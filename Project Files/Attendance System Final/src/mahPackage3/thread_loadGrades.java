/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackage3;

import java.awt.Dialog;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

/**
 *
 * @author Phil Rey Paderogao
 */
public class thread_loadGrades extends SwingWorker<String, Object>{
    long threadDelay = 100;
    long pauseDelay = 500;
    myFunctions my;
    //Dialog Properties
    private JDialog dialog;
    private JFrame jFrameName;
    private JPanel dialogPanel;
    private JLabel lbLoadingMessage;
    private JProgressBar progressBar;
    
    //Main Variables
    private JTable studentsTable;
    private JTable gradesTable;
    
    private String sectionId;
    private String studentId;
    private String subjectsContained;
    
    private JTextField tfGeneralAverage;
    
    private JRadioButton rbPromoted;
    private JRadioButton rbConditional;
    private JRadioButton rbFailed;
    private JRadioButton rbIncomplete;
    
    public thread_loadGrades(JTable [] tablesToUse,String [] stringsToUse,JTextField [] textFieldsToUse,JButton [] buttonsToUse,JRadioButton [] radioButtonsToUse) {
        my = new myFunctions(true);
        studentsTable = tablesToUse[0];
        gradesTable = tablesToUse[1];
        
        sectionId = stringsToUse[0];
        studentId = stringsToUse[1];
        subjectsContained = stringsToUse[2].substring(0,stringsToUse[2].length()-1);
        
        tfGeneralAverage = textFieldsToUse[0];
        
        rbPromoted = radioButtonsToUse[0];
        rbConditional = radioButtonsToUse[1];
        rbFailed = radioButtonsToUse[2];
        rbIncomplete = radioButtonsToUse[3];
        //For Loading Screen
        jFrameName = myVariables.getCurrentLoadingFrame();
        dialogPanel = myVariables.getLoadingPanel();
        lbLoadingMessage = myVariables.getLbLoadingMessage();
        progressBar = myVariables.getProgressBar();
    }

    @Override
    protected String doInBackground() throws Exception {
        try {
            showCustomDialog("Loading", dialogPanel, false, 420, 220, false);
            lbLoadingMessage.setText("Connecting to Database...");
            String subjectIds = subjectsContained.replace(":", ",");
            String where = "WHERE sectionId='"+sectionId+"' AND studentId='"+studentId+"' AND subjectId IN("+subjectIds+") ORDER BY FIELD(subjectID,"+subjectIds+")";
            System.err.println(where);
            String result [] = my.return_values("*", "v_grades", where, myVariables.getGradesViewOrder());
            my.clear_table_rows(gradesTable);
            if(result != null){
                //Load Grades
                int subjectCount = result.length;
                progressBar.setValue(0);
                progressBar.setMaximum(subjectCount);
                
                for(int n=0;n<result.length;n++){
                    lbLoadingMessage.setText("Loading Subject "+(n+1)+" of "+subjectCount);
                    progressBar.setValue(n+1);
                    
                    System.err.println(my.getValueAtColumn(result[n], 13));
                    String statuses [] = my.getValueAtColumn(result[n], 13).split(":");
                    String remarks = statuses[4];
                    
                    
                    result[n] = my.setValueAtColumn(result[n], 13, remarks);
                    result[n] = my.toNameFormat(result[n], new int [] {4,5,6});
                    my.add_table_row(result[n], gradesTable);
                    Thread.sleep(threadDelay);
                }
            }
            
            Thread.sleep(pauseDelay);
        } catch (InterruptedException e) {
            throw new InterruptedException("Interrupted By User.");
        } catch (NullPointerException x){
            x.printStackTrace();
            return "Error FOund: "+x.getMessage();
        }
        
        return "Completed Successfully";
    }

    @Override
    protected void done() {
        closeCustomDialog();
        try {
            System.err.println("Load grades finished: "+get());
        } catch (Exception e) {
        }
        super.done(); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void showCustomDialog(String title, JPanel customPanel, boolean isModal, int width, int height, boolean isResizable){
        if(dialog != null && dialog.isVisible()){
            dialog.setSize(width, height);
            dialog.setTitle(title);
            dialog.add(customPanel);
            dialog.setLocationRelativeTo(jFrameName);
            System.err.println("Sf4 Dialog is already visible. Skipping...");
            return;
        }
        dialog = new JDialog(jFrameName);
        dialog.setTitle(title);
        dialog.add(customPanel);
        dialog.setModal(isModal);
        dialog.setModalityType(Dialog.ModalityType.MODELESS);
        dialog.setSize(width, height);
        dialog.setResizable(isResizable);
        dialog.setUndecorated(true);
        
        dialog.setLocationRelativeTo(jFrameName);
        dialog.setVisible(true);
    }
    private void closeCustomDialog(){
        if(dialog != null){
            dialog.dispose();
        }else{
            System.err.println("Dialog is null...skipping");
        }
    }
}

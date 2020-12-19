/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackage7;

import java.awt.Dialog;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

/**
 *
 * @author Phil Rey Paderogao
 */
public class thread_loadSf10EnrolledSections extends SwingWorker<String, Object>{
    //Main Variables
    JTable sf10Table;
    String studentId;
    JButton btnUseSelectedSections;
    
    //Functions Variables
    long threadDelay = 100;
    long pauseDelay = 500;
    private myFunctions my;
    //Dialog Properties
    private JDialog dialog;
    private JFrame jFrameName;
    private JPanel dialogPanel;
    private JLabel lbLoadingMessage;
    private JProgressBar progressBar;

    public thread_loadSf10EnrolledSections(JTable [] tablesToUse,String [] stringsToUse,JTextField [] textFieldsToUse,JButton [] buttonsToUse,boolean [] booleansToUse) {
        //Main Variables
        sf10Table = tablesToUse[0];
        studentId = stringsToUse[0];
        btnUseSelectedSections = buttonsToUse[0];
        //For Loading Screen & Functions
        
        my = new myFunctions(true);
        
        jFrameName = myVariables.getCurrentLoadingFrame();
        dialogPanel = myVariables.getLoadingPanel();
        lbLoadingMessage = myVariables.getLbLoadingMessage();
        progressBar = myVariables.getProgressBar();
    }
    
    @Override
    protected String doInBackground() throws Exception {
        btnUseSelectedSections.setEnabled(false);
        showCustomDialog("Loading Enrolled Sections...", dialogPanel, false, 420, 220, true);
        progressBar.setMaximum(1);
        progressBar.setValue(0);
        
        lbLoadingMessage.setText("Connecting to Database...");
        
        String where = "WHERE studentId='"+studentId+"'";
        String [] result = my.return_values("*", "form_sf10_view", where, myVariables.getJhsf10Order());
        
        progressBar.setValue(1);
        Thread.sleep(pauseDelay);
        
        my.clear_table_rows(sf10Table);
        if(result != null){
            int studCount = result.length;
            progressBar.setMaximum(studCount);
            
            for (int n = 0; n < studCount; n++) {
                lbLoadingMessage.setText("Loading Sections... "+(n+1)+" of "+studCount);
                progressBar.setValue(n+1);
                
                
                result[n] = my.toNameFormat(result[n], new int [] {10,11,12});
                result[n] = my.toNameFormat(result[n], new int [] {3,4,5});
                
                //Show Remarks?
                
                my.add_table_row(result[n], sf10Table);
                Thread.sleep(threadDelay);
            }
            Thread.sleep(pauseDelay);
            btnUseSelectedSections.setEnabled(true);
        }else{
            my.showMessage("This Student has no Records being enrolled yet.", JOptionPane.ERROR_MESSAGE);
        }
        return "Task Complete";
    }

    @Override
    protected void done() {
        closeCustomDialog();
        super.done(); //To change body of generated methods, choose Tools | Templates.
    }
    //Custom Functions
    
    //Dialog Functions
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

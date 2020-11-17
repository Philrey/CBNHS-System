/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackage7;

import java.awt.Color;
import java.awt.Dialog;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Phil Rey Paderogao
 */
public class thread_loadSf4Details extends SwingWorker<String, Object>{
    long threadDelay = 100;
    long pauseDelay = 500;
    
    private myFunctions my;
    
    //Dialog Properties
    private JDialog dialog;
    private JFrame jFrameName;
    private JPanel dialogPanel;
    private JLabel lbLoadingMessage;
    private JProgressBar progressBar;
    
    //<editor-fold desc="SF2 Variables">
    private JTable [] tablesToUse;
    private String [] stringsToUse;
    private JTextField [] textFieldsToUse;
    private JButton [] buttonsToUse;
    private boolean [] waitForThreadsToFinish;
    
    private JTextField tfSectionName;
    private JTextField tfAdviserName;
    private JTextField tfGradeLevel;
    private JTextField tfSchoolYear;
    //Sf4 Variables (Optional)
    private boolean waitForSecondThreadToFinish;
    
    private JTable sf4Table;
    private JTable sectionsTable;
    private boolean allSectionSelected;
    
    private String sectionId,sectionName,adviserName,gradeLevel;
    //</editor-fold>

    public thread_loadSf4Details(JTable [] tablesToUse,String [] stringsToUse,JTextField [] textFieldsToUse,JButton [] buttonsToUse,boolean [] waitForThreadsToFinish) {
        //For Sf2
        this.tablesToUse = tablesToUse;
        this.stringsToUse = stringsToUse;
        this.textFieldsToUse = textFieldsToUse;
        this.buttonsToUse = buttonsToUse;
        this.waitForThreadsToFinish = waitForThreadsToFinish;
        
        tfSectionName = textFieldsToUse[1];
        tfAdviserName = textFieldsToUse[2];
        tfGradeLevel = textFieldsToUse[3];
        tfSchoolYear = textFieldsToUse[4];
        //For Loading Screen
        jFrameName = myVariables.getCurrentLoadingFrame();
        dialogPanel = myVariables.getLoadingPanel();
        lbLoadingMessage = myVariables.getLbLoadingMessage();
        progressBar = myVariables.getProgressBar();
        //For SF4
        my = new myFunctions(true);
        allSectionSelected = myVariables.isSelectAllSectionsForSf4();
        sf4Table = tablesToUse[3];
        sectionsTable = tablesToUse[4];
        waitForSecondThreadToFinish = waitForThreadsToFinish[2];
    }

    @Override
    protected String doInBackground(){
        try {
            sf4Table.setEnabled(false);
            int sectionCount = 0;
            int selectedSections [];

            if(allSectionSelected){
                selectedSections = null;
                sectionCount = sectionsTable.getRowCount();
            }else{
                selectedSections = sectionsTable.getSelectedRows();
                sectionCount = selectedSections.length;
            }
            System.err.println("Section Length :"+sectionCount);
            for(int n=0;n<sectionCount;n++){
                //<editor-fold desc="Show Loading Dialog">
                showCustomDialog("Loading Sections...", dialogPanel, false, 320, 220, false,true);
                progressBar.setMaximum(sectionCount);
                progressBar.setValue(n+1);
                lbLoadingMessage.setText("Loading Sections..."+(n+1)+" of "+sectionCount);//</editor-fold>
                //<editor-fold desc="load variables for next threads">
                sectionId = sectionsTable.getValueAt(allSectionSelected? n : selectedSections[n], 1).toString();
                String subjectId = sectionsTable.getValueAt(allSectionSelected? n : selectedSections[n], 6).toString();
                sectionName = sectionsTable.getValueAt(allSectionSelected? n : selectedSections[n], 2).toString();
                adviserName = sectionsTable.getValueAt(allSectionSelected? n : selectedSections[n], 4).toString();
                gradeLevel = sectionsTable.getValueAt(allSectionSelected? n : selectedSections[n], 9).toString();
                int schoolYear = Integer.parseInt(sectionsTable.getValueAt(allSectionSelected? n : selectedSections[n], 10).toString());
                
                //Assign Texfields Values
                tfSectionName.setText(sectionName);
                tfAdviserName.setText(adviserName);
                tfGradeLevel.setText(gradeLevel);
                tfSchoolYear.setText(schoolYear+"-"+String.valueOf(schoolYear+1));                
                //</editor-fold>
                Thread.sleep(pauseDelay);
                my.searchItemThread("", "WHERE sectionId='"+sectionId+"'", tablesToUse[1], 11, new int [] {3,4,5}, true, null,new int[]{7,12,17,22},Color.RED);
                my.runSecondaryThread(1, waitForThreadsToFinish[1], new JTable[]{tablesToUse[0],tablesToUse[1],tablesToUse[2],sf4Table}, new String[]{sectionId,stringsToUse[1],subjectId,stringsToUse[3],stringsToUse[4]}, new JTextField[]{textFieldsToUse[0]}, null);
                //<editor-fold desc="Wait For SF2 to Finish Before moving to the next section">
                if(waitForSecondThreadToFinish){
                    System.err.println("Waiting for SecondThread to Finish first...");
                    while (true) {                
                        if(myFunctions.getSecondThread() == null){
                            break;
                        }else{
                            if(!myFunctions.getSecondThread().isAlive()){
                                break;
                            }
                        }
                    }
                }
                showCustomDialog("Loading Sections...", dialogPanel, false, 320, 220, false,false);
                //</editor-fold>
            }
        } catch (Exception e) {
            System.err.println("Error Occured at loadSf4Details");
            //e.printStackTrace();
            return "Failed";
        }
        
        
        
        
        
        return "Success";
    }

    @Override
    protected void done() {
        sf4Table.setEnabled(true);
        closeCustomDialog();
        super.done(); //To change body of generated methods, choose Tools | Templates.
    }
    
    //<editor-fold desc="Custom Functions">
    private void showCustomDialog(String title, JPanel customPanel, boolean isModal, int width, int height, boolean isResizable,boolean isNew){
        if(isNew){
            dialog = new JDialog(jFrameName);
        }
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
    //</editor-fold>
}
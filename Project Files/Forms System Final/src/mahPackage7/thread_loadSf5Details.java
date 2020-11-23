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
public class thread_loadSf5Details extends SwingWorker<String, Object>{
    long threadDelay = 100;
    long pauseDelay = 500;
    
    private myFunctions my;
    //Main Variables
    JTable sf5Table;
    JTable sf5SummaryTable;
    JTable sf5LevelOfProgress;
    JTable sf6Table;
    JTable rankingTable;
    
    String sectionId;
    
    JButton btnLoadStudents;
    JButton btnExport;
    boolean showIncompleteRecords;
    boolean compareToRankings;
    //Dialog Properties
    private JDialog dialog;
    private JFrame jFrameName;
    private JPanel dialogPanel;
    private JLabel lbLoadingMessage;
    private JProgressBar progressBar;

    public thread_loadSf5Details(JTable [] tablesToUse,String [] stringsToUse,JTextField [] textFieldsToUse,JButton [] buttonsToUse,boolean [] booleansToUse) {
        my = new myFunctions(true);
        
        sf5Table = tablesToUse[0];
        sf5SummaryTable = tablesToUse[1];
        sf5LevelOfProgress = tablesToUse[2];
        sf6Table = tablesToUse[3];
        
        sectionId = stringsToUse[0];
        
        btnLoadStudents = buttonsToUse[0];
        btnExport = buttonsToUse[1];
        
        showIncompleteRecords = booleansToUse[0];
        compareToRankings = booleansToUse[1];
        
        //For Loading Screen
        jFrameName = myVariables.getCurrentLoadingFrame();
        dialogPanel = myVariables.getLoadingPanel();
        lbLoadingMessage = myVariables.getLbLoadingMessage();
        progressBar = myVariables.getProgressBar();
    }

    @Override
    protected String doInBackground() throws Exception {
        try {
            btnLoadStudents.setEnabled(false);
            btnExport.setEnabled(false);
            
            showCustomDialog("Loading Grades...", dialogPanel, false, 420, 220, false);
            my.clear_table_rows(sf5Table);
            my.clear_table_rows(sf5SummaryTable);
            my.clear_table_rows(sf5LevelOfProgress);
            if(sf6Table != null){
                my.clear_table_rows(sf6Table);
            }
            if(!loadEmptyCounters()){
                throw new InterruptedException("Interrupted By User");
            }
            
            //Get Students From Database
            lbLoadingMessage.setText("Connecting To Database...");
            String result [] = my.return_values("*", "form_sf5_viewminimal", "WHERE sectionId='"+sectionId+"'", myVariables.getJhsf5MinimalOrder());
            
            if(result==null){
                my.showMessage("This section's students does not have grades submitted yet.", JOptionPane.ERROR_MESSAGE);
                throw new InterruptedException("No students found");
            }
            Thread.sleep(pauseDelay);
            //Load Empty COunters
            //Proces & Count Records
            int studCount = result.length;
            for(int n=0;n<studCount;n++){
                String actionTaken = my.getValueAtColumn(result[n], 11);
                String remarks[] = my.getValueAtColumn(result[n], 9).split("!");
                
                if(actionTaken.contains("Incomplete") && !showIncompleteRecords){
                    continue;   //Skip incomplete record
                }
                if(remarks[0].startsWith("DRP") || remarks[1].startsWith("DRP")){
                    continue;   //Skip Dropped Student
                }
                
                result[n] = my.toNameFormatFull(result[n], new int [] {5,6,7});
                my.add_table_row(result[n], sf5Table);
                Thread.sleep(threadDelay);
            }
            if(!convertGenAverageToWholeNumbers()){
                throw new InterruptedException("Interrupted By User");
            }
            btnExport.setEnabled(true);
            return "Completed Successfully";
        } catch (InterruptedException e) {
            return "Interrupted By User";
        } catch (Exception x){
            x.printStackTrace();
            return "Error Occured";
        }
    }

    @Override
    protected void done() {
        try {
            System.err.println("SF5 Thread ended: "+get());
        } catch (Exception e) {
        }
        closeCustomDialog();
        btnLoadStudents.setEnabled(true);
        
        super.done(); //To change body of generated methods, choose Tools | Templates.
    }
    private boolean convertGenAverageToWholeNumbers(){
        try {
            int studCount = sf5Table.getRowCount();
            progressBar.setMaximum(studCount);
            progressBar.setValue(0);
            for(int n=0;n<studCount;n++){
                lbLoadingMessage.setText("Processing Students..."+(n+1)+" of "+studCount);
                progressBar.setValue(n+1);
                
                float generalAverage = Float.parseFloat(sf5Table.getValueAt(n, 8).toString());
                
                if(compareToRankings){
                    
                }else{
                    sf5Table.setValueAt(String.valueOf((int)generalAverage), n, 8);
                }
            }
            Thread.sleep(pauseDelay);
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }
    private boolean loadEmptyCounters(){
        try {
            lbLoadingMessage.setText("Loading Empty Counters...");
            String summaries [] = {
                "Promoted@@0@@0@@0@@",
                "Conditional@@0@@0@@0@@",
                "Retained@@0@@0@@0@@",
            };
            String levelOfPrgrs [] = {
                "74 Below@@0@@0@@0@@",
                "75 - 79@@0@@0@@0@@",
                "80 - 84@@0@@0@@0@@",
                "85 - 89@@0@@0@@0@@",
                "90 - 100@@0@@0@@0@@"
            };
            for(int n=0;n<summaries.length;n++){
                my.add_table_row(summaries[n], sf5SummaryTable);
            }
            for(int n=0;n<levelOfPrgrs.length;n++){
                my.add_table_row(levelOfPrgrs[n], sf5LevelOfProgress);
            }
            Thread.sleep(pauseDelay);
            return true;
        } catch (Exception e) {
            System.err.println("Interrupted @ loadEmptyCounters");
            return false;
        }
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

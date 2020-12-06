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
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

/**
 *
 * @author Phil Rey Paderogao
 */
public class thread_loadSf8Details extends SwingWorker<String, Object>{
    long threadDelay = 100;
    long pauseDelay = 500;
    
    private myFunctions my;
    //Main Variables
    private JTable sf8Table;
    private JTable summaryTable;
    
    private String sectionId;
    
    private boolean showStudentsWmissingRecords;
    
    private JButton btnLoadStudents;
    private JButton btnExportSf8;
    //Dialog Properties
    private JDialog dialog;
    private JFrame jFrameName;
    private JPanel dialogPanel;
    private JLabel lbLoadingMessage;
    private JProgressBar progressBar;

    public thread_loadSf8Details(JTable [] tablesToUse,String [] stringsToUse,JTextField [] textFieldsToUse,JButton [] buttonsToUse,boolean [] booleansToUse) {
        my = new myFunctions(true);
        
        sf8Table = tablesToUse[0];
        summaryTable = tablesToUse[1];
        
        sectionId = stringsToUse[0];
        
        showStudentsWmissingRecords = booleansToUse[0];
        
        btnLoadStudents = buttonsToUse[0];
        btnExportSf8 = buttonsToUse[1];
        //For Loading Screen
        jFrameName = myVariables.getCurrentLoadingFrame();
        dialogPanel = myVariables.getLoadingPanel();
        lbLoadingMessage = myVariables.getLbLoadingMessage();
        progressBar = myVariables.getProgressBar();
    }
    
    @Override
    protected String doInBackground() throws Exception {
        showCustomDialog("Loading Sf8 Details...", dialogPanel, false, 420, 220, false);
        
        //Load Empty Counters
        my.clear_table_rows(sf8Table);
        if(!loadEmptyCounters()){throw new InterruptedException("Failed @ loadiEmptyCounters");}
        
        //Get Values
        lbLoadingMessage.setText("Connecting to Database...");
        String where = "WHERE sectionId='"+sectionId+"'";
        if(!showStudentsWmissingRecords){
            where+=" AND bmiId!='-1'";
        }
        
        String [] result = my.return_values("*", "form_sf8_view",where , myVariables.getJhsf8Order());
        Thread.sleep(pauseDelay);
        if(result != null){
            //Load Results
            int studCount = result.length;
            progressBar.setMaximum(studCount);
            progressBar.setValue(0);
            for(int n=0;n<studCount;n++){
                lbLoadingMessage.setText("Loading Student "+(n+1)+" of "+studCount);
                progressBar.setValue(n+1);
                
                result[n] = my.toNameFormat(result[n], new int []{3,4,5});
                my.add_table_row(result[n], sf8Table);
                Thread.sleep(threadDelay);
            }
        }else{
            
        }
        return "Finished";
    }

    @Override
    protected void done() {
        closeCustomDialog();
        super.done(); //To change body of generated methods, choose Tools | Templates.
    }
    private boolean loadEmptyCounters(){
        try {
            lbLoadingMessage.setText("Loading Empty Counters...");
            progressBar.setMaximum(1);
            progressBar.setValue(1);
            my.clear_table_rows(summaryTable);
            
            
            Thread.sleep(pauseDelay);
            return true;
        }catch(InterruptedException x){
            return false;
        } catch (Exception e) {
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

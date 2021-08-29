/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackage;

import java.io.File;
import java.io.FilenameFilter;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author pader
 */
public class thread_importSf10 extends SwingWorker<String, Object>{
    long threadDelay = 100;
    long pauseDelay = 500;
    
    //Main Variables
    JTable importTable;
    String fileLocation;
    String startingAddress;
    String endingAddress;
    
    int fileTypeSelected;
    
    JButton btnFileChooser;
    JButton btnCancel;
    JButton btnRegister;
    
    File directorySelected;
    
    //Dialog Properties
    myFunctions my;
    private JLabel lbLoadingMessage;
    private JProgressBar progressBar;
    
    public thread_importSf10(JTable [] tablesToUse,String [] stringsToUse,JTextField [] textFieldsToUse,JButton [] buttonsToUse, File [] directoriesToUse) {
        my = new myFunctions(true);
        //Main Variables
        importTable = tablesToUse[0];
        fileLocation = textFieldsToUse[0].getText();
        fileTypeSelected = Integer.parseInt(stringsToUse[0]);
        
        btnFileChooser = buttonsToUse[0];
        btnCancel = buttonsToUse[1];
        btnRegister = buttonsToUse[2];
        
        directorySelected = directoriesToUse[0];
        //For Loading Screen
        lbLoadingMessage = myVariables.getLbLoadingMessage();
        progressBar = myVariables.getProgressBar();
        //For thead Speed
        long [] threadSpeeds = myVariables.getProcessingSpeedValue();
        threadDelay = threadSpeeds[0];
        pauseDelay = threadSpeeds[1];
    }
    
    @Override
    protected String doInBackground() throws Exception {
        runningThread();
        my.clear_table_rows(importTable);
        
        //#1 Get Files with .xlsx Format
        lbLoadingMessage.setText("Reading Directory for SF10 Files.");
        FilenameFilter filenameFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".xlsx");
            }
        };
        
        File [] filesInsideFolder;
        filesInsideFolder = directorySelected.listFiles(filenameFilter);
        
        if(filesInsideFolder.length <= 0){
            my.showMessage("No Students Found", JOptionPane.WARNING_MESSAGE);
            return "No SF10 Found";
        }
        
        //#2 Read each file inside and put values to import table
        for (File n : filesInsideFolder) {
            //System.err.println("File "+n.getName()+"@@" + n.getPath());
        }
        
        //#3 Check if student id's already exist
        return "Thread Complete";
    }
    
    @Override
    protected void done() {
        closedThread();
        super.done(); //To change body of generated methods, choose Tools | Templates.
    }
    
    //<editor-fold desc="Running Thread Functions">
    private void runningThread(){
        btnFileChooser.setEnabled(false);
        btnCancel.setEnabled(true);
        btnRegister.setEnabled(false);
    }
    private void closedThread(){
        btnFileChooser.setEnabled(true);
        btnCancel.setEnabled(false);
        btnRegister.setEnabled(true);
        //lbLoadingMessage.setText("Process complete...");
    }
    //</editor-fold>
}

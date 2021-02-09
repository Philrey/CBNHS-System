/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackage;

import java.io.File;
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
public class thread_importSf1 extends SwingWorker<String, Object>{
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
    
    
    //Dialog Properties
    myFunctions my;
    private JLabel lbLoadingMessage;
    private JProgressBar progressBar;

    public thread_importSf1(JTable [] tablesToUse,String [] stringsToUse,JTextField [] textFieldsToUse,JButton [] buttonsToUse,boolean [] booleansToUse,File [] filesToUse) {
        my = new myFunctions(true);
        //Main Variables
        importTable = tablesToUse[0];
        fileLocation = textFieldsToUse[0].getText();
        fileTypeSelected = Integer.parseInt(stringsToUse[0]);
        
        btnFileChooser = buttonsToUse[0];
        btnCancel = buttonsToUse[1];
        btnRegister = buttonsToUse[2];
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
        
        //#1 Open Excel File
        my.createExcelFile(fileLocation);
        //#2 Get Headers
        //#3 Determine starting and endpoints
        switch(determineEndingPoints()){
            case -1:{
                throw new InterruptedException("Interrupted @ determiningEndingPoints()");
            }case 0:{
                throw new InterruptedException("Error Occured");
            }case 1:{
                System.out.println("Reading Endpoints Success");
                break;
            }case 2:{
                my.showMessage("No Students were found.\nPlease make sure you selected the correct file type\nor your file has Data inside.", JOptionPane.WARNING_MESSAGE);
                break;
            }
        }
        //#4 Get Data
        lbLoadingMessage.setText("Retrieving Data...");
        String [] result = my.readRegion(
                0,
                columnsToSkip[fileTypeSelected],
                startColumns[fileTypeSelected]+","+startRows[fileTypeSelected],
                endColumns[fileTypeSelected]+","+endingRow
        );
        //System.err.println("Len: "+result.length);
        Thread.sleep(pauseDelay);
        //#5 put values to tables
        try {
            int rowCount = result.length;
            progressBar.setMaximum(rowCount);
            for(int n=0;n<rowCount;n++){
                lbLoadingMessage.setText("Loading Data "+(n+1)+"/"+rowCount);
                progressBar.setValue(n+1);
                System.err.println(result[n]);
                my.add_table_row(result[n], importTable);
                Thread.sleep(threadDelay);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Import Thread Completed";
    }

    @Override
    protected void done() {
        closedThread();
        super.done(); //To change body of generated methods, choose Tools | Templates.
    }
    String startColumns [] = {"A","A","A"};
    String endColumns [] = {"S","S","S"};
    String columnsToSkip [] = {
        null,
        null,
        null
    };
    int startRows [] = {7,7,7};
    int endingRow;
    private int determineEndingPoints(){
        //Returns values -1 = interrupted, 0 = error occured, 1 = successful, 2 = empty
        progressBar.setMaximum(1);
        progressBar.setValue(1);
        lbLoadingMessage.setText("Reading Contents...");
        String value;
        try {
            //Search for LRNs
            for (int n = startRows[fileTypeSelected]; ; n++) {
                try {
                    //Check if value is 12 digits,all numbers
                    value = my.readSingleValue(0, startColumns[fileTypeSelected]+","+n);
                    
                    if(value.length() != 12){
                        endingRow = n;
                        break;
                    }
                    
                    endingRow = n;
                } catch (Exception e) {
                    endingRow = n;
                    break;
                }
                Thread.sleep(threadDelay);
            }
            Thread.sleep(pauseDelay);
            endingRow--;
            System.err.println("Last Row With IDs: "+endingRow);
            
            if(startRows[fileTypeSelected] >= endingRow){   //Nothing was found
                return 2;
            }
            return 1;
            
        }catch (InterruptedException e) {
            return -1;
        }catch(Exception x){
            x.printStackTrace();
            return 0;
        }
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
        lbLoadingMessage.setText("Process complete...");
    }
    //</editor-fold>
}

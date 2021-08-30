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
    
    String headerAddresses [];
    
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
        
        headerAddresses = new String [] {
            "K,8",  //LRN
            
            "E,7",  //Lname
            "O,7",  //Fname
            "AJ,7", //Mname
            "AB,7", //Extention
            
            "AK,8", //Sex
            
            "AB,8", //Month
            "AD,8", //Day
            "AF,8", //Year
            
            "S,12",  //General Ave
            "Y,13",  //School ID
            "J,13",  //Elem School Name
            "AH,13", //Address
        };
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
        progressBar.setMaximum(1);
        progressBar.setValue(0);
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
        progressBar.setValue(1);
        Thread.sleep(pauseDelay);
        //#2 Read each file inside and put values to import table
        //Note: use thread_importSf1 reading process
        progressBar.setValue(0);
        progressBar.setMaximum(filesInsideFolder.length);
        for(int n=0,length=filesInsideFolder.length;n<length;n++){
            //Read File
            lbLoadingMessage.setText("Loading file "+(n+1)+"/"+length);
            progressBar.setValue(n+1);
            my.createExcelFile(filesInsideFolder[n].getPath());
            
            //Get Headers
            String [] result = my.getHeaderValues(headerAddresses);
            
            //Setup Values
            String lrn = result[0];
            String fName = result[2].trim();
            String lName = processExtentionName(result[1], result[4]);
            String mName = checkMiddleName(result[3]);
            
            String line = result[0]+"@@"+
                    my.toNameFormatFull(lName+"@@"+fName+"@@"+mName+"@@", new int [] {0,1,2})
                    +result[5]+"@@"+
                    result[8]+"-"+result[6]+"-"+result[7]+"@@"+
                    result[9]+"@@"+result[10]+"@@"+result[11]+"@@"+result[12]+"@@Ready@@";
            System.err.println("Line " + lrn);
            
            String name = my.capitalizeName(my.getValueAtColumn(line, 1).toLowerCase(),true);
            line = my.setValueAtColumn(line, 1, name);
            //System.err.println("LineA " + line);
            my.add_table_row(line, importTable);
            
            Thread.sleep(threadDelay);
        }
        
        //#3 Validate Values        
        String cValue,msg,fHalf,sHalf;
        boolean isReadyForImport;
        
        progressBar.setValue(0);
        progressBar.setMaximum(importTable.getRowCount());
        for(int n=0,len=importTable.getRowCount();n<len;n++){
            isReadyForImport = true;
            msg = "";
            lbLoadingMessage.setText("Validating Values "+(n+1)+"/"+len);
            progressBar.setValue(n+1);
            
            for(int x=0,xlen=importTable.getColumnCount();x<xlen-1;x++){
                cValue = importTable.getValueAt(n, x).toString();
                if(cValue.trim().length()<=0){
                    msg = "Missing Values";
                    isReadyForImport = false;
                    break;
                }
                
                //Check values depending on column
                switch(x){
                    case 0:{    //LRN
                        try {
                            if(cValue.length() != 12){
                                msg = "Invalid LRN";
                                isReadyForImport = false;
                            }else{
                                fHalf = cValue.substring(0, 6);
                                sHalf = cValue.substring(6, 12);
                                
                                //Note LRN is 12 digits, int limit is 10
                                Integer.parseInt(fHalf);
                                Integer.parseInt(sHalf);
                            }
                        } catch (NumberFormatException e) {
                            e.getMessage();
                            msg = "Invalid LRN";
                            isReadyForImport = false;
                        }
                        break;
                    }case 1:{   //Name                        
                        break;
                    }case 2:{   //Gender
                        if(!cValue.toLowerCase().contains("male") && !cValue.toLowerCase().contains("female")){
                            msg = "Invalid Gender";
                            isReadyForImport = false;
                        }
                        break;
                    }case 3:{   //Bday
                        if(cValue.length() != 8 && cValue.length() != 9 && cValue.length() != 10){
                            msg = "Invalid Date";
                            isReadyForImport = false;
                        }
                        break;
                    }case 4:{   //Grade
                        try {
                            Float.parseFloat(cValue);
                        } catch (NumberFormatException e) {
                            msg = "Invalid Grade";
                            isReadyForImport = false;
                        }
                        break;
                    }case 5:{   //School ID
                        try {
                            Integer.parseInt(cValue);
                        } catch (NumberFormatException e) {
                            msg = "Invalid School ID";
                            isReadyForImport = false;
                        }
                        break;
                    }
                }
                if(!isReadyForImport){break;}
            }
            if(!isReadyForImport){
                importTable.setValueAt(msg, n, 8);
            }
            Thread.sleep(threadDelay);
        }
        
        return "Thread Complete";
    }
    //<editor-fold desc="Functions">
    private String processExtentionName(String lastName,String extention){
        String temp="";
        if(extention.trim().length() > 0){
            temp+=lastName.trim()+","+extention.trim();
        }else{
            temp+=lastName.trim();
        }
        return temp;
    }
    private String checkMiddleName(String middleName){
        return middleName.trim().length()>0? middleName.trim() : "-";
    }
    
    //</editor-fold>
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
        lbLoadingMessage.setText("Process complete...");
    }
    //</editor-fold>
}

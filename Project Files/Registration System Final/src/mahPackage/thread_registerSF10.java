/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackage;

import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import org.apache.commons.validator.GenericValidator;

/**
 *
 * @author pader
 */
public class thread_registerSF10 extends SwingWorker<String, Object>{
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
    
    boolean updateExistingRecords;
    //<editor-fold desc="Load Variables">
    String lrn = "";
    String studentId,personalInfoId;
    String lastName,firstName,middleName,extensionName;
    String gender,birthDay,elementaryGrade,schoolId,schoolName,schoolAddress;
    String status;
    //</editor-fold>
    //Dialog Properties
    myFunctions my;
    private JLabel lbLoadingMessage;
    private JProgressBar progressBar;
    private String dateFormats [] = {"MM/dd/yyyy","MM-dd-yyyy","yyyy-MM-dd"};
    
    public thread_registerSF10(JTable [] tablesToUse,String [] stringsToUse,JTextField [] textFieldsToUse,JButton [] buttonsToUse,boolean [] booleansToUse) {
        my = new myFunctions(true);
        //Main Variables
        importTable = tablesToUse[0];
        fileTypeSelected = Integer.parseInt(stringsToUse[0]);
        
        btnFileChooser = buttonsToUse[0];
        btnCancel = buttonsToUse[1];
        btnRegister = buttonsToUse[2];
        
        updateExistingRecords = booleansToUse[0];
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
        int rowCount = importTable.getRowCount();
        progressBar.setMaximum(rowCount);
        progressBar.setValue(0);
        
        String result [] = null;
        String lastNameNew = null;
        int registered=0,updated=0,failed=0;
        boolean duplicateFound;
        
        for (int n = 0; n < rowCount; n++) {
            lbLoadingMessage.setText("Importing..."+(n+1)+"/"+rowCount);
            progressBar.setValue(n+1);
            lrn = importTable.getValueAt(n, 0).toString();
            status = importTable.getValueAt(n, 8).toString();
            
            if(!status.contains("Ready")){
                continue;
            }
            switch(setValues(n)){
                case -1:{
                    throw new InterruptedException("Interrupted @ setValues()");
                }case 0:{
                    break;
                }case 1:{
                    continue;
                }default:{break;}
            }
            
            //<editor-fold desc="#1 Check for duplicate LRNs">
            setStatus(n, "Checking for Duplicates");
            duplicateFound = my.checkForDuplicates("v_students_jhs", "WHERE lrn='"+lrn+"'", myVariables.getStudentsOrder());
            Thread.sleep(threadDelay);
            //</editor-fold>
            
            //<editor-fold desc="#2 Register To Students Table">
            setStatus(n, "Saving Student");
            if(duplicateFound){
                if(!updateExistingRecords){ //Skip existing records if checkbox is disabled
                    setStatus(n, "Duplicate Found");
                    continue;
                }
                
                //Get student id & Update Only
                result = my.return_values("id", "v_students_jhs", "WHERE lrn='"+lrn+"'", new int[]{0}, myVariables.isDebugModeOn());
                if(result == null){
                    setStatus(n, "Student not Found");
                    failed++;
                    continue;
                }
                studentId = my.getValueAtColumn(result[0], 0);
                
                lastNameNew = extensionName.trim().length()>0? lastName+","+extensionName:lastName;
                String sets [] = {
                    "lName='"+lastNameNew+"'",
                    "fName='"+firstName+"'",
                    "mName='"+middleName+"'",
                    "sex='"+gender+"'",
                    "inGr='"+elementaryGrade+"'",
                    "schoolId='"+schoolId+"'",
                    "schoolName='"+schoolName+"'",
                    "schoolAddress='"+schoolAddress+"'",
                };
                if(!my.update_values("students", sets, "id='"+studentId+"'")){
                    setStatus(n, "Updating Student Failed");
                    failed++;
                    continue;
                }
            }else{
                //Create new entry
                lastNameNew = extensionName.trim().length()>0? lastName+","+extensionName:lastName;
                String studentValues [] = {"null",lrn,lastNameNew,firstName,middleName,gender,elementaryGrade,schoolId,schoolName,schoolAddress};
                System.err.println(Arrays.toString(studentValues));
                if(!my.add_values("students", "id,lrn,lName,fName,mName,sex,inGr,schoolId,schoolName,schoolAddress", studentValues)){
                    setStatus(n, "Saving Student Failed");
                    failed++;
                    continue;
                }
            }
            Thread.sleep(threadDelay);
            //</editor-fold>
            
            //<editor-fold desc="#3 Register To Student's Personal Info Table">
            setStatus(n, "Saving Personal Information");
            String sets [];
            //Add or Update Personal Info
            String columns = "id,stdId,bDate,date";
            if (duplicateFound) {
                if(!updateExistingRecords){ //Skip existing records if checkbox is disabled
                    setStatus(n, "Duplicate Found");
                    continue;
                }
                
                String setVariables = "bDate=VALUES(bDate),date=VALUES(date)";
                //Get student id & Update Only
                result = my.return_values("id", "personalinfo", "WHERE stdId='"+studentId+"'", new int[]{0}, myVariables.isDebugModeOn());
                if(result == null){
                    setStatus(n, "Student not Found");
                    failed++;
                    continue;
                }
                personalInfoId = my.getValueAtColumn(result[0], 0);
                
                sets = new String []{
                    personalInfoId+","+studentId+",'"+birthDay+
                        "',now()"
                };
                
                if(!my.update_multiple_values("personalinfo",columns,setVariables,sets)){
                    setStatus(n,"Updating Personal Info Failed");
                    failed++;
                    continue;
                }
                updated++;
            }else{
                //Get student id of new registered student
                result = my.return_values("id", "v_students_jhs", "WHERE lrn='"+lrn+"'", new int[]{0}, myVariables.isDebugModeOn());
                if(result == null){
                    setStatus(n, "Student not Found");
                    failed++;
                    continue;
                }
                studentId = my.getValueAtColumn(result[0], 0);
                
                sets = new String []{
                    "null,"+studentId+",'"+birthDay+"',now()"
                };
                if(!my.add_multiple_values("personalinfo", columns, sets)){
                    setStatus(n, "Adding Personal Info Failed");
                    failed++;
                    continue;
                }
                registered++;
            }
            //</editor-fold>
            
            Thread.sleep(threadDelay);
            //#4 Set Status
            if(duplicateFound){
                setStatus(n, "Updated Registration");
            }else{
                setStatus(n, "Registered");
            }
            Thread.sleep(threadDelay);
        }
        
        return "register SF10 Thread Complete";
    }

    @Override
    protected void done() {
        closedThread();
        super.done();
    }
    
    //<editor-fold desc="Other Functions">
    private int setValues(int rowIndex){
        // -1 = interrupted, 0 = success, 1 = missing important values
        
        setStatus(rowIndex, "Processing");
        try {
            //Process Name
            String [] tempName = importTable.getValueAt(rowIndex, 1).toString().split(",");
            switch(tempName.length){
                case 0:{
                    setStatus(rowIndex, "No Name Found");
                    return 1;
                }case 1:{
                    setStatus(rowIndex, "Incomplete Name");
                    return 1;
                }case 2:{
                    lastName = tempName[0];
                    firstName = tempName[1];
                    middleName = " ";
                    extensionName = " ";
                    break;
                }case 3:{
                    lastName = tempName[0];
                    firstName = tempName[1];
                    middleName = tempName[2];
                    
                    extensionName = " ";
                    break;
                }case 4:{
                    lastName = tempName[0];
                    firstName = tempName[1];
                    switch(fileTypeSelected){
                        case 0:{
                            middleName = tempName[2];
                            extensionName = tempName[3];
                            break;
                        }case 1:{
                            middleName = tempName[3];
                            extensionName = tempName[2];
                            break;
                        }
                    }
                    break;
                }
            }
            gender = importTable.getValueAt(rowIndex, 2).toString().contains("F")? "Female" : "Male";
            birthDay = importTable.getValueAt(rowIndex, 3).toString();
            elementaryGrade = importTable.getValueAt(rowIndex, 4).toString();
            schoolId = importTable.getValueAt(rowIndex, 5).toString();
            schoolName = importTable.getValueAt(rowIndex, 6).toString();
            schoolAddress = importTable.getValueAt(rowIndex, 7).toString();
            
            if(!checkBirthDate(birthDay)){
                setStatus(rowIndex, "Invalid Birthday");
                return 1;
            }
            //birthDay = my.changeDateFormat(birthDay, dateFormats[fileTypeSelected], "yyyy-MM-dd");
            //birthPlace = importTable.getValueAt(rowIndex, 5).toString();
            Thread.sleep(threadDelay);
            
            return 0;
        } catch (InterruptedException e) {
            return -1;
        }
    }
    private boolean checkBirthDate(String date){
        //System.err.println("Bdate: "+date);
        return GenericValidator.isDate(date, dateFormats[fileTypeSelected], true);
    }
    private void setStatus(int rowIndex,String message){
        importTable.setValueAt(message, rowIndex, 8); //Status Column index 8, column 9
    }
    //</editor-fold>
    
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

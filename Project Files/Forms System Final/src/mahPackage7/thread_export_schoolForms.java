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
public class thread_export_schoolForms extends SwingWorker<Object, Object>{
    //Main Variables
    private header[] headers;
        //SF1
        private JTable sf1Table;
        private String maleCount;
        private String femaleCount;
        private String totalCount;
        //SF2
        private JTable sf2WeekdaysTable;
        private JTable sf2Table;
        private JTable sf2SummaryTable;
        private String sf2MonthSelected;
        private String sf2SchoolDays;
    //Global Variables
    private String sectionName;
    private String adviserName;
    private String gradeLevel;
    private String schoolYear;
    private JButton btnExport;
    
    private String schoolId;
    private String region;
    private String division;
    private String district;
    private String schoolName;
    //Functions Variables
    long threadDelay = 100;
    long pauseDelay = 500;
    private final myFunctions my;
    //Dialog Properties
    private JDialog dialog;
    private final JFrame jFrameName;
    private final JPanel dialogPanel;
    private final JLabel lbLoadingMessage;
    private final JProgressBar progressBar;

    public thread_export_schoolForms(JTable [] tablesToUse,String [] stringsToUse,JTextField [] textFieldsToUse,JButton [] buttonsToUse,boolean [] booleansToUse) {
        //For Loading Screen & Functions
        my = new myFunctions(true);
        
        jFrameName = myVariables.getCurrentLoadingFrame();
        dialogPanel = myVariables.getLoadingPanel();
        lbLoadingMessage = myVariables.getLbLoadingMessage();
        progressBar = myVariables.getProgressBar();
        
        //Main Variables
        btnExport = buttonsToUse[0];
        
        schoolId = myVariables.getSchoolId();
        region = myVariables.getRegion();
        division = myVariables.getDivision();
        district = myVariables.getDistrict();
        schoolName = myVariables.getSchoolName();
        
        assignTablesByForm(tablesToUse,stringsToUse,textFieldsToUse);
    }
    //<editor-fold desc="Constructor Functions">
    private void assignTablesByForm(JTable [] tables,String [] stringsToUse,JTextField [] textFieldsToUse){
        switch(myVariables.getFormSelected()){
            case 1:{
                //Global Variables
                sectionName = my.getSectionNameOnly(textFieldsToUse[0].getText(), true);
                adviserName = textFieldsToUse[1].getText().toUpperCase();
                gradeLevel = textFieldsToUse[2].getText();
                schoolYear = textFieldsToUse[3].getText();
                //SF1 Variables
                sf1Table = tables[0];
                maleCount = textFieldsToUse[4].getText();
                femaleCount = textFieldsToUse[5].getText();
                totalCount = textFieldsToUse[6].getText();
                break;
            }case 2:{
                //Global Variables
                sectionName = my.getSectionNameOnly(textFieldsToUse[0].getText(), true);
                adviserName = textFieldsToUse[1].getText().toUpperCase();
                gradeLevel = textFieldsToUse[2].getText();
                schoolYear = textFieldsToUse[3].getText();
                //SF2 Variables
                sf2WeekdaysTable = tables[0];
                sf2Table = tables[1];
                sf2SummaryTable = tables[2];
                sf2MonthSelected = stringsToUse[0].toUpperCase();
                sf2SchoolDays = textFieldsToUse[4].getText();
                break;
            }case 3:{
                break;
            }case 4:{
                break;
            }case 5:{
                break;
            }case 6:{
                break;
            }case 7:{
                break;
            }case 8:{
                break;
            }case 9:{
                break;
            }case 10:{
                break;
            }default:{
                System.err.println("No Form Selected");
                break;
            }
        }
    }
    //</editor-fold>
    
    @Override
    protected Object doInBackground() throws Exception {
        btnExport.setEnabled(false);
        
        showCustomDialog("Exporting to Excel File", dialogPanel, false, 420, 220, false);
        lbLoadingMessage.setText("Creating File...1/5");
        progressBar.setMaximum(5);
        progressBar.setValue(0);
        
        //#1 Create File & Determine which sheet to use
        if(!my.createExcelFile(getFileName(true))){
            my.showMessage("There was an error Creating the file.\nPlease Make Sure the template exists inside the Templates folder.", JOptionPane.ERROR_MESSAGE);
            throw new InterruptedException("Reading Failed");
        }
        int sheetNumber = getSheetNumberToUse();
        progressBar.setValue(1);
        Thread.sleep(pauseDelay);
        
        //#2 Write Headers
        lbLoadingMessage.setText("Writing Headers...2/5");
        progressBar.setValue(2);
        if(!loadHeaders(sheetNumber)){throw new InterruptedException("Loading Headers Failed...");}
        if(!writeHeaders(sheetNumber)){throw new InterruptedException("Writing Headers Failed...");}
        
        //#3 Write Tables
        lbLoadingMessage.setText("Writing Tables...3/5");
        progressBar.setValue(3);
        if(!writeTables(sheetNumber)){throw new InterruptedException("Writing Tables Failed...");}
        Thread.sleep(pauseDelay);
        
        //#4 Remove Extra Sheets
        lbLoadingMessage.setText("Removing Extra Sheets...4/5");
        my.keepOneSheetOnly(sheetNumber);
        progressBar.setValue(4);
        Thread.sleep(pauseDelay);
        
        //#5 Save File
        lbLoadingMessage.setText("Saving File...5/5");
        if(!my.saveExcelFile(getFileName(false))){
            my.showMessage("There was an error Exporting the file.\nPlease make sure the file you are saving at is not open and try again.", JOptionPane.ERROR_MESSAGE);
            throw new InterruptedException("Save Failed");
        }
        progressBar.setValue(5);
        Thread.sleep(pauseDelay);
        
        closeCustomDialog();
        btnExport.setEnabled(true);
        return "Task Complete";
    }

    @Override
    protected void done() {
        closeCustomDialog();
        super.done(); //To change body of generated methods, choose Tools | Templates.
    }
    //<editor-fold desc="Custom Functions">
    private int getSheetNumberToUse(){
        int sheetIndex = 0;
        int dataCount = 0;
        switch(myVariables.getFormSelected()){
            case 1:{
                dataCount = sf1Table.getRowCount();break;
            }case 2:{
                dataCount = sf2Table.getRowCount()-3;break;
            }case 3:{
                dataCount = sf2Table.getRowCount()-3;break;
            }case 4:{
                dataCount = sf2Table.getRowCount()-3;break;
            }case 5:{
                dataCount = sf2Table.getRowCount()-3;break;
            }case 7:{
                dataCount = sf2Table.getRowCount()-3;break;
            }case 8:{
                dataCount = sf2Table.getRowCount()-3;break;
            }default:{
                break;
            }
        }
        
        if(dataCount <= 10){
            sheetIndex = 0;
        }if(dataCount > 10 && dataCount <= 20){
            sheetIndex = 1;
        }if(dataCount > 20 && dataCount <= 30){
            sheetIndex = 2;
        }if(dataCount > 30 && dataCount <= 40){
            sheetIndex = 3;
        }if(dataCount > 40 && dataCount <= 50){
            sheetIndex = 4;
        }if(dataCount > 50 && dataCount <= 60){
            sheetIndex = 5;
        }if(dataCount > 60 && dataCount <= 70){
            sheetIndex = 6;
        }
        return sheetIndex;
    }
    private boolean writeTables(int sheetNumber){
        String startingAddress,startingAddress2,startingAddress3;
        String excelColumnsToSkip;
        try {
            switch(myVariables.getFormSelected()){
                case 1:{
                    int rowCount = sf1Table.getRowCount();
                    startingAddress = "A,"; //A,7 first row
                    excelColumnsToSkip = null;
                    
                    for (int n = 0; n < rowCount; n++) {
                        lbLoadingMessage.setText("Writing Tables...3/4 Line "+(n+1)+" of "+rowCount);
                        
                        String line = my.get_table_row_values(n, sf1Table);
                        //Single Letter Gender
                        String gender = my.getValueAtColumn(line, 5).substring(0, 1);
                        line = my.setValueAtColumn(line, 5, gender);
                        //Remove Unnecessary Columns
                        line = my.skipColumns(line, new int [] {0,1,2});
                        //Write to excel file
                        my.writeExcelLine(sheetNumber, line, excelColumnsToSkip, startingAddress+(n+7));
                        
                        Thread.sleep(threadDelay);
                    }
                    break;
                }case 2:{
                    break;
                }case 3:{
                    break;
                }case 4:{
                    break;
                }case 5:{
                    break;
                }case 6:{
                    break;
                }case 7:{
                    break;
                }case 8:{
                    break;
                }case 9:{
                    break;
                }case 10:{
                    break;
                }default:{
                    
                }
            }
            
            Thread.sleep(pauseDelay);
            return true;
        }catch(InterruptedException x){
            return false;
        } catch (Exception e) {
            return true;
        }
    }
    private boolean writeHeaders(int sheetNumber){
        try {
            int headerCount = headers.length;
            
            for (int n = 0; n < headerCount; n++) {
                lbLoadingMessage.setText("Writing Headers...2/4 Header "+(n+1)+" of "+headerCount);
                my.writeExcelSingleData(sheetNumber, headers[n].getData(), headers[n].getExcelAddress());
                Thread.sleep(threadDelay);
            }
            Thread.sleep(pauseDelay);
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }
    private boolean loadHeaders(int sheetNumber){
        try {
            switch(myVariables.getFormSelected()){
                case 1:{
                    String mCount [] = new String [] {"M,20","M,30","M,40","M,50","M,60","M,70","M,80"};
                    String fCount [] = new String [] {"M,21","M,31","M,41","M,51","M,61","M,71","M,81"};
                    String tCount [] = new String [] {"M,22","M,32","M,42","M,52","M,62","M,72","M,82"};
                    String advName []= new String [] {"O,20","O,30","O,40","O,50","O,60","O,70","O,80"};
                    
                    headers = new header[]{
                        //Header Parts
                        new header(schoolId, "C,3"),
                        new header(region, "G,3"),
                        new header(division, "L,3"),
                        new header(district, "Q,3"),
                        new header(schoolName, "C,4"),
                        new header(schoolYear, "L,4"),
                        new header(gradeLevel, "N,4"),
                        new header(sectionName, "P,4"),
                        //Form's Custom Fields
                        new header(maleCount, mCount[sheetNumber]),
                        new header(femaleCount, fCount[sheetNumber]),
                        new header(totalCount, tCount[sheetNumber]),
                        new header(adviserName, advName[sheetNumber]),
                    };
                    break;
                }case 2:{
                    //Set Addresses by sheetIndex
                    String monthSelected [] = new String [] {
                        "T,22","T,32","T,42","T,52","T,62","T,72","T,82"};
                    String schoolDays [] = new String [] {
                        "W,22","W,32","W,42","W,52","W,62","W,72","W,82"};
                    String advName [] = new String [] {
                        "U,45","U,55","U,65","U,75","U,85","U,95","U,105"};
                    
                    headers = new header[]{
                        //Header Parts
                        new header(schoolId, "C,3"),
                        new header(sf2MonthSelected, "R,3"),
                        new header(schoolName, "C,4"),
                        new header(schoolYear, "I,3"),
                        new header(gradeLevel, "R,4"),
                        new header(sectionName, "AB,4"),
                        //Form's Custom Fields
                        new header(sf2MonthSelected, monthSelected[sheetNumber]),
                        new header(sf2SchoolDays, schoolDays[sheetNumber]),
                        new header(adviserName, advName[sheetNumber]),
                    };
                    break;
                }case 3:{
                    break;
                }case 4:{
                    break;
                }case 5:{
                    break;
                }case 6:{
                    break;
                }case 7:{
                    break;
                }case 8:{
                    break;
                }case 9:{
                    break;
                }case 10:{
                    break;
                }
            }
            
            Thread.sleep(pauseDelay);
            return true;
        }catch(InterruptedException x){
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
    private String getFileName(boolean importExport){
        String fileName = "";
        switch(myVariables.getFormSelected()){
            case 1:{
                fileName = importExport? "templates/jh_sf1.xlsx" : "exports/jh_sf1.xlsx";break;
            }case 2:{
                fileName = importExport? "templates/jh_sf2.xlsx" : "exports/jh_sf2.xlsx";break;
            }case 3:{
                fileName = importExport? "templates/jh_sf3.xlsx" : "exports/jh_sf3.xlsx";break;
            }case 4:{
                fileName = importExport? "templates/jh_sf4.xlsx" : "exports/jh_sf4.xlsx";break;
            }case 5:{
                fileName = importExport? "templates/jh_sf5.xlsx" : "exports/jh_sf5.xlsx";break;
            }case 6:{
                fileName = importExport? "templates/jh_sf6.xlsx" : "exports/jh_sf6.xlsx";break;
            }case 7:{
                fileName = importExport? "templates/jh_sf7.xlsx" : "exports/jh_sf7.xlsx";break;
            }case 8:{
                fileName = importExport? "templates/jh_sf8.xlsx" : "exports/jh_sf8.xlsx";break;
            }case 9:{
                fileName = importExport? "templates/jh_sf9.xlsx" : "exports/jh_sf9.xlsx";break;
            }case 10:{
                fileName = importExport? "templates/jh_sf10.xlsx" : "exports/jh_sf10.xlsx";break;
            }
        }
        
        return fileName;
    }
    //</editor-fold>
    //<editor-fold desc="Extra Classes">
    private class header{
        private String data;
        private String excelAddress;

        public header(String data, String excelAddress) {
            this.data = data;
            this.excelAddress = excelAddress;
        }

        public String getData() {
            return data;
        }
        
        public String getExcelAddress() {
            return excelAddress;
        }
    }
    //</editor-fold>
    //<editor-fold desc="Dialog Functions">
    private void showCustomDialog(String title, JPanel customPanel, boolean isModal, int width, int height, boolean isResizable){
        if(dialog != null && dialog.isVisible()){
            dialog.setSize(width, height);
            dialog.setTitle(title);
            dialog.add(customPanel);
            dialog.setModal(isModal);
            if(isModal){
                dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            }else{
                dialog.setModalityType(Dialog.ModalityType.MODELESS);
            }
            dialog.setLocationRelativeTo(jFrameName);
            System.err.println("Sf4 Dialog is already visible. Skipping...");
            return;
        }
        dialog = new JDialog(jFrameName);
        dialog.setTitle(title);
        dialog.add(customPanel);
        dialog.setModal(isModal);
        if(isModal){
            dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        }else{
            dialog.setModalityType(Dialog.ModalityType.MODELESS);
        }
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

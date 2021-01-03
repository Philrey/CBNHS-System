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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import org.apache.poi.ss.usermodel.BorderStyle;

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
        //SF3
        private JTable sf3Table;
        private JTable sf3BooksTable;
        //SF4
        private String sf4MonthSelected;
        private JTable sf4Table;
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
                //Global Variables
                sectionName = my.getSectionNameOnly(textFieldsToUse[0].getText(), true);
                adviserName = textFieldsToUse[1].getText().toUpperCase();
                gradeLevel = textFieldsToUse[2].getText();
                schoolYear = textFieldsToUse[3].getText();
                //SF3 Variables
                sf3Table = tables[0];
                sf3BooksTable = tables[1];
                break;
            }case 4:{
                //Global Variables
                schoolYear = textFieldsToUse[0].getText();
                //SF4 Variables
                sf4Table = tables[0];
                sf4MonthSelected = stringsToUse[0].toUpperCase();
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
                dataCount = sf3Table.getRowCount()-3;break;
            }case 4:{
                dataCount = sf4Table.getRowCount();break;
            }case 5:{
                //dataCount = sf2Table.getRowCount()-3;break;
            }case 7:{
                //dataCount = sf2Table.getRowCount()-3;break;
            }case 8:{
                //dataCount = sf2Table.getRowCount()-3;break;
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
                    //<editor-fold desc="WRITE SF1">
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
                    //</editor-fold>
                    break;
                }case 2:{
                    //<editor-fold desc="WRITE SF2">
                    
                    //Write Dates
                    lbLoadingMessage.setText("Writing Tables...3/4 Writing Dates");
                    String days = my.get_table_row_values(0, sf2WeekdaysTable);
                    days = my.skipColumns(days, new int [] {0,1,2,3,4,5,6,32,33});
                    my.writeExcelLine(sheetNumber, days, null, "C,6");
                    Thread.sleep(threadDelay);
                    
                    //Prepare blank days for writing
                    lbLoadingMessage.setText("Writing Tables...3/4 Loading Blank Dates");
                    String blankDays = "";
                    for (int n = 0; n < 25; n++) {
                        blankDays+=" @@";
                    }
                    Thread.sleep(threadDelay);
                    
                    //<editor-fold desc="Extract Counters">
                    lbLoadingMessage.setText("Writing Tables...3/4 Extracting Counters");
                    int rowCount = sf2Table.getRowCount()-3; //Exlude Counters From the bottom
                    String mCount = my.get_table_row_values(rowCount, sf2Table);
                    String fCount = my.get_table_row_values(rowCount+1, sf2Table);
                    String tCount = my.get_table_row_values(rowCount+2, sf2Table);
                    
                    mCount = " @@"+my.skipColumns(mCount, new int [] {0,1,2,4,5,6});
                    fCount = " @@"+my.skipColumns(fCount, new int [] {0,1,2,4,5,6});
                    tCount = " @@"+my.skipColumns(tCount, new int [] {0,1,2,4,5,6});
                    Thread.sleep(threadDelay);
                    //</editor-fold>
                    
                    //Write Sf2 Table
                    String remarks,gender,studentName,absent,tardy,attendanceValue;
                    startingAddress = "A,";
                    boolean firstFemaleFound = false;
                    int row = 0;
                    for (int n = 0; n < rowCount;) {
                        lbLoadingMessage.setText("Writing Tables...3/4 Line "+(n+1)+" of "+rowCount);
                        
                        //Get line
                        String line = my.get_table_row_values(n, sf2Table);
                        studentName = my.getValueAtColumn(line, 3);
                        gender = my.getValueAtColumn(line, 4);
                        
                        absent = my.getValueAtColumn(line, 32);
                        tardy = my.getValueAtColumn(line, 33);
                        
                        //Extract & Move remarks to last part of the line later
                        remarks = my.getValueAtColumn(line, 6);
                        
                        //<editor-fold desc="Check for First Female Occurence & insert male counter & skip n increment">
                        if(!firstFemaleFound){
                            if(gender.contains("Female")){
                                firstFemaleFound = true;
                                //System.err.println(mCount);
                                my.writeExcelLine(sheetNumber, mCount, null, startingAddress+(row+8));
                                row++;
                                Thread.sleep(threadDelay);
                                continue;
                            }
                        }
                        //Merge with blanks
                        String newLine = (n+1)+"@@"+studentName+"@@"+blankDays+absent+"@@"+tardy+"@@"+remarks+"@@";
                        my.writeExcelLine(sheetNumber, newLine, null, startingAddress+(row+8));
                        Thread.sleep(threadDelay);
                        //</editor-fold>
                        
                        //<editor-fold desc="Insert Images If Present,Absent or Tardy">
                        int [] leftIndeces = new int []{7,12,17,22,27};
                        int [] rightIndeces = new int []{11,16,21,26,31};
                        
                        for (int col = 7; col < 32; col++) {
                            lbLoadingMessage.setText("Writing Tables...3/4 Line "+(n+1)+" of "+rowCount+", Attendance "+(col-6)+"/25");
                            attendanceValue = my.getValueAtColumn(line, col);
                            
                            BorderStyle [] borders;
                            if(my.isInsideArray(col, leftIndeces)){
                                borders = new BorderStyle[]{BorderStyle.MEDIUM,BorderStyle.THIN,BorderStyle.THIN,BorderStyle.THIN,};
                            }else{
                                if(my.isInsideArray(col, rightIndeces)){
                                    borders = new BorderStyle[]{BorderStyle.THIN,BorderStyle.MEDIUM,BorderStyle.THIN,BorderStyle.THIN,};
                                }else{
                                    borders = new BorderStyle[]{BorderStyle.THIN,BorderStyle.THIN,BorderStyle.THIN,BorderStyle.THIN,};
                                }
                            }
                            
                            //System.err.println("Attenance Value: "+attendanceValue);
                            if(attendanceValue.equals("P")){
                                my.writeExcelSingleDataWColor(sheetNumber, "P", row+7, col-5,!myVariables.isDebugModeOn()?Color.WHITE:Color.BLUE,borders);
                                continue;
                            }if(attendanceValue.equals("A")){
                                my.writeExcelSingleDataWColor(sheetNumber, "X", row+7, col-5,!myVariables.isDebugModeOn()?Color.BLACK:Color.RED,borders);
                                continue;
                            }if(attendanceValue.equals("TLC")){
                                my.writeExcelSingleDataWColor(sheetNumber, "TLC", row+7, col-5,!myVariables.isDebugModeOn()?Color.WHITE:Color.ORANGE,borders);
                                my.drawImageToCell(sheetNumber, myVariables.getLateCommerIcon(), new int [] {row+7,col-5,row+8,col-4}, false);
                                continue;
                            }if(attendanceValue.equals("TCC")){
                                my.writeExcelSingleDataWColor(sheetNumber, "TCC", row+7, col-5,!myVariables.isDebugModeOn()?Color.WHITE:Color.RED,borders);
                                my.drawImageToCell(sheetNumber, myVariables.getCuttingClassesIcon(), new int [] {row+7,col-5,row+8,col-4}, false);
                                continue;
                            }if(attendanceValue.equals("T")){
                                my.writeExcelSingleDataWColor(sheetNumber, "T", row+7, col-5,!myVariables.isDebugModeOn()?Color.WHITE:Color.ORANGE,borders);
                                my.drawImageToCell(sheetNumber, myVariables.getLateCommerIcon(), new int [] {row+7,col-5,row+8,col-4}, false);
                                continue;
                            }if(attendanceValue.equals("--")){
                                my.writeExcelSingleData(sheetNumber, "--", row+7, col-5);
                            }
                            Thread.sleep(threadDelay);
                        }
                        //</editor-fold>
                        
                        //If there is no female and is last row
                        if(!firstFemaleFound){
                            if(n == rowCount-1){
                                firstFemaleFound = true;
                                row++;
                                my.writeExcelLine(sheetNumber, mCount, null, startingAddress+(row+8));
                                Thread.sleep(threadDelay);
                            }
                        }
                        
                        n++;
                        row++;
                        Thread.sleep(threadDelay);
                    }
                    //Write Female & Total Counters
                    my.writeExcelLine(sheetNumber, fCount, null, startingAddress+(row+8));
                    my.writeExcelLine(sheetNumber, tCount, null, startingAddress+(row+8+1));
                    
                    //Write Summary Table
                    startingAddress2 = "Y,";
                    int [] rowAddresses = new int [] {23,25,29,31,33,35,36,37,39,41};
                    
                    for (int n = 0; n < 10; n++) {
                        lbLoadingMessage.setText("Writing Tables...3/4 Summary "+(n+1)+" of 10");
                        String line = my.get_table_row_values(n, sf2SummaryTable);
                        line = my.skipColumns(line, new int [] {0});
                        
                        my.writeExcelLine(sheetNumber, line, null, startingAddress2+(rowAddresses[n]+(10*sheetNumber)));
                        Thread.sleep(threadDelay);
                    }
                    //</editor-fold>
                    break;
                }case 3:{
                    //<editor-fold desc="WRITE SF3">
                    //#1 Write Book Names
                    int rowCount = sf3BooksTable.getRowCount();
                    startingAddress = "C,5"; //A,7 first row
                    excelColumnsToSkip = "D,F,H,J,L,N,P,R,T,V";
                    
                    String bookTitles = "";
                    for (int n = 0; n < rowCount; n++) {
                        lbLoadingMessage.setText("Writing Tables...3/4 Writing Book Names "+(n+1)+" of "+rowCount);
                        String bookCode = sf3BooksTable.getValueAt(n, 1).toString();
                        bookTitles += (n+1)+". " + bookCode + "@@";
                        Thread.sleep(pauseDelay);
                    }
                    my.writeExcelLine(sheetNumber, bookTitles, excelColumnsToSkip, startingAddress);
                    
                    //#2 Write Sf3 Table
                    rowCount = sf3Table.getRowCount()-3;
                    startingAddress2 = "A,"; //A,7 first row
                    excelColumnsToSkip = null;
                    
                    //Extract Counters;
                    String maleBooks = my.get_table_row_values(rowCount, sf3Table);
                    String femaleBooks = my.get_table_row_values(rowCount+1, sf3Table);
                    String totalBooks = my.get_table_row_values(rowCount+2, sf3Table);
                    
                    maleBooks = " @@"+my.skipColumns(maleBooks, new int [] {0,1,2,4});
                    femaleBooks = " @@"+my.skipColumns(femaleBooks, new int [] {0,1,2,4});
                    totalBooks = " @@"+my.skipColumns(totalBooks, new int [] {0,1,2,4});
                    
                    int row = 0;
                    boolean firstFemaleFound = false;
                    for (int n = 0; n < rowCount;) {
                        lbLoadingMessage.setText("Writing Tables...3/4 Student "+(n+1)+" of "+rowCount);
                        
                        String gender = sf3Table.getValueAt(n, 4).toString();
                        String line = my.get_table_row_values(n, sf3Table);
                        line = (n+1)+"@@"+my.skipColumns(line, new int [] {0,1,2,4});
                        
                        //System.err.println("Line : "+line);
                        if(!firstFemaleFound){
                            if(gender.contains("Female")){
                                firstFemaleFound = true;
                                //System.err.println(mCount);
                                my.writeExcelLine(sheetNumber, maleBooks, excelColumnsToSkip, startingAddress2+(row+8));
                                
                                row++;
                                Thread.sleep(threadDelay);
                                continue;
                            }
                        }
                        //Write Line
                        my.writeExcelLine(sheetNumber, line, excelColumnsToSkip, startingAddress2+(row+8));
                        Thread.sleep(threadDelay);
                        
                        //If there is no female and is last row
                        if(!firstFemaleFound){
                            if(n == rowCount-1){
                                firstFemaleFound = true;
                                row++;
                                my.writeExcelLine(sheetNumber, maleBooks, excelColumnsToSkip, startingAddress2+(row+8));
                                Thread.sleep(threadDelay);
                            }
                        }
                        n++;
                        row++;
                        Thread.sleep(threadDelay);
                    }
                    //Write Female & Total Counters
                    my.writeExcelLine(sheetNumber, femaleBooks, excelColumnsToSkip, startingAddress2+(row+8));
                    my.writeExcelLine(sheetNumber, totalBooks, excelColumnsToSkip, startingAddress2+(row+8+1));
                    
                    //</editor-fold>
                    break;
                }case 4:{
                    //<editor-fold desc="SF4">
                    int rowCount = sf4Table.getRowCount();
                    startingAddress = "A,";
                    excelColumnsToSkip = "M,N,O,S,T,U,V,W,X,AB,AC,AD,AE,AF,AG,AK,AL,AM";
                    
                    for (int n = 0; n < rowCount; n++) {
                        String line = my.get_table_row_values(n, sf4Table);
                        String sectionName = my.getSectionNameOnly(sf4Table.getValueAt(n, 1).toString(), true);
                        
                        line = my.setValueAtColumn(line, 1, sectionName);
                        
                        my.writeExcelLine(sheetNumber, line, excelColumnsToSkip, startingAddress+(n+11));
                        Thread.sleep(threadDelay);
                    }
                    //</editor-fold>
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
            e.printStackTrace();
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
                    String monthSelected [] = new String [] {"T,22","T,32","T,42","T,52","T,62","T,72","T,82"};
                    String schoolDays [] = new String [] {"W,22","W,32","W,42","W,52","W,62","W,72","W,82"};
                    String advName [] = new String [] {"U,45","U,55","U,65","U,75","U,85","U,95","U,105"};
                    
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
                    //Set Addresses by sheetIndex
                    String advName [] = new String [] {"T,23","T,33","T,43","T,53","T,63","T,73","T,83"};
                    
                    headers = new header[]{
                        //Header Parts
                        new header(schoolId, "C,3"),
                        new header(schoolName, "C,4"),
                        new header(schoolYear, "I,3"),
                        new header(gradeLevel, "P,4"),
                        new header(sectionName, "T,4"),
                        //Form's Custom Fields
                        new header(adviserName, advName[sheetNumber]),
                    };
                    break;
                }case 4:{
                    headers = new header[]{
                        //Header Parts
                        new header(schoolId, "D,4"),
                        new header(region, "J,4"),
                        new header(division, "Q,4"),
                        new header(district, "Y,4"),
                        new header(schoolName, "C,6"),
                        new header(schoolYear, "Y,6"),
                        new header(sf4MonthSelected, "AJ,6"),
                    };
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

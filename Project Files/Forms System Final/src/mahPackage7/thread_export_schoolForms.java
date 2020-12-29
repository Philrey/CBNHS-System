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
                    new header(maleCount, "M,70"),
                    new header(femaleCount, "M,71"),
                    new header(totalCount, "M,72"),
                    new header(adviserName, "O,70"),
                };
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
                sf2MonthSelected = stringsToUse[0];
                sf2SchoolDays = textFieldsToUse[4].getText();
                
                headers = new header[]{
                    //Header Parts
                    new header(schoolId, "C,3"),
                    new header(schoolName, "C,4"),
                    new header(schoolYear, "I,4"),
                    new header(gradeLevel, "R,4"),
                    new header(sectionName, "AB,4"),
                    //Form's Custom Fields
                    new header(maleCount, "M,70"),
                    new header(femaleCount, "M,71"),
                    new header(totalCount, "M,72"),
                    new header(adviserName, "O,70"),
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
        lbLoadingMessage.setText("Creating File...1/4");
        progressBar.setMaximum(4);
        
        //#1 Create File
        if(!my.createExcelFile(getFileName(true))){
            my.showMessage("There was an error exporting the file.", JOptionPane.ERROR_MESSAGE);
            throw new InterruptedException("Reading Failed");
        }
        progressBar.setValue(1);
        Thread.sleep(pauseDelay);
        
        //#2 Write Headers
        lbLoadingMessage.setText("Writing Headers...2/4");
        progressBar.setValue(2);
        if(!writeHeaders(0)){throw new InterruptedException("Writing Headers Failed...");}
        
        //#3 Write Tables
        lbLoadingMessage.setText("Writing Tables...3/4");
        progressBar.setValue(3);
        if(!writeTables(0)){throw new InterruptedException("Writing Tables Failed...");}
        Thread.sleep(pauseDelay);
        
        //#4 Save File
        lbLoadingMessage.setText("Saving File...4/4");
        if(!my.saveExcelFile(getFileName(false))){
            my.showMessage("There was an error exporting the file.", JOptionPane.ERROR_MESSAGE);
            throw new InterruptedException("Save Failed");
        }
        progressBar.setValue(4);
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
    private String getFileName(boolean importExport){
        String fileName = "";
        switch(myVariables.getFormSelected()){
            case 1:{
                fileName = importExport? "templates/jh_sf1.xlsx" : "exports/jh_sf1.xlsx";break;
            }case 2:{
                fileName = importExport? "templates/jh_sf1.xlsx" : "exports/jh_sf1.xlsx";break;
            }case 3:{
                fileName = importExport? "templates/jh_sf1.xlsx" : "exports/jh_sf1.xlsx";break;
            }case 4:{
                fileName = importExport? "templates/jh_sf1.xlsx" : "exports/jh_sf1.xlsx";break;
            }case 5:{
                fileName = importExport? "templates/jh_sf1.xlsx" : "exports/jh_sf1.xlsx";break;
            }case 6:{
                fileName = importExport? "templates/jh_sf1.xlsx" : "exports/jh_sf1.xlsx";break;
            }case 7:{
                fileName = importExport? "templates/jh_sf1.xlsx" : "exports/jh_sf1.xlsx";break;
            }case 8:{
                fileName = importExport? "templates/jh_sf1.xlsx" : "exports/jh_sf1.xlsx";break;
            }case 9:{
                fileName = importExport? "templates/jh_sf1.xlsx" : "exports/jh_sf1.xlsx";break;
            }case 10:{
                fileName = importExport? "templates/jh_sf1.xlsx" : "exports/jh_sf1.xlsx";break;
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
    private class headersInt{
        private String data;
        private int row;
        private int column;

        public headersInt(String data, int row, int column) {
            this.data = data;
            this.row = row;
            this.column = column;
        }

        public String getData() {
            return data;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
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

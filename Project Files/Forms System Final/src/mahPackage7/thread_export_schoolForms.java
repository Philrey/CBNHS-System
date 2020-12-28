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
                    new header(schoolId, "C,3"),
                    new header(region, "G,3"),
                    new header(division, "L,3"),
                    new header(district, "Q,3"),
                    new header(schoolName, "C,4"),
                    new header(schoolYear, "L,4"),
                    new header(gradeLevel, "N,4"),
                    new header(sectionName, "P,4"),
                    
                    new header(maleCount, "M,70"),
                    new header(femaleCount, "M,71"),
                    new header(totalCount, "M,72"),
                    new header(adviserName, "O,70"),
                };
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
        
        //Create File
        if(!my.createExcelFile(getFileName())){
            my.showMessage("There was an error exporting the file.", JOptionPane.ERROR_MESSAGE);
            throw new InterruptedException("Reading Failed");
        }
        progressBar.setValue(1);
        Thread.sleep(pauseDelay);
        //Write Headers
        lbLoadingMessage.setText("Writing Headers...2/4");
        progressBar.setValue(2);
        if(!writeHeaders(0)){throw new InterruptedException("Writing Headers Failed...");}
        
        //Write Tables
        lbLoadingMessage.setText("Writing Tables...3/4");
        
        progressBar.setValue(3);
        Thread.sleep(pauseDelay);
        //Save File
        lbLoadingMessage.setText("Saving File...4/4");
        if(!my.saveExcelFile("exports/Excel Test.xlsx")){
            my.showMessage("There was an error exporting the file.", JOptionPane.ERROR_MESSAGE);
            throw new InterruptedException("Save Failed");
        }
        progressBar.setValue(4);
        Thread.sleep(pauseDelay);
        return "Task Complete";
    }

    @Override
    protected void done() {
        closeCustomDialog();
        btnExport.setEnabled(false);
        super.done(); //To change body of generated methods, choose Tools | Templates.
    }
    //<editor-fold desc="Custom Functions">
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
    private String getFileName(){
        String fileName = "";
        switch(myVariables.getFormSelected()){
            case 1:{
                fileName = "templates/jh_sf1.xlsx";break;
            }case 2:{
                fileName = "templates/jh_sf2.xlsx";break;
            }case 3:{
                fileName = "templates/jh_sf3.xlsx";break;
            }case 4:{
                fileName = "templates/jh_sf4.xlsx";break;
            }case 5:{
                fileName = "templates/jh_sf5.xlsx";break;
            }case 6:{
                fileName = "templates/jh_sf6.xlsx";break;
            }case 7:{
                fileName = "templates/jh_sf7.xlsx";break;
            }case 8:{
                fileName = "templates/jh_sf8.xlsx";break;
            }case 9:{
                fileName = "templates/jh_sf9.xlsx";break;
            }case 10:{
                fileName = "templates/jh_sf10.xlsx";break;
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
    //</editor-fold>
}

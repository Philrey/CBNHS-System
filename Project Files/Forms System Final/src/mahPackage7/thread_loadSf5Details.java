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
    JTable rankingTable7;
    JTable rankingTable8;
    JTable rankingTable9;
    JTable rankingTable10;
    
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
        
        rankingTable7 = tablesToUse[4];
        rankingTable8 = tablesToUse[5];
        rankingTable9 = tablesToUse[6];
        rankingTable10 = tablesToUse[7];
        
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
            //Proces & Count Records
            int studCount = result.length;
            int promotedM=0,promotedF=0;
            int conditionalM=0,conditionalF=0;
            int retainedM=0,retainedF=0;
            int incompleteM=0,incompleteF=0;
            
            int male=0;int female=0;
            
            for(int n=0;n<studCount;n++){
                String actionTaken = my.getValueAtColumn(result[n], 11);
                String remarks[] = my.getValueAtColumn(result[n], 9).split("!");
                String gender = my.getValueAtColumn(result[n], 8);
                
                if(actionTaken.contains("Incomplete")){
                    if(showIncompleteRecords){
                        if(gender.contains("Female")){incompleteF++;}
                        else{incompleteM++;}
                    }else{
                        continue;
                    }
                }
                if(remarks[0].startsWith("DRP") || remarks[1].startsWith("DRP")){
                    continue;   //Skip Dropped Student
                }
                
                if(actionTaken.contains("Promoted")){
                    if(gender.contains("Female")){promotedF++;}
                    else{promotedM++;}
                }if(actionTaken.contains("Conditional")){
                    if(gender.contains("Female")){conditionalF++;}
                    else{conditionalM++;}
                }if(actionTaken.contains("Retained")){
                    if(gender.contains("Female")){retainedF++;}
                    else{retainedM++;}
                }
                
                if(gender.contains("Female")){
                    female++;
                }else{
                    male++;
                }
                result[n] = my.toNameFormatFull(result[n], new int [] {5,6,7});
                my.add_table_row(result[n], sf5Table);
                Thread.sleep(threadDelay);
            }
            if(!updateSummaryTable(promotedM, promotedF, conditionalM, conditionalF, retainedM, retainedF, incompleteM, incompleteF)){
                throw new InterruptedException("Interrupted By User");
            }if(!convertGenAverageToWholeNumbers()){
                throw new InterruptedException("Interrupted By User");
            }if(!updateLevelLevelOfProgressTable()){
                throw new InterruptedException("Interrupted By User");
            }
            btnExport.setEnabled(!showIncompleteRecords);
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
    private boolean updateLevelLevelOfProgressTable(){
        try {
            int studCount = sf5Table.getRowCount();
            progressBar.setMaximum(studCount);
            progressBar.setValue(0);
            
            lbLoadingMessage.setText("Updating Level of Progress...");
            Thread.sleep(pauseDelay);
            
            String gender="";
            float generalAverage=0f;
            int below74M = 0,below74F = 0;
            int in75to79M = 0,in75to79F = 0;
            int in80to84M = 0,in80to84F = 0;
            int in85to89M = 0,in85to89F = 0;
            int in90to100M = 0,in90to100F = 0;
            
            for(int n=0;n<studCount;n++){
                lbLoadingMessage.setText("Updating Level of Progress..."+(n+1)+" of "+studCount);
                progressBar.setValue(n+1);
                
                gender = sf5Table.getValueAt(n, 6).toString();
                generalAverage = Float.parseFloat(sf5Table.getValueAt(n, 8).toString());
                
                if(generalAverage <= 74){
                    if(gender.contains("Female")){below74F++;}
                    else{below74M++;}
                }if(generalAverage > 74 && generalAverage <= 79){
                    if(gender.contains("Female")){in75to79F++;}
                    else{in75to79M++;}
                }if(generalAverage > 79 && generalAverage <= 84){
                    if(gender.contains("Female")){in80to84F++;}
                    else{in80to84M++;}
                }if(generalAverage > 84 && generalAverage <= 89){
                    if(gender.contains("Female")){in85to89F++;}
                    else{in85to89M++;}
                }if(generalAverage > 89 && generalAverage <= 100){
                    if(gender.contains("Female")){in90to100F++;}
                    else{in90to100M++;}
                }
                
                Thread.sleep(threadDelay);
            }
            //Update Level of Progress Table
            int currBelow74M = Integer.parseInt(sf5LevelOfProgress.getValueAt(0, 1).toString());
            int currBelow74F = Integer.parseInt(sf5LevelOfProgress.getValueAt(0, 2).toString());
            
            int curr75to79M = Integer.parseInt(sf5LevelOfProgress.getValueAt(1, 1).toString());
            int curr75to79F = Integer.parseInt(sf5LevelOfProgress.getValueAt(1, 2).toString());
            
            int curr80to84M = Integer.parseInt(sf5LevelOfProgress.getValueAt(2, 1).toString());
            int curr80to84F = Integer.parseInt(sf5LevelOfProgress.getValueAt(2, 2).toString());
            
            int curr85to89M = Integer.parseInt(sf5LevelOfProgress.getValueAt(3, 1).toString());
            int curr85to89F = Integer.parseInt(sf5LevelOfProgress.getValueAt(3, 2).toString());
            
            int curr90to100M = Integer.parseInt(sf5LevelOfProgress.getValueAt(4, 1).toString());
            int curr90to100F = Integer.parseInt(sf5LevelOfProgress.getValueAt(4, 2).toString());
            
            //Below 74
            sf5LevelOfProgress.setValueAt(below74M+currBelow74M, 0, 1);
            sf5LevelOfProgress.setValueAt(below74F+currBelow74F, 0, 2);
            sf5LevelOfProgress.setValueAt(below74M+currBelow74M+below74F+currBelow74F, 0, 3);
            //75 - 79
            sf5LevelOfProgress.setValueAt(in75to79M+curr75to79M, 1, 1);
            sf5LevelOfProgress.setValueAt(in75to79F+curr75to79F, 1, 2);
            sf5LevelOfProgress.setValueAt(in75to79M+curr75to79M+in75to79F+curr75to79F, 1, 3);
            //80 - 84
            sf5LevelOfProgress.setValueAt(in80to84M+curr80to84M, 2, 1);
            sf5LevelOfProgress.setValueAt(in80to84F+curr80to84F, 2, 2);
            sf5LevelOfProgress.setValueAt(in80to84M+curr80to84M+in80to84F+curr80to84F, 2, 3);
            //85 - 89
            sf5LevelOfProgress.setValueAt(in85to89M+curr85to89M, 3, 1);
            sf5LevelOfProgress.setValueAt(in85to89F+curr85to89F, 3, 2);
            sf5LevelOfProgress.setValueAt(in85to89M+curr85to89M+in85to89F+curr85to89F, 3, 3);
            //90 - 100
            sf5LevelOfProgress.setValueAt(in90to100M+curr90to100M, 4, 1);
            sf5LevelOfProgress.setValueAt(in90to100F+curr90to100F, 4, 2);
            sf5LevelOfProgress.setValueAt(in90to100M+curr90to100M+in90to100F+curr90to100F, 4, 3);
            
            Thread.sleep(pauseDelay);
            return true;
        } catch(InterruptedException x){
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    private boolean updateSummaryTable(int promotedM,int promotedF,int conditionalM,int conditionalF,int retainedM,int retainedF,int incompleteM,int incompleteF){
        try {
            lbLoadingMessage.setText("Updating Summary Table...");
            //Update summary table
            int currPromotedM = Integer.parseInt(sf5SummaryTable.getValueAt(0, 1).toString());
            int currPromotedF = Integer.parseInt(sf5SummaryTable.getValueAt(0, 2).toString());
            int currConditionalM = Integer.parseInt(sf5SummaryTable.getValueAt(1, 1).toString());
            int currConditionalF = Integer.parseInt(sf5SummaryTable.getValueAt(1, 2).toString());
            int currRetainedM = Integer.parseInt(sf5SummaryTable.getValueAt(2, 1).toString());
            int currRetainedF = Integer.parseInt(sf5SummaryTable.getValueAt(2, 2).toString());
            int currIncM = 0,currIncF = 0;
            
            if(showIncompleteRecords){
                currIncM = Integer.parseInt(sf5SummaryTable.getValueAt(3, 1).toString());
                currIncF = Integer.parseInt(sf5SummaryTable.getValueAt(3, 2).toString());
            }
            //Promoted
            sf5SummaryTable.setValueAt(promotedM+currPromotedM, 0, 1);
            sf5SummaryTable.setValueAt(promotedF+currPromotedF, 0, 2);
            sf5SummaryTable.setValueAt(promotedM+currPromotedM+promotedF+currPromotedF, 0, 3);
            //Conditional
            sf5SummaryTable.setValueAt(conditionalM+currConditionalM, 1, 1);
            sf5SummaryTable.setValueAt(conditionalF+currConditionalF, 1, 2);
            sf5SummaryTable.setValueAt(conditionalM+currConditionalM+conditionalF+currConditionalF, 1, 3);
            //Retained
            sf5SummaryTable.setValueAt(retainedM+currRetainedM, 2, 1);
            sf5SummaryTable.setValueAt(retainedF+currRetainedF, 2, 2);
            sf5SummaryTable.setValueAt(retainedM+currRetainedM+retainedF+currRetainedF, 2, 3);
            if(showIncompleteRecords){
                sf5SummaryTable.setValueAt(incompleteM+currIncM, 3, 1);
                sf5SummaryTable.setValueAt(incompleteF+currIncF, 3, 2);
                sf5SummaryTable.setValueAt(incompleteM+currIncM+incompleteF+currIncF, 3, 3);
            }
            
            Thread.sleep(pauseDelay);
            return true;
        } catch (InterruptedException e) {
            return false;
        } catch (Exception x){
            System.err.println("Error Occured:");
            x.printStackTrace();
            return false;
        }
    }
    private boolean convertGenAverageToWholeNumbers(){
        try {
            int studCount = sf5Table.getRowCount();
            lbLoadingMessage.setText("Converting General Averages...");
            progressBar.setMaximum(studCount);
            progressBar.setValue(0);
            Thread.sleep(pauseDelay);
            
            for(int n=0;n<studCount;n++){
                lbLoadingMessage.setText("Processing Students..."+(n+1)+" of "+studCount);
                progressBar.setValue(n+1);
                
                int gradeLevel = Integer.parseInt(sf5Table.getValueAt(n, 2).toString());
                int studentId = Integer.parseInt(sf5Table.getValueAt(n, 3).toString());
                float generalAverage = Float.parseFloat(sf5Table.getValueAt(n, 8).toString());
                
                if(compareToRankings){
                    if(!compareToRankings(n,studentId, gradeLevel, generalAverage)){
                        throw new InterruptedException("Interrupted By User @ compareToRankings");
                    }
                }else{
                    sf5Table.setValueAt(String.valueOf((int)generalAverage), n, 8);
                }
                Thread.sleep(threadDelay);
            }
            Thread.sleep(pauseDelay);
            return true;
        } catch (InterruptedException e) {
            return false;
        } catch (Exception x){
            x.printStackTrace();
            return false;
        }
    }
    private boolean compareToRankings(int rowIndex,int studentId,int gradeLevel,float generalAverage){
        try {
            lbLoadingMessage.setText("Comparing Student To Rankings...");
            
            JTable tableToUse = null;
            switch(gradeLevel){
                case 7:{
                    tableToUse = rankingTable7;
                    break;
                }case 8:{
                    tableToUse = rankingTable8;
                    break;
                }case 9:{
                    tableToUse = rankingTable9;
                    break;
                }case 10:{
                    tableToUse = rankingTable10;
                    break;
                }
            }
            if(generalAverage >= 75){
                boolean matchFound = false;
                if(tableToUse.getRowCount() > 0){
                    for(int n=0;n<tableToUse.getRowCount();n++){
                        int rankingStudentId = Integer.parseInt(tableToUse.getValueAt(n, 7).toString());
                        if(studentId == rankingStudentId){
                            matchFound = true;
                            break;
                        }
                    }
                }
                
                if(matchFound){
                    sf5Table.setValueAt(String.valueOf(generalAverage), rowIndex, 8);
                }else{
                    sf5Table.setValueAt(String.valueOf((int)generalAverage), rowIndex, 8);
                }
            }else{
                sf5Table.setValueAt(String.valueOf((int)generalAverage), rowIndex, 8);
            }
            
            
            Thread.sleep(pauseDelay);
            return true;
        } catch(InterruptedException x){
            x.printStackTrace();
            return false;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    private boolean loadEmptyCounters(){
        try {
            lbLoadingMessage.setText("Loading Empty Counters...");
            String summaries [] = null;
            if(showIncompleteRecords){
                summaries = new String []{
                    "Promoted@@0@@0@@0@@",
                    "Conditional@@0@@0@@0@@",
                    "Retained@@0@@0@@0@@",
                    "Incomplete@@0@@0@@0@@",
                };
            }else{
                summaries = new String []{
                    "Promoted@@0@@0@@0@@",
                    "Conditional@@0@@0@@0@@",
                    "Retained@@0@@0@@0@@",
                };
            }
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

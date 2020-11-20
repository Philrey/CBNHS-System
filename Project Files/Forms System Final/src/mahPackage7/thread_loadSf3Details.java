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
public class thread_loadSf3Details extends SwingWorker<String, Object>{
    //<editor-fold desc="Variables">
    long threadDelay = 100;
    long pauseDelay = 500;
    myFunctions my;
    
    //Sf4 Variables (Optional)
    private JTextField tfSectionName;
    private JTextField tfAdviserName;
    private JTextField tfGradeLevel;
    private JTextField tfSchoolYear;
    
    //Main Variables
    private JTable sf3Table;
    private JTable sf3BooksTable;
    
    private String sectionId;
    private String subjectId;
    private String missingValuesSubstitute;
    private String booksContained;
    
    private boolean waitForMainThreadToFinish;
    //Dialog Properties
    private JDialog dialog;
    private JFrame jFrameName;
    private JPanel dialogPanel;
    private JLabel lbLoadingMessage;
    private JProgressBar progressBar;
    //</editor-fold>

    public thread_loadSf3Details(JTable [] tablesToUse,String [] stringsToUse,JTextField [] textFieldsToUse,JButton [] buttonsToUse,boolean [] waitForThreadsToFinish) {
        my = new myFunctions(true);
        sf3Table = tablesToUse[0];
        sf3BooksTable = tablesToUse[1];
        
        sectionId = stringsToUse[0];
        subjectId = stringsToUse[1];
        missingValuesSubstitute = stringsToUse[2];
        booksContained = stringsToUse[3];
        
        tfSectionName = textFieldsToUse[0];
        tfAdviserName = textFieldsToUse[1];
        tfGradeLevel = textFieldsToUse[2];
        tfSchoolYear = textFieldsToUse[3];
        
        waitForMainThreadToFinish = waitForThreadsToFinish[1];
        //For Loading Screen
        jFrameName = myVariables.getCurrentLoadingFrame();
        dialogPanel = myVariables.getLoadingPanel();
        lbLoadingMessage = myVariables.getLbLoadingMessage();
        progressBar = myVariables.getProgressBar();
    }
    
    
    @Override
    protected String doInBackground() throws Exception {
        try {
            showCustomDialog("Loading Books...", dialogPanel, false, 320, 220, false);
            lbLoadingMessage.setText("Loading Book Template...");
            progressBar.setMaximum(1);
            progressBar.setValue(0);
            String bookIds = booksContained.substring(0, booksContained.length()-1).replace(":", ",");

            String result [] = my.return_values("*", "books", "WHERE id IN("+bookIds+")", myVariables.getBooksOrder());
            Thread.sleep(pauseDelay);
            if(result != null){
                if(!loadBooks(result)){
                    throw new InterruptedException("Interrupted bt user.");
                }
                my.searchItemThread("", "WHERE sectionId='"+sectionId+"'", sf3Table, 13, new int[]{3,4,5}, true, null, null, null);
                //<editor-fold desc="Wait for search students to finish">
                if(waitForMainThreadToFinish){
                    while (true) {                    
                        if(myFunctions.getMainThead() != null){
                            if(!myFunctions.getMainThead().isAlive()){
                                break;
                            }
                        }else{
                            break;
                        }
                    }
                }//</editor-fold>
                showCustomDialog("Loading Books...", dialogPanel, waitForMainThreadToFinish, 320, 220, false);
                Thread.sleep(pauseDelay);
                loadEmptyCounters();
                //Load student's book records
                loadStudentBooks();
                translateColumns();

            }else{
                loadEmptyCounters();
                return "No Students Found";
            }

            return "Ended Successfully";
        } catch (InterruptedException e) {
            return "Interrupted by user";
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void done() {
        try {
            System.err.println("Sf3 Thread Done: "+get());
        } catch (Exception e) {
            System.err.println("Sf3 Thread Error found: "+e.getLocalizedMessage());
        }
        closeCustomDialog();
        super.done(); //To change body of generated methods, choose Tools | Templates.
    }
    private String [] getBookDetails(int columnIndex){
        int bookIndex = 0;
        int sf3BooksIndex = -1;
        if(columnIndex%2==1){   //issued
            bookIndex = columnIndex;
        }else{                  //returned
            bookIndex = columnIndex-1;
        }
        switch(bookIndex){
            case 5:{
                sf3BooksIndex = 0;break;
            }case 7:{
                sf3BooksIndex = 1;break;
            }case 9:{
                sf3BooksIndex = 2;break;
            }case 11:{
                sf3BooksIndex = 3;break;
            }case 13:{
                sf3BooksIndex = 4;break;
            }case 15:{
                sf3BooksIndex = 5;break;
            }case 17:{
                sf3BooksIndex = 6;break;
            }case 19:{
                sf3BooksIndex = 7;break;
            }case 21:{
                sf3BooksIndex = 8;break;
            }case 23:{
                sf3BooksIndex = 9;break;
            }
        }
        System.err.println("bookIndex="+bookIndex+" sf3BIndex="+sf3BooksIndex);
        try {
            String result = my.get_table_row_values(sf3BooksIndex, sf3BooksTable);
            return result.split("@@");
        } catch (Exception e) {
            return null;
        }
    }
    private void translateColumns(){
        try {
            int studentCount = sf3Table.getRowCount()-3;
            String currentValue="",remarks="";
            for(int rows=0;rows<studentCount;rows++){
                try {
                    remarks = sf3Table.getValueAt(rows, 25).toString();
                } catch (Exception e) {
                    remarks=" ";
                }
                for(int col=5;col<25;col++){
                    String [] currentBookDetails = getBookDetails(col);
                    try {
                        currentValue = sf3Table.getValueAt(rows, col).toString();
                        
                        if(col%2==1){   //issued column
                            
                        }else{  //returned column
                            if(currentValue.contains(":")){
                                String codes [] = currentValue.split(":");
                                if(codes.length == 2){
                                    sf3Table.setValueAt(codes[0], rows, col);
                                    if(remarks.trim().length() <= 0){
                                        remarks = currentBookDetails[4]+":"+codes[1];
                                    }else{
                                        remarks +=", "+currentBookDetails[4]+":"+codes[1];
                                    }
                                }else{
                                    //Rejoin index 1 onwards into one string
                                }
                            }
                        }
                    } catch (Exception e) {
                        sf3Table.setValueAt(missingValuesSubstitute, rows, col);
                    }
                }
                
                //set remarks
                sf3Table.setValueAt(remarks, rows, 25);
            }
            
        } catch (Exception e) {
            System.err.println("Interrupted @ Translate Columns");
            e.printStackTrace();
        }
    }
    private void loadStudentBooks(){
        int studCount = sf3Table.getRowCount();
        progressBar.setMaximum(studCount-3);
        progressBar.setValue(0);
        try {
            for(int n=0;n<studCount-3;n++){ //Loop sf3 table
                lbLoadingMessage.setText("Loading Student "+(n+1)+" of "+(studCount-3));
                progressBar.setValue(n+1);
                String studentId = sf3Table.getValueAt(n, 2).toString();
                Thread.sleep(pauseDelay);
                
                lbLoadingMessage.setText("Connecting to Database...");
                String booksIsdRtn [] = my.return_values("*", "booksissuedreturned", "WHERE sectionId='"+sectionId+"' AND studentId='"+studentId+"'", myVariables.getBooksIssuedReturnedOrder());
                int booksLength = booksIsdRtn.length;
                if(booksIsdRtn != null){
                    for(int x=0;x<booksLength;x++){
                        lbLoadingMessage.setText("Processing Record "+(x+1)+" of "+booksLength);
                        putValuesToBookColumn(n, booksIsdRtn[x]);
                        Thread.sleep(threadDelay);
                    }

                }else{
                    //Fill with empty values
                    for(int x=5;x<25-(sf3BooksTable.getRowCount()*2);x++){
                        sf3Table.setValueAt(missingValuesSubstitute, n, x);
                    }
                    sf3Table.setValueAt("NRA", n, 25);
                }
                Thread.sleep(pauseDelay);
            }
        } catch (Exception e) {
            System.err.println("Interrupted @ Load Student Books");
            return;
        }
    }
    private void putValuesToBookColumn(int row,String cLine){
        String recordValues [] = cLine.split("@@");
        String dateIssued = recordValues[4];
        String dateReturned = recordValues[5];
        
        //Search for matching book ID from sf3Books table
        int booksLength = sf3BooksTable.getRowCount();
        int bookId = Integer.parseInt(recordValues[3]),foundBookId=0;
        boolean matchFound = false;
        int indexSaved = 0;
        for(int n=0;n<booksLength;n++){
            foundBookId = Integer.parseInt(sf3BooksTable.getValueAt(n, 0).toString());
            if(bookId == foundBookId){
                matchFound = true;
                indexSaved = (n*2)+5;
                break;
            }
        }
        if(!matchFound){
            System.err.println("Excess Record Found. Excluding...");return;
        }
        
        sf3Table.setValueAt(dateIssued, row, indexSaved);
        sf3Table.setValueAt(dateReturned, row, indexSaved+1);
    }
    private void loadEmptyCounters(){
        try {
            lbLoadingMessage.setText("Loading Counters...");
            String counters [] = {
                "--@@--@@--@@<== Total For Male ==>@@--@@",
                "--@@--@@--@@<== Total For Female ==>@@--@@",
                "--@@--@@--@@<== Total Learners==>@@--@@",
            };

            for(int n=0;n<counters.length;n++){
                my.add_table_row(counters[n], sf3Table);
                Thread.sleep(threadDelay);
            }
            Thread.sleep(pauseDelay);
        } catch (Exception e) {
            System.err.println("Interrupted @ Load Empty Counters");
            return;
        }
    }
    
    private boolean loadBooks (String [] result){
        my.clear_table_rows(sf3BooksTable);
        String booksOrder [] = booksContained.split(":");
        int orderLength = booksOrder.length;
        int currentId = 0,resultId = 0;
        try {
            progressBar.setValue(0);
            progressBar.setMaximum(orderLength);
            //Load books order by template order
            for(int n=0;n<booksOrder.length;n++){
                lbLoadingMessage.setText("Loading Book "+(n+1)+" of "+orderLength);
                progressBar.setValue(n+1);
                currentId = Integer.parseInt(booksOrder[n]);
                for(int x=0;x<result.length;x++){
                    resultId = Integer.parseInt(my.getValueAtColumn(result[x], 0));

                    if(currentId == resultId){
                        my.add_table_row(result[x]+"--@@", sf3BooksTable);
                        break;
                    }
                }
                Thread.sleep(threadDelay);
            }
            lbLoadingMessage.setText("Marking Indeces...");
            //Mark Book index
            for(int n=0;n<sf3BooksTable.getRowCount();n++){
                lbLoadingMessage.setText("Marking Indeces...Book "+(n+1)+" of "+sf3BooksTable.getRowCount());
                sf3BooksTable.setValueAt("B"+(n+1), n, 4);
                Thread.sleep(threadDelay);
            }
            Thread.sleep(pauseDelay);
            return true;
        } catch (InterruptedException e) {
            System.err.println("Interrupted @ LoadBooks");
            return false;
        }
    }
    
    private void showCustomDialog(String title, JPanel customPanel, boolean isModal, int width, int height, boolean isResizable){
        if(dialog != null && dialog.isVisible()){
            dialog.setTitle(title);
            dialog.add(customPanel);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackage7;

import java.awt.Color;
import java.awt.Dialog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.ImageIcon;
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
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Phil Rey Paderogao
 */
public class thread_loadSf2Details extends SwingWorker<String, Object>{
    long threadDelay = 100;
    long pauseDelay = 500;
    
    //Main Variables
    private int males,females,total;
    private JTable dateTable;
    private JTable tableName;
    private String sectionId;
    private String dateSelected;
    private String subjectId;
    
    private String startingDate;
    private String endingDate;
    
    private boolean waitForMainThreadToFinish;
    
    private JTextField tfMale,tfFemale,tfTotal;
    //Dialog Properties
    private JDialog dialog;
    private JFrame jFrameName;
    private JPanel dialogPanel;
    private JLabel lbLoadingMessage;
    private JProgressBar progressBar;

    public thread_loadSf2Details(JTable [] tablesToUse,String [] stringsToUse,JTextField [] textFieldsToUse,JButton [] buttonsToUse,boolean waitForMainThreadToFinish) {
        dateTable = tablesToUse[0];
        tableName = tablesToUse[1];
        sectionId = stringsToUse[0];
        dateSelected = stringsToUse[1];
        subjectId = stringsToUse[2];
        
        this.waitForMainThreadToFinish = waitForMainThreadToFinish;
        jFrameName = myVariables.getCurrentLoadingFrame();
        dialogPanel = myVariables.getLoadingPanel();
        lbLoadingMessage = myVariables.getLbLoadingMessage();
        progressBar = myVariables.getProgressBar();
    }
    @Override
    protected String doInBackground() throws Exception {
        //Wait For Students to Load
        if(waitForMainThreadToFinish){
            System.err.println("Waiting for mainThread to Finish first...");
            while (true) {                
                if(myFunctions.getMainThead() == null){
                    break;
                }else{
                    if(!myFunctions.getMainThead().isAlive()){
                        break;
                    }
                }
            }
        }
        tableName.setEnabled(false);
        showCustomDialog("Loading Attendances...", dialogPanel, false, 320, 220, false);
        System.err.println("Starting Second THread");
        //Load Dates
        lbLoadingMessage.setText("Determining Days...");
        String dateLine = "-@@-@@-@@-@@-@@-@@-@@"+getStartAndEndDates(dateSelected, false);
        clear_table_rows(dateTable);
        add_table_row(dateLine, dateTable, new int []{7,12,17,22}, Color.RED);
        
        Thread.sleep(pauseDelay);
        //<editor-fold desc="Load Attendances">
            lbLoadingMessage.setText("Processing...");
            
            int studCount = tableName.getRowCount(),attendanceCount=0;
            int currentDateSelected=0,dateResultFound;
            String studentId = "";
            
            progressBar.setMinimum(0);
            progressBar.setMaximum(studCount);
            Thread.sleep(threadDelay);
            
            for(int n=0;n<studCount;n++){   //Loop student table
                lbLoadingMessage.setText("Processing Student "+(n+1)+" of "+studCount);
                progressBar.setValue(n+1);
                studentId = tableName.getValueAt(n, 2).toString();
                Thread.sleep(pauseDelay);
                //Get attendaces of student from database
                String where = "WHERE studentId='"+studentId+"' AND "
                        + "sectionId='"+sectionId+"' AND "
                        + "subjectId='"+subjectId+"' AND "
                        + "dateAdded>='"+startingDate+"' AND "
                        + "dateAdded <='"+endingDate+"' "
                        + "ORDER BY sectionId DESC,studentId DESC,subjectId DESC, dateAdded ASC";
                Thread.sleep(threadDelay);
                lbLoadingMessage.setText("Connecting to Database...");
                
                String [] attendanceResults = return_values("*", "attendance", where, myVariables.getAttendanceOrder());
                
                Thread.sleep(pauseDelay);
                lbLoadingMessage.setText("Loading Attendance...");
                
                boolean matchFound;
                if(attendanceResults != null){
                    for(int x=7;x<32;x++){  //Loop Dates
                        lbLoadingMessage.setText("Processing Student "+(n+1)+" of "+studCount+". Date "+(x-6)+" of 25");
                        try {
                            currentDateSelected = Integer.parseInt(dateTable.getValueAt(0, x).toString());
                        } catch (Exception e) {
                            tableName.setValueAt(myVariables.isDebugModeOn()? "ND" : " ", n, x);
                            continue;
                        }
                        //Match attendance dates with day columns
                        attendanceCount = attendanceResults.length;
                        matchFound = false;
                        for(int y=0;y<attendanceCount;y++){ //Loop Attendances
                            String cLine [] = attendanceResults[y].split("@@"); //{29,3,7,52,Present,2020-02-10 17:52:45,Notes}
                            String dateTime [] = cLine[5].split(" ");   //{2020-03-25,10:00:00}
                            String dates [] = dateTime[0].split("-");   //{2020,03,25}
                            
                            dateResultFound = Integer.parseInt(dates[2]);
                            //System.err.println("CD:"+currentDateSelected+" RD:"+dateTime[0]);
                            if(dateResultFound == currentDateSelected){
                                //System.err.println("Match Found");
                                //Process attendance
                                if(cLine[4].contains("Present")){
                                    tableName.setValueAt("P", n, x);
                                }if(cLine[4].contains("Absent")){
                                    tableName.setValueAt("A", n, x);
                                }if(cLine[4].contains("Tardy") || cLine[4].contains("Late")){
                                    try {
                                        //Check notes for codes
                                        String codes [] = cLine[6].split(":");
                                        tableName.setValueAt("T"+codes[0], n, x);
                                    } catch (Exception e) {
                                        tableName.setValueAt("T", n, x);
                                    }
                                }
                                matchFound = true;
                                break;
                            }
                        }
                        if(!matchFound){
                            tableName.setValueAt(myVariables.isDebugModeOn()? "NAF" : " ", n, x);  //No attendance found for this day
                        }
                        Thread.sleep(threadDelay);
                    }
                }else{
                    for(int x=7;x<32;x++){  //Loop Dates
                        try {
                            currentDateSelected = Integer.parseInt(dateTable.getValueAt(0, x).toString());
                        } catch (Exception e) {
                            tableName.setValueAt(myVariables.isDebugModeOn()? "ND" : " ", n, x);
                            continue;
                        }
                        tableName.setValueAt(myVariables.isDebugModeOn()? "NAF" : " ", n, x);  //No attendance found for this day
                    }
                }
            }
            //Get Attendance PerStudent
            
            //COunt Present Absent & Tardy
        //</editor-fold>
        
        return null;
    }

    @Override
    protected void done() {
        closeCustomDialog();
        super.done(); //To change body of generated methods, choose Tools | Templates.
    }
    //<editor-fold desc="Custom Functions">
    private void showCustomDialog(String title, JPanel customPanel, boolean isModal, int width, int height, boolean isResizable){
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
    public boolean add_table_row(String line,JTable tableName){
        String [] row=line.split("@@");
        Object [] rows = new Object[row.length];
        
        if(row[0].length() < 1){
            return false;
        }
        for(int n=0;n<row.length;n++){
            if(row[n].contains("null")){
                rows[n] = "";
            }else{
                rows[n] = row[n];
            }
            
        }
        
        DefaultTableModel model;
        
        model=(DefaultTableModel)tableName.getModel();
        model.addRow(rows);
        
        return true;
    }
    public boolean add_table_row(String line,JTable tableName,int [] selectedColumns,Color foreground){
        String [] row=line.split("@@");
        Object [] rows = new Object[row.length];
        
        if(row[0].length() < 1){
            return false;
        }
        for(int n=0;n<row.length;n++){
            if(row[n].contains("null")){
                rows[n] = "";
            }else{
                rows[n] = row[n];
            }
            
        }
        
        DefaultTableModel model;
        
        CustomCellRenderer cellRenderer = new CustomCellRenderer(tableName.getBackground(), foreground, tableName.getFont(),tableName.getSelectionForeground(),tableName.getSelectionBackground());
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        for(int n=0;n<tableName.getColumnCount();n++){
            for(int x=0;x<selectedColumns.length;x++){
                if(n == selectedColumns[x]){
                    tableName.getColumnModel().getColumn(n).setCellRenderer(cellRenderer);
                }
            }
        }
        
        model=(DefaultTableModel)tableName.getModel();
        model.addRow(rows);
        
        return true;
    }
    public void clear_table_rows(JTable table_nameTable){
        DefaultTableModel model=(DefaultTableModel) table_nameTable.getModel();
        model.setRowCount(0);
    }
    public String getStartAndEndDates(String dateT,boolean includeWeekends){
        /*
        //Function Query for getting dates
        
        SELECT 
        functionsoutput.id,
        functionsoutput.name,
        getStartingDay(now()) as 'startingDay',
        getLastDay(now()) as 'lastDay'

        FROM functionsoutput
        */
        lbLoadingMessage.setText("Determining Days...Connecting to Database");
        
        String [] result = return_values("getStartingDay('"+dateT+"+') as 'startingDay',getLastDay('"+dateT+"') as 'getLastDay'", "", "", new int [] {0,1});
        String [] dateStrings = null;
        if(result != null){
            //Convert day name to number
            String [] dates = result[0].split("@@");
            startingDate = dateT;
            endingDate = dates[1];
            if(dates[0].contains("Monday")){
                dates[0] = "1";
            }
            if(dates[0].contains("Tuesday")){
                dates[0] = "2";
            }
            if(dates[0].contains("Wednesday")){
                dates[0] = "3";
            }
            if(dates[0].contains("Thursday")){
                dates[0] = "4";
            }
            if(dates[0].contains("Friday")){
                dates[0] = "5";
            }
            if(dates[0].contains("Saturday")){
                dates[0] = "6";
            }
            if(dates[0].contains("Sunday")){
                dates[0] = "0";
            }
            
            //return new String[] {dates[2],dates[3]};
            dateStrings = new String[] {dates[0],dates[1]};
            
            System.out.println(dateStrings[0]+" "+dateStrings[1]);
            String [] lastDay = dateStrings[1].split("-");
            
            //0 = mon, 5-6 = sat-sun
            int currDay = Integer.parseInt(dateStrings[0]);
            
            
            String finalString = "";
            
            //Add spaces at beginning based on starting day
            if(!dateStrings[0].contains("0")){  //add spaces if day is not Sunday
                for(int n=0;n<Integer.parseInt(dateStrings[0])-1;n++){
                    finalString+=" @@";
                }
            }
            
            
            for(int n=0;n<Integer.parseInt(lastDay[2]);n++){
                if(includeWeekends){
                    finalString+=(n+1)+"@@";
                }else{
                    if(currDay != 0 && currDay != 6){
                        finalString+=(n+1)+"@@";
                    }else{
                        //finalString+=" "+"@@";
                        System.out.println("It's sat/sun. skipping");
                    }
                }
                
                
                if(currDay+1 > 6){
                    currDay = 0;
                }else{
                    currDay++;
                }
            }
            
            //System.err.println("Final dates: "+finalString);
            
            return finalString;
        }else{
            
        }
        return null;
    }
    public String [] return_values(String select,String from,String where,int [] order){
        String [] lines;
        String cLine;
        
        try {
            String url = myVariables.getIpAddress()+"returnValues.php?select="+select+"&from="+from+"&where="+where;
            //System.out.println(url);
            url = url.replace("%", "%25");
            url = url.replace(" ", "%20");
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            // optional default is GET
            con.setRequestMethod("GET");
            //add request header
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);
            
            if(responseCode != 200){
                JOptionPane.showMessageDialog(null, "Server Error. Please check your connection.");
                return null;
            }
            
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
               response.append(inputLine);
            }
            in.close();
            //print in String
            //System.out.println(response.toString());
            

            //Read JSON response and print
            JSONObject myResponse = new JSONObject(response.toString());
            JSONArray res = myResponse.getJSONArray("result");
            
            //Get column names
            
            
            
            if(res.length() > 0){
                //Get column names
                JSONObject sample = res.getJSONObject(0);
                cLine = "";
                
                //Display column index & name
                for(int n=0;n<sample.names().length();n++){
                    System.out.println(n+" "+sample.names().getString(n));
                }
                
                //Get values based on column name keys
                for(int n=0;n<res.length();n++){
                    JSONObject row = res.getJSONObject(n);
                    String temp = "";
                    for(int x=0;x<order.length;x++){
                        //System.err.println(row.names().getString(order[x]));
                        temp+=row.getString(row.names().getString(order[x]))+"@@";
                    }
                    cLine+=temp+"//";
                }
                lines = cLine.split("//");
                return lines;
            }else{
                System.err.println("No result");
            }
        } catch (Exception e) {
            System.err.println("Exception Found "+e.getLocalizedMessage());
        }
        
        return null;
    }
    //</editor-fold>
    //<editor-fold desc="Show Message Functions">
    public void showMessage(String message,int messageType){
        JFrame frem = new JFrame();
        frem.setAlwaysOnTop(true);
        ImageIcon ic = null;
        try {
            switch(messageType){
                case JOptionPane.PLAIN_MESSAGE:{
                    ic = getImageIcon(myVariables.getMsgUrlIcon());break;
                }case JOptionPane.INFORMATION_MESSAGE:{
                    ic = getImageIcon(myVariables.getMsgUrlIconSuccess());break;
                }case JOptionPane.ERROR_MESSAGE:{
                    ic = getImageIcon(myVariables.getMsgUrlIconFailed());break;
                }case JOptionPane.WARNING_MESSAGE:{
                    ic = getImageIcon(myVariables.getMsgUrlIconWarning());break;
                }
            }
            JOptionPane.showMessageDialog(frem, message, "Message",messageType,ic);
        } catch (Exception e) {
            System.err.println("No Icon found.");
            JOptionPane.showMessageDialog(frem, message, "Message", messageType);
        }
    }
    protected boolean getConfirmation(String message){
        JFrame frem = new JFrame();
        frem.setAlwaysOnTop(true);
        int choice = -1;
        try {
            choice = JOptionPane.showConfirmDialog(
                    frem,
                    message,
                    "Confirm Choice",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    getImageIcon(myVariables.getConfirmUrlIcon())
            );
        } catch (Exception e) {
            System.err.println("No Icons found.");
            choice = JOptionPane.showConfirmDialog(frem, message, "Confirm Choice", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        }
        System.err.println("Choice: "+choice);
        if(choice == JOptionPane.YES_OPTION){
            return true;
        }
        return false;
    }
    private ImageIcon getImageIcon(String fileDir){
        ImageIcon ii= new ImageIcon(getClass().getResource(fileDir));
        
        return ii;
    }
    //</editor-fold>
}

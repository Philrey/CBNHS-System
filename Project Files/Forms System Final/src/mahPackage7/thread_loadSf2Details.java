/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackage7;

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
        String dateLine = "-@@-@@-@@-@@-@@-@@-@@-@@"+getStartAndEndDates(dateSelected, false);
        Thread.sleep(pauseDelay);
        //Get Attendance PerStudent
        //Match attendance date with day columns
        //COunt Present Absent & Tardy
        
        return null;
    }

    @Override
    protected void done() {
        
        super.done(); //To change body of generated methods, choose Tools | Templates.
    }
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
        String [] result = return_values("functionsoutput.id,functionsoutput.name,getStartingDay('"+dateT+"') as 'startingDay',getLastDay('"+dateT+"') as 'lastDay'", "functionsoutput", "", new int [] {3,1,2,0});
        String [] dateStrings = null;
        if(result != null){
            //Convert day name to number
            String [] dates = result[0].split("@@");
            if(dates[2].contains("Monday")){
                dates[2] = "1";
            }
            if(dates[2].contains("Tuesday")){
                dates[2] = "2";
            }
            if(dates[2].contains("Wednesday")){
                dates[2] = "3";
            }
            if(dates[2].contains("Thursday")){
                dates[2] = "4";
            }
            if(dates[2].contains("Friday")){
                dates[2] = "5";
            }
            if(dates[2].contains("Saturday")){
                dates[2] = "6";
            }
            if(dates[2].contains("Sunday")){
                dates[2] = "0";
            }
            
            //return new String[] {dates[2],dates[3]};
            dateStrings = new String[] {dates[2],dates[3]};
            
            System.out.println(dateStrings[0]+" "+dateStrings[1]);
            String [] lastDay = dateStrings[1].split("-");
            
            //0 = mon, 5-6 = sat-sun
            int currDay = Integer.parseInt(dateStrings[0]);
            
            
            String finalString = "";
            
            //Add spaces at beginning based on starting day
            for(int n=0;n<Integer.parseInt(dateStrings[0]);n++){
                finalString+=" @@";
            }
            
            for(int n=0;n<Integer.parseInt(lastDay[2]);n++){
                if(includeWeekends){
                    finalString+=(n+1)+"@@";
                }else{
                    if(currDay != 0 && currDay != 6){
                        finalString+=(n+1)+"@@";
                    }else{
                        finalString+=" "+"@@";
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

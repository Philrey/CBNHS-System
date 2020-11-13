/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackage7;

import java.awt.Dialog;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.SwingWorker;

/**
 *
 * @author Phil Rey Paderogao
 */
public class thread_calculate_age extends SwingWorker<String, Object>{
    long threadDelay = 500;
    
    //Main Variables
    private JTable tableName;
    private int birthdateTableColumnIndex;
    private String firstFridayOfJuneDate;
    private boolean waitForMainThreadToFinish;
    //Dialog Properties
    private JDialog dialog;
    private JFrame jFrameName;
    private JPanel dialogPanel;
    private JLabel lbLoadingMessage;
    private JProgressBar progressBar;

    public thread_calculate_age(JTable tableName, int birthdateTableColumnIndex, String firstFridayOfJuneDate, boolean waitForMainThreadToFinish) {
        this.tableName = tableName;
        this.birthdateTableColumnIndex = birthdateTableColumnIndex;
        this.waitForMainThreadToFinish = waitForMainThreadToFinish;
        this.firstFridayOfJuneDate = firstFridayOfJuneDate;
        
        jFrameName = myVariables.getCurrentLoadingFrame();
        dialogPanel = myVariables.getLoadingPanel();
        lbLoadingMessage = myVariables.getLbLoadingMessage();
        progressBar = myVariables.getProgressBar();
    }
    
    @Override
    protected String doInBackground() throws Exception {
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
        showCustomDialog("Calculating Students' Age...", dialogPanel, false, 320, 220, false);
        System.err.println("Starting Second THread");
        
        //set variables displayed
        lbLoadingMessage.setText("Starting Thread...");
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        progressBar.setValue(0);
        Thread.sleep(1000);
        int rowCount = tableName.getRowCount();
        for(int n=0;n<rowCount;n++){
            lbLoadingMessage.setText("Processing Age of Student "+(n+1)+" of "+rowCount);
            String birthDate = tableName.getValueAt(n, birthdateTableColumnIndex).toString();
            String age = getAgeInYearsMonths(firstFridayOfJuneDate, birthDate, false);
            
            tableName.setValueAt(age, n, birthdateTableColumnIndex+1);
            
            
            Thread.sleep(threadDelay);
        }
        
        return null;
    }

    @Override
    protected void done() {
        closeCustomDialog();
        super.done(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getAgeInYearsMonths(String dateConducted,String dateOfBirth,boolean includeMonths){
        String dateCon [] = dateConducted.split("-");
        String dateOfBrth [] = dateOfBirth.split("-");
        
        int yearConducted = Integer.parseInt(dateCon[0]);
        int monthConducted = Integer.parseInt(dateCon[1]);
        int yearBday = Integer.parseInt(dateOfBrth[0]);
        int monthBday = Integer.parseInt(dateOfBrth[1]);
        
        String finalAge = "";
        if(monthConducted<monthBday){
            finalAge = includeMonths?(yearConducted-yearBday-1)+": "+((12+monthConducted)-monthBday) : String.valueOf(yearConducted-yearBday-1);
        }else{
            finalAge = includeMonths?(yearConducted-yearBday)+": "+(monthConducted-monthBday) : String.valueOf(yearConducted-yearBday);
        }
        return finalAge;
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

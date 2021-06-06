/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackage4;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

/**
 *
 * @author CIC
 */
public class thread_loadStudentAndGrades extends SwingWorker<String, Object>{
    long threadDelay = 100;
    long pauseDelay = 500;
    
    //Main Variables
    JTable enrolledStudentsTable;
    String sectionId;
    String subjectId;
    String adviserId;
    
    int fileTypeSelected;
    
    JButton btnRefresh;
    
    
    //Dialog Properties
    myFunctions my;
    private JLabel lbLoadingMessage;
    private JProgressBar progressBar;
    
    public thread_loadStudentAndGrades(JTable [] tablesToUse,String [] stringsToUse,JTextField [] textFieldsToUse,JButton [] buttonsToUse,boolean [] booleansToUse) {
        my = new myFunctions(true);
        //Main Variables
        enrolledStudentsTable = tablesToUse[0];
        fileTypeSelected = Integer.parseInt(stringsToUse[0]);
        
        btnRefresh = buttonsToUse[0];
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
        btnRefresh.setEnabled(false);
        
        //#1 Load Students based on section id
        //#2 Load grades based on section id and subjectId
        
        return "Finished";
    }

    @Override
    protected void done() {
        btnRefresh.setEnabled(true);
        super.done(); //To change body of generated methods, choose Tools | Templates.
    }
}

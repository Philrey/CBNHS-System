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
    String teacherId;
    String subjectId;
    
    JButton btnRefresh;
    
    
    //Dialog Properties
    myFunctions my;
    private JLabel lbLoadingMessage;
    private JProgressBar progressBar;
    
    public thread_loadStudentAndGrades(JTable [] tablesToUse,String [] stringsToUse,JTextField [] textFieldsToUse,JButton [] buttonsToUse,boolean [] booleansToUse) {
        my = new myFunctions(true);
        //Main Variables
        enrolledStudentsTable = tablesToUse[0];
        
        sectionId = stringsToUse[0];
        teacherId = stringsToUse[1];
        subjectId = stringsToUse[2];
        
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
        lbLoadingMessage.setText("Loading...");
        my.clear_table_rows(enrolledStudentsTable);
        
        //#1 Load Students based on section id
        int arrLength;
        String [] result = my.return_values(
                "*", "v_enrollment_minimal", "WHERE sectionId='"+sectionId+"'",
                myVariables.getEnrollmentViewMinimalOrder()
        );
        arrLength = result.length;
        if(result == null){
            return "No Students Found on this Section";
        }
        //#1.1 Combine all studentIds for search Ex: 12,123,12,54,645
        String studentIds = "";
        
        for(int n=0;n<result.length;n++){
            studentIds+=my.getValueAtColumn(result[n], 1);
            if(n<arrLength-1){
                studentIds+=",";
            }
        }
        
        //#2 Load grades based on section id and subjectId
        String [] result2 = my.return_values(
            "*", "v_grades",
            "WHERE sectionId='"+sectionId+"' AND subjectId='"+subjectId+"' AND teacherId='"+teacherId+"' AND studentId IN ("+studentIds+")",
            myVariables.getGradesOrder()
        );
        
        //#3 Load Everything to table
        for (int n = 0; n < result.length; n++) {
            result[n] = my.toNameFormat(result[n], new int[]{3,4,5});
            my.add_table_row(
                my.skipColumns(result[n], new int []{6})+"-1@@--@@--@@--@@--@@--@@--@@--@@",
                enrolledStudentsTable
            );
        }
        return "Loading Complete";
    }

    @Override
    protected void done() {
        try {
            lbLoadingMessage.setText(this.get());
        } catch (Exception e) {
            lbLoadingMessage.setText("Loading Failed.");
        }
        btnRefresh.setEnabled(true);
        super.done(); //To change body of generated methods, choose Tools | Templates.
    }
}

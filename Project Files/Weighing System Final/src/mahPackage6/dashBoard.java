/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackage6;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Phil Rey Paderogao
 */
public class dashBoard extends javax.swing.JFrame {

    myFunctions my;
    public dashBoard() {
        my = new myFunctions();
        initComponents();
        
        lbLoggedInUser.setText("Welcome "+myVariables.getUserLoggedInName()+" ("+myVariables.getAccessLevelName(-1)+")");
        
        loadTabs();
        loadTabIcons();
        
        loadColoredButtons();
        loadLabels();
        
        loadTextFields();
        sortTables();
        
        setScrollSpeeds();
        loadYearDropDowns(12);
        
        lbSchoolName.setText(myVariables.getSchoolName() + " Weighing System");
        lbSchoolAddress.setText(myVariables.getSchoolAddress());
    }

    //<editor-fold desc="Custom Functions"> 
    JDialog dialog;
    JDialog seconDaryDialog;
    
    private void showCustomDialog(String title, JPanel customPanel, boolean isModal, int width, int height, boolean isResizable){
        dialog = new JDialog(this);
        dialog.setTitle(title);
        dialog.add(customPanel);
        dialog.setModal(isModal);
        dialog.setSize(width, height);
        dialog.setResizable(isResizable);
        
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }
    private void closeCustomDialog(){
        if(dialog != null){
            dialog.dispose();
        }else{
            System.err.println("Dialog is null...skipping");
        }
    }
    //Use only when making two jdialogs overlap
    private void showSecondaryCustomDialog(String title, JPanel customPanel, boolean isModal, int width, int height, boolean isResizable){
        seconDaryDialog = new JDialog(this);
        seconDaryDialog.setTitle(title);
        seconDaryDialog.add(customPanel);
        seconDaryDialog.setModal(isModal);
        seconDaryDialog.setSize(width, height);
        seconDaryDialog.setResizable(isResizable);
        
        seconDaryDialog.setLocationRelativeTo(this);
        seconDaryDialog.setVisible(true);
    }
    private void closeSecondaryCustomDialog(){
        if(seconDaryDialog != null){
            seconDaryDialog.dispose();
        }else{
            System.err.println("Dialog is null...skipping");
        }
    }
    
    private void setScrollSpeeds(){
        JScrollPane scrollpanes [] = {
            jScrollPane2,jScrollPane7,jScrollPane9,
        };
        
        int scrollSpeed = 15;
        
        for(int n=0;n<scrollpanes.length;n++){
            scrollpanes[n].getVerticalScrollBar().setUnitIncrement(scrollSpeed);
            scrollpanes[n].getHorizontalScrollBar().setUnitIncrement(scrollSpeed);
        }
    }
    private void sortTables(){
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        
        //Center Tables
        //my.centerTable(studentTable, centerRenderer);
        
        //Hide Table Columns
        if(!myVariables.isDebugModeOn()){
            my.hideColumns(assignedTeacherTable, new int [] {0,1,3,6});
            my.hideColumns(enrolledStudentsTable, new int [] {0,1,6});
            
            my.hideColumns(bmiChartMaleTable, new int [] {0});
            my.hideColumns(bmiChartFemaleTable, new int [] {0});
            my.hideColumns(hfaChartMaleTable, new int [] {0});
            my.hideColumns(hfaChartFemaleTable, new int [] {0});
        }
        
        //Set table fonts
        JTable tables [] = {
            assignedTeacherTable,
            enrolledStudentsTable,
            bmiChartMaleTable,bmiChartFemaleTable,
            hfaChartMaleTable,hfaChartFemaleTable,
        };
        //customizeTableColumnColors(sf1SectionTable, new int [] {0,1,2,3}, Color.RED,Color.WHITE,new Font("Segoe UI",Font.PLAIN,11),true);
        //customHeaders(sf1SectionTable, new int []{0,1,2,3}, Color.RED, Color.WHITE, new Font("Comic Sans MS", Font.BOLD, 12), true);
        for(int n=0;n<tables.length;n++){
            tables[n].getTableHeader().setFont(myVariables.COLUMN_HEADER_FONT);
            tables[n].setFont(myVariables.COLUMN_FONT);
            
            tables[n].setSelectionBackground(new Color(22,66,33));
            tables[n].setSelectionForeground(Color.WHITE);
            tables[n].setRowHeight(20);
            
            //Center Tables
            my.centerTable(tables[n], centerRenderer);
            
            //Clear Tables
            my.clear_table_rows(tables[n]);
            
            //tables[n].setAutoCreateRowSorter(true);
        }
        
    }
    private void loadTabs(){
        mainTab.add("Select Managed Section",selectSectionTab);
        mainTab.add("View Students",viewStudentsTab);
        
        mainTab.setFont(myVariables.TAB_HEADER_FONT);
    }
    private void loadTabIcons(){
        Icon tabIcons [] = {
            my.getImgIcn(myVariables.getSectionsIcon()),
            my.getImgIcn(myVariables.getViewStudentsIcon()),
        };
        
        for(int n=0;n<tabIcons.length;n++){
            mainTab.setIconAt(n,tabIcons[n]);
        }
        
        my.remove_multiple_tabs(mainTab, new int [] {1,2});
    }
    private void loadColoredButtons(){
        JButton buttons [] = {
            //Select Section
            btnSearchSection,
            //View Students
            btnSearchEnrolledStudent,btnEvaluate,
            btnSaveEvaluationChanges,
            btnEvaluateTest,
            btnRefreshBmi,btnRefreshHfa,
        };
        
        JButton lightButtons [] = {
            btnMyManagedSubjects,
        };
        Cursor tempC;
        for(int n=0;n<buttons.length;n++){
            buttons[n].setUI(new custom_styledButtonIU());
            //buttons[n].setBackground(new Color(22,66,33));
            buttons[n].setBackground(new Color(22,66,33));
            buttons[n].setForeground(Color.WHITE);            
            buttons[n].setFont(myVariables.BUTTON_FONT);
            //buttons[n].setCursor(my.getCursor(myVariables.getHandCursor()));
            buttons[n].setCursor(new Cursor(Cursor.HAND_CURSOR));
            buttons[n].setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        
        for(int n=0;n<lightButtons.length;n++){
            lightButtons[n].setUI(new custom_styledButtonIU());
            //buttons[n].setBackground(new Color(22,66,33));
            lightButtons[n].setBackground(Color.WHITE);
            lightButtons[n].setForeground(new Color(22,66,33));            
            lightButtons[n].setFont(myVariables.BUTTON_FONT);
            //buttons[n].setCursor(my.getCursor(myVariables.getHandCursor()));
            lightButtons[n].setCursor(new Cursor(Cursor.HAND_CURSOR));
            lightButtons[n].setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
    }
    private void loadLabels(){
        JLabel titleHeaderLabels [] = {
            jLabel35,jLabel36,
        };
        JLabel labels [] = {
            lbSearchResult,lbSearchResult1,
        };
        
        JLabel formsHeaderLabels [] = {
            jLabel14,jLabel16,jLabel18,jLabel1,jLabel2,jLabel3,jLabel4,jLabel28,
        };
        JLabel textFieldHeaderLabels [] = {
            jLabel12,jLabel23,jLabel15,jLabel17,jLabel22,jLabel24,jLabel19,
            jLabel20,jLabel5,jLabel6,jLabel7,jLabel8,jLabel13,jLabel25,jLabel26,
            jLabel9,jLabel11,lbNutritionalStatus,lbHeightForAge,jLabel27,
        };
        
        for (JLabel n : titleHeaderLabels) {
            n.setFont(myVariables.TITLE_HEADER_FONT);
            n.setForeground(Color.WHITE);
        }
        
        for(JLabel n : labels){
            n.setFont(myVariables.LABEL_FONT);
            n.setForeground(Color.WHITE);
        }
        
        for(JLabel n : formsHeaderLabels){
            n.setFont(myVariables.FORMS_HEADER_FONT);
            n.setForeground(Color.BLACK);
        }
        
        for(JLabel n : textFieldHeaderLabels){
            n.setFont(myVariables.TEXTFIELD_HEADER_FONT);
            n.setForeground(Color.BLACK);
        }
    }
    private void loadTextFields(){
        JDateChooser dateChoosers [] = {
            jdcDateOfMeasurement,jdcTestDateOfMeasurement,jdcTestDateOfBirt,
        };
        JSpinner spinners [] = {
            //jsHours,jsMinutes
        };
        
        JTextField searchFields [] = {
            tfSearchTeacherLoad,tfSearchEnrolledStudent,
        };
        JTextField forms [] = {
            tfAge,tfWeight,tfHeight,tfBmi,tfHeightSquared,tfBmiForAge,
            tfHeightForAge,tfTestAge,tfTestHeight,tfTestHeightSq,tfTestWeight,
            tfTestBmi,
        };
        for(JSpinner n : spinners){
            n.setFont(myVariables.TEXTFIELD_FONT);
        }
        for(JDateChooser n : dateChoosers){
            n.setFont(myVariables.TEXTFIELD_FONT);
            n.setDateFormatString("yyyy-MM-dd");
        }
        for(JTextField n : searchFields){
            n.setFont(myVariables.SEARCH_TEXTFIELD_FONT);
        }
        for(JTextField n : forms){
            n.setFont(myVariables.TEXTFIELD_FONT);
        }
    }
    private void loadYearDropDowns(int numberOfYears){
        JComboBox [] yearDropDowns = {
            
        };
        
        JComboBox [] yearDropDownsWithAllOption = {
            jcbSchoolYear1,
        };
        JComboBox [] dropDowns = {
            jcbTestGender,
        };
        int startingYear = 2019;
        
        for(JComboBox n : yearDropDowns){
            n.removeAllItems();
            n.setFont(myVariables.TEXTFIELD_FONT);
            for(int x=0;x<numberOfYears;x++){
                n.addItem(String.valueOf(startingYear+x));
            }
        }
        for(JComboBox n : yearDropDownsWithAllOption){
            n.removeAllItems();
            n.setFont(myVariables.TEXTFIELD_FONT);
            n.addItem("All");
            for(int x=0;x<numberOfYears;x++){
                n.addItem(String.valueOf(startingYear+x));
            }
        }
        for(JComboBox n : dropDowns){
            n.setFont(myVariables.TEXTFIELD_FONT);
        }
    }
    //</editor-fold>
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selectSectionTab = new javax.swing.JPanel();
        lbSearchResult = new javax.swing.JLabel();
        tfSearchTeacherLoad = new javax.swing.JTextField();
        btnSearchSection = new javax.swing.JButton();
        jcbSchoolYear1 = new javax.swing.JComboBox<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        assignedTeacherTable = new javax.swing.JTable();
        viewStudentsTab = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        left = new javax.swing.JPanel();
        lbSearchResult1 = new javax.swing.JLabel();
        tfSearchEnrolledStudent = new javax.swing.JTextField();
        btnSearchEnrolledStudent = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        enrolledStudentsTable = new javax.swing.JTable();
        right = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tfAge = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tfWeight = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        tfHeight = new javax.swing.JTextField();
        btnEvaluate = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tfBmiForAge = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        tfHeightForAge = new javax.swing.JTextField();
        btnSaveEvaluationChanges = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        lbBmiRecordId = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jdcDateOfMeasurement = new com.toedter.calendar.JDateChooser();
        tfHeightSquared = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        tfBmi = new javax.swing.JTextField();
        referenceChartsDialog = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jSplitPane2 = new javax.swing.JSplitPane();
        left1 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        bmiChartMaleTable = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        bmiChartFemaleTable = new javax.swing.JTable();
        btnRefreshBmi = new javax.swing.JButton();
        right1 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        tfTestHeightSq = new javax.swing.JTextField();
        tfTestAge = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        btnEvaluateTest = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lbNutritionalStatus = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbHeightForAge = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jcbTestGender = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jdcTestDateOfBirt = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jdcTestDateOfMeasurement = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        tfTestWeight = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfTestHeight = new javax.swing.JTextField();
        tfTestBmi = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        hfaChartMaleTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        hfaChartFemaleTable = new javax.swing.JTable();
        btnRefreshHfa = new javax.swing.JButton();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        headerPanel = new javax.swing.JPanel();
        lbSchoolName = new javax.swing.JLabel();
        lbSchoolAddress = new javax.swing.JLabel();
        lbLoggedInUser = new javax.swing.JLabel();
        btnMyManagedSubjects = new javax.swing.JButton();
        mainTab = new javax.swing.JTabbedPane();

        selectSectionTab.setBackground(new java.awt.Color(11, 102, 35));

        lbSearchResult.setForeground(new java.awt.Color(255, 255, 255));
        lbSearchResult.setText("Search using the search bar...");

        tfSearchTeacherLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchSectionHandler(evt);
            }
        });

        btnSearchSection.setText("Search");
        btnSearchSection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchSectionHandler(evt);
            }
        });

        jcbSchoolYear1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2019", "2020" }));

        assignedTeacherTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Section ID", "Section Name", "Adv ID", "Name", "Gender", "Subject ID", "Code", "Description", "Grade", "School Year"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        assignedTeacherTable.getTableHeader().setReorderingAllowed(false);
        assignedTeacherTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                assignedTeacherTableMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(assignedTeacherTable);

        javax.swing.GroupLayout selectSectionTabLayout = new javax.swing.GroupLayout(selectSectionTab);
        selectSectionTab.setLayout(selectSectionTabLayout);
        selectSectionTabLayout.setHorizontalGroup(
            selectSectionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectSectionTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(selectSectionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
                    .addGroup(selectSectionTabLayout.createSequentialGroup()
                        .addComponent(lbSearchResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbSchoolYear1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSearchTeacherLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchSection)))
                .addContainerGap())
        );
        selectSectionTabLayout.setVerticalGroup(
            selectSectionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectSectionTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(selectSectionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSearchResult)
                    .addComponent(tfSearchTeacherLoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchSection)
                    .addComponent(jcbSchoolYear1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane1.setBorder(null);
        jSplitPane1.setDividerLocation(600);

        left.setBackground(new java.awt.Color(11, 102, 35));

        lbSearchResult1.setForeground(new java.awt.Color(255, 255, 255));
        lbSearchResult1.setText("Search using the search bar...");

        tfSearchEnrolledStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchEnrolledStudentHandler(evt);
            }
        });

        btnSearchEnrolledStudent.setText("Search");
        btnSearchEnrolledStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchEnrolledStudentHandler(evt);
            }
        });

        enrolledStudentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Student ID", "LRN", "Name", "Gender", "Birth Date", "Section ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        enrolledStudentsTable.getTableHeader().setReorderingAllowed(false);
        enrolledStudentsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                enrolledStudentsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(enrolledStudentsTable);

        javax.swing.GroupLayout leftLayout = new javax.swing.GroupLayout(left);
        left.setLayout(leftLayout);
        leftLayout.setHorizontalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(leftLayout.createSequentialGroup()
                        .addComponent(lbSearchResult1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSearchEnrolledStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchEnrolledStudent)))
                .addContainerGap())
        );
        leftLayout.setVerticalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSearchResult1)
                    .addComponent(tfSearchEnrolledStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchEnrolledStudent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(left);

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        jPanel7.setBackground(new java.awt.Color(22, 66, 33));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("View Student Details");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel12.setText("Age (years, months)");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Basic");

        tfAge.setEditable(false);

        jLabel15.setText("Weight (kg)");

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Nutrional Status Properties");

        jLabel17.setText("Height (m)");

        btnEvaluate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage6/icons/icons8_calculate_16px.png"))); // NOI18N
        btnEvaluate.setText("Evaluate");
        btnEvaluate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEvaluateActionPerformed(evt);
            }
        });

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Results");

        jLabel19.setText("Bmi For Age");

        tfBmiForAge.setEditable(false);

        jLabel20.setText("Height For Age");

        tfHeightForAge.setEditable(false);

        btnSaveEvaluationChanges.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage6/icons/icons8_save_16px.png"))); // NOI18N
        btnSaveEvaluationChanges.setText("Save Evaluation");
        btnSaveEvaluationChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveEvaluationChangesActionPerformed(evt);
            }
        });

        jLabel21.setText("Record ID :");

        lbBmiRecordId.setText("0");

        jLabel23.setText("Date of Measurement");

        tfHeightSquared.setEditable(false);

        jLabel22.setText("Height (m^2)");

        jLabel24.setText("BMI");

        tfBmi.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbBmiRecordId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSaveEvaluationChanges, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEvaluate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfBmiForAge)
                    .addComponent(tfHeightForAge)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                    .addComponent(tfWeight)
                                    .addComponent(tfHeight, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfHeightSquared)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfBmi, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(tfAge, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdcDateOfMeasurement, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(lbBmiRecordId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcDateOfMeasurement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfBmi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfHeightSquared, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEvaluate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfBmiForAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfHeightForAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btnSaveEvaluationChanges)
                .addContainerGap())
        );

        jScrollPane2.setViewportView(jPanel2);

        javax.swing.GroupLayout rightLayout = new javax.swing.GroupLayout(right);
        right.setLayout(rightLayout);
        rightLayout.setHorizontalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
        );
        rightLayout.setVerticalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );

        jSplitPane1.setRightComponent(right);

        javax.swing.GroupLayout viewStudentsTabLayout = new javax.swing.GroupLayout(viewStudentsTab);
        viewStudentsTab.setLayout(viewStudentsTabLayout);
        viewStudentsTabLayout.setHorizontalGroup(
            viewStudentsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
        );
        viewStudentsTabLayout.setVerticalGroup(
            viewStudentsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        referenceChartsDialog.setBackground(new java.awt.Color(255, 255, 204));

        jPanel8.setBackground(new java.awt.Color(22, 66, 33));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Reference Charts");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSplitPane2.setDividerLocation(460);

        jScrollPane9.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setText("Nutritional Status (Boys)");

        bmiChartMaleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Age", "Months", "SVR Wasted", "Wasted", "Normal", "Overweight", "Obese"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bmiChartMaleTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(bmiChartMaleTable);
        if (bmiChartMaleTable.getColumnModel().getColumnCount() > 0) {
            bmiChartMaleTable.getColumnModel().getColumn(7).setHeaderValue("Obese");
        }

        jLabel28.setText("Nutritional Status (Girls)");

        bmiChartFemaleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Age", "Months", "SVR Wasted", "Wasted", "Normal", "Overweight", "Obese"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bmiChartFemaleTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(bmiChartFemaleTable);
        if (bmiChartFemaleTable.getColumnModel().getColumnCount() > 0) {
            bmiChartFemaleTable.getColumnModel().getColumn(7).setHeaderValue("Obese");
        }

        btnRefreshBmi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage6/icons/icons8_sync_16px.png"))); // NOI18N
        btnRefreshBmi.setText("Refresh");
        btnRefreshBmi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshBmiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefreshBmi)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefreshBmi)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane9.setViewportView(jPanel3);

        javax.swing.GroupLayout left1Layout = new javax.swing.GroupLayout(left1);
        left1.setLayout(left1Layout);
        left1Layout.setHorizontalGroup(
            left1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9)
        );
        left1Layout.setVerticalGroup(
            left1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
        );

        jSplitPane2.setLeftComponent(left1);

        right1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel25.setText("Height^2");

        tfTestHeightSq.setEditable(false);
        tfTestHeightSq.setFocusable(false);

        tfTestAge.setEditable(false);
        tfTestAge.setFocusable(false);

        jLabel26.setText("Age");

        btnEvaluateTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage6/icons/icons8_calculate_16px.png"))); // NOI18N
        btnEvaluateTest.setText("Evaluate");
        btnEvaluateTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEvaluateTestActionPerformed(evt);
            }
        });

        jLabel9.setText("Nutritional Status :");

        lbNutritionalStatus.setText("RESULT");

        jLabel11.setText("Height-For-Age :");

        lbHeightForAge.setText("RESULT");

        jLabel13.setText("Gender");

        jcbTestGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Formula Tester");

        jLabel5.setText("Date of Birth");

        jLabel6.setText("Date of Measurement");

        jLabel7.setText("Weight (kg)");

        jLabel8.setText("Height (m)");

        tfTestBmi.setEditable(false);
        tfTestBmi.setFocusable(false);

        jLabel27.setText("BMI");

        javax.swing.GroupLayout right1Layout = new javax.swing.GroupLayout(right1);
        right1.setLayout(right1Layout);
        right1Layout.setHorizontalGroup(
            right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(right1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEvaluateTest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(right1Layout.createSequentialGroup()
                        .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNutritionalStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbHeightForAge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, right1Layout.createSequentialGroup()
                        .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, right1Layout.createSequentialGroup()
                                    .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tfTestWeight)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfTestAge, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jdcTestDateOfBirt, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(right1Layout.createSequentialGroup()
                                .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                                    .addComponent(tfTestHeight))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfTestHeightSq, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jdcTestDateOfMeasurement, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jcbTestGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tfTestBmi, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        right1Layout.setVerticalGroup(
            right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(right1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(right1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdcTestDateOfBirt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(right1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdcTestDateOfMeasurement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, right1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfTestWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(right1Layout.createSequentialGroup()
                            .addComponent(jLabel26)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfTestAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, right1Layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addGap(26, 26, 26))
                        .addGroup(right1Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jcbTestGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(right1Layout.createSequentialGroup()
                                .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel25))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfTestHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfTestHeightSq, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(tfTestBmi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEvaluateTest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lbNutritionalStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lbHeightForAge))
                .addContainerGap())
        );

        jSplitPane2.setRightComponent(right1);

        jScrollPane7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel2.setText("Height-For-Age (Boys)");

        hfaChartMaleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Age", "Months", "SVR Stunted", "Stunted", "Normal", "Tall"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        hfaChartMaleTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(hfaChartMaleTable);

        jLabel3.setText("Height-For-Age (Girls)");

        hfaChartFemaleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Age", "Months", "SVR Stunted", "Stunted", "Normal", "Tall"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        hfaChartFemaleTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(hfaChartFemaleTable);

        btnRefreshHfa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage6/icons/icons8_sync_16px.png"))); // NOI18N
        btnRefreshHfa.setText("Refresh");
        btnRefreshHfa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshHfaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefreshHfa)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefreshHfa)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane7.setViewportView(jPanel1);

        javax.swing.GroupLayout referenceChartsDialogLayout = new javax.swing.GroupLayout(referenceChartsDialog);
        referenceChartsDialog.setLayout(referenceChartsDialogLayout);
        referenceChartsDialogLayout.setHorizontalGroup(
            referenceChartsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
            .addGroup(referenceChartsDialogLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
        );
        referenceChartsDialogLayout.setVerticalGroup(
            referenceChartsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(referenceChartsDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSplitPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dashboard");
        setIconImage(my.getImgIcn(myVariables.getWeighingWindowIcon()).getImage()
        );
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                logOutHandler(evt);
            }
        });

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 255, 204));
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 204));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1003, 600));

        headerPanel.setBackground(new java.awt.Color(22, 66, 33));

        lbSchoolName.setBackground(new java.awt.Color(255, 255, 255));
        lbSchoolName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbSchoolName.setForeground(new java.awt.Color(255, 255, 255));
        lbSchoolName.setText("SCHOOL_NAME Weighing System");

        lbSchoolAddress.setBackground(new java.awt.Color(255, 255, 255));
        lbSchoolAddress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbSchoolAddress.setForeground(new java.awt.Color(255, 255, 255));
        lbSchoolAddress.setText("SCHOOL_ADDRESS");

        lbLoggedInUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbLoggedInUser.setForeground(new java.awt.Color(255, 255, 255));
        lbLoggedInUser.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbLoggedInUser.setText("Welcome USER_NAME, ACCESS_LEVEL");

        btnMyManagedSubjects.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage6/icons/icons8_chart_16px.png"))); // NOI18N
        btnMyManagedSubjects.setText("Reference Charts");
        btnMyManagedSubjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyManagedSubjectsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSchoolName, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSchoolAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbLoggedInUser, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnMyManagedSubjects, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSchoolName)
                    .addComponent(lbLoggedInUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSchoolAddress)
                    .addComponent(btnMyManagedSubjects))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        mainTab.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        mainTab.setToolTipText("");
        mainTab.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        mainTab.setMinimumSize(new java.awt.Dimension(100, 100));
        mainTab.setPreferredSize(new java.awt.Dimension(1068, 548));

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainTab, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainTab, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 983, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMyManagedSubjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyManagedSubjectsActionPerformed
        showCustomDialog("Reference Charts", referenceChartsDialog, true, 800, 660,true);
    }//GEN-LAST:event_btnMyManagedSubjectsActionPerformed

    private void assignedTeacherTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_assignedTeacherTableMouseClicked
        if(evt.getClickCount() == 2){
            if(mainTab.getTabCount() <= 1){
                int row = assignedTeacherTable.getSelectedRow();
                
                String subjectName = assignedTeacherTable.getValueAt(row, 8).toString();
                
                mainTab.addTab("View Students", my.getImgIcn(myVariables.getViewStudentsIcon()), viewStudentsTab);
                mainTab.setSelectedIndex(1);
            }
        }else{
            my.clear_table_rows(enrolledStudentsTable);
            my.remove_multiple_tabs(mainTab, new int [] {1,2});
        }
    }//GEN-LAST:event_assignedTeacherTableMouseClicked

    private void enrolledStudentsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enrolledStudentsTableMouseClicked
        if(evt.getClickCount() == 2){
            int row = enrolledStudentsTable.getSelectedRow();
            String studentId = enrolledStudentsTable.getValueAt(row, 1).toString();
            String sectionId = enrolledStudentsTable.getValueAt(row, 6).toString();
            
            String where = "WHERE studentId='"+studentId+"' AND sectionId='"+sectionId+"'";
            
            String result [] = my.return_values("*", "bmi", where, myVariables.getBmiOrder());
            
            if(result != null){
                String values [] = result[0].split("@@");
                String recordId = values[0];
                String age = values[3];
                
                String weight = values[4];
                String height = values[5];
                String heightSquared = values[6];
                
                String bmi = values[7];
                String bmiForAge = values[8];
                String heightForAge = values[9];
                String dateMeasured = values[10];
                
                lbBmiRecordId.setText(recordId);
                tfAge.setText(age);
                
                tfWeight.setText(weight);
                tfHeight.setText(height);
                tfHeightSquared.setText(heightSquared);
                
                tfBmi.setText(bmi);
                tfBmiForAge.setText(bmiForAge);
                tfHeightForAge.setText(heightForAge);
                
                jdcDateOfMeasurement.setDate(my.dateTimeTojCalendarDateFormat(dateMeasured));
                clearBmiFields(false, true, false);
            }else{
                if(my.getConfirmation("This student has no records yet.\nAdd one now?")){
                    String [] values = {
                        "null,'"+studentId+"','"+sectionId+"'",
                    };
                    
                    if(my.add_values("bmi", "id,studentId,sectionId", values)){
                        my.showMessage("Added Successfully. Please select the student again.", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        my.showMessage("Adding Failed! Please make sure you are connected to the School Network.", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }else{
            clearBmiFields(true, false, false);
        }
    }//GEN-LAST:event_enrolledStudentsTableMouseClicked

    private void logOutHandler(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_logOutHandler
        my.openWindow(this, new login());
    }//GEN-LAST:event_logOutHandler

    private void searchSectionHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchSectionHandler
        String toSearch = tfSearchTeacherLoad.getText();
        String schoolYear = jcbSchoolYear1.getSelectedItem().toString();

        my.remove_multiple_tabs(mainTab, new int [] {1,2});

        String where = "WHERE subjectCode LIKE 'ADV%'";

        //Filter search based on Access Level
        switch (myVariables.getAccessLevel()){
            case 1:{    //Teacher or MAPEH Teacher
                where += " AND teacherId='"+myVariables.getUserLoggedInId()+"'";
                break;
            }case 2:{   //Department Head
                /*String managedSubjects = "";

                for(int n=0;n<assignedSubjectsTable.getRowCount();n++){
                    managedSubjects += assignedSubjectsTable.getValueAt(n, 0).toString();
                    if(n < assignedSubjectsTable.getRowCount()-1){
                        managedSubjects+=",";
                    }
                }
                if(managedSubjects.length() > 0){
                    where += " AND subjectId IN ("+managedSubjects+")";
                }else{
                    my.showMessage("You have no subjects assigned to you. Try refreshing again.\nIf the problem persists, please consult your Curruculum Head if you think this is an error.", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                where += " AND teacherId!='-1'";*/
                break;
            }case 4:{
                where += " AND teacherId!='-1'";
                break;
            }case 5:{
                break;
            }
        }

        if(jcbSchoolYear1.getSelectedIndex() != 0){
            where +=" AND schoolYear='"+schoolYear+"'";
        }

        if(toSearch.length() > 0){
            where +=" AND sectionName LIKE '%"+toSearch+"%'";
        }

        String [] result = my.return_values("*", "v_managedsubjects", where, myVariables.getManagedSubjectsViewOrder());

        my.clear_table_rows(assignedTeacherTable);
        if(result == null){
            lbSearchResult.setText("Showing 0 results for '"+toSearch+"'.");
            return;
        }else{
            if(result.length > 1){
                lbSearchResult.setText("Showing "+result.length+" results for '"+toSearch+"'.");
            }else{
                lbSearchResult.setText("Showing "+result.length+" result for '"+toSearch+"'.");
            }
        }

        for(String row : result){
            row = my.toNameFormat(row, new int [] {4,5,6});

            //System.err.println(my.getValueAtColumn(row, 3));
            if(my.getValueAtColumn(row, 3).contains("-1")){
                row = my.setValueAtColumn(row, 4, "None");
            }
            my.add_table_row(row, assignedTeacherTable);
        }
    }//GEN-LAST:event_searchSectionHandler

    private void btnSaveEvaluationChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveEvaluationChangesActionPerformed
        //Get Values & Update
        String recordId = lbBmiRecordId.getText();
        String age = tfAge.getText();
        String dateOfMeasurement = my.jCalendarToNumberDate(jdcDateOfMeasurement.getDate().toString(), true);
        
        String weight = tfWeight.getText();;
        String height = tfHeight.getText();;
        String heightSquared = tfHeightSquared.getText();;
        
        String bmi = tfBmi.getText();;
        String bmiForAge = tfBmiForAge.getText();;
        String heightForAge = tfHeightForAge.getText();
        
        String sets [] = {
            "age='"+age+"'",
            "weight='"+weight+"'",
            "height='"+height+"'",
            "heightSq='"+heightSquared+"'",
            "bmi='"+bmi+"'",
            "bmiForAge='"+bmiForAge+"'",
            "heightForAge='"+heightForAge+"'",
            "dateExamined='"+dateOfMeasurement+"'"
        };
        
        if(my.update_values("bmi", sets, "id='"+recordId+"'")){
            my.showMessage("Update Successful.", JOptionPane.INFORMATION_MESSAGE);
            searchEnrolledStudentHandler(my.getButtonPressedEvent(evt.getSource()));
        }else{
            my.showMessage("Update Failed. Please make sure you are connected to the School Network.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveEvaluationChangesActionPerformed

    private void searchEnrolledStudentHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchEnrolledStudentHandler
        int row = assignedTeacherTable.getSelectedRow();

        if(row == -1){
            my.showMessage("Please select a section first.", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String sectionId = assignedTeacherTable.getValueAt(row, 1).toString();
        String toSearch = tfSearchEnrolledStudent.getText();

        String where = "WHERE sectionId='"+sectionId+"' AND (lrn='"+toSearch+"' OR lName LIKE '%"+toSearch+"%')";
        my.searchItem(where, enrolledStudentsTable, 8, null, new int [] {3,4,5}, true, true, lbSearchResult1, tfSearchEnrolledStudent, true);
        clearBmiFields(true, false, false);
    }//GEN-LAST:event_searchEnrolledStudentHandler

    private void btnEvaluateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEvaluateActionPerformed
        int row = enrolledStudentsTable.getSelectedRow();
        if(row == -1){
            my.showMessage("No Student Selected.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String dateConducted = "";
        String dateOfBirth = "";
        String weight = tfWeight.getText().trim();
        String height = tfHeight.getText().trim();
        String heightSquared = "";
        String bmi = "";
        String gender = enrolledStudentsTable.getValueAt(row, 4).toString();
        
        try {
            dateConducted = my.jCalendarToNumberDate(jdcDateOfMeasurement.getDate().toString(), false);
            dateOfBirth = enrolledStudentsTable.getValueAt(row, 5).toString();
        } catch (Exception e) {my.showMessage("Invalid Date.", JOptionPane.WARNING_MESSAGE);return;}
        try {
            Integer.parseInt(weight);
            Float.parseFloat(height);
        } catch (Exception e) {my.showMessage("Invalid Weight/Height.", JOptionPane.WARNING_MESSAGE);return;}
        
        heightSquared = my.getHeightSquared(height);
        bmi = my.getBmi(weight, heightSquared);
        String ageInYearMonth = my.getAgeInYearsMonths(dateConducted, dateOfBirth);
        String hfa = my.getHeightForAge(height, ageInYearMonth, gender, false);
        String nutritionalStatus = my.getNutritionalStatus(bmi, ageInYearMonth, gender);
        
        tfHeightSquared.setText(heightSquared);
        tfBmi.setText(bmi);
        tfAge.setText(ageInYearMonth);
        tfHeightForAge.setText(hfa);
        tfBmiForAge.setText(nutritionalStatus);
        
        clearBmiFields(false, true, true);
    }//GEN-LAST:event_btnEvaluateActionPerformed

    private void btnEvaluateTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEvaluateTestActionPerformed
        String dateConducted = "";
        String dateOfBirth = "";
        String weight = tfTestWeight.getText().trim();
        String height = tfTestHeight.getText().trim();
        String heightSquared = "";
        String bmi = "";
        int gender = jcbTestGender.getSelectedIndex();
        
        try {
            dateConducted = my.jCalendarToNumberDate(jdcTestDateOfMeasurement.getDate().toString(), false);
            dateOfBirth = my.jCalendarToNumberDate(jdcTestDateOfBirt.getDate().toString(), false);
        } catch (Exception e) {my.showMessage("Invalid Date.", JOptionPane.WARNING_MESSAGE);return;}
        try {
            Integer.parseInt(weight);
            Float.parseFloat(height);
        } catch (Exception e) {my.showMessage("Invalid Weight/Height.", JOptionPane.WARNING_MESSAGE);return;}
        
        heightSquared = my.getHeightSquared(height);
        bmi = my.getBmi(weight, heightSquared);
        String ageInYearMonth = my.getAgeInYearsMonths(dateConducted, dateOfBirth);
        String hfa = my.getHeightForAge(height, ageInYearMonth, gender==0?"Male":"Female", false);
        String nutritionalStatus = my.getNutritionalStatus(bmi, ageInYearMonth, gender==0?"Male":"Female");
        
        tfTestHeightSq.setText(heightSquared);
        tfTestBmi.setText(bmi);
        tfTestAge.setText(ageInYearMonth);
        lbHeightForAge.setText(hfa);
        lbNutritionalStatus.setText(nutritionalStatus);
        
        //Search for age in Table OPTIONAL
        hfaChartMaleTable.clearSelection();
        hfaChartFemaleTable.clearSelection();
        bmiChartMaleTable.clearSelection();
        bmiChartFemaleTable.clearSelection();
        if(gender == 0){
            if(hfaChartMaleTable.getRowCount() > 0){
                for(int n=0;n<hfaChartMaleTable.getRowCount();n++){
                    String currentAge = hfaChartMaleTable.getValueAt(n, 1).toString();
                    if(currentAge.equals(ageInYearMonth)){
                        my.showSelectedRow(hfaChartMaleTable, n);
                        my.showSelectedItemInsideScrollPane(jLabel2,jScrollPane7,10);
                        hfaChartMaleTable.setRowSelectionInterval(n, n);
                    }
                }
            }
            if(bmiChartMaleTable.getRowCount() > 0){
                for(int n=0;n<bmiChartMaleTable.getRowCount();n++){
                    String currentAge = bmiChartMaleTable.getValueAt(n, 1).toString();
                    if(currentAge.equals(ageInYearMonth)){
                        my.showSelectedRow(bmiChartMaleTable, n);
                        my.showSelectedItemInsideScrollPane(jLabel1,jScrollPane9,10);
                        bmiChartMaleTable.setRowSelectionInterval(n, n);
                    }
                }
            }
        }else{
            if(hfaChartFemaleTable.getRowCount() > 0){
                for(int n=0;n<hfaChartFemaleTable.getRowCount();n++){
                    String currentAge = hfaChartFemaleTable.getValueAt(n, 1).toString();
                    if(currentAge.equals(ageInYearMonth)){
                        my.showSelectedRow(hfaChartFemaleTable, n);
                        my.showSelectedItemInsideScrollPane(jLabel3,jScrollPane7,0);
                        hfaChartFemaleTable.setRowSelectionInterval(n, n);
                    }
                }
            }
            if(bmiChartFemaleTable.getRowCount() > 0){
                for(int n=0;n<bmiChartFemaleTable.getRowCount();n++){
                    String currentAge = bmiChartFemaleTable.getValueAt(n, 1).toString();
                    if(currentAge.equals(ageInYearMonth)){
                        my.showSelectedRow(bmiChartFemaleTable, n);
                        my.showSelectedItemInsideScrollPane(jLabel28,jScrollPane9,0);
                        bmiChartFemaleTable.setRowSelectionInterval(n, n);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnEvaluateTestActionPerformed

    private void btnRefreshHfaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshHfaActionPerformed
        refreshHfaChart();
    }//GEN-LAST:event_btnRefreshHfaActionPerformed

    private void btnRefreshBmiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshBmiActionPerformed
        refreshBmiChart();
    }//GEN-LAST:event_btnRefreshBmiActionPerformed
    private void clearBmiFields(boolean clearFields,boolean enableDisableEvaluateBtn,boolean enableDisableSaveBtn){
        if(clearFields){
            lbBmiRecordId.setText("--Please Select A Student--");
            tfAge.setText("");

            tfWeight.setText("");
            tfHeight.setText("");
            tfHeightSquared.setText("");

            tfBmi.setText("");
            tfBmiForAge.setText("--Please Select A Student--");
            tfHeightForAge.setText("--Please Select A Student--");
        }
        btnEvaluate.setEnabled(enableDisableEvaluateBtn);
        btnSaveEvaluationChanges.setEnabled(enableDisableSaveBtn);
    }
    private void refreshBmiChart(){
        String [] result = my.return_values("*", "bmichart_male", "", myVariables.getBmiChartOrder());
        String [] result2 = my.return_values("*", "bmichart_female", "", myVariables.getBmiChartOrder());
        
        my.clear_table_rows(bmiChartMaleTable);
        my.clear_table_rows(bmiChartFemaleTable);
        
        if(result != null){
            for(String n: result){
                my.add_table_row(n+"Above@@", bmiChartMaleTable);
            }
        }if(result2 != null){
            for(String n: result2){
                my.add_table_row(n+"Above@@", bmiChartFemaleTable);
            }
        }
    }
    private void refreshHfaChart(){
        String [] result = my.return_values("*", "hfachart_male", "", myVariables.getHfaChartOrder());
        String [] result2 = my.return_values("*", "hfachart_female", "", myVariables.getHfaChartOrder());
        
        my.clear_table_rows(hfaChartMaleTable);
        my.clear_table_rows(hfaChartFemaleTable);
        
        if(result != null){
            for(String n: result){
                my.add_table_row(n, hfaChartMaleTable);
            }
        }if(result2 != null){
            for(String n: result2){
                my.add_table_row(n, hfaChartFemaleTable);
            }
        }
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dashBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable assignedTeacherTable;
    private javax.swing.JTable bmiChartFemaleTable;
    private javax.swing.JTable bmiChartMaleTable;
    private javax.swing.JButton btnEvaluate;
    private javax.swing.JButton btnEvaluateTest;
    private javax.swing.JButton btnMyManagedSubjects;
    private javax.swing.JButton btnRefreshBmi;
    private javax.swing.JButton btnRefreshHfa;
    private javax.swing.JButton btnSaveEvaluationChanges;
    private javax.swing.JButton btnSearchEnrolledStudent;
    private javax.swing.JButton btnSearchSection;
    private javax.swing.JTable enrolledStudentsTable;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JTable hfaChartFemaleTable;
    private javax.swing.JTable hfaChartMaleTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JComboBox<String> jcbSchoolYear1;
    private javax.swing.JComboBox<String> jcbTestGender;
    private com.toedter.calendar.JDateChooser jdcDateOfMeasurement;
    private com.toedter.calendar.JDateChooser jdcTestDateOfBirt;
    private com.toedter.calendar.JDateChooser jdcTestDateOfMeasurement;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lbBmiRecordId;
    private javax.swing.JLabel lbHeightForAge;
    private javax.swing.JLabel lbLoggedInUser;
    private javax.swing.JLabel lbNutritionalStatus;
    private javax.swing.JLabel lbSchoolAddress;
    private javax.swing.JLabel lbSchoolName;
    private javax.swing.JLabel lbSearchResult;
    private javax.swing.JLabel lbSearchResult1;
    private javax.swing.JPanel left;
    private javax.swing.JPanel left1;
    private javax.swing.JTabbedPane mainTab;
    private javax.swing.JPanel referenceChartsDialog;
    private javax.swing.JPanel right;
    private javax.swing.JPanel right1;
    private javax.swing.JPanel selectSectionTab;
    private javax.swing.JTextField tfAge;
    private javax.swing.JTextField tfBmi;
    private javax.swing.JTextField tfBmiForAge;
    private javax.swing.JTextField tfHeight;
    private javax.swing.JTextField tfHeightForAge;
    private javax.swing.JTextField tfHeightSquared;
    private javax.swing.JTextField tfSearchEnrolledStudent;
    private javax.swing.JTextField tfSearchTeacherLoad;
    private javax.swing.JTextField tfTestAge;
    private javax.swing.JTextField tfTestBmi;
    private javax.swing.JTextField tfTestHeight;
    private javax.swing.JTextField tfTestHeightSq;
    private javax.swing.JTextField tfTestWeight;
    private javax.swing.JTextField tfWeight;
    private javax.swing.JPanel viewStudentsTab;
    // End of variables declaration//GEN-END:variables
}

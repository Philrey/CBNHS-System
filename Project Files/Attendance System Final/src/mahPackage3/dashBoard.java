/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackage3;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
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
 * @author Phil Rey
 */
public class dashBoard extends javax.swing.JFrame {
    myFunctions my;
    timeThread tr;
    public dashBoard() {
        
        my = new myFunctions();
        initComponents();
        
        tr = new timeThread(lbDateTime);
        lbLoggedInUser.setText("Welcome "+myVariables.getUserLoggedInName()+" ("+myVariables.getAccessLevelName(-1)+")");
        //tr.execute();
        
        loadTabs();
        loadTabIcons();
        
        loadColoredButtons();
        loadLabels();
        
        loadTextFields();
        sortTables();
        
        setScrollSpeeds();
        loadYearDropDowns(12);
        
        lbSchoolName.setText(myVariables.getSchoolName() + " Enrollment System");
        lbSchoolAddress.setText(myVariables.getSchoolAddress());
    }
    
    //<editor-fold desc="Custom Functions"> 
    JDialog dialog;
    
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
    private void setScrollSpeeds(){
        JScrollPane scrollpanes [] = {
            jScrollPane2,jScrollPane4,
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
            my.hideColumns(enrolledStudentsTable, new int [] {0,1,5});
            my.hideColumns(attendanceTable, new int [] {0,1,2,3});
            my.hideColumns(checkAttendanceTable, new int [] {0,1,5});
        }
        
        //Set table fonts
        JTable tables [] = {
            assignedTeacherTable,
            attendanceTable,
            enrolledStudentsTable,
            checkAttendanceTable,
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
        //mainTab.add("Manage Students", manageStudentsTab);
        mainTab.add("Select Managed Section",selectSectionTab);
        mainTab.add("View Students",viewStudentsTab);
        mainTab.add("Check Attendance",checkAttendanceTab);
        
        mainTab.setFont(myVariables.TAB_HEADER_FONT);
    }
    private void loadTabIcons(){
        Icon tabIcons [] = {
            my.getImgIcn(myVariables.getSectionsIcon()),
            my.getImgIcn(myVariables.getSectionsIcon()),
            my.getImgIcn(myVariables.getSectionsIcon()),
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
            btnSearchEnrolledStudent,
            //View Students
            btnSearchDate,
            
            btnEditAttendance,
            btnRecheckAttendance,
            btnCheckAttendance,
            //Check Attendance
            btnFinishAttendance,
            btnSaveChangesToAttendance,
                //Add Notes Dialog
                btnSaveNotes,
        };
        
        JButton lightButtons [] = {
            //btnEdit1
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
            lightButtons[n].setFont(new Font("Comic Sans MS",Font.BOLD,12));
            //buttons[n].setCursor(my.getCursor(myVariables.getHandCursor()));
            lightButtons[n].setCursor(new Cursor(Cursor.HAND_CURSOR));
            lightButtons[n].setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
    }
    private void loadLabels(){
        JLabel titleHeaderLabels [] = {
            jLabel35,jLabel36,jLabel37,jLabel38,
        };
        JLabel labels [] = {
            lbSearchResult,lbSearchResult1,
        };
        
        JLabel formsHeaderLabels [] = {
            jLabel1,jLabel2,jLabel3,jLabel4,jLabel8,
        };
        JLabel textFieldHeaderLabels [] = {
            lbAttendanceCount,jLabel7,jLabel5,lbDateAdded,jLabel10,jLabel11,
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
            jdcDate,jdcCustomDate,
        };
        JSpinner spinners [] = {
            jsHours,jsMinutes
        };
        
        JTextField searchFields [] = {
            tfSearchTeacherLoad,tfSearchEnrolledStudent,
        };
        JTextField forms [] = {
            
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
            jcbMeridan,
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
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jdcDate = new com.toedter.calendar.JDateChooser();
        btnSearchDate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        attendanceTable = new javax.swing.JTable();
        btnEditAttendance = new javax.swing.JButton();
        btnRecheckAttendance = new javax.swing.JButton();
        btnCheckAttendance = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lbAttendanceCount = new javax.swing.JLabel();
        checkAttendanceTab = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        left1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        checkAttendanceTable = new javax.swing.JTable();
        right1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rbToday = new javax.swing.JRadioButton();
        rbCustomDate = new javax.swing.JRadioButton();
        jdcCustomDate = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jsHours = new javax.swing.JSpinner();
        jsMinutes = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jcbMeridan = new javax.swing.JComboBox<>();
        btnFinishAttendance = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        setDateGroup = new javax.swing.ButtonGroup();
        setStatusGroup = new javax.swing.ButtonGroup();
        testDialog = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        editAttendanceDialog = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbAttendanceID = new javax.swing.JLabel();
        btnSaveChangesToAttendance = new javax.swing.JButton();
        lbDateAdded = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        rbPresent = new javax.swing.JRadioButton();
        rbAbsent = new javax.swing.JRadioButton();
        rbTardy = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtaNotes = new javax.swing.JTextArea();
        addNotesDialog = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtaLeaveNotes = new javax.swing.JTextArea();
        btnSaveNotes = new javax.swing.JButton();
        recheckAttendanceDialog = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        recheckAttendanceTable = new javax.swing.JTable();
        lbDateToRecheck = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        headerPanel = new javax.swing.JPanel();
        lbSchoolName = new javax.swing.JLabel();
        lbSchoolAddress = new javax.swing.JLabel();
        lbLoggedInUser = new javax.swing.JLabel();
        lbDateTime = new javax.swing.JLabel();
        mainTab = new javax.swing.JTabbedPane();

        selectSectionTab.setBackground(new java.awt.Color(11, 102, 35));

        lbSearchResult.setForeground(new java.awt.Color(255, 255, 255));
        lbSearchResult.setText("Search using the search bar...");

        tfSearchTeacherLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchManagedSections(evt);
            }
        });

        btnSearchSection.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_find_user_male_16px.png"))); // NOI18N
        btnSearchSection.setText("Search");
        btnSearchSection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchManagedSections(evt);
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
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane1.setBorder(null);
        jSplitPane1.setDividerLocation(600);

        left.setBackground(new java.awt.Color(11, 102, 35));

        lbSearchResult1.setForeground(new java.awt.Color(255, 255, 255));
        lbSearchResult1.setText("Search using the search bar...");

        tfSearchEnrolledStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchEnrolledStudentsHandler(evt);
            }
        });

        btnSearchEnrolledStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_find_user_male_16px.png"))); // NOI18N
        btnSearchEnrolledStudent.setText("Search");
        btnSearchEnrolledStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchEnrolledStudentsHandler(evt);
            }
        });

        enrolledStudentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Student ID", "LRN", "Name", "Gender", "Section ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        enrolledStudentsTable.getTableHeader().setReorderingAllowed(false);
        enrolledStudentsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loadStudentsAttendanceHandler(evt);
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(left);

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

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

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Search Date");

        jdcDate.setToolTipText("Specific date to find");
        jdcDate.setDateFormatString("yyyy-MM-dd");

        btnSearchDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_search_property_16px.png"))); // NOI18N
        btnSearchDate.setText("Search");
        btnSearchDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchSpecificAttendanceHandler(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Attendance Details");

        attendanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Student ID", "Section ID", "Subject ID", "Status", "Date", "Notes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        attendanceTable.getTableHeader().setReorderingAllowed(false);
        attendanceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                attendanceTableMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(attendanceTable);

        btnEditAttendance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_edit_16px.png"))); // NOI18N
        btnEditAttendance.setText("Edit Selected Attendance");
        btnEditAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditAttendanceActionPerformed(evt);
            }
        });

        btnRecheckAttendance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_rollback_16px.png"))); // NOI18N
        btnRecheckAttendance.setText("Re-check Attendances");
        btnRecheckAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecheckAttendanceActionPerformed(evt);
            }
        });

        btnCheckAttendance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_report_card_16px.png"))); // NOI18N
        btnCheckAttendance.setText("Check Attendance Now");
        btnCheckAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAttendanceNowHamdler(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Attendance Options");

        lbAttendanceCount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbAttendanceCount.setText("Present: 0  Absent: 0  Tardy: 0   Total: 0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jdcDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchDate))
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnEditAttendance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRecheckAttendance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCheckAttendance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbAttendanceCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearchDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdcDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbAttendanceCount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditAttendance)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRecheckAttendance)
                .addGap(18, 18, 18)
                .addComponent(btnCheckAttendance)
                .addContainerGap())
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout rightLayout = new javax.swing.GroupLayout(right);
        right.setLayout(rightLayout);
        rightLayout.setHorizontalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
        );
        rightLayout.setVerticalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
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

        jSplitPane2.setBorder(null);
        jSplitPane2.setDividerLocation(650);

        left1.setBackground(new java.awt.Color(11, 102, 35));

        checkAttendanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Student ID", "LRN", "Name", "Gender", "Section ID", "Present", "Absent", "Tardy", "Notes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        checkAttendanceTable.getTableHeader().setReorderingAllowed(false);
        checkAttendanceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkAttendanceTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(checkAttendanceTable);
        if (checkAttendanceTable.getColumnModel().getColumnCount() > 0) {
            checkAttendanceTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            checkAttendanceTable.getColumnModel().getColumn(2).setMaxWidth(100);
            checkAttendanceTable.getColumnModel().getColumn(4).setMaxWidth(60);
            checkAttendanceTable.getColumnModel().getColumn(6).setPreferredWidth(60);
            checkAttendanceTable.getColumnModel().getColumn(6).setMaxWidth(60);
            checkAttendanceTable.getColumnModel().getColumn(7).setPreferredWidth(60);
            checkAttendanceTable.getColumnModel().getColumn(7).setMaxWidth(60);
            checkAttendanceTable.getColumnModel().getColumn(8).setPreferredWidth(60);
            checkAttendanceTable.getColumnModel().getColumn(8).setMaxWidth(60);
            checkAttendanceTable.getColumnModel().getColumn(9).setPreferredWidth(50);
            checkAttendanceTable.getColumnModel().getColumn(9).setMaxWidth(50);
        }

        javax.swing.GroupLayout left1Layout = new javax.swing.GroupLayout(left1);
        left1.setLayout(left1Layout);
        left1Layout.setHorizontalGroup(
            left1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                .addContainerGap())
        );
        left1Layout.setVerticalGroup(
            left1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane2.setLeftComponent(left1);

        jScrollPane4.setBorder(null);
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        jPanel8.setBackground(new java.awt.Color(22, 66, 33));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Attendance Options");

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

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Set Date");

        setDateGroup.add(rbToday);
        rbToday.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        rbToday.setText("Today");
        rbToday.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_unchecked_checkbox_20px.png"))); // NOI18N
        rbToday.setOpaque(false);
        rbToday.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_tick_box_20px.png"))); // NOI18N
        rbToday.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_checked_checkbox_20px.png"))); // NOI18N
        rbToday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkAttendanceTypeHandler(evt);
            }
        });

        setDateGroup.add(rbCustomDate);
        rbCustomDate.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        rbCustomDate.setText("Custom");
        rbCustomDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_unchecked_checkbox_20px.png"))); // NOI18N
        rbCustomDate.setOpaque(false);
        rbCustomDate.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_tick_box_20px.png"))); // NOI18N
        rbCustomDate.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_checked_checkbox_20px.png"))); // NOI18N
        rbCustomDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkAttendanceTypeHandler(evt);
            }
        });

        jLabel5.setText("Date and Time");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText(":");

        jcbMeridan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));

        btnFinishAttendance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_save_16px.png"))); // NOI18N
        btnFinishAttendance.setText("Save Attendance");
        btnFinishAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAttendanceHandler(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Finalize Attendance");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbCustomDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbToday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFinishAttendance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jdcCustomDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jsHours, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jsMinutes, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbMeridan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbToday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbCustomDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcCustomDate, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jsHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jsMinutes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbMeridan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFinishAttendance)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane4.setViewportView(jPanel2);

        javax.swing.GroupLayout right1Layout = new javax.swing.GroupLayout(right1);
        right1.setLayout(right1Layout);
        right1Layout.setHorizontalGroup(
            right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
        );
        right1Layout.setVerticalGroup(
            right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
        );

        jSplitPane2.setRightComponent(right1);

        javax.swing.GroupLayout checkAttendanceTabLayout = new javax.swing.GroupLayout(checkAttendanceTab);
        checkAttendanceTab.setLayout(checkAttendanceTabLayout);
        checkAttendanceTabLayout.setHorizontalGroup(
            checkAttendanceTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
        );
        checkAttendanceTabLayout.setVerticalGroup(
            checkAttendanceTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
        );

        testDialog.setBackground(new java.awt.Color(153, 255, 255));
        testDialog.setInheritsPopupMenu(true);

        jButton2.setText("Yeah");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout testDialogLayout = new javax.swing.GroupLayout(testDialog);
        testDialog.setLayout(testDialogLayout);
        testDialogLayout.setHorizontalGroup(
            testDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        testDialogLayout.setVerticalGroup(
            testDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, testDialogLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(32, 32, 32))
        );

        editAttendanceDialog.setBackground(new java.awt.Color(255, 255, 204));

        jPanel9.setBackground(new java.awt.Color(22, 66, 33));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Edit Attendance");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setText("Record ID: ");

        lbAttendanceID.setText("ATTENDANCE_ID");

        btnSaveChangesToAttendance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_ok_16px.png"))); // NOI18N
        btnSaveChangesToAttendance.setText("Save Changes");
        btnSaveChangesToAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveChangesToAttendanceActionPerformed(evt);
            }
        });

        lbDateAdded.setText("Date: DATE_ADDED");

        jLabel10.setText("Status");

        setStatusGroup.add(rbPresent);
        rbPresent.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        rbPresent.setText("Present");
        rbPresent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_unchecked_checkbox_20px.png"))); // NOI18N
        rbPresent.setIconTextGap(5);
        rbPresent.setOpaque(false);
        rbPresent.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_tick_box_20px.png"))); // NOI18N
        rbPresent.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_checked_checkbox_20px.png"))); // NOI18N

        setStatusGroup.add(rbAbsent);
        rbAbsent.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        rbAbsent.setText("Absent");
        rbAbsent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_unchecked_checkbox_20px.png"))); // NOI18N
        rbAbsent.setIconTextGap(5);
        rbAbsent.setOpaque(false);
        rbAbsent.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_tick_box_20px.png"))); // NOI18N
        rbAbsent.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_checked_checkbox_20px.png"))); // NOI18N

        setStatusGroup.add(rbTardy);
        rbTardy.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        rbTardy.setText("Late");
        rbTardy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_unchecked_checkbox_20px.png"))); // NOI18N
        rbTardy.setIconTextGap(5);
        rbTardy.setOpaque(false);
        rbTardy.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_tick_box_20px.png"))); // NOI18N
        rbTardy.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_checked_checkbox_20px.png"))); // NOI18N

        jLabel11.setText("Notes (Optional)");

        jtaNotes.setColumns(20);
        jtaNotes.setFont(myVariables.TEXTFIELD_FONT);
        jtaNotes.setLineWrap(true);
        jtaNotes.setRows(5);
        jtaNotes.setText("asda asd asd asd asd asd asd asd asd asd asd asd asdas dasdasd asd asd asdasda ad asd asd asdasdasdas a asd");
        jtaNotes.setWrapStyleWord(true);
        jScrollPane5.setViewportView(jtaNotes);

        javax.swing.GroupLayout editAttendanceDialogLayout = new javax.swing.GroupLayout(editAttendanceDialog);
        editAttendanceDialog.setLayout(editAttendanceDialogLayout);
        editAttendanceDialogLayout.setHorizontalGroup(
            editAttendanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editAttendanceDialogLayout.createSequentialGroup()
                .addGroup(editAttendanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editAttendanceDialogLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSaveChangesToAttendance))
                    .addGroup(editAttendanceDialogLayout.createSequentialGroup()
                        .addGroup(editAttendanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(editAttendanceDialogLayout.createSequentialGroup()
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbAttendanceID))
                            .addGroup(editAttendanceDialogLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(editAttendanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbDateAdded)
                                    .addComponent(jLabel10)
                                    .addGroup(editAttendanceDialogLayout.createSequentialGroup()
                                        .addComponent(rbPresent, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbAbsent, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbTardy, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel11))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editAttendanceDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5)))
                .addContainerGap())
        );
        editAttendanceDialogLayout.setVerticalGroup(
            editAttendanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editAttendanceDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editAttendanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(editAttendanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(lbAttendanceID)))
                .addGap(18, 18, 18)
                .addComponent(lbDateAdded)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editAttendanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbPresent)
                    .addComponent(rbAbsent)
                    .addComponent(rbTardy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSaveChangesToAttendance)
                .addContainerGap())
        );

        addNotesDialog.setBackground(new java.awt.Color(255, 255, 204));

        jPanel10.setBackground(new java.awt.Color(22, 66, 33));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Leave a Note for this Student. (Optional)");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel38)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel38)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtaLeaveNotes.setColumns(20);
        jtaLeaveNotes.setFont(myVariables.TEXTFIELD_FONT);
        jtaLeaveNotes.setRows(5);
        jScrollPane6.setViewportView(jtaLeaveNotes);

        btnSaveNotes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_save_16px.png"))); // NOI18N
        btnSaveNotes.setText("Save");
        btnSaveNotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveNotesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addNotesDialogLayout = new javax.swing.GroupLayout(addNotesDialog);
        addNotesDialog.setLayout(addNotesDialogLayout);
        addNotesDialogLayout.setHorizontalGroup(
            addNotesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addNotesDialogLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(addNotesDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addNotesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addNotesDialogLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSaveNotes)))
                .addContainerGap())
        );
        addNotesDialogLayout.setVerticalGroup(
            addNotesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addNotesDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSaveNotes)
                .addContainerGap())
        );

        recheckAttendanceDialog.setBackground(new java.awt.Color(255, 255, 204));

        jPanel11.setBackground(new java.awt.Color(22, 66, 33));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Re-check Attendance");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        recheckAttendanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Student ID", "LRN", "Name", "Gender", "Section ID", "Present", "Absent", "Tardy", "Notes", "Attendance ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        recheckAttendanceTable.getTableHeader().setReorderingAllowed(false);
        recheckAttendanceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recheckAttendanceTableMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(recheckAttendanceTable);
        if (recheckAttendanceTable.getColumnModel().getColumnCount() > 0) {
            recheckAttendanceTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            recheckAttendanceTable.getColumnModel().getColumn(2).setMaxWidth(100);
            recheckAttendanceTable.getColumnModel().getColumn(4).setMaxWidth(60);
            recheckAttendanceTable.getColumnModel().getColumn(6).setPreferredWidth(60);
            recheckAttendanceTable.getColumnModel().getColumn(6).setMaxWidth(60);
            recheckAttendanceTable.getColumnModel().getColumn(7).setPreferredWidth(60);
            recheckAttendanceTable.getColumnModel().getColumn(7).setMaxWidth(60);
            recheckAttendanceTable.getColumnModel().getColumn(8).setPreferredWidth(60);
            recheckAttendanceTable.getColumnModel().getColumn(8).setMaxWidth(60);
            recheckAttendanceTable.getColumnModel().getColumn(9).setPreferredWidth(50);
            recheckAttendanceTable.getColumnModel().getColumn(9).setMaxWidth(50);
        }

        lbDateToRecheck.setText("Selected Date to Change: DATE_SELECTED");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_save_16px.png"))); // NOI18N
        jButton1.setText("Save Changes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout recheckAttendanceDialogLayout = new javax.swing.GroupLayout(recheckAttendanceDialog);
        recheckAttendanceDialog.setLayout(recheckAttendanceDialogLayout);
        recheckAttendanceDialogLayout.setHorizontalGroup(
            recheckAttendanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recheckAttendanceDialogLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(recheckAttendanceDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(recheckAttendanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                    .addGroup(recheckAttendanceDialogLayout.createSequentialGroup()
                        .addComponent(lbDateToRecheck)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, recheckAttendanceDialogLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        recheckAttendanceDialogLayout.setVerticalGroup(
            recheckAttendanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recheckAttendanceDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbDateToRecheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dashboard");
        setIconImage(my.getImgIcn(myVariables.getAttendanceWindowIcon()).getImage()
        );
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                logoutHandler(evt);
            }
        });

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 255, 204));
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 204));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1003, 600));

        headerPanel.setBackground(new java.awt.Color(22, 66, 33));

        lbSchoolName.setBackground(new java.awt.Color(255, 255, 255));
        lbSchoolName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbSchoolName.setForeground(new java.awt.Color(255, 255, 255));
        lbSchoolName.setText("SCHOOL_NAME Attendance System");

        lbSchoolAddress.setBackground(new java.awt.Color(255, 255, 255));
        lbSchoolAddress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbSchoolAddress.setForeground(new java.awt.Color(255, 255, 255));
        lbSchoolAddress.setText("SCHOOL_ADDRESS");

        lbLoggedInUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbLoggedInUser.setForeground(new java.awt.Color(255, 255, 255));
        lbLoggedInUser.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbLoggedInUser.setText("Welcome USER_NAME, ACCESS_LEVEL");

        lbDateTime.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbDateTime.setForeground(new java.awt.Color(255, 255, 255));
        lbDateTime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDateTime.setText("SERVER_DATE_TIME");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addComponent(lbSchoolName, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbLoggedInUser))
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addComponent(lbSchoolAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbDateTime)))
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
                    .addComponent(lbDateTime))
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
            .addComponent(mainTab, javax.swing.GroupLayout.DEFAULT_SIZE, 983, Short.MAX_VALUE)
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainTab, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE))
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

    private void logoutHandler(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_logoutHandler
        tr.cancel(true);
        my.openWindow(this, new login());
    }//GEN-LAST:event_logoutHandler

    private void assignedTeacherTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_assignedTeacherTableMouseClicked
        if(evt.getClickCount() == 2){
            if(mainTab.getTabCount() <= 1){
                mainTab.addTab("View Students", my.getImgIcn(myVariables.getSectionsIcon()), viewStudentsTab);
                mainTab.setSelectedIndex(1);
            }
            resetViewStudentsTab(true, true, false);
            calculateAttendanceCount(lbAttendanceCount, attendanceTable);
        }else{
            my.remove_multiple_tabs(mainTab, new int [] {1,2});
        }
    }//GEN-LAST:event_assignedTeacherTableMouseClicked

    private void searchManagedSections(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchManagedSections
        String toSearch = tfSearchTeacherLoad.getText();
        String schoolYear = jcbSchoolYear1.getSelectedItem().toString();
        
        my.remove_multiple_tabs(mainTab, new int [] {1,2});
        
        String where = "WHERE subjectCode LIKE 'ADV%'";
        
        if(myVariables.getAccessLevel() < 5){
            where += " AND teacherId='"+myVariables.getUserLoggedInId()+"'";
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
    }//GEN-LAST:event_searchManagedSections

    private void searchEnrolledStudentsHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchEnrolledStudentsHandler
        int row = assignedTeacherTable.getSelectedRow();
        
        if(row == -1){
            my.showMessage("Please select a section first.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        resetViewStudentsTab(false, true, false);
        
        String sectionId = assignedTeacherTable.getValueAt(row, 1).toString();
        String toSearch = tfSearchEnrolledStudent.getText();
        
        String where = "WHERE sectionId='"+sectionId+"' AND (lrn='"+toSearch+"' OR lName LIKE '%"+toSearch+"%')";
        my.searchItem(where, enrolledStudentsTable, 6, null, new int [] {3,4,5}, true, true, lbSearchResult1, tfSearchEnrolledStudent, true);
    }//GEN-LAST:event_searchEnrolledStudentsHandler

    private void attendanceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_attendanceTableMouseClicked
        if(evt.getClickCount() == 1){
            resetViewStudentsTab(false, false, true);
        }
        if(evt.getClickCount() == 2){
            int row = attendanceTable.getSelectedRow();
            
            String status = attendanceTable.getValueAt(row, 4).toString();
            String date = attendanceTable.getValueAt(row, 5).toString();
            String notes = attendanceTable.getValueAt(row, 6).toString();
            
            
            my.showMessage("Attendance Details\n\nStatus : "+status+"\nDate : "+my.numberToWordDate(date)+"\nNotes : "+notes, JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_attendanceTableMouseClicked

    private void saveAttendanceHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAttendanceHandler
        //Get Values
        int row = assignedTeacherTable.getSelectedRow();
        
        String sectionId = assignedTeacherTable.getValueAt(row, 1).toString();
        String subjectId = assignedTeacherTable.getValueAt(row, 6).toString();
        String dateSelected = "";
        String time = "";
        
        if(rbToday.isSelected()){
            dateSelected = my.getDateNow(false);
        }
        if(rbCustomDate.isSelected()){
            if(jdcCustomDate.getDate() == null){
                my.showMessage("Please select a date.", JOptionPane.WARNING_MESSAGE);
                return;
            }
            dateSelected = my.jCalendarToNumberDate(jdcCustomDate.getDate().toString(), false);
            time = jsHours.getValue().toString()+":"+jsMinutes.getValue().toString()+":00 "+jcbMeridan.getSelectedItem().toString();
            
            time = my.from12To24HourFormat(time);
            
            if(time == null){
                System.err.println("Invalid time. Returning");
                return;
            }
        }
        //<editor-fold desc="Get Values">
        int count = checkAttendanceTable.getRowCount();
        String sets [] = new String[count];
        String studentId,status="",notes;
        
        for(int n=0;n<count;n++){
            studentId = checkAttendanceTable.getValueAt(n, 1).toString();
            
            if(checkAttendanceTable.getValueAt(n, 6).toString().contains("O")){
                status = "Present";
            }if(checkAttendanceTable.getValueAt(n, 7).toString().contains("O")){
                status = "Absent";
            }if(checkAttendanceTable.getValueAt(n, 8).toString().contains("O")){
                status = "Late";
            }
            notes = checkAttendanceTable.getValueAt(n, 9).toString();
            
            //id,studentId,sectionId,subjectId,status,dateAdded,notes
            if(rbToday.isSelected()){
                sets[n] = "null,'"+studentId+"','"+sectionId+"','"+subjectId+"','"+status+"',now(),'"+notes+"'";
                System.err.println("Today's Date Selected");
            }if(rbCustomDate.isSelected()){
                System.err.println("Custom Date Selected");
                sets[n] = "null,'"+studentId+"','"+sectionId+"','"+subjectId+"','"+status+"','"+dateSelected+" "+time+"','"+notes+"'";
            }
        }
        
        //</editor-fold>
        String where = "WHERE sectionId='"+sectionId+"' AND subjectId='"+subjectId+"' AND dateAdded LIKE '"+dateSelected+"%'";
        
        if(my.checkForDuplicates("attendance",where,myVariables.getAttendanceOrder())){
            my.showMessage("This section already had an Attendance conducted for this day.\n"
                    + "Please use the 'Re-Check Attendance' feature to overwrite this attendance.",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }else{
            if(my.add_multiple_values("attendance", "id,studentId,sectionId,subjectId,status,dateAdded,notes", sets)){
                my.showMessage("Attendance Saved!", JOptionPane.INFORMATION_MESSAGE);
            }else{
                my.showMessage("Saving failed. Please make sure you are connected to the School Network.", JOptionPane.ERROR_MESSAGE);
            }
            //No duplicate. Proceed to save attendance
        }
        
        my.remove_multiple_tabs(mainTab, new int [] {2});
    }//GEN-LAST:event_saveAttendanceHandler

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        closeCustomDialog();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void loadStudentsAttendanceHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadStudentsAttendanceHandler
        if(evt.getClickCount() == 2){
            int row = enrolledStudentsTable.getSelectedRow();
            int subjectRow = assignedTeacherTable.getSelectedRow();
            
            if(row == -1){
                my.showMessage("Please Select a Student", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if(subjectRow == -1){
                my.showMessage("Please Select a Section First", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            String studentId = enrolledStudentsTable.getValueAt(row, 1).toString();
            String sectionId = enrolledStudentsTable.getValueAt(row, 5).toString();
            String subjectId = assignedTeacherTable.getValueAt(subjectRow, 6).toString();
            
            String where = "WHERE studentId='"+studentId+"' AND sectionId='"+sectionId+"' AND subjectId='"+subjectId+"' ORDER BY dateAdded DESC";
            
            my.searchItem(where, attendanceTable, 7, null, null, false, true, null, null, true);
            
            calculateAttendanceCount(lbAttendanceCount,attendanceTable);
        }else{
            resetViewStudentsTab(false, true, false);
            calculateAttendanceCount(lbAttendanceCount, attendanceTable);
        }
    }//GEN-LAST:event_loadStudentsAttendanceHandler

    private void checkAttendanceTypeHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkAttendanceTypeHandler
        checkAttendanceType();
    }//GEN-LAST:event_checkAttendanceTypeHandler

    private void checkAttendanceNowHamdler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAttendanceNowHamdler
        //Load Students
        int row = assignedTeacherTable.getSelectedRow();
        
        if(row == -1){
            my.showMessage("Please select a section first.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String sectionId = assignedTeacherTable.getValueAt(row, 1).toString();
        String toSearch = tfSearchEnrolledStudent.getText();
        
        String where = "WHERE sectionId='"+sectionId+"'";
        
        String result [] = my.return_values("*", "v_enrollment_minimal", where, myVariables.getEnrollmentViewMinimalOrder());
        
        if(result == null){
            my.showMessage("Can't check attendance without students. Please enroll some first.", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        my.clear_table_rows(checkAttendanceTable);
        for(String n : result){
            n = my.toNameFormat(n, new int []{3,4,5});
            n += "O@@ @@ @@ @@";
            
            my.add_table_row(n, checkAttendanceTable);
        }        
        //my.searchItem(where, checkAttendanceTable, 6, null, new int [] {3,4,5}, true, true, lbSearchResult1, tfSearchEnrolledStudent, true);
        
        //Add the tab        
        if(mainTab.getTabCount() <= 2){
            mainTab.addTab("Check Attendance", my.getImgIcn(myVariables.getSectionsIcon()),checkAttendanceTab);
        }
        mainTab.setSelectedIndex(2);
        
        rbToday.setSelected(true);
        checkAttendanceType();
    }//GEN-LAST:event_checkAttendanceNowHamdler

    private void searchSpecificAttendanceHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchSpecificAttendanceHandler
        int row = enrolledStudentsTable.getSelectedRow();
        int subjectRow = assignedTeacherTable.getSelectedRow();

        if(row == -1){
            my.showMessage("Please Select a Student", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(subjectRow == -1){
            my.showMessage("Please Select a Section First", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(jdcDate.getDate() == null){
            //my.showMessage("Please select a Date to search.", JOptionPane.WARNING_MESSAGE);
            //return;
        }
        
        String date = "";
        String studentId = enrolledStudentsTable.getValueAt(row, 1).toString();
        String sectionId = enrolledStudentsTable.getValueAt(row, 5).toString();
        String subjectId = assignedTeacherTable.getValueAt(subjectRow, 6).toString();
        
        String where = "";
        
        if(jdcDate.getDate() == null){
            where = "WHERE studentId='"+studentId+"' AND sectionId='"+sectionId+
                "' AND subjectId='"+subjectId+"' ORDER BY dateAdded DESC";
            
            System.err.println("No date selected");
        }else{
            date = my.jCalendarToNumberDate(jdcDate.getDate().toString(),false);
            where = "WHERE studentId='"+studentId+"' AND sectionId='"+sectionId+
                "' AND subjectId='"+subjectId+"' AND dateAdded LIKE '"+date+"%' ORDER BY dateAdded DESC";
        }

        my.searchItem(where, attendanceTable, 7, null, null, false, true, null, null, true);
        calculateAttendanceCount(lbAttendanceCount,attendanceTable);
        
        resetViewStudentsTab(false, false, false);
    }//GEN-LAST:event_searchSpecificAttendanceHandler

    private void btnEditAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditAttendanceActionPerformed
        int row = attendanceTable.getSelectedRow();
        
        String id = attendanceTable.getValueAt(row, 0).toString();
        String status = attendanceTable.getValueAt(row, 4).toString();
        String date = attendanceTable.getValueAt(row, 5).toString();
        String notes = attendanceTable.getValueAt(row, 6).toString();
        
        lbAttendanceID.setText(id);
        switch (status){
            case "Present":{
                rbPresent.setSelected(true);
                break;
            }case "Absent":{
                rbAbsent.setSelected(true);
                break;
            }case "Late":{
                rbTardy.setSelected(true);
                break;
            }default:{
                rbPresent.setSelected(true);
                break;
            }
        }
        lbDateAdded.setText("Date : "+my.numberToWordDate(date));
        jtaNotes.setText(notes);
        
        showCustomDialog("Edit Selected Attendance",editAttendanceDialog, true, 400, 350, false);
    }//GEN-LAST:event_btnEditAttendanceActionPerformed

    private void btnSaveChangesToAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveChangesToAttendanceActionPerformed
        String id = lbAttendanceID.getText();
        String status = "";
        String notes = jtaNotes.getText();
        
        if(rbPresent.isSelected())
            status = "Present";
        if(rbAbsent.isSelected())
            status = "Absent";
        if(rbTardy.isSelected())
            status = "Late";
        
        String [] sets = {
            "status='"+status+"'",
            "notes='"+notes+"'",
        };
        
        if(my.update_values("attendance", sets, "id='"+id+"'")){
            my.showMessage("Update Successful.", JOptionPane.INFORMATION_MESSAGE);
            
            jdcDate.setDate(null);
            searchSpecificAttendanceHandler(evt);
            
            closeCustomDialog();
        }else{
            my.showMessage("Update failed. Please make sure you are connected to the school network.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveChangesToAttendanceActionPerformed

    private void btnSaveNotesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveNotesActionPerformed
        String notes = jtaLeaveNotes.getText();
        
        int row = checkAttendanceTable.getSelectedRow();
        
        if(notes.length() > 1){
            checkAttendanceTable.setValueAt(notes, row, 9);
        }else{
            checkAttendanceTable.setValueAt(" ", row, 9);
        }
        closeCustomDialog();
    }//GEN-LAST:event_btnSaveNotesActionPerformed

    private void checkAttendanceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkAttendanceTableMouseClicked
        if(evt.getClickCount() == 1){
            int row = checkAttendanceTable.getSelectedRow();
            int column = checkAttendanceTable.getSelectedColumn();

            //columns 6,7,8 & 9
            switch (column){
                case 6:{
                    checkAttendanceTable.setValueAt("O", row, 6);
                    checkAttendanceTable.setValueAt(" ", row, 7);
                    checkAttendanceTable.setValueAt(" ", row, 8);
                    break;
                }case 7:{
                    checkAttendanceTable.setValueAt(" ", row, 6);
                    checkAttendanceTable.setValueAt("O", row, 7);
                    checkAttendanceTable.setValueAt(" ", row, 8);
                    break;
                }case 8:{
                    checkAttendanceTable.setValueAt(" ", row, 6);
                    checkAttendanceTable.setValueAt(" ", row, 7);
                    checkAttendanceTable.setValueAt("O", row, 8);
                    break;
                }case 9:{
                    String notes = checkAttendanceTable.getValueAt(row, 9).toString();
                    if(notes.length() > 1){
                        jtaLeaveNotes.setText(notes);
                    }else{
                        jtaLeaveNotes.setText("");
                    }
                    showCustomDialog("Write Notes", addNotesDialog, true, 400, 300, false);
                    break;
                }
            }
        }
    }//GEN-LAST:event_checkAttendanceTableMouseClicked

    private void recheckAttendanceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recheckAttendanceTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_recheckAttendanceTableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        closeCustomDialog();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnRecheckAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecheckAttendanceActionPerformed
        //Prompt user
        if(!my.getConfirmation("Re-checking allows you to change the values of the attendance on\n"
                + "the selected date. Continue?")){
            my.showMessage("Re-checking attendance canceled.", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        
        //Load Students
        int row = assignedTeacherTable.getSelectedRow();
        int attendanceRow = attendanceTable.getSelectedRow();
        
        if(row == -1){
            my.showMessage("Please select a section first.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String sectionId = assignedTeacherTable.getValueAt(row, 1).toString();
        String dateSelected = attendanceTable.getValueAt(attendanceRow, 5).toString();
        
        String where = "WHERE sectionId='"+sectionId+"'";
        
        String result [] = my.return_values("*", "v_enrollment_minimal", where, myVariables.getEnrollmentViewMinimalOrder());
        
        if(result == null){
            my.showMessage("Can't check attendance without students. Please enroll some first.", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        lbDateToRecheck.setText("Selected Date to Change: "+dateSelected);
        my.clear_table_rows(recheckAttendanceTable);
        for(String n : result){
            n = my.toNameFormat(n, new int []{3,4,5});
            n += "O@@ @@ @@ @@null@@";  //Start off with empty IDs for easier query later in saving
            
            my.add_table_row(n, recheckAttendanceTable);
        }
        my.remove_multiple_tabs(mainTab, new int [] {2});
        
        //Load attendance record for the selected date
        
        //Show dialog
        showCustomDialog("Re-check Attendance from selected Date", recheckAttendanceDialog, true, 600, 400, true);
    }//GEN-LAST:event_btnRecheckAttendanceActionPerformed

    /**
     * @param args the command line arguments
     */
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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dashBoard().setVisible(true);
            }
        });
    }
    private void resetViewStudentsTab(boolean clearStudentsTable,boolean clearAttendanceTable,boolean enableAttendanceButtons){
        if(clearStudentsTable){
            my.clear_table_rows(enrolledStudentsTable);
            tfSearchEnrolledStudent.setText("");
        }
        if(clearAttendanceTable){
            jdcDate.setDate(null);
            my.clear_table_rows(attendanceTable);
        }
        
        btnEditAttendance.setEnabled(enableAttendanceButtons);
        btnRecheckAttendance.setEnabled(enableAttendanceButtons);
    }
    private void calculateAttendanceCount(JLabel attendanceCounter,JTable attendanceTable){
        int present = 0,absent = 0,tardy = 0;
        for(int n=0;n<attendanceTable.getRowCount();n++){
            String status = attendanceTable.getValueAt(n, 4).toString();
            
            if(status.contains("Present") || status.contains("present"))
                present++;
            if(status.contains("Absent") || status.contains("absent"))
                absent++;
            if(status.contains("Late") || status.contains("late"))
                tardy++;
        }
        
        attendanceCounter.setText("Present :"+present+"  Absent :"+absent+"  Tardy :"+tardy+"   Total :"+(present+absent+tardy));
    }
    private void checkAttendanceType(){
        if(rbToday.isSelected()){
            enableDisableCustomDateType(false);
        }
        if(rbCustomDate.isSelected()){
            enableDisableCustomDateType(true);
        }
    }
    private void enableDisableCustomDateType(boolean enabled){
        jdcCustomDate.setEnabled(enabled);
        jsHours.setEnabled(enabled);
        jsMinutes.setEnabled(enabled);
        
        jcbMeridan.setEnabled(enabled);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addNotesDialog;
    private javax.swing.JTable assignedTeacherTable;
    private javax.swing.JTable attendanceTable;
    private javax.swing.JButton btnCheckAttendance;
    private javax.swing.JButton btnEditAttendance;
    private javax.swing.JButton btnFinishAttendance;
    private javax.swing.JButton btnRecheckAttendance;
    private javax.swing.JButton btnSaveChangesToAttendance;
    private javax.swing.JButton btnSaveNotes;
    private javax.swing.JButton btnSearchDate;
    private javax.swing.JButton btnSearchEnrolledStudent;
    private javax.swing.JButton btnSearchSection;
    private javax.swing.JPanel checkAttendanceTab;
    private javax.swing.JTable checkAttendanceTable;
    private javax.swing.JPanel editAttendanceDialog;
    private javax.swing.JTable enrolledStudentsTable;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JComboBox<String> jcbMeridan;
    private javax.swing.JComboBox<String> jcbSchoolYear1;
    private com.toedter.calendar.JDateChooser jdcCustomDate;
    private com.toedter.calendar.JDateChooser jdcDate;
    private javax.swing.JSpinner jsHours;
    private javax.swing.JSpinner jsMinutes;
    private javax.swing.JTextArea jtaLeaveNotes;
    private javax.swing.JTextArea jtaNotes;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lbAttendanceCount;
    private javax.swing.JLabel lbAttendanceID;
    private javax.swing.JLabel lbDateAdded;
    private javax.swing.JLabel lbDateTime;
    private javax.swing.JLabel lbDateToRecheck;
    private javax.swing.JLabel lbLoggedInUser;
    private javax.swing.JLabel lbSchoolAddress;
    private javax.swing.JLabel lbSchoolName;
    private javax.swing.JLabel lbSearchResult;
    private javax.swing.JLabel lbSearchResult1;
    private javax.swing.JPanel left;
    private javax.swing.JPanel left1;
    private javax.swing.JTabbedPane mainTab;
    private javax.swing.JRadioButton rbAbsent;
    private javax.swing.JRadioButton rbCustomDate;
    private javax.swing.JRadioButton rbPresent;
    private javax.swing.JRadioButton rbTardy;
    private javax.swing.JRadioButton rbToday;
    private javax.swing.JPanel recheckAttendanceDialog;
    private javax.swing.JTable recheckAttendanceTable;
    private javax.swing.JPanel right;
    private javax.swing.JPanel right1;
    private javax.swing.JPanel selectSectionTab;
    private javax.swing.ButtonGroup setDateGroup;
    private javax.swing.ButtonGroup setStatusGroup;
    private javax.swing.JPanel testDialog;
    private javax.swing.JTextField tfSearchEnrolledStudent;
    private javax.swing.JTextField tfSearchTeacherLoad;
    private javax.swing.JPanel viewStudentsTab;
    // End of variables declaration//GEN-END:variables
}

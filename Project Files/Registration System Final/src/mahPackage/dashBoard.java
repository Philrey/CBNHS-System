/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackage;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Phil Rey
 */
public class dashBoard extends javax.swing.JFrame {

    /**
     * Creates new form dashBoard
     */
    myFunctions my;
    
    public dashBoard() {
        my = new myFunctions(false);
        initComponents();
        
        lbLoggedInUser.setText("Welcome "+myVariables.getUserLoggedInName()+" ("+myVariables.getAccessLevelName(-1)+")");
        
        loadColoredButtons();
        loadTabs();
        loadTabIcons();
        sortTables();
        loadLabels();
        loadTextFields();
        setScrollSpeeds();
        
        loadYearDropDowns(1);
        
        myVariables.setProgressBar(jpbProgressBar);
        myVariables.setLbLoadingMessage(lbProgressMessage);
        
        lbSchoolName.setText(myVariables.getSchoolName() + " Registration System");
        lbSchoolAddress.setText(myVariables.getSchoolAddress());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        manageStudentsTab = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        left1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();
        tfSearchStudent = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        lbSearchResult = new javax.swing.JLabel();
        right1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        addStudentTab = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfFname = new javax.swing.JTextField();
        tfMname = new javax.swing.JTextField();
        tfLName = new javax.swing.JTextField();
        tfStudentLrn = new javax.swing.JTextField();
        tfInitialGrade = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        rbMale = new javax.swing.JRadioButton();
        rbFemale = new javax.swing.JRadioButton();
        jLabel36 = new javax.swing.JLabel();
        tfSchoolId = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        tfSchoolName = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        tfSchoolAddress = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        editStudentTab = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tfFirstName1 = new javax.swing.JTextField();
        tfMiddleName1 = new javax.swing.JTextField();
        tfLastName1 = new javax.swing.JTextField();
        tfStudentLrn1 = new javax.swing.JTextField();
        tfInitialGrade1 = new javax.swing.JTextField();
        btnSaveChanges = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        rbFemale1 = new javax.swing.JRadioButton();
        rbMale1 = new javax.swing.JRadioButton();
        jLabel87 = new javax.swing.JLabel();
        tfSchoolId1 = new javax.swing.JTextField();
        jLabel90 = new javax.swing.JLabel();
        tfSchoolName1 = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        tfSchoolAddress1 = new javax.swing.JTextField();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        personalInfoTab = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        left2 = new javax.swing.JPanel();
        btnSearch1 = new javax.swing.JButton();
        tfSearchStudent1 = new javax.swing.JTextField();
        lbSearchResult1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        studentTable1 = new javax.swing.JTable();
        right2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        tfBdate = new javax.swing.JTextField();
        tfAge = new javax.swing.JTextField();
        tfMotherTongue = new javax.swing.JTextField();
        tfEthnicGroup = new javax.swing.JTextField();
        tfReligion = new javax.swing.JTextField();
        tfHouseNumber = new javax.swing.JTextField();
        tfBarangay = new javax.swing.JTextField();
        tfMunicipality = new javax.swing.JTextField();
        tfProvince = new javax.swing.JTextField();
        tfFathersName = new javax.swing.JTextField();
        tfMothersName = new javax.swing.JTextField();
        tfGuardiansName = new javax.swing.JTextField();
        tfRelationship = new javax.swing.JTextField();
        tfContactNumber = new javax.swing.JTextField();
        btnEdit = new javax.swing.JButton();
        btnSaveChanges1 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        manageSubjectsTab = new javax.swing.JPanel();
        jSplitPane3 = new javax.swing.JSplitPane();
        left3 = new javax.swing.JPanel();
        lbSearchResult2 = new javax.swing.JLabel();
        tfSearchSubject = new javax.swing.JTextField();
        btnSearch2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        subjectTable = new javax.swing.JTable();
        right3 = new javax.swing.JPanel();
        subjectsTab = new javax.swing.JTabbedPane();
        addSubjectTab = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        tfSubjectCode = new javax.swing.JTextField();
        tfSubjectDescription = new javax.swing.JTextField();
        jcbGradeLevel = new javax.swing.JComboBox<>();
        btnAdd1 = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        editSubjectTab = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        tfSubjectCode1 = new javax.swing.JTextField();
        tfSubjectDescription1 = new javax.swing.JTextField();
        jcbGradeLevel1 = new javax.swing.JComboBox<>();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        btnSaveChanges2 = new javax.swing.JButton();
        subjectLoadsTab = new javax.swing.JPanel();
        jSplitPane4 = new javax.swing.JSplitPane();
        left4 = new javax.swing.JPanel();
        lbSearchResult3 = new javax.swing.JLabel();
        tfSearchSubjectLoad = new javax.swing.JTextField();
        btnSearch3 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        subjectTable1 = new javax.swing.JTable();
        right4 = new javax.swing.JPanel();
        subjectLoadTabs = new javax.swing.JTabbedPane();
        addStudentTab4 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        tfLoadName1 = new javax.swing.JTextField();
        jcbGradeLevel2 = new javax.swing.JComboBox<>();
        btnAdd2 = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        editLoadTab = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        tfLoadName = new javax.swing.JTextField();
        jcbGradeLevel3 = new javax.swing.JComboBox<>();
        btnSaveChanges4 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        selectedSubjectTable = new javax.swing.JTable();
        tfSearchSubject2 = new javax.swing.JTextField();
        btnSearch4 = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        searchedsubjectTable = new javax.swing.JTable();
        jLabel54 = new javax.swing.JLabel();
        btnAddSubjectToList = new javax.swing.JButton();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        btnRemoveSubjectFromList = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        lbLoadId = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        manageUsersTab = new javax.swing.JPanel();
        jSplitPane5 = new javax.swing.JSplitPane();
        left5 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        tfSearchUser = new javax.swing.JTextField();
        btnSearch5 = new javax.swing.JButton();
        lbSearchResult4 = new javax.swing.JLabel();
        right5 = new javax.swing.JPanel();
        usersTab = new javax.swing.JTabbedPane();
        addUserTab = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jPanel13 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jcbGender2 = new javax.swing.JComboBox<>();
        btnAdd3 = new javax.swing.JButton();
        jcbAccessLevel = new javax.swing.JComboBox<>();
        tfFname1 = new javax.swing.JTextField();
        tfMname1 = new javax.swing.JTextField();
        tfLName1 = new javax.swing.JTextField();
        tfUserName = new javax.swing.JTextField();
        tfPassword = new javax.swing.JTextField();
        editUserTab = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jPanel14 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        tfFname2 = new javax.swing.JTextField();
        tfMname2 = new javax.swing.JTextField();
        tfLName2 = new javax.swing.JTextField();
        tfUserName1 = new javax.swing.JTextField();
        tfPassword1 = new javax.swing.JTextField();
        jcbGender1 = new javax.swing.JComboBox<>();
        btnSaveChanges5 = new javax.swing.JButton();
        jcbAccessLevel1 = new javax.swing.JComboBox<>();
        usersPersonalInfoTab = new javax.swing.JPanel();
        usersPersonalInfoTabNew = new javax.swing.JSplitPane();
        left = new javax.swing.JPanel();
        lbSearchResult5 = new javax.swing.JLabel();
        tfSearchUser1 = new javax.swing.JTextField();
        btnSearch6 = new javax.swing.JButton();
        jScrollPane14 = new javax.swing.JScrollPane();
        usersTable1 = new javax.swing.JTable();
        right = new javax.swing.JPanel();
        jtpUserDetailsTab = new javax.swing.JTabbedPane();
        jScrollPane15 = new javax.swing.JScrollPane();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        tfEmployeeNumber = new javax.swing.JTextField();
        tfFundSource = new javax.swing.JTextField();
        tfNatureOfAppointment = new javax.swing.JTextField();
        tfDegree = new javax.swing.JTextField();
        tfMajor = new javax.swing.JTextField();
        tfMinor = new javax.swing.JTextField();
        tfPosition = new javax.swing.JTextField();
        btnEdit1 = new javax.swing.JButton();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        btnSaveChanges6 = new javax.swing.JButton();
        jLabel99 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        lbUserInfoId = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        btnEditAssignedSubject = new javax.swing.JButton();
        jScrollPane16 = new javax.swing.JScrollPane();
        managedSubjectTable = new javax.swing.JTable();
        btnDeleteManagedSubject = new javax.swing.JButton();
        jLabel61 = new javax.swing.JLabel();
        tfSearchSubject3 = new javax.swing.JTextField();
        btnSearch7 = new javax.swing.JButton();
        jScrollPane17 = new javax.swing.JScrollPane();
        searchedsubjectTable1 = new javax.swing.JTable();
        btnAddManagedSubject = new javax.swing.JButton();
        btnSaveManagedSubjectChanges = new javax.swing.JButton();
        addStudentGenderGroup = new javax.swing.ButtonGroup();
        editStudentGenderGroup = new javax.swing.ButtonGroup();
        importDialog = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel94 = new javax.swing.JLabel();
        jtbImportTabs = new javax.swing.JTabbedPane();
        importStudentsTab = new javax.swing.JPanel();
        importTablesTab = new javax.swing.JTabbedPane();
        jScrollPane18 = new javax.swing.JScrollPane();
        importTableSF1 = new javax.swing.JTable();
        jScrollPane20 = new javax.swing.JScrollPane();
        importTableSF10 = new javax.swing.JTable();
        jLabel95 = new javax.swing.JLabel();
        jcbFileFormats = new javax.swing.JComboBox<>();
        tfFileLocation = new javax.swing.JTextField();
        btnOpenFileExplorer = new javax.swing.JButton();
        btnRegisterStudents = new javax.swing.JButton();
        btnCancelImport = new javax.swing.JButton();
        jpbProgressBar = new javax.swing.JProgressBar();
        lbProgressMessage = new javax.swing.JLabel();
        cbUpdateExisting = new javax.swing.JCheckBox();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        headerPanel = new javax.swing.JPanel();
        lbSchoolName = new javax.swing.JLabel();
        lbSchoolAddress = new javax.swing.JLabel();
        lbLoggedInUser = new javax.swing.JLabel();
        btnImportFromLis = new javax.swing.JButton();
        mainTab = new javax.swing.JTabbedPane();

        manageStudentsTab.setBackground(new java.awt.Color(11, 102, 35));

        jSplitPane1.setBorder(null);
        jSplitPane1.setDividerLocation(700);

        left1.setBackground(new java.awt.Color(11, 102, 35));

        studentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID (H)", "LRN", "Last Name", "First Name", "Middle Name", "Gender", "Initial Gen. Ave.", "Current Gr. Lvl"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        studentTable.getTableHeader().setReorderingAllowed(false);
        studentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loadStudentHandler(evt);
            }
        });
        jScrollPane1.setViewportView(studentTable);
        if (studentTable.getColumnModel().getColumnCount() > 0) {
            studentTable.getColumnModel().getColumn(1).setPreferredWidth(120);
            studentTable.getColumnModel().getColumn(2).setPreferredWidth(150);
            studentTable.getColumnModel().getColumn(3).setPreferredWidth(200);
            studentTable.getColumnModel().getColumn(4).setPreferredWidth(150);
            studentTable.getColumnModel().getColumn(5).setPreferredWidth(100);
            studentTable.getColumnModel().getColumn(6).setPreferredWidth(120);
            studentTable.getColumnModel().getColumn(7).setPreferredWidth(100);
        }

        tfSearchStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchStudentHandler(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_find_user_male_16px.png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchStudentHandler(evt);
            }
        });

        lbSearchResult.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbSearchResult.setForeground(new java.awt.Color(255, 255, 255));
        lbSearchResult.setText("Search using the search bar...");

        javax.swing.GroupLayout left1Layout = new javax.swing.GroupLayout(left1);
        left1.setLayout(left1Layout);
        left1Layout.setHorizontalGroup(
            left1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, left1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(left1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(left1Layout.createSequentialGroup()
                        .addComponent(lbSearchResult, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfSearchStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        left1Layout.setVerticalGroup(
            left1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(left1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSearchStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(lbSearchResult))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(left1);

        jScrollPane6.setBorder(null);
        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        addStudentTab.setBackground(new java.awt.Color(255, 255, 204));
        addStudentTab.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel4.setBackground(new java.awt.Color(22, 66, 33));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Add New Student");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tfFname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewStudentHandler(evt);
            }
        });

        tfMname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewStudentHandler(evt);
            }
        });

        tfLName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewStudentHandler(evt);
            }
        });

        tfStudentLrn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewStudentHandler(evt);
            }
        });

        tfInitialGrade.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_add_user_male_16px.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewStudentHandler(evt);
            }
        });

        jLabel5.setText("First Name");

        jLabel6.setText("Middle Name");

        jLabel7.setText("Last Name, Extension (Jr,Sr,IV)");

        jLabel8.setText("Student LRN (12 Digits)");
        jLabel8.setToolTipText("Can be found on the student's report card.");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel9.setText("Elementary Completer General Average");

        jLabel10.setText("Gender");

        addStudentGenderGroup.add(rbMale);
        rbMale.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        rbMale.setSelected(true);
        rbMale.setText("Male");
        rbMale.setContentAreaFilled(false);
        rbMale.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbMale.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        rbMale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_male_16px.png"))); // NOI18N
        rbMale.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_ok_16px.png"))); // NOI18N

        addStudentGenderGroup.add(rbFemale);
        rbFemale.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        rbFemale.setText("Female");
        rbFemale.setContentAreaFilled(false);
        rbFemale.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbFemale.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rbFemale.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        rbFemale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_female_16px.png"))); // NOI18N
        rbFemale.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_ok_16px.png"))); // NOI18N

        jLabel36.setText("School ID");

        tfSchoolId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfSchoolId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSchoolIdaddNewStudentHandler(evt);
            }
        });

        jLabel37.setText("Elementary School Name");

        tfSchoolName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSchoolNameaddNewStudentHandler(evt);
            }
        });

        jLabel83.setText("School Address");

        tfSchoolAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSchoolAddressaddNewStudentHandler(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Basic");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Elementary Details");

        javax.swing.GroupLayout addStudentTabLayout = new javax.swing.GroupLayout(addStudentTab);
        addStudentTab.setLayout(addStudentTabLayout);
        addStudentTabLayout.setHorizontalGroup(
            addStudentTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addStudentTabLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(addStudentTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addStudentTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfSchoolAddress)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfSchoolName)
                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfFname)
                    .addComponent(tfMname)
                    .addComponent(tfLName)
                    .addComponent(tfStudentLrn)
                    .addGroup(addStudentTabLayout.createSequentialGroup()
                        .addGroup(addStudentTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addStudentTabLayout.createSequentialGroup()
                                .addComponent(rbMale, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbFemale, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfSchoolId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfInitialGrade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        addStudentTabLayout.setVerticalGroup(
            addStudentTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addStudentTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfMname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfLName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfStudentLrn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addStudentTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbMale)
                    .addComponent(rbFemale))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(12, 12, 12)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfInitialGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSchoolId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSchoolName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel83)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSchoolAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdd)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane6.setViewportView(addStudentTab);

        jTabbedPane2.addTab("Add Student", jScrollPane6);

        jScrollPane7.setBorder(null);
        jScrollPane7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        editStudentTab.setBackground(new java.awt.Color(255, 255, 204));

        jPanel5.setBackground(new java.awt.Color(22, 66, 33));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Edit Student");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tfFirstName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateStudentHandler(evt);
            }
        });

        tfMiddleName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateStudentHandler(evt);
            }
        });

        tfLastName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateStudentHandler(evt);
            }
        });

        tfStudentLrn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateStudentHandler(evt);
            }
        });

        tfInitialGrade1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfInitialGrade1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateStudentHandler(evt);
            }
        });

        btnSaveChanges.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_save_16px.png"))); // NOI18N
        btnSaveChanges.setText("Save Changes");
        btnSaveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateStudentHandler(evt);
            }
        });

        jLabel11.setText("Elementary Completer General Average");

        jLabel12.setText("First Name");

        jLabel13.setText("Gender");

        jLabel14.setText("Middle Name");

        jLabel15.setText("Last Name");

        jLabel16.setText("Student LRN (12 Digits)");

        editStudentGenderGroup.add(rbFemale1);
        rbFemale1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        rbFemale1.setText("Female");
        rbFemale1.setContentAreaFilled(false);
        rbFemale1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbFemale1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rbFemale1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        rbFemale1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_female_16px.png"))); // NOI18N
        rbFemale1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_ok_16px.png"))); // NOI18N

        editStudentGenderGroup.add(rbMale1);
        rbMale1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        rbMale1.setText("Male");
        rbMale1.setContentAreaFilled(false);
        rbMale1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbMale1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        rbMale1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_male_16px.png"))); // NOI18N
        rbMale1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_ok_16px.png"))); // NOI18N

        jLabel87.setText("School ID");

        tfSchoolId1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfSchoolId1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSchoolId1addNewStudentHandler(evt);
            }
        });

        jLabel90.setText("Elementary School Name");

        tfSchoolName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSchoolName1addNewStudentHandler(evt);
            }
        });

        jLabel91.setText("School Address");

        tfSchoolAddress1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSchoolAddress1addNewStudentHandler(evt);
            }
        });

        jLabel92.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel92.setText("Basic");

        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel93.setText("Elementary Details");

        javax.swing.GroupLayout editStudentTabLayout = new javax.swing.GroupLayout(editStudentTab);
        editStudentTab.setLayout(editStudentTabLayout);
        editStudentTabLayout.setHorizontalGroup(
            editStudentTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editStudentTabLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(editStudentTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editStudentTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfFirstName1)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel92, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfMiddleName1)
                    .addComponent(tfLastName1)
                    .addComponent(tfStudentLrn1)
                    .addComponent(jLabel93, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSaveChanges, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfSchoolAddress1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel91, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel87, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel90, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfSchoolName1)
                    .addGroup(editStudentTabLayout.createSequentialGroup()
                        .addGroup(editStudentTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(editStudentTabLayout.createSequentialGroup()
                                .addComponent(rbMale1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbFemale1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfSchoolId1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfInitialGrade1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        editStudentTabLayout.setVerticalGroup(
            editStudentTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editStudentTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel92)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfFirstName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfMiddleName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfLastName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfStudentLrn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editStudentTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbMale1)
                    .addComponent(rbFemale1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel93)
                .addGap(12, 12, 12)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfInitialGrade1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel87)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSchoolId1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel90)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSchoolName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel91)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSchoolAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSaveChanges)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane7.setViewportView(editStudentTab);

        jTabbedPane2.addTab("Edit Student", jScrollPane7);

        javax.swing.GroupLayout right1Layout = new javax.swing.GroupLayout(right1);
        right1.setLayout(right1Layout);
        right1Layout.setHorizontalGroup(
            right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        right1Layout.setVerticalGroup(
            right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        jSplitPane1.setRightComponent(right1);

        javax.swing.GroupLayout manageStudentsTabLayout = new javax.swing.GroupLayout(manageStudentsTab);
        manageStudentsTab.setLayout(manageStudentsTabLayout);
        manageStudentsTabLayout.setHorizontalGroup(
            manageStudentsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        manageStudentsTabLayout.setVerticalGroup(
            manageStudentsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        personalInfoTab.setBackground(new java.awt.Color(11, 102, 35));

        jSplitPane2.setBorder(null);
        jSplitPane2.setDividerLocation(700);

        left2.setBackground(new java.awt.Color(11, 102, 35));

        btnSearch1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_find_user_male_16px.png"))); // NOI18N
        btnSearch1.setText("Search");
        btnSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchStudentForPrsnlInfHandler(evt);
            }
        });

        tfSearchStudent1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchStudentForPrsnlInfHandler(evt);
            }
        });

        lbSearchResult1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbSearchResult1.setForeground(new java.awt.Color(255, 255, 255));
        lbSearchResult1.setText("Search using the search bar...");

        studentTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID (H)", "LRN", "Last Name", "First Name", "Middle Name", "Gender", "Initial Gen. Ave.", "Current Gr. Lvl"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        studentTable1.getTableHeader().setReorderingAllowed(false);
        studentTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loadStudentPersonalInfo(evt);
            }
        });
        jScrollPane2.setViewportView(studentTable1);
        if (studentTable1.getColumnModel().getColumnCount() > 0) {
            studentTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
            studentTable1.getColumnModel().getColumn(5).setPreferredWidth(20);
        }

        javax.swing.GroupLayout left2Layout = new javax.swing.GroupLayout(left2);
        left2.setLayout(left2Layout);
        left2Layout.setHorizontalGroup(
            left2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(left2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, left2Layout.createSequentialGroup()
                        .addComponent(lbSearchResult1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSearchStudent1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        left2Layout.setVerticalGroup(
            left2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(left2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSearchStudent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch1)
                    .addComponent(lbSearchResult1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane2.setLeftComponent(left2);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setAutoscrolls(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jPanel6.setBackground(new java.awt.Color(22, 66, 33));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("View Personal Info");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tfBdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePersonalInfoChangesHandler(evt);
            }
        });

        tfAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePersonalInfoChangesHandler(evt);
            }
        });

        tfMotherTongue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePersonalInfoChangesHandler(evt);
            }
        });

        tfEthnicGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePersonalInfoChangesHandler(evt);
            }
        });

        tfReligion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePersonalInfoChangesHandler(evt);
            }
        });

        tfHouseNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePersonalInfoChangesHandler(evt);
            }
        });

        tfBarangay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePersonalInfoChangesHandler(evt);
            }
        });

        tfMunicipality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePersonalInfoChangesHandler(evt);
            }
        });

        tfProvince.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePersonalInfoChangesHandler(evt);
            }
        });

        tfFathersName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePersonalInfoChangesHandler(evt);
            }
        });

        tfMothersName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePersonalInfoChangesHandler(evt);
            }
        });

        tfGuardiansName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePersonalInfoChangesHandler(evt);
            }
        });

        tfRelationship.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePersonalInfoChangesHandler(evt);
            }
        });

        tfContactNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePersonalInfoChangesHandler(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_edit_16px.png"))); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPersonalInfoHandler(evt);
            }
        });

        btnSaveChanges1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_save_16px.png"))); // NOI18N
        btnSaveChanges1.setText("Save Changes");
        btnSaveChanges1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePersonalInfoChangesHandler(evt);
            }
        });

        jLabel18.setText("Birth Date (yyyy-mm-dd)");

        jLabel19.setText("Age");

        jLabel20.setText("Mother Tongue");

        jLabel21.setText("IP (Ethnic Group)");

        jLabel22.setText("Religion");

        jLabel23.setText("House Number");

        jLabel24.setText("Barangay");

        jLabel25.setText("Municipality");

        jLabel26.setText("Province");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Address");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Basic Information");

        jLabel29.setText("Mother's Name (Maiden Name)");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Parents");

        jLabel31.setText("Father's Name");

        jLabel32.setText("Relationship");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Guardian");

        jLabel34.setText("Guardian's Name");

        jLabel35.setText("Contact number of Parent or Guardian");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfAge)
                            .addComponent(tfBdate)
                            .addComponent(btnSaveChanges1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfContactNumber)
                            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                            .addComponent(tfRelationship)
                            .addComponent(tfGuardiansName)
                            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfMothersName)
                            .addComponent(tfFathersName)
                            .addComponent(tfMunicipality)
                            .addComponent(tfBarangay)
                            .addComponent(tfHouseNumber)
                            .addComponent(tfEthnicGroup)
                            .addComponent(tfMotherTongue)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfReligion, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfProvince, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfBdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfMotherTongue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfEthnicGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfReligion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfHouseNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfBarangay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfMunicipality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfProvince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfFathersName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfMothersName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfGuardiansName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfRelationship, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSaveChanges1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel1);

        javax.swing.GroupLayout right2Layout = new javax.swing.GroupLayout(right2);
        right2.setLayout(right2Layout);
        right2Layout.setHorizontalGroup(
            right2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
        );
        right2Layout.setVerticalGroup(
            right2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
        );

        jSplitPane2.setRightComponent(right2);

        javax.swing.GroupLayout personalInfoTabLayout = new javax.swing.GroupLayout(personalInfoTab);
        personalInfoTab.setLayout(personalInfoTabLayout);
        personalInfoTabLayout.setHorizontalGroup(
            personalInfoTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 935, Short.MAX_VALUE)
        );
        personalInfoTabLayout.setVerticalGroup(
            personalInfoTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        manageSubjectsTab.setBackground(new java.awt.Color(11, 102, 35));

        jSplitPane3.setBorder(null);
        jSplitPane3.setDividerLocation(700);

        left3.setBackground(new java.awt.Color(11, 102, 35));

        lbSearchResult2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbSearchResult2.setForeground(new java.awt.Color(255, 255, 255));
        lbSearchResult2.setText("Search using the search bar...");

        tfSearchSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchSubjects(evt);
            }
        });

        btnSearch2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_search_property_16px.png"))); // NOI18N
        btnSearch2.setText("Search");
        btnSearch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchSubjects(evt);
            }
        });

        subjectTable.setAutoCreateRowSorter(true);
        subjectTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID (H)", "Subject Code", "Description", "Grade Level"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        subjectTable.getTableHeader().setReorderingAllowed(false);
        subjectTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loadSubjectHandler(evt);
            }
        });
        jScrollPane5.setViewportView(subjectTable);
        if (subjectTable.getColumnModel().getColumnCount() > 0) {
            subjectTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout left3Layout = new javax.swing.GroupLayout(left3);
        left3.setLayout(left3Layout);
        left3Layout.setHorizontalGroup(
            left3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(left3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(left3Layout.createSequentialGroup()
                        .addComponent(lbSearchResult2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSearchSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        left3Layout.setVerticalGroup(
            left3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(left3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSearchSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch2)
                    .addComponent(lbSearchResult2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane3.setLeftComponent(left3);

        addSubjectTab.setBackground(new java.awt.Color(255, 255, 204));

        jPanel9.setBackground(new java.awt.Color(22, 66, 33));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Add New Subject");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jcbGradeLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grade 7", "Grade 8", "Grade 9", "Grade 10" }));
        jcbGradeLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbGradeLevelActionPerformed(evt);
            }
        });

        btnAdd1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_add_book_16px.png"))); // NOI18N
        btnAdd1.setText("Add");
        btnAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewSubjectHandler(evt);
            }
        });

        jLabel40.setText("Subject Code (e.g ENG7)");

        jLabel41.setText("Description (e.g MATHEMATICS)");

        jLabel45.setText("Grade Level");

        javax.swing.GroupLayout addSubjectTabLayout = new javax.swing.GroupLayout(addSubjectTab);
        addSubjectTab.setLayout(addSubjectTabLayout);
        addSubjectTabLayout.setHorizontalGroup(
            addSubjectTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addSubjectTabLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(addSubjectTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addSubjectTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfSubjectCode)
                    .addComponent(tfSubjectDescription)
                    .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(addSubjectTabLayout.createSequentialGroup()
                        .addGroup(addSubjectTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jcbGradeLevel, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        addSubjectTabLayout.setVerticalGroup(
            addSubjectTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addSubjectTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSubjectCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSubjectDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel45)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbGradeLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAdd1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        subjectsTab.addTab("Add Subject", addSubjectTab);

        editSubjectTab.setBackground(new java.awt.Color(255, 255, 204));

        jPanel10.setBackground(new java.awt.Color(22, 66, 33));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Edit Subject");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel46)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel46)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tfSubjectCode1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveSubjectChangesHandler(evt);
            }
        });

        tfSubjectDescription1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveSubjectChangesHandler(evt);
            }
        });

        jcbGradeLevel1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grade 7", "Grade 8", "Grade 9", "Grade 10" }));
        jcbGradeLevel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbGradeLevel1ActionPerformed(evt);
            }
        });

        jLabel48.setText("Subject Code");

        jLabel49.setText("Grade Level");

        jLabel50.setText("Description");

        btnSaveChanges2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_save_16px.png"))); // NOI18N
        btnSaveChanges2.setText("Save Changes");
        btnSaveChanges2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveSubjectChangesHandler(evt);
            }
        });

        javax.swing.GroupLayout editSubjectTabLayout = new javax.swing.GroupLayout(editSubjectTab);
        editSubjectTab.setLayout(editSubjectTabLayout);
        editSubjectTabLayout.setHorizontalGroup(
            editSubjectTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editSubjectTabLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(editSubjectTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editSubjectTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfSubjectCode1)
                    .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfSubjectDescription1)
                    .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSaveChanges2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(editSubjectTabLayout.createSequentialGroup()
                        .addGroup(editSubjectTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jcbGradeLevel1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        editSubjectTabLayout.setVerticalGroup(
            editSubjectTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editSubjectTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSubjectCode1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSubjectDescription1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbGradeLevel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSaveChanges2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        subjectsTab.addTab("Edit Subject", editSubjectTab);

        javax.swing.GroupLayout right3Layout = new javax.swing.GroupLayout(right3);
        right3.setLayout(right3Layout);
        right3Layout.setHorizontalGroup(
            right3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(subjectsTab)
        );
        right3Layout.setVerticalGroup(
            right3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(subjectsTab)
        );

        jSplitPane3.setRightComponent(right3);

        javax.swing.GroupLayout manageSubjectsTabLayout = new javax.swing.GroupLayout(manageSubjectsTab);
        manageSubjectsTab.setLayout(manageSubjectsTabLayout);
        manageSubjectsTabLayout.setHorizontalGroup(
            manageSubjectsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1055, Short.MAX_VALUE)
        );
        manageSubjectsTabLayout.setVerticalGroup(
            manageSubjectsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        subjectLoadsTab.setBackground(new java.awt.Color(11, 102, 35));

        jSplitPane4.setBorder(null);
        jSplitPane4.setDividerLocation(700);

        left4.setBackground(new java.awt.Color(11, 102, 35));

        lbSearchResult3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbSearchResult3.setForeground(new java.awt.Color(255, 255, 255));
        lbSearchResult3.setText("Search using the search bar...");

        tfSearchSubjectLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchLoadsHandler(evt);
            }
        });

        btnSearch3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_search_property_16px.png"))); // NOI18N
        btnSearch3.setText("Search");
        btnSearch3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchLoadsHandler(evt);
            }
        });

        subjectTable1.setAutoCreateRowSorter(true);
        subjectTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID (H)", "Load Name", "Grade Level", "Subjects Contained (H)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        subjectTable1.getTableHeader().setReorderingAllowed(false);
        subjectTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subjectTable1MouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(subjectTable1);
        if (subjectTable1.getColumnModel().getColumnCount() > 0) {
            subjectTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout left4Layout = new javax.swing.GroupLayout(left4);
        left4.setLayout(left4Layout);
        left4Layout.setHorizontalGroup(
            left4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, left4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(left4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane8)
                    .addGroup(left4Layout.createSequentialGroup()
                        .addComponent(lbSearchResult3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSearchSubjectLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        left4Layout.setVerticalGroup(
            left4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(left4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSearchSubjectLoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch3)
                    .addComponent(lbSearchResult3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane4.setLeftComponent(left4);

        addStudentTab4.setBackground(new java.awt.Color(255, 255, 204));

        jPanel11.setBackground(new java.awt.Color(22, 66, 33));

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Add New Load");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel42)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel42)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jcbGradeLevel2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jcbGradeLevel2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grade 7", "Grade 8", "Grade 9", "Grade 10" }));
        jcbGradeLevel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbGradeLevel2ActionPerformed(evt);
            }
        });

        btnAdd2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_add_book_16px.png"))); // NOI18N
        btnAdd2.setText("Add");
        btnAdd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewLoadHandler(evt);
            }
        });

        jLabel43.setText("Load Name (e.g. Grade 7)");

        jLabel47.setText("Grade Level");

        javax.swing.GroupLayout addStudentTab4Layout = new javax.swing.GroupLayout(addStudentTab4);
        addStudentTab4.setLayout(addStudentTab4Layout);
        addStudentTab4Layout.setHorizontalGroup(
            addStudentTab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addStudentTab4Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(addStudentTab4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addStudentTab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfLoadName1)
                    .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(addStudentTab4Layout.createSequentialGroup()
                        .addGroup(addStudentTab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jcbGradeLevel2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        addStudentTab4Layout.setVerticalGroup(
            addStudentTab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addStudentTab4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfLoadName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbGradeLevel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAdd2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        subjectLoadTabs.addTab("Add Load", addStudentTab4);

        editLoadTab.setBackground(new java.awt.Color(255, 255, 204));

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));

        jLabel52.setText("Load Name");

        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel53.setText("Grade Level");

        jcbGradeLevel3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jcbGradeLevel3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grade 7", "Grade 8", "Grade 9", "Grade 10" }));
        jcbGradeLevel3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectLoadGradeLevelChangedHandler(evt);
            }
        });

        btnSaveChanges4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_save_16px.png"))); // NOI18N
        btnSaveChanges4.setText("Save Changes");
        btnSaveChanges4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveLoadChangesHandler(evt);
            }
        });

        selectedSubjectTable.setAutoCreateRowSorter(true);
        selectedSubjectTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID (H)", "Subject Code", "Description", "Grade Level"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        selectedSubjectTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane9.setViewportView(selectedSubjectTable);
        if (selectedSubjectTable.getColumnModel().getColumnCount() > 0) {
            selectedSubjectTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        tfSearchSubject2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findSubjectHandler(evt);
            }
        });

        btnSearch4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_search_property_16px.png"))); // NOI18N
        btnSearch4.setText("Search");
        btnSearch4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findSubjectHandler(evt);
            }
        });

        searchedsubjectTable.setAutoCreateRowSorter(true);
        searchedsubjectTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID (H)", "Subject Code", "Description", "Grade Level"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        searchedsubjectTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane10.setViewportView(searchedsubjectTable);
        if (searchedsubjectTable.getColumnModel().getColumnCount() > 0) {
            searchedsubjectTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        jLabel54.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("Selected Subjects (Max 12 Subjects)");

        btnAddSubjectToList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_add_book_16px.png"))); // NOI18N
        btnAddSubjectToList.setText("Add");
        btnAddSubjectToList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSubjectToLoadHandler(evt);
            }
        });

        jLabel57.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("Select Subjec(s) to Add.");

        jLabel58.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("Load Details");

        btnRemoveSubjectFromList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_delete_bin_16px.png"))); // NOI18N
        btnRemoveSubjectFromList.setText("Remove");
        btnRemoveSubjectFromList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeSubjectFromListHandler(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(tfLoadName)
                    .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSaveChanges4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddSubjectToList, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRemoveSubjectFromList, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jcbGradeLevel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(tfSearchSubject2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel58)
                .addGap(7, 7, 7)
                .addComponent(jLabel52)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfLoadName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel53)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbGradeLevel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel57)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSearchSubject2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddSubjectToList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRemoveSubjectFromList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSaveChanges4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane4.setViewportView(jPanel3);

        jPanel12.setBackground(new java.awt.Color(22, 66, 33));

        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Edit Subject Load");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel51)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel51)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbLoadId.setText("ID_NUMBER");

        jLabel55.setText("Load ID:");

        javax.swing.GroupLayout editLoadTabLayout = new javax.swing.GroupLayout(editLoadTab);
        editLoadTab.setLayout(editLoadTabLayout);
        editLoadTabLayout.setHorizontalGroup(
            editLoadTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editLoadTabLayout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel55)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLoadId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        editLoadTabLayout.setVerticalGroup(
            editLoadTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editLoadTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editLoadTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(editLoadTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel55)
                        .addComponent(lbLoadId)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE))
        );

        subjectLoadTabs.addTab("Edit Load", editLoadTab);

        javax.swing.GroupLayout right4Layout = new javax.swing.GroupLayout(right4);
        right4.setLayout(right4Layout);
        right4Layout.setHorizontalGroup(
            right4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(subjectLoadTabs)
        );
        right4Layout.setVerticalGroup(
            right4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(subjectLoadTabs)
        );

        jSplitPane4.setRightComponent(right4);

        javax.swing.GroupLayout subjectLoadsTabLayout = new javax.swing.GroupLayout(subjectLoadsTab);
        subjectLoadsTab.setLayout(subjectLoadsTabLayout);
        subjectLoadsTabLayout.setHorizontalGroup(
            subjectLoadsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)
        );
        subjectLoadsTabLayout.setVerticalGroup(
            subjectLoadsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane4)
        );

        manageUsersTab.setBackground(new java.awt.Color(11, 102, 35));

        jSplitPane5.setBorder(null);
        jSplitPane5.setDividerLocation(700);

        left5.setBackground(new java.awt.Color(11, 102, 35));

        usersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID (H)", "Last Name", "First Name", "Middle Name", "Gender", "User Name", "Password", "Access Level"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        usersTable.getTableHeader().setReorderingAllowed(false);
        usersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usersTableMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(usersTable);
        if (usersTable.getColumnModel().getColumnCount() > 0) {
            usersTable.getColumnModel().getColumn(0).setPreferredWidth(10);
            usersTable.getColumnModel().getColumn(4).setPreferredWidth(20);
        }

        tfSearchUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchUsersHander(evt);
            }
        });

        btnSearch5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_find_user_male_16px.png"))); // NOI18N
        btnSearch5.setText("Search");
        btnSearch5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchUsersHander(evt);
            }
        });

        lbSearchResult4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbSearchResult4.setForeground(new java.awt.Color(255, 255, 255));
        lbSearchResult4.setText("Search using the search bar...");

        javax.swing.GroupLayout left5Layout = new javax.swing.GroupLayout(left5);
        left5.setLayout(left5Layout);
        left5Layout.setHorizontalGroup(
            left5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, left5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(left5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane11)
                    .addGroup(left5Layout.createSequentialGroup()
                        .addComponent(lbSearchResult4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSearchUser, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        left5Layout.setVerticalGroup(
            left5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(left5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSearchUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch5)
                    .addComponent(lbSearchResult4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane5.setLeftComponent(left5);

        addUserTab.setBackground(new java.awt.Color(255, 255, 204));

        jPanel7.setBackground(new java.awt.Color(22, 66, 33));

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Add New User");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel44)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel44)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane12.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel13.setBackground(new java.awt.Color(255, 255, 204));

        jLabel56.setText("First Name");

        jLabel59.setText("Middle Name");

        jLabel60.setText("Last Name");

        jLabel63.setText("Gender");

        jLabel65.setText("Access Level");

        jLabel62.setText("User Name");

        jLabel71.setText("Password");

        jLabel72.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel72.setText("Basic");

        jLabel73.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel73.setText("Account Details");

        jcbGender2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        jcbGender2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbGender2ActionPerformed(evt);
            }
        });

        btnAdd3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_add_user_male_16px.png"))); // NOI18N
        btnAdd3.setText("Add");
        btnAdd3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewUserHandler(evt);
            }
        });

        jcbAccessLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 = Teacher", "2 = Department Head", "3 = Curriculum Head", "4 = Registrar" }));
        jcbAccessLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAccessLevelActionPerformed(evt);
            }
        });

        tfLName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfLName1ActionPerformed(evt);
            }
        });

        tfUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUserNameActionPerformed(evt);
            }
        });

        tfPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jcbAccessLevel, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel65, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jcbGender2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel63, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnAdd3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfUserName)
                    .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfPassword)
                    .addComponent(jLabel71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfFname1)
                    .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfMname1)
                    .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfLName1)
                    .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel72)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel56)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfFname1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel59)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfMname1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel60)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfLName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel63)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbGender2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel73)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel62)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel71)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel65)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbAccessLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAdd3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane12.setViewportView(jPanel13);

        javax.swing.GroupLayout addUserTabLayout = new javax.swing.GroupLayout(addUserTab);
        addUserTab.setLayout(addUserTabLayout);
        addUserTabLayout.setHorizontalGroup(
            addUserTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(addUserTabLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addUserTabLayout.setVerticalGroup(
            addUserTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addUserTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12))
        );

        usersTab.addTab("Add User", addUserTab);

        editUserTab.setBackground(new java.awt.Color(255, 255, 204));

        jPanel8.setBackground(new java.awt.Color(22, 66, 33));

        jLabel64.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("Edit User");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel64)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel64)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 204));

        jLabel66.setText("First Name");

        jLabel67.setText("Gender");

        jLabel74.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel74.setText("Account Details");

        jLabel75.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel75.setText("Basic");

        jLabel68.setText("Middle Name");

        jLabel76.setText("User Name");

        jLabel77.setText("Password");

        jLabel69.setText("Last Name");

        jLabel70.setText("Access Level");

        tfFname2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveUserChangesHandler(evt);
            }
        });

        tfMname2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveUserChangesHandler(evt);
            }
        });

        tfLName2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveUserChangesHandler(evt);
            }
        });

        tfUserName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveUserChangesHandler(evt);
            }
        });

        tfPassword1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveUserChangesHandler(evt);
            }
        });

        jcbGender1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        jcbGender1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbGender1ActionPerformed(evt);
            }
        });

        btnSaveChanges5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_save_16px.png"))); // NOI18N
        btnSaveChanges5.setText("Save Changes");
        btnSaveChanges5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveUserChangesHandler(evt);
            }
        });

        jcbAccessLevel1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 = Teacher", "2 = Department Head", "3 = Curriculum Head", "4 = Registrar" }));
        jcbAccessLevel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAccessLevel1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfFname2)
                    .addComponent(jLabel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfMname2)
                    .addComponent(jLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfLName2)
                    .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfUserName1)
                    .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfPassword1)
                    .addComponent(btnSaveChanges5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbGender1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jcbAccessLevel1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel70, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel75)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel66)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfFname2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel68)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfMname2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel69)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfLName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel67)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbGender1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel74)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel76)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfUserName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel77)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel70)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbAccessLevel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSaveChanges5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane13.setViewportView(jPanel14);

        javax.swing.GroupLayout editUserTabLayout = new javax.swing.GroupLayout(editUserTab);
        editUserTab.setLayout(editUserTabLayout);
        editUserTabLayout.setHorizontalGroup(
            editUserTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editUserTabLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
        );
        editUserTabLayout.setVerticalGroup(
            editUserTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editUserTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE))
        );

        usersTab.addTab("Edit User", editUserTab);

        javax.swing.GroupLayout right5Layout = new javax.swing.GroupLayout(right5);
        right5.setLayout(right5Layout);
        right5Layout.setHorizontalGroup(
            right5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(usersTab)
        );
        right5Layout.setVerticalGroup(
            right5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(usersTab)
        );

        jSplitPane5.setRightComponent(right5);

        javax.swing.GroupLayout manageUsersTabLayout = new javax.swing.GroupLayout(manageUsersTab);
        manageUsersTab.setLayout(manageUsersTabLayout);
        manageUsersTabLayout.setHorizontalGroup(
            manageUsersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
        );
        manageUsersTabLayout.setVerticalGroup(
            manageUsersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane5)
        );

        usersPersonalInfoTab.setBackground(new java.awt.Color(11, 102, 35));

        usersPersonalInfoTabNew.setBorder(null);
        usersPersonalInfoTabNew.setDividerLocation(700);

        left.setBackground(new java.awt.Color(11, 102, 35));

        lbSearchResult5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbSearchResult5.setForeground(new java.awt.Color(255, 255, 255));
        lbSearchResult5.setText("Search using the search bar...");

        tfSearchUser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchUserPersonalInfoHandler(evt);
            }
        });

        btnSearch6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_find_user_male_16px.png"))); // NOI18N
        btnSearch6.setText("Search");
        btnSearch6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchUserPersonalInfoHandler(evt);
            }
        });

        usersTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID (H)", "Last Name", "First Name", "Middle Name", "Gender", "User Name (H)", "Password (H)", "Access Level"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        usersTable1.getTableHeader().setReorderingAllowed(false);
        usersTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usersTable1loadStudentPersonalInfo(evt);
            }
        });
        jScrollPane14.setViewportView(usersTable1);
        if (usersTable1.getColumnModel().getColumnCount() > 0) {
            usersTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
            usersTable1.getColumnModel().getColumn(4).setPreferredWidth(20);
        }

        javax.swing.GroupLayout leftLayout = new javax.swing.GroupLayout(left);
        left.setLayout(leftLayout);
        leftLayout.setHorizontalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane14)
                    .addGroup(leftLayout.createSequentialGroup()
                        .addComponent(lbSearchResult5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSearchUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch6, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        leftLayout.setVerticalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSearchUser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch6)
                    .addComponent(lbSearchResult5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addContainerGap())
        );

        usersPersonalInfoTabNew.setLeftComponent(left);

        jtpUserDetailsTab.setBackground(new java.awt.Color(255, 255, 204));

        jScrollPane15.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane15.setAutoscrolls(true);

        jPanel15.setBackground(new java.awt.Color(255, 255, 204));

        jPanel16.setBackground(new java.awt.Color(22, 66, 33));

        jLabel78.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setText("View User's Personal Info");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel78)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel78)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tfEmployeeNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEmployeeNumberActionPerformed(evt);
            }
        });

        tfFundSource.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFundSourceActionPerformed(evt);
            }
        });

        tfNatureOfAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNatureOfAppointmentActionPerformed(evt);
            }
        });

        tfDegree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDegreeActionPerformed(evt);
            }
        });

        tfMajor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMajorActionPerformed(evt);
            }
        });

        tfMinor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMinorActionPerformed(evt);
            }
        });

        tfPosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPositionActionPerformed(evt);
            }
        });

        btnEdit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_edit_16px.png"))); // NOI18N
        btnEdit1.setText("Edit");
        btnEdit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdit1editPersonalInfoHandler(evt);
            }
        });

        jLabel79.setText("Employee Number/T.I.N.");

        jLabel80.setText("Fund Source");

        jLabel81.setText("Nature of Appointment/Employment Status");

        jLabel84.setText("Degree/ Post Graduate");

        jLabel85.setText("Major/ Specialization");

        jLabel86.setText("Minor");

        jLabel88.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel88.setText("Educational Qualification");

        jLabel89.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel89.setText("Basic Information");

        btnSaveChanges6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_save_16px.png"))); // NOI18N
        btnSaveChanges6.setText("Save Changes");
        btnSaveChanges6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveChanges6ActionPerformed(evt);
            }
        });

        jLabel99.setText("Position/ Designation");

        jLabel82.setText("Profile ID: ");

        lbUserInfoId.setText("ID_NUMBER");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel79, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel80, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel99, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel81, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel84, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel85, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel86, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel82)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbUserInfoId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(tfPosition)
                            .addComponent(jLabel89, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfFundSource)
                            .addComponent(tfEmployeeNumber)
                            .addComponent(btnSaveChanges6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEdit1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfNatureOfAppointment)
                            .addComponent(tfMinor)
                            .addComponent(tfMajor)
                            .addComponent(tfDegree)
                            .addComponent(jLabel88, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel89)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel79)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfEmployeeNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel80)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfFundSource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel99)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel81)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNatureOfAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel88)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel84)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDegree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel85)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfMajor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel86)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfMinor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEdit1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSaveChanges6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel82)
                    .addComponent(lbUserInfoId))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane15.setViewportView(jPanel15);

        jtpUserDetailsTab.addTab("Personal Info", jScrollPane15);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        jPanel18.setBackground(new java.awt.Color(22, 66, 33));

        jLabel96.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(255, 255, 255));
        jLabel96.setText("Assign Department Head Subjects");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel96)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel96)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel97.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel97.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel97.setText("Managed Subjects");

        btnEditAssignedSubject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_edit_16px.png"))); // NOI18N
        btnEditAssignedSubject.setText("Edit");
        btnEditAssignedSubject.setToolTipText("Edit managed subjects by this user");
        btnEditAssignedSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditAssignedSubjectActionPerformed(evt);
            }
        });

        managedSubjectTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID (H)", "Subject Code (H)", "Description", "Grade Level"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        managedSubjectTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane16.setViewportView(managedSubjectTable);
        if (managedSubjectTable.getColumnModel().getColumnCount() > 0) {
            managedSubjectTable.getColumnModel().getColumn(0).setPreferredWidth(5);
            managedSubjectTable.getColumnModel().getColumn(1).setPreferredWidth(5);
            managedSubjectTable.getColumnModel().getColumn(2).setPreferredWidth(5);
        }

        btnDeleteManagedSubject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_delete_bin_16px.png"))); // NOI18N
        btnDeleteManagedSubject.setText("Remove Selected");
        btnDeleteManagedSubject.setToolTipText("Remove selected subjects");
        btnDeleteManagedSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteManagedSubjectActionPerformed(evt);
            }
        });

        jLabel61.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("Select Subjec(s) to Add.");

        btnSearch7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_search_property_16px.png"))); // NOI18N
        btnSearch7.setText("Search");
        btnSearch7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch7findSubjectHandler(evt);
            }
        });

        searchedsubjectTable1.setAutoCreateRowSorter(true);
        searchedsubjectTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID (H)", "Subject Code", "Description", "Grade Level"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        searchedsubjectTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane17.setViewportView(searchedsubjectTable1);
        if (searchedsubjectTable1.getColumnModel().getColumnCount() > 0) {
            searchedsubjectTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        btnAddManagedSubject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_add_16px.png"))); // NOI18N
        btnAddManagedSubject.setText("Add Selected");
        btnAddManagedSubject.setToolTipText("Add a new subject");
        btnAddManagedSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddManagedSubjectActionPerformed(evt);
            }
        });

        btnSaveManagedSubjectChanges.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_edit_16px.png"))); // NOI18N
        btnSaveManagedSubjectChanges.setText("Save Changes");
        btnSaveManagedSubjectChanges.setToolTipText("Save Changes");
        btnSaveManagedSubjectChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveManagedSubjectChangesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel97, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tfSearchSubject3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch7, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnSaveManagedSubjectChanges, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnEditAssignedSubject)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDeleteManagedSubject))
                            .addComponent(btnAddManagedSubject, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel97)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteManagedSubject)
                    .addComponent(btnEditAssignedSubject))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel61)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSearchSubject3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddManagedSubject)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSaveManagedSubjectChanges)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane19.setViewportView(jPanel2);

        jtpUserDetailsTab.addTab("Assign Subjects", jScrollPane19);

        javax.swing.GroupLayout rightLayout = new javax.swing.GroupLayout(right);
        right.setLayout(rightLayout);
        rightLayout.setHorizontalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtpUserDetailsTab, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
        );
        rightLayout.setVerticalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtpUserDetailsTab, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
        );

        usersPersonalInfoTabNew.setRightComponent(right);

        javax.swing.GroupLayout usersPersonalInfoTabLayout = new javax.swing.GroupLayout(usersPersonalInfoTab);
        usersPersonalInfoTab.setLayout(usersPersonalInfoTabLayout);
        usersPersonalInfoTabLayout.setHorizontalGroup(
            usersPersonalInfoTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(usersPersonalInfoTabNew, javax.swing.GroupLayout.DEFAULT_SIZE, 1017, Short.MAX_VALUE)
        );
        usersPersonalInfoTabLayout.setVerticalGroup(
            usersPersonalInfoTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(usersPersonalInfoTabNew)
        );

        importDialog.setBackground(new java.awt.Color(255, 255, 204));

        jPanel17.setBackground(new java.awt.Color(22, 66, 33));

        jLabel94.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(255, 255, 255));
        jLabel94.setText("Import From DepEd LIS");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel94)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel94)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        importStudentsTab.setBackground(new java.awt.Color(255, 255, 204));

        importTableSF1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "LRN", "Name", "Gender", "Birthday", "Age", "Mother Tongue", "IP", "Religion", "House No.", "Brgy.", "Municipality", "Province", "Father's Name", "Mother's Name", "Guardian's Name", "Relationship", "Contact", "Remarks", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        importTableSF1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        importTableSF1.getTableHeader().setReorderingAllowed(false);
        importTableSF1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                importTableSF1loadStudentHandler(evt);
            }
        });
        jScrollPane18.setViewportView(importTableSF1);
        if (importTableSF1.getColumnModel().getColumnCount() > 0) {
            importTableSF1.getColumnModel().getColumn(0).setPreferredWidth(100);
            importTableSF1.getColumnModel().getColumn(1).setPreferredWidth(250);
            importTableSF1.getColumnModel().getColumn(2).setPreferredWidth(80);
            importTableSF1.getColumnModel().getColumn(3).setPreferredWidth(80);
            importTableSF1.getColumnModel().getColumn(4).setPreferredWidth(70);
            importTableSF1.getColumnModel().getColumn(5).setPreferredWidth(150);
            importTableSF1.getColumnModel().getColumn(6).setPreferredWidth(100);
            importTableSF1.getColumnModel().getColumn(7).setPreferredWidth(100);
            importTableSF1.getColumnModel().getColumn(8).setPreferredWidth(100);
            importTableSF1.getColumnModel().getColumn(9).setPreferredWidth(100);
            importTableSF1.getColumnModel().getColumn(10).setPreferredWidth(100);
            importTableSF1.getColumnModel().getColumn(11).setPreferredWidth(100);
            importTableSF1.getColumnModel().getColumn(12).setPreferredWidth(250);
            importTableSF1.getColumnModel().getColumn(13).setPreferredWidth(250);
            importTableSF1.getColumnModel().getColumn(14).setPreferredWidth(250);
            importTableSF1.getColumnModel().getColumn(15).setPreferredWidth(100);
            importTableSF1.getColumnModel().getColumn(16).setPreferredWidth(100);
            importTableSF1.getColumnModel().getColumn(17).setPreferredWidth(200);
            importTableSF1.getColumnModel().getColumn(18).setPreferredWidth(200);
        }

        importTablesTab.addTab("SF1", jScrollPane18);

        importTableSF10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "LRN", "Name", "Gender", "Birthday", "Elem. Grade", "School ID", "School", "School Address", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        importTableSF10.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        importTableSF10.getTableHeader().setReorderingAllowed(false);
        importTableSF10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                importTableSF10loadStudentHandler(evt);
            }
        });
        jScrollPane20.setViewportView(importTableSF10);
        if (importTableSF10.getColumnModel().getColumnCount() > 0) {
            importTableSF10.getColumnModel().getColumn(0).setPreferredWidth(100);
            importTableSF10.getColumnModel().getColumn(1).setPreferredWidth(250);
            importTableSF10.getColumnModel().getColumn(2).setPreferredWidth(80);
            importTableSF10.getColumnModel().getColumn(3).setPreferredWidth(80);
            importTableSF10.getColumnModel().getColumn(4).setPreferredWidth(100);
            importTableSF10.getColumnModel().getColumn(5).setPreferredWidth(150);
            importTableSF10.getColumnModel().getColumn(6).setPreferredWidth(200);
            importTableSF10.getColumnModel().getColumn(7).setPreferredWidth(200);
            importTableSF10.getColumnModel().getColumn(8).setPreferredWidth(100);
        }

        importTablesTab.addTab("SF10", jScrollPane20);

        jLabel95.setText("Select Excel File Format");

        jcbFileFormats.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HiSRMS-SF1 JHS (Default)", "LIS-SF1 JHS v2014.2.1.1", "CBNHS - SF10" }));

        tfFileLocation.setEditable(false);

        btnOpenFileExplorer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_opened_folder_16px.png"))); // NOI18N
        btnOpenFileExplorer.setText("Select File");
        btnOpenFileExplorer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenFileExplorerActionPerformed(evt);
            }
        });

        btnRegisterStudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_add_user_group_woman_man_16px.png"))); // NOI18N
        btnRegisterStudents.setText("Register Students");
        btnRegisterStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterStudentsActionPerformed(evt);
            }
        });

        btnCancelImport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_close_window_25px.png"))); // NOI18N
        btnCancelImport.setEnabled(false);
        btnCancelImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelImportActionPerformed(evt);
            }
        });

        jpbProgressBar.setBackground(new java.awt.Color(255, 255, 255));
        jpbProgressBar.setMinimum(5);
        jpbProgressBar.setToolTipText("");
        jpbProgressBar.setValue(0);

        lbProgressMessage.setText("Select a file first...");

        cbUpdateExisting.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        cbUpdateExisting.setText("Update Existing Records?");
        cbUpdateExisting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_unchecked_checkbox_20px.png"))); // NOI18N
        cbUpdateExisting.setOpaque(false);
        cbUpdateExisting.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_checked_checkbox_20px.png"))); // NOI18N

        javax.swing.GroupLayout importStudentsTabLayout = new javax.swing.GroupLayout(importStudentsTab);
        importStudentsTab.setLayout(importStudentsTabLayout);
        importStudentsTabLayout.setHorizontalGroup(
            importStudentsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(importStudentsTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(importStudentsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(importStudentsTabLayout.createSequentialGroup()
                        .addComponent(jcbFileFormats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfFileLocation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOpenFileExplorer))
                    .addGroup(importStudentsTabLayout.createSequentialGroup()
                        .addGroup(importStudentsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jpbProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbProgressMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelImport, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(importStudentsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRegisterStudents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbUpdateExisting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(importStudentsTabLayout.createSequentialGroup()
                        .addComponent(jLabel95)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(importTablesTab))
                .addContainerGap())
        );
        importStudentsTabLayout.setVerticalGroup(
            importStudentsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, importStudentsTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel95)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(importStudentsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbFileFormats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfFileLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOpenFileExplorer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(importTablesTab, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(importStudentsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, importStudentsTabLayout.createSequentialGroup()
                        .addComponent(cbUpdateExisting)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegisterStudents))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, importStudentsTabLayout.createSequentialGroup()
                        .addGroup(importStudentsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCancelImport, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpbProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbProgressMessage)))
                .addContainerGap())
        );

        jtbImportTabs.addTab("Import Students", importStudentsTab);

        javax.swing.GroupLayout importDialogLayout = new javax.swing.GroupLayout(importDialog);
        importDialog.setLayout(importDialogLayout);
        importDialogLayout.setHorizontalGroup(
            importDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(importDialogLayout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jtbImportTabs)
        );
        importDialogLayout.setVerticalGroup(
            importDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(importDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtbImportTabs))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dashboard");
        setIconImage(my.getImgIcn(myVariables.getRegistrationWindowIcon()).getImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                logoutHandler(evt);
            }
        });

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 255, 204));
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 204));

        headerPanel.setBackground(new java.awt.Color(22, 66, 33));

        lbSchoolName.setBackground(new java.awt.Color(255, 255, 255));
        lbSchoolName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbSchoolName.setForeground(new java.awt.Color(255, 255, 255));
        lbSchoolName.setText("SCHOOL_NAME Registration System");

        lbSchoolAddress.setBackground(new java.awt.Color(255, 255, 255));
        lbSchoolAddress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbSchoolAddress.setForeground(new java.awt.Color(255, 255, 255));
        lbSchoolAddress.setText("SCHOOL_ADDRESS");

        lbLoggedInUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbLoggedInUser.setForeground(new java.awt.Color(255, 255, 255));
        lbLoggedInUser.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbLoggedInUser.setText("Welcome USER_NAME, ACCESS_LEVEL");

        btnImportFromLis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_upward_arrow_16px.png"))); // NOI18N
        btnImportFromLis.setText("Import from LIS");
        btnImportFromLis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportFromLisActionPerformed(evt);
            }
        });

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
                        .addComponent(btnImportFromLis)))
                .addContainerGap())
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSchoolName)
                    .addComponent(lbLoggedInUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSchoolAddress)
                    .addComponent(btnImportFromLis))
                .addContainerGap(20, Short.MAX_VALUE))
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
            .addComponent(mainTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainTab, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logoutHandler(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_logoutHandler
        my.openWindow(this, new login());
    }//GEN-LAST:event_logoutHandler

    private void addNewStudentHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewStudentHandler
        //Retrieve field values
        //String studentId = studentTable.getValueAt(studentTable.getSelectedRow(), 0).toString();
        
        String [] fields = {
            "null",
            my.convertEscapeCharacters(tfFname.getText().trim()),
            my.convertEscapeCharacters(tfMname.getText().trim()).length() > 0 ?my.convertEscapeCharacters(tfMname.getText().trim()) : " ",
            my.convertEscapeCharacters(tfLName.getText().trim()),
            tfStudentLrn.getText(),
            rbMale.isSelected()?"Male":"Female",
            tfInitialGrade.getText(),
            "0",
            my.convertEscapeCharacters(tfSchoolId.getText().trim()).length() > 0 ?my.convertEscapeCharacters(tfSchoolId.getText().trim()) : " ",
            my.convertEscapeCharacters(tfSchoolName.getText().trim()).length() > 0 ?my.convertEscapeCharacters(tfSchoolName.getText().trim()) : " ",
            my.convertEscapeCharacters(tfSchoolAddress.getText().trim()).length() > 0 ?my.convertEscapeCharacters(tfSchoolAddress.getText().trim()) : " ",
            "JHS"
        };
        
        //Validate Fields
        for(int n=0;n<fields.length;n++){
            if(fields[n].length() <=0){
                my.showMessage("Please Fill-up all fields.", JOptionPane.WARNING_MESSAGE);
                return;
            }
            //Validate lrn
            if(n == 4){
                if(fields[n].length() != 12){
                    my.showMessage("LRN must be 12-digit number.", JOptionPane.ERROR_MESSAGE);
                    return;
                }else{
                    if(fields[n].contains(".")){
                        my.showMessage("LRN must not have a decimal point.", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    try {
                        Float.parseFloat(fields[n]);
                    } catch (Exception e) {
                        System.err.println(e.getLocalizedMessage());
                        my.showMessage("Invalid LRN", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }
            //Validate grade
            if(n == 6){
                try {
                    Double.parseDouble(fields[n]);
                } catch (NumberFormatException e) {
                    my.showMessage("Invalid Grade.", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }
        
        //Check for duplicate LRN
        String [] result = my.return_values("*", "v_students_jhs", "WHERE lrn = '"+fields[4]+"'", myVariables.getStudentsOrder());
        
        if(result != null){
            String student[] = my.toNameFormat(result[0], new int[] {2,3,4}).split("@@");
            
            my.showMessage("LRN already exists. \n\nStudent with existing LRN:\n\t\t"+student[2], JOptionPane.ERROR_MESSAGE);
            return;
        }
        //Add
        if(my.add_values("students", "id,fName,mName,lName,lrn,sex,inGr,curGrLvl,schoolId,schoolName,schoolAddress,dep_type", fields)){
            my.showMessage("Student added successfully", JOptionPane.INFORMATION_MESSAGE);
        }else{
            my.showMessage("Adding Failed. Make sure you are connected to the School Network.", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //Reset Table
        searchStudentHandler(evt);
    }//GEN-LAST:event_addNewStudentHandler

    private void searchStudentHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchStudentHandler
        String toSearch = my.convertEscapeCharacters(tfSearchStudent.getText().trim());
        String where = "WHERE lrn='"+toSearch+"' ";
        
        if(myVariables.getAccessLevel() <5){
            where = "WHERE lrn='"+toSearch+"' OR lName LIKE'%"+toSearch+"%' OR fName LIKE'%"+toSearch+"%' OR mName LIKE'%"+toSearch+"%' LIMIT 50";
            my.searchItem(where, studentTable, 0, null, null, false, true, lbSearchResult, tfSearchStudent,true);
        }else{
            where = "WHERE lrn='"+toSearch+"' OR lName LIKE'%"+toSearch+"%' OR fName LIKE'%"+toSearch+"%' OR mName LIKE'%"+toSearch+"%'";
            my.searchItem(where, studentTable, 0, null, null, false, true, lbSearchResult, tfSearchStudent,true);
        }
        clearAddStudentFields();
        
        if(jTabbedPane2.getTabCount() > 1){
            jTabbedPane2.removeTabAt(1);
        }
    }//GEN-LAST:event_searchStudentHandler

    private void jcbGradeLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbGradeLevelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbGradeLevelActionPerformed

    private void jcbGradeLevel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbGradeLevel1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbGradeLevel1ActionPerformed

    private void searchSubjects(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchSubjects
        String toSearch = tfSearchSubject.getText().trim();
        String where = "WHERE subjectCode LIKE '%"+toSearch+"%' OR description LIKE '%"+toSearch+"%'";
        
        if(subjectsTab.getTabCount() > 1){
            subjectsTab.removeTabAt(1);
        }        
        my.searchItem(where, subjectTable, 1,null, null, false, true, lbSearchResult2, tfSearchSubject,true);
    }//GEN-LAST:event_searchSubjects

    private void loadStudentPersonalInfo(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadStudentPersonalInfo
        if(evt.getClickCount() == 2 && studentTable1.getSelectedRow() != -1){
            int row = studentTable1.getSelectedRow();
            String studentId = studentTable1.getValueAt(row, 0).toString();
            
            String [] result = my.return_values("*", "personalinfo", "where stdId = '"+studentId+"'", myVariables.getStudentsPersonalInfoOrder());
            
            //Check if personal info record already exists. If not, create one
            if(result == null || result.length == 0){
                if(my.getConfirmation("This student has no personal records yet.\nAdd one now?")){
                    String [] fields = {
                        "null",
                        studentId,
                    };
                    
                    if(my.add_values("personalInfo", "id,stdId", fields)){
                        my.showMessage("Personal Record Created successfully.\nPlease select the student again afterwards.", JOptionPane.INFORMATION_MESSAGE);
                        enableDisablePersonalInfoFields(false, false);
                        return;
                    }else{
                        my.showMessage("Adding Failed. Please make sure you are connected to the school network.", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }else{
                    return;
                }
            }
            
            //System.out.println(result[0]);
            String [] info = result[0].split("@@");
            
            tfBdate.setText(info[2]);
            tfAge.setText(info[3]);
            tfMotherTongue.setText(info[4]);
            tfEthnicGroup.setText(info[5]);
            tfReligion.setText(info[6]);
            
            tfHouseNumber.setText(info[7]);
            tfBarangay.setText(info[8]);
            tfMunicipality.setText(info[9]);
            tfProvince.setText(info[10]);
            
            tfFathersName.setText(info[11]);
            tfMothersName.setText(info[12]);
            
            tfGuardiansName.setText(info[13]);
            tfRelationship.setText(info[14]);
            tfContactNumber.setText(info[15]);
            
            enableDisablePersonalInfoFields(false, false);
            
        }else{
            //clear fields
            enableDisablePersonalInfoFields(false, true);
        }
    }//GEN-LAST:event_loadStudentPersonalInfo

    private void searchStudentForPrsnlInfHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchStudentForPrsnlInfHandler
        String toSearch = my.convertEscapeCharacters(tfSearchStudent1.getText().trim());
        String where = "WHERE lrn='"+toSearch+"' ";
        
        if(myVariables.getAccessLevel() <5){
            where = "WHERE lrn='%"+toSearch+"%' OR lName LIKE'%"+toSearch+"%' OR fName LIKE'%"+toSearch+"%' OR mName LIKE'%"+toSearch+"%' LIMIT 50";
            my.searchItem(where, studentTable1, 0, null, null, false, true, lbSearchResult1, tfSearchStudent1,true);
        }else{
            where = "WHERE lrn='%"+toSearch+"%' OR lName LIKE'%"+toSearch+"%' OR fName LIKE'%"+toSearch+"%' OR mName LIKE'%"+toSearch+"%'";
            my.searchItem(where, studentTable1, 0, null, null, false, true, lbSearchResult1, tfSearchStudent1,true);
        }
        enableDisablePersonalInfoFields(false, true);
    }//GEN-LAST:event_searchStudentForPrsnlInfHandler

    private void editPersonalInfoHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPersonalInfoHandler
        enableDisablePersonalInfoFields(true, false);
    }//GEN-LAST:event_editPersonalInfoHandler

    private void jcbGradeLevel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbGradeLevel2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbGradeLevel2ActionPerformed

    private void searchLoadsHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchLoadsHandler
        String toSearch = my.convertEscapeCharacters(tfSearchSubjectLoad.getText().trim());
        String where = "WHERE b_loadName LIKE '%"+toSearch+"%' ";
        
        if(subjectLoadTabs.getTabCount() > 1){
            subjectLoadTabs.remove(1);
        }
        my.searchItem(where, subjectTable1, 2, null, null, false, true, lbSearchResult3, tfSearchSubjectLoad, true);
    }//GEN-LAST:event_searchLoadsHandler

    private void findSubjectHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findSubjectHandler
        String toSearch = my.convertEscapeCharacters(tfSearchSubject2.getText());
        
        String gradeLevelSelected [] = jcbGradeLevel3.getSelectedItem().toString().split(" ");
        
        my.searchItem(
                "WHERE (subjectCode LIKE '%"+toSearch+"%' OR description LIKE '%"+toSearch+"%') AND gradeLevel = '"+gradeLevelSelected[1]+"'",
                searchedsubjectTable,
                1,
                null,null,
                false, true,
                null, tfSearchSubject2, true);
    }//GEN-LAST:event_findSubjectHandler

    private void subjectLoadGradeLevelChangedHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectLoadGradeLevelChangedHandler
        my.clear_table_rows(searchedsubjectTable);
        my.clear_table_rows(selectedSubjectTable);
    }//GEN-LAST:event_subjectLoadGradeLevelChangedHandler

    private void addSubjectToLoadHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSubjectToLoadHandler
        if(searchedsubjectTable.getSelectedRow() != -1){
            //Get selected subjects list
            int [] selectedRows = searchedsubjectTable.getSelectedRows();
            boolean matchFound;
            
            for(int n=0;n<selectedRows.length;n++){
                //get current selected subject ID
                int subjectId = Integer.parseInt(searchedsubjectTable.getValueAt(selectedRows[n], 0).toString());
                matchFound = false;
                
                if(selectedSubjectTable.getRowCount() == 13){
                    my.showMessage("You have reached the maximum\n number of subjects for this Subject Load.", JOptionPane.ERROR_MESSAGE);
                    break;
                }
                
                //Compare with id with selected subject table Ids if duplicate already exists
                for(int x=0;x<selectedSubjectTable.getRowCount();x++){
                    int selectedSubjectId = Integer.parseInt(selectedSubjectTable.getValueAt(x, 0).toString());
                    
                    if(subjectId == selectedSubjectId){
                        matchFound = true;
                        break;
                    }
                }
                //Add new subject to list
                if(!matchFound){
                    String newSubject = my.get_table_row_values(selectedRows[n], searchedsubjectTable);
                    my.add_table_row(newSubject, selectedSubjectTable);
                }
            }
        }else{
            my.showMessage("Please select at least 1 subject to add to the list.", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_addSubjectToLoadHandler

    private void removeSubjectFromListHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeSubjectFromListHandler
        if(selectedSubjectTable.getSelectedRow() != -1){
            int selectedRows [] = selectedSubjectTable.getSelectedRows();
            
            //Start deleting from the last index to avoid errors
            for(int n=selectedRows.length-1;n>=0;n--){
                my.remove_table_row(selectedSubjectTable, selectedRows[n]);
            }
        }else{
            my.showMessage("No subject selected to remove.", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_removeSubjectFromListHandler

    private void subjectTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subjectTable1MouseClicked
        if(subjectTable1.getSelectedRow() != -1 && evt.getClickCount() == 2){
            if(subjectLoadTabs.getTabCount() <= 1){
                int row = subjectTable1.getSelectedRow();
                
                //Add "Edit Load" tab to "subjectLoadTabs" again
                
                subjectLoadTabs.add("Edit Load", editLoadTab);
                subjectLoadTabs.setSelectedIndex(1);
                
                //Assign Values to fields and search for subjects
                String loadId = subjectTable1.getValueAt(row, 0).toString();
                String loadName = subjectTable1.getValueAt(row, 1).toString();
                String subjectsContained = "";
                int gradeLevel = Integer.parseInt(subjectTable1.getValueAt(row, 2).toString());
                
                try {
                    subjectsContained = subjectTable1.getValueAt(row, 3).toString();
                    subjectsContained = subjectsContained.replace(':', ',');
                } catch (Exception e) {
                    System.err.println("Subject Contained is empty");
                }
                
                lbLoadId.setText(loadId);
                tfLoadName.setText(loadName);
                switch(gradeLevel){
                    case 7:{
                        jcbGradeLevel3.setSelectedIndex(0);break;
                    }case 8:{
                        jcbGradeLevel3.setSelectedIndex(1);break;
                    }case 9:{
                        jcbGradeLevel3.setSelectedIndex(2);break;
                    }case 10:{
                        jcbGradeLevel3.setSelectedIndex(3);break;
                    }default:{
                        jcbGradeLevel3.setSelectedIndex(0);break;
                    }
                }
                
                //Check if there is at least one subject to search
                if(subjectsContained.length() >=2){                    
                    if(subjectsContained.charAt(subjectsContained.length()-1) == ','){
                        subjectsContained = subjectsContained.substring(0, subjectsContained.length()-1);
                        System.err.println("Comma found...deleting");
                    }
                    
                    my.searchItem("WHERE id IN ("+subjectsContained+") ORDER BY FIELD(id,"+subjectsContained+")", selectedSubjectTable, 1, null, null, false, true, null, tfSearchSubject2, true);
                }else{
                    my.clear_table_rows(selectedSubjectTable);
                }
                
                System.err.println(subjectsContained);
            }
        }else{
            //Remove edit tab
            if(subjectLoadTabs.getTabCount() > 1){
                subjectLoadTabs.remove(1);
            }
        }
    }//GEN-LAST:event_subjectTable1MouseClicked

    private void tfLName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfLName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfLName1ActionPerformed

    private void jcbGender2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbGender2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbGender2ActionPerformed

    private void addNewUserHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewUserHandler
        //Get text fields
        String [] fields = {
            "null",
            my.convertEscapeCharacters(tfLName1.getText().trim()),
            my.convertEscapeCharacters(tfFname1.getText().trim()),
            my.convertEscapeCharacters(tfMname1.getText().trim().length()>0? tfMname1.getText().trim() : " "),
            jcbGender2.getSelectedIndex()==0?"Male":"Female",
            my.convertEscapeCharacters(tfUserName.getText()),
            my.convertEscapeCharacters(tfPassword.getText()),
            String.valueOf(jcbAccessLevel.getSelectedIndex()+1),
        };
        
        for(String n : fields){
            System.err.println(n);
            if(n.length() == 0){
                
                my.showMessage("Please fill-up all fields.", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        //Search for duplicate username
        String [] result = my.return_values("*", "v_users_jhs", "WHERE user_name ='"+fields[5]+"'", myVariables.getUsersOrder());
        
        if(result != null){
            my.showMessage("User name already exists. Please use another one.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        //Add User
        if(my.add_values("users", "id,user_Lname,user_Fname,user_Mname,gender,user_name,user_password,user_level",fields)){
            my.showMessage("New User Added successfully.", JOptionPane.INFORMATION_MESSAGE);
            clearAddUserFields();
        }else{
            my.showMessage("Adding Failed. Please make sure you connected to the school network.", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //Refresh
        searchUsersHander(evt);
    }//GEN-LAST:event_addNewUserHandler

    private void jcbGender1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbGender1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbGender1ActionPerformed

    private void jcbAccessLevel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAccessLevel1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbAccessLevel1ActionPerformed

    private void jcbAccessLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAccessLevelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbAccessLevelActionPerformed

    private void searchUsersHander(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchUsersHander
        String toSearch = my.convertEscapeCharacters(tfSearchUser.getText().trim());
        String where = "WHERE user_Lname='"+toSearch+"' OR user_Fname='"+toSearch+"' OR user_Mname='"+toSearch+"'";
        String order = " ORDER BY user_level DESC,user_Lname ASC,user_Fname ASC, user_Mname ASC";
        
        if(myVariables.getAccessLevel() <5){
            where = "WHERE user_Lname LIKE'%"+toSearch+"%' OR user_Fname LIKE'%"+toSearch+"%' OR user_Mname LIKE'%"+toSearch+"%' LIMIT 50";
            my.searchItem(where+order, usersTable, 3, null, null, false, true, lbSearchResult4, tfSearchUser,true);
        }else{
            where = "WHERE user_Lname LIKE'%"+toSearch+"%' OR user_Fname LIKE'%"+toSearch+"%' OR user_Mname LIKE'%"+toSearch+"%'";
            my.searchItem(where+order, usersTable, 3, null, null, false, true, lbSearchResult4, tfSearchUser,true);
        }
        
        if(usersTab.getTabCount() > 1){
            usersTab.remove(1);
        }
        //my.searchItem("", usersTable, 3, null, null, false, true, lbSearchResult4, tfSearchUser, true);
    }//GEN-LAST:event_searchUsersHander

    private void usersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersTableMouseClicked
        int row = usersTable.getSelectedRow();
        
        if(row != -1 && evt.getClickCount() == 2){
            //Add "edit user" tab
            if(usersTab.getTabCount() <=1){
                usersTab.addTab("Edit User", editUserTab);
                usersTab.setSelectedIndex(1);
            }
            //Retrieve values from table
            String userId = usersTable.getValueAt(row, 0).toString();
            String lName = usersTable.getValueAt(row, 1).toString();
            String fName = usersTable.getValueAt(row, 2).toString();
            String mName = usersTable.getValueAt(row, 3).toString();
            String gender = usersTable.getValueAt(row, 4).toString();
            String userName = usersTable.getValueAt(row, 5).toString();
            String password = usersTable.getValueAt(row, 6).toString();
            int accessLevel = Integer.parseInt(usersTable.getValueAt(row, 7).toString());
            
            if(accessLevel == 5){
                if(jcbAccessLevel1.getItemCount() < 5){
                    jcbAccessLevel1.addItem("5 = Administrator");
                }
            }else{
                if(jcbAccessLevel1.getItemCount() >= 5){
                    jcbAccessLevel1.removeItemAt(4);
                }
            }
            
            //Set field values
            tfFname2.setText(fName);
            tfMname2.setText(mName);
            tfLName2.setText(lName);
            
            if(gender.contains("f") || gender.contains("F")){
                jcbGender1.setSelectedIndex(1);
            }else{
                jcbGender1.setSelectedIndex(0);
            }
            
            tfUserName1.setText(userName);
            tfPassword1.setText(password);
            
            System.err.println("Access Level: "+accessLevel);
            
            switch(accessLevel){
                case 1:{
                    jcbAccessLevel1.setSelectedIndex(0);
                    break;
                }case 2:{
                    jcbAccessLevel1.setSelectedIndex(1);
                    break;
                }case 3:{
                    jcbAccessLevel1.setSelectedIndex(2);
                    break;
                }case 4:{
                    jcbAccessLevel1.setSelectedIndex(3);
                    break;
                }case 5:{
                    jcbAccessLevel1.setSelectedIndex(4);
                    break;
                }default:{
                    jcbAccessLevel1.setSelectedIndex(1);
                    break;
                }
            }
            
        }else{
            //Clear edit tab
            if(usersTab.getTabCount() > 1){
                usersTab.remove(1);
            }
        }
    }//GEN-LAST:event_usersTableMouseClicked

    private void tfUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUserNameActionPerformed

    private void tfPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPasswordActionPerformed

    private void searchUserPersonalInfoHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchUserPersonalInfoHandler
        String toSearch = my.convertEscapeCharacters(tfSearchUser1.getText().trim());
        String where = "WHERE (user_Lname='"+toSearch+"' OR user_Fname='"+toSearch+"' OR user_Mname='"+toSearch+"') AND user_level='2'";
        String order = " ORDER BY user_level DESC,user_Lname ASC,user_Fname ASC, user_Mname ASC";
        
        if(myVariables.getAccessLevel() <5){
            where = "WHERE user_Lname LIKE'%"+toSearch+"%' OR user_Fname LIKE'%"+toSearch+"%' OR user_Mname LIKE'%"+toSearch+"%' LIMIT 50";
            my.searchItem(where+order, usersTable1, 3, null, null, false, true, lbSearchResult5, tfSearchUser1,true);
        }else{
            where = "WHERE user_Lname LIKE'%"+toSearch+"%' OR user_Fname LIKE'%"+toSearch+"%' OR user_Mname LIKE'%"+toSearch+"%'";
            my.searchItem(where+order, usersTable1, 3, null, null, false, true, lbSearchResult5, tfSearchUser1,true);
        }
        
        //my.searchItem("", usersTable1, 3, null, null, false, true, lbSearchResult5, tfSearchUser1, true);
        enableDisableUsersPersonalInfoFields(false, true);
    }//GEN-LAST:event_searchUserPersonalInfoHandler

    private void usersTable1loadStudentPersonalInfo(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersTable1loadStudentPersonalInfo
        if(evt.getClickCount() == 2 && usersTable1.getSelectedRow() != -1){
            int row = usersTable1.getSelectedRow();
            String userId = usersTable1.getValueAt(row, 0).toString();
            String accessLevel = usersTable1.getValueAt(row, 7).toString();
            
            String [] result = my.return_values("*", "userdetails", "where userId = '"+userId+"'", myVariables.getUsersPersonalInfoOrder());
            
            
            //Check if records exists. If not, ask to create one.
            if(result == null){
                if(my.getConfirmation("This user has no personal records yet.\nAdd one now?")){
                    String [] fields = {
                        "null",
                        userId,
                    };
                    
                    if(my.add_values("userdetails", "id,userId", fields)){
                        my.showMessage("Record Created Successfully. Please select the user again.", JOptionPane.INFORMATION_MESSAGE);
                        searchUserPersonalInfoHandler(new ActionEvent(usersTable1, 0, "null"));
                        return;
                    }else{
                        my.showMessage("Adding Failed. Please make sure you are connected to the school network.", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }else{
                    return;
                }
            }
            System.out.println(result[0]);
            String [] info = result[0].split("@@");
            
            lbUserInfoId.setText(info[0]);
            tfEmployeeNumber.setText(info[2]);
            tfFundSource.setText(info[3]);
            tfPosition.setText(info[4]);
            tfNatureOfAppointment.setText(info[5]);
            
            tfDegree.setText(info[6]);
            tfMajor.setText(info[7]);
            tfMinor.setText(info[8]);
            
            enableDisableUsersPersonalInfoFields(false, false);
            enableDisableManagedSubjectButtons(false, true);
            
            if(!accessLevel.equalsIgnoreCase("2") && !accessLevel.equalsIgnoreCase("5")){
                btnEditAssignedSubject.setEnabled(false);   //Disable manage Subject Edit
            }
            
            //Loading Managed Subjects
            String subjectsContained = info[9];
            try {
                subjectsContained = subjectsContained.replace(':', ',');
            } catch (Exception e) {
                System.err.println("Subject Contained is empty");
            }
            //Check if there is at least one subject to search
            if(subjectsContained.length() >=2 && !subjectsContained.contains("NONE")){                    
                if(subjectsContained.charAt(subjectsContained.length()-1) == ','){
                    subjectsContained = subjectsContained.substring(0, subjectsContained.length()-1);
                    System.err.println("Comma found...deleting");
                }

                my.searchItem("WHERE id IN ("+subjectsContained+")", managedSubjectTable, 1, null, null, false, true, null, tfSearchSubject2, true);
            }else{
                my.clear_table_rows(selectedSubjectTable);
            }
        }else{
            //clear fields
            enableDisableUsersPersonalInfoFields(false, true);
            enableDisableManagedSubjectButtons(false, false);
        }
    }//GEN-LAST:event_usersTable1loadStudentPersonalInfo

    private void tfEmployeeNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEmployeeNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEmployeeNumberActionPerformed

    private void tfFundSourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFundSourceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFundSourceActionPerformed

    private void tfNatureOfAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNatureOfAppointmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNatureOfAppointmentActionPerformed

    private void tfDegreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDegreeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDegreeActionPerformed

    private void tfMajorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfMajorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfMajorActionPerformed

    private void tfMinorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfMinorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfMinorActionPerformed

    private void btnEdit1editPersonalInfoHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdit1editPersonalInfoHandler
        enableDisableUsersPersonalInfoFields(true, false);
    }//GEN-LAST:event_btnEdit1editPersonalInfoHandler

    private void btnSaveChanges6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveChanges6ActionPerformed
        //Get Values
        String userInfoId = lbUserInfoId.getText();
        String empNum = my.convertEscapeCharacters(tfEmployeeNumber.getText());
        String fundSrc = my.convertEscapeCharacters(tfFundSource.getText().trim());
        String posDes = my.convertEscapeCharacters(tfPosition.getText().trim());
        String noaEs = my.convertEscapeCharacters(tfNatureOfAppointment.getText().trim());
        String major = my.convertEscapeCharacters(tfMajor.getText().trim());
        String minor = my.convertEscapeCharacters(tfMinor.getText().trim());
        
        String [] sets = {
            "employeeNumber='"+empNum+"'",
            "fundSource='"+fundSrc+"'",
            "position='"+posDes+"'",
            "nature='"+noaEs+"'",
            "major='"+major+"'",
            "minor='"+minor+"'",
        };
        
        if(my.update_values("userdetails", sets, "id='"+userInfoId+"'")){
            my.showMessage("Update Successful.", JOptionPane.INFORMATION_MESSAGE);
            //clear fields
            enableDisableUsersPersonalInfoFields(false, true);
            enableDisableManagedSubjectButtons(false, false);
        }else{
            my.showMessage("Update Failed. Please make sure you are connectecd to the School Network.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveChanges6ActionPerformed

    private void btnEditAssignedSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditAssignedSubjectActionPerformed
        int row = usersTable1.getSelectedRow();
        
        if(row != -1){
            int accessLevel = Integer.parseInt(usersTable1.getValueAt(row, 7).toString());
            
            if(accessLevel != 2 && accessLevel != 5 && myVariables.getAccessLevel() != 5){
                my.showMessage("Users with an access level "+2+" ("+myVariables.getAccessLevelName(2)+") can only be assigned.", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }else{
            my.showMessage("No User Selected.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        enableDisableManagedSubjectButtons(true, false);
    }//GEN-LAST:event_btnEditAssignedSubjectActionPerformed

    private void tfPositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPositionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPositionActionPerformed

    private void loadStudentHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadStudentHandler
        System.err.println("Selected col " + studentTable.getSelectedColumn());
        
        if(evt.getClickCount() == 2 && studentTable.getSelectedRow() != -1){
            int row = studentTable.getSelectedRow();
            String studentId = studentTable.getValueAt(row, 0).toString();
            
            //Retrieve Values
            String [] result = my.return_values("*", "v_students_jhs", "where id = '"+studentId+"'", myVariables.getStudentsOrder());
            System.out.println(result[0]);
            String [] info = result[0].split("@@");
            
            //Load fields
            tfLastName1.setText(info[2]);
            tfFirstName1.setText(info[3]);
            tfMiddleName1.setText(info[4]);
            
            tfStudentLrn1.setText(info[1]);
            tfInitialGrade1.setText(info[6]);
            
            tfSchoolId1.setText(info[8]);
            tfSchoolName1.setText(info[9]);
            tfSchoolAddress1.setText(info[10]);
            
            if(info[5].contains("f") || info[5].contains("F")){
                rbFemale1.setSelected(true);
            }else{
                rbMale1.setSelected(true);
            }
            
            //re-add edit tab
            jTabbedPane2.addTab("Edit Student", jScrollPane7);
            jTabbedPane2.setSelectedIndex(1);
        }else{
            if(jTabbedPane2.getTabCount() > 1){
                jTabbedPane2.removeTabAt(1);
            }
        }
    }//GEN-LAST:event_loadStudentHandler

    private void updateStudentHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateStudentHandler
        //Retrieve field values
        String studentId = studentTable.getValueAt(studentTable.getSelectedRow(), 0).toString();
        
        String [] fields = {
            my.convertEscapeCharacters(tfLastName1.getText().trim()),
            my.convertEscapeCharacters(tfFirstName1.getText().trim()),
            my.convertEscapeCharacters(tfMiddleName1.getText().trim()).length() > 0 ? my.convertEscapeCharacters(tfMiddleName1.getText().trim()) : " ",
            tfStudentLrn1.getText(),
            rbMale1.isSelected()?"Male":"Female",
            tfInitialGrade1.getText(),
            my.convertEscapeCharacters(tfSchoolId1.getText().trim()).length() > 0 ?my.convertEscapeCharacters(tfSchoolId1.getText().trim()) : " ",
            my.convertEscapeCharacters(tfSchoolName1.getText().trim()).length() > 0 ?my.convertEscapeCharacters(tfSchoolName1.getText().trim()) : " ",
            my.convertEscapeCharacters(tfSchoolAddress1.getText().trim()).length() > 0 ?my.convertEscapeCharacters(tfSchoolAddress1.getText().trim()) : " ",
        };
        
        //Validate Fields
        for(int n=0;n<fields.length;n++){
            if(fields[n].length() <=0){
                my.showMessage("Please Fill-up all fields.", JOptionPane.WARNING_MESSAGE);
                return;
            }
            //Validate lrn
            if(n == 3){
                if(fields[n].length() != 12){
                    my.showMessage("LRN must be 12-digit number.", JOptionPane.ERROR_MESSAGE);
                    return;
                }else{
                    if(fields[n].contains(".")){
                        my.showMessage("LRN must not have a decimal point.", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    try {
                        Float.parseFloat(fields[n]);
                    } catch (Exception e) {
                        System.err.println(e.getLocalizedMessage());
                        my.showMessage("Invalid LRN", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }
            //Validate grade
            if(n == 5){
                try {
                    Double.parseDouble(fields[n]);
                } catch (NumberFormatException e) {
                    my.showMessage("Invalid Grade.", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }
        
        //Check for duplicate LRN
        String [] result = my.return_values("*", "v_students_jhs", "WHERE lrn='"+fields[3]+"'AND id!='"+studentId+"'", myVariables.getStudentsOrder());
        
        if(result != null){
            String student[] = my.toNameFormat(result[0], new int[] {2,3,4}).split("@@");
            
            my.showMessage("LRN already exists. \n\nStudent with existing LRN:\n\t\t"+student[2], JOptionPane.ERROR_MESSAGE);
            return;
        }
        //Update fields to set notation
        String [] sets = {
            "lName='"+fields[0]+"'",
            "fName='"+fields[1]+"'",
            "mName='"+fields[2]+"'",
            "lrn='"+fields[3]+"'",
            "sex='"+fields[4]+"'",
            "inGr='"+fields[5]+"'",
            "schoolId='"+fields[6]+"'",
            "schoolName='"+fields[7]+"'",
            "schoolAddress='"+fields[8]+"'"
        };
        //Update
        if(my.update_values("students", sets, "id = '"+studentId+"'")){
            my.showMessage("Student Updated successfully", JOptionPane.INFORMATION_MESSAGE);
        }else{
            my.showMessage("Update Failed. Make sure you are connected to the School Network.", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //Reset Table
        searchStudentHandler(evt);
    }//GEN-LAST:event_updateStudentHandler

    private void savePersonalInfoChangesHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePersonalInfoChangesHandler
        String studentId = studentTable1.getValueAt(studentTable1.getSelectedRow(), 0).toString();
        
        //<editor-fold desc="Retrieve Values By Batch">
        String [] basic = {
            "bDate='"+my.convertEscapeCharacters(tfBdate.getText())+"'",
            "age='"+my.convertEscapeCharacters(tfAge.getText())+"'",
            "mTongue='"+my.convertEscapeCharacters(tfMotherTongue.getText())+"'",
            "ip='"+my.convertEscapeCharacters(tfEthnicGroup.getText())+"'",
            "rlgn='"+my.convertEscapeCharacters(tfReligion.getText())+"'",            
        };
        String [] address = {
            "houseN='"+my.convertEscapeCharacters(tfHouseNumber.getText())+"'",
            "brgy='"+my.convertEscapeCharacters(tfBarangay.getText())+"'",
            "mncpl='"+my.convertEscapeCharacters(tfMunicipality.getText())+"'",
            "prvnce='"+my.convertEscapeCharacters(tfProvince.getText())+"'",
        };
        String [] parentGuardian = {
            "fName='"+my.convertEscapeCharacters(tfFathersName.getText())+"'",
            "mName='"+my.convertEscapeCharacters(tfMothersName.getText())+"'",
            "gName='"+my.convertEscapeCharacters(tfGuardiansName.getText())+"'",
            "rltnshp='"+my.convertEscapeCharacters(tfRelationship.getText())+"'",
            "contact='"+my.convertEscapeCharacters(tfContactNumber.getText())+"'",
            "date=now()",
        };
        //</editor-fold>
        
        //Update By Batch
        boolean updateSuccess [] = {false,false,false};
        
        updateSuccess[0] = my.update_values("personalInfo", basic, "stdId='"+studentId+"'");
        updateSuccess[1] = my.update_values("personalInfo", address, "stdId='"+studentId+"'");
        updateSuccess[2] = my.update_values("personalInfo", parentGuardian, "stdId='"+studentId+"'");
        
        if(updateSuccess[0] && updateSuccess[1] && updateSuccess[2]){
            my.showMessage("Update Successful.", JOptionPane.INFORMATION_MESSAGE);
        }else{
            my.showMessage("Update Failed.\n\nBasic: "+
                    (updateSuccess[0]?"Success":"Failed")+
                    "\nAddress: "+(updateSuccess[1]?"Success":"Failed")+
                    "\nParent & Guardian: "+(updateSuccess[0]?"Success":"Failed"), JOptionPane.ERROR_MESSAGE);
        }
        searchStudentForPrsnlInfHandler(evt);
    }//GEN-LAST:event_savePersonalInfoChangesHandler

    private void loadSubjectHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadSubjectHandler
        if(evt.getClickCount() == 2 && subjectTable.getSelectedRow() != -1){
            int row = subjectTable.getSelectedRow();
            String subjectId = subjectTable.getValueAt(row, 0).toString();
            
            String result [] = my.return_values("*", "v_subjects_jhs", "WHERE id='"+subjectId+"'", myVariables.getSubjectOrder());
            
            if(result.length > 0){
                if(subjectsTab.getTabCount() <= 1){
                    subjectsTab.addTab("Edit Subject", editSubjectTab);
                    subjectsTab.setSelectedIndex(1);
                }
                
                String [] info = result[0].split("@@");
                
                tfSubjectCode1.setText(info[1]);
                tfSubjectDescription1.setText(info[2]);
                
                int gradeLevel = Integer.parseInt(info[3]);
                
                switch(gradeLevel){
                    case 7:{
                        jcbGradeLevel1.setSelectedIndex(0);
                        break;
                    }case 8:{
                        jcbGradeLevel1.setSelectedIndex(1);
                        break;
                    }case 9:{
                        jcbGradeLevel1.setSelectedIndex(2);
                        break;
                    }case 10:{
                        jcbGradeLevel1.setSelectedIndex(3);
                        break;
                    }
                }
                
                
            }
        }else{
            if(subjectsTab.getTabCount() > 1){
                subjectsTab.remove(1);
            }
        }
    }//GEN-LAST:event_loadSubjectHandler

    private void saveSubjectChangesHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveSubjectChangesHandler
        int row = subjectTable.getSelectedRow();
        
        String subjectId = subjectTable.getValueAt(row, 0).toString();
        String subjectCode = tfSubjectCode1.getText();
        String description = tfSubjectDescription1.getText();
        
        String gradeLevel = "";
        switch(jcbGradeLevel1.getSelectedIndex()){
            case 0:{
                gradeLevel="7";break;
            }case 1:{
                gradeLevel="8";break;
            }case 2:{
                gradeLevel="9";break;
            }case 3:{
                gradeLevel="10";break;
            }
        }
        
        String [] fields = {
            subjectCode,
            description,
            gradeLevel,
        };
        
        for(String n: fields){
            if(n.length() <=0){
                my.showMessage("Please fill-up all fields.", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        
        String sets [] = {
            "subjectCode='"+my.convertEscapeCharacters(subjectCode)+"'",
            "description='"+my.convertEscapeCharacters(description)+"'",
            "gradeLevel='"+gradeLevel+"'",
        };
        
        //update
        if(my.update_values("subjects", sets, "id='"+subjectId+"'")){
            my.showMessage("Update Successful.", JOptionPane.INFORMATION_MESSAGE);
            searchSubjects(evt);
        }else{
            my.showMessage("Update Failed. Please make sure you connected to the School Network.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveSubjectChangesHandler

    private void saveLoadChangesHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveLoadChangesHandler
        String loadId = lbLoadId.getText();
        String loadName = my.convertEscapeCharacters(tfLoadName.getText().trim());
        String subjects = "";
        
        //Get ids with ":" separator
        for(int n=0;n<selectedSubjectTable.getRowCount();n++){
            subjects+=selectedSubjectTable.getValueAt(n, 0).toString()+":";
        }
        String sets[] = {
            "b_loadName='"+loadName+"'",
            "d_subjectsContained='"+subjects+"'",
        };
        
        //update
        if(my.update_values("loads", sets, "a_id='"+loadId+"'")){
            my.showMessage("Update Successful.", JOptionPane.INFORMATION_MESSAGE);
            searchLoadsHandler(evt);
        }else{
            my.showMessage("Update Failed. Please make sure you are connect to the School Network.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveLoadChangesHandler

    private void addNewSubjectHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewSubjectHandler
        String subjectCode = my.convertEscapeCharacters(tfSubjectCode.getText().trim());
        String description = my.convertEscapeCharacters(tfSubjectDescription.getText().trim());
        String gradeLevel = "";
        
        switch(jcbGradeLevel.getSelectedIndex()){
            case 0:{
                gradeLevel="7";break;
            }case 1:{
                gradeLevel="8";break;
            }case 2:{
                gradeLevel="9";break;
            }case 3:{
                gradeLevel="10";break;
            }
        }
        
        String fields[] = {
            "null",
            subjectCode,
            description,
            gradeLevel,
        };
        
        for (String n : fields){
            if(n.length() <= 0){
                my.showMessage("Please fill-up all fields.", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        
        if(my.add_values("subjects", "id,subjectCode,description,gradeLevel", fields)){
            my.showMessage("Adding Successful.", JOptionPane.INFORMATION_MESSAGE);
            searchSubjects(evt);
        }else{
            my.showMessage("Adding Failed. Please make sure you are connected to the School Network.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addNewSubjectHandler

    private void addNewLoadHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewLoadHandler
        String loadName = my.convertEscapeCharacters(tfLoadName1.getText().trim());
        String gradeLevel = "";
        switch(jcbGradeLevel2.getSelectedIndex()){
            case 0:{
                gradeLevel = "7";break;
            }case 1:{
                gradeLevel = "8";break;
            }case 2:{
                gradeLevel = "9";break;
            }case 3:{
                gradeLevel = "10";break;
            }
        }
        
        if(loadName.length() <=0 ){
            my.showMessage("Please fill-up all fields.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        //Add
        String [] fields = {
            "null",
            loadName,
            gradeLevel,
        };
        if(my.add_values("loads", "a_id,b_loadName,c_gradeLevel", fields)){
            my.showMessage("Load Added Successfully.", JOptionPane.INFORMATION_MESSAGE);
            searchLoadsHandler(evt);
        }else{
            my.showMessage("Adding Failed. Please check your connection to the School Network.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addNewLoadHandler

    private void saveUserChangesHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveUserChangesHandler
        //Get Values
        int row = usersTable.getSelectedRow();
        String userId = usersTable.getValueAt(row, 0).toString();
        
        String lName = my.convertEscapeCharacters(tfLName2.getText());
        String fName = my.convertEscapeCharacters(tfFname2.getText());
        String mName = tfMname2.getText().trim().length() > 0 ? tfMname2.getText().trim() : " ";
        mName = my.convertEscapeCharacters(mName);
        
        String gender = jcbGender1.getSelectedIndex()==0?"Male":"Female";
        String userName = my.convertEscapeCharacters(tfUserName1.getText());
        String password = my.convertEscapeCharacters(tfPassword1.getText());
        String accessLevel = String.valueOf(jcbAccessLevel1.getSelectedIndex()+1);
        
        String [] fields = {
            lName,fName,mName,userName,password
        };
        
        for(String n : fields){
            if(n.length() <= 0){
                my.showMessage("Please fill-up all fields.", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        //Check for duplicate user name
        String result [] = my.return_values("*", "v_users_jhs", "WHERE user_name ='"+userName+"' AND id !='"+userId+"'", myVariables.getUsersOrder());
        
        if(result != null){
            my.showMessage("Username already exists. Please choose another one.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        //Update values
        String [] sets = {
            "user_Lname='"+lName+"'",
            "user_Fname='"+fName+"'",
            "user_Mname='"+mName+"'",
            "gender='"+gender+"'",
            "user_name='"+userName+"'",
            "user_password='"+password+"'",
            "user_level='"+accessLevel+"'",
        };
        
        if(my.update_values("users", sets, "id='"+userId+"'")){
            my.showMessage("Update Successful.", JOptionPane.INFORMATION_MESSAGE);
            searchUsersHander(evt);
        }else{
            my.showMessage("Update Failed. Please make sure you are connected to the school network.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveUserChangesHandler

    private void btnSaveManagedSubjectChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveManagedSubjectChangesActionPerformed
        //Get Values
        String profileId = lbUserInfoId.getText();
        String subjects = "";
        
        //Append subjects with ':' splitter
        if(managedSubjectTable.getRowCount() != 0){
            for(int n=0;n<managedSubjectTable.getRowCount();n++){
                subjects+=managedSubjectTable.getValueAt(n, 0).toString()+":";
            }
        }else{
            subjects = "NONE";
            System.err.println("No subjects.");
        }
        
        //Update
        String [] sets = {"managedSubjects='"+subjects+"'"};
        
        if(my.update_values("userdetails", sets, "id='"+profileId+"'")){
            my.showMessage("Update Successful.", JOptionPane.INFORMATION_MESSAGE);
            
            //Loading Managed Subjects
            String subjectsContained = subjects;
            try {
                subjectsContained = subjectsContained.replace(':', ',');
            } catch (Exception e) {
                System.err.println("Subject Contained is empty");
            }
            //Check if there is at least one subject to search
            if(subjectsContained.length() >=2 && !subjectsContained.contains("NONE")){                    
                if(subjectsContained.charAt(subjectsContained.length()-1) == ','){
                    subjectsContained = subjectsContained.substring(0, subjectsContained.length()-1);
                    System.err.println("Comma found...deleting");
                }

                my.searchItem("WHERE id IN ("+subjectsContained+")", managedSubjectTable, 1, null, null, false, true, null, tfSearchSubject2, true);
                enableDisableManagedSubjectButtons(false, true);
            }else{
                my.clear_table_rows(selectedSubjectTable);
            }
        }else{
            my.showMessage("Update Failed. Please make sure you are connected to the school network.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveManagedSubjectChangesActionPerformed

    private void btnAddManagedSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddManagedSubjectActionPerformed
        if(searchedsubjectTable1.getSelectedRow() != -1){
            //Get selected subjects list
            int [] selectedRows = searchedsubjectTable1.getSelectedRows();
            boolean matchFound;
            
            for(int n=0;n<selectedRows.length;n++){
                //get current selected subject ID
                int subjectId = Integer.parseInt(searchedsubjectTable1.getValueAt(selectedRows[n], 0).toString());
                matchFound = false;
                                
                //Compare with id with selected subject table Ids if duplicate already exists
                for(int x=0;x<managedSubjectTable.getRowCount();x++){
                    int selectedSubjectId = Integer.parseInt(managedSubjectTable.getValueAt(x, 0).toString());
                    
                    if(subjectId == selectedSubjectId){
                        matchFound = true;
                        break;
                    }
                }
                //Add new subject to list
                if(!matchFound){
                    String newSubject = my.get_table_row_values(selectedRows[n], searchedsubjectTable1);
                    my.add_table_row(newSubject, managedSubjectTable);
                }
            }
        }else{
            my.showMessage("Please select at least 1 subject to add to the list.", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAddManagedSubjectActionPerformed

    private void btnDeleteManagedSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteManagedSubjectActionPerformed
       if(managedSubjectTable.getSelectedRow() != -1){
            int selectedRows [] = managedSubjectTable.getSelectedRows();
            
            //Start deleting from the last index to avoid errors
            for(int n=selectedRows.length-1;n>=0;n--){
                my.remove_table_row(managedSubjectTable, selectedRows[n]);
            }
        }else{
            my.showMessage("No subject selected to remove.", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteManagedSubjectActionPerformed

    private void btnSearch7findSubjectHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch7findSubjectHandler
        String toSearch = my.convertEscapeCharacters(tfSearchSubject3.getText());
        my.searchItem("WHERE subjectCode LIKE '%"+toSearch+"%' OR description LIKE '%"+toSearch+"%'", searchedsubjectTable1, 1, null, null, false, true, null, tfSearchSubject3,true);
    }//GEN-LAST:event_btnSearch7findSubjectHandler

    private void tfSchoolIdaddNewStudentHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSchoolIdaddNewStudentHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSchoolIdaddNewStudentHandler

    private void tfSchoolNameaddNewStudentHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSchoolNameaddNewStudentHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSchoolNameaddNewStudentHandler

    private void tfSchoolAddressaddNewStudentHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSchoolAddressaddNewStudentHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSchoolAddressaddNewStudentHandler

    private void tfSchoolId1addNewStudentHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSchoolId1addNewStudentHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSchoolId1addNewStudentHandler

    private void tfSchoolName1addNewStudentHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSchoolName1addNewStudentHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSchoolName1addNewStudentHandler

    private void tfSchoolAddress1addNewStudentHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSchoolAddress1addNewStudentHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSchoolAddress1addNewStudentHandler

    private void btnImportFromLisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportFromLisActionPerformed
        showCustomDialog("Import Files", importDialog, false, 800, 500, true);
    }//GEN-LAST:event_btnImportFromLisActionPerformed

    private void importTableSF1loadStudentHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_importTableSF1loadStudentHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_importTableSF1loadStudentHandler

    private void btnOpenFileExplorerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenFileExplorerActionPerformed
        switch(jcbFileFormats.getSelectedIndex()){
            case 0:{
                showFileChooserDialog("Excel Files","xlsx");
                importTablesTab.setSelectedIndex(0);
                break;
            }case 1:{
                showFileChooserDialog("Excel Files","xlsx");
                importTablesTab.setSelectedIndex(0);
                break;
            }case 2:{
                showFolderChooserDialog();
                importTablesTab.setSelectedIndex(1);
                break;
            }
        }
    }//GEN-LAST:event_btnOpenFileExplorerActionPerformed

    private void btnCancelImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelImportActionPerformed
        my.interruptThirdThread();
        my.interrupSecondThread();
        my.interrupMainThread();
        lbProgressMessage.setText("Import Cancelled...");
        jpbProgressBar.setValue(0);
    }//GEN-LAST:event_btnCancelImportActionPerformed

    private void btnRegisterStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterStudentsActionPerformed
        int index = jcbFileFormats.getSelectedIndex();
        
        switch(index){
            case 2:{
                if(importTableSF10.getRowCount() <= 0){
                    my.showMessage("No Students found inside the table.", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                my.runMainThread(
                    3,
                    new JTable[]{importTableSF10},
                    new String[]{String.valueOf(index)},
                    null,
                    new JButton[]{btnOpenFileExplorer,btnCancelImport,btnRegisterStudents},
                    new boolean[]{cbUpdateExisting.isSelected()},
                    null
                );
                break;
            }default:{
                if(importTableSF1.getRowCount() <= 0){
                    my.showMessage("No Students found inside the table.", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                my.runMainThread(
                    1,
                    new JTable[]{importTableSF1},
                    new String[]{String.valueOf(index)},
                    new JTextField[]{tfFileLocation},
                    new JButton[]{btnOpenFileExplorer,btnCancelImport,btnRegisterStudents},
                    new boolean[]{cbUpdateExisting.isSelected()},
                    null
                );
                break;
            }
        }
    }//GEN-LAST:event_btnRegisterStudentsActionPerformed

    private void importTableSF10loadStudentHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_importTableSF10loadStudentHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_importTableSF10loadStudentHandler

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dashBoard().setVisible(true);
            }
        });
    }
    //<editor-fold desc="Custom Functions">
    JDialog dialog;
    JDialog seconDaryDialog;
    JFileChooser fileChooser;
    FileFilter filter;
    
    private void showFolderChooserDialog(){
        fileChooser = new JFileChooser();
        
        //Check if there is already a selected directory
        if(tfFileLocation.getText().length()>0){
            fileChooser.setCurrentDirectory(new File(tfFileLocation.getText()));
        }else{
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        }
        
        fileChooser.setDialogTitle("Select Folder with SF10 Excel Files");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        fileChooser.setAcceptAllFileFilterUsed(false);
        
        //Check if approved or not
        int result = fileChooser.showOpenDialog(importDialog);
        
        switch(result){
            case JFileChooser.APPROVE_OPTION:{
                //Process file here
                processFolderSelected();
                break;
            }default:{
                System.err.println("No File Selected");
                break;
            }
        }
    }
    private void showFileChooserDialog(String fileTypeTitle,String extentionName){
        fileChooser = new JFileChooser();
        
        if(tfFileLocation.getText().length()>0){
            fileChooser.setCurrentDirectory(new File(tfFileLocation.getText()));
        }else{
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        }
        filter = new FileNameExtensionFilter(fileTypeTitle, new String [] {extentionName});
        
        fileChooser.setFileFilter(filter);
        
        int result = fileChooser.showOpenDialog(importDialog);
        
        System.err.println(result);
        
        switch(result){
            case JFileChooser.APPROVE_OPTION:{
                //Process file here
                processFileSelected();
                break;
            }default:{
                System.err.println("No File Selected");
                break;
            }
        }
    }
    private void processFolderSelected(){
        tfFileLocation.setText(fileChooser.getSelectedFile().toString());
        File file = fileChooser.getSelectedFile();
        
        my.runMainThread(
                2,new JTable[]{importTableSF10},
                new String[]{String.valueOf(jcbFileFormats.getSelectedIndex())},
                new JTextField[]{tfFileLocation},
                new JButton[]{btnOpenFileExplorer,btnCancelImport,btnRegisterStudents},
                null,
                new File[]{file}
        );
    }
    private void processFileSelected(){
        tfFileLocation.setText(fileChooser.getSelectedFile().toString());
        File file = fileChooser.getSelectedFile();
        
        
        my.runMainThread(
                0,new JTable[]{importTableSF1},
                new String[]{String.valueOf(jcbFileFormats.getSelectedIndex())},
                new JTextField[]{tfFileLocation},
                new JButton[]{btnOpenFileExplorer,btnCancelImport,btnRegisterStudents},
                null,
                new File[]{file}
        );
    }
    
    private void showCustomDialog(String title, JPanel customPanel, boolean isModal, int width, int height, boolean isResizable){
        if (dialog == null || dialog.isVisible() || dialog.isActive()){
            closeCustomDialog();
        }
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
    private void openWindow(int index){
        JFrame windows [] = {
            this,
        };
    }
    private void clearAddStudentFields(){
        tfFname.setText("");
        tfMname.setText("");
        tfLName.setText("");
        
        tfStudentLrn.setText("");
        tfInitialGrade.setText("");
        
        rbMale.setSelected(true);
    }
    private void clearAddUserFields(){
        tfFname1.setText("");
        tfMname1.setText("");
        tfLName1.setText("");
        
        jcbGender2.setSelectedIndex(0);
        
        tfUserName.setText("");
        tfPassword.setText("");
        
        jcbAccessLevel.setSelectedIndex(0);
    }
    private void enableDisableManagedSubjectButtons(boolean enabled,boolean enableEditBtn){
        if(enabled){
            btnEditAssignedSubject.setEnabled(false);
            
            btnAddManagedSubject.setEnabled(true);
            btnDeleteManagedSubject.setEnabled(true);
            btnSaveManagedSubjectChanges.setEnabled(true);
            btnSearch7.setEnabled(true);
            
            tfSearchSubject3.setEnabled(true);
            searchedsubjectTable1.setEnabled(true);
        }else{
            btnEditAssignedSubject.setEnabled(enableEditBtn);
            
            btnAddManagedSubject.setEnabled(false);
            btnDeleteManagedSubject.setEnabled(false);
            btnSaveManagedSubjectChanges.setEnabled(false);
            btnSearch7.setEnabled(false);
            
            tfSearchSubject3.setEnabled(false);
            searchedsubjectTable1.setEnabled(false);
            
            my.clear_table_rows(searchedsubjectTable1);
        }
    }
    private void enableDisablePersonalInfoFields(boolean enabled,boolean clearFields){
        JTextField textFields [] = {
            tfBdate,
            tfAge,
            tfMotherTongue,
            tfEthnicGroup,
            tfReligion,
            
            tfHouseNumber,
            tfBarangay,
            tfMunicipality,
            tfProvince,
            
            tfFathersName,
            tfMothersName,
            
            tfGuardiansName,
            tfRelationship,
            tfContactNumber,
        };
        
        for(int n=0;n<textFields.length;n++){
            textFields[n].setEnabled(enabled);
            if(clearFields){
                textFields[n].setText("");
            }
            if(enabled){
                //textFields[n].setForeground(Color.BLUE);
                textFields[n].setOpaque(true);
            }else{
                textFields[n].setDisabledTextColor(Color.BLACK);
                textFields[n].setOpaque(false);
            }
        }
        
        if(enabled){
            btnSaveChanges1.setEnabled(true);
            btnEdit.setEnabled(false);
        }else{
            if(clearFields){
                btnEdit.setEnabled(false);
            }else{
                btnEdit.setEnabled(true);
            }
            btnSaveChanges1.setEnabled(false);
        }
    }
    
    private void enableDisableUsersPersonalInfoFields(boolean enabled,boolean clearFields){
        JTextField textFields [] = {
            tfEmployeeNumber,
            tfFundSource,
            tfPosition,
            tfNatureOfAppointment,
            
            tfDegree,
            tfMajor,
            tfMinor,
        };
        
        for(int n=0;n<textFields.length;n++){
            textFields[n].setEnabled(enabled);
            if(clearFields){
                textFields[n].setText("");
            }
            if(enabled){
                textFields[n].setForeground(Color.BLUE);
                textFields[n].setOpaque(true);
            }else{
                textFields[n].setDisabledTextColor(Color.BLACK);
                textFields[n].setOpaque(false);
            }
        }
        
        if(enabled){
            btnSaveChanges6.setEnabled(true);
            btnEdit1.setEnabled(false);
        }else{
            if(clearFields){
                btnEdit1.setEnabled(false);
            }else{
                //Enable only for Registrar and Admin Only
                if(myVariables.getAccessLevel() == 4 || myVariables.getAccessLevel() == 5){
                    btnEdit1.setEnabled(true);
                }else{
                    btnEdit1.setEnabled(false);
                }
            }
            btnSaveChanges6.setEnabled(false);
        }
        
        my.clear_table_rows(managedSubjectTable);
    }
    //<editor-fold desc="Custom Functions"> 
    private void loadYearDropDowns(int numberOfYears){
        JComboBox [] yearDropDowns = {
            
        };
        JComboBox [] dropDowns = {
            jcbAccessLevel,jcbAccessLevel1,jcbGender1,jcbGender2,jcbGradeLevel,
            jcbGradeLevel1,jcbGradeLevel2,jcbGradeLevel3,jcbFileFormats,
        };
        int startingYear = 2019;
        
        for(JComboBox n : yearDropDowns){
            n.removeAllItems();
            n.setFont(myVariables.TEXTFIELD_FONT);
            for(int x=0;x<numberOfYears;x++){
                n.addItem(String.valueOf(startingYear+x));
            }
        }
        for(JComboBox n : dropDowns){
            n.setFont(myVariables.TEXTFIELD_FONT);
        }
    }
    private void setScrollSpeeds(){
        JScrollPane scrollpanes [] = {
            jScrollPane3,
            jScrollPane4,
            jScrollPane12,
            jScrollPane13,
            jScrollPane15,
            jScrollPane6,
            jScrollPane7,
            jScrollPane19,
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
            my.hideColumns(studentTable, new int [] {0});
            my.hideColumns(studentTable1, new int [] {0,6});
            my.hideColumns(subjectTable, new int [] {0});
            my.hideColumns(subjectTable1, new int [] {0,3});
            my.hideColumns(usersTable, new int [] {0});
            my.hideColumns(usersTable1, new int [] {0,5,6});
            my.hideColumns(managedSubjectTable, new int [] {0});
            my.hideColumns(searchedsubjectTable1, new int [] {0});
            my.hideColumns(searchedsubjectTable, new int [] {0});
            my.hideColumns(selectedSubjectTable, new int [] {0});
        }
        
        //Set table fonts
        JTable tables [] = {
            studentTable,
            studentTable1,
            subjectTable,
            
            subjectTable1,
            searchedsubjectTable,
            selectedSubjectTable,
            
            usersTable,
            
            usersTable1,
            managedSubjectTable,
            searchedsubjectTable1,
            
            importTableSF1,
            importTableSF10,
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
        mainTab.add("Manage Students", manageStudentsTab);
        mainTab.add("Student's Personal Info",personalInfoTab);
        mainTab.add("Manage Subjects",manageSubjectsTab);
        mainTab.add("Subject Loads",subjectLoadsTab);
        mainTab.add("Manage Users",manageUsersTab);
        mainTab.add("User's Personal Info",usersPersonalInfoTab);
        
        mainTab.setFont(myVariables.TAB_HEADER_FONT);
        jtbImportTabs.setFont(myVariables.TAB_HEADER_FONT);
        
        my.remove_multiple_tabs(jTabbedPane2, new int [] {1});
        my.remove_multiple_tabs(subjectsTab, new int [] {1});
        my.remove_multiple_tabs(subjectLoadTabs, new int [] {1});
        my.remove_multiple_tabs(usersTab, new int [] {1});
    }
    private void loadTabIcons(){
        Icon tabIcons [] = {
            my.getImgIcn(myVariables.getStudentsIcon()),
            my.getImgIcn(myVariables.getStudentsPrsnlInfIcon()),
            my.getImgIcn(myVariables.getSubjectsIcon()),
            my.getImgIcn(myVariables.getSubjeLoadsIcon()),
            my.getImgIcn(myVariables.getUsersIcon()),
            my.getImgIcn(myVariables.getUsersPrsnlInfIcon()),
        };
        
        for(int n=0;n<tabIcons.length;n++){
            mainTab.setIconAt(n,tabIcons[n]);
        }
        
        //Remove tabs based on access Level
        switch(myVariables.getAccessLevel()){
            case 3:{
                my.remove_multiple_tabs(mainTab, new int [] {0,1,4});
                jtpUserDetailsTab.removeAll();
                jtpUserDetailsTab.addTab("Assign Subjects", jScrollPane19);
                break;
            }case 4:{
                jtpUserDetailsTab.removeAll();
                jtpUserDetailsTab.addTab("Personal Info", jScrollPane15);
                break;
            }case 5:{
                break;
            }
        }
    }
    private void loadColoredButtons(){
        JButton buttons [] = {
            //Manage Students
            btnAdd,
            btnSaveChanges,
            btnSearch,
            //Personal Info
            btnSaveChanges1,
            btnEdit,
            btnSearch1,
            //Manage Subjects
            btnSearch2,
            btnAdd1,
            btnSaveChanges2,
            //Subject Loads
            btnSearch3,
            btnAdd2,
            btnSearch4,
            btnAddSubjectToList,
            btnRemoveSubjectFromList,
            btnSaveChanges4,
            //Manage Users
            btnSearch5,
            btnAdd3,
            btnSaveChanges5,
            //User's Personal Info
            btnSearch6,
            btnEdit1,
            btnSaveChanges6,
            btnEditAssignedSubject,
            btnAddManagedSubject,
            btnDeleteManagedSubject,
            btnSaveManagedSubjectChanges,
            btnSearch7,
            //Import From LIS
            //btnOpenFileExplorer,
            btnRegisterStudents,
        };
        
        JButton lightButtons [] = {
            btnImportFromLis,
            btnOpenFileExplorer,
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
            jLabel1,jLabel2,jLabel17,jLabel39,jLabel46,jLabel42,jLabel51,jLabel44,jLabel64,jLabel78,jLabel94,
        };
        JLabel labels [] = {
            lbSearchResult,lbSearchResult1,lbSearchResult2,lbSearchResult3,lbSearchResult4,lbSearchResult5
        };
        
        JLabel formsHeaderLabels [] = {
            jLabel27,jLabel28,jLabel30,jLabel33,jLabel54,jLabel57,jLabel58,jLabel72,jLabel73,
            jLabel74,jLabel75,jLabel88,jLabel89,jLabel97,jLabel3,jLabel4,jLabel92,jLabel93,
        };
        JLabel textFieldHeaderLabels [] = {
            jLabel5,jLabel6,jLabel7,jLabel8,jLabel9,jLabel10,jLabel11,jLabel12,jLabel13,jLabel14,jLabel15,
            jLabel16,jLabel18,jLabel19,jLabel20,jLabel21,jLabel22,jLabel23,jLabel24,jLabel25,jLabel26,jLabel29,
            jLabel31,jLabel32,jLabel34,jLabel35,jLabel40,jLabel41,jLabel45,jLabel48,jLabel49,jLabel50,jLabel43,
            jLabel47,jLabel52,jLabel53,jLabel56,jLabel59,jLabel60,jLabel62,jLabel65,jLabel71,jLabel66,jLabel68,
            jLabel67,jLabel69,jLabel76,jLabel77,jLabel70,jLabel79,jLabel80,jLabel99,jLabel81,jLabel84,jLabel85,
            jLabel86,jLabel36,jLabel37,jLabel83,jLabel87,jLabel90,jLabel91,jLabel95,lbProgressMessage,
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
        JTextField searchFields [] = {
            tfSearchStudent,tfSearchStudent1,tfSearchSubject,
            tfSearchSubject2,tfSearchSubjectLoad,tfSearchUser,tfSearchUser1,
            tfSearchSubject3,
        };
        JTextField forms [] = {
            //Manage Students
            tfFname,tfMname,tfLName,tfStudentLrn,tfInitialGrade,tfSchoolId,tfSchoolName,tfSchoolAddress,
            tfFirstName1,tfMiddleName1,tfLastName1,tfStudentLrn1,tfInitialGrade1,tfSchoolId1,tfSchoolName1,tfSchoolAddress1,
            //Personal Info
            tfBdate,tfAge,tfMotherTongue,tfEthnicGroup,tfReligion,
            tfHouseNumber,tfBarangay,tfMunicipality,tfProvince,
            tfFathersName,tfMotherTongue,tfGuardiansName,tfRelationship,tfContactNumber,
            //Subjects
            tfSubjectCode,tfSubjectDescription,tfSubjectCode1,tfSubjectDescription1,
            //Subject Loads
            tfLoadName,tfLoadName1,
            //Users
            tfFname1,tfMname1,tfLName1,tfUserName,tfPassword,
            tfFname2,tfMname2,tfLName2,tfUserName1,tfPassword1,
            //User's Personal Info
            tfEmployeeNumber,tfFundSource,tfPosition,tfNatureOfAppointment,
            tfDegree,tfMajor,tfMinor,
            //Import Tab
            tfFileLocation,
        };
        
        for(JTextField n : searchFields){
            n.setFont(myVariables.SEARCH_TEXTFIELD_FONT);
        }
        for(JTextField n : forms){
            n.setFont(myVariables.TEXTFIELD_FONT);
        }
    }
    //</editor-fold>
    
    
    //</editor-fold>
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup addStudentGenderGroup;
    private javax.swing.JPanel addStudentTab;
    private javax.swing.JPanel addStudentTab4;
    private javax.swing.JPanel addSubjectTab;
    private javax.swing.JPanel addUserTab;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAdd1;
    private javax.swing.JButton btnAdd2;
    private javax.swing.JButton btnAdd3;
    private javax.swing.JButton btnAddManagedSubject;
    private javax.swing.JButton btnAddSubjectToList;
    private javax.swing.JButton btnCancelImport;
    private javax.swing.JButton btnDeleteManagedSubject;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnEdit1;
    private javax.swing.JButton btnEditAssignedSubject;
    private javax.swing.JButton btnImportFromLis;
    private javax.swing.JButton btnOpenFileExplorer;
    private javax.swing.JButton btnRegisterStudents;
    private javax.swing.JButton btnRemoveSubjectFromList;
    private javax.swing.JButton btnSaveChanges;
    private javax.swing.JButton btnSaveChanges1;
    private javax.swing.JButton btnSaveChanges2;
    private javax.swing.JButton btnSaveChanges4;
    private javax.swing.JButton btnSaveChanges5;
    private javax.swing.JButton btnSaveChanges6;
    private javax.swing.JButton btnSaveManagedSubjectChanges;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearch1;
    private javax.swing.JButton btnSearch2;
    private javax.swing.JButton btnSearch3;
    private javax.swing.JButton btnSearch4;
    private javax.swing.JButton btnSearch5;
    private javax.swing.JButton btnSearch6;
    private javax.swing.JButton btnSearch7;
    private javax.swing.JCheckBox cbUpdateExisting;
    private javax.swing.JPanel editLoadTab;
    private javax.swing.ButtonGroup editStudentGenderGroup;
    private javax.swing.JPanel editStudentTab;
    private javax.swing.JPanel editSubjectTab;
    private javax.swing.JPanel editUserTab;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JPanel importDialog;
    private javax.swing.JPanel importStudentsTab;
    private javax.swing.JTable importTableSF1;
    private javax.swing.JTable importTableSF10;
    private javax.swing.JTabbedPane importTablesTab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JSplitPane jSplitPane4;
    private javax.swing.JSplitPane jSplitPane5;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JComboBox<String> jcbAccessLevel;
    private javax.swing.JComboBox<String> jcbAccessLevel1;
    private javax.swing.JComboBox<String> jcbFileFormats;
    private javax.swing.JComboBox<String> jcbGender1;
    private javax.swing.JComboBox<String> jcbGender2;
    private javax.swing.JComboBox<String> jcbGradeLevel;
    private javax.swing.JComboBox<String> jcbGradeLevel1;
    private javax.swing.JComboBox<String> jcbGradeLevel2;
    private javax.swing.JComboBox<String> jcbGradeLevel3;
    private javax.swing.JProgressBar jpbProgressBar;
    private javax.swing.JTabbedPane jtbImportTabs;
    private javax.swing.JTabbedPane jtpUserDetailsTab;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lbLoadId;
    private javax.swing.JLabel lbLoggedInUser;
    private javax.swing.JLabel lbProgressMessage;
    private javax.swing.JLabel lbSchoolAddress;
    private javax.swing.JLabel lbSchoolName;
    private javax.swing.JLabel lbSearchResult;
    private javax.swing.JLabel lbSearchResult1;
    private javax.swing.JLabel lbSearchResult2;
    private javax.swing.JLabel lbSearchResult3;
    private javax.swing.JLabel lbSearchResult4;
    private javax.swing.JLabel lbSearchResult5;
    private javax.swing.JLabel lbUserInfoId;
    private javax.swing.JPanel left;
    private javax.swing.JPanel left1;
    private javax.swing.JPanel left2;
    private javax.swing.JPanel left3;
    private javax.swing.JPanel left4;
    private javax.swing.JPanel left5;
    private javax.swing.JTabbedPane mainTab;
    private javax.swing.JPanel manageStudentsTab;
    private javax.swing.JPanel manageSubjectsTab;
    private javax.swing.JPanel manageUsersTab;
    private javax.swing.JTable managedSubjectTable;
    private javax.swing.JPanel personalInfoTab;
    private javax.swing.JRadioButton rbFemale;
    private javax.swing.JRadioButton rbFemale1;
    private javax.swing.JRadioButton rbMale;
    private javax.swing.JRadioButton rbMale1;
    private javax.swing.JPanel right;
    private javax.swing.JPanel right1;
    private javax.swing.JPanel right2;
    private javax.swing.JPanel right3;
    private javax.swing.JPanel right4;
    private javax.swing.JPanel right5;
    private javax.swing.JTable searchedsubjectTable;
    private javax.swing.JTable searchedsubjectTable1;
    private javax.swing.JTable selectedSubjectTable;
    private javax.swing.JTable studentTable;
    private javax.swing.JTable studentTable1;
    private javax.swing.JTabbedPane subjectLoadTabs;
    private javax.swing.JPanel subjectLoadsTab;
    private javax.swing.JTable subjectTable;
    private javax.swing.JTable subjectTable1;
    private javax.swing.JTabbedPane subjectsTab;
    private javax.swing.JTextField tfAge;
    private javax.swing.JTextField tfBarangay;
    private javax.swing.JTextField tfBdate;
    private javax.swing.JTextField tfContactNumber;
    private javax.swing.JTextField tfDegree;
    private javax.swing.JTextField tfEmployeeNumber;
    private javax.swing.JTextField tfEthnicGroup;
    private javax.swing.JTextField tfFathersName;
    private javax.swing.JTextField tfFileLocation;
    private javax.swing.JTextField tfFirstName1;
    private javax.swing.JTextField tfFname;
    private javax.swing.JTextField tfFname1;
    private javax.swing.JTextField tfFname2;
    private javax.swing.JTextField tfFundSource;
    private javax.swing.JTextField tfGuardiansName;
    private javax.swing.JTextField tfHouseNumber;
    private javax.swing.JTextField tfInitialGrade;
    private javax.swing.JTextField tfInitialGrade1;
    private javax.swing.JTextField tfLName;
    private javax.swing.JTextField tfLName1;
    private javax.swing.JTextField tfLName2;
    private javax.swing.JTextField tfLastName1;
    private javax.swing.JTextField tfLoadName;
    private javax.swing.JTextField tfLoadName1;
    private javax.swing.JTextField tfMajor;
    private javax.swing.JTextField tfMiddleName1;
    private javax.swing.JTextField tfMinor;
    private javax.swing.JTextField tfMname;
    private javax.swing.JTextField tfMname1;
    private javax.swing.JTextField tfMname2;
    private javax.swing.JTextField tfMotherTongue;
    private javax.swing.JTextField tfMothersName;
    private javax.swing.JTextField tfMunicipality;
    private javax.swing.JTextField tfNatureOfAppointment;
    private javax.swing.JTextField tfPassword;
    private javax.swing.JTextField tfPassword1;
    private javax.swing.JTextField tfPosition;
    private javax.swing.JTextField tfProvince;
    private javax.swing.JTextField tfRelationship;
    private javax.swing.JTextField tfReligion;
    private javax.swing.JTextField tfSchoolAddress;
    private javax.swing.JTextField tfSchoolAddress1;
    private javax.swing.JTextField tfSchoolId;
    private javax.swing.JTextField tfSchoolId1;
    private javax.swing.JTextField tfSchoolName;
    private javax.swing.JTextField tfSchoolName1;
    private javax.swing.JTextField tfSearchStudent;
    private javax.swing.JTextField tfSearchStudent1;
    private javax.swing.JTextField tfSearchSubject;
    private javax.swing.JTextField tfSearchSubject2;
    private javax.swing.JTextField tfSearchSubject3;
    private javax.swing.JTextField tfSearchSubjectLoad;
    private javax.swing.JTextField tfSearchUser;
    private javax.swing.JTextField tfSearchUser1;
    private javax.swing.JTextField tfStudentLrn;
    private javax.swing.JTextField tfStudentLrn1;
    private javax.swing.JTextField tfSubjectCode;
    private javax.swing.JTextField tfSubjectCode1;
    private javax.swing.JTextField tfSubjectDescription;
    private javax.swing.JTextField tfSubjectDescription1;
    private javax.swing.JTextField tfUserName;
    private javax.swing.JTextField tfUserName1;
    private javax.swing.JPanel usersPersonalInfoTab;
    private javax.swing.JSplitPane usersPersonalInfoTabNew;
    private javax.swing.JTabbedPane usersTab;
    private javax.swing.JTable usersTable;
    private javax.swing.JTable usersTable1;
    // End of variables declaration//GEN-END:variables
}

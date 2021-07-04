/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mahPackage4;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
    public dashBoard() {
        my = new myFunctions(false);
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
        
        myVariables.setProgressBar(pbProgressBar);
        myVariables.setLbLoadingMessage(lbMessage);
        
        lbSchoolName.setText(myVariables.getSchoolName() + " Grading System");
        lbSchoolAddress.setText(myVariables.getSchoolAddress());
        
        hideElementsByAccessLevel();
        refreshAssignedSubjects(false);
        
        tfSearchTeacherLoad.requestFocus();
    }
    
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
        viewStudentsTab2 = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        left2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        enrolledStudentsTable1 = new javax.swing.JTable();
        btnRefreshStudents = new javax.swing.JButton();
        pbProgressBar = new javax.swing.JProgressBar();
        lbMessage = new javax.swing.JLabel();
        right2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbSectionName2 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbSubjectName2 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lbStatusOptions1 = new javax.swing.JLabel();
        jRadioButton17 = new javax.swing.JRadioButton();
        jRadioButton18 = new javax.swing.JRadioButton();
        jRadioButton19 = new javax.swing.JRadioButton();
        jRadioButton20 = new javax.swing.JRadioButton();
        lbStatusOptions2 = new javax.swing.JLabel();
        jRadioButton21 = new javax.swing.JRadioButton();
        jRadioButton22 = new javax.swing.JRadioButton();
        jRadioButton23 = new javax.swing.JRadioButton();
        jRadioButton24 = new javax.swing.JRadioButton();
        lbStatusOptions3 = new javax.swing.JLabel();
        jRadioButton25 = new javax.swing.JRadioButton();
        jRadioButton26 = new javax.swing.JRadioButton();
        jRadioButton27 = new javax.swing.JRadioButton();
        jRadioButton28 = new javax.swing.JRadioButton();
        jRadioButton29 = new javax.swing.JRadioButton();
        jRadioButton30 = new javax.swing.JRadioButton();
        jRadioButton31 = new javax.swing.JRadioButton();
        jRadioButton32 = new javax.swing.JRadioButton();
        lbStatusOptions4 = new javax.swing.JLabel();
        btnSaveChangesCurrent = new javax.swing.JButton();
        btnSaveChangesAll = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btnDphSelected = new javax.swing.JButton();
        btnDphAll = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        btnRgrSelected = new javax.swing.JButton();
        btnRgrAll = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        btnAdvSelected = new javax.swing.JButton();
        btnAdvAll = new javax.swing.JButton();
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
        jLabel2 = new javax.swing.JLabel();
        btnEditGrades = new javax.swing.JButton();
        lbDateUpdated = new javax.swing.JLabel();
        lbGradeStatus = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfFirstQ = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfSecondQ = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfThirdQ = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfFourthQ = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfGeneralWeighedAverage = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lbSubjectName = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbRecordId = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        selectQuarterDialog = new javax.swing.JPanel();
        rbQuarter1 = new javax.swing.JRadioButton();
        lbQuarterSelect = new javax.swing.JLabel();
        btnSelectQuarter = new javax.swing.JButton();
        rbQuarter2 = new javax.swing.JRadioButton();
        rbQuarter3 = new javax.swing.JRadioButton();
        rbQuarter4 = new javax.swing.JRadioButton();
        editGradeDialog = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        contentsPanel = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tfEditFirstQuarter = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfEditSecondQuarter = new javax.swing.JTextField();
        tfEditThirdQuarter = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tfEditFourthQuarter = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        rbAutomatic = new javax.swing.JRadioButton();
        rbManual = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        tfEditGwa = new javax.swing.JTextField();
        btnSaveGradeChanges = new javax.swing.JButton();
        cbAllowDecimalValues = new javax.swing.JCheckBox();
        lbStatusOptions = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        jRadioButton13 = new javax.swing.JRadioButton();
        jRadioButton14 = new javax.swing.JRadioButton();
        jRadioButton15 = new javax.swing.JRadioButton();
        jRadioButton16 = new javax.swing.JRadioButton();
        tfEvaluation = new javax.swing.JTextField();
        computationOptionGroup = new javax.swing.ButtonGroup();
        q1StatusGroup = new javax.swing.ButtonGroup();
        q2StatusGroup = new javax.swing.ButtonGroup();
        q3tatusGroup = new javax.swing.ButtonGroup();
        q4StatusGroup = new javax.swing.ButtonGroup();
        myAssignedSubjectsDialog = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        assignedSubjectsTable = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        selectQuarterGroup = new javax.swing.ButtonGroup();
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
                tfSearchTeacherLoadsearchManagedSections(evt);
            }
        });

        btnSearchSection.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_search_property_16px.png"))); // NOI18N
        btnSearchSection.setText("Search");
        btnSearchSection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchSectionsearchManagedSections(evt);
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
        if (assignedTeacherTable.getColumnModel().getColumnCount() > 0) {
            assignedTeacherTable.getColumnModel().getColumn(5).setPreferredWidth(70);
            assignedTeacherTable.getColumnModel().getColumn(5).setMaxWidth(70);
            assignedTeacherTable.getColumnModel().getColumn(7).setPreferredWidth(70);
            assignedTeacherTable.getColumnModel().getColumn(7).setMaxWidth(70);
            assignedTeacherTable.getColumnModel().getColumn(9).setPreferredWidth(70);
            assignedTeacherTable.getColumnModel().getColumn(9).setMaxWidth(70);
            assignedTeacherTable.getColumnModel().getColumn(10).setPreferredWidth(100);
            assignedTeacherTable.getColumnModel().getColumn(10).setMaxWidth(100);
        }

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

        jSplitPane2.setBorder(null);
        jSplitPane2.setDividerLocation(600);

        left2.setBackground(new java.awt.Color(11, 102, 35));

        enrolledStudentsTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Student ID", "LRN", "Name", "Gender", "Section ID", "Grade ID", "Q1", "Q2", "Q3", "Q4", "General Average", "Status", "Date Updated"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        enrolledStudentsTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        enrolledStudentsTable1.getTableHeader().setReorderingAllowed(false);
        enrolledStudentsTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                enrolledStudentsTable1MouseClicked(evt);
            }
        });
        enrolledStudentsTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                enrolledStudentsTable1KeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(enrolledStudentsTable1);
        if (enrolledStudentsTable1.getColumnModel().getColumnCount() > 0) {
            enrolledStudentsTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
            enrolledStudentsTable1.getColumnModel().getColumn(3).setPreferredWidth(200);
            enrolledStudentsTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
            enrolledStudentsTable1.getColumnModel().getColumn(11).setPreferredWidth(120);
            enrolledStudentsTable1.getColumnModel().getColumn(12).setPreferredWidth(200);
            enrolledStudentsTable1.getColumnModel().getColumn(13).setPreferredWidth(200);
        }

        btnRefreshStudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_sync_16px.png"))); // NOI18N
        btnRefreshStudents.setText("Refresh");
        btnRefreshStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshStudentsActionPerformed(evt);
            }
        });

        lbMessage.setForeground(new java.awt.Color(255, 255, 255));
        lbMessage.setText("Progress Here");

        javax.swing.GroupLayout left2Layout = new javax.swing.GroupLayout(left2);
        left2.setLayout(left2Layout);
        left2Layout.setHorizontalGroup(
            left2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(left2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                    .addGroup(left2Layout.createSequentialGroup()
                        .addGroup(left2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(left2Layout.createSequentialGroup()
                                .addComponent(pbProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefreshStudents)))
                .addContainerGap())
        );
        left2Layout.setVerticalGroup(
            left2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, left2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(left2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRefreshStudents)
                    .addGroup(left2Layout.createSequentialGroup()
                        .addComponent(lbMessage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pbProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane2.setLeftComponent(left2);

        right2.setBackground(new java.awt.Color(255, 255, 204));

        jScrollPane6.setBorder(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        jPanel10.setBackground(new java.awt.Color(22, 66, 33));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Grade Details");

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

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Basic");

        jLabel19.setText("Section Name:");

        lbSectionName2.setText("SECTION_NAME");

        jLabel21.setText("Subject Name:");

        lbSubjectName2.setText("SUBJECT_NAME");

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Grade Details");

        lbStatusOptions1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbStatusOptions1.setText("1st Quarter Status");

        jRadioButton17.setBackground(new java.awt.Color(255, 255, 255));
        q1StatusGroup.add(jRadioButton17);
        jRadioButton17.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton17.setForeground(new java.awt.Color(0, 102, 0));
        jRadioButton17.setSelected(true);
        jRadioButton17.setText("Open");
        jRadioButton17.setToolTipText("The subject teacher can edit the grades.");
        jRadioButton17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton17.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton17.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton17.setFocusable(false);
        jRadioButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton17.setOpaque(false);
        jRadioButton17.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton30MouseClicked(evt);
            }
        });

        jRadioButton18.setBackground(new java.awt.Color(255, 255, 255));
        q1StatusGroup.add(jRadioButton18);
        jRadioButton18.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton18.setForeground(new java.awt.Color(0, 0, 153));
        jRadioButton18.setText("Submitted");
        jRadioButton18.setToolTipText("Once submitted, subject teachers can't edit the grade anymore and should wait for the Approval of the Department Head");
        jRadioButton18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton18.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton18.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton18.setFocusable(false);
        jRadioButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton18.setOpaque(false);
        jRadioButton18.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton30MouseClicked(evt);
            }
        });

        jRadioButton19.setBackground(new java.awt.Color(255, 255, 255));
        q1StatusGroup.add(jRadioButton19);
        jRadioButton19.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton19.setForeground(new java.awt.Color(255, 102, 0));
        jRadioButton19.setText("Approved");
        jRadioButton19.setToolTipText("Approved by the Department Head and waiting for the Registrar to close it.");
        jRadioButton19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton19.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton19.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton19.setFocusable(false);
        jRadioButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton19.setOpaque(false);
        jRadioButton19.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton30MouseClicked(evt);
            }
        });

        jRadioButton20.setBackground(new java.awt.Color(255, 255, 255));
        q1StatusGroup.add(jRadioButton20);
        jRadioButton20.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton20.setForeground(new java.awt.Color(204, 0, 0));
        jRadioButton20.setText("Closed");
        jRadioButton20.setToolTipText("Closed by the Registrar and means it has been finalized.");
        jRadioButton20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton20.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton20.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton20.setFocusable(false);
        jRadioButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton20.setOpaque(false);
        jRadioButton20.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton30MouseClicked(evt);
            }
        });

        lbStatusOptions2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbStatusOptions2.setText("2nd Quarter Status");

        jRadioButton21.setBackground(new java.awt.Color(255, 255, 255));
        q2StatusGroup.add(jRadioButton21);
        jRadioButton21.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton21.setForeground(new java.awt.Color(0, 102, 0));
        jRadioButton21.setText("Open");
        jRadioButton21.setToolTipText("The subject teacher can edit the grades.");
        jRadioButton21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton21.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton21.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton21.setFocusable(false);
        jRadioButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton21.setOpaque(false);
        jRadioButton21.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton30MouseClicked(evt);
            }
        });

        jRadioButton22.setBackground(new java.awt.Color(255, 255, 255));
        q2StatusGroup.add(jRadioButton22);
        jRadioButton22.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton22.setForeground(new java.awt.Color(0, 0, 153));
        jRadioButton22.setSelected(true);
        jRadioButton22.setText("Submitted");
        jRadioButton22.setToolTipText("Once submitted, subject teachers can't edit the grade anymore and should wait for the Approval of the Department Head");
        jRadioButton22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton22.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton22.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton22.setFocusable(false);
        jRadioButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton22.setOpaque(false);
        jRadioButton22.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton30MouseClicked(evt);
            }
        });

        jRadioButton23.setBackground(new java.awt.Color(255, 255, 255));
        q2StatusGroup.add(jRadioButton23);
        jRadioButton23.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton23.setForeground(new java.awt.Color(255, 102, 0));
        jRadioButton23.setText("Approved");
        jRadioButton23.setToolTipText("Approved by the Department Head and waiting for the Registrar to close it.");
        jRadioButton23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton23.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton23.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton23.setFocusable(false);
        jRadioButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton23.setOpaque(false);
        jRadioButton23.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton30MouseClicked(evt);
            }
        });

        jRadioButton24.setBackground(new java.awt.Color(255, 255, 255));
        q2StatusGroup.add(jRadioButton24);
        jRadioButton24.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton24.setForeground(new java.awt.Color(204, 0, 0));
        jRadioButton24.setText("Closed");
        jRadioButton24.setToolTipText("Closed by the Registrar and means it has been finalized.");
        jRadioButton24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton24.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton24.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton24.setFocusable(false);
        jRadioButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton24.setOpaque(false);
        jRadioButton24.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton30MouseClicked(evt);
            }
        });

        lbStatusOptions3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbStatusOptions3.setText("3rd Quarter Status");

        jRadioButton25.setBackground(new java.awt.Color(255, 255, 255));
        q3tatusGroup.add(jRadioButton25);
        jRadioButton25.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton25.setForeground(new java.awt.Color(0, 102, 0));
        jRadioButton25.setText("Open");
        jRadioButton25.setToolTipText("The subject teacher can edit the grades.");
        jRadioButton25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton25.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton25.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton25.setFocusable(false);
        jRadioButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton25.setOpaque(false);
        jRadioButton25.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton30MouseClicked(evt);
            }
        });

        jRadioButton26.setBackground(new java.awt.Color(255, 255, 255));
        q3tatusGroup.add(jRadioButton26);
        jRadioButton26.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton26.setForeground(new java.awt.Color(0, 0, 153));
        jRadioButton26.setText("Submitted");
        jRadioButton26.setToolTipText("Once submitted, subject teachers can't edit the grade anymore and should wait for the Approval of the Department Head");
        jRadioButton26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton26.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton26.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton26.setFocusable(false);
        jRadioButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton26.setOpaque(false);
        jRadioButton26.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton30MouseClicked(evt);
            }
        });

        jRadioButton27.setBackground(new java.awt.Color(255, 255, 255));
        q3tatusGroup.add(jRadioButton27);
        jRadioButton27.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton27.setForeground(new java.awt.Color(255, 102, 0));
        jRadioButton27.setText("Approved");
        jRadioButton27.setToolTipText("Approved by the Department Head and waiting for the Registrar to close it.");
        jRadioButton27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton27.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton27.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton27.setFocusable(false);
        jRadioButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton27.setOpaque(false);
        jRadioButton27.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton30MouseClicked(evt);
            }
        });

        jRadioButton28.setBackground(new java.awt.Color(255, 255, 255));
        q3tatusGroup.add(jRadioButton28);
        jRadioButton28.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton28.setForeground(new java.awt.Color(204, 0, 0));
        jRadioButton28.setText("Closed");
        jRadioButton28.setToolTipText("Closed by the Registrar and means it has been finalized.");
        jRadioButton28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton28.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton28.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton28.setFocusable(false);
        jRadioButton28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton28.setOpaque(false);
        jRadioButton28.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton30MouseClicked(evt);
            }
        });

        jRadioButton29.setBackground(new java.awt.Color(255, 255, 255));
        q4StatusGroup.add(jRadioButton29);
        jRadioButton29.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton29.setForeground(new java.awt.Color(0, 102, 0));
        jRadioButton29.setText("Open");
        jRadioButton29.setToolTipText("The subject teacher can edit the grades.");
        jRadioButton29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton29.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton29.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton29.setFocusable(false);
        jRadioButton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton29.setOpaque(false);
        jRadioButton29.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton30MouseClicked(evt);
            }
        });

        jRadioButton30.setBackground(new java.awt.Color(255, 255, 255));
        q4StatusGroup.add(jRadioButton30);
        jRadioButton30.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton30.setForeground(new java.awt.Color(0, 0, 153));
        jRadioButton30.setSelected(true);
        jRadioButton30.setText("Submitted");
        jRadioButton30.setToolTipText("Once submitted, subject teachers can't edit the grade anymore and should wait for the Approval of the Department Head");
        jRadioButton30.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton30.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton30.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton30.setFocusable(false);
        jRadioButton30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton30.setOpaque(false);
        jRadioButton30.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton30MouseClicked(evt);
            }
        });

        jRadioButton31.setBackground(new java.awt.Color(255, 255, 255));
        q4StatusGroup.add(jRadioButton31);
        jRadioButton31.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton31.setForeground(new java.awt.Color(255, 102, 0));
        jRadioButton31.setText("Approved");
        jRadioButton31.setToolTipText("Approved by the Department Head and waiting for the Registrar to close it.");
        jRadioButton31.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton31.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton31.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton31.setFocusable(false);
        jRadioButton31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton31.setOpaque(false);
        jRadioButton31.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton30MouseClicked(evt);
            }
        });

        jRadioButton32.setBackground(new java.awt.Color(255, 255, 255));
        q4StatusGroup.add(jRadioButton32);
        jRadioButton32.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton32.setForeground(new java.awt.Color(204, 0, 0));
        jRadioButton32.setText("Closed");
        jRadioButton32.setToolTipText("Closed by the Registrar and means it has been finalized.");
        jRadioButton32.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton32.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton32.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton32.setFocusable(false);
        jRadioButton32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton32.setOpaque(false);
        jRadioButton32.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton30MouseClicked(evt);
            }
        });

        lbStatusOptions4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbStatusOptions4.setText("4th Quarter Status");

        btnSaveChangesCurrent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_save_16px.png"))); // NOI18N
        btnSaveChangesCurrent.setText("Save Changes (This Student)");

        btnSaveChangesAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_save_16px.png"))); // NOI18N
        btnSaveChangesAll.setText("Save All Changes");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSaveChangesCurrent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSectionName2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSubjectName2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbStatusOptions1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbStatusOptions2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbStatusOptions3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbStatusOptions4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jRadioButton17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton20))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jRadioButton21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton24))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jRadioButton25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton28))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jRadioButton29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton32)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnSaveChangesAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(lbSectionName2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(lbSubjectName2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbStatusOptions1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton17)
                    .addComponent(jRadioButton18)
                    .addComponent(jRadioButton19)
                    .addComponent(jRadioButton20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbStatusOptions2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton21)
                    .addComponent(jRadioButton22)
                    .addComponent(jRadioButton23)
                    .addComponent(jRadioButton24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbStatusOptions3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton25)
                    .addComponent(jRadioButton26)
                    .addComponent(jRadioButton27)
                    .addComponent(jRadioButton28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbStatusOptions4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton29)
                    .addComponent(jRadioButton30)
                    .addComponent(jRadioButton31)
                    .addComponent(jRadioButton32))
                .addGap(18, 18, 18)
                .addComponent(btnSaveChangesCurrent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSaveChangesAll)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jScrollPane6.setViewportView(jPanel2);

        jTabbedPane1.addTab("Main Details", jScrollPane6);

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));

        jPanel11.setBackground(new java.awt.Color(22, 66, 33));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Global Approval Controls");

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

        jLabel24.setText("Department Head Controls");

        btnDphSelected.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_to_do_16px.png"))); // NOI18N
        btnDphSelected.setText("Approve Selected");
        btnDphSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDphSelectedActionPerformed(evt);
            }
        });

        btnDphAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_check_all_16px.png"))); // NOI18N
        btnDphAll.setText("Approve All");
        btnDphAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDphAllActionPerformed(evt);
            }
        });

        jLabel25.setText("Registrar Controls");

        btnRgrSelected.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_to_do_16px.png"))); // NOI18N
        btnRgrSelected.setText("Close Selected");
        btnRgrSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRgrSelectedActionPerformed(evt);
            }
        });

        btnRgrAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_check_all_16px.png"))); // NOI18N
        btnRgrAll.setText("Close All");
        btnRgrAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRgrAllActionPerformed(evt);
            }
        });

        jLabel26.setText("Subject Teacher Controls");

        btnAdvSelected.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_to_do_16px.png"))); // NOI18N
        btnAdvSelected.setText("Submit Selected");
        btnAdvSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdvSelectedActionPerformed(evt);
            }
        });

        btnAdvAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_check_all_16px.png"))); // NOI18N
        btnAdvAll.setText("Submit All");
        btnAdvAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdvAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdvSelected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdvAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDphSelected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDphAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRgrSelected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRgrAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdvSelected)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdvAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDphSelected)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDphAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRgrSelected)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRgrAll)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane7.setViewportView(jPanel3);

        jTabbedPane1.addTab("Approval Controls", jScrollPane7);

        javax.swing.GroupLayout right2Layout = new javax.swing.GroupLayout(right2);
        right2.setLayout(right2Layout);
        right2Layout.setHorizontalGroup(
            right2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        right2Layout.setVerticalGroup(
            right2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        jSplitPane2.setRightComponent(right2);

        javax.swing.GroupLayout viewStudentsTab2Layout = new javax.swing.GroupLayout(viewStudentsTab2);
        viewStudentsTab2.setLayout(viewStudentsTab2Layout);
        viewStudentsTab2Layout.setHorizontalGroup(
            viewStudentsTab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1062, Short.MAX_VALUE)
        );
        viewStudentsTab2Layout.setVerticalGroup(
            viewStudentsTab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
        );

        jSplitPane1.setBorder(null);
        jSplitPane1.setDividerLocation(600);

        left.setBackground(new java.awt.Color(11, 102, 35));

        lbSearchResult1.setForeground(new java.awt.Color(255, 255, 255));
        lbSearchResult1.setText("Search using the search bar...");

        tfSearchEnrolledStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSearchEnrolledStudentsearchEnrolledStudentsHandler(evt);
            }
        });

        btnSearchEnrolledStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_find_user_male_16px.png"))); // NOI18N
        btnSearchEnrolledStudent.setText("Search");
        btnSearchEnrolledStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchEnrolledStudentsearchEnrolledStudentsHandler(evt);
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

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Grade Details");

        btnEditGrades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_edit_16px.png"))); // NOI18N
        btnEditGrades.setText("Edit Grades");
        btnEditGrades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditGradesActionPerformed(evt);
            }
        });

        lbDateUpdated.setText("Date Updated: YYYY-MM-DD HH:MM:SS");

        lbGradeStatus.setText("SUBMISSION_STATUS");

        jLabel5.setText("1st Quarter");

        tfFirstQ.setEditable(false);
        tfFirstQ.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfFirstQ.setText("90");

        jLabel6.setText("2nd Quarter");

        tfSecondQ.setEditable(false);
        tfSecondQ.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfSecondQ.setText("90");

        jLabel7.setText("3rd Quarter");

        tfThirdQ.setEditable(false);
        tfThirdQ.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfThirdQ.setText("90");

        jLabel8.setText("4th Quarter");

        tfFourthQ.setEditable(false);
        tfFourthQ.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfFourthQ.setText("90");

        jLabel9.setText("General Weighed Average");

        tfGeneralWeighedAverage.setEditable(false);
        tfGeneralWeighedAverage.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfGeneralWeighedAverage.setText("90");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Basic Info");

        lbSubjectName.setText("Subject Name: SUBJECT_NAME");

        jLabel15.setText("Record ID:");

        lbRecordId.setText("RECORD_ID");

        jLabel16.setText("Status :");

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
                    .addComponent(btnEditGrades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbDateUpdated, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbSubjectName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbRecordId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tfFirstQ, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tfSecondQ, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfThirdQ, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfFourthQ, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfGeneralWeighedAverage, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbGradeStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lbRecordId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSubjectName)
                .addGap(10, 10, 10)
                .addComponent(lbDateUpdated)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbGradeStatus)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfFirstQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSecondQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfThirdQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfFourthQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfGeneralWeighedAverage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditGrades)
                .addContainerGap(123, Short.MAX_VALUE))
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

        selectQuarterDialog.setBackground(new java.awt.Color(255, 255, 204));

        selectQuarterGroup.add(rbQuarter1);
        rbQuarter1.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        rbQuarter1.setText("First Quarter (Q1)");
        rbQuarter1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbQuarter1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        rbQuarter1.setIconTextGap(10);
        rbQuarter1.setOpaque(false);
        rbQuarter1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        rbQuarter1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbQuarter1cbAllowDecimalValuesMouseClicked(evt);
            }
        });

        lbQuarterSelect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbQuarterSelect.setText("Select Quarter:");

        btnSelectQuarter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_16px.png"))); // NOI18N
        btnSelectQuarter.setText("OK");
        btnSelectQuarter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectQuarterActionPerformed(evt);
            }
        });

        selectQuarterGroup.add(rbQuarter2);
        rbQuarter2.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        rbQuarter2.setText("Third Quarter (Q3)");
        rbQuarter2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbQuarter2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        rbQuarter2.setIconTextGap(10);
        rbQuarter2.setOpaque(false);
        rbQuarter2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        rbQuarter2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbQuarter2cbAllowDecimalValuesMouseClicked(evt);
            }
        });

        selectQuarterGroup.add(rbQuarter3);
        rbQuarter3.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        rbQuarter3.setSelected(true);
        rbQuarter3.setText("Second Quarter (Q2)");
        rbQuarter3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbQuarter3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        rbQuarter3.setIconTextGap(10);
        rbQuarter3.setOpaque(false);
        rbQuarter3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        rbQuarter3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbQuarter3cbAllowDecimalValuesMouseClicked(evt);
            }
        });

        selectQuarterGroup.add(rbQuarter4);
        rbQuarter4.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        rbQuarter4.setText("Fourth Quarter (Q4)");
        rbQuarter4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbQuarter4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        rbQuarter4.setIconTextGap(10);
        rbQuarter4.setOpaque(false);
        rbQuarter4.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        rbQuarter4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbQuarter4cbAllowDecimalValuesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout selectQuarterDialogLayout = new javax.swing.GroupLayout(selectQuarterDialog);
        selectQuarterDialog.setLayout(selectQuarterDialogLayout);
        selectQuarterDialogLayout.setHorizontalGroup(
            selectQuarterDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectQuarterDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(selectQuarterDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbQuarterSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, selectQuarterDialogLayout.createSequentialGroup()
                        .addGroup(selectQuarterDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rbQuarter4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbQuarter2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbQuarter3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbQuarter1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSelectQuarter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        selectQuarterDialogLayout.setVerticalGroup(
            selectQuarterDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectQuarterDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbQuarterSelect)
                .addGap(18, 18, 18)
                .addComponent(rbQuarter1)
                .addGap(4, 4, 4)
                .addComponent(rbQuarter3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbQuarter2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbQuarter4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSelectQuarter)
                .addContainerGap())
        );

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        contentsPanel.setBackground(new java.awt.Color(255, 255, 204));

        jPanel8.setBackground(new java.awt.Color(22, 66, 33));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Edit Grades");

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

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("1st Quarter");

        tfEditFirstQuarter.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfEditFirstQuarter.setText("90");
        tfEditFirstQuarter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                calculateGwaOnKeyReleaseHandler(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("2nd Quarter");

        tfEditSecondQuarter.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfEditSecondQuarter.setText("90");
        tfEditSecondQuarter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                calculateGwaOnKeyReleaseHandler(evt);
            }
        });

        tfEditThirdQuarter.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfEditThirdQuarter.setText("90");
        tfEditThirdQuarter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                calculateGwaOnKeyReleaseHandler(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("3rd Quarter");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("4th Quarter");

        tfEditFourthQuarter.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfEditFourthQuarter.setText("90");
        tfEditFourthQuarter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                calculateGwaOnKeyReleaseHandler(evt);
            }
        });

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Grade Details");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Computation Options");

        computationOptionGroup.add(rbAutomatic);
        rbAutomatic.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        rbAutomatic.setText("Automatic");
        rbAutomatic.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbAutomatic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        rbAutomatic.setIconTextGap(10);
        rbAutomatic.setOpaque(false);
        rbAutomatic.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        rbAutomatic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbAllowDecimalValuesMouseClicked(evt);
            }
        });

        computationOptionGroup.add(rbManual);
        rbManual.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        rbManual.setText("Manual");
        rbManual.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbManual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        rbManual.setIconTextGap(10);
        rbManual.setOpaque(false);
        rbManual.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        rbManual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbAllowDecimalValuesMouseClicked(evt);
            }
        });

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("General Weighed Average (GWA)");

        tfEditGwa.setEditable(false);
        tfEditGwa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfEditGwa.setText("90");
        tfEditGwa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEditGwaActionPerformed(evt);
            }
        });

        btnSaveGradeChanges.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_save_16px.png"))); // NOI18N
        btnSaveGradeChanges.setText("Save Changes");
        btnSaveGradeChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveGradeChangesActionPerformed(evt);
            }
        });

        cbAllowDecimalValues.setFont(myVariables.TEXTFIELD_FONT);
        cbAllowDecimalValues.setText("Allow decimal values?");
        cbAllowDecimalValues.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbAllowDecimalValues.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_checkbox_20px.png"))); // NOI18N
        cbAllowDecimalValues.setIconTextGap(10);
        cbAllowDecimalValues.setOpaque(false);
        cbAllowDecimalValues.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_checkbox_20px.png"))); // NOI18N
        cbAllowDecimalValues.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_checked_checkbox_20px.png"))); // NOI18N
        cbAllowDecimalValues.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbAllowDecimalValuesMouseClicked(evt);
            }
        });

        lbStatusOptions.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbStatusOptions.setText("Status Options");

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        q1StatusGroup.add(jRadioButton1);
        jRadioButton1.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton1.setForeground(new java.awt.Color(0, 102, 0));
        jRadioButton1.setText("Open");
        jRadioButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton1.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton1.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton1.setFocusable(false);
        jRadioButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton1.setOpaque(false);
        jRadioButton1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        q1StatusGroup.add(jRadioButton2);
        jRadioButton2.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton2.setForeground(new java.awt.Color(0, 0, 153));
        jRadioButton2.setText("Submitted");
        jRadioButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton2.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton2.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton2.setFocusable(false);
        jRadioButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton2.setOpaque(false);
        jRadioButton2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N

        jRadioButton3.setBackground(new java.awt.Color(255, 255, 255));
        q1StatusGroup.add(jRadioButton3);
        jRadioButton3.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton3.setForeground(new java.awt.Color(255, 102, 0));
        jRadioButton3.setText("Approved");
        jRadioButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton3.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton3.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton3.setFocusable(false);
        jRadioButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton3.setOpaque(false);
        jRadioButton3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N

        jRadioButton4.setBackground(new java.awt.Color(255, 255, 255));
        q1StatusGroup.add(jRadioButton4);
        jRadioButton4.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton4.setForeground(new java.awt.Color(204, 0, 0));
        jRadioButton4.setText("Closed");
        jRadioButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton4.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton4.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton4.setFocusable(false);
        jRadioButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton4.setOpaque(false);
        jRadioButton4.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N

        jRadioButton5.setBackground(new java.awt.Color(255, 255, 255));
        q2StatusGroup.add(jRadioButton5);
        jRadioButton5.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton5.setForeground(new java.awt.Color(0, 102, 0));
        jRadioButton5.setText("Open");
        jRadioButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton5.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton5.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton5.setFocusable(false);
        jRadioButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton5.setOpaque(false);
        jRadioButton5.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N

        jRadioButton6.setBackground(new java.awt.Color(255, 255, 255));
        q2StatusGroup.add(jRadioButton6);
        jRadioButton6.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton6.setForeground(new java.awt.Color(0, 0, 153));
        jRadioButton6.setText("Submitted");
        jRadioButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton6.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton6.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton6.setFocusable(false);
        jRadioButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton6.setOpaque(false);
        jRadioButton6.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N

        jRadioButton7.setBackground(new java.awt.Color(255, 255, 255));
        q2StatusGroup.add(jRadioButton7);
        jRadioButton7.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton7.setForeground(new java.awt.Color(255, 102, 0));
        jRadioButton7.setText("Approved");
        jRadioButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton7.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton7.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton7.setFocusable(false);
        jRadioButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton7.setOpaque(false);
        jRadioButton7.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N

        jRadioButton8.setBackground(new java.awt.Color(255, 255, 255));
        q2StatusGroup.add(jRadioButton8);
        jRadioButton8.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton8.setForeground(new java.awt.Color(204, 0, 0));
        jRadioButton8.setText("Closed");
        jRadioButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton8.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton8.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton8.setFocusable(false);
        jRadioButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton8.setOpaque(false);
        jRadioButton8.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N

        jRadioButton9.setBackground(new java.awt.Color(255, 255, 255));
        q3tatusGroup.add(jRadioButton9);
        jRadioButton9.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton9.setForeground(new java.awt.Color(0, 102, 0));
        jRadioButton9.setText("Open");
        jRadioButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton9.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton9.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton9.setFocusable(false);
        jRadioButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton9.setOpaque(false);
        jRadioButton9.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N

        jRadioButton10.setBackground(new java.awt.Color(255, 255, 255));
        q3tatusGroup.add(jRadioButton10);
        jRadioButton10.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton10.setForeground(new java.awt.Color(0, 0, 153));
        jRadioButton10.setText("Submitted");
        jRadioButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton10.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton10.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton10.setFocusable(false);
        jRadioButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton10.setOpaque(false);
        jRadioButton10.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N

        jRadioButton11.setBackground(new java.awt.Color(255, 255, 255));
        q3tatusGroup.add(jRadioButton11);
        jRadioButton11.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton11.setForeground(new java.awt.Color(255, 102, 0));
        jRadioButton11.setText("Approved");
        jRadioButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton11.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton11.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton11.setFocusable(false);
        jRadioButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton11.setOpaque(false);
        jRadioButton11.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N

        jRadioButton12.setBackground(new java.awt.Color(255, 255, 255));
        q3tatusGroup.add(jRadioButton12);
        jRadioButton12.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton12.setForeground(new java.awt.Color(204, 0, 0));
        jRadioButton12.setText("Closed");
        jRadioButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton12.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton12.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton12.setFocusable(false);
        jRadioButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton12.setOpaque(false);
        jRadioButton12.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N

        jRadioButton13.setBackground(new java.awt.Color(255, 255, 255));
        q4StatusGroup.add(jRadioButton13);
        jRadioButton13.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton13.setForeground(new java.awt.Color(0, 102, 0));
        jRadioButton13.setText("Open");
        jRadioButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton13.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton13.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton13.setFocusable(false);
        jRadioButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton13.setOpaque(false);
        jRadioButton13.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N

        jRadioButton14.setBackground(new java.awt.Color(255, 255, 255));
        q4StatusGroup.add(jRadioButton14);
        jRadioButton14.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton14.setForeground(new java.awt.Color(0, 0, 153));
        jRadioButton14.setText("Submitted");
        jRadioButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton14.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton14.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton14.setFocusable(false);
        jRadioButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton14.setOpaque(false);
        jRadioButton14.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N

        jRadioButton15.setBackground(new java.awt.Color(255, 255, 255));
        q4StatusGroup.add(jRadioButton15);
        jRadioButton15.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton15.setForeground(new java.awt.Color(255, 102, 0));
        jRadioButton15.setText("Approved");
        jRadioButton15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton15.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton15.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton15.setFocusable(false);
        jRadioButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton15.setOpaque(false);
        jRadioButton15.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N

        jRadioButton16.setBackground(new java.awt.Color(255, 255, 255));
        q4StatusGroup.add(jRadioButton16);
        jRadioButton16.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton16.setForeground(new java.awt.Color(204, 0, 0));
        jRadioButton16.setText("Closed");
        jRadioButton16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton16.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton16.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton16.setFocusable(false);
        jRadioButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton16.setOpaque(false);
        jRadioButton16.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N

        tfEvaluation.setEditable(false);
        tfEvaluation.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfEvaluation.setText("90");
        tfEvaluation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEvaluationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentsPanelLayout = new javax.swing.GroupLayout(contentsPanel);
        contentsPanel.setLayout(contentsPanelLayout);
        contentsPanelLayout.setHorizontalGroup(
            contentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentsPanelLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSaveGradeChanges, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbAutomatic, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbManual, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(contentsPanelLayout.createSequentialGroup()
                        .addGroup(contentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfEditFirstQuarter, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(contentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(contentsPanelLayout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton4))
                            .addComponent(lbStatusOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contentsPanelLayout.createSequentialGroup()
                        .addGroup(contentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfEditSecondQuarter, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton8))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contentsPanelLayout.createSequentialGroup()
                        .addGroup(contentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfEditThirdQuarter, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton12))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contentsPanelLayout.createSequentialGroup()
                        .addComponent(cbAllowDecimalValues)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfEditGwa, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfEvaluation, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contentsPanelLayout.createSequentialGroup()
                        .addGroup(contentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfEditFourthQuarter, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButton13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton16)))
                .addContainerGap())
        );
        contentsPanelLayout.setVerticalGroup(
            contentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(17, 17, 17)
                .addGroup(contentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbStatusOptions))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEditFirstQuarter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEditSecondQuarter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton6)
                    .addComponent(jRadioButton7)
                    .addComponent(jRadioButton8))
                .addGap(8, 8, 8)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEditThirdQuarter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton9)
                    .addComponent(jRadioButton10)
                    .addComponent(jRadioButton11)
                    .addComponent(jRadioButton12))
                .addGap(8, 8, 8)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEditFourthQuarter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton13)
                    .addComponent(jRadioButton14)
                    .addComponent(jRadioButton15)
                    .addComponent(jRadioButton16))
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbAutomatic)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbManual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEditGwa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAllowDecimalValues)
                    .addComponent(tfEvaluation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addComponent(btnSaveGradeChanges)
                .addContainerGap())
        );

        jScrollPane3.setViewportView(contentsPanel);

        javax.swing.GroupLayout editGradeDialogLayout = new javax.swing.GroupLayout(editGradeDialog);
        editGradeDialog.setLayout(editGradeDialogLayout);
        editGradeDialogLayout.setHorizontalGroup(
            editGradeDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        editGradeDialogLayout.setVerticalGroup(
            editGradeDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );

        myAssignedSubjectsDialog.setBackground(new java.awt.Color(255, 255, 204));

        jPanel9.setBackground(new java.awt.Color(22, 66, 33));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Assigned Subjects");

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

        assignedSubjectsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Subject Code", "Description", "Grade Level"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        assignedSubjectsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(assignedSubjectsTable);
        if (assignedSubjectsTable.getColumnModel().getColumnCount() > 0) {
            assignedSubjectsTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            assignedSubjectsTable.getColumnModel().getColumn(1).setMaxWidth(100);
            assignedSubjectsTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            assignedSubjectsTable.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        jLabel17.setText("These subjects above are given to you by Curriculum Head users.");

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_sync_16px.png"))); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout myAssignedSubjectsDialogLayout = new javax.swing.GroupLayout(myAssignedSubjectsDialog);
        myAssignedSubjectsDialog.setLayout(myAssignedSubjectsDialogLayout);
        myAssignedSubjectsDialogLayout.setHorizontalGroup(
            myAssignedSubjectsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myAssignedSubjectsDialogLayout.createSequentialGroup()
                .addGroup(myAssignedSubjectsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myAssignedSubjectsDialogLayout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefresh))
                    .addGroup(myAssignedSubjectsDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(myAssignedSubjectsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        myAssignedSubjectsDialogLayout.setVerticalGroup(
            myAssignedSubjectsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myAssignedSubjectsDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(myAssignedSubjectsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Grading System Dashboard");
        setIconImage(my.getImgIcn(myVariables.getGradingWindowIcon()).getImage()
        );
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 255, 204));
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 204));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1003, 600));

        headerPanel.setBackground(new java.awt.Color(22, 66, 33));

        lbSchoolName.setBackground(new java.awt.Color(255, 255, 255));
        lbSchoolName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbSchoolName.setForeground(new java.awt.Color(255, 255, 255));
        lbSchoolName.setText("SCHOOL_NAME Grading System");

        lbSchoolAddress.setBackground(new java.awt.Color(255, 255, 255));
        lbSchoolAddress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbSchoolAddress.setForeground(new java.awt.Color(255, 255, 255));
        lbSchoolAddress.setText("SCHOOL_ADDRESS");

        lbLoggedInUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbLoggedInUser.setForeground(new java.awt.Color(255, 255, 255));
        lbLoggedInUser.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbLoggedInUser.setText("Welcome USER_NAME, ACCESS_LEVEL");

        btnMyManagedSubjects.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_classroom_16px.png"))); // NOI18N
        btnMyManagedSubjects.setText("My Assigned Subjects");
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
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

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        my.openWindow(this, new login());
    }//GEN-LAST:event_formWindowClosed

    private void tfSearchTeacherLoadsearchManagedSections(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSearchTeacherLoadsearchManagedSections
        String toSearch = tfSearchTeacherLoad.getText();
        String schoolYear = jcbSchoolYear1.getSelectedItem().toString();

        my.remove_multiple_tabs(mainTab, new int [] {1,2});

        String where = "WHERE subjectCode NOT LIKE 'ADV%'";
        
        //Filter search based on Access Level
        switch (myVariables.getAccessLevel()){
            case 1:{    //Teacher or Subject Teacher
                where += " AND teacherId='"+myVariables.getUserLoggedInId()+"'";
                break;
            }case 2:{   //Department Head
                String managedSubjects = "";
                
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
                
                where += " AND teacherId!='-1'";
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
    }//GEN-LAST:event_tfSearchTeacherLoadsearchManagedSections

    private void btnSearchSectionsearchManagedSections(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchSectionsearchManagedSections
        String toSearch = tfSearchTeacherLoad.getText();
        String schoolYear = jcbSchoolYear1.getSelectedItem().toString();

        my.remove_multiple_tabs(mainTab, new int [] {1,2});

        String where = "WHERE subjectCode NOT LIKE 'ADV%'";
        
        //Filter search based on Access Level
        switch (myVariables.getAccessLevel()){
            case 1:{    //Teacher or Subject Teacher
                where += " AND teacherId='"+myVariables.getUserLoggedInId()+"'";
                break;
            }case 2:{   //Department Head
                String managedSubjects = "";
                
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
                
                where += " AND teacherId!='-1'";
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
    }//GEN-LAST:event_btnSearchSectionsearchManagedSections

    private void assignedTeacherTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_assignedTeacherTableMouseClicked
        if(evt.getClickCount() == 2){
            if(mainTab.getTabCount() <= 1){
                int row = assignedTeacherTable.getSelectedRow();
                
                String sectionName = assignedTeacherTable.getValueAt(row, 2).toString();
                String subjectName = assignedTeacherTable.getValueAt(row, 8).toString();
                
                lbSubjectName2.setText(subjectName.toUpperCase());
                lbSectionName2.setText(sectionName.toUpperCase());
                
                mainTab.addTab("View Students", my.getImgIcn(myVariables.getViewStudentsIcon()), viewStudentsTab2);
                mainTab.setSelectedIndex(1);
            }
            //resetStudentDetails(true, true, false);
            loadStudentsAndGrades();
            //calculateAttendanceCount(lbAttendanceCount, attendanceTable);
        }else{
            my.remove_multiple_tabs(mainTab, new int [] {1,2});
        }
    }//GEN-LAST:event_assignedTeacherTableMouseClicked

    private void tfSearchEnrolledStudentsearchEnrolledStudentsHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSearchEnrolledStudentsearchEnrolledStudentsHandler
        //DUPLICATED SEARCH
        int row = assignedTeacherTable.getSelectedRow();

        if(row == -1){
            my.showMessage("Please select a section first.", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String sectionId = assignedTeacherTable.getValueAt(row, 1).toString();
        String toSearch = tfSearchEnrolledStudent.getText();

        resetStudentDetails(true, true, false);
        String where = "WHERE sectionId='"+sectionId+"' AND (lrn='"+toSearch+"' OR lName LIKE '%"+toSearch+"%')";
        my.searchItem(where, enrolledStudentsTable, 6, null, new int [] {3,4,5}, true, true, lbSearchResult1, tfSearchEnrolledStudent, true);
    }//GEN-LAST:event_tfSearchEnrolledStudentsearchEnrolledStudentsHandler

    private void btnSearchEnrolledStudentsearchEnrolledStudentsHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchEnrolledStudentsearchEnrolledStudentsHandler
        //DUPLICATED SEARCH
        int row = assignedTeacherTable.getSelectedRow();

        if(row == -1){
            my.showMessage("Please select a section first.", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String sectionId = assignedTeacherTable.getValueAt(row, 1).toString();
        String toSearch = tfSearchEnrolledStudent.getText();
        
        resetStudentDetails(true, true, false);
        String where = "WHERE sectionId='"+sectionId+"' AND (lrn='"+toSearch+"' OR lName LIKE '%"+toSearch+"%')";
        my.searchItem(where, enrolledStudentsTable, 6, null, new int [] {3,4,5}, true, true, lbSearchResult1, tfSearchEnrolledStudent, true);
    }//GEN-LAST:event_btnSearchEnrolledStudentsearchEnrolledStudentsHandler

    private void enrolledStudentsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enrolledStudentsTableMouseClicked
        if(evt.getClickCount() == 2){
            int row = enrolledStudentsTable.getSelectedRow();
            int sectionRow = assignedTeacherTable.getSelectedRow();
            
            String sectionId = assignedTeacherTable.getValueAt(sectionRow,1).toString();
            String subjectId = assignedTeacherTable.getValueAt(sectionRow, 6).toString();
            String studentId = enrolledStudentsTable.getValueAt(row, 1).toString();
            
            //Check if record exists...Add if none are found
            String where = "WHERE sectionId='"+sectionId+"' AND subjectId='"+subjectId+"' AND studentId='"+studentId+"'";
            
            if(my.checkForDuplicates("grades", where, myVariables.getGradesOrder())){
                //Load data here
                System.err.println("Record found.");
                String result[] = my.return_values("*", "grades", where, myVariables.getGradesOrder());
                
                if(result != null){
                    String values[] = result[0].split("@@");
                    
                    lbRecordId.setText(values[0]);
                    lbDateUpdated.setText("Date:  "+my.numberToWordDate(values[10]));
                    lbGradeStatus.setText(values[9]);
                    
                    tfFirstQ.setText(values[4].contains("-1")||Double.valueOf(values[4])== 0? " " : values[4]);
                    tfSecondQ.setText(values[5].contains("-1")||Double.valueOf(values[5])== 0? " " : values[5]);
                    tfThirdQ.setText(values[6].contains("-1")||Double.valueOf(values[6])== 0? " " : values[6]);
                    tfFourthQ.setText(values[7].contains("-1")||Double.valueOf(values[7])== 0? " " : values[7]);
                    tfGeneralWeighedAverage.setText(values[8].contains("-1")? " " : values[8]);
                    
                    resetStudentDetails(false, false, true);
                }else{
                    my.showMessage("Oooops! This record might have been deleted just now.\nPlease contact your Developer for help.", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                if(my.getConfirmation("This student has no record yet. Add one now?")){
                    String [] toSend = {
                        "null,'"+studentId+"','"+sectionId+"','"+subjectId+"','Open:Open:Open:Open:Incomplete:',now()",
                    };
                    
                    if(my.add_values("grades", "id,studentId,sectionId,subjectId,status,dateUpdated", toSend)){
                        my.showMessage("Adding Successful. Please select the student again", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        my.showMessage("Adding Failed. Please make sure you are connected to the School Network.", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    my.showMessage("Adding Grade Records canceled.", JOptionPane.PLAIN_MESSAGE);
                }
            }
        }else{
            resetStudentDetails(false, true, false);
        }
    }//GEN-LAST:event_enrolledStudentsTableMouseClicked

    private void tfEditGwaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEditGwaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEditGwaActionPerformed

    private void btnEditGradesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditGradesActionPerformed
        String q1 = tfFirstQ.getText().trim();
        String q2 = tfSecondQ.getText().trim();
        String q3 = tfThirdQ.getText().trim();
        String q4 = tfFourthQ.getText().trim();
        String gwa = tfGeneralWeighedAverage.getText().trim();
        
        tfEditFirstQuarter.setText(q1);
        tfEditSecondQuarter.setText(q2);
        tfEditThirdQuarter.setText(q3);
        tfEditFourthQuarter.setText(q4);
        tfEditGwa.setText(gwa);
        
        //Load Status
        String [] statuses = lbGradeStatus.getText().split(":");
        JTextField [] quarterFields = {tfEditFirstQuarter,tfEditSecondQuarter,tfEditThirdQuarter,tfEditFourthQuarter};
        JRadioButton [][] radioSets = {
            new JRadioButton[] {jRadioButton1,jRadioButton2,jRadioButton3,jRadioButton4},
            new JRadioButton[] {jRadioButton5,jRadioButton6,jRadioButton7,jRadioButton8},
            new JRadioButton[] {jRadioButton9,jRadioButton10,jRadioButton11,jRadioButton12},
            new JRadioButton[] {jRadioButton13,jRadioButton14,jRadioButton15,jRadioButton16},
        };
        for(int n=0;n<statuses.length;n++){
            if(n==4){
                tfEvaluation.setText(statuses[n]);
                break;
            }
            loadStatuses(quarterFields[n], statuses[n], radioSets[n], myVariables.getAccessLevel()!=5? true:false);
        }
        enableDisableSaveButtonViaStatus();
        
        if(myVariables.getAccessLevel() == 5){
            lbStatusOptions.setText("Status Options (Ignored By Admin)");
        }else{
            lbStatusOptions.setText("Status Options");
        }
        
        cbAllowDecimalValues.setSelected(false);
        checkCalculationMethod(false,cbAllowDecimalValues.isSelected());
        
        showCustomDialog("Edit Grade Details", editGradeDialog, true, 450, 580, true);
    }//GEN-LAST:event_btnEditGradesActionPerformed

    private void btnSaveGradeChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveGradeChangesActionPerformed
        String recordId = lbRecordId.getText();
        String q1 = tfEditFirstQuarter.getText().trim().length()>0? tfEditFirstQuarter.getText() : "-1";
        String q2 = tfEditSecondQuarter.getText().trim().length()>0? tfEditSecondQuarter.getText() : "-1";
        String q3 = tfEditThirdQuarter.getText().trim().length()>0? tfEditThirdQuarter.getText() : "-1";
        String q4 = tfEditFourthQuarter.getText().trim().length()>0? tfEditFourthQuarter.getText() : "-1";
        String gwa = tfEditGwa.getText().trim();
        String status = retrieveStatuses();
        
        
        if(gwa.contains("NaN")){
            my.showMessage("Invalid Grade. Please check your inputs first.", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String [] sets = {
            "firstQuarter='"+q1+"'",
            "secondQuarter='"+q2+"'",
            "thirdQuarter='"+q3+"'",
            "fourthQuarter='"+q4+"'",
            "gwa='"+gwa+"'",
            "status='"+status+"'",
            "dateUpdated=now()",
        };
        
        if(my.update_values("grades", sets, "id='"+recordId+"'")){
            my.showMessage("Changes Saved.", JOptionPane.INFORMATION_MESSAGE);
            closeCustomDialog();
            resetStudentDetails(false, true, false);
        }else{
            my.showMessage("Update Failed. Please make sure you are connected to the School Network", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveGradeChangesActionPerformed

    private void calculateGwaOnKeyReleaseHandler(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_calculateGwaOnKeyReleaseHandler
        checkCalculationMethod(true,cbAllowDecimalValues.isSelected());
    }//GEN-LAST:event_calculateGwaOnKeyReleaseHandler

    private void cbAllowDecimalValuesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbAllowDecimalValuesMouseClicked
        checkCalculationMethod(true, cbAllowDecimalValues.isSelected());
    }//GEN-LAST:event_cbAllowDecimalValuesMouseClicked

    private void btnMyManagedSubjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyManagedSubjectsActionPerformed
        showCustomDialog("My Assigned Subjects", myAssignedSubjectsDialog, true, 500, 400, false);
    }//GEN-LAST:event_btnMyManagedSubjectsActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        refreshAssignedSubjects(true);
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void tfEvaluationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEvaluationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEvaluationActionPerformed

    private void enrolledStudentsTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enrolledStudentsTable1MouseClicked
        int row = enrolledStudentsTable1.getSelectedRow();
        int col = enrolledStudentsTable1.getSelectedColumn();
        
        if(row != -1){
            String statuses = enrolledStudentsTable1.getValueAt(row, 12).toString();            
            btnSaveChangesCurrent.setEnabled(true);
            
            if(!statuses.contains("--")){
                loadStatusRadioBtns(statuses);
                
                if(col >= 7 && col <= 11){
                    //Check if status is open And can only be edited by Subject Teacher, Registrar or Admin
                    if(canEditGrade(col) && (myVariables.getAccessLevel() == 1 || myVariables.getAccessLevel() >= 4)){
                        String studentName = enrolledStudentsTable1.getValueAt(row, 3).toString();
                        String currentGrade = enrolledStudentsTable1.getValueAt(row, col).toString();
                        
                        String temp = (String) JOptionPane.showInputDialog(
                                this,
                                col-6!= 5? "Quarter " + (col-6) + " Grade:" : "General Average",
                                studentName,
                                JOptionPane.INFORMATION_MESSAGE,
                                my.getImgIcn(myVariables.getMsgUrlIcon()),
                                null,currentGrade
                        );
                        
                        if(temp != null){
                            enrolledStudentsTable1.setValueAt(temp, row, col);
                            calculateGrade(row);
                        } else {
                            //enrolledStudentsTable1.setValueAt(0, row, col);
                        }
                    }
                }
                
                return;
            }else {
                int row2 = assignedTeacherTable.getSelectedRow();
                String studentId = enrolledStudentsTable1.getValueAt(row, 1).toString();
                String sectionId = enrolledStudentsTable1.getValueAt(row, 5).toString();
                String subjectId = assignedTeacherTable.getValueAt(row2, 6).toString();
                
                if(my.getConfirmation("This student has no record yet. Add one now?")){
                    String [] toSend = {
                        "null,'"+studentId+"','"+sectionId+"','"+subjectId+"','Open:Open:Open:Open:Incomplete:',now()",
                    };
                    
                    if(my.add_values("grades", "id,studentId,sectionId,subjectId,status,dateUpdated", toSend)){
                        my.showMessage("Adding Successful. Please select the student again", JOptionPane.INFORMATION_MESSAGE);
                        loadStudentsAndGrades();
                    }else{
                        my.showMessage("Adding Failed. Please make sure you are connected to the School Network.", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    my.showMessage("Adding Grade Records canceled.", JOptionPane.PLAIN_MESSAGE);
                }
            }
            
            loadStatusRadioBtns(null);
        }        
    }//GEN-LAST:event_enrolledStudentsTable1MouseClicked
    private boolean canEditGrade(int column){
        switch(column){
            case 7:{
                return jRadioButton17.isSelected();
            }case 8:{
                return jRadioButton21.isSelected();
            }case 9:{
                return jRadioButton25.isSelected();
            }case 10:{
                return jRadioButton29.isSelected();
            }case 11:{
                return true;//can edit General Average Directly
            } default: {
                return false;
            }
        }
    }
    
    private void btnRefreshStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshStudentsActionPerformed
        loadStudentsAndGrades();
    }//GEN-LAST:event_btnRefreshStudentsActionPerformed

    private void enrolledStudentsTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_enrolledStudentsTable1KeyReleased
        int row = enrolledStudentsTable1.getSelectedRow();
        int col = enrolledStudentsTable1.getSelectedColumn();
        
        if(row != -1 && (evt.getKeyCode() == KeyEvent.VK_RIGHT || evt.getKeyCode() == KeyEvent.VK_LEFT)){
            String statuses = enrolledStudentsTable1.getValueAt(row, 12).toString();
            btnSaveChangesCurrent.setEnabled(true);
            
            if(!statuses.contains("--")){
                loadStatusRadioBtns(statuses);
                
                if(col >= 7 && col <= 11){
                    //Check if status is open
                    if(canEditGrade(col)){
                        String studentName = enrolledStudentsTable1.getValueAt(row, 3).toString();
                        String currentGrade = enrolledStudentsTable1.getValueAt(row, col).toString();
                        
                        String temp = (String) JOptionPane.showInputDialog(
                                this,
                                col-6!= 5? "Quarter " + (col-6) + " Grade:" : "General Average",
                                studentName,
                                JOptionPane.INFORMATION_MESSAGE,
                                my.getImgIcn(myVariables.getMsgUrlIcon()),
                                null,currentGrade
                        );
                        
                        if(temp != null){
                            enrolledStudentsTable1.setValueAt(temp, row, col);
                            calculateGrade(row);
                        } else {
                            
                        }
                    }
                }
                
                return;
            }
            
            loadStatusRadioBtns(null);
        }
    }//GEN-LAST:event_enrolledStudentsTable1KeyReleased

    private void jRadioButton30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton30MouseClicked
        int row = enrolledStudentsTable1.getSelectedRow();
        
        if(row != -1){
            String result = retrieveCheckedStatuses(row, false);
            enrolledStudentsTable1.setValueAt(result, row, 12);
        }
    }//GEN-LAST:event_jRadioButton30MouseClicked

    private void rbQuarter1cbAllowDecimalValuesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbQuarter1cbAllowDecimalValuesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rbQuarter1cbAllowDecimalValuesMouseClicked

    private void rbQuarter2cbAllowDecimalValuesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbQuarter2cbAllowDecimalValuesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rbQuarter2cbAllowDecimalValuesMouseClicked

    private void rbQuarter3cbAllowDecimalValuesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbQuarter3cbAllowDecimalValuesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rbQuarter3cbAllowDecimalValuesMouseClicked

    private void rbQuarter4cbAllowDecimalValuesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbQuarter4cbAllowDecimalValuesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rbQuarter4cbAllowDecimalValuesMouseClicked

    private void btnAdvSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdvSelectedActionPerformed
        selectQuarter("Submit Selected");
    }//GEN-LAST:event_btnAdvSelectedActionPerformed

    private void btnAdvAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdvAllActionPerformed
        selectQuarter("Submit All");
    }//GEN-LAST:event_btnAdvAllActionPerformed

    private void btnDphSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDphSelectedActionPerformed
        selectQuarter("Approve Selected");
    }//GEN-LAST:event_btnDphSelectedActionPerformed

    private void btnDphAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDphAllActionPerformed
        selectQuarter("Approve All");
    }//GEN-LAST:event_btnDphAllActionPerformed

    private void btnRgrSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRgrSelectedActionPerformed
        selectQuarter("Close Selected");
    }//GEN-LAST:event_btnRgrSelectedActionPerformed

    private void btnRgrAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRgrAllActionPerformed
        selectQuarter("Close All");
    }//GEN-LAST:event_btnRgrAllActionPerformed

    private void btnSelectQuarterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectQuarterActionPerformed
        //Save Here
        
        closeCustomDialog();
    }//GEN-LAST:event_btnSelectQuarterActionPerformed
    
    
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
    private void selectQuarter(String title){
        switch (enrolledStudentsTable1.getSelectedColumn()){
            case 7: {
                rbQuarter1.setSelected(true);
                break;
            }case 8: {
                rbQuarter2.setSelected(true);
                break;
            }case 9: {
                rbQuarter3.setSelected(true);
                break;
            }case 10: {
                rbQuarter4.setSelected(true);
                break;
            }default: {
                rbQuarter1.setSelected(true);
                break;
            }
        }
        showCustomDialog(title, selectQuarterDialog, true, 250, 300, false);
        
        btnSelectQuarter.requestFocus();
    }
    
    private void updateStatusFields(){
        int row = enrolledStudentsTable1.getSelectedRow();
        
        if(row != -1){
            JRadioButton [][] radioSets = {
                new JRadioButton[] {jRadioButton17,jRadioButton18,jRadioButton19,jRadioButton20},
                new JRadioButton[] {jRadioButton21,jRadioButton22,jRadioButton23,jRadioButton24},
                new JRadioButton[] {jRadioButton25,jRadioButton26,jRadioButton27,jRadioButton28},
                new JRadioButton[] {jRadioButton29,jRadioButton30,jRadioButton31,jRadioButton32},
            };
            String status = retrieveStatuses();
        }
    }
    
    private void resetStudentDetails(boolean clearTable,boolean clearFields, boolean enableEditBtn){
        if(clearTable){
            my.clear_table_rows(enrolledStudentsTable);
        }
        if(clearFields){
            lbRecordId.setText(" --Please Select A Student--");
            lbDateUpdated.setText("Date: --Please Select A Student--");
            lbGradeStatus.setText(" --Please Select A Student--");
            
            tfFirstQ.setText("");
            tfSecondQ.setText("");
            tfThirdQ.setText("");
            tfFourthQ.setText("");
            tfGeneralWeighedAverage.setText("");
        }
        
        btnEditGrades.setEnabled(enableEditBtn);
    }
    private String getEvaluation(double gwa){
        //Check if all fields have values
        if(tfEditFirstQuarter.getText().length() == 0 || tfEditSecondQuarter.getText().length() == 0 
                || tfEditThirdQuarter.getText().length() == 0 || tfEditFourthQuarter.getText().length() == 0)
            return "Incomplete";
        if(gwa<75f){
            return "Failed";
        }else{
            return "Passed";
        }
    }
    private String getEvaluation(int row, double gwa){
        //Check if all fields have values
        if(enrolledStudentsTable1.getValueAt(row, 7).toString().length() == 0 || 
            enrolledStudentsTable1.getValueAt(row, 8).toString().length() == 0 ||
            enrolledStudentsTable1.getValueAt(row, 9).toString().length() == 0 ||
            enrolledStudentsTable1.getValueAt(row, 10).toString().length() == 0){
            return "Incomplete";
        }
        if(gwa<75f){
            return "Failed";
        }else{
            return "Passed";
        }
    }
    private void calculateGrade(int row){
        int q1,q2,q3,q4,gwa;
        
        //Column 7 = Q1
        
        try {
            q1 = enrolledStudentsTable1.getValueAt(row, 7).toString().length()>0 ?
                    Integer.parseInt(enrolledStudentsTable1.getValueAt(row, 7).toString()) : 0;
            q2 = enrolledStudentsTable1.getValueAt(row, 8).toString().length()>0 ?
                    Integer.parseInt(enrolledStudentsTable1.getValueAt(row, 8).toString()) : 0;
            q3 = enrolledStudentsTable1.getValueAt(row, 9).toString().length()>0 ?
                    Integer.parseInt(enrolledStudentsTable1.getValueAt(row, 9).toString()) : 0;
            q4 = enrolledStudentsTable1.getValueAt(row, 10).toString().length()>0 ?
                    Integer.parseInt(enrolledStudentsTable1.getValueAt(row, 10).toString()) : 0;

            gwa = (q1+q2+q3+q4)/4;

            enrolledStudentsTable1.setValueAt(gwa,row, 11);
            
            String newStatus = my.setValueAtColumn(
                    enrolledStudentsTable1.getValueAt(row, 12).toString().replace(":", "@@"),
                    4, getEvaluation(row,gwa)
            );
            enrolledStudentsTable1.setValueAt(newStatus.replace("@@",":"), row, 12);
        } catch (Exception e) {
            System.err.println("Invalid Values entered");
            tfEditGwa.setText("NaN");
        }
    }
    
    private void checkCalculationMethod(boolean calculateGwa,boolean allowDecimalValues){
        if(rbAutomatic.isSelected()){
            tfEditGwa.setEditable(false);
            tfEvaluation.setEditable(false);
        }
        if(rbManual.isSelected()){
            tfEditGwa.setEditable(true);
            tfEvaluation.setEditable(true);
            return;
        }
        
        if(calculateGwa && rbAutomatic.isSelected()){
            if(allowDecimalValues){
                DecimalFormat df = new DecimalFormat("#.##");
                double q1,q2,q3,q4,gwa;
                
                try {
                    q1 = tfEditFirstQuarter.getText().length()>0 ? Double.parseDouble(tfEditFirstQuarter.getText()) : 0f;
                    q2 = tfEditSecondQuarter.getText().length()>0 ? Double.parseDouble(tfEditSecondQuarter.getText()) : 0f;
                    q3 = tfEditThirdQuarter.getText().length()>0 ? Double.parseDouble(tfEditThirdQuarter.getText()) : 0f;
                    q4 = tfEditFourthQuarter.getText().length()>0 ? Double.parseDouble(tfEditFourthQuarter.getText()) : 0f;

                    gwa = (q1+q2+q3+q4)/4;

                    tfEditGwa.setText(String.valueOf(df.format(gwa)));
                    tfEvaluation.setText(getEvaluation(gwa));
                } catch (Exception e) {
                    System.err.println("Invalid Values entered");
                    tfEditGwa.setText("NaN");
                }
            }else{
                int q1,q2,q3,q4,gwa;
                try {
                    q1 = tfEditFirstQuarter.getText().length()>0 ? Integer.parseInt(tfEditFirstQuarter.getText()) : 0;
                    q2 = tfEditSecondQuarter.getText().length()>0 ? Integer.parseInt(tfEditSecondQuarter.getText()) : 0;
                    q3 = tfEditThirdQuarter.getText().length()>0 ? Integer.parseInt(tfEditThirdQuarter.getText()) : 0;
                    q4 = tfEditFourthQuarter.getText().length()>0 ? Integer.parseInt(tfEditFourthQuarter.getText()) : 0;

                    gwa = (q1+q2+q3+q4)/4;

                    tfEditGwa.setText(String.valueOf(gwa));
                    tfEvaluation.setText(getEvaluation(gwa));
                } catch (Exception e) {
                    System.err.println("Invalid Values entered");
                    tfEditGwa.setText("NaN");
                }
            }
        }
    }
    private void loadStatuses(JTextField quarterTextField,String status, JRadioButton [] radioButtonsInOrder, boolean disableByUserLevel){
        switch(status){
            case "Open":{
                quarterTextField.setEditable(true);
                radioButtonsInOrder[0].setSelected(true);
                break;
            }case "Submitted":{
                quarterTextField.setEditable(false);
                radioButtonsInOrder[1].setSelected(true);
                break;
            }case "Approved":{
                quarterTextField.setEditable(false);
                radioButtonsInOrder[2].setSelected(true);
                break;
            }case "Closed":{
                quarterTextField.setEditable(false);
                radioButtonsInOrder[3].setSelected(true);
                break;
            }
        }
        
        if(disableByUserLevel){
            switch(myVariables.getAccessLevel()){
                case 5:{
                    for(JRadioButton n : radioButtonsInOrder){
                        n.setEnabled(true);
                    }
                    break;
                }case 4:{
                    radioButtonsInOrder[0].setEnabled(true);    //Open
                    radioButtonsInOrder[1].setEnabled(false);   //Submitted
                    radioButtonsInOrder[2].setEnabled(true);   //Approved
                    radioButtonsInOrder[3].setEnabled(true);    //Closed
                    break;
                }case 2:{
                    if(status.contains("Closed")){
                        //Disable all
                        radioButtonsInOrder[0].setEnabled(false);
                        radioButtonsInOrder[1].setEnabled(false);
                        radioButtonsInOrder[2].setEnabled(false);
                        radioButtonsInOrder[3].setEnabled(false);
                    }else{
                        radioButtonsInOrder[0].setEnabled(true);
                        radioButtonsInOrder[1].setEnabled(true);
                        radioButtonsInOrder[2].setEnabled(true);
                        radioButtonsInOrder[3].setEnabled(false);
                    }
                    break;
                }case 1:{
                    for(JRadioButton n : radioButtonsInOrder){
                        n.setEnabled(false);
                    }
                    break;
                }
                default:{
                    break;
                }
            }
        }
    }
    private void enableDisableSaveButtonViaStatus(){
        //Disable save button if all statuses are not equal to open. Note: Works on Access Level 1 users only.
        if(!jRadioButton1.isSelected() && !jRadioButton5.isSelected() && !jRadioButton9.isSelected() && !jRadioButton13.isSelected() && myVariables.getAccessLevel()==1){
            btnSaveGradeChanges.setEnabled(false);
        }else{
            btnSaveGradeChanges.setEnabled(true);
        }
    }
    private void loadStatusRadioBtns(String statuses){
        JRadioButton [][] radioSets = {
            new JRadioButton[] {jRadioButton17,jRadioButton18,jRadioButton19,jRadioButton20},
            new JRadioButton[] {jRadioButton21,jRadioButton22,jRadioButton23,jRadioButton24},
            new JRadioButton[] {jRadioButton25,jRadioButton26,jRadioButton27,jRadioButton28},
            new JRadioButton[] {jRadioButton29,jRadioButton30,jRadioButton31,jRadioButton32},
        };
        ButtonGroup [] radioGroups = {q1StatusGroup,q2StatusGroup,q3tatusGroup,q4StatusGroup};
        
        if(statuses == null){
            
            //Disable & uncheck all
            for (int n = 0; n < radioSets.length; n++) {
                radioGroups[n].clearSelection();
                for (int x = 0; x < 4; x++) {
                    radioSets[n][x].setEnabled(false);
                }
            }
            
            btnSaveChangesCurrent.setEnabled(false);
            btnSaveChangesAll.setEnabled(false);
        } else {
            String [] status = statuses.split(":");
            
            //Check Based on status
            for (int n = 0; n < radioSets.length; n++) {
                switch (status[n]){
                    case "Open":{
                        radioSets[n][0].setSelected(true); break;
                    }case "Submitted":{
                        radioSets[n][1].setSelected(true); break;
                    }case "Approved":{
                        radioSets[n][2].setSelected(true); break;
                    }case "Closed":{
                        radioSets[n][3].setSelected(true); break;
                    }
                }
            }
            enableDisableRadioBtnsByUserType();
        }
    }
    private String retrieveCheckedStatuses(int row, boolean checkForSubmittedGrades ){
        String status [] = new String[4];
        String previousStatuses [] = enrolledStudentsTable1.getValueAt(row, 12).toString().split(":");
        
        JRadioButton [][] radioSets = {
            new JRadioButton[] {jRadioButton17,jRadioButton18,jRadioButton19,jRadioButton20},
            new JRadioButton[] {jRadioButton21,jRadioButton22,jRadioButton23,jRadioButton24},
            new JRadioButton[] {jRadioButton25,jRadioButton26,jRadioButton27,jRadioButton28},
            new JRadioButton[] {jRadioButton29,jRadioButton30,jRadioButton31,jRadioButton32},
        };
        
        for(int n=0;n<radioSets.length;n++){
            if(radioSets[n][0].isSelected()){   //Open
                //Override and Set to submitted if user is an ADVISER_USER and Column has a value
                String gradeValue = enrolledStudentsTable1.getValueAt(row, n).toString().trim();
                if(checkForSubmittedGrades && 
                    myVariables.getAccessLevel() == 1 &&
                    gradeValue.length() > 0 &&
                    !gradeValue.contains("--") && Integer.parseInt(gradeValue) > 0){
                    
                    status[n] = "Submitted";
                }else{
                    status[n] = "Open";
                }continue;
            }if(radioSets[n][1].isSelected()){  //Submitted
                status[n] = "Submitted";continue;
            }if(radioSets[n][2].isSelected()){  //Approved
                status[n] = "Approved";continue;
            }if(radioSets[n][3].isSelected()){  //Closed
                status[n] = "Closed";
            }
        }
        
        String finalStatus = status[0]+":"+status[1]+":"+status[2]+":"+status[3]+":"+previousStatuses[4]+":";
        return finalStatus;
    }
    private String retrieveStatuses(){
        String status [] = new String[4];
        JTextField [] textFields = {tfEditFirstQuarter,tfEditSecondQuarter,tfEditThirdQuarter,tfEditFourthQuarter};
        JRadioButton [][] radioSets = {
            new JRadioButton[] {jRadioButton1,jRadioButton2,jRadioButton3,jRadioButton4},
            new JRadioButton[] {jRadioButton5,jRadioButton6,jRadioButton7,jRadioButton8},
            new JRadioButton[] {jRadioButton9,jRadioButton10,jRadioButton11,jRadioButton12},
            new JRadioButton[] {jRadioButton13,jRadioButton14,jRadioButton15,jRadioButton16},
        };
        for(int n=0;n<radioSets.length;n++){
            if(radioSets[n][0].isSelected()){   //Open
                //Override and Set to submitted if user is an ADVISER_USER and Textfield has a value
                if(myVariables.getAccessLevel() == 1 && textFields[n].getText().trim().length() > 0){
                    status[n] = "Submitted";
                }else{
                    status[n] = "Open";
                }continue;
            }if(radioSets[n][1].isSelected()){  //Submitted
                status[n] = "Submitted";continue;
            }if(radioSets[n][2].isSelected()){  //Approved
                status[n] = "Approved";continue;
            }if(radioSets[n][3].isSelected()){  //Closed
                status[n] = "Closed";
            }
        }
        String finalStatus = status[0]+":"+status[1]+":"+status[2]+":"+status[3]+":"+tfEvaluation.getText()+":";
        System.err.println(finalStatus);
        
        return finalStatus;
    }
    private void hideElementsByAccessLevel(){
        if(myVariables.getAccessLevel() != 2 && myVariables.getAccessLevel() != 5){
            btnMyManagedSubjects.setVisible(false);
        }
    }
    private void refreshAssignedSubjects(boolean notifyIfEmpty){
        if(myVariables.getAccessLevel() != 2 && myVariables.getAccessLevel() != 5){
            System.err.println("Not a Department Head or Admin. Skipping");
            return;
        }
        String userId = String.valueOf(myVariables.getUserLoggedInId());
        
        String [] result = my.return_values("*", "userDetails", "WHERE userId='"+userId+"'", myVariables.getUsersPersonalInfoOrder());
        
        if(result != null){
            String assignedSubjects = "";
            assignedSubjects = my.getValueAtColumn(result[0], 9);
            if(assignedSubjects.contains("NONE")){
                 if(notifyIfEmpty){
                    my.showMessage("You have no subjects assigned to you. Try refreshing again.\nIf the problem persists, please consult your Curruculum Head if you think this is an error.", JOptionPane.WARNING_MESSAGE);
                }
                return;
            }
            
            assignedSubjects = assignedSubjects.replace(":", ",");
            int length = assignedSubjects.length();
            
            if(assignedSubjects.charAt(length-1) == ','){
                assignedSubjects = assignedSubjects.substring(0, length-1);
            }
            
            String [] subjects = my.return_values("*", "subjects", "WHERE id IN ("+assignedSubjects+")", myVariables.getSubjectOrder());
            
            if(subjects != null){
                my.clear_table_rows(assignedSubjectsTable);
                for(String n : subjects){
                    my.add_table_row(n, assignedSubjectsTable);
                }
            }else{
                if(notifyIfEmpty){
                    my.showMessage("You have no subjects assigned to you. Try refreshing again.\nIf the problem persists, please consult your Curruculum Head if you think this is an error.", JOptionPane.WARNING_MESSAGE);
                }
            }
        }else{
            if(notifyIfEmpty){
                my.showMessage("You have no subjects assigned to you. Try refreshing again.\nIf the problem persists, please consult your Curruculum Head if you think this is an error.", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    private void loadStudentsAndGrades(){
        int row = assignedTeacherTable.getSelectedRow();
        
        if(row == -1){
            my.showMessage("No Section Selected.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String sectionId = assignedTeacherTable.getValueAt(row, 1).toString();
        String adviserId = assignedTeacherTable.getValueAt(row, 3).toString();
        String subjectId = assignedTeacherTable.getValueAt(row, 6).toString();
        
        loadStatusRadioBtns(null);
        
        my.runMainThread(
            0,
            new JTable[]{enrolledStudentsTable1},
            new String[]{sectionId,adviserId,subjectId},
            null,
            new JButton[]{btnRefreshStudents},
            null,
            null
        );
        
        enableDisableGlobalBtnsByUserType();
        btnSaveChangesCurrent.setEnabled(false);
        btnSaveChangesAll.setEnabled(true);
    }
    private void enableDisableGlobalBtnsByUserType(){
        JButton adviserBtns [] = {btnAdvSelected, btnAdvAll};
        JButton depHeadBtns [] = {btnDphSelected, btnDphAll};
        JButton registrarBtns [] = {btnRgrSelected, btnRgrAll};
        
        boolean advisers,depHeads,registrar;
        
        advisers = myVariables.getAccessLevel() == 1 || myVariables.getAccessLevel() >= 4 ? true : false;
        depHeads = myVariables.getAccessLevel() == 2 || myVariables.getAccessLevel() == 5? true : false;
        registrar = myVariables.getAccessLevel() >= 4 ? true : false;
        
        for(int n=0;n<2;n++){
            adviserBtns[n].setEnabled(advisers);
            depHeadBtns[n].setEnabled(depHeads);
            registrarBtns[n].setEnabled(registrar);
        }
    }
    private void enableDisableRadioBtnsByUserType(){
        //System.err.println("Enabling Radio Btns "+ myVariables.getAccessLevel());
        JRadioButton [][] radioSets = {
            new JRadioButton[] {jRadioButton17,jRadioButton18,jRadioButton19,jRadioButton20},
            new JRadioButton[] {jRadioButton21,jRadioButton22,jRadioButton23,jRadioButton24},
            new JRadioButton[] {jRadioButton25,jRadioButton26,jRadioButton27,jRadioButton28},
            new JRadioButton[] {jRadioButton29,jRadioButton30,jRadioButton31,jRadioButton32},
        };
        
        for(int n=0;n<radioSets.length;n++){
            switch(myVariables.getAccessLevel()){
                case 1:{
                    radioSets[n][0].setEnabled(false);
                    radioSets[n][1].setEnabled(false);
                    radioSets[n][2].setEnabled(false);
                    radioSets[n][3].setEnabled(false);
                    break;
                }case 2:{
                    radioSets[n][0].setEnabled(false);
                    radioSets[n][1].setEnabled(true);
                    radioSets[n][2].setEnabled(true);
                    radioSets[n][3].setEnabled(false);
                    break;
                }case 3:{
                    radioSets[n][0].setEnabled(true);
                    radioSets[n][1].setEnabled(true);
                    radioSets[n][2].setEnabled(true);
                    radioSets[n][3].setEnabled(true);
                    break;
                }case 4:{
                    radioSets[n][0].setEnabled(true);
                    radioSets[n][1].setEnabled(false);
                    radioSets[n][2].setEnabled(true);
                    radioSets[n][3].setEnabled(true);
                    break;
                }case 5:{
                    radioSets[n][0].setEnabled(true);
                    radioSets[n][1].setEnabled(true);
                    radioSets[n][2].setEnabled(true);
                    radioSets[n][3].setEnabled(true);
                    break;
                }
            }
        }
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
            jScrollPane2,jScrollPane3,
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
            my.hideColumns(enrolledStudentsTable1, new int [] {0,1,5,6}); // 12 is status column
            my.hideColumns(assignedSubjectsTable, new int [] {0});
        }
        
        //Set table fonts
        JTable tables [] = {
            assignedTeacherTable,
            enrolledStudentsTable,
            enrolledStudentsTable1,
            assignedSubjectsTable,
            
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
        mainTab.add("View Students",viewStudentsTab2);
        
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
            btnEditGrades,
            btnSearchEnrolledStudent,
            btnSaveChangesCurrent,
            btnSaveChangesAll,
            //Select Quarter
            btnSelectQuarter,
            //Approval
            btnAdvSelected,btnAdvAll,
            btnDphSelected,btnDphAll,
            btnRgrSelected,btnRgrAll,
            //Edit Grades Dialog
            btnSaveGradeChanges,
            //My Assigned Subjects Dialog
            btnRefresh,
        };
        
        JButton lightButtons [] = {
            btnMyManagedSubjects,btnRefreshStudents,
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
            jLabel35,jLabel36,jLabel37,jLabel38,jLabel39,
        };
        JLabel labels [] = {
            lbSearchResult,lbSearchResult1,lbMessage,
        };
        
        JLabel formsHeaderLabels [] = {
            jLabel2,jLabel3,jLabel12,jLabel13,jLabel14,
            jLabel18,jLabel23,lbQuarterSelect,
        };
        JLabel textFieldHeaderLabels [] = {
            lbDateUpdated,lbGradeStatus,jLabel5,jLabel6,jLabel7,jLabel8,jLabel9,lbSubjectName,
            jLabel1,jLabel4,jLabel10,jLabel11,jLabel15,lbRecordId,jLabel16,lbStatusOptions,jLabel17,
            jLabel19,lbSectionName2,jLabel21,lbSubjectName2,
            lbStatusOptions1,lbStatusOptions2,lbStatusOptions3,lbStatusOptions4,
            jLabel24,jLabel25,jLabel26,
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
            //jdcDate,jdcCustomDate,
        };
        JSpinner spinners [] = {
            //jsHours,jsMinutes
        };
        
        JTextField searchFields [] = {
            tfSearchTeacherLoad,tfSearchEnrolledStudent,
        };
        JTextField forms [] = {
            tfFirstQ,tfSecondQ,tfThirdQ,tfFourthQ,tfGeneralWeighedAverage,
            //Edit Grades Dialog
            tfEditFirstQuarter,tfEditSecondQuarter,tfEditThirdQuarter,tfEditFourthQuarter,
            tfEditGwa,tfEvaluation,
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
            //jcbMeridan,
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable assignedSubjectsTable;
    private javax.swing.JTable assignedTeacherTable;
    private javax.swing.JButton btnAdvAll;
    private javax.swing.JButton btnAdvSelected;
    private javax.swing.JButton btnDphAll;
    private javax.swing.JButton btnDphSelected;
    private javax.swing.JButton btnEditGrades;
    private javax.swing.JButton btnMyManagedSubjects;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRefreshStudents;
    private javax.swing.JButton btnRgrAll;
    private javax.swing.JButton btnRgrSelected;
    private javax.swing.JButton btnSaveChangesAll;
    private javax.swing.JButton btnSaveChangesCurrent;
    private javax.swing.JButton btnSaveGradeChanges;
    private javax.swing.JButton btnSearchEnrolledStudent;
    private javax.swing.JButton btnSearchSection;
    private javax.swing.JButton btnSelectQuarter;
    private javax.swing.JCheckBox cbAllowDecimalValues;
    private javax.swing.ButtonGroup computationOptionGroup;
    private javax.swing.JPanel contentsPanel;
    private javax.swing.JPanel editGradeDialog;
    private javax.swing.JTable enrolledStudentsTable;
    private javax.swing.JTable enrolledStudentsTable1;
    private javax.swing.JPanel headerPanel;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton13;
    private javax.swing.JRadioButton jRadioButton14;
    private javax.swing.JRadioButton jRadioButton15;
    private javax.swing.JRadioButton jRadioButton16;
    private javax.swing.JRadioButton jRadioButton17;
    private javax.swing.JRadioButton jRadioButton18;
    private javax.swing.JRadioButton jRadioButton19;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton20;
    private javax.swing.JRadioButton jRadioButton21;
    private javax.swing.JRadioButton jRadioButton22;
    private javax.swing.JRadioButton jRadioButton23;
    private javax.swing.JRadioButton jRadioButton24;
    private javax.swing.JRadioButton jRadioButton25;
    private javax.swing.JRadioButton jRadioButton26;
    private javax.swing.JRadioButton jRadioButton27;
    private javax.swing.JRadioButton jRadioButton28;
    private javax.swing.JRadioButton jRadioButton29;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton30;
    private javax.swing.JRadioButton jRadioButton31;
    private javax.swing.JRadioButton jRadioButton32;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> jcbSchoolYear1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lbDateUpdated;
    private javax.swing.JLabel lbGradeStatus;
    private javax.swing.JLabel lbLoggedInUser;
    private javax.swing.JLabel lbMessage;
    private javax.swing.JLabel lbQuarterSelect;
    private javax.swing.JLabel lbRecordId;
    private javax.swing.JLabel lbSchoolAddress;
    private javax.swing.JLabel lbSchoolName;
    private javax.swing.JLabel lbSearchResult;
    private javax.swing.JLabel lbSearchResult1;
    private javax.swing.JLabel lbSectionName2;
    private javax.swing.JLabel lbStatusOptions;
    private javax.swing.JLabel lbStatusOptions1;
    private javax.swing.JLabel lbStatusOptions2;
    private javax.swing.JLabel lbStatusOptions3;
    private javax.swing.JLabel lbStatusOptions4;
    private javax.swing.JLabel lbSubjectName;
    private javax.swing.JLabel lbSubjectName2;
    private javax.swing.JPanel left;
    private javax.swing.JPanel left2;
    private javax.swing.JTabbedPane mainTab;
    private javax.swing.JPanel myAssignedSubjectsDialog;
    private javax.swing.JProgressBar pbProgressBar;
    private javax.swing.ButtonGroup q1StatusGroup;
    private javax.swing.ButtonGroup q2StatusGroup;
    private javax.swing.ButtonGroup q3tatusGroup;
    private javax.swing.ButtonGroup q4StatusGroup;
    private javax.swing.JRadioButton rbAutomatic;
    private javax.swing.JRadioButton rbManual;
    private javax.swing.JRadioButton rbQuarter1;
    private javax.swing.JRadioButton rbQuarter2;
    private javax.swing.JRadioButton rbQuarter3;
    private javax.swing.JRadioButton rbQuarter4;
    private javax.swing.JPanel right;
    private javax.swing.JPanel right2;
    private javax.swing.JPanel selectQuarterDialog;
    private javax.swing.ButtonGroup selectQuarterGroup;
    private javax.swing.JPanel selectSectionTab;
    private javax.swing.JTextField tfEditFirstQuarter;
    private javax.swing.JTextField tfEditFourthQuarter;
    private javax.swing.JTextField tfEditGwa;
    private javax.swing.JTextField tfEditSecondQuarter;
    private javax.swing.JTextField tfEditThirdQuarter;
    private javax.swing.JTextField tfEvaluation;
    private javax.swing.JTextField tfFirstQ;
    private javax.swing.JTextField tfFourthQ;
    private javax.swing.JTextField tfGeneralWeighedAverage;
    private javax.swing.JTextField tfSearchEnrolledStudent;
    private javax.swing.JTextField tfSearchTeacherLoad;
    private javax.swing.JTextField tfSecondQ;
    private javax.swing.JTextField tfThirdQ;
    private javax.swing.JPanel viewStudentsTab;
    private javax.swing.JPanel viewStudentsTab2;
    // End of variables declaration//GEN-END:variables

}

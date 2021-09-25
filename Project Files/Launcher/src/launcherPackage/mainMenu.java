package launcherPackage;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Phil Rey Paderogao
 */
public class mainMenu extends javax.swing.JFrame {
    myFunctions my;
    /**
     * Creates new form mainMenu
     */
    public mainMenu() {
        my = new myFunctions();
        initComponents();
        
        reloadSettingFields();
        
        loadLabels();
        loadTextFields();
        loadColoredButtons();
        loadTabIcons();
        setScrollSpeeds();
    }
    private void reloadSettingFields(){
        lbSchoolName.setText(myVariables.getSchoolName());
        lbSchoolAddress.setText(myVariables.getSchoolAddress());
        
        tfSchoolName.setText(myVariables.getSchoolName());
        tfSchoolAddress.setText(myVariables.getSchoolAddress());
        tfSchoolId.setText(myVariables.getSchoolId());
        
        tfDistrict.setText(myVariables.getDistrict());
        tfDivision.setText(myVariables.getDivision());
        tfRegion.setText(myVariables.getRegion());
        
        tfSchoolHead.setText(myVariables.getPrincipal());
        tfDivisionRepresentative.setText(myVariables.getDivisionRepresentative());
        tfDivisionSuperintendent.setText(myVariables.getDivisionSuperintendent());
        
        try {
            jcbLoadingSpeed.setSelectedIndex(myVariables.getLoadingSpeed());
        } catch (Exception e) {
            jcbLoadingSpeed.setSelectedIndex(0);
        }
        
        tfIpAddress.setText(myVariables.getIpAddressOnly());
    }
    
    private void loadTextFields(){
        JTextField searchFields [] = {
            
        };
        JTextField forms [] = {
            tfSchoolName,
            tfSchoolAddress,
            tfSchoolId,
            
            tfDistrict,
            tfDivision,
            tfRegion,
            
            tfSchoolHead,
            tfDivisionRepresentative,
            tfDivisionSuperintendent,
            
            tfIpAddress,
        };
        
        for(JTextField n : searchFields){
            n.setFont(myVariables.SEARCH_TEXTFIELD_FONT);
        }
        for(JTextField n : forms){
            n.setFont(myVariables.TEXTFIELD_FONT);
        }
    }
    private void setScrollSpeeds(){
        JScrollPane scrollpanes [] = {
            jScrollPane2,
            jScrollPane1,
            jScrollPane4,
        };
        
        int scrollSpeed = 15;
        
        for(int n=0;n<scrollpanes.length;n++){
            scrollpanes[n].getVerticalScrollBar().setUnitIncrement(scrollSpeed);
            scrollpanes[n].getHorizontalScrollBar().setUnitIncrement(scrollSpeed);
        }
    }
    private void loadTabIcons(){
        Icon tabIcons [] = {
            my.getImgIcn(myVariables.getHomeIcon()),
            my.getImgIcn(myVariables.getSettingsIcon()),
            my.getImgIcn(myVariables.getAboutIcon()),
        };
        
        for(int n=0;n<tabIcons.length;n++){
            mainTab.setIconAt(n,tabIcons[n]);
        }
        
        mainTab.setFont(myVariables.TAB_HEADER_FONT);
    }
    private void loadLabels(){
        JLabel titleHeaderLabels [] = {
            jLabel36,jLabel37,jLabel38,jLabel40,
        };
        JLabel labels [] = {
            
        };
        
        JLabel formsHeaderLabels [] = {
            jLabel1,jLabel5,jLabel9,
        };
        JLabel textFieldHeaderLabels [] = {
            jLabel2,jLabel3,jLabel4,jLabel6,jLabel7,jLabel8,jLabel10,jLabel11,jLabel12,
            jLabel13,jLabel14,
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
    private void loadColoredButtons(){
        JButton buttons [] = {
            btnSaveSettings,
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
            lightButtons[n].setBackground(new Color(214, 255, 183));
            lightButtons[n].setForeground(new Color(22,66,33));            
            lightButtons[n].setFont(new Font("Comic Sans MS",Font.BOLD,12));
            //buttons[n].setCursor(my.getCursor(myVariables.getHandCursor()));
            lightButtons[n].setCursor(new Cursor(Cursor.HAND_CURSOR));
            lightButtons[n].setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel2 = new keeptoo.KGradientPanel();
        headerPanel = new javax.swing.JPanel();
        lbSchoolName = new javax.swing.JLabel();
        lbSchoolAddress = new javax.swing.JLabel();
        mainTab = new javax.swing.JTabbedPane();
        jSplitPane2 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        btnEnrollment = new javax.swing.JLabel();
        btnRegistration = new javax.swing.JLabel();
        btnAttendance = new javax.swing.JLabel();
        btnWeighing = new javax.swing.JLabel();
        btnBookKeepimg = new javax.swing.JLabel();
        btnGrading = new javax.swing.JLabel();
        btnForms = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtaModuleInformation = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfSchoolName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfSchoolAddress = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfSchoolId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfDistrict = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfDivision = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfRegion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfSchoolHead = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tfDivisionRepresentative = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tfDivisionSuperintendent = new javax.swing.JTextField();
        jcbLoadingSpeed = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        btnSaveSettings = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        tfIpAddress = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HiSRMS v2.0");
        setIconImage(my.getImgIcn(myVariables.getLauncherIcon()).getImage()
        );
        setResizable(false);

        kGradientPanel2.setkEndColor(new java.awt.Color(255, 255, 204));
        kGradientPanel2.setkStartColor(new java.awt.Color(255, 255, 204));

        headerPanel.setBackground(new java.awt.Color(22, 66, 33));

        lbSchoolName.setBackground(new java.awt.Color(255, 255, 255));
        lbSchoolName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbSchoolName.setForeground(new java.awt.Color(255, 255, 255));
        lbSchoolName.setText("SCHOOL_NAME Launcher");

        lbSchoolAddress.setBackground(new java.awt.Color(255, 255, 255));
        lbSchoolAddress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbSchoolAddress.setForeground(new java.awt.Color(255, 255, 255));
        lbSchoolAddress.setText("SCHOOL_ADDRESS");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSchoolName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbSchoolAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbSchoolName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSchoolAddress)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        mainTab.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        mainTab.setToolTipText("");
        mainTab.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        mainTab.setMinimumSize(new java.awt.Dimension(100, 100));
        mainTab.setPreferredSize(new java.awt.Dimension(1068, 548));

        jSplitPane2.setBorder(null);
        jSplitPane2.setDividerLocation(475);
        jSplitPane2.setResizeWeight(1.0);

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 245, 135));
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 204));
        kGradientPanel1.setkTransparentControls(false);

        btnEnrollment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/launcherPackage/buttons/Enrollment.png"))); // NOI18N
        btnEnrollment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEnrollment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnrollmentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEnrollmentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEnrollmentMouseExited(evt);
            }
        });

        btnRegistration.setIcon(new javax.swing.ImageIcon(getClass().getResource("/launcherPackage/buttons/Registration.png"))); // NOI18N
        btnRegistration.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistration.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrationMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegistrationMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistrationMouseExited(evt);
            }
        });

        btnAttendance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/launcherPackage/buttons/Attendance.png"))); // NOI18N
        btnAttendance.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAttendance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAttendanceMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAttendanceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAttendanceMouseExited(evt);
            }
        });

        btnWeighing.setIcon(new javax.swing.ImageIcon(getClass().getResource("/launcherPackage/buttons/Weighing_.png"))); // NOI18N
        btnWeighing.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnWeighing.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnWeighingMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnWeighingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnWeighingMouseExited(evt);
            }
        });

        btnBookKeepimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/launcherPackage/buttons/Book Keeping.png"))); // NOI18N
        btnBookKeepimg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBookKeepimg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBookKeepimgMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBookKeepimgMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBookKeepimgMouseExited(evt);
            }
        });

        btnGrading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/launcherPackage/buttons/Grading.png"))); // NOI18N
        btnGrading.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGrading.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGradingMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGradingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGradingMouseExited(evt);
            }
        });

        btnForms.setIcon(new javax.swing.ImageIcon(getClass().getResource("/launcherPackage/buttons/Forms.png"))); // NOI18N
        btnForms.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnForms.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFormsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFormsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFormsMouseExited(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(22, 66, 33));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Select Module");

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

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnForms, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(btnWeighing)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBookKeepimg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGrading))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(btnRegistration)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEnrollment)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAttendance))))
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAttendance)
                    .addComponent(btnRegistration)
                    .addComponent(btnEnrollment))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnWeighing)
                    .addComponent(btnBookKeepimg)
                    .addComponent(btnGrading))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnForms)
                .addGap(0, 31, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(kGradientPanel1);

        jSplitPane2.setLeftComponent(jScrollPane2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jPanel9.setBackground(new java.awt.Color(22, 66, 33));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("System Details");

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

        jtaModuleInformation.setEditable(false);
        jtaModuleInformation.setColumns(20);
        jtaModuleInformation.setFont(myVariables.TEXTFIELD_FONT);
        jtaModuleInformation.setLineWrap(true);
        jtaModuleInformation.setRows(5);
        jtaModuleInformation.setText("Select a System for more info.\n");
        jtaModuleInformation.setWrapStyleWord(true);
        jScrollPane3.setViewportView(jtaModuleInformation);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane2.setRightComponent(jPanel1);

        mainTab.addTab("Home", jSplitPane2);

        kGradientPanel3.setkEndColor(new java.awt.Color(255, 245, 135));
        kGradientPanel3.setkStartColor(new java.awt.Color(255, 255, 204));

        jPanel10.setBackground(new java.awt.Color(22, 66, 33));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("General");

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

        jPanel12.setBackground(new java.awt.Color(22, 66, 33));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Performance");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40)
                .addContainerGap(291, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("School Details");

        jLabel2.setText("School Name");

        jLabel3.setText("Address");

        jLabel4.setText("School ID");

        tfSchoolId.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Department Details");

        jLabel6.setText("District");

        jLabel7.setText("Division");

        jLabel8.setText("Region");

        tfRegion.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Personnel Details");

        jLabel10.setText("School Head");

        jLabel11.setText("Division Representative");

        jLabel12.setText("Division Superintendent");

        jcbLoadingSpeed.setFont(myVariables.TEXTFIELD_FONT);
        jcbLoadingSpeed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal (Default)", "Fast", "Very Fast " }));

        jLabel13.setText("Loading Speed");

        btnSaveSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/launcherPackage/icons/icons8_save_16px.png"))); // NOI18N
        btnSaveSettings.setText("Save Changes");
        btnSaveSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveSettingsActionPerformed(evt);
            }
        });

        jLabel14.setText("IP Address");

        tfIpAddress.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(340, Short.MAX_VALUE))
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfSchoolAddress)
                            .addComponent(tfSchoolId, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDivision, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfSchoolHead, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDivisionRepresentative, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDivisionSuperintendent, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfSchoolName)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbLoadingSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSaveSettings, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfIpAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSchoolName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSchoolAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSchoolId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDivision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSchoolHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDivisionRepresentative, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDivisionSuperintendent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfIpAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbLoadingSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSaveSettings)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(kGradientPanel3);

        mainTab.addTab("Settings", jScrollPane1);

        kGradientPanel4.setkEndColor(new java.awt.Color(255, 245, 135));
        kGradientPanel4.setkStartColor(new java.awt.Color(255, 255, 204));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/launcherPackage/icons/About Tab.png"))); // NOI18N

        javax.swing.GroupLayout kGradientPanel4Layout = new javax.swing.GroupLayout(kGradientPanel4);
        kGradientPanel4.setLayout(kGradientPanel4Layout);
        kGradientPanel4Layout.setHorizontalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        kGradientPanel4Layout.setVerticalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
        );

        jScrollPane4.setViewportView(kGradientPanel4);

        mainTab.addTab("About", jScrollPane4);

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainTab, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrationMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrationMouseEntered
        btnRegistration.setIcon(my.getImgIcn(myVariables.getRegistrationActBtnIcon()));
        selectModuleInfo(1);
    }//GEN-LAST:event_btnRegistrationMouseEntered

    private void btnRegistrationMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrationMouseExited
        btnRegistration.setIcon(my.getImgIcn(myVariables.getRegistrationBtnIcon()));
        selectModuleInfo(0);
    }//GEN-LAST:event_btnRegistrationMouseExited

    private void btnEnrollmentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnrollmentMouseEntered
        btnEnrollment.setIcon(my.getImgIcn(myVariables.getEnrollmentActBtnIcon()));
        selectModuleInfo(2);
    }//GEN-LAST:event_btnEnrollmentMouseEntered

    private void btnEnrollmentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnrollmentMouseExited
        btnEnrollment.setIcon(my.getImgIcn(myVariables.getEnrollmentBtnIcon()));
        selectModuleInfo(0);
    }//GEN-LAST:event_btnEnrollmentMouseExited

    private void btnAttendanceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAttendanceMouseEntered
        btnAttendance.setIcon(my.getImgIcn(myVariables.getAttendanceActBtnIcon()));
        selectModuleInfo(3);
    }//GEN-LAST:event_btnAttendanceMouseEntered

    private void btnAttendanceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAttendanceMouseExited
        btnAttendance.setIcon(my.getImgIcn(myVariables.getAttendanceBtnIcon()));
        selectModuleInfo(0);
    }//GEN-LAST:event_btnAttendanceMouseExited

    private void btnWeighingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnWeighingMouseEntered
        btnWeighing.setIcon(my.getImgIcn(myVariables.getWeighingActBtnIcon()));
        selectModuleInfo(4);
    }//GEN-LAST:event_btnWeighingMouseEntered

    private void btnWeighingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnWeighingMouseExited
        btnWeighing.setIcon(my.getImgIcn(myVariables.getWeighingBtnIcon()));
        selectModuleInfo(0);
    }//GEN-LAST:event_btnWeighingMouseExited

    private void btnBookKeepimgMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBookKeepimgMouseEntered
        btnBookKeepimg.setIcon(my.getImgIcn(myVariables.getBookKeepActBtnIcon()));
        selectModuleInfo(5);
    }//GEN-LAST:event_btnBookKeepimgMouseEntered

    private void btnBookKeepimgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBookKeepimgMouseExited
        btnBookKeepimg.setIcon(my.getImgIcn(myVariables.getBookKeepBtnIcon()));
        selectModuleInfo(0);
    }//GEN-LAST:event_btnBookKeepimgMouseExited

    private void btnGradingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGradingMouseEntered
        btnGrading.setIcon(my.getImgIcn(myVariables.getGradingActBtnIcon()));
        selectModuleInfo(6);
    }//GEN-LAST:event_btnGradingMouseEntered

    private void btnGradingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGradingMouseExited
        btnGrading.setIcon(my.getImgIcn(myVariables.getGradingBtnIcon()));
        selectModuleInfo(0);
    }//GEN-LAST:event_btnGradingMouseExited

    private void btnFormsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormsMouseEntered
        btnForms.setIcon(my.getImgIcn(myVariables.getFormsActBtnIcon()));
        selectModuleInfo(7);
    }//GEN-LAST:event_btnFormsMouseEntered

    private void btnFormsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormsMouseExited
        btnForms.setIcon(my.getImgIcn(myVariables.getFormsBtnIcon()));
        selectModuleInfo(0);
    }//GEN-LAST:event_btnFormsMouseExited

    private void btnBookKeepimgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBookKeepimgMouseClicked
        runModule(5,true);
    }//GEN-LAST:event_btnBookKeepimgMouseClicked

    private void btnSaveSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveSettingsActionPerformed
        String schoolName = tfSchoolName.getText().trim();
        String schoolAddress = tfSchoolAddress.getText().trim();
        String schoolId = tfSchoolId.getText().trim();
        
        String district = tfDistrict.getText().trim();
        String division = tfDivision.getText().trim();
        String region = tfRegion.getText().trim();
        
        String schoolHead = tfSchoolHead.getText().trim();
        String representative = tfDivisionRepresentative.getText().trim();
        String superintendent = tfDivisionSuperintendent.getText().trim();
        
        String ipAddress = tfIpAddress.getText().trim();
        int speed = jcbLoadingSpeed.getSelectedIndex();
        
        myVariables.setSchoolName(schoolName.length()>0? schoolName:" ");
        myVariables.setSchoolAddress(schoolAddress.length()>0? schoolAddress:" ");
        myVariables.setSchoolId(schoolId.length()>0? schoolId:" ");
        
        myVariables.setDistrict(district.length()>0? district:" ");
        myVariables.setDivision(division.length()>0? division:" ");
        myVariables.setRegion(region.length()>0? region:" ");
        
        myVariables.setPrincipal(schoolHead.length()>0? schoolHead:" ");
        myVariables.setDivisionRepresentative(representative.length()>0? representative:" ");
        myVariables.setDivisionSuperintendent(superintendent.length()>0? superintendent:" ");
        
        myVariables.setIpAddressOnly(ipAddress.length()>0? ipAddress:" ");
        myVariables.setLoadingSpeed(speed);
        if (my.writeSettings()) {
            my.showMessage("Settings Saved.", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveSettingsActionPerformed

    private void btnRegistrationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrationMouseClicked
        runModule(1, true);
    }//GEN-LAST:event_btnRegistrationMouseClicked

    private void btnEnrollmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnrollmentMouseClicked
        runModule(2, true);
    }//GEN-LAST:event_btnEnrollmentMouseClicked

    private void btnAttendanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAttendanceMouseClicked
        runModule(3, true);
    }//GEN-LAST:event_btnAttendanceMouseClicked

    private void btnWeighingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnWeighingMouseClicked
        runModule(4, true);
    }//GEN-LAST:event_btnWeighingMouseClicked

    private void btnGradingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGradingMouseClicked
        runModule(6, true);
    }//GEN-LAST:event_btnGradingMouseClicked

    private void btnFormsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormsMouseClicked
        runModule(7, true);
    }//GEN-LAST:event_btnFormsMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Windows look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Windows (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainMenu().setVisible(true);
            }
        });
    }
    //<editor-fold desc="Custom Functions">
    private static final String moduleInformation [] = {
        "Select a System for more info.",
        "Registration System\n\nUsed for registering new students and monitoring their main information",
        "Enrollment System\n\nManages sections and Enrollment of Students.",
        "Attendance System\n\nManages Student daily and monthly Attendances.",
        "Weighing System\n\nUsed for monitoring Students' BMI and other health measurements.",
        "Book Keeping System\n\nUsed for recording distributed & returned books by students throughout the School Year.",
        "Grading System\n\nRecords the quarterly grades of students.",
        "Forms System\n\nCompiles all the data recorded by the other Systems and exports them as School Documents."
    };
    
    private void selectModuleInfo(int index){
        jtaModuleInformation.setText(moduleInformation[index]);
    }
    private void runModule(int index,boolean minimizeOpened){
        boolean opened = false;
        switch(index){
            case 1:{
                opened = my.runExeFile("modules/registration.exe",false);
                break;
            }case 2:{
                opened = my.runExeFile("modules/enrollment.exe",false);
                break;
            }case 3:{
                opened = my.runExeFile("modules/attendance.exe",false);
                break;
            }case 4:{
                opened = my.runExeFile("modules/weighing.exe",false);
                break;
            }case 5:{
                opened = my.runExeFile("modules/bookKeeping.exe",false);
                break;
            }case 6:{
                opened = my.runExeFile("modules/grading.exe",false);
                break;
            }case 7:{
                opened = my.runExeFile("modules/forms.exe",false);
                break;
            }
        }
        if(minimizeOpened){
            if(opened){
                this.setState(JFrame.ICONIFIED);
            }else{
                this.setState(JFrame.NORMAL);
            }
        }
    }
    //</editor-fold>
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAttendance;
    private javax.swing.JLabel btnBookKeepimg;
    private javax.swing.JLabel btnEnrollment;
    private javax.swing.JLabel btnForms;
    private javax.swing.JLabel btnGrading;
    private javax.swing.JLabel btnRegistration;
    private javax.swing.JButton btnSaveSettings;
    private javax.swing.JLabel btnWeighing;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JComboBox<String> jcbLoadingSpeed;
    private javax.swing.JTextArea jtaModuleInformation;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel3;
    private keeptoo.KGradientPanel kGradientPanel4;
    private javax.swing.JLabel lbSchoolAddress;
    private javax.swing.JLabel lbSchoolName;
    private javax.swing.JTabbedPane mainTab;
    private javax.swing.JTextField tfDistrict;
    private javax.swing.JTextField tfDivision;
    private javax.swing.JTextField tfDivisionRepresentative;
    private javax.swing.JTextField tfDivisionSuperintendent;
    private javax.swing.JTextField tfIpAddress;
    private javax.swing.JTextField tfRegion;
    private javax.swing.JTextField tfSchoolAddress;
    private javax.swing.JTextField tfSchoolHead;
    private javax.swing.JTextField tfSchoolId;
    private javax.swing.JTextField tfSchoolName;
    // End of variables declaration//GEN-END:variables
}

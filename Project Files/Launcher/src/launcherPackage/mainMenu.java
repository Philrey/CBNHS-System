package launcherPackage;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

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
        
        lbSchoolName.setText(myVariables.getSchoolName());
        lbSchoolAddress.setText(myVariables.getSchoolAddress());
        
        loadLabels();
        loadTabIcons();
        setScrollSpeeds();
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
            jLabel36,jLabel37,
        };
        JLabel labels [] = {
        };
        
        JLabel formsHeaderLabels [] = {
        };
        JLabel textFieldHeaderLabels [] = {
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
        jScrollPane4 = new javax.swing.JScrollPane();

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

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 245, 135));
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 204));
        kGradientPanel1.setkTransparentControls(false);

        btnEnrollment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/launcherPackage/buttons/Enrollment.png"))); // NOI18N
        btnEnrollment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEnrollment.addMouseListener(new java.awt.event.MouseAdapter() {
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
        mainTab.addTab("Settings", jScrollPane1);
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
        runModule(5);
    }//GEN-LAST:event_btnBookKeepimgMouseClicked

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
        "Registration",
        "Enrollment",
        "Attendance",
        "Weighing",
        "Book Keeping",
        "Grading",
        "Forms"
    };
    
    private void selectModuleInfo(int index){
        jtaModuleInformation.setText(moduleInformation[index]);
    }
    private void runModule(int index){
        switch(index){
            case 1:{
                break;
            }case 2:{
                break;
            }case 3:{
                break;
            }case 4:{
                break;
            }case 5:{
                my.runExeFile("modules/BorrowSystem.exe", true);
                break;
            }case 6:{
                break;
            }case 7:{
                break;
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
    private javax.swing.JLabel btnWeighing;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTextArea jtaModuleInformation;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JLabel lbSchoolAddress;
    private javax.swing.JLabel lbSchoolName;
    private javax.swing.JTabbedPane mainTab;
    // End of variables declaration//GEN-END:variables
}

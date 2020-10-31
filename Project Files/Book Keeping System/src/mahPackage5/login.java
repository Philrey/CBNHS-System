/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackage5;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Phil Rey Paderogao
 */
public class login extends javax.swing.JFrame {
    myFunctions my;
    
    public login() {
        my = new myFunctions();
        initComponents();
        
        loadColoredButtons();
    }
    private void loadColoredButtons(){
        JButton buttons [] = {
            btnLogin,
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

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome to Book Keeping System");
        setIconImage(my.getImgIcn(myVariables.getBookKeepingWindowIcon()).getImage()
        );
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setOpaque(false);

        jTextField1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(51, 51, 51));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("admin");
        jTextField1.setToolTipText("");
        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "User Name", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 14), new java.awt.Color(0, 102, 0))); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1loginHandler(evt);
            }
        });

        jPasswordField1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(51, 51, 51));
        jPasswordField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordField1.setText("password");
        jPasswordField1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Password", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 14), new java.awt.Color(0, 102, 0))); // NOI18N
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1loginHandler(evt);
            }
        });

        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_login_16px.png"))); // NOI18N
        btnLogin.setText("Login");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginloginHandler(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(22, 66, 33));
        jCheckBox1.setText("Remember Me");
        jCheckBox1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_unchecked_checkbox_20px.png"))); // NOI18N
        jCheckBox1.setIconTextGap(10);
        jCheckBox1.setOpaque(false);
        jCheckBox1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_tick_box_20px.png"))); // NOI18N
        jCheckBox1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_checked_checkbox_20px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jPasswordField1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 199, Short.MAX_VALUE)
                        .addComponent(jCheckBox1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 110, 360, 190));

        jPanel2.setOpaque(false);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/depeduseplogo.png"))); // NOI18N

        jScrollPane1.setBorder(null);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(10);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setText("This system was developed in collaboration with the Department of Education (DepED), University of Southeastern Philippines (USeP) and Crossing Bayabas National High School (CBNHS) intended to automate the book distribution process.");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextArea1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea1.setEnabled(false);
        jTextArea1.setOpaque(false);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE))
                .addGap(70, 70, 70))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 290, 350, 180));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(22, 66, 33));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BOOK KEEPING SYSTEM");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, 360, 98));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/Login Screen 2.png"))); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(9999, 9999));
        jLabel2.setMinimumSize(new java.awt.Dimension(1025, 500));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1loginHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1loginHandler
        loginUser();
    }//GEN-LAST:event_jTextField1loginHandler

    private void jPasswordField1loginHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1loginHandler
        loginUser();
    }//GEN-LAST:event_jPasswordField1loginHandler

    private void btnLoginloginHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginloginHandler
        loginUser();
    }//GEN-LAST:event_btnLoginloginHandler
    private void loginUser(){
        // TODO add your handling code here:

        String userName = jTextField1.getText();
        String password = String.valueOf(jPasswordField1.getPassword());

        int result = my.login(userName, password, new int [] {1,4,5});

        switch(result){
            case 0:{
                my.openWindow(this,new dashBoard());
                break;
            }case 1:{
                my.showMessage("Your account does not have the Access Level required\nto use this program.", JOptionPane.WARNING_MESSAGE);
                break;
            }case 2:{
                my.showMessage("Incorrect Username or Password", JOptionPane.ERROR_MESSAGE);
                break;
            }
        }
    }
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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}

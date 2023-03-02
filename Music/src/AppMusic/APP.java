package AppMusic;

public class APP extends javax.swing.JFrame {

    public APP() {
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage("src/resources/icons/logo_icon.png"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogin = new javax.swing.JPanel();
        txtLoginEmail = new javax.swing.JTextField();
        labelLogin1 = new javax.swing.JLabel();
        btnLoginEnter = new javax.swing.JButton();
        labelLogin2 = new javax.swing.JLabel();
        labelLogin3 = new javax.swing.JLabel();
        txtLoginPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login:");
        setMaximumSize(new java.awt.Dimension(500, 338));
        setMinimumSize(new java.awt.Dimension(500, 338));
        setPreferredSize(new java.awt.Dimension(500, 338));
        setResizable(false);

        panelLogin.setBackground(new java.awt.Color(179, 7, 83));
        panelLogin.setAlignmentX(0.0F);
        panelLogin.setAlignmentY(0.0F);
        panelLogin.setMaximumSize(new java.awt.Dimension(450, 250));
        panelLogin.setMinimumSize(new java.awt.Dimension(450, 250));

        txtLoginEmail.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtLoginEmail.setAlignmentX(0.0F);
        txtLoginEmail.setAlignmentY(0.0F);
        txtLoginEmail.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtLoginEmail.setMaximumSize(new java.awt.Dimension(260, 30));
        txtLoginEmail.setMinimumSize(new java.awt.Dimension(260, 30));
        txtLoginEmail.setPreferredSize(new java.awt.Dimension(260, 30));
        txtLoginEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginEmailActionPerformed(evt);
            }
        });

        labelLogin1.setFont(new java.awt.Font("Cambria", 1, 26)); // NOI18N
        labelLogin1.setForeground(new java.awt.Color(255, 255, 255));
        labelLogin1.setText("Login Ideal Music:");

        btnLoginEnter.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnLoginEnter.setText("Entrar");
        btnLoginEnter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLoginEnter.setFocusable(false);
        btnLoginEnter.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnLoginEnter.setMaximumSize(new java.awt.Dimension(260, 30));
        btnLoginEnter.setMinimumSize(new java.awt.Dimension(260, 30));
        btnLoginEnter.setPreferredSize(new java.awt.Dimension(260, 30));
        btnLoginEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginEnterActionPerformed(evt);
            }
        });

        labelLogin2.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        labelLogin2.setForeground(new java.awt.Color(255, 255, 255));
        labelLogin2.setText("Senha:");
        labelLogin2.setAlignmentY(0.0F);

        labelLogin3.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        labelLogin3.setForeground(new java.awt.Color(255, 255, 255));
        labelLogin3.setText("Nome:");
        labelLogin3.setAlignmentY(0.0F);

        txtLoginPassword.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtLoginPassword.setAlignmentX(0.0F);
        txtLoginPassword.setAlignmentY(0.0F);
        txtLoginPassword.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtLoginPassword.setMaximumSize(new java.awt.Dimension(260, 30));
        txtLoginPassword.setMinimumSize(new java.awt.Dimension(260, 30));
        txtLoginPassword.setPreferredSize(new java.awt.Dimension(260, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/logo_menor.png"))); // NOI18N

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addContainerGap(89, Short.MAX_VALUE)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnLoginEnter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelLoginLayout.createSequentialGroup()
                                .addComponent(labelLogin2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLoginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLoginLayout.createSequentialGroup()
                                .addComponent(labelLogin3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelLogin1)
                                    .addComponent(txtLoginEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(labelLogin1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLoginEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelLogin3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLogin2)
                    .addComponent(txtLoginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnLoginEnter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 352, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLoginEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoginEmailActionPerformed

    private void btnLoginEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginEnterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLoginEnterActionPerformed

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
            java.util.logging.Logger.getLogger(APP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(APP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(APP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(APP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new APP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoginEnter;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelLogin1;
    private javax.swing.JLabel labelLogin2;
    private javax.swing.JLabel labelLogin3;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JTextField txtLoginEmail;
    private javax.swing.JPasswordField txtLoginPassword;
    // End of variables declaration//GEN-END:variables
}
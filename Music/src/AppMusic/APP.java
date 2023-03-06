package AppMusic;

import Control.Config;
import Model.Database;

public class APP extends javax.swing.JFrame {

    private static final Database DB = new Database();

    public APP() {
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage("src/resources/icons/logo_icon.png"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogin = new javax.swing.JPanel();
        txtLoginLogin = new javax.swing.JTextField();
        labelLogin1 = new javax.swing.JLabel();
        btnLoginEnter = new javax.swing.JButton();
        labelLogin2 = new javax.swing.JLabel();
        labelLogin3 = new javax.swing.JLabel();
        txtLoginPassword = new javax.swing.JPasswordField();
        labelLoginLogo = new javax.swing.JLabel();

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

        txtLoginLogin.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtLoginLogin.setAlignmentX(0.0F);
        txtLoginLogin.setAlignmentY(0.0F);
        txtLoginLogin.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtLoginLogin.setMaximumSize(new java.awt.Dimension(260, 30));
        txtLoginLogin.setMinimumSize(new java.awt.Dimension(260, 30));
        txtLoginLogin.setPreferredSize(new java.awt.Dimension(260, 30));
        txtLoginLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginLoginActionPerformed(evt);
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
        labelLogin3.setText("Login:");
        labelLogin3.setAlignmentY(0.0F);

        txtLoginPassword.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtLoginPassword.setAlignmentX(0.0F);
        txtLoginPassword.setAlignmentY(0.0F);
        txtLoginPassword.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtLoginPassword.setMaximumSize(new java.awt.Dimension(260, 30));
        txtLoginPassword.setMinimumSize(new java.awt.Dimension(260, 30));
        txtLoginPassword.setPreferredSize(new java.awt.Dimension(260, 30));

        labelLoginLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/logo.png"))); // NOI18N

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelLoginLogo))
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
                                    .addComponent(txtLoginLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(labelLogin1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLoginLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelLogin3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLogin2)
                    .addComponent(txtLoginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnLoginEnter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(labelLoginLogo)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLoginLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoginLoginActionPerformed

    private void btnLoginEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginEnterActionPerformed
        if (Config.verifyTextFields(txtLoginLogin, txtLoginPassword)) {
            //if (Config.isCorrect(txtLoginLogin, "login") && Config.isCorrect(txtLoginPassword, "password")) {
                openInterface("employee");
            //}
        }

        Config.clearTextFields(txtLoginLogin, txtLoginPassword);
    }//GEN-LAST:event_btnLoginEnterActionPerformed

    public static void main(String args[]) {
        APP app = new APP();
        app.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoginEnter;
    private javax.swing.JLabel labelLogin1;
    private javax.swing.JLabel labelLogin2;
    private javax.swing.JLabel labelLogin3;
    private javax.swing.JLabel labelLoginLogo;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JTextField txtLoginLogin;
    private javax.swing.JPasswordField txtLoginPassword;
    // End of variables declaration//GEN-END:variables

    /**
     * Método responsável por pégar o tipo do usuário e abrir a interface correspondente
     * 
     * @author Kaik D' Andrade
     * @param type
     */
    private void openInterface(String type) {

        switch (type) {
            case "employee" -> {
                MusicInterface_Employee interfaceEmployee = new MusicInterface_Employee();
                interfaceEmployee.setVisible(true);
                interfaceEmployee.setLocationRelativeTo(null);
                setVisible(false);
            }

            case "artist" -> {
                MusicInterface_Artist interfaceArtist = new MusicInterface_Artist();
                interfaceArtist.setVisible(true);
                interfaceArtist.setLocationRelativeTo(null);
                setVisible(false);
            }

            default -> {
                break;
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import db.ConnectionManager;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


/**
 *
 * @author kausar
 */
public class F_login extends javax.swing.JFrame {

    /**
     * Creates new form F_login
     */
    public F_login() {
        initComponents();
        jLabel1.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/OEIKCK0.jpg")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
        
        setLocationRelativeTo(null);
   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        btn_login = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        btn_exit = new javax.swing.JButton();
        comStatus = new javax.swing.JComboBox();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(0, 136, 146));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addContainerGap(191, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(51, 0, 153));
        jPanel1.setForeground(new java.awt.Color(0, 0, 204));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Pasword");

        txtUsername.setBackground(new java.awt.Color(51, 0, 135));
        txtUsername.setForeground(new java.awt.Color(255, 255, 255));

        btn_login.setText("Login");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });

        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        txtPassword.setBackground(new java.awt.Color(51, 0, 135));
        txtPassword.setForeground(new java.awt.Color(255, 255, 255));

        btn_exit.setText("Exit");
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

        comStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "admin", "user" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btn_login)
                        .addGap(18, 18, 18)
                        .addComponent(btn_reset))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(btn_exit))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(txtPassword)
                            .addComponent(comStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(comStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_login)
                    .addComponent(btn_reset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_exit)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        // TODO add your handling code here:
        this.txtUsername.setText(null);
        this.txtPassword.setText(null);
                
    }//GEN-LAST:event_btn_resetActionPerformed
 public void  Login(){
        ConnectionManager conMan=new ConnectionManager();
        Connection conn= conMan.logOn();  
            try {  
                String sql = "select * from tbl_login LEFT JOIN tbl_anggota ON tbl_anggota.nim = tbl_login.username "
                        + "LEFT JOIN tbl_jabatan ON tbl_jabatan.id_jabatan = tbl_anggota.id_jabatan "
                        + "LEFT JOIN tbl_sekolah ON tbl_sekolah.id_sekolah = tbl_anggota.id_sekolah "
                        + "where tbl_login.username = '" + txtUsername.getText() + "' and tbl_login.status = '"+comStatus.getSelectedItem().toString()+"'" ;  
                Statement st = conn.createStatement();  
                ResultSet rsLogin = st.executeQuery(sql);  
      
                rsLogin.next();  
                rsLogin.last(); //mengecek jumlah baris pada hasil query  
                if (rsLogin.getRow()==1 && rsLogin.getString("status").equalsIgnoreCase("user")){      
                    if(txtPassword.getText().equals(rsLogin.getString("password"))){
                    JOptionPane.showMessageDialog(rootPane, "Login Berhasil!");
                    String nim, nama, alamat, no_hp, email, angkatan, status, jabatan, sekolah;
                    nim = rsLogin.getString("tbl_anggota.nim");
                    nama = rsLogin.getString("tbl_anggota.nama");
                    alamat = rsLogin.getString("tbl_anggota.alamat");
                    no_hp = rsLogin.getString("tbl_anggota.no_hp");
                    email = rsLogin.getString("tbl_anggota.email");
                    angkatan = rsLogin.getString("tbl_anggota.angkatan");
                    status = rsLogin.getString("tbl_anggota.status");
                    jabatan = rsLogin.getString("tbl_jabatan.nama");
                    sekolah = rsLogin.getString("tbl_sekolah.nama");
                    new F_User(nim,nama,alamat,no_hp,email,angkatan,status,jabatan,sekolah).setVisible(true);   
                    this.dispose();
                    
                }
                    else {
                    JOptionPane.showMessageDialog(rootPane, "Login Gagal, Silahkan Coba Lagi");  
                    txtUsername.requestFocus();
                    txtPassword.setText("");  
                    
                    }
                }
                else if (rsLogin.getRow()==1 && rsLogin.getString("status").equalsIgnoreCase("admin")){
                    if(txtPassword.getText().equals(rsLogin.getString("password"))){
                      JOptionPane.showMessageDialog(rootPane, "Login Berhasil!");
                      new F_Admin().setVisible(true);
                      this.dispose();
                    }else {
                    JOptionPane.showMessageDialog(rootPane, "Login Gagal, Silahkan Coba Lagi");  
                    txtUsername.requestFocus();
                    txtPassword.setText("");  
                    
                    }
                   
                }
                else {  
                    JOptionPane.showMessageDialog(rootPane, "Login Gagal, Silahkan Coba Lagi");  
                    txtUsername.setText("");  
                    txtPassword.setText("");  
                    txtUsername.requestFocus();  
                }
    
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(rootPane,"Koneksi Gagal");
            }
 }
    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        // TODO add your handling code here:
        Login();
    }//GEN-LAST:event_btn_loginActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btn_exitActionPerformed

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
            java.util.logging.Logger.getLogger(F_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(F_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(F_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(F_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
 try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
            SwingUtilities.updateComponentTreeUI(new F_Admin());
                   }catch(Exception ex){
                       System.out.println("Gagal");
                   }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new F_login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_reset;
    private javax.swing.JComboBox comStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
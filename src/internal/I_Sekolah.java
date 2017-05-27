/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal;

import java.util.ArrayList;
import Controller.CmdSekolah;
import entitas.Exporter;
import entitas.Sekolah;
import java.io.File;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author kausar
 */
public class I_Sekolah extends javax.swing.JInternalFrame {

    /**
     * Creates new form F_Sekolah
     */
    public I_Sekolah() {
        initComponents();
        tampilSklh();
    }
    
    public void tampilSklh(){
        CmdSekolah cSklh = new CmdSekolah();
        ArrayList<Sekolah> mySklh = cSklh.getAllMhs();
        // 4 diperoleh dari banyak kolom
        Object[][] dtSklh = new Object[mySklh.size()][5];
        int mySize = 0;
        for(Sekolah sklh : mySklh){
            dtSklh[mySize][0] = sklh.getNama();
            dtSklh[mySize][1] = sklh.getAlamat();
            dtSklh[mySize][2] = sklh.getNo_hp();
            dtSklh[mySize][3] = sklh.getEmail();
            dtSklh[mySize][4] = sklh.getId_sekolah();
            mySize++;
            
        }
        TabelSekolah.setModel(new javax.swing.table.DefaultTableModel(
           
                dtSklh,
            new String [] {
                "Nama Sekolah", "Alamat", "Email", "No Hp", "null"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TabelSekolah);
        if (TabelSekolah.getColumnModel().getColumnCount() > 0) {
            TabelSekolah.getColumnModel().getColumn(4).setMinWidth(0);
            TabelSekolah.getColumnModel().getColumn(4).setMaxWidth(0);
        }


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelKiri = new javax.swing.JPanel();
        PanelButton = new javax.swing.JPanel();
        btn_save = new javax.swing.JLabel();
        btn_update = new javax.swing.JLabel();
        btn_delete = new javax.swing.JLabel();
        btn_print = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        panelInput = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        txtNamaSekolah = new javax.swing.JTextField();
        txtNoHp = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        PanelKanan = new javax.swing.JPanel();
        btn_search = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelSekolah = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        PanelKiri.setBackground(new java.awt.Color(204, 204, 204));
        PanelKiri.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        PanelButton.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PanelButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        btn_save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_saveMouseClicked(evt);
            }
        });
        PanelButton.add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        btn_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update.png"))); // NOI18N
        btn_update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_updateMouseClicked(evt);
            }
        });
        PanelButton.add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btn_delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_deleteMouseClicked(evt);
            }
        });
        PanelButton.add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));

        btn_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/print.png"))); // NOI18N
        btn_print.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_printMouseClicked(evt);
            }
        });
        PanelButton.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        PanelButton.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        panelInput.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        panelInput.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nama Sekolah");
        panelInput.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel2.setText("Email");
        panelInput.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        jLabel3.setText("Alamat");
        panelInput.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel4.setText("No Hp");
        panelInput.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        txtAlamat.setColumns(20);
        txtAlamat.setRows(5);
        jScrollPane1.setViewportView(txtAlamat);

        panelInput.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 210, 80));
        panelInput.add(txtNamaSekolah, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 210, -1));
        panelInput.add(txtNoHp, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 210, -1));
        panelInput.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 210, -1));

        javax.swing.GroupLayout PanelKiriLayout = new javax.swing.GroupLayout(PanelKiri);
        PanelKiri.setLayout(PanelKiriLayout);
        PanelKiriLayout.setHorizontalGroup(
            PanelKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelKiriLayout.createSequentialGroup()
                .addGroup(PanelKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelKiriLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PanelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelKiriLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(panelInput, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        PanelKiriLayout.setVerticalGroup(
            PanelKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelKiriLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelInput, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(PanelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelKanan.setBackground(new java.awt.Color(204, 204, 204));
        PanelKanan.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sSearch.png"))); // NOI18N
        btn_search.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_searchMouseClicked(evt);
            }
        });

        TabelSekolah.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nama Sekolah", "Alamat", "Email", "No Hp", "id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TabelSekolah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelSekolahMouseClicked(evt);
            }
        });
        TabelSekolah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TabelSekolahKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(TabelSekolah);
        if (TabelSekolah.getColumnModel().getColumnCount() > 0) {
            TabelSekolah.getColumnModel().getColumn(4).setMinWidth(0);
            TabelSekolah.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        javax.swing.GroupLayout PanelKananLayout = new javax.swing.GroupLayout(PanelKanan);
        PanelKanan.setLayout(PanelKananLayout);
        PanelKananLayout.setHorizontalGroup(
            PanelKananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelKananLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelKananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelKananLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_search)))
                .addContainerGap())
        );
        PanelKananLayout.setVerticalGroup(
            PanelKananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelKananLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelKananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_search)
                    .addGroup(PanelKananLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelKiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelKanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelKanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelKiri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_saveMouseClicked
        // TODO add your handling code here:
        String nama_sekolah, alamat, no_hp, email;
        
        nama_sekolah = txtNamaSekolah.getText();
        alamat = txtAlamat.getText();
        no_hp = txtNoHp.getText();
        email = txtEmail.getText();
       
        
        
        Sekolah sklh = new Sekolah(nama_sekolah, alamat, no_hp, email);
        CmdSekolah cSklh = new CmdSekolah();
        cSklh.saveSklh(sklh);
        JOptionPane.showMessageDialog(null, "Data tersimpan");
        tampilSklh();
    }//GEN-LAST:event_btn_saveMouseClicked

    private void btn_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_updateMouseClicked
        // TODO add your handling code here:
        int row = TabelSekolah.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(null, "Pilih data dulu");
            
        }else{
        String nama_sekolah, alamat, no_hp, email,Strid_sekolah;
        int id_sekolah;
        nama_sekolah = txtNamaSekolah.getText();
        alamat = txtAlamat.getText();
        no_hp = txtNoHp.getText();
        email = txtEmail.getText();
        Strid_sekolah = TabelSekolah.getValueAt(row, 4).toString();
        id_sekolah = Integer.parseInt(Strid_sekolah);
        
        
        
        Sekolah sklh = new Sekolah(id_sekolah,nama_sekolah, alamat, no_hp, email);
        CmdSekolah cSklh = new CmdSekolah();
        cSklh.updateSklh(sklh);
        JOptionPane.showMessageDialog(null, "Data Terupate");
        tampilSklh();
        }              
    }//GEN-LAST:event_btn_updateMouseClicked

    private void TabelSekolahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TabelSekolahKeyPressed
        // TODO add your handling code here:
       
        
    }//GEN-LAST:event_TabelSekolahKeyPressed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        this.dispose();
       
    }//GEN-LAST:event_jLabel5MouseClicked

    private void btn_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseClicked
        // TODO add your handling code here:
        int row = TabelSekolah.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(null, "Pilih data dulu");
            
        }else{
        String Strid_sekolah;
        int id_sekolah;
        
        Strid_sekolah = TabelSekolah.getValueAt(row, 4).toString();
        id_sekolah = Integer.parseInt(Strid_sekolah);
        
        
        
        CmdSekolah cSklh = new CmdSekolah();
        cSklh.deleteSklh(id_sekolah);
        JOptionPane.showMessageDialog(null, "Data terhapus");
        tampilSklh();
        }
    }//GEN-LAST:event_btn_deleteMouseClicked

     public void cari_data(JTable tbl, String text){
        TableRowSorter sorter = new TableRowSorter(tbl.getModel());
        tbl.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        tbl.setSelectionMode(1);
}
     
     
    private void btn_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchMouseClicked
        // TODO add your handling code here:
        cari_data(TabelSekolah, (String)txtSearch.getText());
        
    }//GEN-LAST:event_btn_searchMouseClicked

    private void TabelSekolahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelSekolahMouseClicked
        // TODO add your handling code here:
        int row = TabelSekolah.getSelectedRow();
        String nama_sekolah,alamat,no_hp,email,Strid_sekolah;
        int id_sekolah;
        nama_sekolah = TabelSekolah.getValueAt(row, 0).toString();
        alamat = TabelSekolah.getValueAt(row, 1).toString();
        no_hp = TabelSekolah.getValueAt(row, 2).toString();
        email = TabelSekolah.getValueAt(row, 3).toString();
        Strid_sekolah = TabelSekolah.getValueAt(row, 4).toString();
        id_sekolah = Integer.parseInt(Strid_sekolah);
        txtNamaSekolah.setText(nama_sekolah);
        txtAlamat.setText(alamat);
        txtNoHp.setText(no_hp);
        txtEmail.setText(email);
    }//GEN-LAST:event_TabelSekolahMouseClicked

    private void btn_printMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_printMouseClicked
        // TODO add your handling code here:
          if (TabelSekolah.getRowCount() == 0){
            JOptionPane.showMessageDialog(null, "Tidak ada data");
        }
        
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Export ke excell"," .xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Save");
        chooser.setMultiSelectionEnabled(false);
        chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
                List<JTable> tb = new ArrayList<>();
            List<String>nom = new ArrayList<>();
            tb.add(TabelSekolah);
            nom.add("ViewsDataSekolah");
            String file = chooser.getSelectedFile().toString().concat(".xls");
            try {
                Exporter e = new Exporter(new File(file) , tb , nom);
               
                if(e.export()){
                    JOptionPane.showMessageDialog(null, "Berhasil Export","Export To Excell", 
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null, "ada yang error" +ex.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            } 
    }//GEN-LAST:event_btn_printMouseClicked

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelButton;
    private javax.swing.JPanel PanelKanan;
    private javax.swing.JPanel PanelKiri;
    private javax.swing.JTable TabelSekolah;
    private javax.swing.JLabel btn_delete;
    private javax.swing.JLabel btn_print;
    private javax.swing.JLabel btn_save;
    private javax.swing.JLabel btn_search;
    private javax.swing.JLabel btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelInput;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNamaSekolah;
    private javax.swing.JTextField txtNoHp;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
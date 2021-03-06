/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal;

import java.util.ArrayList;
import Controller.CmdProker;
import db.ConnectionManager;
import entitas.Exporter;
import entitas.Proker;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
public class I_Proker extends javax.swing.JInternalFrame {

    /**
     * Creates new form F_Proker
     */
    public I_Proker() {
        initComponents();
        tampilPrkr();
        tampilCombo();
    }
    
     public void tampilCombo(){
       
    ConnectionManager conMan=new ConnectionManager();
    Connection conn= conMan.logOn(); 

    try
    {
  
    String sql ="select distinct angkatan from tbl_anggota";
    
       Statement stm=conn.createStatement();
       ResultSet rs1 = stm.executeQuery(sql);   
       while (rs1.next())
       {  
         String angkatan=rs1.getString("angkatan");
         comPeriode.addItem(angkatan);
       }
       
       }catch (Exception e)
    {
        JOptionPane.showMessageDialog(null, "GAGAL MENAMPILKAN DATA");
    }
    }
    
    public void tampilPrkr(){
        CmdProker cPrkr = new CmdProker();
        ArrayList<Proker> myPrkr = cPrkr.getAllPrkr();
        // Matriks 2 dimensi = baris x kolom
        Object[][] dtPrkr = new Object[myPrkr.size()][7];
        int mySize = 0;
        for(Proker prkr : myPrkr){
            dtPrkr[mySize][0] = prkr.getNama_proker();
            dtPrkr[mySize][1] = prkr.getTujuan();
            dtPrkr[mySize][2] = prkr.getTempat();
            dtPrkr[mySize][3] = prkr.getAnggaran();
            dtPrkr[mySize][4] = prkr.getTanggal();
            dtPrkr[mySize][5] = prkr.getStatus();
            dtPrkr[mySize][6] = prkr.getId_proker();
            mySize++;
            
        }
        TabelProker.setModel(new javax.swing.table.DefaultTableModel(
            /** new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            }**/
                dtPrkr,
            new String [] {
                "Nama Proker", "Tujuan", "Tempat", "Anggaran", "tanggal","status", "Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,java.lang.String.class,java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TabelProker);
        if (TabelProker.getColumnModel().getColumnCount() > 0) {
            TabelProker.getColumnModel().getColumn(6).setMinWidth(0);
            TabelProker.getColumnModel().getColumn(6).setMaxWidth(0);
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
        txtTujuan = new javax.swing.JTextArea();
        txtNamaProker = new javax.swing.JTextField();
        txtAnggaran = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtTempat = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        txtTanggal = new javax.swing.JFormattedTextField();
        comStatus = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        comPeriode = new javax.swing.JComboBox();
        PanelKanan = new javax.swing.JPanel();
        btn_search = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelProker = new javax.swing.JTable();

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
        PanelButton.add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        btn_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update.png"))); // NOI18N
        btn_update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_updateMouseClicked(evt);
            }
        });
        PanelButton.add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btn_delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_deleteMouseClicked(evt);
            }
        });
        PanelButton.add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        btn_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/print.png"))); // NOI18N
        btn_print.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_printMouseClicked(evt);
            }
        });
        PanelButton.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        PanelButton.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        panelInput.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        panelInput.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nama Proker");
        panelInput.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel2.setText("Status");
        panelInput.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        jLabel3.setText("Tujuan");
        panelInput.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel4.setText("Tempat");
        panelInput.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        txtTujuan.setColumns(20);
        txtTujuan.setRows(5);
        jScrollPane1.setViewportView(txtTujuan);

        panelInput.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 210, -1));
        panelInput.add(txtNamaProker, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 210, -1));
        panelInput.add(txtAnggaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 210, -1));

        txtTempat.setColumns(20);
        txtTempat.setRows(5);
        jScrollPane3.setViewportView(txtTempat);

        panelInput.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 210, 100));

        jLabel6.setText("Tanggal");
        panelInput.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        txtTanggal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-M-d"))));
        panelInput.add(txtTanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 210, -1));

        comStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sudah Terlaksana", "Belum Terlaksana" }));
        panelInput.add(comStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 210, -1));

        jLabel7.setText("Anggaran");
        panelInput.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        jLabel8.setText("Periode");
        panelInput.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        panelInput.add(comPeriode, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 210, -1));

        javax.swing.GroupLayout PanelKiriLayout = new javax.swing.GroupLayout(PanelKiri);
        PanelKiri.setLayout(PanelKiriLayout);
        PanelKiriLayout.setHorizontalGroup(
            PanelKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelKiriLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(PanelKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(PanelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelInput, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        PanelKiriLayout.setVerticalGroup(
            PanelKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelKiriLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelInput, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PanelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
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

        TabelProker.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nama Proker", "Tujuan", "Tempat", "Anggaran", "id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TabelProker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelProkerMouseClicked(evt);
            }
        });
        TabelProker.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TabelProkerKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(TabelProker);

        javax.swing.GroupLayout PanelKananLayout = new javax.swing.GroupLayout(PanelKanan);
        PanelKanan.setLayout(PanelKananLayout);
        PanelKananLayout.setHorizontalGroup(
            PanelKananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelKananLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelKananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelKananLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(btn_search)))
                .addContainerGap())
        );
        PanelKananLayout.setVerticalGroup(
            PanelKananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelKananLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(PanelKananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelKananLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_search))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2))
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
            .addComponent(PanelKiri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelKanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_saveMouseClicked
        // TODO add your handling code here:
        String nama_proker,tujuan,tempat,status, periode;
        int anggaran;
        
        nama_proker = txtNamaProker.getText();
        tujuan = txtTujuan.getText();
        tempat = txtTempat.getText();
        anggaran =Integer.parseInt(txtAnggaran.getText());
        java.util.Date tanggal = (java.util.Date) txtTanggal.getValue();
        status = comStatus.getSelectedItem().toString();
        periode = comPeriode.getSelectedItem().toString();
       
        
        
        Proker prkr = new Proker(nama_proker, tujuan, tempat, anggaran, tanggal, status, periode);
        CmdProker cPrkr = new CmdProker();
        cPrkr.savePrkr(prkr);
        JOptionPane.showMessageDialog(null, "Data tersimpan");
        tampilPrkr();
    }//GEN-LAST:event_btn_saveMouseClicked

    private void btn_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_updateMouseClicked
        // TODO add your handling code here:
        int row = TabelProker.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(null, "Pilih data dulu");
            
        }else{
        String nama_proker,tujuan,tempat,status,periode;
        int id_proker,anggaran;
        
        nama_proker = txtNamaProker.getText();
        tujuan = txtTujuan.getText();
        tempat = txtTempat.getText();
        anggaran = Integer.parseInt(txtAnggaran.getText());
        id_proker = (int) TabelProker.getValueAt(row, 6);
        java.util.Date tanggal = (java.util.Date) txtTanggal.getValue();
        status = comStatus.getSelectedItem().toString();
        periode = comPeriode.getSelectedItem().toString();
       
        
        
        Proker prkr = new Proker(nama_proker, tujuan, tempat, anggaran, id_proker, tanggal, status, periode);
        CmdProker cPrkr = new CmdProker();
        cPrkr.updatePrkr(prkr);
        JOptionPane.showMessageDialog(null, "Data terupdate");
        tampilPrkr();
        }
                      
    }//GEN-LAST:event_btn_updateMouseClicked

    private void TabelProkerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TabelProkerKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_TabelProkerKeyPressed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void btn_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseClicked
        // TODO add your handling code here:
        int row = TabelProker.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(null, "Pilih data dulu");
            
        }else{
        int id_proker;
        
        id_proker =(int) TabelProker.getValueAt(row, 6);
       
        
        
        
        CmdProker cPrkr = new CmdProker();
        cPrkr.deletePrkr(id_proker);
        JOptionPane.showMessageDialog(null, "Data Terhapus");
        tampilPrkr();
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
        cari_data(TabelProker, (String)txtSearch.getText());
        
    }//GEN-LAST:event_btn_searchMouseClicked

    private void TabelProkerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelProkerMouseClicked
        // TODO add your handling code here:
        int row = TabelProker.getSelectedRow();
        String nama_proker,tujuan,tempat,status,tanggal;
        int anggaran,id_proker;
        nama_proker = TabelProker.getValueAt(row, 0).toString();
        tujuan = TabelProker.getValueAt(row, 1).toString();
        tempat = TabelProker.getValueAt(row, 2).toString();
        anggaran = (int)TabelProker.getValueAt(row, 3);
        tanggal = TabelProker.getValueAt(row, 4).toString();
        status = TabelProker.getValueAt(row, 5).toString();
        id_proker = (int) TabelProker.getValueAt(row, 6);
        
        txtNamaProker.setText(nama_proker);
        txtTujuan.setText(tujuan);
        txtTempat.setText(tempat);
        txtTanggal.setText(tanggal);
        comStatus.setSelectedItem(status);
        txtAnggaran.setText(String.valueOf(anggaran));
    }//GEN-LAST:event_TabelProkerMouseClicked

    private void btn_printMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_printMouseClicked
        // TODO add your handling code here:
          if (TabelProker.getRowCount() == 0){
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
            tb.add(TabelProker);
            nom.add("ViewsDataProker");
            String file = chooser.getSelectedFile().toString().concat(".xls");
            try {
                Exporter e = new Exporter(new File(file) , tb , nom);
               
                if(e.export()){
                    JOptionPane.showMessageDialog(null, "Berhasil Export","Export To Excell", JOptionPane.INFORMATION_MESSAGE);
                }
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null, "ada yang error" +ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            } 
    }//GEN-LAST:event_btn_printMouseClicked

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelButton;
    private javax.swing.JPanel PanelKanan;
    private javax.swing.JPanel PanelKiri;
    private javax.swing.JTable TabelProker;
    private javax.swing.JLabel btn_delete;
    private javax.swing.JLabel btn_print;
    private javax.swing.JLabel btn_save;
    private javax.swing.JLabel btn_search;
    private javax.swing.JLabel btn_update;
    private javax.swing.JComboBox comPeriode;
    private javax.swing.JComboBox comStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panelInput;
    private javax.swing.JTextField txtAnggaran;
    private javax.swing.JTextField txtNamaProker;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JFormattedTextField txtTanggal;
    private javax.swing.JTextArea txtTempat;
    private javax.swing.JTextArea txtTujuan;
    // End of variables declaration//GEN-END:variables
}

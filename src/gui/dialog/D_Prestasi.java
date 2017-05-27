/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.dialog;

import Controller.CmdPelanggaran;
import Controller.CmdPrestasi;
import db.ConnectionManager;
import entitas.Exporter;
import entitas.Prestasi;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author kausar
 */
public class D_Prestasi extends javax.swing.JDialog {
    private DefaultTableModel model;
    /**
     * Creates new form D_Pelanggaran1
     */
    public D_Prestasi(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
       
        tampilsemuacombo();
    }
    
    public D_Prestasi(java.awt.Frame parent, boolean modal, String nim) {  
        super(parent, modal); 
        initComponents();
        model = new DefaultTableModel();

        //menambahkan header tabel
        model.addColumn("NIM");
        model.addColumn("Nama Kegiatan");
        model.addColumn("Tanggal");
        model.addColumn("Uraian prestasi");
        model.addColumn("Id Prestasi");
        model.addColumn("Id Kegiatan");

        TabelPrestasi.setModel(model);
        tampilsemuacombo();
        txtNim.setText(nim);
        txtNim.setEditable(false);
        txtTanggal.setEditable(false);
        txtIdKeg.setVisible(false);
        loadData();
    }
    public final void loadData() {
       
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
        try {
             ConnectionManager conMan= new ConnectionManager();
            Connection con =conMan.logOn();
            String sql = "select * from tbl_prestasi LEFT JOIN tbl_anggota ON tbl_prestasi.nim = tbl_anggota.nim LEFT JOIN tbl_kegiatan ON tbl_prestasi.id_kegiatan = tbl_kegiatan.id_kegiatan where tbl_prestasi.nim = '"+ txtNim.getText() +"'";
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery(sql);
            
            while (r.next()) {
                Object[] o = new Object[6];
                o[0] = r.getString("tbl_anggota.nim");
                o[1] = r.getString("tbl_kegiatan.nama");
                o[2] = r.getString("tbl_kegiatan.tanggal");
                o[3] = r.getString("tbl_prestasi.uraian");
                o[4] = r.getString("tbl_prestasi.id_prestasi");
                o[5] = r.getString("tbl_kegiatan.id_kegiatan");
                

                model.addRow(o);
            }
            
            
            r.close();
            s.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    


    

    
    public void tampilsemuacombo(){
    ConnectionManager conMan=new ConnectionManager();
    Connection conn= conMan.logOn(); 
    
    
    try
    {
  
      String sql ="select * from tbl_kegiatan";
     
       Statement stm=conn.createStatement();
       ResultSet rs = stm.executeQuery(sql);
       while (rs.next())
       {  
         String kegiatan=rs.getString("nama");         
         comKegiatan.addItem(kegiatan);
       }
       
       
       
       }catch (Exception e)
    {
        JOptionPane.showMessageDialog(null, "GAGAL MENAMPILKAN DATA");
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
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtUraian = new javax.swing.JTextArea();
        txtNim = new javax.swing.JFormattedTextField();
        comKegiatan = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtIdKeg = new javax.swing.JTextField();
        txtTanggal = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        PanelKanan = new javax.swing.JPanel();
        btn_search = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelPrestasi = new javax.swing.JTable();

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
        PanelButton.add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        btn_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update.png"))); // NOI18N
        btn_update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_updateMouseClicked(evt);
            }
        });
        PanelButton.add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btn_delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_deleteMouseClicked(evt);
            }
        });
        PanelButton.add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        btn_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/print.png"))); // NOI18N
        btn_print.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_printMouseClicked(evt);
            }
        });
        PanelButton.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        PanelButton.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, -1));

        panelInput.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        panelInput.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Uraian Prestasi");
        panelInput.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        txtUraian.setColumns(20);
        txtUraian.setRows(5);
        jScrollPane3.setViewportView(txtUraian);

        panelInput.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 270, 100));
        panelInput.add(txtNim, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 270, -1));

        comKegiatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comKegiatanActionPerformed(evt);
            }
        });
        panelInput.add(comKegiatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 270, -1));

        jLabel2.setText("NIM");
        panelInput.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel6.setText("Nama Kegiatan");
        panelInput.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));
        panelInput.add(txtIdKeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 30, -1));

        txtTanggal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-M-d"))));
        panelInput.add(txtTanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 270, -1));

        jLabel4.setText("Tanggal");
        panelInput.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        javax.swing.GroupLayout PanelKiriLayout = new javax.swing.GroupLayout(PanelKiri);
        PanelKiri.setLayout(PanelKiriLayout);
        PanelKiriLayout.setHorizontalGroup(
            PanelKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelKiriLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelInput, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        PanelKiriLayout.setVerticalGroup(
            PanelKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelKiriLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelInput, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(PanelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        TabelPrestasi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TabelPrestasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelPrestasiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelPrestasi);
        if (TabelPrestasi.getColumnModel().getColumnCount() > 0) {
            TabelPrestasi.getColumnModel().getColumn(3).setMinWidth(0);
            TabelPrestasi.getColumnModel().getColumn(3).setMaxWidth(0);
        }

        javax.swing.GroupLayout PanelKananLayout = new javax.swing.GroupLayout(PanelKanan);
        PanelKanan.setLayout(PanelKananLayout);
        PanelKananLayout.setHorizontalGroup(
            PanelKananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelKananLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(PanelKananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelKananLayout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_search)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelKananLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE))
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
        int id_kegiatan;
        String nim,uraian;
        id_kegiatan = Integer.parseInt(txtIdKeg.getText());
        nim = txtNim.getText();
        uraian = txtUraian.getText();

        Prestasi plgrn = new Prestasi(nim, id_kegiatan, uraian);
        CmdPrestasi cPres = new CmdPrestasi();
        cPres.savePres(plgrn);
        JOptionPane.showMessageDialog(null, "Data berhasil tersimpan");
        loadData();
    }//GEN-LAST:event_btn_saveMouseClicked

    private void btn_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_updateMouseClicked
        // TODO add your handling code here:
        int row = TabelPrestasi.getSelectedRow();
        String nim,Strid_prestasi, uraian;
        int id_prestasi,id_kegiatan;
        uraian = txtUraian.getText();
        nim = txtNim.getText();
        Strid_prestasi = (String) TabelPrestasi.getValueAt(row,4);
        id_prestasi = Integer.parseInt(Strid_prestasi);
        id_kegiatan = Integer.parseInt(txtIdKeg.getText());
        
        Prestasi pres = new Prestasi(id_prestasi, nim, id_kegiatan, uraian);
        CmdPrestasi cPres = new CmdPrestasi();
        cPres.updatePres(pres);
        JOptionPane.showMessageDialog(null, "Data tersimpan");
        loadData();

    }//GEN-LAST:event_btn_updateMouseClicked

    private void btn_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseClicked
        // TODO add your handling code here:
        int row = TabelPrestasi.getSelectedRow();
        String Strid_prestasi;
        int id_prestasi;

        Strid_prestasi = (String) TabelPrestasi.getValueAt(row, 4);
        id_prestasi = Integer.parseInt(Strid_prestasi);
        CmdPrestasi cPres = new CmdPrestasi();
        cPres.deletePres(id_prestasi);
        JOptionPane.showMessageDialog(null, "Data tersimpan");
        loadData();
    }//GEN-LAST:event_btn_deleteMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        this.dispose();
  
    }//GEN-LAST:event_jLabel5MouseClicked

    private void comKegiatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comKegiatanActionPerformed
        ConnectionManager conMan= new ConnectionManager();
        Connection con =conMan.logOn();
        try
        {
            String sql="select * from tbl_kegiatan where tbl_kegiatan.nama='"+comKegiatan.getSelectedItem()+"'";
            Statement st=con.createStatement();
            ResultSet rs =st.executeQuery(sql);

            while(rs.next())
            {
                txtIdKeg.setText(rs.getString("id_kegiatan"));
                txtTanggal.setText(rs.getString("tanggal"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_comKegiatanActionPerformed
public void cari_data(JTable tbl, String text){
        TableRowSorter sorter = new TableRowSorter(tbl.getModel());
        tbl.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        tbl.setSelectionMode(1);
}
    private void btn_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchMouseClicked
        // TODO add your handling code here:
        cari_data(TabelPrestasi, (String)txtSearch.getText());
    }//GEN-LAST:event_btn_searchMouseClicked

    private void TabelPrestasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelPrestasiMouseClicked
        // TODO add your handling code here:
        int i = TabelPrestasi.getSelectedRow();

       
        String nama_kegiatan = (String) model.getValueAt(i, 1);
        String uraian = (String) model.getValueAt(i, 3);
        txtUraian.setText(uraian);
        comKegiatan.setSelectedItem(nama_kegiatan);
        String id_pelanggaran = (String) model.getValueAt(i, 4);
        
    }//GEN-LAST:event_TabelPrestasiMouseClicked

    private void btn_printMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_printMouseClicked
        // TODO add your handling code here:
        if (TabelPrestasi.getRowCount() == 0){
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
            tb.add(TabelPrestasi);
            nom.add("Laporan Prestasi");
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
            java.util.logging.Logger.getLogger(D_Prestasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(D_Prestasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(D_Prestasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(D_Prestasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                D_Prestasi dialog = new D_Prestasi(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelButton;
    private javax.swing.JPanel PanelKanan;
    private javax.swing.JPanel PanelKiri;
    private javax.swing.JTable TabelPrestasi;
    private javax.swing.JLabel btn_delete;
    private javax.swing.JLabel btn_print;
    private javax.swing.JLabel btn_save;
    private javax.swing.JLabel btn_search;
    private javax.swing.JLabel btn_update;
    private javax.swing.JComboBox comKegiatan;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panelInput;
    private javax.swing.JTextField txtIdKeg;
    private javax.swing.JFormattedTextField txtNim;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JFormattedTextField txtTanggal;
    private javax.swing.JTextArea txtUraian;
    // End of variables declaration//GEN-END:variables
}
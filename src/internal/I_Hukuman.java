/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal;

import java.util.ArrayList;
import Controller.CmdHukuman;
import db.ConnectionManager;
import entitas.Exporter;
import entitas.Hukuman;
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
public class I_Hukuman extends javax.swing.JInternalFrame {

    /**
     * Creates new form F_Sekolah
     */
    public I_Hukuman() {
        initComponents();
        tampilHkmn();
        tampilPasal();    
        txtIsi.setEditable(false);
        txtKodeAdart.setEditable(false);  
    }
    
    public void tampilPasal(){
        comPasal.addItem("");
    ConnectionManager conMan=new ConnectionManager();
    Connection conn= conMan.logOn(); 

    try
    {
  
    String sql ="select distinct pasal from tbl_adart";
    
       Statement stm=conn.createStatement();
       ResultSet rs1 = stm.executeQuery(sql);   
       while (rs1.next())
       {  
         String pasal=rs1.getString("pasal");
         comPasal.addItem(pasal);
       }
       
       }catch (Exception e)
    {
        JOptionPane.showMessageDialog(null, "GAGAL MENAMPILKAN DATA");
    }
    }
    
    public void tampilAyat(){
    ConnectionManager conMan=new ConnectionManager();
    Connection conn= conMan.logOn(); 

    try
    {
  
    String sql ="select ayat from tbl_adart where pasal ='"+comPasal.getSelectedItem()+"'";
    
       Statement stm=conn.createStatement();
       ResultSet rs1 = stm.executeQuery(sql);   
       while (rs1.next())
       {  
         String ayat=rs1.getString("ayat");
         comAyat.addItem(ayat);
       }
       
       }catch (Exception e)
    {
        JOptionPane.showMessageDialog(null, "GAGAL MENAMPILKAN DATA ayat");
    }
    }
    
    public void tampilHkmn(){
        CmdHukuman cHkmn = new CmdHukuman();
        ArrayList<Hukuman> myHkmn = cHkmn.getAllHukuman();
        
        Object[][] dtHkmn = new Object[myHkmn.size()][5];
        int mySize = 0;
        for(Hukuman hkmn : myHkmn){
            
            dtHkmn[mySize][0] = hkmn.getPasal();
            dtHkmn[mySize][1] = hkmn.getAyat();
            dtHkmn[mySize][2] = hkmn.getNama();
            dtHkmn[mySize][3] = hkmn.getUraian();
            dtHkmn[mySize][4] = hkmn.getId_hukuman();
            mySize++;
            
        }
        TabelHukuman.setModel(new javax.swing.table.DefaultTableModel(
           
                dtHkmn,
            new String [] {
                "Pasal", "Ayat", "Nama Hukuman", "Uraian", "Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, 
                java.lang.String.class, java.lang.String.class,
                java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TabelHukuman);
        
        


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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtUraian = new javax.swing.JTextArea();
        txtNama = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtIsi = new javax.swing.JTextArea();
        comPasal = new javax.swing.JComboBox();
        txtKodeAdart = new javax.swing.JTextField();
        comAyat = new javax.swing.JComboBox();
        PanelKanan = new javax.swing.JPanel();
        btn_search = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelHukuman = new javax.swing.JTable();

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

        jLabel1.setText("AD/ART");
        panelInput.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel3.setText("Nama");
        panelInput.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jLabel4.setText("Uraian");
        panelInput.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        txtUraian.setColumns(20);
        txtUraian.setRows(5);
        jScrollPane1.setViewportView(txtUraian);

        panelInput.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 270, 110));
        panelInput.add(txtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 270, -1));

        txtIsi.setColumns(20);
        txtIsi.setRows(5);
        jScrollPane3.setViewportView(txtIsi);

        panelInput.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 80, 350, 100));

        comPasal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comPasalActionPerformed(evt);
            }
        });
        panelInput.add(comPasal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 120, -1));
        panelInput.add(txtKodeAdart, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 260, -1));

        comAyat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comAyatActionPerformed(evt);
            }
        });
        panelInput.add(comAyat, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 120, -1));

        javax.swing.GroupLayout PanelKiriLayout = new javax.swing.GroupLayout(PanelKiri);
        PanelKiri.setLayout(PanelKiriLayout);
        PanelKiriLayout.setHorizontalGroup(
            PanelKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelKiriLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(PanelKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(PanelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelInput, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        PanelKiriLayout.setVerticalGroup(
            PanelKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelKiriLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelInput, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PanelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        TabelHukuman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Pasal", "Ayat", "Nama Hukuman", "Uraian", "Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelHukuman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TabelHukumanMousePressed(evt);
            }
        });
        TabelHukuman.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TabelHukumanKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(TabelHukuman);

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
            .addComponent(PanelKanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelKiri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_saveMouseClicked
        // TODO add your handling code here:
        String kode_adart,nama,uraian;
        
        kode_adart = (String) txtKodeAdart.getText();
        uraian = txtUraian.getText();
        nama = txtNama.getText();
        
        
        Hukuman hkmn = new Hukuman(kode_adart, nama, uraian);
        CmdHukuman cHkmn = new CmdHukuman();
        int hasil = cHkmn.saveHkmn(hkmn);
        JOptionPane.showMessageDialog(null, "Data tersimpan = "+hasil);
        tampilHkmn();
    }//GEN-LAST:event_btn_saveMouseClicked

    private void btn_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_updateMouseClicked
        // TODO add your handling code here:
        int row = TabelHukuman.getSelectedRow();
        String kode_adart,uraian,nama;
        int id_hukuman;
        kode_adart = txtKodeAdart.getText();
        uraian = txtUraian.getText();
        nama = txtNama.getText();
        id_hukuman =(int) TabelHukuman.getValueAt(row, 4);
        
        Hukuman hkmn = new Hukuman(id_hukuman,kode_adart, nama, uraian);
        CmdHukuman cHkmn = new CmdHukuman();
        cHkmn.updateHkmn(hkmn);
        JOptionPane.showMessageDialog(null, "Data terupdate");
        tampilHkmn();
                      
    }//GEN-LAST:event_btn_updateMouseClicked

    private void TabelHukumanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TabelHukumanKeyPressed
        // TODO add your handling code here:
            
    }//GEN-LAST:event_TabelHukumanKeyPressed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void btn_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseClicked
        // TODO add your handling code here:
        int row = TabelHukuman.getSelectedRow();
        String Strid_hukuman;
        int id_hukuman;
        
        Strid_hukuman = TabelHukuman.getValueAt(row, 4).toString();
        id_hukuman = Integer.parseInt(Strid_hukuman);
       
        CmdHukuman cHkmn = new CmdHukuman();
        int hasil = cHkmn.deleteHkmn(id_hukuman);
        JOptionPane.showMessageDialog(null, "Data terhapus");
        tampilHkmn();
    }//GEN-LAST:event_btn_deleteMouseClicked

     public void cari_data(JTable tbl, String text){
        TableRowSorter sorter = new TableRowSorter(tbl.getModel());
        tbl.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        tbl.setSelectionMode(1);
}
     
     
    private void btn_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchMouseClicked
        // TODO add your handling code here:
        cari_data(TabelHukuman, (String)txtSearch.getText());
        
    }//GEN-LAST:event_btn_searchMouseClicked

    private void TabelHukumanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelHukumanMousePressed
        // TODO add your handling code here:
        int row = TabelHukuman.getSelectedRow();
        String pasal, ayat, nama, uraian;
        
        pasal = TabelHukuman.getValueAt(row, 0).toString();
        ayat = TabelHukuman.getValueAt(row, 1).toString();
        nama = TabelHukuman.getValueAt(row, 2).toString();
        uraian = TabelHukuman.getValueAt(row, 3).toString();
        
        
        comPasal.setSelectedItem(pasal);
        comAyat.setSelectedItem(ayat);
        txtUraian.setText(uraian);
        txtNama.setText(nama);    
    }//GEN-LAST:event_TabelHukumanMousePressed

    private void comPasalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comPasalActionPerformed
        comAyat.removeAllItems();
        comAyat.addItem("");
        tampilAyat();
    }//GEN-LAST:event_comPasalActionPerformed

    private void comAyatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comAyatActionPerformed
       ConnectionManager conMan= new ConnectionManager();
        Connection con =conMan.logOn();
        try
            {
                String sql="select * from tbl_adart where pasal='"+comPasal.getSelectedItem()+"' and ayat='"+comAyat.getSelectedItem()+"'";
                Statement st=con.createStatement();
                ResultSet rs =st.executeQuery(sql);

                while(rs.next())
                {
                    txtKodeAdart.setText(rs.getString("kode_adart"));
                    txtIsi.setText(rs.getString("uraian"));
                }
            }catch(Exception e){
                System.out.println(e);
            }
    }//GEN-LAST:event_comAyatActionPerformed

    private void btn_printMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_printMouseClicked
        // TODO add your handling code here:
          if (TabelHukuman.getRowCount() == 0){
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
            tb.add(TabelHukuman);
            nom.add("ViewsDataHukuman");
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

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelButton;
    private javax.swing.JPanel PanelKanan;
    private javax.swing.JPanel PanelKiri;
    private javax.swing.JTable TabelHukuman;
    private javax.swing.JLabel btn_delete;
    private javax.swing.JLabel btn_print;
    private javax.swing.JLabel btn_save;
    private javax.swing.JLabel btn_search;
    private javax.swing.JLabel btn_update;
    private javax.swing.JComboBox comAyat;
    private javax.swing.JComboBox comPasal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panelInput;
    private javax.swing.JTextArea txtIsi;
    private javax.swing.JTextField txtKodeAdart;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextArea txtUraian;
    // End of variables declaration//GEN-END:variables
}

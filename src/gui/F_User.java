/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Controller.GetDataUser;
import entitas.Panitia;
import entitas.Pelanggaran;
import entitas.Prestasi;
import gui.dialog.D_ResetPassword;
import java.awt.CardLayout;
import java.util.ArrayList;

/**
 *
 * @author kausar
 */
public class F_User extends javax.swing.JFrame {

    /**
     * Creates new form F_User
     */
    public F_User() {
        initComponents();
        showPanitia(dynamicNim.getText());
        showPretasi(dynamicNim.getText());
        showPelangaran(dynamicNim.getText());
    }
    
    public F_User(String nim,String nama,String alamat,String no_hp,String email,String angkatan,String status,String jabatan,String sekolah) {
        initComponents();
        dynamicNim.setText(nim);
        dynamicNama.setText(nama);
        dynamicAlamat.setText(alamat);
        dynamicNoHp.setText(no_hp);
        dynamicEmail.setText(email);
        dynamicAngkatan.setText(angkatan);
        dynamicStatus.setText(status);
        dynamicJabatan.setText(jabatan);
        dynamicAsalSklh.setText(sekolah);
        showPanitia(dynamicNim.getText());
        showPretasi(dynamicNim.getText());
        showPelangaran(dynamicNim.getText());
        
    }
    
    public void showPanitia(String nim){
        GetDataUser cGetPan = new GetDataUser();
        ArrayList<Panitia> myPan = cGetPan.getAllPan(nim);
        // 4 diperoleh dari banyak kolom
        Object[][] dtPanitia = new Object[myPan.size()][3];
        int mySize = 0;
        for(Panitia pan : myPan){
            dtPanitia[mySize][0] = pan.getProker();
            dtPanitia[mySize][1] = pan.getJabatan();
            dtPanitia[mySize][2] = pan.getTanggal();
            
            mySize++;
            
        }
        TabelPanitia.setModel(new javax.swing.table.DefaultTableModel(
           /** new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            }**/dtPanitia,
            new String [] {
                "Nama Proker", "Jabatan", "Tanggal"
            }
        ));
        jScrollPane1.setViewportView(TabelPanitia);

    }
    public void showPretasi(String nim){
        GetDataUser cGetPres = new GetDataUser();
        ArrayList<Prestasi> myPres = cGetPres.getAllPres(nim);
        // 4 diperoleh dari banyak kolom
        Object[][] dtPrestasi = new Object[myPres.size()][3];
        int mySize = 0;
        for(Prestasi pres : myPres){
            dtPrestasi[mySize][0] = pres.getNama_kegiatan();
            dtPrestasi[mySize][1] = pres.getTanggal();
            dtPrestasi[mySize][2] = pres.getUraian();
            
            mySize++;
            
        }
        
         TabelPrestasi.setModel(new javax.swing.table.DefaultTableModel(
         /**   new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            }**/dtPrestasi,
            new String [] {
                "Nama Kegiatan", "Tanggal", "Uraian",
            }
        ));
        jScrollPane2.setViewportView(TabelPrestasi);

    }
    
    public void showPelangaran(String nim){
        GetDataUser cGetLang = new GetDataUser();
        ArrayList<Pelanggaran> myLang = cGetLang.getAllPlgrn(nim);
        // 4 diperoleh dari banyak kolom
        Object[][] dtPlgrn = new Object[myLang.size()][3];
        int mySize = 0;
        for(Pelanggaran lang : myLang){
            dtPlgrn[mySize][0] = lang.getNama_hukuman();
            dtPlgrn[mySize][1] = lang.getTanggal();
            dtPlgrn[mySize][2] = lang.getUraian();
            
            mySize++;
            
        }
        
         TabelHukuman.setModel(new javax.swing.table.DefaultTableModel(
         /**   new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            }**/dtPlgrn,
            new String [] {
                "Nama Hukuman", "Tanggal", "Uraian",
            }
        ));
        jScrollPane2.setViewportView(TabelPrestasi);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        L_Nim = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dynamicNim = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnLogOut = new javax.swing.JLabel();
        btnPrestasi = new javax.swing.JLabel();
        btnPanitia = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnHukuman1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnReset = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        dynamicNama = new javax.swing.JLabel();
        dynamicAlamat = new javax.swing.JLabel();
        dynamicNoHp = new javax.swing.JLabel();
        dynamicAngkatan = new javax.swing.JLabel();
        dynamicEmail = new javax.swing.JLabel();
        dynamicJabatan = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        dynamicAsalSklh = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        dynamicStatus = new javax.swing.JLabel();
        pnlUtama = new javax.swing.JPanel();
        pnlPanitia = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelPanitia = new javax.swing.JTable();
        TitlePrestasi1 = new javax.swing.JLabel();
        pnlPrestasi = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelPrestasi = new javax.swing.JTable();
        TitlePrestasi = new javax.swing.JLabel();
        pnlPelanggaran = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TabelHukuman = new javax.swing.JTable();
        TitlePrestasi2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setFont(new java.awt.Font("Tempus Sans ITC", 0, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("SELAMAT DATANG DI SISTEM INFORMASI ANGGOTA HIMPUNAN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Diri"));

        L_Nim.setText("Nim :");

        jLabel2.setText("Alamat :");

        jLabel3.setText("Nomor Hp :");

        jLabel4.setText("Angkatan :");

        jLabel5.setText("Jabatan :");

        jLabel6.setText("Email :");

        dynamicNim.setText("dynamicNim");

        jLabel11.setText("Nama :");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Informasi"));

        btnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logoff.png"))); // NOI18N
        btnLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogOutMouseClicked(evt);
            }
        });

        btnPrestasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/prestasi1.png"))); // NOI18N
        btnPrestasi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrestasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrestasiMouseClicked(evt);
            }
        });

        btnPanitia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/panitia.png"))); // NOI18N
        btnPanitia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPanitia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPanitiaMouseClicked(evt);
            }
        });

        jLabel1.setText("Panitia");

        jLabel8.setText("Prestasi");

        jLabel9.setText("Pelanggaran");

        btnHukuman1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hkm.png"))); // NOI18N
        btnHukuman1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHukuman1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHukuman1MouseClicked(evt);
            }
        });

        jLabel13.setText("Exit");

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/resetpass.png"))); // NOI18N
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetMouseClicked(evt);
            }
        });

        jLabel14.setText("Reset Password");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(btnPrestasi))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(btnHukuman1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReset)
                        .addGap(48, 48, 48)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel13))
                    .addComponent(btnLogOut))
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(btnPanitia)
                    .addContainerGap(317, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnPrestasi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnHukuman1)
                                .addComponent(btnReset))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(jLabel14)))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(btnLogOut)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel13)))))
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(btnPanitia)
                    .addContainerGap(33, Short.MAX_VALUE)))
        );

        dynamicNama.setText("dynamicNama");

        dynamicAlamat.setText("dynamicAlamat");

        dynamicNoHp.setText("dynamicNoHp");

        dynamicAngkatan.setText("dynamicAngkatan");

        dynamicEmail.setText("dynamicEmail");

        dynamicJabatan.setText("dynamicJabatan");

        jLabel10.setText("Asal Sekolah :");

        dynamicAsalSklh.setText("dynamicAsalSklh");

        jLabel12.setText("Status :");

        dynamicStatus.setText("dynamicStatus");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(L_Nim)
                            .addComponent(jLabel11)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dynamicStatus)
                            .addComponent(dynamicAsalSklh)
                            .addComponent(dynamicJabatan)
                            .addComponent(dynamicAngkatan)
                            .addComponent(dynamicNoHp)
                            .addComponent(dynamicAlamat)
                            .addComponent(dynamicNama)
                            .addComponent(dynamicNim)
                            .addComponent(dynamicEmail))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(dynamicNama))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_Nim)
                    .addComponent(dynamicNim))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(dynamicAlamat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dynamicNoHp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(dynamicEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(dynamicAngkatan))
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(dynamicStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(dynamicJabatan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(dynamicAsalSklh))
                .addGap(23, 23, 23)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        pnlUtama.setLayout(new java.awt.CardLayout());

        pnlPanitia.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        TabelPanitia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama Proker", "Jabatan", "Tempat", ""
            }
        ));
        jScrollPane1.setViewportView(TabelPanitia);

        TitlePrestasi1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        TitlePrestasi1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitlePrestasi1.setText("Data Kepanitiaan Yang Pernah Diikuti Selama Dihimpunan");

        javax.swing.GroupLayout pnlPanitiaLayout = new javax.swing.GroupLayout(pnlPanitia);
        pnlPanitia.setLayout(pnlPanitiaLayout);
        pnlPanitiaLayout.setHorizontalGroup(
            pnlPanitiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TitlePrestasi1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
            .addGroup(pnlPanitiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE))
        );
        pnlPanitiaLayout.setVerticalGroup(
            pnlPanitiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPanitiaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitlePrestasi1, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                .addGap(388, 388, 388))
            .addGroup(pnlPanitiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPanitiaLayout.createSequentialGroup()
                    .addGap(0, 76, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlUtama.add(pnlPanitia, "CardPanitia");

        pnlPrestasi.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        TabelPrestasi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama Kegiatan", "Tanggal", "Uraian", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(TabelPrestasi);

        TitlePrestasi.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        TitlePrestasi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitlePrestasi.setText("Data Prestasi Yang Pernah Diraih Pada Kegiatan Himpunan");

        javax.swing.GroupLayout pnlPrestasiLayout = new javax.swing.GroupLayout(pnlPrestasi);
        pnlPrestasi.setLayout(pnlPrestasiLayout);
        pnlPrestasiLayout.setHorizontalGroup(
            pnlPrestasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
            .addComponent(TitlePrestasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlPrestasiLayout.setVerticalGroup(
            pnlPrestasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrestasiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitlePrestasi, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlUtama.add(pnlPrestasi, "CardPrestasi");

        TabelHukuman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama Kegiatan", "Tanggal", "Uraian", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(TabelHukuman);

        TitlePrestasi2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        TitlePrestasi2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitlePrestasi2.setText("Data Pelanggaran Yang Pernah Dilakukan Selama Himpunan");

        javax.swing.GroupLayout pnlPelanggaranLayout = new javax.swing.GroupLayout(pnlPelanggaran);
        pnlPelanggaran.setLayout(pnlPelanggaranLayout);
        pnlPelanggaranLayout.setHorizontalGroup(
            pnlPelanggaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
            .addComponent(TitlePrestasi2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlPelanggaranLayout.setVerticalGroup(
            pnlPelanggaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPelanggaranLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitlePrestasi2, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlUtama.add(pnlPelanggaran, "cardPelanggaran");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlUtama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlUtama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPanitiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPanitiaMouseClicked
        // TODO add your handling code here:
        cl = (CardLayout) pnlUtama.getLayout();
        cl.show(pnlUtama, "CardPanitia");
    }//GEN-LAST:event_btnPanitiaMouseClicked

    private void btnPrestasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrestasiMouseClicked
        // TODO add your handling code here:
        cl = (CardLayout) pnlUtama.getLayout();
        cl.show(pnlUtama, "CardPrestasi");
    }//GEN-LAST:event_btnPrestasiMouseClicked

    private void btnLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogOutMouseClicked
        // TODO add your handling code here:
        this.dispose();
        F_login fl = new F_login();
        fl.setVisible(true);
    }//GEN-LAST:event_btnLogOutMouseClicked

    private void btnHukuman1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHukuman1MouseClicked
        // TODO add your handling code here:
         cl = (CardLayout) pnlUtama.getLayout();
        cl.show(pnlUtama, "cardPelanggaran");
    }//GEN-LAST:event_btnHukuman1MouseClicked

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        // TODO add your handling code here:
        String nim = dynamicNim.getText();
        
        D_ResetPassword res = new D_ResetPassword(this, rootPaneCheckingEnabled, nim);
        res.setVisible(true);
    }//GEN-LAST:event_btnResetMouseClicked

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
            java.util.logging.Logger.getLogger(F_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(F_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(F_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(F_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new F_User().setVisible(true);
            }
        });
    }
private CardLayout cl;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel L_Nim;
    private javax.swing.JTable TabelHukuman;
    private javax.swing.JTable TabelPanitia;
    private javax.swing.JTable TabelPrestasi;
    private javax.swing.JLabel TitlePrestasi;
    private javax.swing.JLabel TitlePrestasi1;
    private javax.swing.JLabel TitlePrestasi2;
    private javax.swing.JLabel btnHukuman1;
    private javax.swing.JLabel btnLogOut;
    private javax.swing.JLabel btnPanitia;
    private javax.swing.JLabel btnPrestasi;
    private javax.swing.JLabel btnReset;
    private javax.swing.JLabel dynamicAlamat;
    private javax.swing.JLabel dynamicAngkatan;
    private javax.swing.JLabel dynamicAsalSklh;
    private javax.swing.JLabel dynamicEmail;
    private javax.swing.JLabel dynamicJabatan;
    private javax.swing.JLabel dynamicNama;
    private javax.swing.JLabel dynamicNim;
    private javax.swing.JLabel dynamicNoHp;
    private javax.swing.JLabel dynamicStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pnlPanitia;
    private javax.swing.JPanel pnlPelanggaran;
    private javax.swing.JPanel pnlPrestasi;
    private javax.swing.JPanel pnlUtama;
    // End of variables declaration//GEN-END:variables

   
}

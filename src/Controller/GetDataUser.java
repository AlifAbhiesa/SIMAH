/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import db.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import entitas.Adart;
import entitas.Hukuman;
import entitas.Panitia;
import entitas.Pelanggaran;
import entitas.Prestasi;

/**
 *
 * @author kausar
 */
public class GetDataUser {
    
     public ArrayList<Panitia> getAllPan(String nim){
        ArrayList<Panitia> myPan = new ArrayList<Panitia>();
        String query = "select * from tbl_panitia LEFT JOIN tbl_jabatan ON "
                + "tbl_panitia.id_jabatan = tbl_jabatan.id_jabatan LEFT JOIN "
                + "tbl_proker ON tbl_proker.id_proker = tbl_panitia.id_proker "
                + "LEFT JOIN tbl_anggota ON tbl_anggota.nim = tbl_panitia.nim  where tbl_panitia.nim='"+nim+"'";
        
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Panitia pan = new Panitia();
                pan.setJabatan(rs.getString("tbl_jabatan.nama"));
                pan.setProker(rs.getString("nama_proker"));
                pan.setTanggal(rs.getString("tanggal"));
                
               
                
                myPan.add(pan);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CmdPanitia.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return myPan;
    }
    // menyimpan data ADART
    
     public ArrayList<Prestasi> getAllPres(String nim){
        ArrayList<Prestasi> myPres = new ArrayList<Prestasi>();
        String query = "select * from tbl_prestasi LEFT JOIN tbl_kegiatan ON tbl_kegiatan.id_kegiatan = tbl_prestasi.id_kegiatan where tbl_prestasi.nim='"+nim+"'";
        
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Prestasi pres = new Prestasi();
                pres.setNama_kegiatan(rs.getString("tbl_kegiatan.nama"));
                pres.setUraian(rs.getString("tbl_prestasi.uraian"));
                pres.setTanggal(rs.getString("tbl_kegiatan.tanggal"));
                
               
                
                myPres.add(pres);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CmdPanitia.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return myPres;
        
     }
     
     public ArrayList<Pelanggaran> getAllPlgrn(String nim){
        ArrayList<Pelanggaran> myPlgrn = new ArrayList<Pelanggaran>();
        String query = "select * from tbl_pelanggaran LEFT JOIN tbl_anggota ON tbl_pelanggaran.nim = tbl_anggota.nim LEFT JOIN tbl_hukuman ON tbl_hukuman.id_hukuman = tbl_pelanggaran.id_hukuman where tbl_pelanggaran.nim='"+nim+"'";
        
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Pelanggaran lang = new Pelanggaran();
                lang.setNama_hukuman(rs.getString("tbl_hukuman.nama"));
                lang.setTanggal(rs.getDate("tbl_pelanggaran.tanggal"));
                lang.setUraian(rs.getString("tbl_hukuman.uraian"));
                
               
                
                myPlgrn.add(lang);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CmdPanitia.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return myPlgrn;
    }
    
}

  
    


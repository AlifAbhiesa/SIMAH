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
import entitas.Panitia;

/**
 *
 * @author kausar
 */
public class CmdPanitia {
    
    public ArrayList<Panitia> getAllPan(){
        ArrayList<Panitia> myPan = new ArrayList<Panitia>();
        String query = "select * from tbl_panitia LEFT JOIN tbl_jabatan ON "
                + "tbl_panitia.id_jabatan = tbl_jabatan.id_jabatan LEFT JOIN "
                + "tbl_proker ON tbl_proker.id_proker = tbl_panitia.id_proker "
                + "LEFT JOIN tbl_anggota ON tbl_anggota.nim = tbl_panitia.nim";
        
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Panitia pan = new Panitia();
                pan.setId_panitia(rs.getInt("id_panitia"));
                pan.setId_jabatan(rs.getInt("id_jabatan"));
                pan.setId_proker(rs.getInt("id_proker"));
                pan.setNim(rs.getString("nim"));
                pan.setJabatan(rs.getString("tbl_jabatan.nama"));
                pan.setProker(rs.getString("nama_proker"));
                pan.setNama_mhs(rs.getString("tbl_anggota.nama"));
                
                myPan.add(pan);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CmdPanitia.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return myPan;
    }
    // menyimpan data Panitia
    
    public int savePan(Panitia pan){
        int result = 0;
       String query = "insert into tbl_panitia(id_panitia,nim,id_proker,id_jabatan)"
                + "values("+pan.getId_panitia()+","+pan.getNim()+","+pan.getId_proker()
               +","+pan.getId_jabatan()+")";
        
        
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        
        try {
            Statement stm = conn.createStatement();
            result = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(CmdPanitia.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return result;
    }
    
    
    //update
    public int updatePan(Panitia updPan){
        String query = "update tbl_panitia set nim = '"+
                updPan.getNim()+"',id_jabatan="+updPan.getId_jabatan()+",id_proker="+updPan.getId_proker()+""
                + " where id_panitia="+updPan.getId_panitia()+"";
        int hasil = 0;
        
        ConnectionManager conMan = new ConnectionManager();
        Connection conn =conMan.logOn();
        
        try{
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);   
        } catch (SQLException ex) {
            Logger.getLogger(CmdPanitia.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    
    //delete
    
    public int deletePan(int id_panitia){
        int hasil = 0;
        String query = "delete from tbl_panitia where id_panitia = "+id_panitia+"";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn =conMan.logOn();
        
        try{
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);   
        } catch (SQLException ex) {
            Logger.getLogger(CmdPanitia.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    
}

  
    


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
import entitas.Anggota;

/**
 *
 * @author kausar
 */
public class CmdAnggota {
    
    public ArrayList<Anggota> getAllAgt(){
        ArrayList<Anggota> myAgt = new ArrayList<Anggota>();
        String query = "select * from tbl_anggota LEFT JOIN tbl_jabatan ON tbl_anggota.id_jabatan = tbl_jabatan.id_jabatan LEFT JOIN tbl_sekolah ON tbl_sekolah.id_sekolah = tbl_anggota.id_sekolah";
        
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Anggota agt = new Anggota();
                agt.setNim(rs.getString("nim"));
                agt.setNama(rs.getString("nama"));
                agt.setAlamat(rs.getString("alamat"));
                agt.setNo_hp(rs.getString("no_hp"));
                agt.setEmail(rs.getString("email"));
                agt.setAngkatan(rs.getString("angkatan"));
                agt.setStatus(rs.getString("status"));
                //dari entitas lain setelah menggunakan join
                agt.setNama_sekolah(rs.getString("tbl_sekolah.nama"));
                agt.setId_sekolah(rs.getInt("id_sekolah"));
                agt.setJabatan(rs.getString("tbl_jabatan.nama"));
                agt.setId_jabatan(rs.getInt("id_jabatan"));
                
                myAgt.add(agt);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CmdAnggota.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return myAgt;
    }
    
    public int saveAgt(Anggota agt){
        int result = 0;
       String query = "insert into tbl_anggota(nim,nama,alamat,no_hp,email,angkatan,id_sekolah,id_jabatan)"
                + "values("+agt.getNim()+",'"+agt.getNama()+"','"+agt.getAlamat()+"','"+agt.getNo_hp()
               +"','"+agt.getEmail()+"','"+agt.getAngkatan()
               +"',"+agt.getId_sekolah()+","+agt.getId_jabatan()+")";
        
        
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        
        try {
            Statement stm = conn.createStatement();
            result = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(CmdAnggota.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return result;
    }
    
    
    //update
    public int updateAgt(Anggota updAgt){
        String query = "update tbl_anggota set nim='"+updAgt.getNim()+"', nama = '"+
                updAgt.getNama()+"',alamat='"+updAgt.getAlamat()
                +"',no_hp='"+updAgt.getNo_hp()+"',email='"+updAgt.getEmail()+"',angkatan='"+updAgt.getAngkatan()
                +"',id_jabatan="+updAgt.getId_jabatan()+",id_sekolah="+updAgt.getId_sekolah()+" where nim="+updAgt.getNim()+"";
        int hasil = 0;
        
        ConnectionManager conMan = new ConnectionManager();
        Connection conn =conMan.logOn();
        
        try{
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);   
        } catch (SQLException ex) {
            Logger.getLogger(CmdAnggota.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    
     public int updateStatus(String status, String nim){
        String query = "update tbl_anggota set status='"+status+"' where nim='"+nim+"'";
        int hasil = 0;
        
        ConnectionManager conMan = new ConnectionManager();
        Connection conn =conMan.logOn();
        
        try{
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);   
        } catch (SQLException ex) {
            Logger.getLogger(CmdAnggota.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    
    //delete
    
    public int deleteAgt(String nim){
        int hasil = 0;
        String query = "delete from tbl_anggota where nim = '"+nim+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn =conMan.logOn();
        
        try{
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);   
        } catch (SQLException ex) {
            Logger.getLogger(CmdAnggota.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    
}

  
    


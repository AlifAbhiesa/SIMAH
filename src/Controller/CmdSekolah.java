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
import entitas.Sekolah;

/**
 *
 * @author kausar
 */
public class CmdSekolah {
    
    public ArrayList<Sekolah> getAllMhs(){
        ArrayList<Sekolah> mySklh = new ArrayList<Sekolah>();
        String query = "Select * from tbl_sekolah";
        
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Sekolah sklh = new Sekolah();
                sklh.setNama(rs.getString("nama"));
                sklh.setAlamat(rs.getString("alamat"));
                sklh.setNo_hp(rs.getString("no_hp"));
                sklh.setEmail(rs.getString("email"));
                sklh.setId_sekolah(rs.getInt("id_sekolah"));
                
                mySklh.add(sklh);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CmdSekolah.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return mySklh;
    }
    // menyimpan data sekolah
    public int saveSklh(Sekolah sklh){
        int result = 0;
        String query = "insert into tbl_sekolah(id_sekolah,nama,alamat,no_hp,email)"
                + "values("+sklh.getId_sekolah()+",'"+sklh.getNama()
                +"','"+sklh.getAlamat()+"','"+sklh.getNo_hp()+"','"+sklh.getEmail()+"')";
        
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        
        try {
            Statement stm = conn.createStatement();
            result = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(CmdSekolah.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return result;
    }
    
    
    //update
    public int updateSklh(Sekolah updSklh){
        String query = "update tbl_sekolah set nama='"+updSklh.getNama()+"', alamat = '"+
                updSklh.getAlamat()+"',no_hp='"+updSklh.getNo_hp()+"',email='"+updSklh.getEmail()+"' where id_sekolah='"+updSklh.getId_sekolah()+"'";
        int hasil = 0;
        
        ConnectionManager conMan = new ConnectionManager();
        Connection conn =conMan.logOn();
        
        try{
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);   
        } catch (SQLException ex) {
            Logger.getLogger(CmdSekolah.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    
    //delete
    
    public int deleteSklh(int id_sekolah){
        int hasil = 0;
        String query = "delete from tbl_sekolah where id_sekolah ="+id_sekolah+"";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn =conMan.logOn();
        
        try{
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);   
        } catch (SQLException ex) {
            Logger.getLogger(CmdSekolah.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    
}

    
    //update
   
    


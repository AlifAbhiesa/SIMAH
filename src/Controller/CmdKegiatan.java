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
import entitas.Kegiatan;

/**
 *
 * @author kausar
 */
public class CmdKegiatan {
    
    public ArrayList<Kegiatan> getAllKeg(){
        ArrayList<Kegiatan> myKeg = new ArrayList<Kegiatan>();
        String query = "Select * from tbl_kegiatan";
        
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Kegiatan keg = new Kegiatan();
                keg.setId_kegiatan(rs.getInt("id_kegiatan"));
                keg.setNama(rs.getString("nama"));
                keg.setTanggal(rs.getDate("tanggal"));
                keg.setUraian(rs.getString("uraian"));
                
                
                myKeg.add(keg);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CmdKegiatan.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return myKeg;
    }
    // menyimpan data ADART
    
    public int saveKeg(Kegiatan keg){
        int result = 0;
       String query = "insert into tbl_kegiatan(id_kegiatan,nama,tanggal,uraian)"
                + "values("+keg.getId_kegiatan()+",'"+keg.getNama()+"','"+new java.sql.Date(keg.getTanggal().getTime())+"','"+keg.getUraian()+"')";
        
        
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        
        try {
            Statement stm = conn.createStatement();
            result = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(CmdKegiatan.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return result;
    }
    
    
    //update
    public int updateKeg(Kegiatan updKeg){
        String query = "update tbl_kegiatan set nama = '"+
                updKeg.getNama()+"',tanggal='"+new java.sql.Date(updKeg.getTanggal().getTime())
                +"',uraian='"+updKeg.getUraian()+"' where id_kegiatan='"+updKeg.getId_kegiatan()+"'";
        int hasil = 0;
        
        ConnectionManager conMan = new ConnectionManager();
        Connection conn =conMan.logOn();
        
        try{
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);   
        } catch (SQLException ex) {
            Logger.getLogger(CmdKegiatan.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    
    //delete
    
    public int deleteKeg(int id_kegiatan){
        int hasil = 0;
        String query = "delete from tbl_kegiatan where id_kegiatan = '"+id_kegiatan+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn =conMan.logOn();
        
        try{
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);   
        } catch (SQLException ex) {
            Logger.getLogger(CmdKegiatan.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    
}

  
    


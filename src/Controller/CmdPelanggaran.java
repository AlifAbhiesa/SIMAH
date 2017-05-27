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
import entitas.Pelanggaran;

/**
 *
 * @author kausar
 */
public class CmdPelanggaran {
    
   
    // menyimpan data Hukuman
    public int savePlgrn(Pelanggaran plgrn){
        int result = 0;
        //query sql save
        String query = "insert into tbl_pelanggaran(id_pelanggaran,id_hukuman,nim,tanggal)"
                + "values("+plgrn.getId_pelanggaran()+",'"+plgrn.getId_hukuman()
                +"','"+plgrn.getNim()+"','"+new java.sql.Date(plgrn.getTanggal().getTime())+"')";
        //membuka koneksi ke database
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        
        //eksekusi query
        try {
            Statement stm = conn.createStatement();
            result = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(CmdPelanggaran.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return result;
    }
    
    
    //update
    public int updatePlgrn(Pelanggaran updPlgrn){
        String query = "update tbl_pelanggaran set id_pelanggaran='"+updPlgrn.getId_pelanggaran()+"', id_hukuman = '"+
                updPlgrn.getId_hukuman()+"',nim='"+updPlgrn.getNim()+"',tanggal ='"+new java.sql.Date(updPlgrn.getTanggal().getTime())+"' where id_pelanggaran="+updPlgrn.getId_pelanggaran()+"";
        int hasil = 0;
        
        ConnectionManager conMan = new ConnectionManager();
        Connection conn =conMan.logOn();
        
        try{
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);   
        } catch (SQLException ex) {
            Logger.getLogger(CmdPelanggaran.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    
    //delete
    
    public int deletePlgrn(int id_pelanggaran){
        int hasil = 0;
        String query = "delete from tbl_pelanggaran where id_pelanggaran="+id_pelanggaran+"";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn =conMan.logOn();
        
        try{
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);   
        } catch (SQLException ex) {
            Logger.getLogger(CmdPelanggaran.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    
}
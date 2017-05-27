/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import db.ConnectionManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import entitas.Prestasi;

/**
 *
 * @author kausar
 */
public class CmdPrestasi {
    
   
    // menyimpan data Hukuman
    public int savePres(Prestasi pres){
        int result = 0;
        //query sql save
        String query = "insert into tbl_prestasi(id_prestasi,nim,id_kegiatan,uraian)"
                + "values("+pres.getId_prestasi()+",'"+pres.getNim()
                +"',"+pres.getId_kegiatan()+",'"+pres.getUraian()+"')";
        //membuka koneksi ke database
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        
        //eksekusi query
        try {
            Statement stm = conn.createStatement();
            result = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(CmdPrestasi.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return result;
    }
    
    
    //update
    public int updatePres(Prestasi updPres){
        String query = "update tbl_prestasi set id_kegiatan = "+
                updPres.getId_kegiatan()+",nim='"+updPres.getNim()+"',uraian='"+updPres.getUraian()+"' where id_prestasi="+updPres.getId_prestasi()+"";
        int hasil = 0;
        
        ConnectionManager conMan = new ConnectionManager();
        Connection conn =conMan.logOn();
        
        try{
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);   
        } catch (SQLException ex) {
            Logger.getLogger(CmdPrestasi.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    
    //delete
    
    public int deletePres(int id_prestasi){
        int hasil = 0;
        String query = "delete from tbl_prestasi where id_prestasi="+id_prestasi+"";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn =conMan.logOn();
        
        try{
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);   
        } catch (SQLException ex) {
            Logger.getLogger(CmdPrestasi.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    
}
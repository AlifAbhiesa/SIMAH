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
import entitas.Hukuman;

/**
 *
 * @author kausar
 */
public class CmdHukuman {
    
    public ArrayList<Hukuman> getAllHukuman(){
        ArrayList<Hukuman> myHkmn = new ArrayList<Hukuman>();
        String query = "select * from tbl_hukuman LEFT JOIN tbl_adart ON tbl_hukuman.kode_adart = tbl_adart.kode_adart";
        
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Hukuman hkmn = new Hukuman();
                hkmn.setKode_adart(rs.getString("kode_adart"));
                hkmn.setNama(rs.getString("nama"));
                hkmn.setUraian(rs.getString("uraian"));
                hkmn.setAyat(rs.getString("ayat"));
                hkmn.setPasal(rs.getString("pasal"));
                hkmn.setId_hukuman(rs.getInt("id_hukuman"));
                
                myHkmn.add(hkmn);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CmdHukuman.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return myHkmn;
    }
    // menyimpan data Hukuman
    public int saveHkmn(Hukuman hkmn){
        int result = 0;
        //query sql save
        String query = "insert into tbl_hukuman(id_hukuman,kode_adart,nama,uraian)"
                + "values("+hkmn.getId_hukuman()+",'"+hkmn.getKode_adart()
                +"','"+hkmn.getNama()+"','"+hkmn.getUraian()+"')";
        //membuka koneksi ke database
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        
        //eksekusi query
        try {
            Statement stm = conn.createStatement();
            result = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(CmdHukuman.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return result;
    }
    
    
    //update
    public int updateHkmn(Hukuman updHkmn){
        String query = "update tbl_hukuman set kode_adart='"+updHkmn.getKode_adart()+"', nama = '"+
                updHkmn.getNama()+"',uraian='"+updHkmn.getUraian()+"' where id_hukuman="+updHkmn.getId_hukuman()+"";
        int hasil = 0;
        
        ConnectionManager conMan = new ConnectionManager();
        Connection conn =conMan.logOn();
        
        try{
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);   
        } catch (SQLException ex) {
            Logger.getLogger(CmdHukuman.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    
    //delete
    
    public int deleteHkmn(int id_hukuman){
        int hasil = 0;
        String query = "delete from tbl_hukuman where id_hukuman ="+id_hukuman+"";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn =conMan.logOn();
        
        try{
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);   
        } catch (SQLException ex) {
            Logger.getLogger(CmdHukuman.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    
}
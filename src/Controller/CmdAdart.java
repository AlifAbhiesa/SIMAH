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

/**
 *
 * @author kausar
 */
public class CmdAdart {
    
    public ArrayList<Adart> getAllAdart(){
        ArrayList<Adart> myAdart = new ArrayList<Adart>();
        String query = "Select * from tbl_adart";
        
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Adart adart = new Adart();
                adart.setKode_adart(rs.getString("kode_adart"));
                adart.setPasal(rs.getString("pasal"));
                adart.setUraian(rs.getString("uraian"));
                adart.setAyat(rs.getString("ayat"));
                
                myAdart.add(adart);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CmdAdart.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return myAdart;
    }
    // menyimpan data ADART
    
    public int saveAdart(Adart art){
        int result = 0;
       String query = "insert into tbl_adart(kode_adart,pasal,uraian,ayat)"
                + "values('"+art.getKode_adart()+"','"+art.getPasal()+"','"+art.getUraian()+"','"+art.getAyat()+"')";
        
        
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        
        try {
            Statement stm = conn.createStatement();
            result = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(CmdAdart.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return result;
    }
    
    
    //update
    public int updateAdart(Adart updArt){
        String query = "update tbl_adart set kode_adart='"+updArt.getKode_adart()+"', pasal = '"+
                updArt.getPasal()+"',uraian='"+updArt.getUraian()+"',ayat='"+updArt.getAyat()+"' where kode_adart='"+updArt.getKode_adart()+"'";
        int hasil = 0;
        
        ConnectionManager conMan = new ConnectionManager();
        Connection conn =conMan.logOn();
        
        try{
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);   
        } catch (SQLException ex) {
            Logger.getLogger(CmdAdart.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    
    //delete
    
    public int deleteAdart(String kode_adart){
        int hasil = 0;
        String query = "delete from tbl_adart where kode_adart = '"+kode_adart+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn =conMan.logOn();
        
        try{
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);   
        } catch (SQLException ex) {
            Logger.getLogger(CmdAdart.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    
}

  
    


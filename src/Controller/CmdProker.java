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
import entitas.Proker;

/**
 *
 * @author kausar
 */
public class CmdProker {
    
    public ArrayList<Proker> getAllPrkr(){
        ArrayList<Proker> myPrkr = new ArrayList<Proker>();
        String query = "Select * from tbl_proker";
        
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Proker prkr = new Proker();
                prkr.setNama_proker(rs.getString("nama_proker"));
                prkr.setTujuan(rs.getString("tujuan"));
                prkr.setTempat(rs.getString("tempat"));
                prkr.setAnggaran(rs.getInt("anggaran"));
                prkr.setId_proker(rs.getInt("id_proker"));
                prkr.setTanggal(rs.getDate("tanggal"));
                prkr.setStatus(rs.getString("status"));
                
                myPrkr.add(prkr);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CmdProker.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return myPrkr;
    }
    // menyimpan data sekolah
    public int savePrkr(Proker prkr){
        int result = 0;
        String query = "insert into tbl_proker(id_proker,nama_proker,tujuan,tempat,anggaran,tanggal,status,periode)"
                + "values("+prkr.getId_proker()+",'"+prkr.getNama_proker()
                +"','"+prkr.getTujuan()+"','"+prkr.getTempat()+"',"+prkr.getAnggaran()+",'"
                +new java.sql.Date(prkr.getTanggal().getTime())+"','"+prkr.getStatus()+"','"+prkr.getPeriode()+"')";
        
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        
        try {
            Statement stm = conn.createStatement();
            result = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(CmdProker.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return result;
    }
    
    
    //update
    public int updatePrkr(Proker updPrkr){
        String query = "update tbl_proker set nama_proker='"+updPrkr.getNama_proker()+"', tujuan = '"+
                updPrkr.getTujuan()+"',tempat='"+updPrkr.getTempat()
                +"',anggaran="+updPrkr.getAnggaran()+", tanggal='"+new java.sql.Date(updPrkr.getTanggal().getTime())+"',status='"+updPrkr.getStatus()+"',periode='"+updPrkr.getPeriode()+"' where id_proker ='"+updPrkr.getId_proker()+"'";
        int hasil = 0;
        
        ConnectionManager conMan = new ConnectionManager();
        Connection conn =conMan.logOn();
        
        try{
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);   
        } catch (SQLException ex) {
            Logger.getLogger(CmdProker.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    
    //delete
    
    public int deletePrkr(int id_proker){
        int hasil = 0;
        String query = "delete from tbl_proker where id_proker ="+id_proker+"";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn =conMan.logOn();
        
        try{
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);   
        } catch (SQLException ex) {
            Logger.getLogger(CmdProker.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    
}

    
    //update
   
    


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
import entitas.Jabatan;

/**
 *
 * @author kausar
 */
public class CmdJabatan {
    
    public ArrayList<Jabatan> getAllJbtn(){
        ArrayList<Jabatan> myJbtn = new ArrayList<Jabatan>();
        String query = "Select * from tbl_jabatan";
        
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Jabatan jbtn = new Jabatan();
                jbtn.setId_jabatan(rs.getInt("id_jabatan"));
                jbtn.setNama(rs.getString("nama"));
                jbtn.setJobdesc(rs.getString("jobdesc"));
                jbtn.setPeriode(rs.getString("periode"));
                jbtn.setStatus(rs.getString("status"));
                
                myJbtn.add(jbtn);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CmdJabatan.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return myJbtn;
    }
    // menyimpan data ADART
    
    public int saveJabatan(Jabatan jbtn){
        int result = 0;
       String query = "insert into tbl_jabatan(id_jabatan,nama,jobdesc,periode,status)"
                + "values("+jbtn.getId_jabatan()+",'"+jbtn.getNama()+"','"+jbtn.getJobdesc()+"','"+jbtn.getPeriode()+"','"+jbtn.getStatus()+"')";
        
        
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        
        try {
            Statement stm = conn.createStatement();
            result = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(CmdJabatan.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return result;
    }
    
    
    //update
    public int updateJabatan(Jabatan updJbtn){
        String query = "update tbl_jabatan set nama='"+updJbtn.getNama()+"', jobdesc = '"+
                updJbtn.getJobdesc()+"',periode='"+updJbtn.getPeriode()
                +"',status='"+updJbtn.getStatus()+"' where id_jabatan="+updJbtn.getId_jabatan()+"";
        int hasil = 0;
        
        ConnectionManager conMan = new ConnectionManager();
        Connection conn =conMan.logOn();
        
        try{
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);   
        } catch (SQLException ex) {
            Logger.getLogger(CmdJabatan.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    
    //delete
    
    public int deleteJabatan(int id_jabatan){
        int hasil = 0;
        String query = "delete from tbl_jabatan where id_jabatan = '"+id_jabatan+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn =conMan.logOn();
        
        try{
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);   
        } catch (SQLException ex) {
            Logger.getLogger(CmdJabatan.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    
}

  
    


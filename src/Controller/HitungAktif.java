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
import javax.swing.JOptionPane;

/**
 *
 * @author kausar
 */
public class HitungAktif {
    private int hasil;
    private String status;
    
    
    public String hitung(String nim, String angkatan){
        ConnectionManager conMan=new ConnectionManager();
        Connection conn= conMan.logOn();  
            try {  
                String sql = "select * from tbl_proker where status ='Sudah Terlaksana' and periode = '"+angkatan+"'";  
                String sql1 = "select * from tbl_proker LEFT JOIN tbl_panitia ON tbl_panitia.id_proker = tbl_proker.id_proker where status ='Sudah Terlaksana' and tbl_proker.periode = '"+angkatan+"' and nim ='"+nim+"'";  
                Statement st = conn.createStatement();  
                ResultSet rs = st.executeQuery(sql);  
                rs.next();
                rs.last();
                int bagi = rs.getRow();
               
                
                Statement st1 = conn.createStatement();  
                ResultSet rs1 = st1.executeQuery(sql1);  
                rs1.next();
                rs1.last();
                int jml = rs1.getRow();
                hasil = 0;
                if(bagi > 0){
                hasil = (jml*100)/bagi;
                }else{
                    hasil = 60;
                }
                if(hasil <= 0){
                    status = "Pasif Sekali";
                }else if(hasil > 0 && hasil < 60){
                    status = "Pasif";
                }else if(hasil >= 60){
                    status = "Aktif";
                }         
    }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error");
    }
        return status;
    
    }
    

}

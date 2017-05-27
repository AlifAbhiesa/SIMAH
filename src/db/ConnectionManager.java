/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author kausar
 */
public class ConnectionManager {
    private Connection con;
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/simah";
    private String username = "root";
    private String password="";
    
    
    public Connection logOn(){
        try{
        Class.forName( driver ).newInstance();
        
        con = DriverManager.getConnection(url,username,password);
    }
    
    catch(Exception ex){
        ex.printStackTrace();
}
        return con;
}
    
    
    public void logOff(){
        try{
            con.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supply.chain.manageement.system;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.sql.Connection;
import java.util.logging.Logger;
/**
 *
 * @author ADITYA
 */
public class DBConnection {
    
    public Connection con;
    String url= "jdbc:mysql://localhost:3306/supplychainmanagement";
    String db="supplychainmanagement";
    String user = "root";
    String pass="Aditya@2002";
    
    public Connection mkDataBase() throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
        } catch (Exception ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE,null,ex);
           
        }
        return con;
    }
    
    
    
    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem;
import java.sql.*;

/**
 *
 * @author Zeynep
 */
public class ConnectionProvider {
    Connection con;
    public static Connection getCon()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
            return con;
        }  
        catch (Exception e)
        {
            return null;
        }
           
    }
    
}
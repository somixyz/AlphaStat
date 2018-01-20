/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Milos Dragovic
 */
public class JavaDBConnect {

    private static Connection connection = null;
     
    public static Connection dbConnect(){
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:alphastat.sqlite");
            return connection;
        } 
        catch (ClassNotFoundException | SQLException e) {
            System.out.println("JAVA DB CONNECTION");
            JOptionPane.showMessageDialog(null, e); 
            return null;
        }
    }
    
}

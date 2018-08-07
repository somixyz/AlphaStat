/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

import form.AlphaStatMain;
import form.LoginFrm;
import java.awt.HeadlessException;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Milos Dragovic
 */
public class LoginEvent extends LoginFrm implements KeyListener {
    private javax.swing.JTextField txtUserName;
    private javax.swing.JPasswordField txtPassword;
    private Connection connection = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    
    public LoginEvent(javax.swing.JTextField txtUserName , javax.swing.JPasswordField txtPassword, Connection connection) {
        this.txtUserName = txtUserName;
        this.txtPassword = txtPassword;
        this.connection = connection;
    }
 
    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            String sql = "select * from Log_in where user_name = ? and password = ?" ;
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, txtUserName.getText());
            pst.setString(2, txtPassword.getText());
            
            rs = pst.executeQuery();
            if(rs.next()){
                close();
                AlphaStatMain obj = new AlphaStatMain();
                obj.setVisible(true);
                
                try {
                    rs.close();
                    pst.close();
                    connection.close();
                } catch (Exception e1) { 
                    JOptionPane.showMessageDialog(rootPane, e1);
                }
            }else { 
                JOptionPane.showMessageDialog(rootPane, "UserName/Password is incorrect");
            }
        } catch (SQLException | HeadlessException e2) {
            JOptionPane.showMessageDialog(rootPane, e2);
        }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package event;

import db_connect.JavaDBConnect;
import form.AlphaStatMain;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTextField;

/**
 *
 * @author Milos Dragovic
 */
public class SearchEvent extends AlphaStatMain implements FocusListener,KeyListener{
    private Connection connection = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private JTextField txtSearch ;
    
    public SearchEvent(JTextField txtSearch){
        this.txtSearch = txtSearch;
        connection = JavaDBConnect.dbConnect();
    } 
    @Override
    public void focusGained(FocusEvent e) {
        txtSearch.setText("");   
    } 
    @Override
    public void focusLost(FocusEvent e) {
        txtSearch.setText("Search");
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        String sql = "select * from Student_info where Student_id=?";
            try {
                pst = connection.prepareStatement(sql);
                pst.setString(1, txtSearch.getText());
                rs = pst.executeQuery();
                if(rs.next()){
                    getValue();
                }
                else{
                setClearValue();
                }
            } catch (Exception ex) {
            }
    }
}

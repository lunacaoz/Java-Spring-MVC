/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Impl;

import Dao.UserDao;
import Driver.ConnectMySQL;
import Model.User;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ACER
 */
public class UserImpl implements UserDao {
    Connection con = ConnectMySQL.getConnection();
    @Override
    public User find(String email,String pass)
    {
        String sql;
        try {
            if(email.contains("@")) 
            sql = "select*from usser where email='"+email+"' and pass = '"+pass+"'";
        else{
            sql = "select*from usser where sdt='"+email+"' and pass = '"+pass+"'";
        }
        PreparedStatement sttm = con.prepareStatement(sql);
        ResultSet rs = sttm.executeQuery();
        if(rs.next()) return new User(rs);
        } catch (SQLException ex) {
            Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insertUsser(String full_name, String email,String sdt,String pass) {
        String sql = "INSERT INTO `sneaker`.`usser` (`full_name`, `email`, `sdt`, `pass`, `admin`) "
                + "VALUES (N?,?,?, N?, 0);";
        try {
            PreparedStatement sttm = con.prepareStatement(sql);
            sttm.setString(1, full_name);
            sttm.setString(2, email);
            sttm.setString(3, sdt);
            sttm.setString(4, pass);
            sttm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

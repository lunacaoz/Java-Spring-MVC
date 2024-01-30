/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Impl;

import Dao.OderDao;
import Driver.ConnectMySQL;
import Model.Oder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class OderImpl implements OderDao {
    Connection con = ConnectMySQL.getConnection();
    @Override
    public void insert_oder(Oder user_oder) {
        String sql = "INSERT INTO `sneaker`.`oder` "
                + "(`user_id`, `place`, `type_cart`, `user_cart`, `phone_cart`, `expir_cart`, `cvv`, `product_sz_sl_id`, `sl`) "
                + "VALUES (?, ?,?,?,?,?,?,?,?);";
             PreparedStatement sttm;
             
        try {
            sttm = con.prepareStatement(sql);
            sttm.setInt(1, user_oder.getUser_id());
            sttm.setString(2, user_oder.getPlace());
            sttm.setString(3, user_oder.getType_cart());
            sttm.setString(4, user_oder.getUser_cart());
            sttm.setString(5, user_oder.getPhone_cart());
            sttm.setInt(6, user_oder.getExpir_cart());
            sttm.setInt(7, user_oder.getCvv());
            sttm.setInt(8, user_oder.getProduct_sz_sl_id());
            sttm.setInt(9, user_oder.getSl());
            sttm.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(OderImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
             
    }

    @Override
    public List<Oder> showall() {
        String sql = "SELECT * FROM sneaker.oder;";
        List<Oder> listOder = new ArrayList<>();
        try {
            PreparedStatement sttm = con.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            while(rs.next()){
                int user_id = rs.getInt("user_id");
                int expir_cart = rs.getInt("expir_cart");
                int cvv = rs.getInt("cvv");
                int product_sz_sl_id = rs.getInt("product_sz_sl_id");
                int sl = rs.getInt("sl");
                String place = rs.getString("place");
                String type_cart = rs.getString("type_cart");
                String user_cart = rs.getString("user_cart");
                String phone_cart = rs.getString("phone_cart");
                listOder.add(new Oder(user_id, place, type_cart, user_cart, phone_cart, expir_cart, cvv, product_sz_sl_id, sl));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OderImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listOder;
    }
    
}

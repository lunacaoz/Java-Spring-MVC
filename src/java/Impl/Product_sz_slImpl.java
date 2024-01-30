/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Impl;

import Dao.Product_sz_slDao;
import Driver.ConnectMySQL;
import Model.Product_sz_sl;
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
public class Product_sz_slImpl implements Product_sz_slDao {
    Connection con = ConnectMySQL.getConnection();
    String sql = "SELECT * FROM sneaker.product_sz_sl;";
    List<Product_sz_sl> listProduct_sz_sl= new ArrayList<>();
    @Override
    public List<Product_sz_sl> showall(){
        try {
            PreparedStatement sttm = con.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            while(rs.next()){
                int product_sz_sl_id = rs.getInt("product_sz_sl_id");
                int sl = rs.getInt("sl");
                int sz=rs.getInt("sz");
                int product_color_id = rs.getInt("product_color_id");
                listProduct_sz_sl.add(new Product_sz_sl(product_sz_sl_id,sl,sz,product_color_id));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Product_sz_slImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listProduct_sz_sl;
    }
}

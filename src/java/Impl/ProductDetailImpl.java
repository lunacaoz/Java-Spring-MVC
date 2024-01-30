/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Impl;

import Driver.ConnectMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Dao.ProductDetailDao;
import Model.Product_Detail;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class ProductDetailImpl implements ProductDetailDao {

    List<Product_Detail> listProduct_Detail = new ArrayList<>();
    @Override
     public List<Product_Detail> showProductDetail(int Product_id){
    Connection con = ConnectMySQL.getConnection();
        PreparedStatement sttm;
        try {
                String sql = "select product.product_id, product.img, product.chatlieu,product.year_sx,product.baohanh,xuatsu,product_color.img_color,product_color.product_color_id\n" +
                "from product \n" +
                "inner join product_color \n" +
                "on product.product_id = product_color.product_id\n" +
                "where product.product_id= ?";
            sttm = con.prepareStatement(sql);
            sttm.setInt(1, Product_id);
            ResultSet rs = sttm.executeQuery();
            while(rs.next()){
                int product_id = rs.getInt("product_id");
                String img = rs.getString("img");
                String chatlieu = rs.getString("chatlieu");
                int year_sx = rs.getInt("year_sx");
                int baohanh = rs.getInt("baohanh");
                String xuatsu = rs.getString("xuatsu");
                String img_color = rs.getString("img_color");
                int product_color_id = rs.getInt("product_color_id");
                listProduct_Detail.add(new Product_Detail(product_id, img, chatlieu, year_sx, baohanh, xuatsu, img_color,product_color_id));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDetailImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listProduct_Detail;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Impl;

import Dao.ProductDao;
import Driver.ConnectMySQL;
import Model.Product;
import Model.Size;
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
public class ProductImpl implements ProductDao {
    @Override
    public List<Product> showall(){
        Connection con = ConnectMySQL.getConnection();
        String sql ;
        List<Product> listProduct = new ArrayList<>();
        sql ="SELECT * FROM sneaker.product;";
        PreparedStatement sttm;
        try {
            sttm = con.prepareStatement(sql);
             ResultSet rs = sttm.executeQuery();
            while(rs.next()){
                int id = rs.getInt("product_id");
                String name = rs.getString("product_name");
                String chatlieu = rs.getString("chatlieu");
                int year = rs.getInt("year_sx");
                String xs = rs.getString("xuatsu");
                int baohanh = rs.getInt("baohanh");
                int price = rs.getInt("price");
                String img = rs.getString("img");
                int brand_id = rs.getInt("brand_id");
                listProduct.add(new Product(id,name,chatlieu,year,xs,baohanh,price,img,brand_id));
               }
        } catch (SQLException ex) {
            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listProduct;
    }
    @Override
    public List<Product> findname(String namefind){
        Connection con = ConnectMySQL.getConnection();
        String sql ;
        List<Product> listProduct = new ArrayList<>();
        sql ="SELECT * FROM sneaker.product";
        PreparedStatement sttm;
        try {
            sttm = con.prepareStatement(sql);
             ResultSet rs = sttm.executeQuery();
            while(rs.next()){
                    if(namefind.toLowerCase().contains((rs.getString("product_name")))){
                        int id = rs.getInt("product_id");
                        String name = rs.getString("product_name");
                        String chatlieu = rs.getString("chatlieu");
                        int year = rs.getInt("year_sx");
                        String xs = rs.getString("xuatsu");
                        int baohanh = rs.getInt("baohanh");
                        int price = rs.getInt("price");
                        String img = rs.getString("img");
                        int brand_id = rs.getInt("brand_id");
                        listProduct.add(new Product(id,name,chatlieu,year,xs,baohanh,price,img,brand_id));
                   }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listProduct;
    }

    @Override
    public List<Size> showsize(int product_color_id) {
        Connection con = ConnectMySQL.getConnection();
        String sql ;
        List<Size> listSize = new ArrayList<>();
        sql ="SELECT * FROM sneaker.product_sz_sl where product_color_id="+product_color_id;
        try {
            PreparedStatement sttm = con.prepareStatement(sql);
            ResultSet rs =  sttm.executeQuery();
            while(rs.next()){
                int product_sz_sl_id = rs.getInt("product_sz_sl_id");
                int sz = rs.getInt("sz");
                int sl = rs.getInt("sl");
                listSize.add(new Size(product_sz_sl_id,product_color_id, sz, sl));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSize;
    }

    @Override
    public void insert(Product product) {
    String selectQuery = "SELECT * FROM product WHERE product_name = ?";
    String insertQuery = "INSERT INTO product (product_name, chatlieu, year_sx, xuatsu, baohanh, price, img, brand_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection con = ConnectMySQL.getConnection();
         PreparedStatement selectStmt = con.prepareStatement(selectQuery);
         PreparedStatement insertStmt = con.prepareStatement(insertQuery)) {

        // Check if product exists
        selectStmt.setString(1, product.getProduct_name().toLowerCase());
        ResultSet rs = selectStmt.executeQuery();

        if (!rs.next()) {
            // Insert the product if it doesn't exist
            insertStmt.setString(1, product.getProduct_name());
            insertStmt.setString(2, product.getChatlieu());
            insertStmt.setInt(3, product.getYear_sx());
            insertStmt.setString(4, product.getXuatsu());
            insertStmt.setInt(5, product.getBaohanh());
            insertStmt.setInt(6, product.getPrice());
            insertStmt.setString(7, "./inc/img/" + product.getImg());
            insertStmt.setInt(8, product.getBrand_id());
            insertStmt.executeUpdate();
        }
    } catch (SQLException ex) {
        Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        // Consider rethrowing the exception or handling it in a user-friendly manner
    }
}


    @Override
    public void updatePrice(int id_product, int price,String name) {
        Connection con = ConnectMySQL.getConnection();
        String sql = "UPDATE `sneaker`.`product` SET price = ?,product_name=? WHERE product_id = ?;";
        try {
            PreparedStatement sttm = con.prepareStatement(sql);
            sttm.setInt(1, price);
            sttm.setString(2, name);
            sttm.setInt(3, id_product);
            sttm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Impl;

import Dao.CartDao;
import Driver.ConnectMySQL;
import Model.Cart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class CartImpl implements CartDao {
     Connection con = ConnectMySQL.getConnection();
        List<Cart> listCart = new ArrayList<>();
     @Override
        public List<Cart> showall(int id_user){
         try {
             String sql = "SELECT \n" +
"    c.id_user,\n" +
"    pc.img_color AS img,\n" +
"    p.product_name,\n" +
"    psz.sz,\n" +
"    c.sl,\n" +
"    pc.color,\n" +
"    p.price\n" +
"FROM \n" +
"    cart c\n" +
"JOIN \n" +
"    product_sz_sl psz ON c.product_sz_sl_id = psz.product_sz_sl_id\n" +
"JOIN \n" +
"    product_color pc ON psz.product_color_id = pc.product_color_id\n" +
"JOIN \n" +
"    product p ON pc.product_id = p.product_id\n" +
"WHERE \n" +
"    c.id_user ="+id_user;
             PreparedStatement sttm = con.prepareStatement(sql);
             ResultSet rs = sttm.executeQuery();
             while(rs.next()){
                 if(id_user ==rs.getInt("id_user")){
                    String img = rs.getString("img");
                    String product_name = rs.getString("product_name");
                    int sz= rs.getInt("sz");
                    String color = rs.getString("color");
                    int sl = rs.getInt("sl");
                    int price = rs.getInt("price");
                    listCart.add(new Cart(id_user, img, product_name, sz, color, sl, price));
                 }
                 
             }
         } catch (SQLException ex) {
             Logger.getLogger(CartImpl.class.getName()).log(Level.SEVERE, null, ex);
         }
         return listCart;
     }
    
     @Override
    public void EmpityCart(int id_user){
        String sql ="delete from cart\n" +
                    "where id_user=?";
         try {
             PreparedStatement sttm = con.prepareStatement(sql);
             sttm.setInt(1, id_user);
             sttm.executeUpdate();
             
         } catch (SQLException ex) {
             Logger.getLogger(CartImpl.class.getName()).log(Level.SEVERE, null, ex);
         }
         
    }

    @Override
    public void One_delete(int id_user, int produc_sz_sl) {
        String sql ="delete from cart\n" +
                     "where id_user = ? and product_sz_sl_id = ?";
         try {
             PreparedStatement sttm = con.prepareStatement(sql);
             sttm.setInt(1, id_user);
             sttm.setInt(2, produc_sz_sl);
             
         } catch (SQLException ex) {
             Logger.getLogger(CartImpl.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @Override
public void add_cart(int id_user, int product_sz_sl_id) {
    // Câu lệnh SQL để kiểm tra người dùng và sản phẩm đã tồn tại trong giỏ hàng chưa
    String sql_select = "SELECT * FROM cart WHERE id_user = " + id_user + " AND product_sz_sl_id = " + product_sz_sl_id;
    try {
        // Chuẩn bị và thực thi câu lệnh SQL select
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql_select);

        // Kiểm tra nếu sản phẩm đã tồn tại, cập nhật số lượng
        if(rs.next()){
            String sql_update = "UPDATE cart SET sl = sl + 1 WHERE id_user = " + id_user + " AND product_sz_sl_id = " + product_sz_sl_id;
            stmt.executeUpdate(sql_update);
        }
        // Nếu không tồn tại, thêm mới vào giỏ hàng
        else{
            String sql_insert = "INSERT INTO `sneaker`.`cart` (`id_user`, `product_sz_sl_id`, `sl`) VALUES (" + id_user + ", " + product_sz_sl_id + ", 1)";
            stmt.executeUpdate(sql_insert);
        }
    } catch (SQLException ex) {
        Logger.getLogger(CartImpl.class.getName()).log(Level.SEVERE, null, ex);
    } 
}
}


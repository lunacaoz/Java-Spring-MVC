/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ACER
 */
public class Oder {
    private int user_id ,expir_cart,cvv,product_sz_sl_id,sl;
    private String place,type_cart,user_cart,phone_cart;
    public Oder(int user_id, String place, String type_cart,String user_cart, String phone_cart, int expir_cart, int cvv, int product_sz_sl_id, int sl) {
        this.user_id = user_id;
        this.expir_cart = expir_cart;
        this.cvv = cvv;
        this.product_sz_sl_id = product_sz_sl_id;
        this.sl = sl;
        this.place = place;
        this.type_cart = type_cart;
        this.user_cart = user_cart;
        this.phone_cart = phone_cart;
    }
    public Oder(ResultSet rs) throws SQLException{
        this.user_id = rs.getInt("user_id");
        this.expir_cart = rs.getInt("expir_cart");
        this.cvv = rs.getInt("cvv");
        this.product_sz_sl_id = rs.getInt("product_sz_sl_id");
        this.sl = rs.getInt("sl");
        this.place = rs.getString("place");
        this.type_cart = rs.getString("type_cart");
        this.user_cart = rs.getString("user_cart");
        this.phone_cart = rs.getString("phone_cart");
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getExpir_cart() {
        return expir_cart;
    }

    public void setExpir_cart(int expir_cart) {
        this.expir_cart = expir_cart;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getProduct_sz_sl_id() {
        return product_sz_sl_id;
    }

    public void setProduct_sz_sl_id(int product_sz_sl_id) {
        this.product_sz_sl_id = product_sz_sl_id;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getType_cart() {
        return type_cart;
    }

    public void setType_cart(String type_cart) {
        this.type_cart = type_cart;
    }

    public String getUser_cart() {
        return user_cart;
    }

    public void setUser_cart(String user_cart) {
        this.user_cart = user_cart;
    }

    public String getPhone_cart() {
        return phone_cart;
    }

    public void setPhone_cart(String phone_cart) {
        this.phone_cart = phone_cart;
    }
}

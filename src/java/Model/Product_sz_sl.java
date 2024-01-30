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
public class Product_sz_sl {
   private int product_sz_sl_id;
   private int sl;
   private int sz;
   int product_color_id;

    public Product_sz_sl(int product_sz_sl_id, int sl, int sz, int product_color_id) {
        this.product_sz_sl_id = product_sz_sl_id;
        this.sl = sl;
        this.sz = sz;
        this.product_color_id = product_color_id;
    }
    public Product_sz_sl(ResultSet rs) throws SQLException{
        this.product_sz_sl_id = rs.getInt("product_sz_sl_id");
        this.sl = rs.getInt("sl");
        this.sz = rs.getInt("sz");
        this.product_color_id = rs.getInt("product_color_id");
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

    public int getSz() {
        return sz;
    }

    public void setSz(int sz) {
        this.sz = sz;
    }

    public int getProduct_color_id() {
        return product_color_id;
    }

    public void setProduct_color_id(int product_color_id) {
        this.product_color_id = product_color_id;
    }
   
}

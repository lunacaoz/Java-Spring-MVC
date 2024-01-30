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
public class Size {
    private int product_sz_sl_id;
    private int product_color_id;
    private int sz;
    private int sl;

    public Size(int product_sz_sl_id,int product_color_id, int sz, int sl) {
        this.product_sz_sl_id = product_sz_sl_id;
        this.product_color_id = product_color_id;
        this.sz = sz;
        this.sl = sl;
    }
     public Size(ResultSet rs) throws SQLException{
         this.product_sz_sl_id = rs.getInt("product_sz_sl_id");
        this.product_color_id = rs.getInt("product_color_id");
        this.sz = rs.getInt("sz");
        this.sl = rs.getInt("sl");
    }

    public int getProduct_sz_sl_id() {
        return product_sz_sl_id;
    }

    public void setProduct_sz_sl_id(int product_sz_sl_id) {
        this.product_sz_sl_id = product_sz_sl_id;
    }

    public int getProduct_color_id() {
        return product_color_id;
    }

    public void setProduct_color_id(int product_color_id) {
        this.product_color_id = product_color_id;
    }

    public int getSz() {
        return sz;
    }

    public void setSz(int sz) {
        this.sz = sz;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }
    
}

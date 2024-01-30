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
public class Product_Detail {
    private int product_id;
    private String img;
    private String chatlieu;
    private int year_sx;
    private int baohanh;
    private String xuatsu;
    private String img_color;
    private int product_color_id;
    public Product_Detail(ResultSet rs) throws SQLException{
            this.product_id = rs.getInt("product_id");
            this.img = rs.getString("img");
            this.chatlieu = rs.getString("chatlieu");
            this.year_sx = rs.getInt("year_sx");
            this.baohanh = rs.getInt("baohanh");
            this.xuatsu = rs.getString("xuatsu");
            this.img_color = rs.getString("img_color");
            this.product_color_id = rs.getInt("product_color_id");
        }
    public Product_Detail(int product_id, String img, String chatlieu, int year_sx, int baohanh, String xuatsu, String img_color,int product_color_id) {
        this.product_id = product_id;
        this.img = img;
        this.chatlieu = chatlieu;
        this.year_sx = year_sx;
        this.baohanh = baohanh;
        this.xuatsu = xuatsu;
        this.img_color = img_color;
        this.product_color_id = product_color_id;
        
        
    }
    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getChatlieu() {
        return chatlieu;
    }

    public void setChatlieu(String chatlieu) {
        this.chatlieu = chatlieu;
    }

    public int getYear_sx() {
        return year_sx;
    }

    public void setYear_sx(int year_sx) {
        this.year_sx = year_sx;
    }

    public int getBaohanh() {
        return baohanh;
    }

    public void setBaohanh(int baohanh) {
        this.baohanh = baohanh;
    }

    public String getXuatsu() {
        return xuatsu;
    }

    public void setXuatsu(String xuatsu) {
        this.xuatsu = xuatsu;
    }

    public String getColor_img() {
        return img_color;
    }

    public void setColor_img(String color_img) {
        this.img_color = color_img;
    }
     public int getProduct_color_id() {
        return product_color_id;
    }

    public void setProduct_color_id(int product_color_id) {
        this.product_color_id = product_color_id;
    }
}

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
public class Product {
    private int product_id;
    private String product_name;
    private String chatlieu;
    private int year_sx ;
    private String xuatsu;
    private int baohanh;
    private int price;
    private String img;
    private int brand_id;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
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

    public String getXuatsu() {
        return xuatsu;
    }

    public void setXuatsu(String xuatsu) {
        this.xuatsu = xuatsu;
    }

    public int getBaohanh() {
        return baohanh;
    }

    public void setBaohanh(int baohanh) {
        this.baohanh = baohanh;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public Product(int product_id, String product_name, String chatlieu, int year_sx, String xuatsu, int baohanh, int price, String img, int brand_id) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.chatlieu = chatlieu;
        this.year_sx = year_sx;
        this.xuatsu = xuatsu;
        this.baohanh = baohanh;
        this.price = price;
        this.img = img;
        this.brand_id = brand_id;
    }
    public Product(ResultSet rs) throws SQLException{
        this.product_id = rs.getInt("product_id");
        this.product_name = rs.getString("product_name");
        this.chatlieu = rs.getString("chatlieu");
        this.year_sx = rs.getInt("year_sx");
        this.xuatsu = rs.getString("xuatsu");
        this.baohanh = rs.getInt("baohanh");
        this.price = rs.getInt("price");
        this.img = rs.getString("img");
        this.brand_id = rs.getInt("brand_id");
    }
    
}

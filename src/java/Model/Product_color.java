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
public class Product_color {
    private int product_color_id;
    private String color;
    private String img;
    private int product_id;

    public int getProduct_color_id() {
        return product_color_id;
    }

    public void setProduct_color_id(int product_color_id) {
        this.product_color_id = product_color_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Product_color(int product_color_id, String color, String img,int product_id) {
        this.product_color_id = product_color_id;
        this.product_id = product_id;
        this.color = color;
        this.img = img;
    }
    public Product_color(ResultSet rs )  throws SQLException{
        this.product_color_id = rs.getInt("product_color_id");
        this.color = rs.getString("color");
        this.img = rs.getString("img");
        this.product_id = rs.getInt("product_id");
    }
}

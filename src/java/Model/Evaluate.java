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
public class Evaluate {
    private int star_id;
    private int id_user;
    private int star;
    private int product_id;

    public Evaluate(int star_id, int id_user, int star, int product_id) {
        this.star_id = star_id;
        this.id_user = id_user;
        this.star = star;
        this.product_id = product_id;
    }
    public Evaluate(ResultSet rs) throws SQLException{
        this.star_id = rs.getInt("star_id");
        this.id_user = rs.getInt("id_user");
        this.star = rs.getInt("star");
        this.product_id = rs.getInt("product_id");
    }
    public int getStar_id() {
        return star_id;
    }

    public void setStar_id(int star_id) {
        this.star_id = star_id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
}

package Model;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private int id_user;
    private String full_name;
    private String email;
    private String sdt;
    private String pass;
    private String admin;

    public User(ResultSet rs) throws SQLException {
        this.id_user = rs.getInt("id_user");
        this.full_name = rs.getString("full_name");
        this.email = rs.getString("email");
        this.sdt = rs.getString("sdt");
        this.pass = rs.getString("pass");
        this.admin = rs.getString("admin");
    }

    // Các phương thức khác của lớp User
    public User(int id_user, String full_name, String email, String sdt, String pass, String admin) {
        this.id_user = id_user;
        this.full_name = full_name;
        this.email = email;
        this.sdt = sdt;
        this.pass = pass;
        this.admin = admin;
    }
    
    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }


    
    
}

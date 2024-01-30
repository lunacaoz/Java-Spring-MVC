/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Impl;

import Dao.BrandDao;
import Driver.ConnectMySQL;
import Model.Brand;
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
public class BrandImpl implements BrandDao {
    @Override
    public List<Brand> showall(){
        Connection con = ConnectMySQL.getConnection();
        String sql = "SELECT * FROM sneaker.brand;";
        List<Brand> listBrand = new ArrayList<Brand>();
        try {
            PreparedStatement sttm = con.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            while(rs.next()){
                int id = rs.getInt("brand_id");
                String name = rs.getString("brand_name");
                listBrand.add(new Brand(id,name));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BrandImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listBrand;
        }
    }

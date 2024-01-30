/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import Model.Product_Detail;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface ProductDetailDao {
    public List<Product_Detail> showProductDetail(int Product_id);
    
}

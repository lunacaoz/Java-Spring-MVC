/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Product;
import Model.Size;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface ProductDao {
    public List<Product> showall();
    public List<Product> findname(String namefind);
    public List<Size> showsize( int product_color_id);
    public void insert(Product product);
    public void updatePrice(int id_product , int price,String name);
}

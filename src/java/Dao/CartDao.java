/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import Model.Cart;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface CartDao {
    public List<Cart> showall(int id_user);
    public void EmpityCart(int id_user);
    public void One_delete(int id_user,int product_sz_sl_id);
    public void add_cart(int id_user,int product_sz_sl_id);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Impl.BrandImpl;
import Impl.CartImpl;
import Impl.OderImpl;
import Impl.ProductImpl;
import Impl.ProductDetailImpl;
import Impl.Product_sz_slImpl;
import Impl.UserImpl;

/**
 *
 * @author ACER
 */
public class Database {
    public static UserDao getUserDao(){
        return new UserImpl();
    }
    public static BrandDao getBranDao() {
        return new BrandImpl();
    }
    public static ProductDao getProduct(){
        return new ProductImpl();
    }
    public static ProductDetailDao getProduct_color(){
        return new ProductDetailImpl();
    }
    public  static CartDao getCart(){
        return new CartImpl();
    }

    public static Product_sz_slDao getProduct_sz_sl(){
        return new Product_sz_slImpl();
    }
    public static OderDao getOderDao(){
        return new OderImpl();
    }
}

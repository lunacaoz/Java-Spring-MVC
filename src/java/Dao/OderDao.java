/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Oder;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface OderDao {
    public void insert_oder(Oder user_oder);
    public List<Oder> showall();
}

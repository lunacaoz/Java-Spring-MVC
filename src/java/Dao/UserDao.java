/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;


import Model.User;

/**
 *
 * @author ACER
 */
public interface UserDao {
    public User find(String email,String pass);
    public void insertUsser(String full_name, String email,String sdt,String pass);
}

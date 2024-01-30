/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Web;

import Dao.Database;
import Model.Cart;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.net.URLDecoder;
import java.util.List;

/**
 *
 * @author ACER
 */
public class CartSevlet extends HttpServlet {
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id_user= (int)session.getAttribute("id_user");
        List<Cart> listCart = Database.getCart().showall(id_user);
        request.setAttribute("listCart", listCart);
        double s = 0;
        for(Cart i : listCart){
            s = s+i.getPrice()*i.getSl();
        }
        request.setAttribute("tong", s);
        String ts = request.getParameter("id");
        if(ts!= null){
             int id = Integer.parseInt(ts);
            Database.getCart().EmpityCart(id);
        }
        request.getRequestDispatcher("./html/cart.jsp").include(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }



}

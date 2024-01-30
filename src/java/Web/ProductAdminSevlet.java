/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Web;

import Dao.Database;
import Model.Oder;
import Model.Product;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author ACER
 */
public class ProductAdminSevlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        if(id != null){
            int id_be = Integer.parseInt(id);
            request.setAttribute("id",id_be);
        }
        else{
            request.setAttribute("id",0);
        }
        List<Product> listProduct = Database.getProduct().showall();
        request.setAttribute("listProduct", listProduct);
        List<Oder> listOder = Database.getOderDao().showall();
        request.setAttribute("listOder", listOder);
        request.getRequestDispatcher("./html/home_admin.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
}

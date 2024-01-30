/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Web;

import Dao.Database;
import Dao.UserDao;
import Model.User;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author ACER
 */
public class LoginSevlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("title", "Login");
        request.getRequestDispatcher("./html/login.jsp").include(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        User user = Database.getUserDao().find(email,pass);
        if(user == null){
            request.getSession().setAttribute("Errol", "Your passwork or email is incorrect");
            request.getRequestDispatcher("./html/login.jsp").include(request, response);
        }
        else{
            if(user.getAdmin().equals("1")){
                response.sendRedirect("./home_admin");
            }
            else{
                request.getSession().setAttribute("user", user);
                request.removeAttribute("Errol");
                response.sendRedirect("./bar");
            }
        }
            
    }


}

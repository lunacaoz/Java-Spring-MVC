
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Web;
import Dao.Database;
import Model.Brand;
import Model.Product;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

public class BarSevlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Brand> listBrand = Database.getBranDao().showall();
        request.setAttribute("listBrand", listBrand);
        String idBrand = request.getParameter("idBrand");
        if(idBrand==null){
            idBrand= "0";
        }
        request.setAttribute("idBrand",idBrand);
        List<Product> listProduct = Database.getProduct().showall();
        request.setAttribute("listProduct", listProduct);
        request.getRequestDispatcher("./View/Bar.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}

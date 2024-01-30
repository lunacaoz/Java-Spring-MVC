/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Web;

import Dao.Database;
import Model.Product_Detail;
import Model.Size;
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
public class ProductSevlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idProductString = request.getParameter("id_product");
        if(idProductString!=null){
            int idProduct = Integer.parseInt(idProductString);
            List<Product_Detail> listDetail = Database.getProduct_color().showProductDetail(idProduct);
            request.getSession().setAttribute("listDetail", listDetail);
            Product_Detail all = listDetail.get(0);
            request.setAttribute("all",all);
        }
        request.setAttribute("product_sz_id", request.getParameter("product_sz_id"));
        String temp = request.getParameter("product_id_color");
        request.setAttribute("product_id_color", temp);
        if(temp!=null){       
            int product_id_color = Integer.parseInt(temp);
            List<Size> listsize = Dao.Database.getProduct().showsize(product_id_color);
            request.setAttribute("listSize", listsize);
        }
       request.getRequestDispatcher("./View/Product.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String stringId_sz = request.getParameter("id2");
            String userId = request.getParameter("id1");

            if (stringId_sz != null && !stringId_sz.isEmpty() && userId != null && !userId.isEmpty()) {
                try {
                    int product_sz_id = Integer.parseInt(stringId_sz);
                    int id_user = Integer.parseInt(userId);
                    // Sử dụng id_user và product_sz_id để cập nhật giỏ hàng
                    Dao.Database.getCart().add_cart(id_user, product_sz_id);
                    response.sendRedirect("bar"); // Đảm bảo rằng đây là đường dẫn đúng
                } catch (NumberFormatException e) {
                    // Xử lý lỗi ở đây, có thể ghi log hoặc gửi thông báo lỗi về cho client
                    e.printStackTrace();
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid number format");
                }
            } else {
                // Gửi lỗi nếu id1 hoặc id2 là null hoặc rỗng
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Product size ID or User ID is missing");
            }
    }


}

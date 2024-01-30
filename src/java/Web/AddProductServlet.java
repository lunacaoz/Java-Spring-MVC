/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Web;

import Dao.Database;
import Model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;

/**
 *
 * @author ACER
 */
@MultipartConfig
public class AddProductServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String product_name = request.getParameter("product_name");
        String year_sx = request.getParameter("year_sx");
        String brand_id = request.getParameter("brand_id");
        String xuatsu = request.getParameter("xuatsu");
        String chatlieu = request.getParameter("chatlieu");
        String baohanh = request.getParameter("baohanh");
        String price = request.getParameter("price");
        String img = saveUploadedFile(request, response);
        if(year_sx!=null && brand_id !=null && baohanh!=null && price!= null){
            int namsx = Integer.parseInt(year_sx);
            int brand = Integer.parseInt(brand_id);
            int bh = Integer.parseInt(baohanh);
            int gia = Integer.parseInt(price);
            Product sp = new Product(0, product_name, chatlieu, namsx, xuatsu, bh, gia, img, brand);
            Database.getProduct().insert(sp);
        }
        response.sendRedirect("home_admin");
        
    }

     private String saveUploadedFile(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String uploadPath = getServletContext().getRealPath("") + File.separator + "inc" + File.separator + "img";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        Part filePart = request.getPart("img");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // Lấy tên file gốc

        OutputStream out = null;
        InputStream filecontent = null;

        try {
            out = new FileOutputStream(new File(uploadPath + File.separator + fileName));
            filecontent = filePart.getInputStream();

            int read;
            final byte[] bytes = new byte[1024];
            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            return fileName; 
        } catch (FileNotFoundException fne) {
            fne.printStackTrace();
            return null; 
        } finally {
            if (out != null) {
                out.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
        }
    }
}

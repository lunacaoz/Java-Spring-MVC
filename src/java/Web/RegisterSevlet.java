package Web;



import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author ACER
 */
public class RegisterSevlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("./html/register.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fullName = request.getParameter("full_name");
        String email = request.getParameter("email");
        String sdt = request.getParameter("phone");
        String password = request.getParameter("pass");
        String repeatPassword = request.getParameter("repass"); // you need to add the 'name' attribute in HTML
        boolean check = false;
        if(!email.contains("@") || email !=null){
            request.setAttribute("errol",1);  
            check = false;
        }
        else{
               check = true;
        }
        if(!password.equals(repeatPassword)){
            request.setAttribute("errol_pass",1);  
            check = false;
        }
        else {
            if( password!=null ||  repeatPassword!=null){
                check = true;
            }
            else{
                check = false;
            }
        }
        
        if(check == true){
            Dao.Database.getUserDao().insertUsser(fullName, email, sdt, password);
            request.getRequestDispatcher("./html/login.jsp").include(request, response);
        }
        else{
            request.getRequestDispatcher("./html/register.jsp").include(request, response);
        }
        

    }
}

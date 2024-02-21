package servlets;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignInServlet")
public class SignInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve values from the login form
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Perform authentication logic (you should add your own implementation)

        // Set user login status in session (example)
        request.getSession().setAttribute("user", email);

        if(email=="jdeez@gmail.com" && password=="jdeez" ) {
        response.sendRedirect("admission.jsp");
        
        }else {
        	
        }
    }
}
 
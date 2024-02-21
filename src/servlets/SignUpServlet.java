package servlets;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve values from the signup form
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Perform signup logic (you should add your own implementation)

        // Redirect to the login page after successful signup
        response.sendRedirect("signin.jsp");
    }
}

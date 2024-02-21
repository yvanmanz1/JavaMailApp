package servlets;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdmissionServlet")
public class AdmissionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Ensure user is authenticated (you should add your own implementation)
        if (request.getSession().getAttribute("user") == null) {
            // Redirect to the login page if not authenticated
            response.sendRedirect("signin.jsp");
            return;
        }

        // Retrieve values from the admission form
        String name = request.getParameter("name");
        String address = request.getParameter("address");

        // Perform admission logic (you should add your own implementation)

        // Send confirmation email using JavaMail API (you should add your own implementation)
        String userEmail = "jrwirangira7@gmail.com"; // Get the candidate's email from the admission form
        String confirmationSubject = "Admission Confirmation";
        String confirmationBody = "Dear candidate, your admission request has been received.";

        try {
            EmailUtility.sendConfirmationEmail(userEmail, confirmationSubject, confirmationBody);
        } catch (MessagingException e) {
            // Handle exception (log, display an error message, etc.)
            e.printStackTrace();
        }
        // Redirect to a confirmation page or homepage
        response.sendRedirect("confirmation.jsp");
    }
}

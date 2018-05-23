/** ****************************************************************************
 *
 * File        : RegisterUserServlet.java
 *
 * Date        : 11-Mar-2018
 *
 * Description : A servlet for registering a user.
 *
 * Author      : Ali Jarjis
 *
 ***************************************************************************** */
package Servlets;

import Controller.AccessController;
import Controller.DatabaseController;
import Controller.UserController;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AJarj
 */
@WebServlet(name = "RegisterUser", urlPatterns = {"/RegisterUser"})
public class RegisterUserServlet extends HttpServlet {

    /**
     * Processes requests to register a user.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        // Stores any errors that occur for view to access
        Map<String, String> errorMessages = new HashMap();
        request.setAttribute("errorMessages", errorMessages);

        try {
            // Retreives the data of a new user to register from form
            String userName = request.getParameter("userName").toLowerCase();
            String firstName = request.getParameter("firstName");
            String surname = request.getParameter("surname");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String cPassword = request.getParameter("confirmPassword");

            // Error checking for registration
            if (userName == null || userName.trim().isEmpty()) {
                errorMessages.put("userName", "Please enter a valid username.");
            } else if (!DatabaseController.checkUsername(userName)) {
                errorMessages.put("userName", "Username already exists.");
            } else if (firstName == null || firstName.trim().isEmpty()) {
                errorMessages.put("firstName", "Please enter a valid first name.");
            } else if (surname == null || surname.trim().isEmpty()) {
                errorMessages.put("surname", "Please enter a valid surname.");
            } else if (email == null || email.trim().isEmpty()) {
                errorMessages.put("email", "Please enter a valid email.");
            } else if (password == null || password.trim().isEmpty()) {
                errorMessages.put("password", "Please enter a valid password.");
            } else if (!password.trim().equals(cPassword.trim())) {
                errorMessages.put("confirmPassword", "Passwords must match.");
            }

            // Checks if no errors have occured, refreshing page if they have
            if (errorMessages.isEmpty()) {
                // Creates new user and logs them in
                UserController userController = AccessController
                        .registerUser(userName, firstName,
                                surname, email, password);
                //Create the user on on the Database
                DatabaseController.AddUser(userController.getUser());

                // Creates a session for logged in user
                HttpSession session = request.getSession();
                session.setAttribute("user", userController);

                // Redirects user to profile page and prevents resubmitting
                response.sendRedirect("index.jsp");
            } else {
                request.getRequestDispatcher("registration.jsp")
                        .forward(request, response);
            }
        } catch (SQLException e) {
            errorMessages.put("errorMain",
                    "Sorry, an error occured, please try again.");
            request.getRequestDispatcher("registration.jsp")
                    .forward(request, response);
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Logout");
            rd.forward(request, response);
        }
    }

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
        request.setAttribute("errorMessages", null);
        request.getRequestDispatcher("registration.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet for registering a user.";
    }// </editor-fold>

}

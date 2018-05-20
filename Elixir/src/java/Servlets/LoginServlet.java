/** ***************************************************************************
 *
 * File        : LoginServlet.java
 *
 * Date        : 13-May-2018
 *
 * Description : A servlet for logging a user into their account.
 *
 * Author      : Ali Jarjis
 *
 ***************************************************************************** */
package Servlets;

import Controller.AccessController;
import Controller.DatabaseController;
import Controller.UserController;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ali Jarjis
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests to login.
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
        
        // Retreives the data of a new user to register from form
        String userName = request.getParameter("userName").toLowerCase();
        String password = request.getParameter("password");
        
        // Checks if username is valid
        if (userName == null || userName.trim().isEmpty()) {
            errorMessages.put("userNameLog", "Please enter a valid username.");
        } else if (password == null || password.trim().isEmpty()) {
            errorMessages.put("passwordLog", "Please enter a valid password.");
        }
        
        // Registers user if no errors occur
        if (errorMessages.isEmpty()) {
            // Get password stored in the database assosiated with username
            String hashedPass = DatabaseController.getPasswordForLogin(userName);
            // Create empty user
            UserController userController = null;
            // Check if user exists
            if (hashedPass != null) {
                // Check if password is correct
                boolean passChk = AccessController.login(userName,
                        password, hashedPass);
                if (passChk) {
                    // Creates new user and logs them in
                    userController
                            = new UserController(DatabaseController.getUserByUsername(userName));
                    userController.setProfile(DatabaseController.getUserProfile(userName));
                } else {
                    // TODO: error must be catched here
                    System.err.println("Invalid Username or password!");
                }
            } else {
                // TODO: error must be catched here
                System.err.println("Invalid Username or password!");
            }

            // Creates a session for logged in user
            HttpSession session = request.getSession();
            session.setAttribute("user", userController);

            // Redirects user to profile page and prevents resubmitting
            response.sendRedirect("index.jsp");
        } else {
            request.getRequestDispatcher("registration.jsp")
                    .forward(request, response);
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
        processRequest(request, response);
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
        return "Short description";
    }// </editor-fold>

}

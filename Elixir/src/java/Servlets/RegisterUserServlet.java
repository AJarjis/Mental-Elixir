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
        Map<String, String> errorMessages = new HashMap();
        request.setAttribute("errorMessages", errorMessages);
        try {
            // TODO: Require sanitisation before accepting

            // Retreives the data of a new user to register from form
            String userName = request.getParameter("userName").toLowerCase();
            System.out.println(userName);
            String firstName = request.getParameter("firstName");
            String surname = request.getParameter("surname");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            if (userName == null || userName.trim().isEmpty()) {
                errorMessages.put("userName", "Username can't be blank");
            }
            
            else if (!DatabaseController.checkUsername(userName)) {
                errorMessages.put("userName", "Username already exists");
            }
            
            
            else if (firstName == null || firstName.trim().isEmpty()) {
                errorMessages.put("firstName", "First name can't be blank");
            }

            
            else if (surname == null || surname.trim().isEmpty()) {
                errorMessages.put("surname", "Surname can't be blank");
            }
            
            else if (email == null || email.trim().isEmpty()) {
                errorMessages.put("email", "Email can't be blank");
            }


            else if (password == null || password.trim().isEmpty()) {
                errorMessages.put("password", "Password can't be blank");
            }
            else if (password.contains("password")) {
                errorMessages.put("password",
                        "Password cannot contain 'password'");
            }
            if (errorMessages.isEmpty()) {

                // Creates new user and logs them in
                UserController userController = AccessController
                        .registerUser(userName, firstName
                                , surname, email, password);
                //Create the user on on the Database
                DatabaseController.AddUser(userController.getUser());

                // Gives JSP access to user details
                //request.setAttribute("user", userController);

                // Creates a session for logged in user
                HttpSession session = request.getSession();
                session.setAttribute("user", userController);

                // Redirects user to profile page and prevents resubmitting
                response.sendRedirect("index.jsp");
            }
            else{
                request.getRequestDispatcher("registration.jsp")
                        .forward(request, response);
            }
        } catch (SQLException e) {
            // TODO: catch error in an elegant manner
            errorMessages.put("errorMain", "Sorry, an error occured");
            request.getRequestDispatcher("registration.jsp")
                        .forward(request, response);
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            //System.exit(0);
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
        RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
        rd.forward(request, response);
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

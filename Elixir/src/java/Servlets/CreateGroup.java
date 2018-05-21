/** ***************************************************************************
 *
 * File        : CreateGroup.java
 *
 * Date        : 20-May-2018
 *
 * Description : A servlet  *
 * Author      : Ali Jarjis
 *
 ***************************************************************************** */
package Servlets;

import Controller.DatabaseController;
import Controller.ProfileController;
import Controller.UserController;
import Model.Group;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "CreateGroupServlet", urlPatterns = {"/CreateGroup"})
public class CreateGroup extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Stores any errors that occur for view to access
        Map<String, String> errorMessages = new HashMap();
        request.setAttribute("errorMessages", errorMessages);
        // Convert mood type to actual enum mood type
        String groupName = request.getParameter("groupName");

        // Grabs note about mood
        String groupDescription = request.getParameter("groupDescription");

        if (groupName.trim().isEmpty()) {
            errorMessages.put("errorMain", "Please enter a group name");
        } else if (DatabaseController.alreadyGroup(groupName)) {
            errorMessages.put("errorMain", "Group name is already taken.");
        } else if (groupDescription.trim().isEmpty()) {
            errorMessages.put("errorMain", "Please enter a group description");
        }
        if (errorMessages.isEmpty()) {
            // Load in currently logged in user
            HttpSession session = request.getSession();
            UserController user = (UserController) session.getAttribute("user");

            // Create mood and set as mood controller
            Group group = new Group(groupName, groupDescription, user.getUser());

            // Update database with mood
            DatabaseController.addGroup(group);

            // Add mood to user's profile
            ProfileController pc = new ProfileController(user.getProfile());

            // Redirects user to profile page and prevents resubmitting
            response.sendRedirect("groups.jsp");
        } else {
            request.getRequestDispatcher("createGroup.jsp")
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
        request.setAttribute("errorMessages", null);
        request.getRequestDispatcher("createGroup.jsp")
                    .forward(request, response);
        
        
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

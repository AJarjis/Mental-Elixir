/** ***************************************************************************
 *
 * File        : AddMood.java
 *
 * Date        : 15-May-2018
 *
 * Description : A servlet for adding a mood for a user.
 * Author      : Ali Jarjis
 *
 ***************************************************************************** */
package Servlets;

import Controller.DatabaseController;
import Controller.MoodController;
import Controller.ProfileController;
import Controller.UserController;
import Model.MoodTypes;
import java.io.IOException;
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
@WebServlet(name = "AddMoodServlet", urlPatterns = {"/AddMood"})
public class AddMood extends HttpServlet {

    /**
     * Processes request to add a mood.
     *
     * @param request               servlet request
     * @param response              servlet response
     * @throws ServletException     if a servlet-specific error occurs
     * @throws IOException          if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Convert mood type to actual enum mood type
        String moodType = request.getParameter("moodType");
        
        // Load in currently logged in user
        HttpSession session = request.getSession();
        UserController user = (UserController) session.getAttribute("user");
        
        // Create mood and set as mood controller
        MoodController mc = new MoodController(Integer.parseInt(moodType));
        
        // Update database with mood
        DatabaseController.addMoodEntry(user.getUserName(), mc.getMood());
        
        // Add mood to user's profile
        ProfileController pc = new ProfileController(user.getProfile());
        pc.addMood(mc.getMood());
        
        // Redirects user to profile page and prevents resubmitting
        response.sendRedirect("index.jsp");
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

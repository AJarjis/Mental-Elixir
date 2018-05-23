/*****************************************************************************

File        : AddActivityServlet.java

Date        : 22-May-2018

Description : A servlet 

Author      : Ali Jarjis

******************************************************************************/

package Servlets;

import Controller.DatabaseController;
import Controller.UserController;
import Model.Activity;
import Model.Goal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name="AddActivityServlet", urlPatterns={"/AddActivity"})
public class AddGoalServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        try{
        // Get goal and activities
        String goalString = request.getParameter("goal");
        String activitiesStrings [] = request.getParameterValues("activity");
        
        // Create activity for activities
        List<Activity> activities = new ArrayList();
        for (int i = 0; i < activitiesStrings.length; i++) {
            Activity act = new Activity(null, activitiesStrings[i]);
            activities.add(act);
        }
      
        // Create goal
        Goal goal = new Goal(activities, goalString);
        
        // Load in currently logged in user
        HttpSession session = request.getSession();
        UserController user = (UserController) session.getAttribute("user");
        
        // Add goal to database
        DatabaseController.addGoalEntry(goal, user.getUserName());
        user.getProfile().addGoal(goal);
        
        // Redirect page
        response.sendRedirect("index.jsp");
        }
        catch(Exception e)
        {
            RequestDispatcher rd = request.getRequestDispatcher("Logout");
                rd.forward(request,response);
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

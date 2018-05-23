/** ***************************************************************************
 *
 * File        : AddActivityServlet.java
 *
 * Date        : 22-May-2018
 *
 * Description : A servlet  *
 * Author      : Ali Jarjis
 *
 ***************************************************************************** */
package Servlets;

import Controller.DatabaseController;
import Controller.GoalController;
import Controller.UserController;
import Model.Activity;
import Model.ActivityTypes;
import java.io.IOException;
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
@WebServlet(name = "AddActivityServlet", urlPatterns = {"/AddActivity"})
public class AddGoalServlet extends HttpServlet {

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
        try {
            HttpSession session = request.getSession();
            UserController user = (UserController) session.getAttribute("user");

            // Get goal and activities
            String goalString = request.getParameter("goal");
            String activitiesStrings[] = request.getParameterValues("activity");

            // Add goal entry to the database
            GoalController goal = new GoalController(goalString);
            DatabaseController.addGoalEntry(goal.getGoal(), user.getUserName());

            int goalID = DatabaseController.getGoalID(
                    goal.getGoal().getDescription(), user.getUserName());

            // Create activity for activities
            for (int i = 0; i < activitiesStrings.length; i++) {
                Activity act = new Activity(ActivityTypes.Body, activitiesStrings[i]);
                DatabaseController.addActivityEntry(act, goalID);
                goal.addActivity(act);
            }

            user.getProfile().addGoal(goal.getGoal());

//        // Load in currently logged in user
//        HttpSession session = request.getSession();
//        UserController user = (UserController) session.getAttribute("user");
//      
//        // Create goal
//        Goal goal = new Goal(activities, goalString);
//        GoalController goalCon = new GoalController(goal);
//        int goalID = DatabaseController.getGoalID(goalCon.getGoal().getDescription(),
//                user.getUserName());
//        
//        // Add goal to database
//        DatabaseController.addGoalEntry(goal, user.getUserName());
//        user.getProfile().addGoal(goal);
//        
//        for (int i = 0; i < activities.size(); i++) {
//            // Add activities to the goal
//            goal.addActivity(activities.get(i));
//            // Using the goal id add the activities
//            DatabaseController.addActivityEntry(activities.get(i), goalID);
//        }
            // Redirect page
            response.sendRedirect("index.jsp");
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

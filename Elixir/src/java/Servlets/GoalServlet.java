/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controller.ActivityController;
import Controller.DatabaseController;
import Controller.GoalController;
import Controller.UserController;
import Model.ActivityTypes;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kyklos
 */
@WebServlet(name = "Test", urlPatterns = {"/Test"})
public class GoalServlet extends HttpServlet {

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
        // Retrieve the session
       HttpSession session = request.getSession();
       // Create a user controller from the session
       UserController testUser = (UserController) session.getAttribute("user");
       // Create a date format that the user will be using
       DateFormat fDate = new SimpleDateFormat("yyyy-MM-dd");
       
       // Collect information from webpage
       String goalDescription = request.getParameter("description");
       String targetDate = request.getParameter("targetDate");     
       ActivityTypes act1Type = ActivityTypes.convertToActivityType(request.getParameter("activity"));
       String act1Desc = request.getParameter("activitydesc");
       ActivityTypes act2Type = ActivityTypes.convertToActivityType(request.getParameter("activity2"));
       String act2Desc = request.getParameter("activity2desc");

       //Create new goal from paramiters collected
       GoalController goal = new GoalController(goalDescription);
       //Check if the date is pressent in the param collection
        if (!targetDate.equals("")) {
            //Get instanse of calendar
            Calendar date = Calendar.getInstance();
           try {
               //Set data using the date provided by the user
               date.setTime(fDate.parse(targetDate));
           } catch (ParseException e) {
               System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
           }
           //set the target date variable of the goal object
           goal.setTargetDate(date);
        }
        // Add goal entry to the database
        DatabaseController.addGoalEntry(goal.getGoal(), testUser.getUserName());
        // get the id of the goal
        int goalID = DatabaseController.getGoalID(goal.getGoal().getDescription(), testUser.getUserName());
       /**
        * Create new activities from the parameters collected if the user has 
        * provided any description for the activity
        */
        if (!act1Desc.equals("")) {
            ActivityController activity1 = new ActivityController(act1Type, act1Desc);
            // Add activities to the goal
            goal.addActivity(activity1.getActivity());
            // Using the goal id add the activities
            DatabaseController.addActivityEntry(activity1.getActivity(), goalID);
        }
        if (!act2Desc.equals("")) {
            ActivityController activity2 = new ActivityController(act2Type, act2Desc);
            // Add activities to the goal
            goal.addActivity(activity2.getActivity());
            // Using the goal id add the activities
            DatabaseController.addActivityEntry(activity2.getActivity(), goalID);
        }
       
       
        
        
        
        // Add goal to the user profile
        testUser.getProfile().addGoal(goal.getGoal());
        // Modify the session so it reflects the changes
        session.setAttribute("user", testUser);
        // Redirect user to the same page to see the results
        response.sendRedirect("goalTest.jsp");
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

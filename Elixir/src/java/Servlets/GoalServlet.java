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
       HttpSession session = request.getSession();
       UserController testUser = (UserController) session.getAttribute("user");
       DateFormat fDate = new SimpleDateFormat("dd/MM/yyyy");
       
       String goalDescription = request.getParameter("description");
       String targetDate = request.getParameter("targetDate");
       
       ActivityTypes act1Type = ActivityTypes.convertToActivityType(request.getParameter("activity"));
       String act1Desc = request.getParameter("activitydesc");
               
               
       GoalController goal = new GoalController(goalDescription);
       ActivityController activity1 = new ActivityController(act1Type, act1Desc);
        if (!targetDate.equals("")) {
            
            Calendar date = Calendar.getInstance();
           try {
               date.setTime(fDate.parse(targetDate));
           } catch (ParseException e) {
               System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
           }
           goal.setTargetDate(date);
        }
        testUser.getProfile().addGoal(goal.getGoal());
        session.setAttribute("user", testUser);
        DatabaseController.connectToDatabase();
        DatabaseController.addGoalEntry(goal.getGoal(), testUser.getUserName());
        int goalID = DatabaseController.getGoalID(goal.getGoal().getDescription(), testUser.getUserName());
        DatabaseController.addActivityEntry(activity1.getActivity(), goalID);
        DatabaseController.closeConnection();
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

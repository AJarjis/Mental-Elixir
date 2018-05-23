/*****************************************************************************

File        : JoinGroup.java

Date        : 20-May-2018

Description : A servlet 

Author      : Ali Jarjis

******************************************************************************/

package Servlets;

import Controller.DatabaseController;
import Controller.GroupController;
import Controller.UserController;
import Model.Group;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name="JoinGroupServlet", urlPatterns={"/JoinGroup"})
public class JoinGroup extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        // Grab user
        HttpSession session = request.getSession();
        UserController user = (UserController) session.getAttribute("user");
        
        // Get group user wishes to join
        String groupName = request.getParameter("joinGroup");

        
        // Retrieve group from database
        Group group = DatabaseController.getGroup(groupName);
                
        // Add user to group in database
        DatabaseController.addUserToGroup(user.getUserName(), groupName);
        
        // Update user's groups
        user.getProfile().addPartOfGroup(group);
        
        // Create groupController
        GroupController groupController = new GroupController(group);
        groupController.addMember(user.getUser());
        session.setAttribute("group", groupController);
        
        response.sendRedirect("groupPage.jsp");
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

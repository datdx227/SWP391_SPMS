/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.UserDAO;
import entity.User;
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
 * @author Computer
 */
@WebServlet(name = "UserProfileController", urlPatterns = {"/profile"})
public class UserProfileController extends HttpServlet {

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
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = new User();
        UserDAO dao = new UserDAO();
        user = dao.getUserById(userId);
        request.setAttribute("user", user);
        request.setAttribute("panel", "userProfile");
        request.getRequestDispatcher("/WEB-INF/web/homepage.jsp").forward(request, response);
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
        String email = request.getParameter("EmailAddress");
        String phone = request.getParameter("Phone");
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        int uid = u.getId();
        UserDAO dao = new UserDAO();
        boolean status = dao.updateUser(email, phone, uid);
        if (status) {
            request.setAttribute("message", "Update profile successful!");
            request.setAttribute("messageType", "text-success");
            response.sendRedirect(request.getContextPath() + "/profile?id=" + uid);
        } else {
            request.setAttribute("message", "Update profile failed. Please try again!");
            request.setAttribute("messageType", "text-danger");
            response.sendRedirect(request.getContextPath() + "/profile?id=" + uid);
        }

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

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
@WebServlet(name = "PasswordController", urlPatterns = {"/password"})
public class PasswordController extends HttpServlet {

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
        request.setAttribute("panel", "changePassword");
        request.getRequestDispatcher("WEB-INF/web/homepage.jsp").forward(request, response);
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
        String oldPass = request.getParameter("OldPassword");
        String password = request.getParameter("Password");
        String confirmPass = request.getParameter("RePass");
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        int uid = u.getId();
        UserDAO dao = new UserDAO();
        if (oldPass.equals(u.getPassword())) {
            if (password.equals(confirmPass)) {
                dao.changePassword(password, uid);
                request.setAttribute("message", "Change password successful!");
                request.setAttribute("messageType", "text-success");
                doGet(request, response);
            } else {
                request.setAttribute("message", "Change password Failed. Please try again!");
                request.setAttribute("messageType", "text-danger");
                doGet(request, response);
            }
        } else {
            request.setAttribute("message", "Wrong current password. Please enter correct your password!");
            request.setAttribute("messageType", "text-warning");
            doGet(request, response);
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

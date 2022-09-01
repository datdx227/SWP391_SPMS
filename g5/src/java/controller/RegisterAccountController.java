/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.User;

/**
 *
 * @author Computer
 */
@WebServlet(name = "registerAccount", urlPatterns = {"/register"})
public class RegisterAccountController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/web/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("inputFullname");
        String email = request.getParameter("inputEmail");
        String password = request.getParameter("inputPassword");
        String repassword = request.getParameter("inputPasswordConfirm");
        User user = new User();
        UserDAO dao = new UserDAO();
        user.setFullname(name);
        user.setPassword(password);
        user.setEmail(email);
        if (password.equals(repassword)) {
            dao.registerUser(user);
            response.sendRedirect(request.getContextPath() + "/home");
        }

    }

}

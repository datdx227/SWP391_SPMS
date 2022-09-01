/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.SettingDAO;
import entity.SettingClass;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Seth
 */
@WebServlet(name = "HomepageController", urlPatterns = {"/home"})
public class HomepageController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SettingDAO dao = new SettingDAO();
        List<SettingClass> contactType = dao.getContactType();
        request.setAttribute("contactType", contactType);
        request.getRequestDispatcher("/WEB-INF/web/homepage.jsp").forward(request, response);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.SettingDAO;
import entity.SettingClass;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author quang
 */
public class SettingDetails extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = -1;
        try {
            id = Integer.parseInt(request.getParameter("setting"));
            SettingDAO set = new SettingDAO();
            SettingClass s = set.getSettingById(id);
            request.setAttribute("setting", s);
            request.setAttribute("panel", "setting-details");
            request.getRequestDispatcher("/WEB-INF/dashboard/dashboard.jsp").forward(request, response);
        } catch (Exception e) {

        }
    }
}

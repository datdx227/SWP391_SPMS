/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.ClassSettingDAO;
import entity.ClassSetting;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Constant;

/**
 *
 * @author Acer
 */
@WebServlet(name = "ClassSettingDetail", urlPatterns = {"/classSettingdetail"})
public class ClassSettingDetailController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        ClassSetting a = new ClassSettingDAO().get(id);
        request.setAttribute("a", a);
        request.setAttribute("panel", Constant.CLASSSETINGDETAILPAGE);
        request.getRequestDispatcher("/WEB-INF/dashboard/dashboard.jsp").forward(request, response);
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
        
        int id = Integer.parseInt(request.getParameter("id"));
        String title  = request.getParameter("title");
        int type_id = Integer.parseInt(request.getParameter("type_id"));
        int display_order = Integer.parseInt(request.getParameter("order"));
        String value = request.getParameter("value");
        String description = request.getParameter("description");
        byte[] bytes = description.getBytes(StandardCharsets.ISO_8859_1);
         description = new String(bytes, StandardCharsets.UTF_8);
        ClassSetting a = new ClassSetting();
        a.setClass_id(1);
        
        a.setDescription(description);
        a.setSetting_value(value);
        a.setDisplay_order(display_order);
        a.setSetting_id(id);
        a.setSetting_title(title);
        a.setType_id(type_id);
        new ClassSettingDAO().update(a);
        
        request.getRequestDispatcher("classSettings").forward(request, response);
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

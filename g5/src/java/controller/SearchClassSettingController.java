/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.ClassSettingDAO;
import dao.SettingDAO;
import entity.ClassSetting;
import entity.ClassSetting;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Constant;
import utils.Paging;

/**
 *
 * @author Acer
 */
@WebServlet(name = "SearchClassSettingController", urlPatterns = {"/classSettings"})
public class SearchClassSettingController extends HttpServlet {

     private final String SEARCHBYNAME = "Search";
    private final String FILTERBYTYPE = "FilterByType";
    private final String FILTERBYSTATUS = "FilterByStatus";
    private final String PAGING = "Paging";
    //private final String SHOWSETTINGLIST = "ShowSettingList";
    private List<ClassSetting> show(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pageStr = request.getParameter("page");
        int page = 1;
        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
        }
        List<ClassSetting> list = (List<ClassSetting>) request.getSession().getAttribute(Constant.CLASSSETTINGLIST);
        Paging<ClassSetting> paging = new Paging<ClassSetting>(list);
        request.setAttribute("page", page);
        if (paging.isNext(page)) {
            request.setAttribute("isnext", "OK");
        }
        return paging.show(page);
    }

    private void search(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String search = request.getParameter("title");
        if (search == null) {
            search = "";
        }
        List<ClassSetting> list = new ClassSettingDAO().getAll();
        Iterator ite = list.iterator();
        while (ite.hasNext()) {
            ClassSetting setting = (ClassSetting) ite.next();
            search = search.toLowerCase();
            if (!setting.getSetting_title().toLowerCase().contains(search)) {
                ite.remove();
            }
        }
        request.getSession().setAttribute(Constant.CLASSSETTINGLIST, list);
    }

    private void filterByStatus(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String statusStr = request.getParameter("status");
        int status = 0;
        if (statusStr.equals("1")) {
            status = 1;
        }
        List<ClassSetting> list = new ClassSettingDAO().getAll();
        Iterator ite = list.iterator();
        while (ite.hasNext()) {
            ClassSetting setting = (ClassSetting) ite.next();
            if (setting.getStatus() != status) {
                ite.remove();
            }
        }
        request.getSession().setAttribute(Constant.CLASSSETTINGLIST, list);
    }

    private void filterByType(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String typeStr = request.getParameter("type");
        int type = Integer.parseInt(typeStr);
        List<ClassSetting> list = new ClassSettingDAO().getAll();
        Iterator ite = list.iterator();
        while (ite.hasNext()) {
            ClassSetting setting = (ClassSetting) ite.next();
            if (setting.getType_id() != type) {
                ite.remove();
            }
        }
        request.getSession().setAttribute(Constant.CLASSSETTINGLIST, list);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("Action");
        String change = request.getParameter("change");
        if (change != null){
            int id = Integer.parseInt(request.getParameter("id"));
            int status = Integer.parseInt(request.getParameter("status"));
            status = Math.abs(status-1);
            new ClassSettingDAO().changeStatus(id, status);
        }
        if (action == null) {
            action = SEARCHBYNAME;
        }
        if (action.equals(SEARCHBYNAME)) {
            search(request, response);
            //show(request, response);
        } else if (action.equals(FILTERBYSTATUS)) {
            filterByStatus(request, response);
            //show
        } else if (action.equals(FILTERBYTYPE)) {
            filterByType(request, response);
        }
        if (!action.equals(PAGING)) request.getSession().setAttribute("Action", action);
        request.setAttribute(Constant.CLASSSETTINGLIST, show(request, response));
        request.setAttribute("panel", Constant.CLASSSETINGPAGE);
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.SettingDAO;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.SettingClass;
import utils.Constant;
import utils.Paging;

/**
 *
 * @author Acer
 */
@WebServlet(name = "SearchSettingListController", urlPatterns = {"/settinglist"})
public class SearchSettingListController extends HttpServlet {

    private final int PAGE_SIZE = 5;

    private List<SettingClass> show(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pageStr = request.getParameter("page");
        int page = 1;
        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
        }
        List<SettingClass> list = (List<SettingClass>) request.getSession().getAttribute("SettingList");
        Paging<SettingClass> paging = new Paging<SettingClass>(list);
        request.setAttribute("page", page);
        if (paging.isNext(page)) {
            request.setAttribute("isnext", "OK");
        }
        return paging.show(page);
    }

    private void search(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String search = request.getParameter("search");
        if (search == null) {
            search = "";
        }
        List<SettingClass> list = new SettingDAO().getSettings();
        Iterator ite = list.iterator();
        while (ite.hasNext()) {
            SettingClass setting = (SettingClass) ite.next();
            search = search.toLowerCase();
            if (!setting.getSettingName().toLowerCase().contains(search)) {
                ite.remove();
            }
        }
        request.getSession().setAttribute("SettingList", list);
    }

    private void filterByStatus(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String statusStr = request.getParameter("status");
        int status = 0;
        if (statusStr.equals("Active")) {
            status = 1;
        }
        List<SettingClass> list = new SettingDAO().getSettings();
        Iterator ite = list.iterator();
        while (ite.hasNext()) {
            SettingClass setting = (SettingClass) ite.next();
            if (setting.getStatus() != status) {
                ite.remove();
            }
        }
        request.getSession().setAttribute("SettingList", list);
    }

    private void filterByType(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String typeStr = request.getParameter("Action");
        int type = Integer.parseInt(typeStr);
        List<SettingClass> list = new SettingDAO().getSettings();
        Iterator ite = list.iterator();
        while (ite.hasNext()) {
            SettingClass setting = (SettingClass) ite.next();
            if (setting.getTypeId() != type) {
                ite.remove();
            }
        }
        request.getSession().setAttribute("SettingList", list);
    }
    private final String SEARCHBYNAME = "Search";
    private final String FILTERBYTYPE = "FilterByType";
    private final String FILTERBYSTATUS = "FilterByStatus";
    private final String PAGING = "Paging";
    private final String SHOWSETTINGLIST = "ShowSettingList";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("Action");
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
        request.getSession().setAttribute("Action", action);
        request.setAttribute("ShowSettingList", show(request, response));
        request.setAttribute("panel", "setting-list");
        request.getRequestDispatcher("/WEB-INF/dashboard/dashboard.jsp").forward(request, response);
        //List<Setting> list;

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

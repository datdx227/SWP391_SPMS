/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.ClassSettingDAO;
import dao.MilestoneDAO;
import entity.ClassSetting;
import entity.Milestone;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "SearchMileStoneController", urlPatterns = {"/milestones"})
public class SearchMileStoneController extends HttpServlet {

    private final String SEARCHBYITE = "SearchByITe";
    private final String SEARCHBYCLASS = "SearchByClass";
    private final String PAGING = "Paging";
    //private final String SHOWSETTINGLIST = "ShowSettingList";
    private List<Milestone> show(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pageStr = request.getParameter("page");
        int page = 1;
        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
        }
        List<Milestone> list = (List<Milestone>) request.getSession().getAttribute(Constant.MILESTONELIST);
        Paging<Milestone> paging = new Paging<Milestone>(list);
        request.setAttribute("page", page);
        if (paging.isNext(page)) {
            request.setAttribute("isnext", "OK");
        }
        return paging.show(page);
    }

    
    private void initial(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        List<String> list = new ArrayList<>();
        list.add("HE150002");
        list.add("HE150983");
        list.add("HE169092");
        list.add("HE109322");
        request.setAttribute("classes", list);
        //list.clear();
        
        
    }
    private void searchByIte(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Milestone> list = new MilestoneDAO().getAll();
        String idStr = request.getParameter("iteid");
        if (idStr == null) idStr= "0";
        int id = Integer.parseInt(idStr);
        Iterator ite = list.iterator();
        if (id != 0){
            while (ite.hasNext()){
                Milestone ms = (Milestone) ite.next();
                if (ms.getIteration_id()!= id) ite.remove();
            }
        }
        request.getSession().setAttribute(Constant.MILESTONELIST, list);
    }
    private void searchByClass(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Milestone> list = new MilestoneDAO().getAll();
        String idStr = request.getParameter("id");
        if (idStr == null) idStr= "0";
        int id = Integer.parseInt(idStr);
        Iterator ite = list.iterator();
        if (id!=0){
            while (ite.hasNext()){
                Milestone ms = (Milestone) ite.next();
                if (ms.getClass_id() != id) ite.remove();
            }
        }
        request.getSession().setAttribute(Constant.MILESTONELIST, list);
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
            new MilestoneDAO().changeStatus(id, status);
        }
        if (action == null) {
            action = SEARCHBYITE;
        }
        if (action.equals(SEARCHBYITE)) {
            searchByIte(request, response);
            //show(request, response);
        }else if (action.equals(SEARCHBYCLASS)){
            searchByClass(request, response);
        }
        
        initial(request, response);
        if (!action.equals(PAGING)) request.getSession().setAttribute("Action", action);
        request.setAttribute(Constant.MILESTONELIST, show(request, response));
        request.setAttribute("panel", Constant.MILESTONEPAGE);

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

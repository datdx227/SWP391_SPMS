/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AddMilestoneClassSetingDAO;
import dao.MilestoneDAO;
import entity.Milestone;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "MilestoneCreateController", urlPatterns = {"/createmilestone"})
public class MilestoneCreateController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private void initial(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        List<String> list = new ArrayList<>();
        list.add("HE150002");
        list.add("HE150983");
        list.add("HE169092");
        list.add("HE109322");
        request.setAttribute("classes", list);
        
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        request.setAttribute("iterations", list1);
        //list.clear();        
        
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //int id = Integer.parseInt(request.getParameter("id"));
        //Milestone a = new MilestoneDAO().get(id);
        //request.setAttribute("a", a);
        initial(request, response);
        request.setAttribute("panel", "MileStone_create");
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
        //int milestone_id = Integer.parseInt(request.getParameter("id"));
        int iteration_id = Integer.parseInt(request.getParameter("iteration_id"));
        int class_id = Integer.parseInt(request.getParameter("class_id"));
        String fDate = request.getParameter("from_date");
        String tDate = request.getParameter("to_date");
        String description = request.getParameter("description");
        Date from_date = Date.valueOf(fDate);
        Date to_date = Date.valueOf(tDate);
        
        if (from_date.after(to_date)){
            request.setAttribute("message", "From Date must go before To Date");
            //Milestone ms = new MilestoneDAO().get(milestone_id);
            //request.setAttribute("a", ms);
            request.setAttribute("panel", "MileStone_create");
            request.getRequestDispatcher("/WEB-INF/dashboard/dashboard.jsp").forward(request, response);
            return;
        }
        Milestone a = new Milestone();
        a.setIteration_id(iteration_id);
        a.setClass_id(class_id);
        //a.setMilestone_id(milestone_id);
        a.setFrom_date(from_date);
        a.setTo_date(to_date);
        a.setDescription(description);
        new AddMilestoneClassSetingDAO().addMileStone(a);
        request.getRequestDispatcher("milestones").forward(request, response);
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

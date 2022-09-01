/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.StudentEvaluationDAO;
import dao.UserDAO;
import entity.IterationEvaluation;
import entity.Loc_Evaluation;
import entity.MemberEvaluation;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
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
@WebServlet(name = "StudentEvaluationController", urlPatterns = {"/studentevaluation"})
public class StudentEvaluationController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private void eva(HttpServletRequest request, HttpServletResponse response,int student_id)
            throws ServletException, IOException{
        
        List<IterationEvaluation> list = new StudentEvaluationDAO().getIteEvas();
        
        
        Iterator ite = list.iterator();
        while(ite.hasNext()){
            IterationEvaluation iteration = (IterationEvaluation) ite.next();
            if (iteration.getUserId()!= student_id) ite.remove();
        }
        
        request.setAttribute("IteEvas",list );
        double point = 0;
        int count=0;
        double bonus =0;
        for(IterationEvaluation iteration:list){
            point += iteration.getTotalGrade();
            count++;
            bonus += iteration.getBonus();
        }
        request.setAttribute("teampoint", point/count);
        request.setAttribute("bonus", bonus);
        List<MemberEvaluation> list1 = new StudentEvaluationDAO().getMemberEvas();
        ite = list1.iterator();
        while(ite.hasNext()){
            MemberEvaluation mem = (MemberEvaluation) ite.next();
            if (mem.getStudent_id() != student_id) ite.remove();
        }
        
        point =0;
        count = 0;
        for(MemberEvaluation mem :list1){
            point += mem.getGrade();
            count++;
           
        }
        request.setAttribute("invidualpoint", point/count);
        request.setAttribute("MemberEvas", list1);
    }
    private void loc_eva(HttpServletRequest request, HttpServletResponse response,int student_id)
            throws ServletException, IOException{
        List<Loc_Evaluation> list = new StudentEvaluationDAO().getLocEvas();
        Iterator ite = list.iterator();
        while(ite.hasNext()){
            Loc_Evaluation loc = (Loc_Evaluation) ite.next();
            if (loc.getStudent_id() != student_id) ite.remove();
        }
        int total=0;
        for (Loc_Evaluation loc:list){
            total += Integer.parseInt(loc.getConverted_loc());
        }
        request.setAttribute("totalLoc", total);
        request.setAttribute("LocEvas",list);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String idStr = request.getParameter("student_id");
        int student_id;
        if (idStr==null || idStr.equals("")) student_id =1;
        else student_id = Integer.parseInt(idStr);
        User user = new UserDAO().getUser(student_id);
        request.setAttribute("student", user);
        List<String> teamName = new ArrayList<>();
        teamName.add("SGB");
        teamName.add("GAM");
        teamName.add("T1");
        teamName.add("TS");
        teamName.add("SE");
        Random ran = new Random();
        request.setAttribute("teamName", teamName.get(student_id-1));
        
        
        eva(request, response,student_id);
        loc_eva(request, response,student_id);
        request.setAttribute("students", new UserDAO().getUsers());
        request.setAttribute("panel", Constant.STUDENTEVALUATION);
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

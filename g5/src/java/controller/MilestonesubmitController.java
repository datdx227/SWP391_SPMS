/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.MilestoneSubmitDAO;
import dao.MilestoneDAO;
import entity.Team;
import entity.Team_Evaluation;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Acer
 */
@WebServlet(name = "MilestonesubmitController", urlPatterns = {"/milestonesubmit"})
public class MilestonesubmitController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private final String TEAM = "SearchByTeam";
    private final String MILESTONE = "SearchByMileStone";
    private void searchByTeam(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String teamStr = request.getParameter("team");
        int  team_id ;
        if (teamStr!=null) team_id = Integer.parseInt(teamStr);
        else team_id = 0;
        request.setAttribute("team_id", team_id);
        MilestoneSubmitDAO dao = new MilestoneSubmitDAO();
        List<Team> list =  new MilestoneSubmitDAO().getTeams();
        List<Team_Evaluation> teamEvas = dao.getTeamEva();
        
        if (team_id !=0){
            Iterator ite = list.iterator();
            while (ite.hasNext()){
                Team team = (Team) ite.next();
                if (team.getTeam_id()!= team_id) ite.remove();
            }
        }
        System.err.println("////" + teamEvas.size());
        for (Team team: list){
            team.setTeamEvaList(new ArrayList<Team_Evaluation>());
            for(Team_Evaluation teamEva: teamEvas){
                System.err.println("////" + teamEva.getTeam_id()+" //"+team.getTeam_id());
                if (teamEva.getTeam_id() == team.getTeam_id()) team.getTeamEvaList().add(teamEva);
            }
        }
        request.setAttribute("teamSearch", list);
    }
    private void searchByMilestone(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        int milestone_id = Integer.parseInt(request.getParameter("milestone"));
        MilestoneSubmitDAO dao = new MilestoneSubmitDAO();
        List<Team> list = dao.getTeams();
        List<Team_Evaluation> teamEvas = dao.getTeamEva();
        Iterator ite = list.iterator();
        for (Team team: list){
            team.setTeamEvaList(new ArrayList<Team_Evaluation>());
            for(Team_Evaluation teamEva: teamEvas){
                if (teamEva.getTeam_id() == team.getTeam_id()) team.getTeamEvaList().add(teamEva);
            }
        }
        request.setAttribute("teamSearch", list);
        
    }
    private void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String[] gradeStr = request.getParameterValues("grade");
        String[] idStr = request.getParameterValues("teamEva_id");
        
        String[] comment = request.getParameterValues("comment");
        //byte[] bytes = comment.getBytes(StandardCharsets.ISO_8859_1);
        //comment = new String(bytes, StandardCharsets.UTF_8);
        for(int i=0; i< comment.length;i++){
            double grade = Double.parseDouble(gradeStr[i]);
            int teamEva_id = Integer.parseInt(idStr[i]);
            byte[] bytes = comment[i].getBytes(StandardCharsets.ISO_8859_1);
            comment[i] = new String(bytes, StandardCharsets.UTF_8);  
            new MilestoneSubmitDAO().updateTeamEva(teamEva_id, grade, comment[i]);
        }
        
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action==null) action= TEAM;
        MilestoneSubmitDAO dao = new MilestoneSubmitDAO();
        request.setAttribute("teams", dao.getTeams());
        request.setAttribute("milestones", new MilestoneDAO().getAll());
        
        String update= request.getParameter("update");
        if ("Yup".equals(update)){
            update(request, response);
        }
        
        if (action.equals(TEAM)){
            searchByTeam(request, response);
        }else if (action.equals(MILESTONE)){
            searchByMilestone(request, response);
        } 
        request.setAttribute("panel", "Milestone_submits");
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

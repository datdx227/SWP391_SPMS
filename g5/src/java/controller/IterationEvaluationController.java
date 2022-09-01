/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.IterationEvaluationDAO;
import dao.MilestoneDAO;
import dao.TeamDAO;
import entity.Iteration_Evaluation;
import entity.Milestone;
import entity.Team;
import entity.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author quang
 */
@WebServlet(name = "IterationEvaluationController", urlPatterns = {"/dashboard/itervaluas/*"})
public class IterationEvaluationController extends HttpServlet {

    private static final Integer ENTRIES_PER_PAGE = 5;
    IterationEvaluationDAO itervaluaDAO = new IterationEvaluationDAO();
    TeamDAO teamDao = new TeamDAO();
    MilestoneDAO mileDao = new MilestoneDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null || path.equals("/list")) {
            itervaluaList(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null) {
            return;
        }
//        switch (path) {
//            case "/import":
//                importEvaluation(request, response);
//                break;
//        }
    }

    private void itervaluaList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String team_id = request.getParameter("team_id");
        String milestone_id = request.getParameter("milestone_id");
        String pageInput = request.getParameter("page");
        int page = pageInput == null ? 1 : Integer.parseInt(pageInput);

        String query = "";
        if (team_id != null && !team_id.trim().equalsIgnoreCase("0")) {
            query += (" AND " + "ie.team_id = " + team_id);
        }
        if (milestone_id != null && !milestone_id.trim().equalsIgnoreCase("0")) {
            query += (" AND " + "ie.milestone_id = " + milestone_id);
        }

        List<Iteration_Evaluation> itervaluas = itervaluaDAO.getIterValuas(query, page);
        List<Team> teams = teamDao.getTeamList();
        List<Milestone> milestones = mileDao.getMileStoneList();

        int maxpage = itervaluas.size() / ENTRIES_PER_PAGE;
        if (ENTRIES_PER_PAGE * maxpage < itervaluas.size()) {
            maxpage += 1;
        }

        List<Iteration_Evaluation> itervaluas2 = new ArrayList<>();

        for (int i = (page - 1) * ENTRIES_PER_PAGE; i < page * ENTRIES_PER_PAGE; i++) {
            if (i < itervaluas.size()) {
                itervaluas2.add(itervaluas.get(i));
            } else {
                break;
            }
        }

        request.setAttribute("team_id", team_id == null ? 0 : team_id);
        request.setAttribute("milestone_id", milestone_id == null ? 0 : milestone_id);
        request.setAttribute("teams", teams);
        request.setAttribute("milestones", milestones);
        request.setAttribute("itervaluas", itervaluas2);
        request.setAttribute("maxpage", maxpage);
        request.setAttribute("panel", "iteration-evaluation-list");
        request.getRequestDispatcher("/WEB-INF/dashboard/dashboard.jsp").forward(request, response);
    }

//    private void importEvaluation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute("user");
//
//        String teamEval = request.getParameter("comment");
//        String indiEval = request.getParameter("indi_comment");
//
//        Iteration_Evaluation ie = new Iteration_Evaluation();
//        ie.setComment(teamEval);
//        ie.setIndi_comment(indiEval);
//        
//        itervaluaDAO.importEvaluation(ie, user.getId());
//        response.sendRedirect(request.getContextPath() + "/dashboard/itervaluas");
//    }
}

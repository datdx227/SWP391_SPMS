/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.TeamDAO;
import entity.Team;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Computer
 */
@WebServlet(name = "TeamManagementController", urlPatterns = {"/dashboard/team/*"})
public class TeamManagementController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null || path.equals("/list")) {
//            teamList(request, response);
            Team team = new Team();
            TeamDAO dao = new TeamDAO();
            List<Team> list = dao.getTeamList();
            request.setAttribute("list", list);
            request.setAttribute("panel", "team-list");
            request.getRequestDispatcher("/WEB-INF/dashboard/dashboard.jsp").forward(request, response);
        }
//        switch (path) {
//            case "/detail":
//                teamDetail(request, response);
//                break;
//            case "/update":
//
//                break;
//        }
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
        String path = request.getPathInfo();
        if (path == null) {
            return;
        }
        switch (path) {
            case "/detail":
                teamDetail(request, response);
                break;
            case "/update":

                break;
        }
    }

    private void teamList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Team team = new Team();
        TeamDAO dao = new TeamDAO();
        List<Team> list = dao.getTeamList();
        request.setAttribute("list", list);
        request.setAttribute("panel", "team-list");
        request.getRequestDispatcher("/WEB-INF/dashboard/dashboard.jsp").forward(request, response);
    }

    private void teamDetail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int teamId = Integer.parseInt(request.getParameter("detailId"));
        Team team = new Team();
        TeamDAO dao = new TeamDAO();
        team = dao.getTeamById(teamId);
        request.setAttribute("team", team);
        request.setAttribute("panel", "team-detail");
        request.getRequestDispatcher("/WEB-INF/dashboard/dashboard.jsp").forward(request, response);

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

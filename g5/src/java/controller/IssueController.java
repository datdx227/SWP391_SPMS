/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.FunctionDAO;
import dao.IssueDAO;
import dao.MilestoneDAO;
import dao.TeamDAO;
import dao.UserDAO;
import entity.Assignee;
import entity.Function;
import entity.Issue;
import entity.Milestone;
import entity.Team;
import entity.Type;
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
@WebServlet(name = "IssueController", urlPatterns = {"/dashboard/issues/*"})
public class IssueController extends HttpServlet {

    private static final Integer ENTRIES_PER_PAGE = 5;
    IssueDAO issueDAO = new IssueDAO();
    TeamDAO teamDao = new TeamDAO();
    FunctionDAO funDAO = new FunctionDAO();
    MilestoneDAO mileDAO = new MilestoneDAO();
    UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null || path.equals("/list")) {
            issueList2(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null) {
        }
    }
    //==========================================================================

    private void issueList2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String team_id = request.getParameter("team_id");
        String issue_title = request.getParameter("issue_title");
        String type_name = request.getParameter("type_name");
        String function_id = request.getParameter("function_id");
        String milestone_id = request.getParameter("milestone_id");
        String assignee_id = request.getParameter("assignee_id");
        String status = request.getParameter("status");
        String pageInput = request.getParameter("page");
        String order_by = request.getParameter("order_by");
        int page = pageInput == null ? 1 : Integer.parseInt(pageInput);

        String query = "";
        if (team_id != null && !team_id.trim().equalsIgnoreCase("0")) {
            query += (" AND " + "i.team_id = " + team_id);
        }
        if (function_id != null && !function_id.trim().equalsIgnoreCase("0")) {
            query += (" AND " + "i.function_id = " + function_id);
        }
        if (milestone_id != null && !milestone_id.trim().equalsIgnoreCase("0")) {
            query += (" AND " + "i.milestone_id = " + milestone_id);
        }
        if (assignee_id != null && !assignee_id.trim().equalsIgnoreCase("0")) {
            query += (" AND " + "i.assignee_id = " + assignee_id);
        }
        if (status != null && !status.trim().equalsIgnoreCase("-1")) {
            query += (" AND " + "i.status = " + status);
        }
        if (issue_title != null && !"".equals(issue_title)) {
            query += (" AND " + "i.issue_title LIKE '%" + issue_title + "%'");
        }
        if (type_name != null && !"".equals(type_name)) {
            query += (" AND " + "i.issue_type LIKE '%" + type_name + "%'");
        }
        int order = order_by == null ? (-1) : Integer.parseInt(order_by);
        if (order != -1) {
            query += " ORDER BY i.issue_id " + ((order == 0) ? "ASC" : "DESC");
        }

        List<Issue> issues = issueDAO.getIssues(query, page);
        List<Team> teams = teamDao.getTeamList();
        List<Type> types = issueDAO.getTypeList();
        List<Function> functions = funDAO.getFunctionList();
        List<Milestone> milestones = mileDAO.getMileStoneList();
        List<Assignee> assignees = userDAO.getAssignees();
        
        int maxpage = issues.size() / ENTRIES_PER_PAGE;
        if (ENTRIES_PER_PAGE * maxpage < issues.size()) {
            maxpage += 1;
        }

        List<Issue> issues2 = new ArrayList<>();

        for (int i = (page - 1) * ENTRIES_PER_PAGE; i < page * ENTRIES_PER_PAGE; i++) {
            if (i < issues.size()) {
                issues2.add(issues.get(i));
            } else {
                break;
            }
        }

        request.setAttribute("team_id", team_id == null ? 0 : team_id);
        request.setAttribute("issue_title", issue_title == null ? "" : issue_title);
        request.setAttribute("type_name", type_name == null ? "" : type_name);
        request.setAttribute("function_id", function_id == null ? 0 : function_id);
        request.setAttribute("milestone_id", milestone_id == null ? 0 : milestone_id);
        request.setAttribute("assignee_id", assignee_id == null ? 0 : assignee_id);
        request.setAttribute("status", status == null ? -1 : status);
        request.setAttribute("order_by", order_by == null ? -1 : order_by);
        request.setAttribute("teams", teams);
        request.setAttribute("types", types);
        request.setAttribute("functions", functions);
        request.setAttribute("assignees", assignees);
        request.setAttribute("milestones", milestones);
        request.setAttribute("issues", issues2);
        request.setAttribute("maxpage", maxpage);
        request.setAttribute("panel", "issue-list2");
        request.getRequestDispatcher("/WEB-INF/dashboard/dashboard.jsp").forward(request, response);
    }
}

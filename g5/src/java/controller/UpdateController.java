/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.FunctionDAO;
import dao.MilestoneDAO;
import dao.UpdateDAO;
import entity.Function;
import entity.Milestone;
import entity.Update;
import entity.User;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Seth
 */
@WebServlet(name = "UpdateController", urlPatterns = {"/updates/*"})
public class UpdateController extends HttpServlet {

    FunctionDAO funcDao = new FunctionDAO();
    UpdateDAO updDao = new UpdateDAO();
    MilestoneDAO mileDao = new MilestoneDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null || path.equals("/list")) {
            updatesList(request, response);
        }
        switch (path) {
            case "/detail":
                updatesListDetails(request, response);
                break;
            case "/update":
                getUpdateDetails(request, response);
                break;
            case "/delete":
                removeUpdate(request, response);
                break;
            case "/add":
                newUpdate(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null) {
            return;
        }
        switch (path) {
            case "/update":
                updateUpdate(request, response);
                break;
            case "/add":
                addNewUpdate(request, response);
                break;
        }
    }

    public void updatesList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Function> functionList = funcDao.getFunctionList();
        request.setAttribute("panel", "evaluated-functions");
        request.setAttribute("functions", functionList);
        request.getRequestDispatcher("/WEB-INF/web/homepage.jsp").forward(request, response);
    }

    public void updatesListDetails(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int functionId = Integer.parseInt(request.getParameter("id"));
        List<Update> updates = updDao.getUpdateListByFunctionId(functionId);
        request.setAttribute("currentFunctionId", functionId);
        request.setAttribute("updates", updates);
        request.setAttribute("panel", "tracking-update");
        request.getRequestDispatcher("/WEB-INF/web/homepage.jsp").forward(request, response);
    }

    public void newUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int functionId = Integer.parseInt(request.getParameter("id"));
        List<Milestone> list = mileDao.getMileStoneList();
        Date updateDate = new java.sql.Date(System.currentTimeMillis());
        request.setAttribute("action", "add");
        request.setAttribute("milestoneList", list);
        request.setAttribute("subPanel", "add-update");
        request.setAttribute("functionId", functionId);
        request.setAttribute("updateDate", updateDate);
        updatesListDetails(request, response);
    }

    public void addNewUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("user");
        String title = request.getParameter("updateName");
        int functionId = Integer.parseInt(request.getParameter("functionId"));
        int milestoneId = Integer.parseInt(request.getParameter("milestone"));
        Timestamp updateDate = new java.sql.Timestamp(new java.util.Date().getTime());
        String description = request.getParameter("description");

        Update update = new Update();
        update.setTitle(title);
        update.setFunctionId(functionId);
        update.setMilestoneId(milestoneId);
        update.setUpdateDate(updateDate);
        update.setDescription(description);
        updDao.addNewUpdate(update, currentUser.getId());
        response.sendRedirect(request.getContextPath() + "/updates/detail?id=" + functionId);
    }

    public void getUpdateDetails(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Milestone> list = mileDao.getMileStoneList();
        int updateId = Integer.parseInt(request.getParameter("id"));
        Update update = updDao.getUpdateById(updateId);
        request.setAttribute("action", "update");
        request.setAttribute("functionId", updateId);
        request.setAttribute("updateDate", update.getUpdateDate());
        request.setAttribute("title", update.getTitle());
        request.setAttribute("currentMilestone", update.getMilestoneId());
        request.setAttribute("description", update.getDescription());
        request.setAttribute("milestoneList", list);
        request.setAttribute("subPanel", "add-update");
        updatesListDetails(request, response);
    }

    public void removeUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int updateId = Integer.parseInt(request.getParameter("id"));
        updDao.deleteUpdate(updateId);
        response.sendRedirect(request.getContextPath() + "/updates");
    }

    public void updateUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("user");
        int updateId = Integer.parseInt(request.getParameter("functionId"));
        String title = request.getParameter("updateName");
        int milestoneId = Integer.parseInt(request.getParameter("milestone"));
        Timestamp updateDate = new java.sql.Timestamp(new java.util.Date().getTime());
        String description = request.getParameter("description");

        Update update = new Update();
        update.setId(updateId);
        update.setMilestoneId(milestoneId);
        update.setTitle(title);
        update.setUpdateDate(updateDate);
        update.setDescription(description);

        updDao.updateUpdate(update, currentUser.getId());
        response.sendRedirect(request.getContextPath() + "/updates");
    }
}

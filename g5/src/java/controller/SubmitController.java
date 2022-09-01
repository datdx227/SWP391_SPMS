/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.FunctionDAO;
import dao.IterationDAO;
import dao.UserDAO;
import entity.Function;
import entity.Iteration;
import entity.User;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Seth
 */
@WebServlet(name = "SubmitController", urlPatterns = {"/submit/*"})
public class SubmitController extends HttpServlet {

    FunctionDAO funcDao = new FunctionDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null || path.equals("/list")) {
            iterationList(request, response);
        }
        switch (path) {
            case "/detail":
                submitList(request, response);
                break;
            case "/update":
                break;
            case "/add":
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null || path.equals("/list")) {
            iterationList(request, response);
        }
        switch (path) {
            case "/update":
                updateSubmit(request, response);
                break;
        }
    }

    public void iterationList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        IterationDAO iterDao = new IterationDAO();
        List<Iteration> list = iterDao.getAllIterations();
        request.setAttribute("iterList", list);
        request.setAttribute("panel", "iteration-submit");
        request.getRequestDispatcher("/WEB-INF/web/homepage.jsp").forward(request, response);
    }

    public void submitList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDAO userDao = new UserDAO();
        int iterationId = Integer.parseInt(request.getParameter("id"));
        List<Function> functionList = funcDao.getFunctionListByIteration(iterationId);
        List<User> students = userDao.getStudentList();
        request.setAttribute("functions", functionList);
        request.setAttribute("students", students);
        request.setAttribute("panel", "tracking-submit");
        request.getRequestDispatcher("/WEB-INF/web/homepage.jsp").forward(request, response);
    }

    public void updateSubmit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String values[] = request.getParameterValues("submitId");
        String assignee[] = request.getParameterValues("assigneeId");
        int submitIds[] = null;
        int assigneeIds[] = null;
        for (int i = 0; i < values.length; i++) {
            submitIds[i] = Integer.parseInt(values[i]);
        }
        for (int i = 0; i < assignee.length; i++) {
            assigneeIds[i] = Integer.parseInt(assignee[i]);
        }
    }
}

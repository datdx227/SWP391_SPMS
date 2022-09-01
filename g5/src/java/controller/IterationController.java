/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.IterationDAO;
import dao.SubjectDAO;
import entity.Iteration;
import entity.Subject;
import entity.User;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.CustomMath;

/**
 *
 * @author Seth
 */
@WebServlet(name = "IterationController", urlPatterns = {"/dashboard/iterations/*"})
public class IterationController extends HttpServlet {

    private static final Integer ENTRIES_PER_PAGE = 5;
    CustomMath customMath = new CustomMath();
    IterationDAO iterDao = new IterationDAO();
    SubjectDAO subDao = new SubjectDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null || path.equals("/list")) {
            iterationList(request, response);
        }
        switch (path) {
            case "/detail":
                iterationDetails(request, response);
                break;
            case "/update":
                updateIterationStatus(request, response);
                break;
            case "/add":
                toAddIteration(request, response);
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
                updateIterationDetails(request, response);
                break;
            case "/add":
                addNewIteration(request, response);
                break;
        }
    }

    private void iterationList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String pageInput = request.getParameter("page");
        String subjectId = request.getParameter("filterSubject");
        String status = request.getParameter("filterStatus");
        String name = request.getParameter("searchName");
        String sort = request.getParameter("order");
        User user = (User) session.getAttribute("user");

        int page = 1;
        if (pageInput != null) {
            try {
                page = Integer.parseInt(pageInput);
                if (page < 1) {
                    page = 1;
                }
            } catch (NumberFormatException ignored) {
            }
        }

        List<Iteration> iterations;
        List<Subject> subjects = subDao.getAllSubjects();
        if (user.getRoleId() == 3) {
            subjects = subDao.getSubjectListByUID(user.getId());
        }

        int subject = subjects.get(0).getId();
        if (subjectId != null) {
            try {
                subject = Integer.parseInt(subjectId);
                if (subject < 1) {
                    subject = subjects.get(0).getId();
                }
            } catch (NumberFormatException ignored) {
            }
        }

        iterations = iterDao.getIterationsSubjectId(page, ENTRIES_PER_PAGE, subject);
        int totalIteration = iterDao.getTotalIterationsSubjectId(subject);

        if (status != null) {
            boolean trueStatus = false;
            if (status.equals("active")) {
                trueStatus = true;
            }
            iterations = iterDao.getIterationsSubjectIdAndStatus(page, ENTRIES_PER_PAGE, subject, trueStatus);
            totalIteration = iterDao.getTotalIterationsSubjectIdAndStatus(subject, trueStatus);
            request.setAttribute("query", "filterSubject=" + subject + "?filterStatus=" + status + '&');
            request.setAttribute("status", trueStatus);
        } else if (name != null) {
            iterations = iterDao.getIterationsSubjectIdAndName(page, ENTRIES_PER_PAGE, subject, name);
            totalIteration = iterDao.getTotalIterationsSubjectIdAndName(subject, name);
            request.setAttribute("query", "filterSubject=" + subject + "?searchName=" + name + '&');
            request.setAttribute("searchName", name);
        } else if (sort != null) {
            iterations = iterDao.getIterationsSubjectIdAndOrder(page, ENTRIES_PER_PAGE, subject, sort);
            request.setAttribute("query", "filterSubject=" + subject + "?order=" + sort + '&');
            request.setAttribute("order", sort);
        }
        int maxPage = customMath.ceiling(totalIteration, ENTRIES_PER_PAGE);

        request.setAttribute("filterSubjectId", subject);
        request.setAttribute("current-page", page);
        request.setAttribute("max-page", maxPage);
        request.setAttribute("subjects", subjects);
        request.setAttribute("iterations", iterations);
        request.setAttribute("panel", "iteration-list");
        request.getRequestDispatcher("/WEB-INF/dashboard/dashboard.jsp").forward(request, response);
    }

    private void iterationDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Subject> subjects = subDao.getSubjectListByUID(user.getId());
        if(subjects.isEmpty()) {
            subjects = subDao.getAllSubjects();
        }
        int id = Integer.parseInt(request.getParameter("id"));
        Iteration iter = iterDao.getIterationDetails(id);
        request.setAttribute("iteration", iter);
        request.setAttribute("subjects", subjects);
        request.setAttribute("panel", "iteration-detail");
        request.setAttribute("crudpath", "update");
        request.getRequestDispatcher("/WEB-INF/dashboard/dashboard.jsp").forward(request, response);
    }

    private void updateIterationStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int id = Integer.parseInt(request.getParameter("id"));
        boolean status = Boolean.parseBoolean(request.getParameter("status"));
        iterDao.updateIterationStatus(id, user.getId(), status);
        response.sendRedirect(request.getContextPath() + "/dashboard/iterations");
    }

    private void updateIterationDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        int iterId = Integer.parseInt(request.getParameter("iteration-id"));
        String iterName = request.getParameter("iteration-name");
        int subjectId = Integer.parseInt(request.getParameter("subject"));
        int evalWeight = Integer.parseInt(request.getParameter("eval-weight"));
        boolean onGoing = Boolean.parseBoolean(request.getParameter("on-going"));
        boolean status = Boolean.parseBoolean(request.getParameter("status"));
        String description = request.getParameter("description");

        Iteration iter = new Iteration();
        iter.setId(iterId);
        iter.setIteration_name(iterName);
        iter.setSubject_id(subjectId);
        iter.setEval_weight(evalWeight);
        iter.setOn_going(onGoing);
        iter.setStatus(status);
        iter.setDescription(description);

        iterDao.updateIterationDetails(iter, user.getId());
        response.sendRedirect(request.getContextPath() + "/dashboard/iterations/detail?id=" + iter.getId());
    }

    private void toAddIteration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Subject> subjects = subDao.getSubjectListByUID(user.getId());
        if(subjects.isEmpty()) {
            subjects = subDao.getAllSubjects();
        }
        request.setAttribute("subjects", subjects);
        request.setAttribute("panel", "iteration-detail");
        request.setAttribute("crudpath", "add");
        request.getRequestDispatcher("/WEB-INF/dashboard/dashboard.jsp").forward(request, response);
    }

    private void addNewIteration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        String iterName = request.getParameter("iteration-name");
        int subjectId = Integer.parseInt(request.getParameter("subject"));
        int evalWeight = Integer.parseInt(request.getParameter("eval-weight"));
        boolean onGoing = Boolean.parseBoolean(request.getParameter("on-going"));
        boolean status = Boolean.parseBoolean(request.getParameter("status"));
        String description = request.getParameter("description");

        Iteration iter = new Iteration();
        iter.setIteration_name(iterName);
        iter.setSubject_id(subjectId);
        iter.setEval_weight(evalWeight);
        iter.setOn_going(onGoing);
        iter.setStatus(status);
        iter.setDescription(description);

        iterDao.addNewIteration(iter, user.getId());
        response.sendRedirect(request.getContextPath() + "/dashboard/iterations");
    }
}

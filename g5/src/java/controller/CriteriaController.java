/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.CriteriaDAO;
import java.io.IOException;
import dao.IterationDAO;
import dao.SubjectDAO;
import entity.Criteria;
import entity.Iteration;
import entity.Subject;
import entity.User;
import utils.CustomMath;
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
@WebServlet(name = "CriteriaController", urlPatterns = {"/dashboard/criterias/*"})
public class CriteriaController extends HttpServlet {

    private static final Integer ENTRIES_PER_PAGE = 5;
    CustomMath customMath = new CustomMath();
    IterationDAO iterDao = new IterationDAO();
    CriteriaDAO criterDao = new CriteriaDAO();
    SubjectDAO subDao = new SubjectDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null || path.equals("/list")) {
            criteriaList(request, response);
        }
        switch (path) {
            case "/detail":
                criteriaDetails(request, response);
                break;
            case "/update":
                updateCriteriaStatus(request, response);
                break;
            case "/add":
                toAddCriteria(request, response);
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
                updateCriteriaDetails(request, response);
                break;
            case "/add":
                addNewCriteria(request, response);
                break;
        }
    }

    private void criteriaList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String pageInput = request.getParameter("page");
        String iterationId = request.getParameter("filterIteration");
        String subjectId = request.getParameter("filterSubject");
        String status = request.getParameter("filterStatus");
        String name = request.getParameter("searchName");
        String sort = request.getParameter("order");

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

        List<Criteria> criterias = null;
        List<Iteration> iterations = iterDao.getAllIterations();
        List<Subject> subjects = subDao.getAllSubjects();
        if (user.getRole_id() == 3) {
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

        iterations = iterDao.getAllIterationsSubjectId(subject);
        int iteration = iterations.get(0).getId();
        if (iterationId != null) {
            iteration = Integer.parseInt(iterationId);
            if (iteration < 1) {
                iteration = iterations.get(0).getId();
            }
        }
        criterias = criterDao.getCriteriaListBySubjectIdAndIterationId(page, ENTRIES_PER_PAGE, subject, iteration);
        int totalCriteria = criterDao.getTotalCriteriaBySubjectIdAndIterationId(subject, iteration);
        request.setAttribute("query", "filterSubject=" + subjectId + "&filterIteration=" + iterationId + '&');
        if (status != null) {
            boolean trueStatus = false;
            if (status.equals("active")) {
                trueStatus = true;
            }
            criterias = criterDao.getCriteriaListBySubjectIdAndIterationIdAndStatus(page, ENTRIES_PER_PAGE, subject, iteration, trueStatus);
            totalCriteria = criterDao.getTotalCriteriaBySubjectIdAndIterationIdAndStatus(subject, iteration, trueStatus);
            request.setAttribute("query", "filterSubject=" + subjectId + "&filterIteration=" + iterationId + "&filterStatus=" + status + '&');
            request.setAttribute("status", trueStatus);
        } else if (name != null) {
            criterias = criterDao.getCriteriaListBySubjectIdAndIterationIdAndName(page, ENTRIES_PER_PAGE, subject, iteration, name);
            totalCriteria = criterDao.getTotalCriteriaBySubjectIdAndIterationIdAndName(subject, iteration, name);
            request.setAttribute("query", "filterSubject=" + subjectId + "&filterIteration=" + iterationId + "&searchName=" + name + '&');
            request.setAttribute("searchName", name);
        } else if (sort != null) {
            criterias = criterDao.getCriteriaListBySubjectIdOrdered(page, ENTRIES_PER_PAGE, subject, sort);
            request.setAttribute("query", "filterSubject=" + subjectId + "&filterIteration=" + iterationId + "&order=" + sort + '&');
            request.setAttribute("order", sort);
        }

        int maxPage = customMath.ceiling(totalCriteria, ENTRIES_PER_PAGE);

        request.setAttribute("filterSubjectId", subject);
        request.setAttribute("filterIterationId", iterationId);
        request.setAttribute("current-page", page);
        request.setAttribute("subjects", subjects);
        request.setAttribute("max-page", maxPage);
        request.setAttribute("iterations", iterations);
        request.setAttribute("criterias", criterias);
        request.setAttribute("panel", "criteria-list");
        request.getRequestDispatcher("/WEB-INF/dashboard/dashboard.jsp").forward(request, response);
    }

    private void criteriaDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Criteria criter = criterDao.getIterationCriteriaDetails(id);
        String subjectName = criterDao.getSubjectNameByCriteriaId(id);
        String iterationName = criterDao.getIterationNameByCriteriaId(id);

        request.setAttribute("criteria", criter);
        request.setAttribute("panel", "criteria-details");
        request.setAttribute("subjectName", subjectName);
        request.setAttribute("iterationName", iterationName);
        request.getRequestDispatcher("/WEB-INF/dashboard/dashboard.jsp").forward(request, response);
    }

    private void updateCriteriaStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int id = Integer.parseInt(request.getParameter("id"));
        boolean status = Boolean.parseBoolean(request.getParameter("status"));
        criterDao.updateCriteriaStatus(id, user.getId(), status);
        response.sendRedirect(request.getContextPath() + "/dashboard/criterias");
    }

    private void updateCriteriaDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int criteriaId = Integer.parseInt(request.getParameter("criteria-id"));
        String criteriaName = request.getParameter("criteria-name");
        boolean isTeamEval = Boolean.parseBoolean(request.getParameter("team-eval"));
        int maxLOC = Integer.parseInt(request.getParameter("max-loc"));
        int evalWeight = Integer.parseInt(request.getParameter("eval-weight"));
        boolean isStatus = Boolean.parseBoolean(request.getParameter("status"));
        String description = request.getParameter("description");

        Criteria crite = new Criteria();
        crite.setId(criteriaId);
        crite.setCriteriaName(criteriaName);
        crite.setIsTeamEval(isTeamEval);
        crite.setMaxLoc(maxLOC);
        crite.setEvalWeight(evalWeight);
        crite.setStatus(isStatus);
        crite.setDescription(description);

        criterDao.updateCriteriaDetails(crite, user.getId());
        response.sendRedirect(request.getContextPath() + "/dashboard/criterias/detail?id=" + crite.getId());
    }

    private void toAddCriteria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int subjectId = Integer.parseInt(request.getParameter("subject"));
        List<Iteration> iterations = iterDao.getAllIterationsSubjectId(subjectId);

        request.setAttribute("iterations", iterations);
        request.setAttribute("panel", "criteria-add");
        request.getRequestDispatcher("/WEB-INF/dashboard/dashboard.jsp").forward(request, response);
    }

    private void addNewCriteria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int iterationId = Integer.parseInt(request.getParameter("iteration"));
        String criteriaName = request.getParameter("criteria-name");
        boolean isTeamEval = Boolean.parseBoolean(request.getParameter("team-eval"));
        int maxLOC = Integer.parseInt(request.getParameter("max-loc"));
        int evalWeight = Integer.parseInt(request.getParameter("eval-weight"));
        boolean isStatus = Boolean.parseBoolean(request.getParameter("status"));
        String description = request.getParameter("description");

        Criteria crite = new Criteria();
        crite.setIterationId(iterationId);
        crite.setCriteriaName(criteriaName);
        crite.setIsTeamEval(isTeamEval);
        crite.setMaxLoc(maxLOC);
        crite.setEvalWeight(evalWeight);
        crite.setStatus(isStatus);
        crite.setDescription(description);
        criterDao.addNewCriteria(crite, user.getId());
        response.sendRedirect(request.getContextPath() + "/dashboard/criterias");
    }
}

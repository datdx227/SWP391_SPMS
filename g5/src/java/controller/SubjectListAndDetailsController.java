/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.SubjectDAO;
import dao.UserDAO;
import entity.Manager;
import entity.Subject;
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
import utils.CustomMath;

/**
 *
 * @author quang
 */
@WebServlet(name = "SubjectController", urlPatterns = {"/dashboard/subjects/*"})
public class SubjectListAndDetailsController extends HttpServlet {

    private static final Integer ENTRIES_PER_PAGE = 5;
    CustomMath customMath = new CustomMath();
    UserDAO userDAO = new UserDAO();
    SubjectDAO subDao = new SubjectDAO();

    private void subjectList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String manager_id = request.getParameter("manager_id");
        String subject_code = request.getParameter("subject_code");
        String subject_name = request.getParameter("subject_name");
        String status = request.getParameter("status");
        String pageInput = request.getParameter("page");
        String order_by = request.getParameter("order_by");
        int page = pageInput == null ? 1 : Integer.parseInt(pageInput);

        String query = "";
        if (manager_id != null && !manager_id.trim().equalsIgnoreCase("0")) {
            query += (" WHERE " + "s.manager_id = " + manager_id);
        }
        if (status != null && !status.trim().equalsIgnoreCase("-1")) {
            query += (" AND " + "s.status = " + status);
        }
        if (subject_code != null && !"".equals(subject_code)) {
            query += (" AND " + "s.subject_code LIKE '%" + subject_code + "%'");
        }
        if (subject_name != null && !"".equals(subject_name)) {
            query += (" AND " + "s.subject_name LIKE '%" + subject_name + "%'");
        }
        int order = order_by == null ? (-1) : Integer.parseInt(order_by);
        if (order != -1) {
            query += " ORDER BY s.issue_id " + ((order == 0) ? "ASC" : "DESC");
        }

        List<Subject> subjects = subDao.getSubjects(query, page);
        List<Manager> managers = userDAO.getManagers();

        int maxpage = subjects.size() / ENTRIES_PER_PAGE;
        if (ENTRIES_PER_PAGE * maxpage < subjects.size()) {
            maxpage += 1;
        }

        List<Subject> subjects2 = new ArrayList<>();

        for (int i = (page - 1) * ENTRIES_PER_PAGE; i < page * ENTRIES_PER_PAGE; i++) {
            if (i < subjects.size()) {
                subjects2.add(subjects.get(i));
            } else {
                break;
            }
        }

        request.setAttribute("manager_id", manager_id == null ? 0 : manager_id);
        request.setAttribute("subject_code", subject_code == null ? "" : subject_code);
        request.setAttribute("subject_name", subject_name == null ? "" : subject_name);
        request.setAttribute("manager_id", manager_id == null ? 0 : manager_id);
        request.setAttribute("status", status == null ? -1 : status);
        request.setAttribute("order_by", order_by == null ? -1 : order_by);
        request.setAttribute("managers", managers);
        request.setAttribute("subjects", subjects2);
        request.setAttribute("maxpage", maxpage);
        request.setAttribute("panel", "subject-list");
        request.getRequestDispatcher("/WEB-INF/dashboard/dashboard.jsp").forward(request, response);
    }

    private void updateSubjectStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int id = Integer.parseInt(request.getParameter("id"));
        boolean status = Boolean.parseBoolean(request.getParameter("status"));
        subDao.updateSubjectStatus(id, user.getId(), status);
        response.sendRedirect(request.getContextPath() + "/dashboard/subjects");
    }

    private void subjectDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Manager> managers = userDAO.getManagers();

        int id = Integer.parseInt(request.getParameter("id"));
        Subject sub = subDao.getSubjectDetails(id);
        request.setAttribute("subject", sub);
        request.setAttribute("managers", managers);
        request.setAttribute("panel", "subject-details");
        request.setAttribute("crudpath", "update");
        request.getRequestDispatcher("/WEB-INF/dashboard/dashboard.jsp").forward(request, response);
    }

    private void updateSubjectDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        int subjectId = Integer.parseInt(request.getParameter("subject-id"));
        String subjectCode = request.getParameter("subject-code");
        String subjectName = request.getParameter("subject-name");
        int managerId = Integer.parseInt(request.getParameter("manager"));
        boolean status = Boolean.parseBoolean(request.getParameter("status"));
        String description = request.getParameter("description");

        Subject sub = new Subject();
        sub.setId(subjectId);
        sub.setSubject_code(subjectCode);
        sub.setSubject_name(subjectName);
        sub.setManager_id(managerId);
        sub.setStatus(status);
        sub.setDescription(description);

        subDao.updateSubjectDetails(sub, user.getId());
        response.sendRedirect(request.getContextPath() + "/dashboard/subjects");
    }

    private void toAddSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Manager> managers = userDAO.getManagers();

        request.setAttribute("managers", managers);
        request.setAttribute("panel", "subject-add");
        request.setAttribute("crudpath", "add");
        request.getRequestDispatcher("/WEB-INF/dashboard/dashboard.jsp").forward(request, response);
    }

    private void addNewSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        String subjectName = request.getParameter("subject-name");
        String subjectCode = request.getParameter("subject-code");
        int managerId = Integer.parseInt(request.getParameter("manager"));
        boolean status = Boolean.parseBoolean(request.getParameter("status"));
        String description = request.getParameter("description");

        Subject sub = new Subject();
        sub.setSubject_code(subjectName);
        sub.setSubject_name(subjectCode);
        sub.setManager_id(managerId);
        sub.setStatus(status);
        sub.setDescription(description);

        subDao.addNewSubject(sub, user.getId());
        response.sendRedirect(request.getContextPath() + "/dashboard/sucjects");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null || path.equals("/list")) {
            subjectList(request, response);
        } else if (path.equals("/detail")) {
            subjectDetails(request, response);
        } else if (path.equals("/update")) {
            updateSubjectStatus(request, response);
        } else if (path.equals("/add")) {
            toAddSubject(request, response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null) {
            return;
        } else if (path.equals("/update")) {
            updateSubjectDetails(request, response);
        } else if (path.equals("/add")) {
            addNewSubject(request, response);
        }
    }
}

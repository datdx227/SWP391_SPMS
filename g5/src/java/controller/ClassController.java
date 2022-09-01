/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.ClassDAO;
import dao.SubjectDAO;
import dao.UserDAO;
import entity.Subject;
import entity.User;
import entity.Class;
import entity.Term;
import entity.Trainer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "ClassController", urlPatterns = {"/dashboard/classes/*"})
public class ClassController extends HttpServlet {

    private static final Integer ENTRIES_PER_PAGE = 5;
    CustomMath customMath = new CustomMath();
    ClassDAO classDAO = new ClassDAO();
    SubjectDAO subDao = new SubjectDAO();
    UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null || path.equals("/list")) {
            classList(request, response);
        } else if (path.equals("/update")) {
            updateClassStatus(request, response);
        } else if (path.equals("/details")) {
            classDetails(request, response);
        } else if (path.equals("/add")) {
            toAddClass(request, response);
        }
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
        } else if (path.equals("/update")) {
            updateClassDetails(request, response);
        } else if (path.equals("/add")) {
            addNewClass(request, response);
        }
    }

    private void classList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String subject_id = request.getParameter("subject_id");
        String term_name = request.getParameter("term_name");
        String class_code = request.getParameter("class_code");
        String trainer_id = request.getParameter("trainer_id");
        String status = request.getParameter("status");
        String pageInput = request.getParameter("page");
        String order_by = request.getParameter("order_by");
        int page = pageInput == null ? 1 : Integer.parseInt(pageInput);

        String query = "";
        if (subject_id != null && !subject_id.trim().equalsIgnoreCase("0")) {
            query += (" AND " + "c.subject_id = " + subject_id);
        }
        if (trainer_id != null && !trainer_id.trim().equalsIgnoreCase("0")) {
            query += (" AND " + "c.trainer_id = " + trainer_id);
        }
        if (status != null && !status.trim().equalsIgnoreCase("-1")) {
            query += (" AND " + "c.status = " + status);
        }
        if (class_code != null && !"".equals(class_code)) {
            query += (" AND " + "c.class_code LIKE '%" + class_code + "%'");
        }
        if (term_name != null && !"".equals(term_name)) {
            query += (" AND " + "c.term_name LIKE '%" + term_name + "%'");
        }
        int order = order_by == null ? (-1) : Integer.parseInt(order_by);
        if (order != -1) {
            query += " ORDER BY c.class_id " + ((order == 0) ? "ASC" : "DESC");
        }

        List<Class> classes = classDAO.getClasses(query, page);
        List<Subject> subjects = subDao.getAllSubjects();
        List<Term> terms = classDAO.getTermList();
        List<Trainer> trainers = userDAO.getTrainers();

        int maxpage = classes.size() / ENTRIES_PER_PAGE;
        if (ENTRIES_PER_PAGE * maxpage < classes.size()) {
            maxpage += 1;
        }

        List<Class> classes2 = new ArrayList<>();

        for (int i = (page - 1) * ENTRIES_PER_PAGE; i < page * ENTRIES_PER_PAGE; i++) {
            if (i < classes.size()) {
                classes2.add(classes.get(i));
            } else {
                break;
            }
        }

        request.setAttribute("subject_id", subject_id == null ? 0 : subject_id);
        request.setAttribute("class_code", class_code == null ? "" : class_code);
        request.setAttribute("term_name", term_name == null ? "" : term_name);
        request.setAttribute("trainer_id", trainer_id == null ? 0 : trainer_id);
        request.setAttribute("status", status == null ? -1 : status);
        request.setAttribute("order_by", order_by == null ? -1 : order_by);
        request.setAttribute("subjects", subjects);
        request.setAttribute("terms", terms);
        request.setAttribute("trainers", trainers);
        request.setAttribute("classes", classes2);
        request.setAttribute("maxpage", maxpage);
        request.setAttribute("panel", "class-list");
        request.getRequestDispatcher("/WEB-INF/dashboard/dashboard.jsp").forward(request, response);
    }

    private void updateClassStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int id = Integer.parseInt(request.getParameter("id"));
        boolean status = Boolean.parseBoolean(request.getParameter("status"));
        classDAO.updateClassStatus(id, user.getId(), status);
        response.sendRedirect(request.getContextPath() + "/dashboard/classes");
    }

    private void classDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Subject> subjects = subDao.getAllSubjects();
        List<Term> terms = classDAO.getTermList();
        List<Trainer> trainers = userDAO.getTrainers();

        int id = Integer.parseInt(request.getParameter("id"));
        Class c = classDAO.getClassDetails(id);
        request.setAttribute("classes", c);
        request.setAttribute("subjects", subjects);
        request.setAttribute("terms", terms);
        request.setAttribute("trainers", trainers);
        request.setAttribute("panel", "class-details");
        request.setAttribute("crudpath", "update");
        request.getRequestDispatcher("/WEB-INF/dashboard/dashboard.jsp").forward(request, response);
    }

    private void updateClassDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        int classId = Integer.parseInt(request.getParameter("class-id"));
        String classCode = request.getParameter("class-code");
        int subjectId = Integer.parseInt(request.getParameter("subject"));
        String termName = request.getParameter("term");
        int trainerId = Integer.parseInt(request.getParameter("trainer"));
        boolean isBlock5 = Boolean.parseBoolean(request.getParameter("is_block5"));
        boolean status = Boolean.parseBoolean(request.getParameter("status"));

        Class c = new Class();
        c.setId(classId);
        c.setSubject_id(subjectId);
        c.setClass_code(classCode);
        c.setTerm_name(termName);
        c.setIs_block5(isBlock5);
        c.setTrainer_id(trainerId);
        c.setStatus(status);

        classDAO.updateClassDetails(c, user.getId());
        response.sendRedirect(request.getContextPath() + "/dashboard/classes");
    }

    private void toAddClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Subject> subjects = subDao.getAllSubjects();
        List<Term> terms = classDAO.getTermList();
        List<Trainer> trainers = userDAO.getTrainers();
        
        request.setAttribute("subjects", subjects);
        request.setAttribute("terms", terms);
        request.setAttribute("trainers", trainers);
        request.setAttribute("panel", "class-add");
        request.setAttribute("crudpath", "add");
        request.getRequestDispatcher("/WEB-INF/dashboard/dashboard.jsp").forward(request, response);
    }

    private void addNewClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        int classId = Integer.parseInt(request.getParameter("class-id"));
        String classCode = request.getParameter("class-code");
        int subjectId = Integer.parseInt(request.getParameter("subject"));
        String termName = request.getParameter("term");
        int trainerId = Integer.parseInt(request.getParameter("trainer"));
        boolean is_block5 = Boolean.parseBoolean(request.getParameter("is_block5"));
        boolean status = Boolean.parseBoolean(request.getParameter("status"));

        Class c = new Class();
        c.setId(classId);
        c.setSubject_id(subjectId);
        c.setClass_code(classCode);
        c.setTerm_name(termName);
        c.setTrainer_id(trainerId);
        c.setIs_block5(is_block5);
        c.setStatus(status);

        classDAO.addNewClass(c, user.getId());
        response.sendRedirect(request.getContextPath() + "/dashboard/classes");
    }
}

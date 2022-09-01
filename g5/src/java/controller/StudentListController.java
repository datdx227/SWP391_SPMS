package controller;

import dao.StudentDAO;
import entity.Student;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author BarePC
 */
public class StudentListController extends HttpServlet {

    private final int PAGE_SIZE = 5;

//    private void getParameter(HttpServletRequest request) throws ServletException, IOException {
//        String param = "?";
//        for (Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
//            if (!entry.getKey().equals("index")) {
//                param += entry.getKey() + "=" + entry.getValue()[0] + "&";
//            }
//        }
//        request.setAttribute("parameter", param);
//    }

    private int Update(HttpServletRequest request) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("team_id"));
        int student_id = Integer.parseInt(request.getParameter("id"));
//        String title = request.getParameter("title");
//        int value = Integer.parseInt(request.getParameter("value"));
//        int display_order = Integer.parseInt(request.getParameter("display_order"));
//        int status = Integer.parseInt(request.getParameter("status"));
//        String description = request.getParameter("description");
        return new StudentDAO().updateSubject(id,student_id);
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //int index = request.getParameter("index") != null ? Integer.parseInt(request.getParameter("index")) : 1;
        ArrayList<Student> list = new StudentDAO().getAllStudent();
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");
        String message = "";
        if (request.getParameter("statusSet") != null) {
            String status = request.getParameter("statusSet").equals("1") ? "0" : "1";
            String id = request.getParameter("id");
            if (new StudentDAO().change(status, id) != -1) {
                message = "Change status success";
            }

        }
        switch (action) {
            case "searchName":
                String title = request.getParameter("name");
                list = new StudentDAO().searchName(title);
                request.setAttribute("searchName", title);
                break;
            case "searchMail":
                String value = request.getParameter("mail");
                list = new StudentDAO().searchMail(value);
                request.setAttribute("searchMail", value);
                break;
            case "searchRole":
                String role = request.getParameter("role");
                list = new StudentDAO().searchRole(Integer.parseInt(role));
                request.setAttribute("searchRole", role);
                break;
            case "filterTeam":
                list = new StudentDAO().filterTeam(Integer.parseInt(request.getParameter("team_id")));
                break;
            case "filterStatus":
                String status = request.getParameter("status");
                list = new StudentDAO().filterStatus(Integer.parseInt(status));
                request.setAttribute("status", status);
                break;
            case "update":
                Update(request);
                message = "Update success";
                list = new StudentDAO().getAllStudent();
                break;
        }
//        int pageTotal;
//        if (!list.isEmpty()) {
//            int numOfRecord = list.get(0).getNumOfRecord();
//            if (numOfRecord % PAGE_SIZE == 0) {
//                pageTotal = numOfRecord / PAGE_SIZE;
//            } else {
//                pageTotal = numOfRecord / PAGE_SIZE + 1;
//            }
//            request.setAttribute("pageTotal", pageTotal);
//        }

        //getParameter(request);
//        request.setAttribute("list", new StudentDAO().getAllStudent());
        //request.setAttribute("list", list);
        request.setAttribute("listTeam", new StudentDAO().getAllTeam());
        request.setAttribute("list", list);
        request.setAttribute("message", message);
        request.getRequestDispatcher("studentlist.jsp").forward(request, response);
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

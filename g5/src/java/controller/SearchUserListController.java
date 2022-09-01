/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.SettingClass;
import entity.User;
import utils.Paging;
import java.nio.charset.StandardCharsets;
import utils.Constant;

/**
 *
 * @author Acer
 */
@WebServlet(name = "SearchUserListController", urlPatterns = {"/userlist"})
public class SearchUserListController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String SEARCHBYNAME = "Search";
    private final String FILTERBYROLE = "FilterByROLE";
    private final String FILTERBYSTATUS = "FilterByStatus";
    private final String PAGING = "Paging";
    private final String SHOWSETTINGLIST = "ShowSettingList";
    private void searchByName(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        //request.setCharacterEncoding("UTF-8");
        String name= request.getParameter("name");
        
        if (name==null) name="";
       // byte[] bytes = name.getBytes(StandardCharsets.ISO_8859_1);
       // name = new String(bytes, StandardCharsets.UTF_8);
        List<User> list = new UserDAO().getUsers();
        Iterator ite = list.iterator();
        name = name.toLowerCase();
        while(ite.hasNext()){
            User user = (User) ite.next();
            //String a = user.getFullName();
            if (!user.getEmail().toLowerCase().contains(name)) ite.remove();
        }
        request.getSession().setAttribute("UserList", list);
    }
    private void filterByStatus(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        //String name= request.getParameter("name");
        int status = Integer.parseInt(request.getParameter("status"));
        List<User> list = new UserDAO().getUsers();
        Iterator ite = list.iterator();
       
        //name = name.toLowerCase();
        while(ite.hasNext()){
            User user = (User) ite.next();
            System.err.println(user.getStatus());
            if (user.getStatus()!=status) ite.remove();
        }
        request.getSession().setAttribute("UserList", list);
    }
    private void filterByRole(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        //String name= request.getParameter("name");
        int status = Integer.parseInt(request.getParameter("role"));
        String role ="";
        if (status == 1) role ="Admin";
        else if (status ==2) role = "User";
        
        List<User> list = new UserDAO().getUsers();
        Iterator ite = list.iterator();
        //name = name.toLowerCase();
        while(ite.hasNext()){
            User user = (User) ite.next();
            if (user.getRole_id()!= status) ite.remove();
        }
        request.getSession().setAttribute("UserList", list);
    }
    private List<User> show(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
         String pageStr = request.getParameter("page");
        int page = 1;
        if (pageStr != null) page = Integer.parseInt(pageStr);
        //request.setAttribute("page", page);
        
        List<User> list = (List<User>) request.getSession().getAttribute("UserList");
        Paging<User> paging = new Paging<User>(list);
         request.setAttribute("page", page);
        if (paging.isNext(page)) request.setAttribute("isnext", "OK");
        return paging.show(page);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("Action");
        if (action==null) action = SEARCHBYNAME;
        if (action.equals(SEARCHBYNAME)){
            searchByName(request, response);
            request.getSession().setAttribute("Action", action);
        }else if (action.equals(FILTERBYSTATUS)){
            filterByStatus(request, response);
            request.getSession().setAttribute("Action", action);
        }else if (action.equals(FILTERBYROLE)){
            filterByRole(request, response);
            request.getSession().setAttribute("Action", action);
        }
        List<User> list = show(request, response);
        request.setAttribute("UserList", list);
        request.setAttribute("panel", Constant.USERLISTPAGE);
        request.getRequestDispatcher("/WEB-INF/dashboard/dashboard.jsp").forward(request, response);
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

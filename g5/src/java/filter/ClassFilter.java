/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package filter;

import entity.User;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Seth
 */
@WebFilter(filterName = "ClassFilter", urlPatterns = {"/dashboard/classes/detail", "/dashboard/classes/update"})
public class ClassFilter implements Filter {

    @Override
    public void init(FilterConfig config) {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession s = httpRequest.getSession();
        // Prohibits Trainers
        try {
            if (s.getAttribute("user") != null) {
                User u = (User) s.getAttribute("user");
                if (u.getRoleId() == 4) {
                    httpRequest.getRequestDispatcher("/WEB-INF/common/forbidden.jsp").forward(request, response);
                    return;
                }
                chain.doFilter(request, response);
            } else {
                httpResponse.sendRedirect("/SPM/login");
            }
        } catch (Exception e) {
        }
    }
}

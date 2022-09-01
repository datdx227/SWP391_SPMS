/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package filter;

import entity.User;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Seth
 */
@WebFilter(filterName = "TrackingUpdateFilter", urlPatterns = {"/updates/*"})
public class TrackingUpdateFilter implements Filter {

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

        // Prohibits guests
        User user = (User) httpRequest.getSession().getAttribute("user");
        if (user == null) {
            httpRequest.getRequestDispatcher("/WEB-INF/common/forbidden.jsp").forward(request, response);
            return;
        }
        chain.doFilter(request, response);
    }

}

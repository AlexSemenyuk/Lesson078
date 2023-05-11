package org.itstep.filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.itstep.data.User;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class AuthentificationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        System.out.println("Filter: " + req.getRequestURI());

        User user = null;
        if (session.getAttribute("user") != null) {
            user = (User) session.getAttribute("user");
            System.out.println("Filter" + user.toString());
        }
        String reqURI = req.getRequestURI();
        String reqContextPath = req.getServletContext().getContextPath();

        if (reqURI.equals(reqContextPath + "/")) {
            if (user == null) {
                chain.doFilter(request, response);
                return;
            } else if (user.getLogin().equals("admin") && user.getPassword().equals("admin")) {
                resp.sendRedirect(reqContextPath + "/admin");
                return;
            } else {
                resp.sendRedirect(reqContextPath + "/home");
                return;
            }
        }
        if (reqURI.equals(reqContextPath + "/admin")) {
            if (user == null) {
                resp.sendRedirect(reqContextPath + "/");
                return;
            } else if (user.getLogin().equals("admin") && user.getPassword().equals("admin")) {
                chain.doFilter(request, response);
                return;
            } else {
                resp.sendRedirect(reqContextPath + "/home");
                return;
            }
        }

        if (user == null) {
            resp.sendRedirect(reqContextPath + "/");
            return;
        }
        chain.doFilter(request, response);
    }
}


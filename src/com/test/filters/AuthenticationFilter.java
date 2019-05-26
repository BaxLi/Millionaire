package com.test.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthenticationFilter implements Filter {

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filter)
            throws IOException, ServletException {
        //pre-processing
        HttpServletRequest request = (HttpServletRequest) req;
        if (request.getRequestURI().startsWith("/Millionaire/login")) 
            { 
                HttpSession session = request.getSession();
                    if (session.getAttribute("username") == null) {
                            request.getRequestDispatcher("/html/login.jsp").forward(request, resp);
                        }
        }
        filter.doFilter(request, resp);
        //post-processing

    }
}

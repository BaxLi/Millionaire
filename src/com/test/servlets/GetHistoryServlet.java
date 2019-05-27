package com.test.servlets;

import com.test.beans.ActivityItem;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.dao.ApplicationDao;

@WebServlet("/getHistory")
public class GetHistoryServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //get the HTTPSession object
        HttpSession session = request.getSession();

        //create a cart as arraylist for the user
        List<ActivityItem> myActivity = (ArrayList<ActivityItem>) session.getAttribute("myactivity");

        if (myActivity == null) {
            myActivity = new ApplicationDao().getLastActivity((String) session.getAttribute("username"), 5);
        } 
        
        //set the results in session scope
        session.setAttribute("myactivity", myActivity);

        //forward to history view page.jsp
        request.getRequestDispatcher("/html/history.jsp").forward(request, response);

    }

}

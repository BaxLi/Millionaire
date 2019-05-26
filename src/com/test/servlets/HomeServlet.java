package com.test.servlets;

import com.test.dao.DBConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/index.html", "/home"})
//@WebServlet("")

public class HomeServlet extends HttpServlet {

//    public Connection connection = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        req.getRequestDispatcher("/html/index.html").forward(req, resp);
    }

//    @Override
//    public void init() throws ServletException {
////    super.init();
//        //setup DB connection
//        System.out.println("inside init method");
//        connection = DBConnection.getConnectionToDatabase();
//    }
//
//    @Override
//    public void destroy() {
//        System.out.println("inside destroy method");
//        try {
//            connection.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(HomeServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }

}

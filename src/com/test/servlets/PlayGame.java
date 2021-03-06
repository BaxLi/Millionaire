package com.test.servlets;

import com.test.beans.CurrentGame;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.text.MessageFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dao.ApplicationDao;
import com.test.dao.SQLrequests;
import javax.servlet.http.HttpSession;

@WebServlet("/playGame")
public class PlayGame extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        HttpSession session = req.getSession();
        CurrentGame game = (CurrentGame) session.getAttribute("currentGame");
        game.getGameQuestions().add(SQLrequests.getRandomQuestion(1));
        
        req.getRequestDispatcher("/html/playGame.jsp").forward(req, resp);
    }
}

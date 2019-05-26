package com.test.servlets;

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

import com.test.beans.Product;
import com.test.beans.Question;
import com.test.dao.ApplicationDao;

@WebServlet("/addQuestionToDB")
public class AddQuestionToDB extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/html/addQuestion.jsp").forward(request, response);
    }

    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Question qs = new Question();
        qs.setQuestion(req.getParameter("question"));
        qs.setAnswer1(req.getParameter("answer1"));
        qs.setAnswer2(req.getParameter("answer2"));
        qs.setAnswer3(req.getParameter("answer3"));
        qs.setAnswer4(req.getParameter("answer4"));
        String correctAnswer = (String) req.getParameter("correctAnswer");
        qs.setCorrectAnswer(Integer.valueOf(correctAnswer));

        String questionlevel = (String) req.getParameter("questionlevel"); // money amount compensation for this qs
        qs.setQuestionlevel(Integer.valueOf(questionlevel));
        
        boolean result=new ApplicationDao().addQuestionToDb(qs);
        
        req.getRequestDispatcher("/html/home.jsp").forward(req, resp);
    }

}

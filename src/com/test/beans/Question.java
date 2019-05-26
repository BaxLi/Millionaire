/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.beans;

/**
 *
 * @author User
 */
public class Question {
    private String question="not read from DB ";
    private String answer1="No answer1";
    private String answer2="No answer2";
    private String answer3="No answer3";
    private String answer4="No answer4";
    private int correctAnswer;
    private int questionlevel;

    public int getQuestionlevel() {
        return questionlevel;
    }

    public void setQuestionlevel(int questionlevel) {
        this.questionlevel = questionlevel;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }
    
}

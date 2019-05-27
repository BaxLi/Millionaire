/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.beans;

import com.test.dao.SQLrequests;
import java.util.ArrayList;


/**
 *
 * @author User
 */
public class CurrentGame {

    private String user;
    private String session;
    private ArrayList<Question> gameQuestions;
    private int lastAnswered;

    public CurrentGame(String user) {
        this.user = user;
        gameQuestions = new ArrayList<Question>();
        gameQuestions.add(SQLrequests.getRandomQuestion(1));
    }

    public String getUser() {
        return user;
    }

    public ArrayList<Question> getGameQuestions() {
        return gameQuestions;
    }

    public int getLastAnswered() {
        return lastAnswered;
    }

    public void setLastAnswered(int lastAnswered) {
        this.lastAnswered = lastAnswered;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.dao;

import com.test.beans.Question;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class SQLrequests {

    public static Question getRandomQuestion(int questionLevel) {
        Question randomQuestion = null;
        Random randomGenerator = new Random();
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            String sql = "select * from questions where questionlevel like '%" + questionLevel + "%'";
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(sql);
            int setSize = 0;
            if (set != null) {
                set.beforeFirst();
                set.last();
                setSize = set.getRow();
                set.first();
                int randomNr = randomGenerator.nextInt(setSize) + 1;
                int i = 1;
                while (i < randomNr) {
                    set.next();
                    i++;
                }
                randomQuestion = new Question(set);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLrequests.class.getName()).log(Level.SEVERE, null, ex);
        }
        return randomQuestion;
    }
}

package com.test.dao;

import com.test.beans.ActivityItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.test.beans.Order;
import com.test.beans.Product;
import com.test.beans.Question;
import com.test.beans.User;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import org.apache.jasper.tagplugins.jstl.core.ForEach;

public class ApplicationDao {

    public boolean addQuestionToDb(Question question) {
        boolean executed = false;
        try {
            // get the connection for the database
            Connection connection = DBConnection.getConnectionToDatabase();

            // write the insert query
            String insertQuery = "insert into questions(question, rightanswer, answer1, answer2, answer3, answer4, questionlevel)"
                    + " values(?,?,?,?,?,?,?)";

            // set parameters with PreparedStatement
            java.sql.PreparedStatement statement = connection.prepareStatement(insertQuery);
            statement.setString(1, question.getQuestion());
            statement.setInt(2, question.getCorrectAnswer());
            statement.setString(3, question.getAnswer1());
            statement.setString(4, question.getAnswer2());
            statement.setString(5, question.getAnswer3());
            statement.setString(6, question.getAnswer4());
            statement.setInt(7, question.getQuestionlevel());

            // execute the statement
            statement.executeUpdate();
            executed = true;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return executed;
    }

    public List<Product> searchQuestions(String searchString, Connection connection) {
        Product product = null;
        List<Product> products = new ArrayList<>();
        // Connection connection = DBConnection.getConnectionToDatabase();
        try {

            String sql = "select * from products where product_name like '%" + searchString + "%'";

            Statement statement = connection.createStatement();

            ResultSet set = statement.executeQuery(sql);

            while (set.next()) {
                product = new Product();
                product.setProductId(set.getInt("product_id"));
                product.setProductImgPath(set.getString("image_path"));
                product.setProductName(set.getString("product_name"));
                products.add(product);

            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return products;
    }

    public int registerUser(User user) {
        int rowsAffected = 0;
        try {
            // get the connection for the database
            Connection connection = DBConnection.getConnectionToDatabase();

            // write the insert query
            String insertQuery = "insert into users values(?,?,?,?,?,?)";

            // set parameters with PreparedStatement
            java.sql.PreparedStatement statement = connection.prepareStatement(insertQuery);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getLastName());
            statement.setInt(5, user.getAge());
            statement.setString(6, user.getActivity());

            // execute the statement
            rowsAffected = statement.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowsAffected;
    }

    public boolean validateUser(String username, String password) {
        boolean isValidUser = false;
        try {

            // get the connection for the database
            Connection connection = DBConnection.getConnectionToDatabase();

            // write the select query
            String sql = "select * from users where username=? and password=?";

            // set parameters with PreparedStatement
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            // execute the statement and check whether user exists
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                isValidUser = true;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return isValidUser;
    }

    public User getProfileDetails(String username) {
        User user = null;
        try {
            // get connection to database
            Connection connection = DBConnection.getConnectionToDatabase();

            // write select query to get profile details
            String sql = "select * from users where username=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);

            // execute query, get resultset and return User info
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                user = new User();
                user.setUsername(set.getString("username"));
                user.setFirstName(set.getString("first_name"));
                user.setLastName(set.getString("last_name"));
                user.setActivity(set.getString("activity"));
                user.setAge(set.getInt("age"));

            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return user;
    }

    public void setUserJustLogged(String username) {
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String loggedTime = sdf.format(dt);

        try {
            // get the connection for the database
            Connection connection = DBConnection.getConnectionToDatabase();

            // write the insert query
            String insertQuery = "INSERT INTO usersactivity (username, points, action) VALUES('" + username + "',0,'login')";
            Statement statement = connection.createStatement();
            statement.executeUpdate(insertQuery);

        } catch (SQLException exception) {
            exception.printStackTrace();
//            System.out.println(exception);
        }

    }

    public List<ActivityItem> getLastActivity(String username, int deepOfActivity) {
        List<ActivityItem> allActivity = this.getActivity(username);
        Iterator<ActivityItem> allActivityIterator = allActivity.iterator();
        List<ActivityItem> myActivity = new ArrayList<ActivityItem>();
        if (deepOfActivity <= 0) {
            deepOfActivity = 5;
        }
        int i = 0;
        while (allActivityIterator.hasNext()) {
            i++;
            if (i <= deepOfActivity) {
                myActivity.add(allActivityIterator.next());
            } else {
                break;
            }

        }
        return myActivity;
    }

    public List<ActivityItem> getActivity(String username) {
        List<ActivityItem> myList = new ArrayList<>();
        ActivityItem activityItem = null;

        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            String sql = "select * from usersactivity where username like '%" + username + "%'";
            Statement statement = null;
            if (connection != null) {
                statement = connection.createStatement();
                ResultSet set = statement.executeQuery(sql);
                while (set.next()) {
                    activityItem = new ActivityItem();
                    activityItem.timeOfActivity = set.getTimestamp("timestamp").toString();
                    String act = set.getString("action");
                    activityItem.descriptionOfActivity = ((act == null) ? "- no comments -" : act);
                    myList.add(activityItem);
                }
            }
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
        return myList;
    }
}

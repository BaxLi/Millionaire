<%@page import="java.util.Iterator"%>
<%@page import="com.test.beans.ActivityItem"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="UTF-8">
        <title>Millionaire - history</title>
        <link rel="stylesheet" href="css/style.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%@include file="header.jspf" %>

        <form action='addQuestionToDB' method='post'>
            <div class="form-group ">
                <label for="question" class="form-control-lg">Question here</label>
                <textarea class="form-control" name="question" rows="2"></textarea>
            </div>
            <div class="row form-control-lg">
                <div class="col">
                    <input type="text" class="form-control" placeholder="Answer 1" name='answer1'>
                </div>
                <div class="col">
                    <input type="text" class="form-control" placeholder="Answer 2" name='answer2'>
                </div>
            </div>
            <div class="row form-control-lg">
                <div class="col">
                    <input type="text" class="form-control" placeholder="Answer 3" name='answer3'>
                </div>
                <div class="col">
                    <input type="text" class="form-control" placeholder="Answer 4" name='answer4'>
                </div>
            </div>

            <div class="form-row col-md-12">
                <label for="selectCorrectAnswer" class="font-weight-bold text-warning form-control-lg form-group col-md-2">Select correct answer</label>
                <select class="form-group col-md-1" name="correctAnswer" id="selectCorrectAnswer">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                </select>
                <label for="amount" class="font-weight-bold text-warning form-control-lg form-group col-md-2">Fill money amount for correct answer</label>
                 <div class="col">
                    <input type="text" class="form-control col-md-2" placeholder="0" name='questionlevel' id="amount">
                </div>
                <az class="form-group col-md-3"></az>
                <input type="submit" class="btn btn-primary" value="SAVE_to_DB">
            </div>
        </form>
        
        <%@include file="footer.jspf" %>
    </body>
</html>
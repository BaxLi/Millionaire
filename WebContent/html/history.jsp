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

        <table >
            <tr>
                <td>Timestamp</td>
                <td>Description</td>
            </tr>
            <%
                List<ActivityItem> myActivity = (List) session.getAttribute("myactivity");
                Iterator<ActivityItem> myActivityIterator=myActivity.iterator();
                while (myActivityIterator.hasNext()) {
                    ActivityItem item = myActivityIterator.next();
            %>
            <tr>
                <td> <%=item.timeOfActivity%></td>  
                <td> <%=item.descriptionOfActivity%></td>  
            </tr>
            <%
                }
            %>
        </table>

        <%@include file="footer.jspf" %>
    </body>
</html>
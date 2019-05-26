<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Millionaire</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>

        <%@include file="header.jspf"%>

        <myTags:formatDate date="<%=Calendar.getInstance().getTime()%>" format="dd-MM-YYYY"/>
        <section id="profile" class="section">
            <div class="container">
                <h2 class="headline">My Profile</h2>
                <table id="profile">

                    <tr>
                        <td>Username</td>
                        <td>${user.username}</td>
                    </tr>
                    <tr>
                        <td>First Name</td>
                        <td>${user.firstName}</td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td>${user.lastName}</td>
                    </tr>
                    <tr>
                        <td>Age</td>
                        <td>${user.age}</td>
                    </tr>
                    <tr>
                        <td>Interested in</td>
                        <td>${user.activity}</td>
                    </tr>

                </table>
            </div>
            <div class="container">

            </div>
        </section>

        <%@include file="footer.jspf"%>
    </body>
</html>
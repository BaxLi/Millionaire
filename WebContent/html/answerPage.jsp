<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Millionaire-ANSWER</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>

        <%@include file="header.jspf"%>

        <myTags:formatDate date="<%=Calendar.getInstance().getTime()%>" format="dd-MM-YYYY"/>
        
        <section id="profile" class="section">
            <div class="container">
                
                <h2 class="headline">Current game result</h2>
                
                <table id="answered">

                    <tr>
                        <td>Username</td>
                        <td> <%=session.getAttribute("username")%> </td>
                        <td> <%=session.getAttribute("isAdmin")%></td>
                        
                    </tr>
                    
                </table>
            </div>
                    
            <div class="container">

            </div>
        </section>

        <%@include file="footer.jspf"%>
    </body>
</html>
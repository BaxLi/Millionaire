<!DOCTYPE html>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Millionaire - Login</title>
        <link rel="stylesheet" href="css/style.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%@include file="header.jspf"%>
        <!-- #home -->
        <section>
            <!-- displays date and time for today -->
            <%=displayDate()%>
        </section>
        <section id="login" class="section">
            <div class="container tagline">
                <%
                    if (request.getAttribute("error") != null) {
                %>
                <%=request.getAttribute("error")%><br />
                <%
                    }
                %>
                <em>LOGIN USER</em>
                <form action="login" method="post">
                    <label>Username</label> <input type="text"     name="username" id="username"><br /> 
                    <label>Password</label> <input type="password" name="password" id="password"><br /> 
                    <input type="submit" value="Login">
                </form>
            </div>
        </section>
        <!-- #products -->

        <%@include file="footer.jspf"%>
        <!-- footer -->
        <%!public String displayDate() {
                SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd hh:mm");
                Date date = Calendar.getInstance().getTime();
                return dateFormat.format(date);
            }%>
    </body>
</html>
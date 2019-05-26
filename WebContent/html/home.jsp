<!DOCTYPE html>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>--%>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Millionaire - HOME</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <!--  header   -->
        <%@include file="header.jspf"%>

        <section class="container-fluid h2" style="background-color: red;">
            <div class="row d-flex justify-content-center">

                <div class="col-2" style="background-color: blueviolet;">
                </div>
                <div class="col-6" >
                    <!--style="background-image:url('../images/start.jpg') no-repeat center center;height:800; width:600;">--> 
                    <div class="row d-flex justify-content-center">
                        <img src="../images/start.jpg" class="img-fluid" alt="IMAGE"> 
                    </div>
                    <div class="row d-flex justify-content-center">
                        <form action="playGame" method="post">
                            <button type="button" class="btn btn-secondary btn-lg">Instructions</button>
                            <button type="button" class="btn btn-primary btn-lg" onClick="redirectPage('<%=response.encodeURL("playGame")%>')" href='<%=response.encodeURL("playGame")%>'>PlayGame</button>
                            <button type="button" class="btn btn-info btn-lg">Info</button>
                        </form>
                    </div>
                </div> 
                <div class="col-2" style="background-color: blue;">
                </div>

                <script>
                    function redirectPage(pageName) {
                        window.location.href = pageName;
                    }
                </script>
            </div>
        </section>


        <%@include file="footer.jspf" %>
    </body>
</html>
<%@page import="com.test.beans.Question"%>
<%@page import="com.test.beans.CurrentGame"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>playGame</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <!--  header   -->
        <%@include file="header.jspf"%>

        <section class="container-fluid h2" style="background-color: aquamarine;">
            <div class="row d-flex justify-content-center">
                <div class="col-2" style="background-color: blueviolet;">
                </div>
                <div class="col-6" >
                    <div class="row d-flex justify-content-center">
                        <img src="../images/background.jpg" class="img-fluid" alt="IMAGE"> 
                        <someitem class="table-responsive-md col-12"> 
                            <%
                                if (session.getAttribute("currentGame") != null) {
                                    CurrentGame gm = (CurrentGame) session.getAttribute("currentGame");
                                    Question gmq = gm.getGameQuestions().get(0);
                            %>
                            <td>

                                Last answerred question--> 
                                <%=(int) gm.getLastAnswered()%>
                            </td>
                            <td>
THE QUESTION IS: 
                                <%=gmq.getQuestion()%>
                                <%

                                } else {%>
                                element is null!!
                                <%
                                    }
                                %>
                            </td>
                        </someitem>

                        <tbr class="table-responsive-md">
                            <table>
                                <tr id="question" >
                                    <td id="question" colspan="2" >
                                        <%
                                            CurrentGame gm = (CurrentGame) session.getAttribute("currentGame");
                                        %>
                                        <%
                                            gm.getGameQuestions().get(gm.getLastAnswered());
                                        %>                                
                                    </td>
                                </tr>

                                <tr>
                                    <td id="answer1"> Answer 1 </td>
                                    <td id="answer2"> Answer 2 </td>
                                </tr>
                                <tr>
                                    <td id="answer3" >

                                        <button type="button" class="btn btn-info btn-lg" 
                                                onClick="redirectPage('<%=response.encodeURL("answerPage")%>')">Answer 3</button>

                                    </td>
                                    <td id="answer4"> Answer 4 </td>
                                </tr>
                            </table>
                        </tbr>

                    </div>
                    <div class="row d-flex justify-content-center">
                        <!--<button type="button" class="btn btn-info btn-lg">Info</button>-->
                    </div>
                </div> 
                <div class="col-2" style="background-color: blue;">
                </div>

            </div>
        </section>


        <%@include file="footer.jspf" %>
    </body>
</html>
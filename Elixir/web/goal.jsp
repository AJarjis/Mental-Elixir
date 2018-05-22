<%@page import="Model.Activity"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@page import="Model.Goal"%>
<%@page import="Controller.UserController"%>
<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Checks if a user is logged in, redirecting them to register/login page if not-->
<%
    UserController user = (UserController) session.getAttribute("user");
    if (user == null) {
        RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
        rd.forward(request, response);
    }
%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../../../favicon.ico">
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
        <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
        <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#datepicker").datepicker();
            });
        </script>
        <title>elixir</title>


        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <!-- Custom styles for this template -->
        <link rel="stylesheet" type="text/css" href="css/styles.css">
        <style>
            body {

                padding-top: 65px;
                background-color: #FDFFFC;

            }

            .navbar-expand-md {
                box-shadow: 2px 2px 10px #000000;
            }

            h5 {
                color: white;
            }

            label {
                color: white;
            }

            .inputError {
                color: red;
            }

        </style>
    </head>

    <!-- Checks if a user is logged in, redirecting them to register/login page if not-->


    <body>

        <div class="naiveBar" id="navBarPlaceholder"></div>

        <div class="flex-container p-5" style="background-color: #FDFFFC">
            <div class="container" style="width: 80%; background-color: #FDFFFC">
                <div class="row justify-content-center">
                    <div class="col-sm-8 mb-5 ">
                        <div class="card-body">
                            <span>${errorMessages.errorMain}</span>
                            <h5 style="color: gray">Goal Test</h5>
                            <form action="Test" method="POST">
                                <div class="form-group">
                                    <label style="color: gray" for="description">Goal Description</label>
                                    <input type="text" class="form-control" id="userName" name="description">

                                </div>
                                <div class="form-group">
                                    <label style="color: gray" for="targetDate">Date</label>
                                    <input type="date" class="form-control" id="datepicker" name="targetDate">

                                </div>
                                <div class="form-group">
                                    <label style="color: gray" for="activity1">Activity 1 type</label>
                                    <select name="activity">
                                        <option value="Body">Body</option>
                                        <option value="Mind">Mind</option>
                                        <option value="Communication">Communication</option>
                                        <option value="StressReduction">Stress reduction</option>
                                        <option value="Love">Love</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label style="color: gray" for="activity1">Activity 1 description</label>
                                    <input type="descrption" class="form-control" id="desc" name="activitydesc">

                                </div>
                                <div class="form-group">
                                    <label style="color: gray" for="activity1">Activity 2 type</label>
                                    <select name="activity2">
                                        <option value="Body">Body</option>
                                        <option value="Mind">Mind</option>
                                        <option value="Communication">Communication</option>
                                        <option value="StressReduction">Stress reduction</option>
                                        <option value="Love">Love</option>
                                    </select>
                                </div>
                                <div>
                                    <label style="color: gray" for="password">Activity 2 description</label>
                                    <input type="descrption" class="form-control" id="desc" name="activity2desc">

                                </div>
                                <div class="card p-5">
                                    <input style="color: white" class="btn btn-primary" type="submit" value="Add Goal">
                                    <!--                                                <input style="color: white" class="btn btn-secondary" type="submit" value="Test Button 02">
                                                                                    <input style="color: white" class="btn btn-primary" type="submit" value="Test Button 03">
                                                                                    <input style="color: white" class="btn btn-secondary" type="submit" value="Test Button 04">
                                                                                    <input style="color: white" class="btn btn-primary" type="submit" value="Test Button 05">
                                                                                    <input style="color: white" class="btn btn-secondary" type="submit" value="Test Button 06">
                                                                                    <input style="color: white" class="btn btn-primary" type="submit" value="Test Button 07">-->
                                </div>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!--DISPLAY GOALS-->                    
        <table width="59%" border="1">
            <tr>
                <th>
                    Description
                </th>
                <th>
                    Target Date
                </th>
                <th>
                    Completion Status
                </th>
                <th>
                    Goal Activities
                </th>
            </tr>
            <!--Way of inserting Goal details that already exist for current user-->
            <%
                List<Goal> lGoal = user.getProfile().getGoal();
                for (Goal g : lGoal) {
            %>
            <tr>
                <td>
                    <%
                        if (g.getDescription() != null) {
                            out.print(g.getDescription());
                        } else {
                            out.print("No description set");
                        }
                    %>
                </td>
                <td>
                    <%
                        if (g.getTargetDate() != null) {
                            DateFormat fDate = new SimpleDateFormat("dd/MM/yyyy");
                            out.print(fDate.format(g.getTargetDate().getTime()));
                        } else {
                            out.print("No Target Date set");
                        }
                    %>
                </td>  
                <td>
                    <%
                        if (g.getCompletionStatus()) {
                            out.print("Completed");
                        } else {
                            out.print("Incomplete");
                        }
                    %>
                </td>
                <td>
                    <table>
                        <tr>
                            <th>
                                Activity Type
                            </th>
                            <th>
                                Description
                            </th>
                            <th>
                                Completion Status
                            </th>
                        </tr>
                        <%
                            if (g.getActivities() != null) {

                                for (Activity a : g.getActivities()) {
                        %>
                        <tr>
                            <td>
                                <%
                                    out.print(a.getActivityType().convertToString());
                                %>
                            </td>
                            <td>
                                <%
                                    out.print(a.getDescription());
                                %>
                            </td>
                            <td>
                                <%
                                    if (a.isCompletionStatus()) {
                                        out.print("Complete!");
                                    } else {
                                        out.print("Incomplete");
                                    }
                                %>
                            </td>
                        </tr>
            </tr>
        </tr>
        <%}%>
    </table>
</td>
</tr>
<%
        }
    }
%>
</table>
<div class="flex-container" style="background-color: #011627">
    <!--Footer-->
    <footer class="page-footer font-small blue pt-4 mt-4">

        <!--Footer Links-->
        <div class="container-fluid text-center text-md-left">
            <div class="row">

                <!--First column-->
                <div class="col-md-6">

                </div>
                <!--/.First column-->

                <!--Second column-->
                <!-- <div class="col-md-6">
<h5 class="text-uppercase">Links</h5>
<ul class="list-unstyled">
<li>
    <a href="#!">Link 1</a>
</li>
<li>
    <a href="#!">Link 2</a>
</li>
<li>
    <a href="#!">Link 3</a>
</li>
<li>
    <a href="#!">Link 4</a>
</li>
</ul>
</div> -->
                <!--/.Second column-->
            </div>
        </div>
        <!--/.Footer Links-->

        <!--Copyright-->
        <div class="footer-copyright py-3 text-center" style="color : white;">
            Â© 2018 Copyright:
            <a href="https://mentalelixir.co.uk"> MentalElixir.co.uk </a>
        </div>
        <!--/.Copyright-->

    </footer>
    <!--/.Footer-->
</div>



<!-- /.container -->


<!-- Bootstrap core JavaScript
        ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" 
        integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" 
crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" 
        integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" 
crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" 
      integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" 
      crossorigin="anonymous">
<script src="js/scripts.js"></script>

</body>

</html>

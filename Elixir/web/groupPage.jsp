<%@page import="Model.User"%>
<%@page import="Controller.UserController"%>
<%@page import="Controller.GroupController"%>
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

        <title>elixir - The Health Potion for the Mind.</title>

        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/styles.css">

        <!-- Custom styles for this template -->
        <style type="text/css">


        </style>
    </head>


    <body>

        <div class="naiveBar" id="navBarPlaceholder"></div>



        <main role="main" class="flex-container">
            <div class="container text-center">
                <% GroupController group = (GroupController) session.getAttribute("group"); %>
                <h1>Guild Name: <% out.print(group.getGroupName()); %></h1>
                <h5>Guild Master: <% out.print(group.getCreator().getUserName()); %></h5>
                <br/>
                <div class="row">
                    <div class="col-md-8">
                        <p class="text-left"><b>Guild Description: </b><% out.print(group.getDescription()); %></p>
                    </div>
                    <div class="col-md-4">
                        <h3>Allies</h3>
                        <% for (User u : group.getMembers()) {
                        %>
                        <div class="card" style="margin-bottom: 1%">
                            <b>Username: </b><% out.print(u.getUserName()); %>
                        </div>
                        <%}%>
                    </div>
                </div>

            </div>


            <div class="flex-container pt-5 text-center">
                <img src="images/heroes.jpeg" style="width: 100%;">
            </div>

            <div class="flex-container" style="background-color: #011627">
                <!--Footer-->
                <footer class="page-footer font-small blue pt-4 mt-4">

                    <!--Footer Links-->

                    <!--/.Footer Links-->

                    <!--Copyright-->
                    <div class="footer-copyright py-3 text-center" style="color : white;">
                        © 2018 Copyright:
                        <a href="https://mentalelixir.co.uk"> MentalElixir.co.uk </a>
                    </div>
                    <!--/.Copyright-->

                </footer>
                <!--/.Footer-->
            </div>



        </main>
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


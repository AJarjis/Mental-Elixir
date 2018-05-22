<%@page import="Controller.UserController"%>
<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../../../favicon.ico">

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
    <%
        UserController user = (UserController) session.getAttribute("user");
        if (user == null) {
            RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
            rd.forward(request, response);
        }
    %>


    <body>
        <div id="navBarPlaceholder" class="naiveBar"></div>

        <div class="flex-container p-5" style="background-color: #FDFFFC">
            <div class="container" style="width: 80%; background-color: #FDFFFC">
                <div class="row justify-content-center">
                    <div class="col-sm-8 mb-5 ">
                        <div class="card-body">
                            <span>${errorMessages.errorMain}</span>
                            <h5 style="color: gray">Create Group</h5>
                            <form action="CreateGroup" method="POST">
                                <div class="form-group">
                                    <label style="color: gray" for="groupName">Group Name:</label>
                                    <input class="form-control" type="text" name="groupName" id="groupName">
                                </div>
                                <div class="form-group">
                                    <label style="color: gray" for="groupDescription">Description:</label>
                                    <textarea class="form-control" id="groupDescription" name="groupDescription"></textarea>
                                </div>
                                <input style="color: white" class="btn btn-primary" type="submit" value="Create Group">
                            </form>
                        </div>
                    </div>
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
                    © 2018 Copyright:
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
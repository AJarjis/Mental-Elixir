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
        if (user != null) {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
    %>


<body>
    <nav class="navbar navbar-expand-md navbar-light fixed-top" style="background-color: #FDFFFC">
        <span id="title" class="navbar-text" style="font-size: 30px">elixir</span>
        <a class="navbar-brand" href="#">
                <img src="images/logo.svg" alt="logo" style="height: 40px">
            </a>
        <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>




        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <span class="navbar-text">A health potion for the mind.</span>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link justify-content-end" href="#">
                            <img class="img-fluid" src="images/home.svg" style="height: 30px" alt="home icon" >

                        </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">
                            <img class="img-fluid" src="images/account.svg" style="height: 30px" alt="Account icon">

                        </a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link" href="http://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <img class="img-fluid" src="images/goals.svg" style="height: 30px" alt="Activities icon">

                        </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdown01">
                        <a class="dropdown-item" href="#">Activities</a>
                        <a class="dropdown-item" href="#">Goals</a>
                        <a class="dropdown-item" href="#">Mood Assessment</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link" href="http://example.com" id="dropdown02" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <img class="img-fluid" src="images/contacts.svg" style="height: 30px" alt="Activities icon">

                        </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdown02">
                        <a class="dropdown-item" href="#">Advice & Support</a>
                        <a class="dropdown-item" href="#">Report a Bug.</a>
                    </div>
                </li>
            </ul>
        </div>
    </nav>

    <div class="flex-container p-5 text-center" style="background-color: #2EC4B6">
        <img src="images/logo_white.svg" style="height : 18em; background-color: #2EC4B6">
        <div class="flex-container">
            <span class="flex" style="font-size: 8em; color: white">elixir</span>
            <div class="flex-container">
                <span class="flex" style="font-size: 3em; color: white">Welcome to elixir, the health potion for the mind.</span>
            </div>
            <div class="flex-container p-5">
                <span class="flex" style="font-size: 1.5em; color: white">You can sign back in below if you have already started using elixir, otherwise register underneath to join the rather small number of people who are now using elixir to track their mental wellbeing </span>
            </div>
        </div>
    </div>

    <div class="flex-container p-5" style="background-color: #F3A341">
        <div class="container" style="width: 80%; background-color: #F3A341">
            <div class="row justify-content-center">
                <div class="col-sm-8 mb-5 ">
                    <div class="card-body">
                        <h5>Existing User:</h5>
                        <form action="Login" method="POST">
                            <div class="form-group">
                                <label for="userName">Username:</label>
                                <input type="text" class="form-control" id="userName" name="userName">
                                <span class="inputError">${errorMessages.userNameLog}</span>
                            </div>
                            <div class="form-group">
                                <label for="password">Password:</label>
                                <input type="password" class="form-control" id="password" name="password">
                                <span class="inputError">${errorMessages.passwordLog}</span>
                            </div>
                            <input class="btn btn-primary" type="submit" value="Login">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="flex-container p-5" style="background-color: #FDFFFC">
        <div class="container" style="width: 80%; background-color: #FDFFFC">
            <div class="row justify-content-center">
                <div class="col-sm-8 mb-5 ">
                    <div class="card-body">
                        <span>${errorMessages.errorMain}</span>
                        <h5 style="color: gray">Register New User:</h5>
                        <form action="RegisterUser" method="POST">
                            <div class="form-group">
                                <label style="color: gray" for="userName">Username:</label>
                                <input type="text" class="form-control" id="userName" name="userName">
                                <span class="inputError">${errorMessages.userName}</span>
                            </div>
                            <div class="form-group">
                                <label style="color: gray" for="firstName">First Name:</label>
                                <input type="text" class="form-control" id="firstName" name="firstName">
                                <span class="inputError">${errorMessages.firstName}</span>
                            </div>
                            <div class="form-group">
                                <label style="color: gray" for="surname">Surname:</label>
                                <input type="text" class="form-control" id="surname" name="surname">
                                <span class="inputError">${errorMessages.surname}</span>
                            </div>
                            <div class="form-group">
                                <label style="color: gray" for="email">Email:</label>
                                <input type="email" class="form-control" id="email" name="email">
                                <span class="inputError">${errorMessages.email}</span>
                            </div>
                            <div class="form-group">
                                <label style="color: gray" for="password">Password:</label>
                                <input type="password" class="form-control" id="password" name="password">
                                <span class="inputError">${errorMessages.password}</span>
                            </div>
                            <input style="color: white" class="btn btn-primary" type="submit" value="Register User">
                        </form>
                    </div>
                </div>
            </div>
        </div>
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
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</body>

</html>
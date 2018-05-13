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

        <div class="d-flex align-items-stretch">
            <div class="sidebar-right bg-secondary col-2 pt-5 d-none d-md-block">
                <div class="card" style="text-align: center">
                    <img class="card-img-top pt-4" src="images/contacts.svg" alt="Card image cap" style="height: 20vh; padding-bottom: 20px;">
                    <h4 class="card-header"></h4>
                    <div class="card-body">
                        <div class="card-footer">
                        </div>
                    </div>
                </div>
            </div>


            <div class="container">
                <div class="card-body">
                    <form action="Login" method="POST">
                        <div class="form-group">
                            <label for="userName">UserName:</label>
                            <input type="text" class="form-control" id="userName" name="userName">
                        </div>
                        <div class="form-group">
                            <label for="password">Password:</label>
                            <input type="password" class="form-control" id="password" name="password">
                        </div>
                    <input class="btn btn-primary" type="submit" value="Login">
                </form>
            </div>
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
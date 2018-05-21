<%@page import="Controller.UserController"%>
<%@page import="Model.User"%>

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

    <!-- Checks if a user is logged in, redirecting them to register/login page if not-->
    <%
        UserController user = (UserController) session.getAttribute("user");
        if (user != null) {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
    %>


    <body>

        <nav class="navbar navbar-expand-md navbar-light bg-light fixed-top">

            <span id="title" class="navbar-text" style="font-size: 30px">elixir</span>
            <a class="navbar-brand" href="#">
                <img src="images/logo.svg" alt="logo" style="height: 40px">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarsExampleDefault">
               
            </div>
        </nav>

        <main role="main" class="flex-container">

            <div class="row d-xl-none">
                <div id="heroCarousel" class="carousel slide col-xl-12" data-ride="carousel">
                    <div class="carousel-inner" role="listbox">
                        <div class="carousel-item active">
                            <img class="d-block img-fluid" src="images/hero1.jpg" alt="First slide">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>"Before you can battle the Darklord you must first conquer your own demons"</h5>
                                <p>- Shaky the Wise</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img class="d-block img-fluid" src="images/hero2.jpg" alt="Second slide">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>"A true hero is someone who has looked at the Darkness inside themselves and defeated it with acceptance, calmness and positivity"</h5>
                                <p>- Ali the Gay Cleric</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img class="d-block img-fluid" src="images/hero3.jpg" alt="Third slide">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>"SMASH THE FUCKER!!"</h5>
                                <p>- A Talking Bear</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div style="background-color: white">
                <div class="jumbotron jumbotron-fluid">
                    <div class="container">
                        <img src="images/logo.svg" alt="logo" style="height: 10em">
                        <h1>elixir</h1>
                        <h2>Welcome to elixir, the health potion for the mind.</h2>
                        <p>You can sign back in below if you have already started using elixir, otherwise register underneath to join the rather small number of people who are now using elixir to track their mental wellbeing</p>
                    </div>
                </div>


                <div class="flex-container b-3 pb-5" id="loginArea">
                    <div class="login-register-form-section p-5">
                        <ul class="nav nav-tabs justify-content-around">
                            <li class="active"><a href="#login" data-toggle="tab">Login</a></li>
                            <li><a href="#register" data-toggle="tab">Register</a></li>
                        </ul>
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane fade show active" id="login">
                                <form class="form-horizontal" action="Login" method="POST">
                                    <div class="form-group ">
                                        <div class="input-group">
                                            <div class="input-group-addon"><i class="fa fa-user"></i></div>
                                            <input type="text" class="form-control" placeholder="Username" required="required" value="" name="userNameLog">
                                            <span class="inputError">${errorMessages.userNameLog}</span>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <div class="input-group">
                                            <div class="input-group-addon"><i class="fa fa-key"></i></div>
                                            <input type="password" class="form-control" placeholder="Password" required="required" name="passwordLog">
                                            <span class="inputError">${errorMessages.passwordLog}</span>
                                        </div>
                                    </div>
                                    <input type="submit" value="Login" class="btn btn-success btn-custom ">

                                </form>
                            </div>
                            <div role="tabpanel" class="tab-pane fade" id="register">
                                <form class="form-horizontal" method="post" action="RegisterUser">
                                    <span>${errorMessages.errorMain}</span>
                                    <div class="form-group ">
                                        <div class="input-group">
                                            <div class="input-group-addon"><i class="fa fa-user"></i></div>
                                            <input type="text" name="userName" class="form-control" placeholder="Username" required="required" value="">
                                            <span class="inputError">${errorMessages.userName}</span>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <div class="input-group">
                                            <div class="input-group-addon"><i class="fa fa-male"></i></div>
                                            <input type="text" name="firstName" class="form-control" placeholder="First name" required="required" value="">
                                            <span class="inputError">${errorMessages.firstName}</span>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <div class="input-group">
                                            <div class="input-group-addon"><i class="fa fa-male"></i></div>
                                            <input type="text" name="surname" class="form-control" placeholder="Surname" required="required" value="">
                                            <span class="inputError">${errorMessages.surname}</span>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <div class="input-group">
                                            <div class="input-group-addon"><i class="fa fa-envelope"></i></div>
                                            <input type="email" name="email" class="form-control" placeholder="Email" required="required" value="">
                                            <span class="inputError">${errorMessages.email}</span>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <div class="input-group">
                                            <div class="input-group-addon"><i class="fa fa-lock"></i></div>
                                            <input type="password" name="password" class="form-control" placeholder="Password" required="required">
                                            <span class="inputError">${errorMessages.password}</span>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <div class="input-group">
                                            <div class="input-group-addon"><i class="fa fa-lock"></i></div>
                                            <input type="password" name="confirmPassword" class="form-control" placeholder="Confirm Password" required="required">
                                            <span class="inputError">${errorMessages.confirmPassword}</span>
                                        </div>
                                    </div>
                                    <input type="submit" value="Register" class="btn btn-success btn-custom">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="flex-container text-center">
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
        <script src="js/scripts.js"></script>
    </body>

</html>

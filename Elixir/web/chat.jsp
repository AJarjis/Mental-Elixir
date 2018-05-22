<%@page import="Model.Activity"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="Model.Goal"%>
<%@page import="java.util.List"%>
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

        <title>elixir - The Health Potion for the Mind.</title>

        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/styles.css">
        <script type='text/javascript' src='https://cdn.scaledrone.com/scaledrone.min.js'></script> 

        <!-- Custom styles for this template -->
        <style type="text/css">


        </style>
    </head>


    <body>
        <main>
            <div class="naiveBar" id="navBarPlaceholder"></div>
            <div class="container-flex pt-5  bg-secondary">
                <h3 class="text-center text-light">Need a chat? </h3>
                <h5 class="text-center text-light ml-5 mr-5">
                    Our anonymous chat service is here for when you need someone to talk to with no judgement and no expectations. 
                    Please be polite and respectful to those you meet. 
                </h5>
                <div class="chat container p-5">
                    <div class="members-count bg-light">-</div>
                    <div class="members-list bg-light">-</div>
                    <div class="messages bg-light"></div>
                    <form class="message-form" onsubmit="return false;">
                        <input class="message-form__input" placeholder="Type a message.." type="text" />
                        <input class="message-form__button" value="Send" type="submit" />
                    </form>
                </div>
            </div>


            <!-----------------------------------Test Zone End----------------------------------->


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
        <span style="display:none" id="userName"><% out.print(user.getUserName()); %></span>

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
        <script src="js/chat.js"></script>




    </body>

</html>

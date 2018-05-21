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
        <link rel="stylesheet" type="text/css" href="css/style.css">

        <!-- Custom styles for this template -->
        <style type="text/css">


        </style>
    </head>


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
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">WEBWMS</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="faq.jsp">FAQ</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Quick Select</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown01">
                            <a class="smoothScroll dropdown-item" href="#moods">Track Mood</a>
                            <a class="smoothScroll dropdown-item" href="#adventures">Choose Adventure</a>
                            <a class="smoothScroll dropdown-item" href="#">Create Guild</a>
                            <a class="smoothScroll dropdown-item" href="groups.jsp">Join Guild</a>
                        </div>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0" action="Logout" method="GET">
                    <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Log Out">
                </form>
            </div>
        </nav>

        <main role="main" class="flex-container">

            <div class="row d-xl-none">
                <div id="heroCarousel" class="heroPic carousel slide col-xl-12" data-ride="carousel">
                    <div class="carousel-inner" role="listbox">
                        <div class="carousel-item active">
                            <img class="d-block img-fluid" src="images/hero1.jpg" alt="First slide">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>"Before you can battle the Darklord you must first conquer your own demons"</h5>
                                <p>- Shaky the Wise</p>
                            </div>
                        </div>
                        <div class="heroPic carousel-item">
                            <img class="d-block img-fluid" src="images/hero2.jpg" alt="Second slide">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>"A true hero is someone who has looked at the Darkness inside themselves and defeated it with acceptance, calmness and positivity"</h5>
                                <p>- Ali the Gay Cleric</p>
                            </div>
                        </div>
                        <div class="heroPic carousel-item">
                            <img class="d-block img-fluid" src="images/hero3.jpg" alt="Third slide">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>"SMASH THE FUCKER!!"</h5>
                                <p>- A Talking Bear</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>



            <div class="jumbotron jumbotron-fluid border-bottom">
                <div class="container">
                    <img src="images/logo.svg" alt="logo" style="height: 10em">
                    <h1>elixir</h1>
                    <h2>Welcome to elixir, the health potion for the mind.</h2>
                    <p>You can sign back in below if you have already started using elixir, otherwise register underneath to join the rather small number of people who are now using elixir to track their mental wellbeing</p>
                </div>
            </div>

            <div class="container-fluid pb-5" id="moods">
                <h1 class="text-center text-light pt-5">How is your Adventure?</h1>
                <h5 class="text-center text-light pl-5 pr-5">Sometimes an Adventurer can feel full of strength and jubilation and sometimes they may just want to sit in a cave (after wrestling the Bear inside into submission) and hide from the world. How full is your potion?</h5>
                <br>
                <h5 class="text-center text-light pl-5 pr-5">Click on the bottles below to rate your adventure contentment.</h5>
                <div class="row justify-content-center p-3">

                    <div id="moodModalOne " class="moodModal col-lg-1 col-sm-1">
                        <!-- Button trigger modal -->
                        <a data-toggle="modal" data-target="#exampleModalCenter1">
                            <img class="img-fluid" src="images/mood/conOne.png" >
                        </a>

                        <!-- Modal -->
                        <div class="modal fade" id="exampleModalCenter1" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLongTitle">Rating 1 - Empty</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        You are running on empty. Sometimes lifes adventures are just too much and you want to hide away in the nearest Dragons lair. <br><br>Consider reaching out to one of your allies or maybe a professional and just let them know how you are doing. <br><br>Sometimes it is harder to battle your personal demons than it is to fight actual monsters from the pits of the nether world.
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        <button type="button" class="btn btn-primary">Save changes</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="moodModalTwo" class="moodModal col-lg-1 col-sm-1"><a data-toggle="modal" data-target="#exampleModalCenter2">
                            <img class="img-fluid" src="images/mood/conTwo.png">
                        </a>

                        <!-- Modal -->
                        <div class="modal fade" id="exampleModalCenter2" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        ...
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        <button type="button" class="btn btn-primary">Save changes</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="moodModalThree" class="moodModal col-lg-1 col-sm-1">
                        <!-- Button trigger modal -->
                        <a data-toggle="modal" data-target="#exampleModalCenter3">
                            <img class="img-fluid" src="images/mood/conThree.png">

                        </a>

                        <!-- Modal -->
                        <div class="modal fade" id="exampleModalCenter3" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        ...
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        <button type="button" class="btn btn-primary">Save changes</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="moodModalFour" class="moodModal col-lg-1 col-sm-1">
                        <!-- Button trigger modal -->
                        <a data-toggle="modal" data-target="#exampleModalCenter4">
                            <img class="img-fluid" src="images/mood/conFour.png">

                        </a>

                        <!-- Modal -->
                        <div class="modal fade" id="exampleModalCenter4" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        ...
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        <button type="button" class="btn btn-primary">Save changes</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="moodModalFive" class="moodModal col-lg-1 col-sm-1">
                        <!-- Button trigger modal -->
                        <a data-toggle="modal" data-target="#exampleModalCenter5">
                            <img class="img-fluid" src="images/mood/conFive.png">
                        </a>

                        <!-- Modal -->
                        <div class="modal fade" id="exampleModalCenter5" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        ...
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        <button type="button" class="btn btn-primary">Save changes</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row chart p-5 justify-content-center">
                    <canvas id="line-chart"></canvas>
                </div>
            </div>

            <!-----------------------------------Test Zone Start--------------------------------->

            <div id="adventures" class="container">
                <div class="container p-5 text-center text-secondary">
                    <h1>
                        Choose your own Adventures.
                    </h1>
                    <h3>Here you can find a selection of Adventures that you can accept. Each one has a set of quests that needs to be completed to achieve success.</h3>
                </div>
                <div class="row justify-content-center pt-5 text-secondary">
                    <div id="carouselExampleSlidesOnly" class="carousel slide border border-dark p-4" data-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <div class="card" style="width: 25rem;">
                                    <img class="smallpic card-img-top" src="images/love.jpg" alt="Card image cap">
                                    <div class="card-body">
                                        <h5 class="card-title">Five weeks of love</h5>
                                        <p class="card-text">Spend five weeks strengthening the bonds of your relationship.</p>
                                    </div>
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item">Give Compliments Daily</li>
                                        <li class="list-group-item">Do something together</li>
                                        <li class="list-group-item">Do your partner a favour</li>
                                    </ul>
                                    <div class="card-body">
                                        <a href="#" class="card-link">Accept Adventure</a>
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <div class="card" style="width: 25rem;">
                                    <img class="smallpic card-img-top" src="images/breakfastOfChampions.png" alt="Card image cap">
                                    <div class="card-body">
                                        <h5 class="card-title">Healthy Morning Habits</h5>
                                        <p class="card-text">Set yourself up for a successful day with a positive morning. </p>
                                    </div>
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item">Compose a healthy breakfast</li>
                                        <li class="list-group-item">Find a stretch routine</li>
                                        <li class="list-group-item">Drink Water when you wake up</li>
                                    </ul>
                                    <div class="card-body">
                                        <a href="#" class="card-link">Accept Adventure</a>
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <div class="card" style="width: 25rem;">
                                    <img class="smallpic card-img-top" src="images/Vain.jpg" alt="Card image cap">
                                    <div class="card-body">
                                        <h5 class="card-title">Learn to love yourself</h5>
                                        <p class="card-text">Reflect on your successes to help build your self-esteem.</p>
                                    </div>
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item">Write down three things I did well today.</li>
                                        <li class="list-group-item">Write down three things I appreciate about myself</li>
                                        <li class="list-group-item">Write down three things I appreciate about others</li>
                                    </ul>
                                    <div class="card-body">
                                        <a href="#" class="card-link">Accept Adventure</a>
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <div class="card" style="width: 25rem;">
                                    <img class="smallpic card-img-top" src="images/angry.jpg" alt="Card image cap">
                                    <div class="card-body">
                                        <h5 class="card-title">Understand my Mood</h5>
                                        <p class="card-text">Make sure to reflect on your mood three times a day for a least a week.</p>
                                    </div>
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item">Rate in the morning</li>
                                        <li class="list-group-item">Rate in the afternoon</li>
                                        <li class="list-group-item">Rate in the evening</li>
                                    </ul>
                                    <div class="card-body">
                                        <a href="#" class="card-link">Accept Adventure</a>
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <div class="card" style="width: 25rem;">
                                    <img class="smallpic card-img-top" src="images/worried.jpg" alt="Card image cap">
                                    <div class="card-body">
                                        <h5 class="card-title">Step out of your comfort zone</h5>
                                        <p class="card-text">Take some risks and see what the world could have in store.</p>
                                    </div>
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item">Start a dialogue with an unknown person</li>
                                        <li class="list-group-item">Say yes to something you would normally say No to</li>
                                        <li class="list-group-item">Smile and say hi to three strangers</li>
                                    </ul>

                                    <div class="card-body">
                                        <a href="#" class="card-link">Accept Adventure</a>
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <div class="card" style="width: 25rem;">
                                    <img class="smallpic card-img-top" src="images/runninglate.jpg" alt="Card image cap">
                                    <div class="card-body">
                                        <h5 class="card-title">Be on time</h5>
                                        <p class="card-text">Being punctual can help you take control of your situation. Give it a go.</p>
                                    </div>
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item">Estimate and track your time</li>
                                        <li class="list-group-item">Plan to and then arrive 15 mins early</li>
                                        <li class="list-group-item">Do something useful while you wait
                                        </li>
                                    </ul>
                                    <div class="card-body">
                                        <a href="#" class="card-link">Accept Adventure</a>
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <div class="card" style="width: 25rem;">
                                    <img class="smallpic card-img-top" src="images/charity.jpg" alt="Card image cap">
                                    <div class="card-body">
                                        <h5 class="card-title">Do more good and feel better </h5>
                                        <p class="card-text">Taking care of others can be the thing that helps us be happier with ourselves.</p>
                                    </div>
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item">Do a good deed for a friend</li>
                                        <li class="list-group-item">Do a good deed for a stranger</li>
                                        <li class="list-group-item">Do a good deed for a stranger, without telling anyone</li>
                                    </ul>
                                    <div class="card-body">
                                        <a href="#" class="card-link">Accept Adventure</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- Left and right controls -->
                        <a class="left carousel-control" href="#carouselExampleSlidesOnly" role="button" data-slide="prev">
                            <span class="fa fa-chevron-left" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#carouselExampleSlidesOnly" role="button" data-slide="next">
                            <span class="fa fa-chevron-right" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>

                    </div>

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

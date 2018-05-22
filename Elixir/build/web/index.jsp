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

        <nav class="naiveBar navbar navbar-expand-md navbar-light bg-light fixed-top">
            <span id="title" class="navbar-text" style="font-size: 30px">elixir</span>
            <a class="navbar-brand" href="index.jsp">
                <img src="images/logo.svg" alt="logo" style="height: 40px">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <form action="closePoolServlet" method="POST">
                <div class="card p-5">
                    <input style="color: white" class="btn btn-primary" type="submit" value="Close Pooled Resourses">
                </div>
            </form>
            <div class="collapse navbar-collapse" id="navbarsExampleDefault">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="smoothScroll nav-link" href="#moods">Moods</a>
                    </li>
                    <li class="nav-item">
                        <a class="smoothScroll nav-link" href="#adventures">Adventures</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Guilds</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown01">
                            <a class="smoothScroll dropdown-item" href="createGroup.jsp">Create Guild</a>
                            <a class="smoothScroll dropdown-item" href="groups.jsp">Join Guild</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="smoothScroll nav-link" href="chat.jsp">Chat</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="faq.jsp">Help & Support</a>
                    </li>
                </ul>
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">My Account</a>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdown01">
                            <p class="dropdown-header"><b>Username: </b><% out.print(user.getUserName()); %></p>
                            <p class="dropdown-header"><b>Name: </b><% out.print(user.getFullName()); %></p>
                            <p class="dropdown-header"><b>Email: </b><% out.print(user.getEmail());%></p>
                            <div class="dropdown-divider"></div>
                            <a class="smoothScroll dropdown-item bad-dropdown-item" href="" data-toggle="modal" data-target="#deleteAccountModal">
                                <i class="fas fa-minus-circle"></i> Delete Account</a>
                            <a class="smoothScroll dropdown-item warning-dropdown-item" href="Logout">
                                <i class="fas fa-sign-out-alt"></i> Logout</a>
                        </div>
                    </li>
                </ul>

            </div>
        </nav>

        <div class="modal fade" id="deleteAccountModal" tabindex="-1" role="dialog" aria-labelledby="deleteAccountModalTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="deleteAccountModalTitle">Confirm Account Deletion</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Are you sure you wish to delete your account? This is a permanent action and all you progress will be lost forever.
                    </div>
                    <div class="modal-footer">

                        <button type="button" class="btn btn-secondary" data-dismiss="modal" href="DeleteAccount">Close</button>
                        <form action="DeleteAccount" method="POST">
                            <button type="submit" class="btn btn-danger">Delete Account</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <main role="main" class="flex-container">

            <div class="row d-xl-none">
                <div id="heroCarousel" class="heroPic carousel slide col-xl-12" data-ride="carousel">
                    <div class="carousel-inner" role="listbox">
                        <div class="carousel-item active">
                            <img class="d-block img-fluid" src="images/hero1.jpg" alt="First slide">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>"Before you can battle the Darklord you must first conquer your own demons"</h5>
                                <p>- Sit Monty Fortesque</p>
                            </div>
                        </div>
                        <div class="heroPic carousel-item">
                            <img class="d-block img-fluid" src="images/hero2.jpg" alt="Second slide">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>"A true hero is someone who has looked at the Darkness inside themselves and defeated it with acceptance, calmness and positivity"</h5>
                                <p>- Alijar Jis - Cleric of the fifth order</p>
                            </div>
                        </div>
                        <div class="heroPic carousel-item">
                            <img class="d-block img-fluid" src="images/hero3.jpg" alt="Third slide">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>"GRRRAAAAArrrrRRooooooooroooww"</h5>
                                <p>- A Bear</p>
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

                    <div id="moodModalOne " class="moodModal col-lg-1 col-md-2 col-sm-2">
                        <!-- Button trigger modal -->
                        <a data-toggle="modal" data-target="#exampleModalCenter1">
                            <img class="img-fluid" id="conOne" src="images/mood/conOne.png" >
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
                                        <button type="button" class="btn btn-primary">Save Rating</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="moodModalTwo" class="moodModal col-lg-1 col-md-2 col-sm-2"><a data-toggle="modal" data-target="#exampleModalCenter2">
                            <img class="img-fluid" id="conTwo" src="images/mood/conTwo.png">
                        </a>

                        <!-- Modal -->
                        <div class="modal fade" id="exampleModalCenter2" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLongTitle">Rating 2 - Struggling Along</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        Sure, things could be worse but they could most definitely be  a lot better. <br><br>Sometimes your favourite wizard gets impaled by a Trogg, sometimes you lose your sharpest sword off a cliff
                                        and sometimes Daisy , the farmers daughter, laughs at you and runs off with that Elven archer you hated.<br><br> Whatever the cause, the outlook feels pretty bleak right now. Best gather together your team of adventurers and treat yourselves to a nice banquet and some time to unwind.
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        <button type="button" class="btn btn-primary">Save Rating</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="moodModalThree" class="moodModal col-lg-1 col-md-2 col-sm-2">
                        <!-- Button trigger modal -->
                        <a data-toggle="modal" data-target="#exampleModalCenter3">
                            <img class="img-fluid" id="conThree" src="images/mood/conThree.png">

                        </a>

                        <!-- Modal -->
                        <div class="modal fade" id="exampleModalCenter3" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLongTitle">Rating 3 - Neither here nor there</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        You battled past that ogre and beat the scales off the dragon. But, to be honest, the hoard of treasure is just....well....its just okay. Its not exactly disappointing, but it also isn't anything very special.<br><br>
                                        Some days just feel ordinary and this is one of those. If you really think about it there is lots on your adventures that has been fantastic. On the other hand, your new boots are pretty uncomfortable and the dwarf that came along is a little annoying.<br><br> Neither really happy or unhappy. Let's hope that more exciting adventures are just around the corner.
                                        
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        <button type="button" class="btn btn-primary">Save Rating</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="moodModalFour" class="moodModal col-lg-1 col-md-2 col-sm-2">
                        <!-- Button trigger modal -->
                        <a data-toggle="modal" data-target="#exampleModalCenter4">
                            <img class="img-fluid" id="conFour" src="images/mood/conFour.png">

                        </a>

                        <!-- Modal -->
                        <div class="modal fade" id="exampleModalCenter4" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLongTitle">Rating 4 - No worries...nearly.</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        The quest is complete. You brought the innkeeper back his lost barrels from that band of thieves and he is letting you and your friends eat and drink for free.<br><br>
                                        The villagers love you. You have the chair closest to the fire and the the innkeepers dog is asleep at your feet. Exhausted, relaxed and appreciated. <br><br>Life is pretty good right now, apart from that damned dwarf
                                        is singing Dwarven drinking songs and keeps standing on your feet when he dances.
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        <button type="button" class="btn btn-primary">Save Rating</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="moodModalFive" class="moodModal col-lg-1 col-md-2 col-sm-2">
                        <!-- Button trigger modal -->
                        <a data-toggle="modal" data-target="#exampleModalCenter5">
                            <img class="img-fluid" id="conFive" src="images/mood/conFive.png">
                        </a>

                        <!-- Modal -->
                        <div class="modal fade" id="exampleModalCenter5" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLongTitle">Rating 5 - The City is Yours!</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        You did it. You did it all. <br><br>You rescued the lost children, you saved the city from the band of marauding barbarians, you single handedly beat Krogg the BoneBreaker and now his mighty, magical sword
                                        "The Punisher" is yours to wield and command. The throne of the kingdom is yours for the taking, your true love is next to you and you are starting to suspect that you may be an immortal demi-god.<br><br>
                                        For today, not a thing in the world is wrong. Time to sit on your new throne and reflect on this moment and consider how good life can be when you keep on adventuring.
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        <button type="button" class="btn btn-primary">Save Rating</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row chart p-5 justify-content-center">
                    <div id="chartDiv"></div>
                </div>
            </div>

            <!-----------------------------------Test Zone Start--------------------------------->
            <div id="adventures" class="container-flex bg-danger p-4">
                <div class="container bg-light rounded" id="goals">
                    <div class="container pt-5 m text-center text-secondary">
                        <h1>
                            Choose your own Adventure.
                        </h1>
                        <h3>Here you can find a selection of Adventures that you can accept. Each one has a set of quests that needs to be completed to achieve success.</h3>

                    </div>

                    <div class="row justify-content-center pt-5 text-secondary border-top border-bottom border-light">
                        <div class="row" style="width: 100%">
                            <div class="col-md-6">

                                <h3 class="text-center">
                                    <a class="left carousel-control" href="#carouselExampleSlidesOnly" role="button" data-slide="prev">
                                        <span class="far fa-arrow-alt-circle-left" style="font-size: 1.7em;" aria-hidden="true"></span>
                                        <span class="sr-only">Previous</span>
                                    </a>
                                    Available Quests
                                    <a class="right carousel-control" href="#carouselExampleSlidesOnly" role="button" data-slide="next">
                                        <span class="far fa-arrow-alt-circle-right" style="font-size: 1.7em;" aria-hidden="true"></span>
                                        <span class="sr-only">Next</span>
                                    </a>
                                </h3>

                                <div id="carouselExampleSlidesOnly" class="carousel slide border border-dark p-4 mb-5" data-ride="carousel"  data-interval="false">
                                    <div class="carousel-inner">
                                        <div class="carousel-item active">
                                            <div class="card">
                                                <div class="quest-image text-center">
                                                    <img class="smallpic card-img-top" src="images/love.jpg" alt="Card image cap">
                                                </div>
                                                <form action="AddActivity" method="POST">
                                                    <div class="card-body">
                                                        <h5 class="card-title">Five Weeks of Love</h5>
                                                        <input style="display:none" name="goal" value="Five Weeks of Love">
                                                        <p class="card-text">Spend five weeks strengthening the bonds of your relationship.</p>
                                                    </div>
                                                    <ul class="list-group list-group-flush">
                                                        <li class="list-group-item">Give Compliments Daily</li>
                                                        <input style="display:none" name="activity" value="Give Compliments Daily">
                                                        <li class="list-group-item">Do something together</li>
                                                        <input style="display:none" name="activity" value="Do something together">
                                                        <li class="list-group-item">Do your partner a favour</li>
                                                        <input style="display:none" name="activity" value="Do your partner a favour">
                                                    </ul>
                                                    <div class="card-body">
                                                        <input type="submit" class="btn btn-success" value="Accept Adventure">
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                        <div class="carousel-item">
                                            <div class="card">
                                                <div class="quest-image text-center">
                                                    <img class="smallpic card-img-top" src="images/breakfastOfChampions.png" alt="Card image cap">
                                                </div>
                                                <form action="AddActivity" method="POST">
                                                    <div class="card-body">
                                                        <h5 class="card-title">Healthy Morning Habits</h5>
                                                        <input style="display:none" name="goal" value="Healthy Morning Habits">
                                                        <p class="card-text">Set yourself up for a successful day with a positive morning.</p>
                                                    </div>
                                                    <ul class="list-group list-group-flush">
                                                        <li class="list-group-item">Compose a healthy breakfast.</li>
                                                        <input style="display:none" name="activity" value="Compose a healthy breakfast.">
                                                        <li class="list-group-item">Find a stretch routine.</li>
                                                        <input style="display:none" name="activity" value="Find a stretch routine.">
                                                        <li class="list-group-item">Drink Water when you wake up.</li>
                                                        <input style="display:none" name="activity" value="Drink Water when you wake up.">
                                                    </ul>
                                                    <div class="card-body">
                                                        <input type="submit" class="btn btn-success" value="Accept Adventure">
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                        <div class="carousel-item">
                                            <div class="card">
                                                <div class="quest-image text-center">
                                                    <img class="smallpic card-img-top" src="images/Vain.jpg" alt="Card image cap">
                                                </div>
                                                <form action="AddActivity" method="POST">
                                                    <div class="card-body">
                                                        <h5 class="card-title">Learn to Love Yourself</h5>
                                                        <input style="display:none" name="goal" value="Learn to Love Yourself">
                                                        <p class="card-text">Reflect on your successes to help build your self-esteem.</p>
                                                    </div>
                                                    <ul class="list-group list-group-flush">
                                                        <li class="list-group-item">Write down three things I did well today.</li>
                                                        <input style="display:none" name="activity" value="Write down three things I did well today.">
                                                        <li class="list-group-item">Write down three things I appreciate about myself.</li>
                                                        <input style="display:none" name="activity" value="Write down three things I appreciate about myself.">
                                                        <li class="list-group-item">Write down three things I appreciate about others.</li>
                                                        <input style="display:none" name="activity" value="Write down three things I appreciate about others.">
                                                    </ul>
                                                    <div class="card-body">
                                                        <input type="submit" class="btn btn-success" value="Accept Adventure">
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                        <div class="carousel-item">
                                            <div class="card">
                                                <div class="quest-image text-center">
                                                    <img class="smallpic card-img-top" src="images/angry.jpg" alt="Card image cap">
                                                </div>
                                                <form action="AddActivity" method="POST">
                                                    <div class="card-body">
                                                        <h5 class="card-title">Understand my Mood</h5>
                                                        <input style="display:none" name="goal" value="Understand my Mood">
                                                        <p class="card-text">Make sure to reflect on your mood three times a day for a least a week.</p>
                                                    </div>
                                                    <ul class="list-group list-group-flush">
                                                        <li class="list-group-item">Rate in the morning.</li>
                                                        <input style="display:none" name="activity" value="Rate in the morning.">
                                                        <li class="list-group-item">Rate in the afternoon.</li>
                                                        <input style="display:none" name="activity" value="Rate in the afternoon.">
                                                        <li class="list-group-item">Rate in the evening.</li>
                                                        <input style="display:none" name="activity" value="Rate in the evening.">
                                                    </ul>
                                                    <div class="card-body">
                                                        <input type="submit" class="btn btn-success" value="Accept Adventure">
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                        <div class="carousel-item">
                                            <div class="card">
                                                <div class="quest-image text-center">
                                                    <img class="smallpic card-img-top" src="images/worried.jpg" alt="Card image cap">
                                                </div>
                                                <form action="AddActivity" method="POST">
                                                    <div class="card-body">
                                                        <h5 class="card-title">Step Out Of Your Comfort Zone</h5>
                                                        <input style="display:none" name="goal" value="Step Out Of Your Comfort Zone">
                                                        <p class="card-text">Take some risks and see what the world could have in store.</p>
                                                    </div>
                                                    <ul class="list-group list-group-flush">
                                                        <li class="list-group-item">Start a dialogue with an unknown person.</li>
                                                        <input style="display:none" name="activity" value="Start a dialogue with an unknown person.">
                                                        <li class="list-group-item">Say yes to something you would normally say no to.</li>
                                                        <input style="display:none" name="activity" value="Say yes to something you would normally say no to.">
                                                        <li class="list-group-item">Smile and say hi to three strangers.</li>
                                                        <input style="display:none" name="activity" value="Smile and say hi to three strangers.">
                                                    </ul>
                                                    <div class="card-body">
                                                        <input type="submit" class="btn btn-success" value="Accept Adventure">
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                        <div class="carousel-item">
                                            <div class="card">
                                                <div class="quest-image text-center">
                                                    <img class="smallpic card-img-top" src="images/runninglate.jpg" alt="Card image cap">
                                                </div>
                                                <form action="AddActivity" method="POST">
                                                    <div class="card-body">
                                                        <h5 class="card-title">Be on Time</h5>
                                                        <input style="display:none" name="goal" value="Be on Time">
                                                        <p class="card-text">Being punctual can help you take control of your situation. Give it a go.</p>
                                                    </div>
                                                    <ul class="list-group list-group-flush">
                                                        <li class="list-group-item">Estimate and track your time.</li>
                                                        <input style="display:none" name="activity" value="Estimate and track your time.">
                                                        <li class="list-group-item">Plan to and then arrive 15 mins early.</li>
                                                        <input style="display:none" name="activity" value="Plan to and then arrive 15 mins early.">
                                                        <li class="list-group-item">Do something useful while you wait.</li>
                                                        <input style="display:none" name="activity" value="Do something useful while you wait.">
                                                    </ul>
                                                    <div class="card-body">
                                                        <input type="submit" class="btn btn-success" value="Accept Adventure">
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                        <div class="carousel-item">
                                            <div class="card">
                                                <div class="quest-image text-center">
                                                    <img class="smallpic card-img-top" src="images/charity.jpg" alt="Card image cap">
                                                </div>
                                                <form action="AddActivity" method="POST">
                                                    <div class="card-body">
                                                        <h5 class="card-title">Do More Good and Feel Better</h5>
                                                        <input style="display:none" name="goal" value="Do More Good and Feel Better">
                                                        <p class="card-text">Taking care of others can be the thing that helps us be happier with ourselves.</p>
                                                    </div>
                                                    <ul class="list-group list-group-flush">
                                                        <li class="list-group-item">Do a good deed for a friend.</li>
                                                        <input style="display:none" name="activity" value="Do a good deed for a friend.">
                                                        <li class="list-group-item">Do a good deed for a stranger.</li>
                                                        <input style="display:none" name="activity" value="Do a good deed for a stranger.">
                                                        <li class="list-group-item">Do a good deed for a stranger, without telling anyone.</li>
                                                        <input style="display:none" name="activity" value="Do a good deed for a stranger, without telling anyone.">
                                                    </ul>
                                                    <div class="card-body">
                                                        <input type="submit" class="btn btn-success" value="Accept Adventure">
                                                    </div>
                                                </form>
                                            </div>
                                        </div>


                                    </div>



                                </div>
                            </div>
                            <div class="col-md-6">
                                <h3 class="text-center">Your Quests</h3>
                                <div id="accordion">
                                    <!-- FOR GOAL IN USER'S GOALS -->
                                    <%  List<Goal> goals = user.getProfile().getGoal();
                                        int i = 0;
                                        for (Goal g : goals) {
                                            i++;
                                    %>
                                    <div class="card">
                                        <div class="card-header">
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <h3 class="mb-0">
                                                        <button class="btn btn-link" data-toggle="collapse" data-target="#<%=i%>" aria-expanded="true" aria-controls="collapseOne">
                                                            <% out.print(g.getDescription());%>
                                                        </button>
                                                    </h3>
                                                </div>
                                                <div class="col-md-6 text-right">
                                                    <form action="DeleteGoal" method="POST">
                                                        <input style="display:none" name="goal" value="<%=g%>">
                                                        <button type="submit" class="btn btn-outline-success" value="Completed Quest">
                                                            <i class="fas fa-check-square"></i>
                                                        </button>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                        <div id="<%=i%>" class="collapse" aria-labelledby="<%=i%>" data-parent="#accordion">
                                            <div class="card-body">
                                                <div class="list-group">
                                                    <%  List<Activity> activities = g.getActivities();
                                                        for (Activity a : activities) {%>
                                                    <a class="list-group-item list-group-item-action"><% out.print(a.getDescription()); %></a>
                                                    <%}%>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                    <br/>
                                    <%}%>
                                </div>
                            </div>
                        </div>


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

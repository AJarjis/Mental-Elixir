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

        <title>FAQ's and Support</title>

        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/styles.css">

        <!-- Custom styles for this template -->
        <style type="text/css">


        </style>
    </head>


    <body>

        <div id="navBarPlaceholder"></div>

        <main role="main" class="flex-container">

            <div class="jumbotron jumbotron-fluid border-bottom" id="faqjumbo">
                <div class="container">
                    <img src="images/logo.svg" alt="logo" style="height: 10em">
                    <h1>FAQ's and Support</h1>
                    <h2>Here to answer your burning questions.</h2>
                    <p>Please see below the most Frequently Asked Questions (FAQ) that Elixir is asked about types of mental health
                    problems, with descriptions on each and links for more information and how to get help and support.</p>
                </div>
            </div>

            <div class="row chart p-5 justify-content-center" id="faqbox">

                <div class="wrap-collabsible">
                    <input id="collapsible1" class="toggle" type="checkbox">
                    <label for="collapsible1" class="lbl-toggle">Types of Mental Health Problems</label>
                        <div class="collapsible-content">
                            <div class="content-inner">
                                <p>
                                    If you’ve just been diagnosed with a mental health problem you might be looking for 
                                    information on your diagnosis, treatment options and where to go for support. Our information 
                                    pages will give you help and advice on all things Elixir, and also give you useful links to other 
                                    mental health companies in order to provide you with the latest up to date knowledge on all things 
                                    mental health. Types of Mental Health problems which have links to external support include:                                  
                                    <ul>
                                        <li>Anger</li>
                                        <li>Anxiety and Panic Attacks</li>
                                        <li>Depression</li>
                                        <li>Loneliness</li>
                                        <li>Phobias</li>
                                        <li>Post Traumatic Stress Disorder (PTSD)</li>
                                        <li>Self Harm/Suicidal Thoughts</li>
                                    </ul> 
                                </p>
                            </div>
                        </div>
            
                    <input id="collapsible2" class="toggle" type="checkbox">
                    <label for="collapsible2" class="lbl-toggle">What is Anger?</label>
                        <div class="collapsible-content">
                            <div class="content-inner">
                                <p>
                                    Please visit <a href="https://www.mind.org.uk/information-support/types-of-mental-health-problems/anger/about-anger/?o=6271#.Wv7GGPZFykQ">Advice on Anger</a> 
                                    to gain a better understanding on anger. MIND will give detailed descriptions on:
                                    <ul>
                                        <li>What is Anger</li>
                                        <li>When is Anger a problem</li>
                                        <li>What is unhelpful angry behaviour</li>
                                        <li>How can anger affect both mental and physical health</li>
                                    </ul> 
                                </p>
                            </div>
                        </div>
                    
                    <input id="collapsible3" class="toggle" type="checkbox">
                    <label for="collapsible3" class="lbl-toggle">What are Anxiety and Panic Attacks?</label>
                        <div class="collapsible-content">
                            <div class="content-inner">
                                <p>
                                    "You know that feeling when you’re rocking on the back legs of your chair and suddenly for just a 
                                    split second you think you’re about to fall; that feeling in your chest? Imagine that split second 
                                    feeling being frozen in time and lodged in your chest for minutes/hours/days, and imagine with it that 
                                    sense of impending doom and dread sticking around too, but sometimes you don’t even know why."
                                </p>
                                <p>
                                    This is a quote from a video transcript MIND recently undertook with a number of patients suffering 
                                    from anxiety. <a href="https://www.mind.org.uk/information-support/types-of-mental-health-problems/anxiety-and-panic-attacks/about-anxiety/?o=6272#.Wv7HnfZFykQ">Anxiety and Panic Attacks</a> is where 
                                                     you can find all of the up to date information on how to best relieve yourself of anxiety and 
                                                     deal with panic attacks. Hear first hand stories from people who have been or still are 
                                                     suffering from anxiety and/or maybe experience panic attacks. This article gives you the 
                                                     ability to learn methods to stay calm and composed and understand exactly what anxiety is 
                                                     and how it can have a negative effect on your life.                                
                                </p>
                            </div>
                        </div>
                    
                    <input id="collapsible4" class="toggle" type="checkbox">
                    <label for="collapsible4" class="lbl-toggle">What is Depression?</label>
                        <div class="collapsible-content">
                            <div class="content-inner">
                                <p>
                                    Depression is a low mood than can last for a long period of time and have 
                                    severely negative impacts on your life, depending on the severity of the stress. 
                                    Mildly, depression can just be low spirits with the occassional bad thought, 
                                    however at it's most severe, it can make people feel suicidal, giving up the 
                                    will to live. "It feels like I'm stuck under a huge grey-black cloud. It's 
                                    dark and isolating, smothering me at every opportunity." - Amy, a patient 
                                    from MIND about depression. 
                                </p>
                                <p>
                                    Hear from Amy and other patients who suffer from depression at 
                                    <a href="https://www.mind.org.uk/information-support/types-of-mental-health-problems/depression/about-depression/?o=9109#.Wv7RZ_ZFykQ">Depression</a>. 
                                       Learn the different types of depression, the impact it can have on your life, and 
                                       watch a group of people talk with one another about their depression, and how they 
                                       are trying to deal with it to improve all aspects of their life, whether it be their
                                       mental wellbeing (a direct impact from depression), or their physical wellbeing 
                                       (an indirect impact from depression).
                                </p>
                            </div>     
                        </div>
            
                    <input id="collapsible5" class="toggle" type="checkbox">
                    <label for="collapsible5" class="lbl-toggle">What is Loneliness?</label>
                        <div class="collapsible-content">
                            <div class="content-inner">
                                <p>
                                    <a href="https://www.mind.org.uk/information-support/tips-for-everyday-living/loneliness/loneliness/?o=6287#.Wv7M2PZFykQ">Loneliness</a> isn't 
                                       something that is directly considered as a mental health issue, however 
                                       it is something that affects many people and can lead onto mental health 
                                       issues, like those mentioned in the FAQs here. Following the link will
                                       transport you to a wide range of detailed information on loneliness, 
                                       covering the following topics:
                                    <ul>
                                        <li>Why do I feel lonely?</li>
                                        <li>How can I make new connections?</li>
                                        <li>Opening Up</li>
                                        <li>Taking it slow</li>
                                        <li>Ways to tell how I'm feeling</li>
                                        <li>Getting Help</li>
                                        <li>Reading other Stories</li>
                                    </ul> 
                                    If you have are feeling lonely and looking for professional advice and support 
                                    on any of the above topics to do with loneliness, then the above link is the place to follow!
                                </p>
                            </div>
                        </div>
        
                    <input id="collapsible6" class="toggle" type="checkbox">
                    <label for="collapsible6" class="lbl-toggle">What are phobias?</label>
                        <div class="collapsible-content">
                            <div class="content-inner">
                                <p>
                                    A phobia is a type of anxiety disorder. It is an extreme form of fear or anxiety triggered by a particular 
                                    situation (such as being high off the ground) or an object (such as snakes), even when 
                                    there is no danger. Phobias may not even be triggered from just simply being in the 
                                    situations such as those above, as phobias can be triggered from just thinking or 
                                    seeing images of these situations. 
                                </p>
                                <p> 
                                    The following links will take you to specific sections about all things phobias.
                                    <ul>
                                        <li><a href="https://www.mind.org.uk/information-support/types-of-mental-health-problems
                                               /phobias/about-phobias/?o=6804#.Wv7QVvZFykQ">What are phobias?</a> </li>
                                        <li><a href="https://www.mind.org.uk/information-support/types-of-mental-health-problems
                                               /phobias/types-of-phobia/?o=6804#.Wv7RLPZFykQ">What types of phobias are there?</a></li>
                                        <li><a href="https://www.mind.org.uk/information-support/types-of-mental-health-problems
                                               /phobias/symptoms-of-phobias/?o=6804#.Wv7R__ZFykQ">Symptoms of Phobias</a></li>
                                        <li><a href="https://www.mind.org.uk/information-support/types-of-mental-health-problems
                                               /phobias/causes-of-phobias/?o=6804#.Wv7SRvZFykQ">Causes of Phobias</a></li>
                                    </ul>                           
                                </p>
                            </div>
                        </div>
        
                    <input id="collapsible7" class="toggle" type="checkbox">
                    <label for="collapsible7" class="lbl-toggle">What is Post Traumatic Stress Disorder (PTSD)?</label>
                        <div class="collapsible-content">
                            <div class="content-inner">
                                <p>
                                    <a href="https://www.mind.org.uk/information-support/types-of-mental-health-problems/post-traumatic-stress-disorder-ptsd/about-ptsd/?o=14567#.Wv7SkPZFykQ">Post Traumatic Stress Diorder - 
                                        also known as PTSD</a> is a type of anxiety disorder which usually comes about after being 
                                        involved in or witnesseing traumatic events. Common known causes of PTSD include coming 
                                        home from war, but are by no means limited to this, as things such as being in a bad car 
                                        crash can ignite these traumatic events.
                                </p>
                                <p>
                                    Knowing what it's like to have PTSD, how it is diagnosed, as well as what type of PTSD 
                                    you have are key aspects into getting the correct help as soon as possible. The three 
                                    types of PTSD include:
                                    <ul>
                                        <li>Delayed-Onset PTSD</li>
                                        <li>Complex PTSD</li>
                                        <li>Birth Trauma</li>
                                    </ul> 
                                    
                                    Follow the link at the start of this FAQ to be taken to information about topics mentioned 
                                    above, as well symptoms to PTSD, and more material on the three types of 3 PTSD, with the 
                                    best methods of self care for this disorder.
                                </p>
                            </div>
                        </div>
        
                    <input id="collapsible8" class="toggle" type="checkbox">
                    <label for="collapsible8" class="lbl-toggle">What is Self Harm/Suicidal Thoughts?</label>
                        <div class="collapsible-content">
                            <div class="content-inner">
                                <p>
                                    <a href="https://www.mind.org.uk/information-support/types-of-mental-health-problems/self-harm
                                       /about-self-harm/?o=6809#.Wv7UuPZFykQ">Self Harm</a> and <a href="https://www.mind.org.uk/
                                              information-support/types-of-mental-health-problems/suicidal-feelings/about-suicidal-
                                              feelings/?o=6813#.Wv7U3PZFykQ">Suicidal Thoughts</a> are two very important topics in 
                                              mental health, of which the former can lead onto the latter in the most severe of cases. 
                                </p>
                                <h5>Self Harm</h5>
                                <p>
                                    Self-harm is when you hurt yourself as a way of dealing with very difficult feelings, painful memories 
                                    or overwhelming situations and experiences. There are a number of reasons as to why people perform self 
                                    harming actions, from changing emotional pain to physical pain, to punishing yourself for bad feelings 
                                    or experiences. Self harm can also vary from the type of harm people can do to their bodies, 
                                    this may be from cutting body parts with sharp objects, to over eating or simply pulling hair out. 
                                    All of which have negative impacts on human life, even if the instant pain may bring short term relief. 
                                </p>
                                <h5>Suicidal Thoughts</h5>
                                <p>
                                    Suicidal thoughts is the thought of taking your own life, with suicidal actions the 
                                    action of taking it. This is the mental health problem with the biggest overall impact 
                                    should this occur, and therefore should be taken incredibly seriously. Suicidal thoughts are usually 
                                    unique to the individuals who feel them, and these feelings/thoughts can be overwhelming to the 
                                    individual. Men and LGBTQ are the two highest risk groups of individuals who are more likely to 
                                    take their own life, although it is not entirely clear why this is the case. If you have been 
                                    feeling suicidal thoughts or know someone who may be, please visit 
                                    <a href="https://www.mind.org.uk/information-support/types-of-mental-health-problems/suicidal-feelings/about-suicidal-feelings/?o=6813#.Wv7U3PZFykQ">this</a> link as soon as possible for the best 
                                    support, advice and guideance available online to take you in the right direction.
                                </p>
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

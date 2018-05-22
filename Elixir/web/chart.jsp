<%-- 
    Document   : chart
    Created on : 22-May-2018, 15:33:38
    Author     : Kieran
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Controller.DatabaseController"%>
<%@page import="java.util.LinkedList"%>
<%@page import="Model.Mood"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Controller.UserController"%>
<%@page import="Controller.DatabaseController"%>
<%
    UserController user = (UserController) session.getAttribute("user");
    
    if (user == null) {
        RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
        rd.forward(request, response);
    }
%>
<!DOCTYPE html>
<head>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.js"></script>
</head>
<body>
    <div class="container">
        <canvas id="myChart" max-width="450" max-height="225">    
        </canvas>
    </div>
    <form>
        <input name="dateFrom" type="date" value="2018-05-10">
        <input name="dateTo" type="date" value="2018-05-23">
        <input type="submit">
    </form>

    <%
        //Creates default cals
        Calendar cal = Calendar.getInstance();
        Calendar calTo = Calendar.getInstance();
        //pulls data from HTML
        String value = request.getParameter("dateFrom");
        String valueTo = request.getParameter("dateTo");
        if(value==null)
        {
            value = "2018-05-10";
        }
        if(valueTo==null)
        {
            valueTo = "2018-05-30";
        }

        //seperates the data into fields to create the cal object
        char[] year = new char[4], month = new char[2], day = new char[2];
        value.getChars(0, 4, year, 0);
        value.getChars(5, 7, month, 0);
        value.getChars(8, 10, day, 0);
        cal.set(Integer.parseInt(String.valueOf(year)),
                Integer.parseInt(String.valueOf(month))-1,
                Integer.parseInt(String.valueOf(day)));

        valueTo.getChars(0, 4, year, 0);
        valueTo.getChars(5, 7, month, 0);
        valueTo.getChars(8, 10, day, 0);
        calTo.set(Integer.parseInt(String.valueOf(year)),
                Integer.parseInt(String.valueOf(month))-1,
                Integer.parseInt(String.valueOf(day)));
        List<Mood> moods = new LinkedList<Mood>();
        //This is the bit that doesn't work.
        moods = DatabaseController.getMoodsBetweenDates(user.getUserName(), cal, calTo);
        ArrayList<Integer> data = new ArrayList<Integer>();
        for(Mood mood : moods)
        {
            data.add(mood.getMoodType());
        }

    %>
    <!-- prints the cals for debugging -->
    <p> <%=data%> </p>
    <p> <%=cal.getTime()%> </p>
    <p> <%=calTo.getTime()%> </p>
    <script>
        new Chart(document.getElementById("myChart"), {
            type: 'line',
            data: {
                //labels: ["15/6", "16/6", "17/6", "18/6", "19/6", "20/6", "20/6", "21/6", "22/6", "23/6"],
                datasets: [{
                        data: <%=data%>,
                        //label: "Fear",
                        borderColor: "#3e95cd",
                        fill: false
                    }
                ]
            },
            options: {
                scales: {
                    xAxes: [{
                            scaleLabel: {
                                display: true,
                                labelString: 'Time'
                            },
                            gridLines: {
                                drawOnChartArea: false
                            }
                        }],
                    yAxes: [{
                            ticks: {
                                display: false
                                    },
                            scaleLabel: {
                                display: true,
                                labelString: 'Contentment'
                            },
                            gridLines: {
                                drawOnChartArea: false
                            }
                        }]
                },
                legend: {
                    display: false
                    }

            }
        });
    </script>

    <!––
    Check dateFrom < dateTo
    Pull dates from date picker
    run date_diff_indays on those dates
    for each day
    Add each day to a stringArray
    Add data for that day into intArray
    Put stringArray into "labels"
    Put intArray into "data" of RADIO BUTTON    
    Draw Chart

    --->

</body>

<%-- 
    Document   : chart
    Created on : 22-May-2018, 15:33:38
    Author     : Kieran
--%>

<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.Locale"%>
<%@page import="java.time.LocalDateTime"%>
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
    <div class="container-flex">
        <canvas id="myChart" width="80%" >    
        </canvas>
    </div>
    <!--    <form>
            <input name="dateFrom" type="date" value="2018-05-10" onchange="updateConfigByMutating()">
            <input name="dateTo" type="date" value="2018-05-23">
            <input type="submit">
        </form>-->

    <%
        //Creates default cals
        Calendar cal = Calendar.getInstance();
        Calendar calTo = Calendar.getInstance();
        //pulls data from HTML
        LocalDateTime ldt = LocalDateTime.now().plusDays(1);
        DateTimeFormatter formmat1 = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        System.out.println(ldt);

        String formatter = formmat1.format(ldt);
        
        String value = request.getParameter("dateFrom");
        String valueTo = request.getParameter("dateTo");
        if (value == null) {
            value = "2018-05-10";
        }
        if (valueTo == null) {
            valueTo = formatter;
        }

        //seperates the data into fields to create the cal object
        char[] year = new char[4], month = new char[2], day = new char[2];
        value.getChars(0, 4, year, 0);
        value.getChars(5, 7, month, 0);
        value.getChars(8, 10, day, 0);
        cal.set(Integer.parseInt(String.valueOf(year)),
                Integer.parseInt(String.valueOf(month)) - 1,
                Integer.parseInt(String.valueOf(day)));

        valueTo.getChars(0, 4, year, 0);
        valueTo.getChars(5, 7, month, 0);
        valueTo.getChars(8, 10, day, 0);
        calTo.set(Integer.parseInt(String.valueOf(year)),
                Integer.parseInt(String.valueOf(month)) - 1,
                Integer.parseInt(String.valueOf(day)));
        List<Mood> moods = new LinkedList<Mood>();
        //This is the bit that doesn't work.
        moods = DatabaseController.getMoodsBetweenDates(user.getUserName(), cal, calTo);
        ArrayList<Integer> data = new ArrayList<Integer>();
        for (Mood mood : moods) {
            data.add(mood.getMoodType());
        }
    %>
    <!-- prints the cals for debugging -->
<!--    <p> <%=data%> </p>
    <p> <%=cal.getTime()%> </p>
    <p> <%=calTo.getTime()%> </p>-->
    <script>
        var jsData = [];

        <% for (int i = 0; i < data.size(); i++) {%>
        <%int moodValue = data.get(i);%>
        jsData.push(<%=moodValue%>);
        <% }%>

        console.log(jsData);

        var chart = new Chart(document.getElementById("myChart"), {
            type: 'line',
            data: {
                labels: [" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",
                    " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",
                    " ", " ", " ", " ", " ", " ", " "],
                datasets: [{
                        data: jsData,
                        label: "Contentment",
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

        function updateConfigByMutating() {
            chart.options.legend.display = true;
            chart.update();
        }
    </script>
</body>

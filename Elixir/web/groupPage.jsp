<%-- 
    Document   : groupPage
    Created on : 22-May-2018, 21:03:22
    Author     : Kieran
--%>

<%@page import="Controller.GroupController"%>
<%@page import="Model.User"%>
<%@page import="Model.Group"%>
<%@page import="Controller.DatabaseController.*"%>
<%@page import="java.util.List"%>
<%@page import="Controller.DatabaseController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Group Page</title>
    </head>
    <body>
        <% GroupController group = (GroupController) session.getAttribute("group"); %>
        <h1><% out.print(group.getGroupName()); %></h1>
        <p><% out.print(group.getDescription()); %></p>
        <% for(User u : group.getMembers())
        {
            %>
            <p><% out.print(u.getFirstName()); %></p>
            <p><% out.print(u.getSurname());%></p>
        <%}%>
    </body>
</html>

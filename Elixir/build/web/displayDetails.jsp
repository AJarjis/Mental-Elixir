<%-- 
    Document   : displayDetails
    Created on : 12-Mar-2018, 11:31:52
    Author     : AJarj
--%>

<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello 
            <%
            User user = (User) request.getAttribute("user");
            out.print(user.getUserName());
            %> 
        </h1>
    </body>
</html>
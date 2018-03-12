<%-- 
    Document   : registration
    Created on : 11-Mar-2018, 17:20:30
    Author     : AJarj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Test Registration!</h1>
        <form action="RegisterUser" method="POST">
            UserName:<input type="text" name="userName" /><br />
            First Name:<input type="text" name="firstName" /><br />
            Surname:<input type="text" name="surname" /><br />
            Email:<input type="text" name="email" /><br />
            Password:<input type="password" name="password"><br>  
            <input type="submit" value="Register">
        </form>
    </body>
</html>

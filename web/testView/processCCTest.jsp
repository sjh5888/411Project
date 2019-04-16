<%-- 
    Document   : processCCTest
    Created on : Apr 16, 2019, 2:06:08 PM
    Author     : roscoeturner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout Test</title>
    </head>
    <body>
        <h1>Life is pain</h1>

        <form action="${pageContext.servletContext.contextPath}/checkout" method="post">
            <input type="hidden" name ="action" value ="confirm"/>
            <p>Card #:</p> 
            <input type= "text" name="cardNumber"/>      
            <input type= "submit" value="submit"/>
        </form>

    </body>
</html>

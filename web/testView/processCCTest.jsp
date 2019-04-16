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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <form action="CheckoutServlet">
            <input type="hidden" name ="action" value ="confirm"</input>
            <p>Name:</p> 
            <input type= "text" name="cardNumber"/>
            <p>Yearly Salary:</p> 
            <input type= "text" name="salary"/>
            <input type= "submit" value="submit"/>
        </form>
        
    </body>
</html>

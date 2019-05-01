<%-- 
    Document   : ContinueShopping
    Created on : Apr 27, 2019, 8:12:16 PM
    Author     : Kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            .cs{
                background-color: appworkspace;
                border: 2;
                color: white;
                padding: 15px 32px;
                text-align: center;
                text-decoration: none;
                margin: 10px;
                display: inline-block;
                font-size: 16px;
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1>Do you want to checkout or continue shopping</h1>
        <form action="product" method="post">
            <input type="hidden" name ="action" value ="continue"/>  
            <input type= "submit" class="cs" value="Continue Shopping "> 
        </form>
        <form action="${pageContext.servletContext.contextPath}/checkout" method="post">
            <input type="hidden" name="action" value="viewCart" />
            <input type="submit" class="cs" value="View Shopping Cart" />
        </form>
    </center>
</body>
</html>

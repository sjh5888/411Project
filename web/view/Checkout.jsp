<%-- 
    Document   : Checkout
    Author     : gkemp
--%>

<div id ="centerColumn">
    <center>
    <h1>Checkout</h1>
    <span>${product.name}</span>
    <p>Total Bill: <b>$
            <%=request.getAttribute("data") %></b></p><br>
    
    <h2>Please Enter The Following</h2>
    <form action="${pageContext.servletContext.contextPath}/checkout" method="post">
        <input type="hidden" name ="action" value ="confirm"/>
        <p>Credit Card Number:</p> 
        <input type= "text" name="cardNumber"/><br>  
        <label class="pad_top">First Name:</label><br>
        <input type="text" name="firstName" value="${CheckoutServlet.firstName}"><br>
        <label class="pad_top">Last Name:</label><br>
        <input type="text" name="lastName" value="${CheckoutServlet.lastName}"><br>  
        <input type= "submit" value="submit"/>
    </form>
    </center>
</div>
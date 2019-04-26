<%-- 
    Document   : Checkout
    Author     : gkemp
--%>

<div id ="centerColumn">
    <center>
    <h1>That number is invalid. </h1>
    <span>${product.name}</span>
    <h2>Please Try again</h2>
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
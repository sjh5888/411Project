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
        <label class="pad_top">Credit Card Number: </label><br> 
        <input type= "text" name="cardNumber"/><br><br>
        <label class="pad_top">First Name: </label><br>
        <input type="text" name="firstName" value="${CheckoutServlet.firstName}"><br><br>
        <label class="pad_top">Last Name: </label><br>
        <input type="text" name="lastName" value="${CheckoutServlet.lastName}"><br><br>
        <label class="pad_top">Address: </label><br>
        <input type="text" name="lastName" value="${CheckoutServlet.address}"><br><br>  
        <label class="pad_top">Shipping Method: </label><br>
        <input type="radio" name="shipping" value="Ground"> Free Ground Ship<br>
        <input type="radio" name="shipping" value="">   Free Two-Day Air   <br>
        <input type= "submit" value="submit"/><br>   
    </form>
    </center>
</div>
<%-- 
    Document   : Checkout
    Author     : gkemp
--%>

<!-- Checkout.jsp page is used so the customer can purchase their items 
      with the correct credit card number and uses checkoutServlet-->

<div id ="centerColumn">
    <center>
        <h1>Checkout</h1>
        <%--<span>${product.name}</span>--%>
        <%--<p>Total Bill: <b>$
                <%=request.getAttribute("data")%></b></p><br>--%>

        <h2>Please Enter The Following</h2>
        <form action="${pageContext.servletContext.contextPath}/checkout" method="post">
            <input type="hidden" name ="action" value ="confirm"/>
            <label class="pad_top">Credit Card Number: </label><br> 
            <input type= "text" name="cardNumber"/><br><br>
            <label class="pad_top">First Name: </label><br>
            <input type="text" name="firstName" value="${CheckoutServlet.firstName}"><br><br>
            <label class="pad_top">Last Name: </label><br>
            <input type="text" name="lastName" value="${CheckoutServlet.lastName}"><br><br>
            <label class="pad_top">Address: </label><br>
            <input type="text" name="address" value="${CheckoutServlet.address}"><br><br>  
            <label class="pad_top">Shipping Method: </label><br>
            <input type="radio" name="shipping" value="Free Ground Ship"> Free Ground Ship<br>
            <input type="radio" name="shipping" value="Free Two-day Air">   Free Two-Day Air   <br>
            <input type= "submit" value="submit"/><br>   
        </form>
    </center>
</div>
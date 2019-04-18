<%-- 
    Document   : Checkout
    Author     : gkemp
--%>

<div id ="centerColumn">
    <h1>Checkout</h1>
    <h2>Please Enter The Following</h2>
    <form action="${pageContext.servletContext.contextPath}/view/Confirmation.jsp" method="post">
            <input type="hidden" name ="action" value ="confirm"/>
            <p>Credit Card Number:</p> 
            <input type= "text" name="cardNumber"/>      
            <input type= "submit" value="submit"/>
        </form>
    </form>
</div>
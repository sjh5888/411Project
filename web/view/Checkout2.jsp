<%-- 
    Document   : Checkout
    Author     : gkemp
--%>
<style>
    
    body {
    background-image: url("./images2/background.jpg");
    background-repeat: no-repeat;
    background-size: cover;
    

}
</style>

<body>

<div id ="centerColumn">
    <center>
        <h1 style="font-style:oblique; font-size: 22px; color:red">That number is invalid. </h1>
        <span>${product.name}</span>
        <h2>Please Try again</h2>
        <form action="${pageContext.servletContext.contextPath}/checkout" method="post">
            <input type="hidden" name ="action" value ="confirm"/>
            <label class="pad_top">Credit Card Number: </label><br> 
            <input type= "text" name="cardNumber"/><br><br>
            <label class="pad_top">First Name: </label><br>
            <input type="text" name="firstName" value="<%=request.getParameter("firstName")%>"><br><br>
            <label class="pad_top">Last Name: </label><br>
            <input type="text" name="lastName" value="<%=request.getParameter("lastName")%>"><br><br>
            <label class="pad_top">Address: </label><br>
            <input type="text" name="address" value="<%=request.getParameter("address")%>"><br><br>  
            <label class="pad_top">Shipping Method: </label><br>
            <input type="radio" name="shipping" value="Free Ground Ship"> Free Ground Ship<br>
            <input type="radio" name="shipping" value="Free Two-Day Air">   Free Two-Day Air   <br>
            <input type= "submit" value="submit"/><br>   
        </form>
    </center>
</div>
</body>
<%-- 
    Document   : Confirmation
    Author     : gkemp
--%>

<!-- Confirmation.jsp will show the user a thank you confirmation and will return
     the user's name, address, and shipping option.-->

<head>
<style>
    
    body {
    background-image: url("./images2/background.jpg");
    background-repeat: no-repeat;
    background-size: cover;
    

}
</style>
</head>
<body>
<div id ="centerColumn2">
    <center>
    <h1 style="font-style:oblique; font-size: 22px">Confirmation</h1>
        <div class="categoryImage">
            <p>Thank you <strong><%= request.getParameter("firstName")%> 
                    <%= request.getParameter("lastName")%></strong> for your purchase!</p><br> 
                    <p>Your package will be sent to: <br><br><strong>
                    <%= request.getParameter("address")%><br>
                    by <%= request.getParameter("shipping")%></strong><br><br>
                You will be receiving your candy shortly!</p>
            <form action="product" method="post">
                <input type="hidden" name ="action" value ="continue"/>  
                <input type= "submit" class="cs" value="Return to Categories"> 
            </form>
    </center>
    </div>  
    </div>
</body>
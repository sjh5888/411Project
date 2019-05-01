<%-- 
    Document   : Confirmation
    Author     : gkemp
--%>

<div id ="centerColumn">
    <center>
        <h1>Confirmation</h1>
        <div class ="categoryImage">
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
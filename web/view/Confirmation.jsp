<%-- 
    Document   : Confirmation
    Author     : gkemp
--%>

<div id ="centerColumn">
    <center>
        <h1>Confirmation</h1>
        <div class ="categoryImage">
            <p>Thank you <%= request.getParameter("firstName")%> <%= request.getParameter("lastName")%> for your purchase! <br> 
                You will be receiving your candy shortly!</p>

            <form action="product" method="post">
                <input type="hidden" name ="action" value ="continue"/>  
                <input type= "submit" class="cs" value="Return to Categories"> 
            </form>
    </center>
</div>  
</div>
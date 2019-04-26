<%-- 
    Document   : Confirmation
    Author     : gkemp
--%>

<div id ="centerColumn">
    <center>
    <h1>Confirmation</h1>
    <div class ="categoryImage">
        <p>Thank you <%= request.getParameter("firstName") %> <%= request.getParameter("lastName") %> for your purchase! <br> 
            You will be receiving your candy shortly!</p>

        <span class ="categoryText">${data.ProductsBean.productName}</span>
    </center>
    </div>  
</div>
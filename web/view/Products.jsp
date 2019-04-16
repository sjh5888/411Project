<%-- 
    Document   : Products
    Author     : gkemp
--%>

<div id ="centerColumn">
    <div class="row">
        <div class ="image">
            <a href="./IndProducts.jsp">
                <form action="ProductServlet" method="post">
                <label class="pad_top">Product Name: </label>
                <input type="hidden" name="Name" value=${ProductsBean.getName} /><br>
                <label class="pad_top">ID: </label>
                <input type="hidden" name="ProductId" value="${ProductsBean.getProductId}" /><br>
                <label class="pad_top">Price: </label>
                <input type="hidden" name="Price" value="${ProductsBean.getPrice}" /><br>
                </form>
        </div>  
    </div>
</div>

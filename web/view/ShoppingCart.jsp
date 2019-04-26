<%-- 
    Document   : ShoppingCart
    Author     : gkemp
--%>

<div id ="centerColumn">
    <center>
    <h1>Shopping Cart</h1>

    <div class="row">
       
 
            <form action="${pageContext.servletContext.contextPath}/checkout" method="post">
                <label class="pad_top">Product Name: </label>
                <span>${cookie.cart.value}</span>
                <span>${data.ProductsBean.categoryId}</span><br>
                <input type="hidden" name="action" value="checkout">
                <input type="submit" value="Check Out">
            </form></a>
    </div> 

    </center>
</div> 
</div>

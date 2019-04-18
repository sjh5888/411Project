<%-- 
    Document   : ShoppingCart
    Author     : gkemp
--%>

<div id ="centerColumn">

    <h1>Shopping Cart</h1>

    <div class="row">
        <p>Test Words</p>
            <form action="${pageContext.servletContext.contextPath}/view/Products.jsp" method="post">
                <label class="pad_top">Product Name: </label>
                <span>${data.ProductsBean.categoryId}</span><br>
                <input type="" name="action" value="products">
                <input type="submit" value="Choose">
            </form></a>
        </div> 


    </div> 
</div>
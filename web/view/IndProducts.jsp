<%-- 
    Document   : IndProducts
    Author     : gkemp
--%>


<%

    ProductsBean select = (ProductsBean) request.getAttribute("product");


%>

<div id ="centerColumn">

    <div class ="prodImage">
       
        <div id="indivProd">
            <div class ="image">
                <form action="${pageContext.servletContext.contextPath}/checkout" method="post">
                    <label class="pad_top">Product Name: </label>
                    <span>${data.ProductsBean.name}</span><br>
                    <label class="pad_top">Description: </label>
                    <span>${data.ProductsBean.description}</span><br>
                    <input type="hidden" name="action" value="addToCart">
                    <input type="submit" value="Add to Cart">
                </form>
            </div> 
        </div>
    </div>  
</div>

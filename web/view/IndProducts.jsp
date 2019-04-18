<%-- 
    Document   : IndProducts
    Author     : gkemp
--%>

<div id ="centerColumn">

    <div class ="prodImage">
        <a href="#">
            <span class ="ProdText">Product</span>
        </a>
        <div id="indivProd">
            <div class ="image">
                <form action="${pageContext.servletContext.contextPath}/checkout" method="post">
                    <label class="pad_top">Product Name: </label>
                    <span>${ProductsBean.name}</span><br>
                    <label class="pad_top">Description: </label>
                    <span>${ProductsBean.description}</span>
                    <input type="hidden" name="action" value="products">
                    <input type="submit" value="Choose">
                </form></a>
            </div> >
        </div>
    </div>  
</div>

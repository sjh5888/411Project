<%-- 
    Document   : IndProducts
    Author     : gkemp
--%>


<div id ="centerColumn">

    <div class ="prodImage">
       
        <div id="indivProd">
            <div class ="image">
                <form action="${pageContext.servletContext.contextPath}/checkout" method="post">
                    <label class="pad_top"></label>
                    <span>${prodcut.imageLocation}</span>
                    <label class="pad_top">Product: </label>
                    <span>${product.name}</span><br><br>
                    <label class="pad_top">Description: </label>
                    <span>${product.description}</span><br>
                    <input type="hidden" name="action" value="addToCart">
                    <input type="submit" value="Add to Cart">
                </form>
            </div> 
        </div>
    </div>  
</div>

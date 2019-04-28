<%-- 
    Document   : IndProducts
    Author     : gkemp
--%>


<div id ="centerColumn">

    <h1> <br/><br/></h1>
    <div class ="prodImage">
        

        <div id="indivProd">
            <div class ="image">
                <center>
                <form action="${pageContext.servletContext.contextPath}/checkout" method="post">
                    <label class="pad_top">Product#: </label>
                    <span>${product.productId}</span><br>
                    <input type="hidden" name="itemID" value="${product.productId}">
                    <%--<label class="pad_top">Product#: </label>--%>
   
                    <span>${product.name}</span><br>
                    <input type="hidden" name ="name" value="${product.name}">
                    <label class="pad_top"></label>
                    <span><img src = "${product.imageLocation}"</span><br>
                    <input type="hidden" name="image" value="${product.imageLocation}">
                    <label>Price: </label>
                    <span>${product.price}</span><br><br>
                    <input type="hidden" name="price" value="${product.price}">
                    </div>
                    <div class="image"><br><br>
                        <label class="pad_top"><strong>Description:</strong></label><br>
                        <span>${product.description}</span><br><br><br>
                        <label class="pad_top">Enter Quantity: </label>
                        <input type="text" name="quantity" value="${CheckoutServlet.quantity}"><br>
                    <input type="hidden" name="action" value="addToCart">
                    <input type="submit" value="Add to Cart">
                    
                </form> 
                        <form action="${pageContext.servletContext.contextPath}/checkout" method="post">
                            <input type ="submit" name="action" value="viewCart">
                        </form>
                    </center>
            </div> 
                       
        </div>
    </div>  
</div>

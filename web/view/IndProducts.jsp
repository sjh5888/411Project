<%-- 
    Document   : IndProducts
    Author     : gkemp
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- IndProducts.jsp will show an individual product with its price and 
     description.  A customer can choose the quantity of the product they
     would like to purchase and uses checkoutServlet-->
<style>

    body {
        background-image: url("./images2/background.jpg");
        background-repeat: no-repeat;
        background-size: cover;


    }
</style>

<body>

    <div id ="centerColumn">
        <div class ="prodImage">
            <center>
                <h1 style="font-style:oblique; font-size: 22px">Product</h1><br>
               
                <c:if test="${inputError != null}">
                    <p><i>${inputError}</i></p>
                </c:if>

                <div id="indivProd">
                    <div class ="image">
                        <form action="${pageContext.servletContext.contextPath}/checkout" method="post">
                            <label class="pad_top">Product#: </label>
                            <span>${product.productId}</span><br>
                            <input type="hidden" name="itemID" value="${product.productId}">
                            <span>${product.name}</span><br>
                            <input type="hidden" name ="name" value="${product.name}">
                            <label class="pad_top"></label>
                            <span><img src = "${product.imageLocation}"</span><br>
                            <input type="hidden" name="image" value="${product.imageLocation}">
                            <label>Price: </label>
                            <span>${product.price}</span><br><br>
                            <input type="hidden" name="price" value="${product.price}">
                            </div>
                            <div class="image">
                                <label class="pad_top"><strong>Description:</strong></label><br>
                                <span>${product.description}</span><br><br><br>
                                <label class="pad_top">Enter Quantity: </label>
                                <input type="text" name="quantity" value="${CheckoutServlet.quantity}"><br>
                                <input type="hidden" name="action" value="addToCart">
                                <input class="bButton" type="submit" value="Add to Cart">
                                </form> 
                                </center>
                            </div>                     
                    </div> 
                    </body>

<%-- 
    Document   : ShoppingCart
    Author     : gkemp
--%>

<div id ="centerColumn">

    <h1>Cart</h1>

    <div class="row">
        <p>
            <strong>To change the quantity for an item,</strong> enter the new
            quantity and click on the Update button.
        </p>
        <p>
            <strong>To remove an item,</strong> click on the remove button.
        </p>
        <a href="<c:url value='./Category.jsp' />" class="button">Continue shopping</a>
        <form method="post" action="<c:url value='./Checkout.jsp'/>">
            <input type="submit" class="button" value="Checkout" />
        </form>
    </div>
    <table class="table">

        <thead>
            <tr>
                <th>Quantity</th>
                <th>Description</th>
                <th>Price</th>
                <th>Amount</th>
                <th>&nbsp;</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${Productsbean.items}">
            <tr>
                <td>
                    <form method="post" action="<c:url value='/order/updateItem'/>">
                        <input type="hidden" name="product" value="<c:out value='${ProductsBean.productId}' />" />
                        <input type="submit" class="button" value="Update" />
                    </form>
                </td>
                <td>${ProductsBean.name}</td>
                <td>${ProductsBean.price}</td>
                <td>
                    <form method="post" action="<c:url value='/order/removeItem'/>">
                        <input type="hidden" name="product" value="<c:out value='${ProductsBean.productId}' />" />
                        <input type="submit" class="button" value="Delete" />
                    </form>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td><strong>Total:</strong></td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>${cart.totalPriceCurrencyFormat}</td>
            <td>&nbsp;</td>
        </tr>     
        </tbody>
    </table>
</div> 
</div>
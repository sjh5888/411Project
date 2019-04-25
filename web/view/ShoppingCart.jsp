<%-- 
    Document   : ShoppingCart
    Author     : gkemp
--%>

<div id ="centerColumn">

    <h1>Shopping Cart</h1>

    <div class="row">
        <table>
  <tr>
    <th>Product: </th>
    <th>Price: </th>
    <th>Quantity: </th>
  </tr>
  <c:forEach var="c" items="${cookie}">      
  <tr>
    <td>${c.value.name}</td>
    <td>${c.value.price}</td>
    <td>${c.value.quantity}</td>
  </tr>
  </c:forEach>  
  
  
            <form action="${pageContext.servletContext.contextPath}/checkout" method="post">
                <label class="pad_top">Product Name: </label>
                <span>${data.ProductsBean.categoryId}</span><br>
                <input type="hidden" name="action" value="checkout">
                <input type="submit" value="Check Out">
            </form></a>
        </div> 


    </div> 
</div>
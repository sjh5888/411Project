<%-- 
    Document   : ShoppingCart
    Author     : gkemp
--%>

<div id ="centerColumn">
    <center>
    <h1>Shopping Cart</h1>

    <%--<div class="row">--%>
    <div class ="prodImage">

        <div id="indivProd">
            <div class ="image">
       
            <form action="${pageContext.servletContext.contextPath}/checkout" method="post">
                <center>
                <label class="pad_top">Product Name: </label>
                <%--<span>${cookie.cart.value}</span>--%>
                <span><%= request.getParameter("name") %></span><br>
                <label class="pad_top" />
                <span><img src="<%= request.getParameter("image") %>" /><br>
                <label class="pad_top" />
                <span><%= request.getParameter("price") %></span><br
                <label class="pad_top">Enter Quantity: </label>
                <input type="text" name="quantity" value="${CheckoutServlet.quantity}"><br>
                <%--<span>${data.ProductsBean.categoryId}</span><br>--%>
                
                <input type="hidden" name="action" value="checkout">
                <input type="submit" value="Check Out">
                       </center>
            </form></a>
    
    </div> 

    </center>
</div> 
</div>
</div>
          

<%-- 
    Document   : Products
    Author     : gkemp
--%>

<%

    ProductsBean[] products = (ProductsBean[]) request.getAttribute("products");

    for (int i = 0; i < products.length; i++) {

    }


%>

<div id ="centerColumn">
    <div class="row">
        <div class ="image">

            <form action="${pageContext.servletContext.contextPath}/product" method="post">
                <label class="pad_top">Product: </label>
                <span><%=products[0]%></span><br>
                <input type="hidden" name="action" value="products"/>
               
                <input type="hidden" name="products" value="<%=products[0].getId%>"/>
                <input type="hidden" name="products" value="<%=data.ProductsBean.productId[0]%>"/>
                <input type="hidden" name="products" value="<%=data.ProductsBean.productId%>"/>
                
                
                <input type="submit" value="Choose"/>
            </form>
        </div> 
        <div class ="image">
            <form action="${pageContext.servletContext.contextPath}/product" method="post">
                <label class="pad_top">Product: </label>
                <span><%=products[1]%></span><br>
                <input type="hidden" name="action" value="products"/>
                <input type="hidden" name="products" value="<%=products[1]%>"/>
                <input type="submit" value="Choose"/>
            </form>
        </div> 
        <div class ="image">
            <form action="${pageContext.servletContext.contextPath}/product" method="post">
                <label class="pad_top">Product: </label>
                <span><%=products[2]%></span><br>
                <input type="hidden" name="action" value="products"/>
                <input type="hidden" name="products" value="<%=products[2]%>"/>
                <input type="submit" value="Choose"/>
            </form>
        </div> 
        <div class ="image">
            <form action="${pageContext.servletContext.contextPath}/product" method="post">
                <label class="pad_top">Product: </label>
                <span><%=products[3]%></span><br>
                <input type="hidden" name="action" value="products"/>
                <input type="hidden" name="products" value="<%=products[3]%>"/>
                <input type="submit" value="Choose"/>
            </form>
        </div> 
        <div class ="image">
            <form action="${pageContext.servletContext.contextPath}/product" method="post">
                <label class="pad_top">Product: </label>
                <span><%=products[4]%></span><br>
                <input type="hidden" name="action" value="products"/>
                <input type="hidden" name="products" value="<%=products[4]%>"/>
                <input type="submit" value="Choose"/>
            </form>
        </div>
    </div>
</div>

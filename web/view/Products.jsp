<%-- 
    Document   : Products
    Author     : gkemp
--%>

<%

    ProductsBean[] products = (ProductsBean[]) request.getAttribute("products");


%>

<div id ="centerColumn">
    <div class="row">
        <h1>Feel free to browse our products <br/><br/></h1>
        <div class ="image">
            <form action="${pageContext.servletContext.contextPath}/product" method="post">
                <label class="pad_top">Product: </label>
                <input type="hidden" name="action" value="products"/>               
                <input type="hidden" name="ProductId" value="<%=products[0].getProductId()%>"/><br> 
                <span><%=products[0].getName()%></span><br>
                <span><%=products[0].getPrice()%></span><br>            
                <input type="submit" value="Choose"/>
            </form>
        </div> 
        <div class ="image">
            <form action="${pageContext.servletContext.contextPath}/product" method="post">
                <label class="pad_top">Product: </label>
                <span><%=products[1]%></span><br> 
                <input type="hidden" name="action" value="products"/>
                <input type="hidden" name="ProductId" value="<%=products[1].getProductId()%>"/><br> 
                <span><%=products[1].getName()%></span><br>
                <span><%=products[1].getPrice()%></span><br>   
                <input type="submit" value="Choose"/>
            </form>
        </div> 
        <div class ="image">
            <form action="${pageContext.servletContext.contextPath}/product" method="post">
                <label class="pad_top">Product: </label>
                <span><%=products[2]%></span><br>
                <input type="hidden" name="action" value="products"/>
                <input type="hidden" name="ProductId" value="<%=products[2].getProductId()%>"/><br> 
                <span><%=products[2].getName()%></span><br>
                <span><%=products[2].getPrice()%>" </span><br>
                <input type="submit" value="Choose"/>
            </form>
        </div> 
    </div>
</div>

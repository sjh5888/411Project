<%-- 
    Document   : Products
    Author     : gkemp
--%>

<%

    ProductsBean[] products = (ProductsBean[]) request.getAttribute("products");
    int x;

    for (int i = 0; i < products.length; i++) {
     //   x = products[i];
    }


%>

<div id ="centerColumn">
    <div class="row">
         <h1>Feel free to browse our products <br/><br/></h1>
        <div class ="image">

            <form action="${pageContext.servletContext.contextPath}/product" method="post">
                <label class="pad_top">Product: </label>
                <span><%=products[0]%></span><br>
                <input type="hidden" name="action" value="products"/>               
                <input type="hidden" name="products" value="<%=products[0].getProductId()%>"/><br> 
                <input type="hidden" name="products" value="<%=products[0].getName()%>" /><br>
                <input type="hidden" name="products" value="<%=products[0].getPrice()%>" /><br>            
                <input type="submit" value="Choose"/>
            </form>
        </div> 
        <div class ="image">
            <form action="${pageContext.servletContext.contextPath}/product" method="post">
                <label class="pad_top">Product: </label>
                <span><%=products[1]%></span><br>
                <input type="hidden" name="action" value="products"/>
                <input type="hidden" name="products" value="<%=products[1].getProductId()%>"/><br> 
                <input type="hidden" name="products" value="<%=products[1].getName()%>" /><br>
                <input type="hidden" name="products" value="<%=products[1].getPrice()%>" /><br>   
                <input type="submit" value="Choose"/>
            </form>
        </div> 
        <div class ="image">
            <form action="${pageContext.servletContext.contextPath}/product" method="post">
                <label class="pad_top">Product: </label>
                <span><%=products[2]%></span><br>
                <input type="hidden" name="action" value="products"/>
                <input type="hidden" name="products" value="<%=products[2].getProductId()%>"/><br> 
                <input type="hidden" name="products" value="<%=products[2].getName()%>" /><br>
                <input type="hidden" name="products" value="<%=products[2].getPrice()%>" /><br>
                <input type="submit" value="Choose"/>
            </form>
        </div> 
        <div class ="image">
            <form action="${pageContext.servletContext.contextPath}/product" method="post">
                <label class="pad_top">Product: </label>
                <span><%=products[3]%></span><br>
                <input type="hidden" name="action" value="products"/>
                <input type="hidden" name="products" value="<%=products[3].getProductId()%>"/><br> 
                <input type="hidden" name="products" value="<%=products[3].getName()%>" /><br>
                <input type="hidden" name="products" value="<%=products[3].getPrice()%>" /><br>
                <input type="submit" value="Choose"/>
            </form>
        </div> 
        <div class ="image">
            <form action="${pageContext.servletContext.contextPath}/product" method="post">
                <label class="pad_top">Product: </label>
                <span><%=products[4]%></span><br>
                <input type="hidden" name="action" value="products"/>
                <input type="hidden" name="products" value="<%=products[4].getProductId()%>"/><br> 
                <input type="hidden" name="products" value="<%=products[4].getName()%>" /><br>
                <input type="hidden" name="products" value="<%=products[4].getPrice()%>" /><br>
                <input type="submit" value="Choose"/>
            </form>
        </div>
    </div>
</div>

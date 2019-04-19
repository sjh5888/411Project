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
                <input type="hidden" name="products" value="<%=products[0].getProductId()%>"/> 
                <input type="hidden" name="products" value="<%=products[0].getName()%>" />
                <input type="hidden" name="products" value="<%=products[0].getPrice()%>" />               
                <input type="submit" value="Choose"/>
            </form>
        </div> 
        <div class ="image">
            <form action="${pageContext.servletContext.contextPath}/product" method="post">
                <label class="pad_top">Product: </label>
                <span><%=products[1]%></span><br>
                <input type="hidden" name="action" value="products"/>
                <input type="hidden" name="products" value="<%=products[1].getProductId()%>"/> 
                <input type="hidden" name="products" value="<%=products[1].getName()%>" />
                <input type="hidden" name="products" value="<%=products[1].getPrice()%>" />   
                <input type="submit" value="Choose"/>
            </form>
        </div> 
        <div class ="image">
            <form action="${pageContext.servletContext.contextPath}/product" method="post">
                <label class="pad_top">Product: </label>
                <span><%=products[2]%></span><br>
                <input type="hidden" name="action" value="products"/>
                <input type="hidden" name="products" value="<%=products[2].getProductId()%>"/> 
                <input type="hidden" name="products" value="<%=products[2].getName()%>" />
                <input type="hidden" name="products" value="<%=products[2].getPrice()%>" />   
                <input type="submit" value="Choose"/>
            </form>
        </div> 
        <div class ="image">
            <form action="${pageContext.servletContext.contextPath}/product" method="post">
                <label class="pad_top">Product: </label>
                <span><%=products[3]%></span><br>
                <input type="hidden" name="action" value="products"/>
                <input type="hidden" name="products" value="<%=products[3].getProductId()%>"/> 
                <input type="hidden" name="products" value="<%=products[3].getName()%>" />
                <input type="hidden" name="products" value="<%=products[3].getPrice()%>" />   
                <input type="submit" value="Choose"/>
            </form>
        </div> 
        <div class ="image">
            <form action="${pageContext.servletContext.contextPath}/product" method="post">
                <label class="pad_top">Product: </label>
                <span><%=products[4]%></span><br>
                <input type="hidden" name="action" value="products"/>
                <input type="hidden" name="products" value="<%=products[4].getProductId()%>"/> 
                <input type="hidden" name="products" value="<%=products[4].getName()%>" />
                <input type="hidden" name="products" value="<%=products[4].getPrice()%>" />   
                <input type="submit" value="Choose"/>
            </form>
        </div>
    </div>
</div>

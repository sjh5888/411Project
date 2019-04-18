<%-- 
    Document   : Products
    Author     : gkemp
--%>

<div id ="centerColumn">
    <div class="row">
        <div class ="image">
            
                <form action="${pageContext.servletContext.contextPath}/view/IndProducts.jsp" method="post">
                    <label class="pad_top">Product Name: </label>
                    <span>${ProductsBean.name}</span><br>
                    <label class="pad_top">ID: </label>
                    <span>${ProductsBean.productId}</span><br>
                    <label class="pad_top">Price: </label>
                    <span>${ProductsBean.price}</span><br>
                    <input type="hidden" name="action" value="select">
                    <input type="submit" value="Choose">
                </form></a>
        </div>
        <div class ="image">
            <a href="./IndProducts.jsp">
                <form action="ProductServlet" method="post">
                    <label class="pad_top">Product Name: </label>
                    <span>${ProductsBean.name} </span><br>
                    <label class="pad_top">ID: </label>
                    <span>${ProductsBean.productId}</span><br>
                    <label class="pad_top">Price: </label>
                    <span>${ProductsBean.price}</span><br>
                </form></a>
        </div>  
        <div class ="image">
            <a href="./IndProducts.jsp">
                <form action="ProductServlet" method="post">
                    <label class="pad_top">Product Name: </label>
                    <input type="hidden" name="Name" value=${ProductsBean.getName} /><br>
                    <label class="pad_top">ID: </label>
                    <input type="hidden" name="ProductId" value="${ProductsBean.getProductId}" /><br>
                    <label class="pad_top">Price: </label>
                    <input type="hidden" name="Price" value="${ProductsBean.getPrice}" /><br>
                </form></a>
        </div>  
                <div class ="image">
            <a href="./IndProducts.jsp">
                <form action="ProductServlet" method="post">
                    <label class="pad_top">Product Name: </label>
                    <input type="hidden" name="Name" value=${ProductsBean.getName} /><br>
                    <label class="pad_top">ID: </label>
                    <input type="hidden" name="ProductId" value="${ProductsBean.getProductId}" /><br>
                    <label class="pad_top">Price: </label>
                    <input type="hidden" name="Price" value="${ProductsBean.getPrice}" /><br>
                </form></a>
        </div>  
    </div>
</div>

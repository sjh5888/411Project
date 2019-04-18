<%-- 
    Document   : Category
    Author     : gkemp
--%>
<head>
    <link rel="stylesheet" type="text/css" href="styles/main.css">
</head>

<div id ="centerColumn">

    <p>Feel free to browse our categories <br/><br/></p>
    <div class="row">
        <div class ="image">

            <form action="${pageContext.servletContext.contextPath}/product" method="post">
                <label class="pad_top">Category: </label>
                <span>${data.ProductsBean.categoryId}</span><br>
                <input type="hidden" name="action" value="products">
                <input type="submit" value="Choose">
            </form></a>
        </div> 
        <div class ="image">
            <form action="${pageContext.servletContext.contextPath}/product" method="post">
                <label class="pad_top">Category: </label>
                <span>${data.ProductsBean.categoryId}</span><br>
                <input type="hidden" name="action" value="products">
                <input type="submit" value="Choose">
            </form>
        </div>  
        <div class ="image">
            <form action="${pageContext.servletContext.contextPath}/product" method="post">
                <label class="pad_top">Category: </label>
                <span>${data.ProductsBean.categoryId}</span><br>
                <input type="hidden" name="action" value="products">
                <input type="submit" value="Choose">
            </form></a>
        </div> 
        <div class ="image">
            <form action="${pageContext.servletContext.contextPath}/product" method="post">
                <label class="pad_top">Category: </label>
                <span>${data.ProductsBean.categoryId}</span><br>
                <input type="hidden" name="action" value="products">
                <input type="submit" value="Choose">
            </form></a>
        </div> 
    </div>
</div>

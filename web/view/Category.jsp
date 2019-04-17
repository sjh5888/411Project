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

            <a href="./Products.jsp">
                <img src="../sprinkles.jpg" width="250" height="100" alt="sprinkles"/>
                <span class ="categoryText" >
                <label class="pad_top">Category 1</label>
                    <span>${ProductsBean.categoryId}</span><br>
                   </a>
        </div> 
        <div class ="image">
            <a href="./Products.jsp">
                <span class ="categoryText">Category2</span>
            </a>
        </div>  
        <div class ="image">
            <a href="./Products.jsp">
                <span class ="categoryText">Category3</span>
            </a>
        </div> 
    </div>
</div>

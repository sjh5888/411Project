<%-- 
    Document   : Category
    Author     : gkemp
--%>
<head>
    <link rel="stylesheet" type="text/css" href="styles/main.css">
</head>

<!-- Category.jsp This page lists the categories and uses the productServlet -->

<%

    String[] descriptions = (String[]) request.getAttribute("descriptions");

%>

<div id ="centerColumn">

    <div class="row">
        <center>
            <h1>Feel free to browse our categories <br/><br/></h1>
            <div class ="image">
                <img src="./images2/CookiesCremeCandy.png" /><br>
                <form action="${pageContext.servletContext.contextPath}/product" method="post">
                    <label class="pad_top">Category: </label>
                    <span><%=descriptions[0]%></span><br>
                    <input type="hidden" name="action" value="products"/>
                    <input type="hidden" name="description" value="<%=descriptions[0]%>"/>
                    <input type="submit" value="Choose"/>
                </form>
            </div> 
            <div class ="image">
                <img src="./images2/MilkChocolateBar.png" /><br>
                <form action="${pageContext.servletContext.contextPath}/product" method="post">
                    <label class="pad_top">Category: </label>
                    <span><%=descriptions[1]%></span><br>
                    <input type="hidden" name="action" value="products">
                    <input type="hidden" name="description" value="<%=descriptions[1]%>"/>
                    <input type="submit" value="Choose">
                </form>
            </div>  
            <div class ="image">
                <img src="./images2/SpecialDark.png" /><br>
                <form action="${pageContext.servletContext.contextPath}/product" method="post">
                    <label class="pad_top">Category: </label>
                    <span><%=descriptions[2]%></span><br>
                    <input type="hidden" name="action" value="products">
                    <input type="hidden" name="description" value="<%=descriptions[2]%>"/>
                    <input type="submit" value="Choose">
                </form>
            </div> 
            <div class ="image">
                <img src="./images2/JollyRancherTwizzler.png" /><br>
                <form action="${pageContext.servletContext.contextPath}/product" method="post">
                    <label class="pad_top">Category: </label>
                    <span><%=descriptions[3]%></span><br>
                    <input type="hidden" name="action" value="products">
                    <input type="hidden" name="description" value="<%=descriptions[3]%>"/>
                    <input type="submit" value="Choose">
                </form>
            </div> 
        </center>
    </div>
</div>

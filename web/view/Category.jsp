<%-- 
    Document   : Category
    Author     : gkemp
--%>
<head>
    <link rel="stylesheet" type="text/css" href="styles/main.css">
</head>

<%

    String[] descriptions = (String[]) request.getAttribute("descriptions");


%>

<div id ="centerColumn">

    <p>Feel free to browse our categories <br/><br/></p>
    <div class="row">
        <div class ="image">
            <img src='<c:url value="/images2/CookiesCremeCandy.png" />'

                 <form action="${pageContext.servletContext.contextPath}/product" method="post">
                <label class="pad_top">Category: </label>
                <span><%=descriptions[0]%></span><br>
                <input type="hidden" name="action" value="products"/>
                <input type="hidden" name="description" value="<%=descriptions[0]%>"/>
                <input type="submit" value="Choose"/>
            </form>
        </div> 
        <div class ="image">
            <img src='<c:url value="/images2/CookiesCremeCandy.png" />'
            <form action="${pageContext.servletContext.contextPath}/product" method="post">
                <label class="pad_top">Category: </label>S
                <span><%=descriptions[1]%></span><br>
                <input type="hidden" name="action" value="products">
                <input type="hidden" name="description" value="<%=descriptions[1]%>"/>
                <input type="submit" value="Choose">
            </form>
        </div>  
        <div class ="image">
            <form action="${pageContext.servletContext.contextPath}/product" method="post">
                <label class="pad_top">Category: </label>
                <span><%=descriptions[2]%></span><br>
                <input type="hidden" name="action" value="products">
                <input type="hidden" name="description" value="<%=descriptions[2]%>"/>
                <input type="submit" value="Choose">
            </form>
        </div> 
        <div class ="image">
            <form action="${pageContext.servletContext.contextPath}/product" method="post">
                <label class="pad_top">Category: </label>
                <span><%=descriptions[3]%></span><br>
                <input type="hidden" name="action" value="products">
                <input type="hidden" name="description" value="<%=descriptions[3]%>"/>
                <input type="submit" value="Choose">
            </form>
        </div> 
    </div>
</div>

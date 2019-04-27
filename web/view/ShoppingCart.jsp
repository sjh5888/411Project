<%-- 
    Document   : ShoppingCart
    Author     : gkemp
--%>

<div id ="centerColumn">
    
    <h1>Shopping Cart</h1>

    <div class="row">
    <div class ="prodImage">

        <div id="indivProd">
            <div class ="image">
            
            <form action="${pageContext.servletContext.contextPath}/checkout" method="post">
                <% 
                    String name;
                    String image;
                    String price;
                    String total;

                    String test = request.getParameter("name"); 
                    if (test == null) {
                        Cookie[] cookies = request.getCookies();

                        if (cookies != null) {
                         for (Cookie cookie : cookies) {
                           if (cookie.getName().equals("cart")) {
                             String str = cookie.getValue();
                             String[] cats = str.split("|");
                             //name = cats[0];
                             //image = cats[1];
                             //price = cats[2];
                             total = cats[3]; 
                             int one = str.indexOf("|");
                             int two = str.indexOf("||");
                             int three = str.indexOf("|||");
                             name = (str.substring(0, one));
                             image = (str.substring(one + 1, two));
                             price = (str.substring(two + 2, three));
                             System.out.println(name + " " + image + " " + price);
                             request.setAttribute("name", name);
                             request.setAttribute("image", image);
                             request.setAttribute("price", price);
                        
                            }
                          }
                        }
                    }
                    else {
                        name = request.getParameter("name");
                        image = request.getParameter("image");
                        price = request.getParameter("price");
                        request.setAttribute("name", name);
                        request.setAttribute("image", image);
                        request.setAttribute("price", price);
                        
                    }
                %>
                <center>
                <label class="pad_top">Product Name: </label>
                <%--<span>${cookie.cart.value}</span>--%>
                <span><%= request.getAttribute("name") %></span><br>
                <label class="pad_top" />
                <span><img src="<%= request.getAttribute("image") %>" /><br>
                <label class="pad_top" />
                <span><%= request.getAttribute("price") %></span><br
                <label class="pad_top">Enter Quantity: </label>
                <input type="text" name="quantity" value="${CheckoutServlet.quantity}"><br>
                <%--<span>${data.ProductsBean.categoryId}</span><br>--%>
                
                <input type="hidden" name="action" value="checkout">
                <input type="submit" value="Check Out">
                       </center>
            </form>
    
    </div> 

    
</div> 
</div>
</div>
          

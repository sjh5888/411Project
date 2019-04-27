<%-- 
    Document   : ShoppingCart
    Author     : gkemp
--%>

<div id ="centerColumn">
    <center>
    <h1>Shopping Cart</h1>

    <%--<div class="row">--%>
    <div class ="prodImage">

        <div id="indivProd">
            
            
            <form action="${pageContext.servletContext.contextPath}/checkout" method="post">
                <% 
                  /*  String name;
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
                        
                    } */
                 ProductsBean[] items = (ProductsBean[]) request.getAttribute("items");
                 double total = Double.parseDouble(request.getParameter("total"));
 
      for(int i = 0; i < items.length; i++){
              out.write("\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                <label class=\"pad_top\">Product Name: </label>\n");
      out.write("                ");
      out.write("\n");
      out.write("                <span>");
      out.print( items[i].getName() );
      out.write("</span><br>\n");
      out.write("                <label class=\"pad_top\"></label>\n");
      out.write("                <span><img src=\"");
      out.print( items[i].getImageLocation());
      out.write("\"></span><br>\n");
      out.write("                <label class=\"pad_top\" ></label>\n");
      out.write("                <span>");
      out.print( items[i].getPrice());
      out.write("</span><br\n");
      out.write("                ");
      out.write("\n");
      out.write("                \n");
      out.write("                <input type=\"hidden\" name=\"action\" value=\"checkout\">\n");
      out.write("                <input type=\"submit\" value=\"Check Out\">\n");
      out.write("                       \n");
      out.write("            </form>\n");
      out.write("    \n");
      out.write("     \n");
      out.write("\n");
      out.write("    </center>\n");
      out.write("</div> \n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("          \n");
      out.write("\n");
      }
     %>
     
     <h1>$<%=total%></h1>
                
             <%--   <label class="pad_top">Product Name: </label>
                <span>${cookie.cart.value}</span>
                <span><%= items[i].getName() %></span><br>
                <label class="pad_top"></label>
                <span><img src="<%= items[i].getImageLocation()%>"></span><br>
                <label class="pad_top" ></label>
                <span><%= items[i].getPrice()%></span><br
                <%-- <label class="pad_top">Enter Quantity: </label> 
                <input type="text" name="quantity" value="${CheckoutServlet.quantity}"><br>
                
                <%--<span>${data.ProductsBean.categoryId}</span><br>
                
                <input type="hidden" name="action" value="checkout">
                <input type="submit" value="Check Out">
                       
            </form>--%>
    
     

    </center>
</div> 
</div>
</div>
          

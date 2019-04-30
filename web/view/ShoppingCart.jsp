<%-- 
    Document   : ShoppingCart
    Author     : gkemp
--%>

<div id ="centerColumn">
    <div class ="row">
        <center>
            <h1>Shopping Cart</h1><br><br>
        </center>

        <%

            ProductsBean[] items = (ProductsBean[]) request.getAttribute("items");
            
            Cookie[] cookies = request.getCookies();
            String[] total = new String[items.length];
            int x = items.length;
            if (cookies != null) {
                 for (int i = 1; i<items.length + 1;i++) {
                     total[i - 1] = cookies[x].getValue();
                     x--;
                 }
            }
            double combine;
            double combineAll = 0;
          
            for (int i = 0; i < items.length; i++) {
                combine = Double.parseDouble(items[i].getPrice().substring(1, items[i].getPrice().length())) * Integer.parseInt(total[i]);
                combineAll = combineAll + combine;
                out.write("        <div class =\"image\">\n");
                out.write("            <form action=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.servletContext.contextPath}", java.lang.String.class, (PageContext) _jspx_page_context, null));
                //out.write("/checkout\" method=\"post\">\n");
                //out.write("                \n");
                out.write("                \n");
                out.write("                <label class=\"pad_top\">Product Name: </label>\n");
                out.write("                ");
                out.write("\n");
                out.write("                <span>");
                out.print(items[i].getName());
                System.out.println("Testing to see if i is initialized: " + items[i].getName());
                out.write("</span><br>\n");
                out.write("                <label class=\"pad_top\"></label>\n");
                out.write("                <span><img src=\"");
                out.print(items[i].getImageLocation());
                out.write("\"></span><br>\n");
                out.write("                <label class=\"pad_top\" ></label>\n");
                out.write("                <span>");
                out.print(items[i].getPrice());
                out.write(" x ");
                out.print(total[i]);
                out.write("</span><br>\n"); 
                out.write("$");
                
                out.print(String.format("%.2f", combine));
                
                out.write("                          ");
                out.write("                ");
                out.write("\n");
                out.write("                \n");         
                out.write("            </form>\n");
                out.write("    </div> \n");
                out.write("    \n");
                out.write("     \n");
                out.write("\n");

            }
                out.write("                 Total: $");
                out.print(String.format("%.2f", combineAll));
                out.write("                <form action=\"checkout\" method=\"post\">\n");
                out.write("                <input type=\"hidden\" name=\"action\" value=\"checkout\">\n");
                out.write("                <input type=\"submit\" value=\"Checkout\">\n<br>");
                out.write("                </form>\n");
                out.write("                       \n");
                
                out.write("                <form action=\"product\" method=\"post\">\n");
                out.write("                    <input type=\"hidden\" name=\"action\" value=\"continue\"/>\n");
                out.write("                    <input type=\"submit\" value=\"Continue Shopping\">\n");
                out.write("                </form>");
            out.write("    </center>\n");
            out.write("    </div> \n");
            out.write("</div> \n");
            out.write("</div>\n");
            out.write("</div>\n");
            out.write("          \n");
            out.write("\n");
            //}
        %>
        
        
        <%--     <h1>$<%=total%></h1>
                     
                  <label class="pad_top">Product Name: </label>
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





    </div>
</div>


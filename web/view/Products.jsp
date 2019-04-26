<%-- 
    Document   : Products
    Author     : gkemp
--%>

<%

    ProductsBean[] products = (ProductsBean[]) request.getAttribute("products");


%>

<div id ="centerColumn">
    <div class="row">
        <center>
        <h1>Feel free to browse our products <br/><br/></h1>
        
      <%
      for(int i = 0; i < products.length; i++)
      {
      out.write("        <div class =\"image\">\n");
      out.write("            <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.servletContext.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/product\" method=\"post\">\n");
      out.write("                <label class=\"pad_top\"></label>\n");
      out.write("                <input type=\"hidden\" name=\"action\" value=\"select\"/>               \n");
      out.write("                <input type=\"hidden\" name=\"ProductId\" value=\"");
      out.print(products[i].getProductId());
      out.write("\"/><br> \n"); 
      //out.print("<span>" + products[i].getProductId() +"</span>");
      
      out.write("                <span>");
      out.print(products[i].getName());
      out.write("</span><br>\n");
      
      out.write("                <span>");
      out.write("<img src=" + products[i].getImageLocation() + " />");
      out.write("</span><br>\n");
      
      out.write("                <span>");
      out.print(products[i].getPrice());
      out.write("</span><br>            \n");
      out.write("                <input type=\"submit\" value=\"Choose\"/>\n");
      out.write("            </form>\n");
      out.write("        </div> \n");
      }
      %>
        
      <br><br> 
        </center>
    </div>
</div>

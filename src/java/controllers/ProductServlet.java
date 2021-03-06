/**
 * IST 411 2nd Group Project
 * CheckoutServlet.java
 * Purpose: To redirect to the appropriate jsp pages based
 * on if the page is to display categories, products, or an
 * individual product. Also handles sending information based
 * on user selections to send to QueryLogic in order to structure
 * a query to send to the database so returned information can be
 * displayed properly.
 *
 * @version 1.1 5/1/2019
 * @author Gerrald Kemper
 */
package controllers;

import static data.AccessDb.*;
import data.ProductsBean;
import data.QueryLogic;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author D'Clarkus Williams
 */
public class ProductServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        String url = "/index.html";
        String[] description;
        String descriptionHash = "";
        ProductsBean[] products;
        ProductsBean product;

        if (action.equals("continue")) { //continue button on index page
            url = "/view/Category.jsp";
            QueryLogic cat = new QueryLogic();
            String query = cat.query("categories"); //categories table

            try {
                description = runQuery(query, true); //true for pull

                request.setAttribute("descriptions", description);

            } catch (SQLException ex) {
                ex.getMessage();
            } // end catch

        } else if (action.equals("products")) { //selected product category
            url = "/view/Products.jsp";
            QueryLogic all = new QueryLogic();
            String descr = request.getParameter("description");

            descriptionHash = String.valueOf(Math.abs(descr.hashCode()));
            descriptionHash = "c" + descriptionHash; // this is the description ID that will be stored in the Db.

            String query = all.query(descriptionHash);
            try {
                products = arrayProductQuery(query, true); // this will return an array of product beans
                request.setAttribute("products", products);
            } catch (SQLException ex) {
                System.out.println(ex);
            } // end catch

        } else if (action.equals("select")) { //selected product
            url = "/view/IndProducts.jsp";
            String prodID = String.valueOf(request.getParameter("ProductId"));
            //System.out.println(prodID);
            QueryLogic one = new QueryLogic();

            String query = one.query("p" + prodID);
            System.out.println("test: " + query);
            try {
                product = indProductQuery(query, true);
                request.setAttribute("product", product);

            } catch (SQLException ex) {
                ex.getMessage();
            } // end catch
        } // end else if

        // forward to the view
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// getServletInfo()

}

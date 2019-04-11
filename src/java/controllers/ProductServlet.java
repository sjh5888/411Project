/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static data.AccessDb.runQuery;
import data.QueryLogic;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
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

        doPost(request, response); //change later most likely
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

        // perform action and set URL to appropriate page
        String url = "/index.html";
        String description = "";
        String descriptionHash = "";
        ProductsBean[] products; //array of java beans
        ProductsBean product;

        if (action.equals("continue")) { //continue button on index page
            url = "/Category.jsp";
            QueryLogic cat = new QueryLogic();
            String query = cat.query("categories"); //categories table

            try {
                description = runQuery(query, true); //true for pull
                descriptionHash = String.valueOf(description.hashCode());
                descriptionHash = "C" + descriptionHash; //this is the description ID that will be stored in the Db.
                //retrieve categories from Db - call access db and query logic
                
            } catch (SQLException ex) {
                ex.getMessage();
            }
        } else if (action.equals("products")) { //selected product category
            url = "/Products.jsp";
            QueryLogic all = new QueryLogic();
            String query = all.query(descriptionHash);
            products = arrayProductQuery(query, true); // this should return an array of product beans I believe.
            request.setAttribute("products", products); //products should be accessible to the view using the "products" attribute

        } else if (action.equals("select")) { //selected product
            url = "/IndProducts.jsp"; //create array of product beans 
            String prodID = String.valueOf(request.getAttribute("productID")); //will get the selected ID from the URL maybe lmao. 
            QueryLogic one = new QueryLogic();
            String query = one.query(prodID);
            try {
                product = indProductQuery(query, true); //stored in a bean.
                request.setAttribute("product", product); //java bean for individual product is stored in the request obj.

            } catch (SQLException ex) {
                ex.getMessage();
            }
        }

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
    }// </editor-fold>

}

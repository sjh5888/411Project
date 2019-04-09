/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
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
        String url = "/index.jsp";

        if (action.equals("continue")) { //continue button on index page
            url = "/categories.jsp";
            QueryLogic cat = new QueryLogic();
            String query = cat.query("categories"); //categories table
            runQuery(query, true); //true for pull
            //retrieve categories from Db - call access db and query logic
            //call query, call db, create bean, add attributes to the session obj (or request obj)
        } else if (action.equals("products")) { //selected product category
            url = "/products.jsp";
            QueryLogic all = new QueryLogic();
            String query = all.query("all"); //products table
            runQuery(query, true); //true for pull

            /*
            id = String.valueOf(description.hashCode());
            id = id.substring(0, 7);
             */
              
        } else if (action.equals("select")) { //selected product
            url = "/product.jsp"; //create array of product beans 
            //goal is to get data from the structure returned from accessDB...
            //then that shit has to be stored in a bean and passed in the session object.
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

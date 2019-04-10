/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author D'Clarkus Williams
 */
public class CheckoutServlet extends HttpServlet {

    private String cart ="";

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
        String url = "/index.html";

        if (action.equals("addToCart")) { //continue button on index page
            String itemID = request.getParameter("itemID");
            cart = cart + itemID;
            Cookie c = new Cookie("cart", cart);
            c.setMaxAge(60 * 60 * 24 * 365 * 3); // set age to 3 years
            c.setPath("/");                     // allow entire app to access it
            response.addCookie(c);
            
        } else if (action.equals("viewCart")) { 
            url = "/ShoppingCart.jsp";
        } 
        else if (action.equals("checkout")) { 
            url = "/Checkout.jsp";
            
        }
        else if (action.equals("confirm")) { 
            
            
            long cardNumber = (long) request.getAttribute("cardNumber");
            ProcessCC pcc = new ProcessCC();
            
            if (pcc.process(cardNumber)){
                url = "/thanks.jsp";
            }
            else{
                url = "/Checkout.jsp";
                boolean error = true;
                request.setAttribute("error",error); //to alert user that the card was declined
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

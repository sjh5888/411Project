/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import sockets.ClientSocket;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sockets.ClientSocket;

/**
 *
 * @author D'Clarkus Williams
 */
public class CheckoutServlet extends HttpServlet {

    private String cart = "";

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
       
        if(action == null){
            url = "/index.html";
            
        }else if (action.equals("addToCart")) {

            String itemID = request.getParameter("itemID");
           
            System.out.println(itemID);
            
            cart = cart + itemID;

            Cookie c = new Cookie("cart", cart);
            c.setMaxAge(60 * 60 * 24 * 365 * 3);
            c.setPath("/");

            response.addCookie(c);
            url = "/view/ShoppingCart.jsp";

        } else if (action.equals("viewCart")) {
            url = "/view/ShoppingCart.jsp";
        } else if (action.equals("checkout")) {
            url = "/view/Checkout.jsp";
        
        } else if (action.equals("confirm")) {
            System.out.println("help me"); //test
            ClientSocket cs = new ClientSocket("localhost", 11001);

            //String cardNumber = (String) request.getAttribute("cardNumber");
            String cardNumber = request.getParameter("cardNumber"); // 1234567890123452 is a valid test number
            System.out.println("Card" + cardNumber);
            cs.start(cardNumber);

            String result = cs.getReturn();
            System.out.println(result);

            if (result.equals("true")) {
                url = "/view/Confirmation.jsp";
                System.out.println("pass");
            } else {
                url = "/view/Checkout2.jsp";
                boolean error = true;
                request.setAttribute("error", error); //to alert user that the card was declined
                System.out.println("fail");
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

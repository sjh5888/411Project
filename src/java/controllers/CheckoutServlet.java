/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static data.AccessDb.arrayProductQuery;
import static data.AccessDb.indProductQuery;
import data.ProductsBean;
import data.QueryLogic;
import sockets.ClientSocket;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sockets.ClientSocket;

/**
 *
 * @author D'Clarkus Williams
 */
public class CheckoutServlet extends HttpServlet {

    private String cart = "";
    private String price;
    private String total;
    private HttpSession session;
    private String myTotal;
    private ProductsBean[] cartItems;
    private Cookie[] cookies;

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

        if (action == null) {
            url = "/index.html";

        } else if (action.equals("addToCart")) { //need to not redirect but instead add a message or something

            String itemID = request.getParameter("itemID");
            String quantity = request.getParameter("quantity");
            //System.out.println("itemID for selected product: " + itemID);

            Cookie c = new Cookie(itemID, quantity);
            c.setMaxAge(-1);
            c.setPath("/");

            response.addCookie(c);

            //url = "/view/IndProducts.jsp";
             
            url = "/view/ContinueShopping.jsp";
            
        } else if (action.equals("viewCart")) {

            url = "/view/ShoppingCart.jsp";

            Cookie clientCookies[] = request.getCookies();
            //System.out.println("number of cookies stored on drive: " + clientCookies.length);
            final int COOKIE_AMOUNT = clientCookies.length;
            QueryLogic item = new QueryLogic();

            String[] idArray = new String[COOKIE_AMOUNT];
            String[] total = new String[COOKIE_AMOUNT];
            String query = "";

            for (int i = 1; i < COOKIE_AMOUNT; i++) { //starting at one to bypass the session cookie
                String itemID = clientCookies[i].getName();
                String totalValue = clientCookies[i].getValue();
                idArray[i] = itemID;
                total[i] = totalValue;
            }
            request.setAttribute("total", total);

            query = item.checkoutQuery(idArray);
            //System.out.println("Query for cookie IDs: " + query);

            try {

                cartItems = arrayProductQuery(query, true);
                request.setAttribute("items", cartItems);
                //  System.out.println("Testing the db result: " + cartItems[i].getName());

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        } else if (action.equals("checkout")) {

            url = "/view/Checkout.jsp";
        } else if (action.equals("continueshopping")) {
            url = "/view/Category.jsp";

        } else if (action.equals("confirm")) {
            cookies = request.getCookies();
            //System.out.println("help me"); //test
            ClientSocket cs = new ClientSocket("localhost", 11001);

            String cardNumber = request.getParameter("cardNumber"); // 1234567890123452 is a valid test number
            System.out.println("Card" + cardNumber);
            cs.start(cardNumber);

            String result = cs.getReturn();
            System.out.println(result);

            if (result.equals("true")) {
                url = "/view/Confirmation.jsp";

                //delete cart cookies when confirmed:
                for (int i = 1; i < cookies.length; i++) {
                    cookies[i].setMaxAge(0);
                    cookies[i].setPath("/");
                    response.addCookie(cookies[i]);
                    System.out.println(cookies[i].getMaxAge());

                }

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
    }// getServletInfo()

}

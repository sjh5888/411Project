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
            //String image = request.getParameter("image");
            // price = request.getParameter("price");
            String quantity = request.getParameter("quantity");
            //String total = String.valueOf(Double.parseDouble(price1) * Integer.parseInt(quantity));
            System.out.println("itemID for selected product: " + itemID);

            // Cookie c = new Cookie("cart", cart);
            Cookie c = new Cookie(itemID, quantity);
            c.setMaxAge(60 * 60 * 24 * 365 * 3);
            c.setPath("/");

            response.addCookie(c);

            url = "/view/IndProducts.jsp";
            // action = "viewCart";

            //url = "/view/IndProducts.jsp"; 
            url = "/view/ContinueShopping.jsp";
           // action = "viewCart";

            //request.setAttribute("action", action);

        } else if (action.equals("viewCart")) {

            url = "/view/ShoppingCart.jsp";

            /* Cookie[] cookies = request.getCookies();
            String cookieName = "productCookie";
            String cookieValue = "";
            for (Cookie cookie : cookies){
                if (cookieName.equals(cookie.getName())){
                    cookieValue = cookie.getValue();
                    System.out.println("ID is equal to: " + cookieValue);
                }
            }
            request.setAttribute("cookie",cookieValue); */
            Cookie clientCookies[] = request.getCookies();
            System.out.println("number of cookies stored on drive: " + clientCookies.length);
            final int COOKIE_AMOUNT = clientCookies.length;
            int i = 1;
            QueryLogic item = new QueryLogic();
            ProductsBean[] cartItems = new ProductsBean[clientCookies.length];
            double total = 0;
            String query = "";
            HttpSession session = request.getSession();

            // for (int i = 1; i < clientCookies.length; i++) { //starting at one to bypass the session cookie
            while (i < COOKIE_AMOUNT) {
                //cartItems = new ProductsBean[clientCookies.length];
                // System.out.println(cartItems.length);

                String itemID = clientCookies[i].getName();
                int quantity = Integer.parseInt(clientCookies[i].getValue());
                //System.out.println(quantity);
                query = item.query("p" + itemID);
                System.out.println("Query for product stored in cookie: " + query);

                try {
                    cartItems[i] = indProductQuery(query, true);

                    System.out.println("Testing the db result: " + cartItems[i].getName());
                    

                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }

                
                total = total + Double.parseDouble(cartItems[i].getPrice().replace("$", "").trim()) * quantity;
                System.out.println("Testing the cartItems array: " + cartItems[i].getName());
            
            
            System.out.println("Testing the total: " + total);
           
           session = request.getSession();
           session.setAttribute("total",total);
           session.setAttribute("items",cartItems); 


                total = total + Double.parseDouble(cartItems[i].getPrice().replace("$", "").trim()) * quantity;
                System.out.println("Testing the 1st element in cartItems array (inside): " + cartItems[1].getName());
                i++;
                System.out.println("iteration: " + i);

                System.out.println("Testing the total: " + total);

                session.setAttribute("total", total);

            }
             System.out.println("Testing the 1st element in cartItems array (outside): " + cartItems[1].getName());
             session.setAttribute("items", cartItems);
        } else if (action.equals("checkout")) {
            //String quantity = request.getParameter("quantity");
            //String price1 = price.substring(1, price.length());
            //total = String.valueOf(String.format("%.2f", Double.parseDouble(price1) * Integer.parseInt(quantity)));
            //System.out.println("total: " + total);
            //request.setAttribute("data", total);
            request.setAttribute("data", myTotal.format("%.2f", session.getAttribute("total")));

            url = "/view/Checkout.jsp";
        } else if (action.equals("continueshopping")) {
            url = "/view/Category.jsp";

        } else if (action.equals("confirm")) {
            //System.out.println("help me"); //test
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

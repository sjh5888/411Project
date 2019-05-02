/**
 * IST 411 2nd Group Project
 * CheckoutServlet.java
 * Purpose: To redirect to the appropriate jsp pages and
 * display the appropirate information as well as handle
 * cookie creation, cookie deletion, and sessions.
 *
 * @version 1.1 5/1/2019
 * @authors Steve Hansen, Gerrald Kemper, Kevin Hansen
 */
package controllers;

import static data.AccessDb.arrayProductQuery;
import static data.AccessDb.indProductQuery;
import data.ProductsBean;
import data.QueryLogic;
import java.io.IOException;
import java.sql.SQLException;
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

        } else if (action.equals("addToCart")) {

            url = "/view/ContinueShopping.jsp";

            String itemID = request.getParameter("itemID");
            String quantity = request.getParameter("quantity");

            int quant = 0;

            try {
                quant = Integer.parseInt(quantity);
                if (quant >= 100) {
                    throw new NumberFormatException();               
                }
                Cookie c = new Cookie(itemID, quantity);
            c.setMaxAge(-1);
            c.setPath("/");

            response.addCookie(c);
            } catch (NumberFormatException e) {
                url = "/view/IndProducts.jsp";
                String prodID = String.valueOf(request.getParameter("itemID"));
                //System.out.println(prodID);
                QueryLogic one = new QueryLogic();

                String query = one.query("p" + prodID);

                ProductsBean product;
                try {
                    product = indProductQuery(query, true);
                    request.setAttribute("product", product);
                    String message = "Please only enter an integer value less than 100.";
                    request.setAttribute("inputError", message);

                } catch (SQLException ex) {
                    ex.getMessage();
                } // end catch

            }

            

        } else if (action.equals("viewCart")) {

            url = "/view/ShoppingCart.jsp";

            Cookie clientCookies[] = request.getCookies();
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

            try {

                cartItems = arrayProductQuery(query, true);
                request.setAttribute("items", cartItems);

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        } else if (action.equals("checkout")) {

            url = "/view/Checkout.jsp";
        } else if (action.equals("continueshopping")) {
            url = "/view/Category.jsp";

        } else if (action.equals("confirm")) {
            cookies = request.getCookies();
            ClientSocket cs = new ClientSocket("localhost", 11001);

            String cardNumber = request.getParameter("cardNumber"); // 1234567890123452 is a valid test number

            cs.start(cardNumber);

            String result = cs.getReturn();

            if (result.equals("true")) {
                url = "/view/Confirmation.jsp";

                //delete cart cookies when confirmed:
                for (int i = 1; i < cookies.length; i++) {
                    cookies[i].setMaxAge(0);
                    cookies[i].setPath("/");
                    response.addCookie(cookies[i]);
                    System.out.println(cookies[i].getMaxAge());

                }

            } else {
                url = "/view/Checkout2.jsp";
                boolean error = true;
                
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

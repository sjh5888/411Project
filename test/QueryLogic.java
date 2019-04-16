/**
 * IST 411 2nd Group Project
 * QueryLogic.java
 * Purpose: To take a string and change it into an 
 * SQL query
 * 
 * @version 1.1 4/15/2019
 * @author Kevin Hansen
 */

public class QueryLogic
{
    private String query;
    private String startQuery;
    
    public QueryLogic() {
        startQuery = "SELECT * FROM PRODUCTS";
    } // QueryLogic()
    
    /**
    *  Method to take a string and based on the value of the string
    *  form a query from it to access data from the database
    *  @param query -- string that determines the query to be formed
    */
    public String query(String query) {
        if (query.equals("categories")) {
            query = "SELECT * FROM CATEGORIES";
        }
        else if (!query.equals("categories") && query.substring(0, 1).equals("c")) {
            query = "SELECT * FORM PRODUCTS WHERE CATEGORYID=" + query.substring(1, query.length());
                }
        else if (query.equals("products")) {
            query = "SELECT * FROM PRODUCTS";
        }
        else if (!query.equals("products") && query.substring(0, 1).equals("p")) {
            query = "WHERE PRODUCTID='" + query.substring(1, query.length());
        }
        return query;
    } // end query
} // end QueryLogic

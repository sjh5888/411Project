/**
 * IST 411 2nd Group Project
 * QueryLogic.java
 * Purpose: To take a string and change it into an 
 * SQL query
 * 
 * @version 1.1 4/15/2019
 * @author Kevin Hansen
 */

package data;

/**
 * Class to handle structuring the database queries
 */
public class QueryLogic
{
    private String query;
    private String startQuery;
    
    public QueryLogic() {
        startQuery = "SELECT * FROM PRODUCTS";
    }
    
    /**
    *  Method to take a string and based on the value of the string
    *  form a query from it to access data from the database
    *  @param query -- string that determines the query to be formed
    *  @return -- returns the structured query string
    */
    public String query(String query) {
        if (query.equals("categories")) {
            query = "SELECT description FROM categories";
        }
        else if (!query.equals("categories") && query.substring(0, 1).equals("c")) {
            query = "SELECT * FroM PRODUCTS WHERE CATEGORYID=" + query.substring(1, query.length());
                }
        else if (query.substring(0, 1).equals("p")) {
            query = "SELECT * FroM PRODUCTS WHERE PRODUCTID=" + query.substring(1, query.length());
        }
        return query;
    } // end query
    
    /**
     * Method to return the information retrieved from the
     * database.
     * 
     * @param idList -- an array of product id's
     * @return -- returns the string result of the database query
     */
    public String checkoutQuery(String[] idList){        
        String query = "select * from products where ";
        String pid = "productid=";
        
        for(int i = 1; i < idList.length;i++){
            query = query + pid + idList[i] + " or ";
        }
        query = query.substring(0,query.lastIndexOf("or"));
        
        return query;
    } // end checkoutQuery
} // end QueryLogic

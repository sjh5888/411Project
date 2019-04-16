package data;


//package data;

public class QueryLogic
{
    private String query;
    private String startQuery;
    
    public QueryLogic() {
        startQuery = "SELECT * FROM PRODUCTS";
    }
    
    public String query(String query) {
        if (query.equals("categories")) {
            query = "SELECT CATEGORYID FROM PRODUCTS";
        }
        else if (!query.equals("categores") && query.substring(0, 1).equals("c")) {
            query = "SELECT * FORM PRODUCTS WHERE CATEGORYID=" + query.substring(1, query.length());
                }
        else if (query.substring(0, 1).equals("p")) {
            query = "WHERE PRODUCTID='" + query.substring(1, query.length());
        }
        return query;
    }
}

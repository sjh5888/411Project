package data;

public class QueryLogic
{
    private String query;
    private String startQuery;
    
    public QueryLogic() {
        this.startQuery = "SELECT * FROM PRODUCTS";
    }
    
    public String query(String query) {
        if (query.equals("all")) {
            query = this.startQuery;
        }
        else {
            query = this.startQuery + " WHERE ID='" + query + "'";
        }
        return query;
    }
}

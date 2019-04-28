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
            query = "SELECT description FROM categories";
        }
        else if (!query.equals("categories") && query.substring(0, 1).equals("c")) {
            query = "SELECT * FroM PRODUCTS WHERE CATEGORYID=" + query.substring(1, query.length());
                }
        else if (query.substring(0, 1).equals("p")) {
            query = "SELECT * FroM PRODUCTS WHERE PRODUCTID=" + query.substring(1, query.length());
        }
        return query;
    }
    
    public String checkoutQuery(String[] idList){
       //select * from products where productid=943770612 or productid=67058021 <- this works
        
        String query = "select * from products where ";
        String pid = "productid=";
        
        for(int i = 1; i < idList.length;i++){
            query = query + pid + idList[i] + " or ";
        }
        //int length = query.l
        query = query.substring(0,query.lastIndexOf("or"));
        
        return query;
    }
}

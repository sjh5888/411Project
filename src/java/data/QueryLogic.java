package data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Laptop
 */
public class QueryLogic {
    private String query;
    private String startQuery = "SELECT * FROM PRODUCTS"; //select all from products would only happen with a where clause since they are pulled from the Db based on category.
                                                            // I think that this should be select * from categories. Could be wrong tho idk. Pineapple. 
    
    public String query(String query) {
        if (query.equals("all")) {
            query = startQuery;
        }
        else {
            query = startQuery + " WHERE ID='" + query + "'";
        }
        return query;
    }
}

/*
Keyword List

"categories" : select * from categories

"all"        : select * from products

*/

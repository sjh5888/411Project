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
    private String startQuery = "SELECT * FROM PRODUCTS";
    
    public String query(String query) {
        if (query.equals("all")) {
            query = startQuery;
        }
        else {
            query = startQuery + " WHERE ID='" + query + "';";
        }
        return query;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;
        
import java.sql.SQLException;        
/**
 *
 * @author gkemp
 */
public class AccessDbTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
       
        ProductsBean[] x = AccessDb.arrayProductQuery("select * from products where productid=943770612 or productid=67058021", true);
       for(int i = 0; i < x.length; i ++){
        System.out.println(x[i].getName());
    }
    }
    
}


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
       
        String x = AccessDb.runQuery("select * from products", true);
        System.out.println(x);
    }
    
}

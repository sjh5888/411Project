/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */

/**
 *
 * @author Kevin
 */
import java.util.*;
import java.io.*;
import java.sql.*;

/* Class ExecuteEample is loged into a database
* based on credentials stored in the file db.properties
* and writes values into the table SALESHISTORY4
*/
public class DatabaseSetup  
{
    public static void main (String args[]) throws SQLException 
    {
        String className=null;
        String url=null;
        String user = null;
        String password = null;
        
        try
        {
            ResourceBundle resources;
            InputStream in = null;
            ResourceBundle newResources;

            in = ClassLoader.getSystemResourceAsStream("db.properties");

            resources = new PropertyResourceBundle(in);

            in.close();

            className = resources.getString("jdbc.driver");
            url = resources.getString("jdbc.url");
            System.out.println(className);
            user = resources.getString("jdbc.user");
            password = resources.getString("jdbc.password");
            
        } // end try
        
        catch (Exception exp)
        {
            System.out.println("Couldn't load resources." + exp);
            System.exit(-1);
        } // end catch
        
        try
        {
            Class.forName(className);
        } // end try
        
        catch (Exception e) 
        {
            System.out.println("Failed to load  driver.");
            return;
        } // end catch
        
        try
        {
            Connection con = DriverManager.getConnection(url,user,password);   
              
            Statement stmt = con.createStatement();
            
            String tmpString;
            
            tmpString = ("CREATE TABLE Categories" + 
                         "(CategoryID int, " +
                         "Description varchar(500), " +
                         "primary key (CategoryID))"); 
            
            stmt.execute(tmpString);
            
            System.out.println("Created Categories Table");
            
            tmpString = ("CREATE TABLE Products" + 
                         "(ProductID int, " +
                         "Name varchar(255), " +
                         "CategoryID int, " +
                         "Price float, " + 
                         "Description varchar(2000), " +
                         "Inventory int, " +
                         "ShippingLocation int, " +
                         "Weight float, " +
                         "Size varchar(255), " +
                         "ImageLocation varchar(255), " +
                         "primary key (ProductID), " + 
                         "foreign key (CategoryID)" + 
                         "references Categories(CategoryID))"); 
            
                        stmt.execute(tmpString);

                        System.out.println("Created Products Table");

            
            
            int[] catid = {Math.abs("White Chocolate".hashCode()), Math.abs("Milk Chocolate".hashCode()), Math.abs("Dark Chocolate".hashCode()), Math.abs("Other".hashCode())};
            String[] description = {"White Chocolate", "Milk Chocolate", "Dark Chocolate", "Other"};
            for (int i=0;i<catid.length;i++) {
                tmpString = ("INSERT INTO  CATEGORIES (CATEGORYID, DESCRIPTION)" +
                         "VALUES (" + catid[i] + ", '" + description[i] + "')"); 
                stmt.execute(tmpString);
            }
            
            
            int[] prodid = {Math.abs("HERSHEYS Milk Chocolate Bar".hashCode()), Math.abs("SYMPHONY Milk Chocolate Giant Bar".hashCode()), Math.abs("HERSHEYS KISSES Milk Chocolates Party Bag".hashCode()), Math.abs("HERSHEYS Caramels in Dark Chocolate Stand Up Bag".hashCode()), Math.abs("HERSHEYS SPECIAL DARK Mildly Sweet Chocolate Bars".hashCode()), Math.abs("HERSHEYS SPECIAL DARK Mildly Sweet Dark Chocolate Baking Chips".hashCode()), Math.abs("HERSHEYS Cookies n Creme Bars".hashCode()), Math.abs("HERSHEYS Premier White Chips".hashCode()), Math.abs("JOLLY RANCHER and TWIZZLER Candy Assortment".hashCode()), Math.abs("HERSHEYS KISSES Cookies n Creme Candy".hashCode())};
            String[] name = {"HERSHEYS Milk Chocolate Bar", "SYMPHONY Milk Chocolate Giant Bar", "HERSHEYS KISSES Milk Chocolates Party Bag", "HERSHEYS Caramels in Dark Chocolate Stand Up Bag", "HERSHEYS SPECIAL DARK Mildly Sweet Chocolate Bars", "HERSHEYS SPECIAL DARK Mildly Sweet Dark Chocolate Baking Chips", "HERSHEYS Cookies n Creme Bars", "HERSHEYS Premier White Chips", "JOLLY RANCHER and TWIZZLER Candy Assortment", "HERSHEYS KISSES Cookies n Creme Candy"};
            int[] catid1 = {Math.abs("Milk Chocolate".hashCode()), Math.abs("Milk Chocolate".hashCode()), Math.abs("Milk Chocolate".hashCode()), Math.abs("Dark Chocolate".hashCode()), Math.abs("Dark Chocolate".hashCode()), Math.abs("Dark Chocolate".hashCode()), Math.abs("White Chocolate".hashCode()), Math.abs("White Chocolate".hashCode()), Math.abs("Other".hashCode()), Math.abs("Other".hashCode())};
            double[] price = {1.00, 1.30, 2.10, 1.10, 2.00, 1.75, 2.10, 2.50, 1.70, 2.00};
            String[] description1 = {"Made with farm fresh milk, this HERSHEYS Chocolate Bar makes life delicious. Unwrap a bar, break off a piece, savor and repeat.", "This giant version of HERSHEYS SYMPHONY Candy Bar is perfect for sharing. Its creamy milk chocolate contains the perfect harmony of flavors.", "Get the perfect milk chocolate candy for sharing and savoring in a bag fit for a party!", "HERSHEYS Caramels in Dark Chocolate bring together HERSHEYS dark chocolate and a rich center of smooth, soft caramel in just the right amounts.", "This six pack of HERSHEYS SPECIAL DARK Mildly Sweet Chocolate Bars contains plenty of full-sized bars to savor and share.", "These mildly sweet morsels of HERSHEYS SPECIAL DARK Chocolate are great in everything from breakfast muffins to dessert.", "If you love white chocolate or cookies and cream ice cream, then you will appreciate the delicious combination of crunchy chocolate cookie bits and smooth white creme.", "These baking chips are a sweet way to add unique color and white creme flavor to frostings, cookies, brownies and bars.", "This bag is full of assorted flavors of JOLLY RANCHER Chews, Lollipops and Hard Candy mixed in with TWIZZLERS PULL N PEEL Cherry Candy, TWIZZLERS Twists, and TWIZZLERS Rainbow Twist Candy.", "HERSHEYS KISSES Cookies n Creme Candy blends smooth white creme with crunchy chocolate cookie bits."};
            int[] inventory = {20, 27, 10, 5, 21, 34, 15, 28, 40, 45};
            int[] shippingLocation = {17404, 17350, 17340, 17331, 21157, 21158, 17402, 54879, 23456, 90210};
            double[] weight = {1.55, 6.8, 40.0, 7.2, 7.2, 12.0, 1.55, 12.0, 68.8, 10.5};
            String[] size = {"small", "small", "medium", "medium", "large", "meduim", "small", "meduim", "large", "medium"};
            String[] imageLocation = {"images2/MilkChocolateBar.png", "images2/SymphoneMilkChocolate.png", "images2/MilkChocolateKisses.png", "images2/CaramelsDark.png", "images2/SpecialDark.png", "images2/DarkChocolateChips.png", "images2/CookiesNcreame.png", "images2/WhiteChips.png", "images2/JollyRancherTwizzler.png", "images2/CookiesCremeCandy.png"};
            
            for (int i=0;i<name.length;i++) {
                tmpString = ("INSERT INTO  PRODUCTS (PRODUCTID, NAME, CATEGORYID, PRICE, DESCRIPTION, INVENTORY, SHIPPINGLOCATION, WEIGHT, SIZE, IMAGELOCATION)" +
                         "VALUES (" + prodid[i] + ", '" + name[i] + "', " + catid1[i] + ", " + price[i] + ", '" + description1[i] + "', " + inventory[i] + ", " + shippingLocation[i] + ", " + weight[i] + ", '" + size[i] + "', '" + imageLocation[i] + "')"); 
                                
                stmt.execute(tmpString);
                        }; 
            stmt.close();
        
            con.close();
         
        } // end try
        
        catch (Exception e) 
        {
            System.out.println(e);
        } // end catch 
    } // end main
} // end ExecuteExample


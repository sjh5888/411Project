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
                         "Description varchar(500), " +
                         "Inventory int, " +
                         "ShippingLocation varchar(255), " +
                         "Weight float, " +
                         "Size varchar(255), " +
                         "ImageLocation varchar(255), " +
                         "primary key (ProductID), " + 
                         "foreign key (CategoryID)" + 
                         "references Categories(CategoryID))"); 
            
                        stmt.execute(tmpString);

                        System.out.println("Created Products Table");

            
            
            int[] catid = {Math.abs("white Chocolate".hashCode()), Math.abs("Milk Chocolate".hashCode()), Math.abs("Dark Chocolate".hashCode()), Math.abs("Other".hashCode())};
            String[] description = {"White Chocolate", "Milk Chocolate", "Dark Chocolate", "Other"};
            for (int i=0;i<catid.length;i++) {
                tmpString = ("INSERT INTO  CATEGORIES (CATEGORYID, DESCRIPTION)" +
                         "VALUES (" + catid[i] + ", '" + description[i] + "')"); 
                stmt.execute(tmpString);
            }
            
            /*
            int[] prodid = {Math.abs("HERSHEY'S Milk Chocolate Bar".hashCode()), Math.abs("SYMPHONY Milk Chocolate Giant Bar".hashCode()), Math.abs("HERSHEY'S KISSES Milk Chocolates Party Bag".hashCode()), Math.abs("HERSHEY'S Caramels in Dark Chocolate Stand Up Bag".hashCode()), Math.abs("HERSHEY'S SPECIAL DARK Mildly Sweet Chocolate Bars".hashCode()), Math.abs("HERSHEY'S SPECIAL DARK Mildly Sweet Dark Chocolate Baking Chips".hashCode()), Math.abs("HERSHEY'S Cookies 'n' Creme Bars".hashCode()), Math.abs("HERSHEY'S Premier White Chips".hashCode()), Math.abs("JOLLY RANCHER and TWIZZLER Candy Assortment".hashCode()), Math.abs("HERSHEY’S KISSES Cookies ‘n’ Creme Candy".hashCode())};
            String[] name = {"HERSHEY'S Milk Chocolate Bar", "SYMPHONY Milk Chocolate Giant Bar", "HERSHEY'S KISSES Milk Chocolates Party Bag", "HERSHEY'S Caramels in Dark Chocolate Stand Up Bag", "HERSHEY'S SPECIAL DARK Mildly Sweet Chocolate Bars", "HERSHEY'S SPECIAL DARK Mildly Sweet Dark Chocolate Baking Chips", "HERSHEY'S Cookies 'n' Creme Bars", "HERSHEY'S Premier White Chips", "JOLLY RANCHER and TWIZZLER Candy Assortment", "HERSHEY’S KISSES Cookies ‘n’ Creme Candy"};
            double[] price = {};
            String[] description = {"There’s happy, and then there’s HERSHEY’S Happy. Made with farm fresh milk, this HERSHEY’S Chocolate Bar makes life delicious. Unwrap a bar, break off a piece, savor and repeat.", "This giant version of HERSHEY’S SYMPHONY Candy Bar is perfect for sharing. Its creamy milk chocolate contains the perfect harmony of flavors. These chocolate bars will be music to your taste buds.", "Get the perfect milk chocolate candy for sharing and savoring in a bag fit for a party! Pour a candy dish full of HERSHEY'S KISSES Milk Chocolates at your next get-together. They’re sure to be a hit.", "HERSHEY’S Caramels in Dark Chocolate bring together HERSHEY’S dark chocolate and a rich center of smooth, soft caramel in just the right amounts. They’re an experience worth savoring.", "Indulge in something especially dark, mildly sweet and totally delicious. This six pack of HERSHEY'S SPECIAL DARK Mildly Sweet Chocolate Bars contains plenty of full-sized bars to savor and share.", "When only a dark, decadent chocolate will do, reach for these baking chips! These mildly sweet morsels of HERSHEY’S SPECIAL DARK Chocolate are great in everything from breakfast muffins to dessert. Add them to your favorite HERSHEY’S Kitchens recipes, or mix them into your own family recipes.", "If you love white chocolate (or cookies and cream ice cream), then you’ll appreciate the delicious combination of crunchy chocolate cookie bits and smooth white creme. HERSHEY'S Cookies 'n' Creme Candy Bars pack this classic flavor combo into each delicious bite.", "Bring the taste of rich, white creme to your next baking project. These baking chips are a sweet way to add unique color and white creme flavor to frostings, cookies, brownies and bars. Try the delicious recipes on the back of each bag, or use your imagination to create your own white-chocolate inspired desserts.", "This bag is full of assorted flavors of JOLLY RANCHER Chews, Lollipops and Hard Candy mixed in with TWIZZLER’S PULL ‘N’ PEEL Cherry Candy, TWIZZLER’S Twists, and TWIZZLERS Rainbow Twist Candy. That means there are plenty of ways to feed your sweet tooth. It’s the most fun you can have in one bag of candy.", "HERSHEY’S KISSES Cookies ‘n’ Creme Candy blends smooth white creme with crunchy chocolate cookie bits. They’re a sweet twist on classic HERSHEY’S KISSES candies, and their blue foils make them the perfect treat for birthdays and baby showers."};
            int[] inventory = {20, 27, 10, 5, 21, 34, 15, 28, 40, 45};
            String[] shippingLocation = {};
            double[] weight = {1.55, 6.8, 40.0, 7.2, 7.2, 12.0, 1.55, 12.0, 68.8, 10.5};
            String[] size = {"small", "small", "medium", "medium", "large", "meduim", "small", "meduim", "large", "medium"};
            String[] imageLocation = {"images/MilkChocolateBar.png", "images/SymphoneMilkChocolate.png", "images/MilkChocolateKisses.png", "images/CaramelsDark.png", "images/SpecialDark.png", "images/DarkChocolateChips.png", "images/CookiesNcreame.png", "images/WhiteChips.png", "images/JollyRancherTwizzler.png", "images/CookiesCremeCandy.png"};
            
            for (int i=0;i<name.length;i++) {
                tmpString = ("INSERT INTO  PRODUCTS (PRODUCTID, NAME, CATEGORYID, PRICE, DESCRIPTION, INVENTORY, SHIPPINGLOCATION, WEIGHT, SIZE, IMAGELOCATION)" +
                         "VALUES (" + prodid[i] + ", '" + name[i] + "', '" + price[i] + "', " + description[i] + ", '" + inventory[i] + ", '" + shippingLocation[i] + ", '" + weight[i] + ", '" + size[i] + ", '" + imageLocation + "')"); 
                stmt.execute(tmpString);
                        }; */
            stmt.close();
        
            con.close();
         
        } // end try
        
        catch (Exception e) 
        {
            System.out.println(e);
        } // end catch 
    } // end main
} // end ExecuteExample


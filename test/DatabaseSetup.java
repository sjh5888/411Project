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
            String[] prodid = {};
            String[] name = {""};
            double[] price = {};
            String[] description = {""};
            int[] inventory = {};
            String[] shippingLocation = {};
            int[] weight = {};
            String[] size = {};
            String[] imageLocation = {};
            
            for (int i=0;i<brand.length;i++) {
                tmpString = ("INSERT INTO  PRODUCTS (PRODUCTID, NAME, CATEGORYID, PRICE, DESCRIPTION, INVENTORY, SHIPPINGLOCATION, WEIGHT, SIZE, IMAGELOCATION)" +
                         "VALUES (" + (1111+i) + ", '" + brand[i] + "', '" + prod[i] + "', " + price[i] + ", '" + chip[i] + "')"); 
                stmt.execute(tmpString);
                        }; 
            stmt.close();
        
            con.close();
        } // end try
        
        catch (Exception e) 
        {
            System.out.println(e);
        } // end catch */
    } // end main
} // end ExecuteExample


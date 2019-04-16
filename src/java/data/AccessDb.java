/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import controllers.ProductsBean;
import java.sql.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author gkemp
 */
public class AccessDb {

    static String className = null;
    static String url = null;
    static String user = null;
    static String password = null;
    static String resultStr = "";

    public static String runQuery(String queryString, boolean type) throws SQLException {

        try {
            ResourceBundle resources;
            InputStream in = null;

            in = ClassLoader.getSystemResourceAsStream("db.properties");

            resources = new PropertyResourceBundle(in);

            in.close();

            className = resources.getString("jdbc.driver");
            url = resources.getString("jdbc.url");
            //System.out.println(url);
            user = resources.getString("jdbc.user");
            password = resources.getString("jdbc.password");
        } catch (Exception exp) {
            System.out.println("Couldn't load resources." + exp);
            System.exit(-1);
        }

        try {
            Class.forName(className);
        } catch (Exception e) {
            System.out.println("Failed to load  driver.");

        }

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(queryString);

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            /* for (int x = 1; x <= columnCount; x++) {
                //String columnName = rsmd.getColumnName(x);

            }*/
            while (rs.next()) {
                for (int x = 1; x <= columnCount; x++) {
                    resultStr = resultStr + rs.getString(x) + "\t";

                }

            }
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return resultStr;
    }
    
    /**
     * 
     * @param queryString
     * @param type
     * @return
     * @throws SQLException 
     */
    public static ProductsBean indProductQuery(String queryString, boolean type) throws SQLException {

        try {
            ResourceBundle resources;
            InputStream in = null;

            in = ClassLoader.getSystemResourceAsStream("db.properties");

            resources = new PropertyResourceBundle(in);

            in.close();

            className = resources.getString("jdbc.driver");
            url = resources.getString("jdbc.url");
            //System.out.println(url);
            user = resources.getString("jdbc.user");
            password = resources.getString("jdbc.password");
        } catch (Exception exp) {
            System.out.println("Couldn't load resources." + exp);
            System.exit(-1);
        }

        try {
            Class.forName(className);
        } catch (Exception e) {
            System.out.println("Failed to load  driver.");

        }

      
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(queryString);

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            for (int x = 1; x <= columnCount; x++) {
                String columnName = rsmd.getColumnName(x);

            
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    ProductsBean product = new ProductsBean();
                    if (columnName.equals("PRODUCTID")){
                        product.setProductId(rs.getString());
                    }
                    else if (columnName.equals("NAME")){
                        product.setName(rs.getString());
                    }
                    else if (columnName.equals("CATEGORYID")){
                        product.setCategoryId(rs.getString());
                    }
                    else if (columnName.equals("PRICE")){
                        product.setPrice(rs.getString());
                    }
                    else if (columnName.equals("DESCRIPTION")){
                        product.setDescription(rs.getString());
                    }
                    else if (columnName.equals("INVENTORY")){
                        product.setInventory(rs.getString());
                    }
                    else if (columnName.equals("SHIPPINGLOCATION")){
                        product.setShippingLocation(rs.getString());
                    }
                    else if (columnName.equals("WEIGHT")){
                        product.setWeight(rs.getString());
                    }
                    else if (columnName.equals("SIZE")){
                        product.setSize(rs.getString());
                    }
                    else if (columnName.equals("IMAGELOCATION")){
                        product.setImageLocation(rs.getString());
                    }
                }
                }
            
                    return product;
                
            }
            
                
    /**
     * Return array of ProductBeans
     * @param queryString
     * @param type
     * @return
     * @throws SQLException 
     */
    public static ProductsBean arrayProductQuery(String queryString, boolean type) throws SQLException {
        
         try {
            ResourceBundle resources;
            InputStream in = null;

            in = ClassLoader.getSystemResourceAsStream("db.properties");

            resources = new PropertyResourceBundle(in);

            in.close();

            className = resources.getString("jdbc.driver");
            url = resources.getString("jdbc.url");
            //System.out.println(url);
            user = resources.getString("jdbc.user");
            password = resources.getString("jdbc.password");
        } catch (Exception exp) {
            System.out.println("Couldn't load resources." + exp);
            System.exit(-1);
        }

        try {
            Class.forName(className);
        } catch (Exception e) {
            System.out.println("Failed to load  driver.");

        }

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(queryString);

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            for (int x = 1; x <= columnCount; x++) {
                String columnName = rsmd.getColumnName(x);

       
            while (rs.next()) {
                for (int i = 1; x <= columnCount; x++) {
                    ProductsBean products = new ProductsBean();
                    if (columnName.equals("PRODUCTID")){
                        products.setProductId(rs.getString());
                    }
                    else if (columnName.equals("NAME")){
                        products.setName(rs.getString());
                    }
                    else if (columnName.equals("PRICE")){
                        products.setPrice(rs.getString());
                    }
                }   
                return Products;
            }
    
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return resultStr;
    }
    
    

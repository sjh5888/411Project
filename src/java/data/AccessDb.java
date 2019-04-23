/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import data.ProductsBean;
import java.sql.*;

/**
 *
 * @author gkemp
 */
public class AccessDb {

    static String className = null;
    static String url = null;
    static String user = null;
    static String password = null;
    static String description[];
    static ProductsBean[] products;
    static ProductsBean product = new ProductsBean();

    public static String[] runQuery(String queryString, boolean type) throws SQLException {

        try {
            /*ResourceBundle resources;
            InputStream in = null;

            in = ClassLoader.getSystemResourceAsStream("db.properties");

            resources = new PropertyResourceBundle(in);

            in.close();

            className = resources.getString("jdbc.driver");
            url = resources.getString("jdbc.url");
            //System.out.println(url);
            user = resources.getString("jdbc.user");
            password = resources.getString("jdbc.password"); */
            className = "org.apache.derby.jdbc.ClientDriver";
            url = "jdbc:derby://localhost:1527/Products";
            user = "app";
            password = "app";
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
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(queryString);

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            //System.out.println("pass");

            /* for (int x = 1; x <= columnCount; x++) {
                //String columnName = rsmd.getColumnName(x);

            }*/
 /*  while (rs.next()) {
                for (int x = 1; x <= columnCount; x++) {
                    resultStr = resultStr + rs.getString(x) + "\t";

                }

            } */
            int rows = 0;
            if (rs.last()) {
                rows = rs.getRow();
                // Move to beginning
                rs.beforeFirst();

            }
            description = new String[rows];

            int i = 0;

            while (rs.next()) {
                String result = rs.getString(1);
                description[i++] = result;
            }
            // while (rs.next()) {
            //if(  rs.next()){

            /*for (int i = 0; i < rows; i++) {
          while(rs.next()) {  
          for (int j = 0; j < 2; j++) {
 
        
     //description = rs.getString(1);
                description[i] = rs.getString(1);
               //System.out.println(description[i]);
               
            }
 //rs.next();
            }
          } */
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        //System.out.println(description[6]);
        return description;
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
            /*ResourceBundle resources;
            InputStream in = null;

            in = ClassLoader.getSystemResourceAsStream("db.properties");

            resources = new PropertyResourceBundle(in);

            in.close();

            className = resources.getString("jdbc.driver");
            url = resources.getString("jdbc.url");
            //System.out.println(url);
            user = resources.getString("jdbc.user");
            password = resources.getString("jdbc.password");*/
            className = "org.apache.derby.jdbc.ClientDriver";
            url = "jdbc:derby://localhost:1527/Products";
            user = "app";
            password = "app";
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
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery(queryString);

        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        //for (int x = 1; x <= columnCount; x++) {
        //while (rs.next()) { //maybe changeto a for loop to run once because we are only getting data for one product
        /*for (int i = 1; i <= columnCount; i++) {
            String columnName = rsmd.getColumnName(i);
            if (columnName.equals("PRODUCTID")) {
                product.setProductId(Long.parseLong(rs.getString(i)));
            } else if (columnName.equals("NAME")) {
                product.setName(rs.getString(i));
            } else if (columnName.equals("CATEGORYID")) {
                product.setCategoryId(Long.parseLong(rs.getString(i)));
            } else if (columnName.equals("PRICE")) {
                product.setPrice(rs.getString(i));  /////////////////
            } else if (columnName.equals("DESCRIPTION")) {
                product.setDescription(rs.getString(i));
            } else if (columnName.equals("INVENTORY")) {
                product.setInventory(Integer.parseInt(rs.getString(i)));
            } else if (columnName.equals("SHIPPINGLOCATION")) {
                product.setShippingLocation(rs.getString(i));
            } else if (columnName.equals("WEIGHT")) {
                product.setWeight(Double.parseDouble(rs.getString(i)));
            } else if (columnName.equals("SIZE")) {
                product.setSize(rs.getString(i));
            } else if (columnName.equals("IMAGELOCATION")) {
                product.setImageLocation(rs.getString(i));
            } 
            System.out.println(product.getName());
        }*/
        while (rs.next()) {
            product.setProductId(Long.parseLong(rs.getString(1)));
            product.setName(rs.getString(2));
            product.setCategoryId(Long.parseLong(rs.getString(3)));
            product.setPrice(String.valueOf(rs.getString(4)));
            product.setDescription(rs.getString(5));
            product.setInventory(Integer.parseInt(rs.getString(6)));
            product.setShippingLocation(rs.getString(7));
            product.setWeight(Double.parseDouble(rs.getString(8)));
            product.setSize(rs.getString(9));
            product.setImageLocation(rs.getString(10));

        }
        //System.out.println(product.getName());
        //System.out.println(product.getDescription());
        return product;
    }

    /**
     * Return array of ProductBeans
     *
     * @param queryString
     * @param type
     * @return
     * @throws SQLException
     */
    public static ProductsBean[] arrayProductQuery(String queryString, boolean type) throws SQLException {

        try {
            /* ResourceBundle resources;
            InputStream in = null;

            in = ClassLoader.getSystemResourceAsStream("db.properties");

            resources = new PropertyResourceBundle(in);

            in.close();

            className = resources.getString("jdbc.driver");
            url = resources.getString("jdbc.url");
            //System.out.println(url);
            user = resources.getString("jdbc.user");
            password = resources.getString("jdbc.password"); */
            className = "org.apache.derby.jdbc.ClientDriver";
            url = "jdbc:derby://localhost:1527/Products";
            user = "app";
            password = "app";
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
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(queryString);

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            int rows = 0;
            if (rs.last()) {
                rows = rs.getRow();
                // Move to beginning
                rs.beforeFirst();

            }
            products = new ProductsBean[rows];

            int i = 0;

            /* while (rs.next()) {
                String result = rs.getString(1);
                description[i++] = result;
            }*/
            while (rs.next()) {
                
            
                 products[i] = new ProductsBean();
              
                    products[i] = new ProductsBean();
                        
                            products[i].setProductId(Long.parseLong(rs.getString(1)));
                        
                            products[i].setName((rs.getString(2)));
                       
                            products[i].setPrice(rs.getString(4));
                            
                            products[i].setImageLocation(rs.getString(10));
                            
                               i++;
                        }
                        
       
          /*  for (int i = 0; i < rows; i++) {
                products[i] = new ProductsBean();
                while (rs.next()) {
                    for (int j = 1; j <= columnCount; j++) {
                        String columnName = rsmd.getColumnName(j);

                products[i] = new ProductsBean();

                products[i] = new ProductsBean();

                products[i].setProductId(Long.parseLong(rs.getString(1)));

                products[i].setName((rs.getString(2)));

                products[i].setPrice(Double.parseDouble(rs.getString(4)));

                i++;
            } */

            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        //System.out.println(products[0]);
        return products;

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

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
    
    public static Product indProductQuery(String queryString, boolean type) throws SQLException {

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

            }
            while (rs.next()) {
                for (int x = 1; x <= columnCount; x++) {
                    Product product = new Product();
                    if (columnName.equals("PRODUCTID")){
                        product.setProdID(rs.getString());
                    }

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
     * Need 3 more methods that returns 1 ProductBean, 1 array of ProductBeans,
     * and 1 String (Description)
     */
}

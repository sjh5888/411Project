/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import controllers.*;

/**
 *
 * @author elgoo
 */
public class ProductsBean {
    private long productId; 
    private String name;
    private long categoryId;
    private String price; ////
    private String description;
    private int inventory;
    private String shippingLocation;
    private double weight;
    private String size;
    private String imageLocation;
    
 public ProductsBean(){
     productId = 0;
     name = null;
     categoryId = 0;
     price = null; ////////// =0
     description = null;
     inventory = 0;
     shippingLocation = null;
     weight = 0;
     size = null;
     imageLocation = null;
     
 }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }
 
    public void setPrice(String pric) { ////////////////////////
        double xyz = Double.parseDouble(pric);
        System.out.println(xyz);
        this.price = String.format("%.2f", xyz);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public void setShippingLocation(String shippingLocation) {
        this.shippingLocation = shippingLocation;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }
     
    
    public long getProductId(){
        return productId;
    }

    public String getName() {
        return name;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getInventory() {
        return inventory;
    }

    public String getShippingLocation() {
        return shippingLocation;
    }

    public double getWeight() {
        return weight;
    }

    public String getSize() {
        return size;
    }

    public String getImageLocation() {
        return imageLocation;
    }
   
}

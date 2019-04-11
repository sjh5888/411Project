/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author elgoo
 */
public class ProductsBean {
    private long productId = 0;
    private String name = null;
    private long categoryId = 0;
    private double price = 0;
    private String description = null;
    private int inventory = 0;
    private String shippingLocation = null;
    private double weight = 0;
    private String size = null;
    private String imageLocation = null;
    
 public ProductsBean(){
     
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
 
    public void setPrice(double price) {
        this.price = price;
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

    public double getPrice() {
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

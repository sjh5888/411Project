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
    public void setProductId(long pId){
        productId = pId;
    }
    
     public void setName(String n){
        name = n;
    }
     
     public void setCategoryId(long cId){
         categoryId = cId;
     }
     
    // publoc void setPrice(p)
    
    public long getProductId(){
        return productId;
    }
    
   
    
    
}

package com.Tattva.models;

public class Product {
    // fields
    private int productId;
    private String productName;
    private String productDescription;
    private int availableQuantity;
    private double price;
    // constructor
    public Product() {}

    public Product(int productId, String productName, String productDescription, int availableQuantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.availableQuantity = availableQuantity;
        this.price = price;
    }

    // getter and setter methods

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // to string method


    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", availableQuantity=" + availableQuantity +
                ", price=" + price +
                '}';
    }
}

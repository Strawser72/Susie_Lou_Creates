package com.Susie.Lou.Creates.model;

import java.math.BigDecimal;

public class Product {
    private int productId;
    private String name;
    private String SKU;
    private int quantity;
    private BigDecimal price;
    private String imageName;
    private String tags;
    private String genre;
    private String description;
    public Product(int productId, String name, String SKU, int quantity, BigDecimal price, String imageName, String tags, String genre, String description) {
        this.productId = productId;
        this.name = name;
        this.SKU = SKU;
        this.quantity = quantity;
        this.price = price;
        this.imageName = imageName;
        this.tags = tags;
        this.genre = genre;
        this.description = description;
    }

    public Product() {  }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

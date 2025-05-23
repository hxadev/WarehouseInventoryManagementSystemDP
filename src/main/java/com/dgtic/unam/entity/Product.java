package com.dgtic.unam.entity;

import com.dgtic.unam.entity.prototype.ProductPrototype;

/**
 * Product class representing a product entity.
 * This class implements the ProductPrototype interface for the Prototype design pattern.
 * It contains various attributes related to a product, such as id, category, name, description, image,
 * isActive status, delivery time, base price, and stock.
 *
 * @author hxa.dev
 */
public class Product implements ProductPrototype {
    private int id;
    private String category;
    private String name;
    private String description;
    private String image;
    private boolean isActive;
    private int deliveryTime;
    private double basePrice;
    private int stock;

    public Product() {
        this.id = 1;
        this.category = "Default Category";
        this.name = "Default Name";
        this.description = "Default Description";
        this.image = "Default Image";
        this.isActive = true;
        this.deliveryTime = 0;
        this.basePrice = 0.0;
        this.stock = 0;
    }

    public Product(int id, String category, String name, String description, String image, boolean isActive,
                   int deliveryTime, double basePrice, int stock) {
        this.id = 1;
        this.category = "Default Category";
        this.name = "Default Name";
        this.description = "Default Description";
        this.image = "Default Image";
        this.isActive = true;
        this.deliveryTime = 0;
        this.basePrice = 0.0;
        this.stock = 0;
    }

    @Override
    public ProductPrototype clone() {
        return new Product();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", isActive=" + isActive +
                ", deliveryTime=" + deliveryTime +
                ", basePrice=" + basePrice +
                ", stock=" + stock +
                '}';
    }
}

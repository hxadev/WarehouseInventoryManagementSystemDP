package com.dgtic.unam.entity;

import java.util.Date;
import java.util.List;

/**
 * Order class representing an order in the system.
 * This class uses the Builder design pattern to create instances of Order.
 * It contains fields for order ID, customer name, order date, total amount, products, and special instructions.
 * The Builder class is used to construct an Order object step by step.
 *
 * @author hxa.dev
 */
public class Order {
    private int orderId;
    private String customerName;
    private Date orderDate;
    private double totalAmount;
    private List<Product> products;
    private String specialInstructions;

    private Order(Builder b) {
        this.orderId = b.orderId;
        this.customerName = b.customerName;
        this.orderDate = b.orderDate;
        this.totalAmount = b.totalAmount;
        this.products = b.products;
        this.specialInstructions = b.specialInstructions;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public static class Builder {
        private int orderId;
        private String customerName;
        private Date orderDate;
        private double totalAmount;
        private List<Product> products;
        private String specialInstructions;

        public Builder orderId(int orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder customerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder orderDate(Date orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public Builder totalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder products(List<Product> products) {
            this.products = products;
            return this;
        }

        public Builder specialInstructions(String specialInstructions) {
            this.specialInstructions = specialInstructions;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", orderDate=" + orderDate +
                ", totalAmount=" + totalAmount +
                ", products=" + products +
                ", specialInstructions='" + specialInstructions + '\'' +
                '}';
    }
}

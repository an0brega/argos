package br.com.backsolutions.argos.models;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String name;
    private int code;
    private double price;
    private int quantity;

    protected static List<Product> totalStock = new ArrayList<>();

    public Product(String name, int code, double price, int quantity) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.quantity = quantity;
    }

    public List<Product> getQuantityInStock() {
        return totalStock;
    }

    public double getPrice() {
        return price;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

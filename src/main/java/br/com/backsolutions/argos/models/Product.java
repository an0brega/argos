package br.com.backsolutions.argos.models;

public class Product {
    private String name;
    private int code;
    private double price;
    private int quantityInStock;

    public Product(String name, int code, double price, int quantityInStock) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public int getQuantityInStock() {
        return quantityInStock;
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

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
}

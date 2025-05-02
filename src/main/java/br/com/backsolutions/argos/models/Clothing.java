package br.com.backsolutions.argos.models;

public class Clothing extends Product{
    private String size;

    public Clothing(String name, String size, int code, double price, int quantityInStock) {
        super(name, code, price, quantityInStock);
        this.size = size;
    }
}

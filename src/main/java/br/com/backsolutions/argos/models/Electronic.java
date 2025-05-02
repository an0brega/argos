package br.com.backsolutions.argos.models;

public class Electronic extends Product {
    private int voltage;

    public Electronic(String name, int code, double price, int quantityInStock, int voltage) {
        super(name, code, price, quantityInStock);
        this.voltage = voltage;

    }

}

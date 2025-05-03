package br.com.backsolutions.argos.models;

import br.com.backsolutions.argos.interfaces.IStoredItem;

public class Electronic extends Product implements IStoredItem {
    private int voltage;

    public Electronic(String name, int code, double price, int quantityInStock, int voltage) {
        super(name, code, price, quantityInStock);
        this.voltage = voltage;
    }

    @Override
    public void addInStock(String name, int productCode, double productPrice, int quantityInStock) {
        int defaultVoltage = 220;

        Electronic e = new Electronic(name, productCode, productPrice, quantityInStock, defaultVoltage);
        Product.totalStock.add(e);
    }

    public void addInStock(String name, int productCode, double productPrice, int quantityInStock, int voltage) {
        Electronic e = new Electronic(name, productCode, productPrice, quantityInStock, voltage);
        Product.totalStock.add(e);
    }

    @Override
    public void listAllInStock() {

    }

    @Override
    public void updateInStock() {

    }

    @Override
    public void checkByCode() {

    }

    @Override
    public void removeFromStock() {

    }

    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }
}

package br.com.backsolutions.argos.models;

import br.com.backsolutions.argos.interfaces.IStoredItem;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Clothing extends Product {
    private String size;
    private int validCode;

    public Clothing(String name, String size, int code, double price, int quantityInStock) {
        super(name, code, price, quantityInStock);
        this.size = size;
    }

    public void setClothingSize(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString(){
        return  "Product: " + this.getName() + " | Code: " + this.getCode() + " | Price: R$" + this.getPrice() + " | Size: " + this.getSize();

    }
}

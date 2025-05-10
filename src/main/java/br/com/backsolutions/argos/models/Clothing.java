package br.com.backsolutions.argos.models;

public class Clothing extends Product {
    private String size;

    public Clothing(String name, String size, int code, double price, int quantityInStock) {
        super(name, code, price, quantityInStock);
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

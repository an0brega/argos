package br.com.backsolutions.argos.models;

public class Electronic extends Product {
    private int voltage;

    public Electronic(String name, int code, double price, int quantityInStock, int voltage) {
        super(name, code, price, quantityInStock);
        this.voltage = voltage;
    }

    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }

    @Override
    public String toString(){
        return  "Product: " + this.getName() + " | Code: " + this.getCode() + " | Price: R$" + this.getPrice() + " | Voltage: " + this.getVoltage() + "V";
    }
}

package br.com.backsolutions.argos.models;

import br.com.backsolutions.argos.interfaces.IStoredItem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Electronic extends Product implements IStoredItem {
    private int voltage;
    private int validCode;

    public Electronic(){};

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
    public Product addInStock(Scanner scanner) {

        System.out.print("Name: ");
        String name = scanner.nextLine();

        try {
            System.out.print("Code: ");
            validCode = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid imput, it must be a number.");
        }

        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Quantity in stock: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Voltage (110/220): ");
        int voltage = scanner.nextInt();
        scanner.nextLine();

        return new Electronic(name, validCode, price, quantity, voltage);
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

    @Override
    public String toString(){
        return  "Product: " + this.getName() + " | Code: " + this.getCode() + " | Price: R$" + this.getPrice() + " | Voltage: " + this.getVoltage() + "V";
    }
}

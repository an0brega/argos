package br.com.backsolutions.argos.models;

import br.com.backsolutions.argos.interfaces.IStoredItem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Clothing extends Product implements IStoredItem {
    private String size;
    private int validCode;

    public Clothing(){}

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

        System.out.print("Size (M/G): ");
        String size = scanner.nextLine();
        scanner.nextLine();

        return new Clothing(name, size, validCode, price, quantity);
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
        return  "Product: " + this.getName() + " | Code: " + this.getCode() + " | Price: R$" + this.getPrice() + " | Size: " + this.getSize();

    }
}

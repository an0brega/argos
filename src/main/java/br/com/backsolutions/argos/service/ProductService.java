package br.com.backsolutions.argos.service;

import br.com.backsolutions.argos.interfaces.IStoredItem;
import br.com.backsolutions.argos.models.Clothing;
import br.com.backsolutions.argos.models.Electronic;
import br.com.backsolutions.argos.models.Food;
import br.com.backsolutions.argos.models.Product;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IStoredItem {

    private List<Product> storage;
    private int validCode;
    private Product product;

    public void addInStock(List<Product> items, Scanner scanner) {

        storage = items;

        System.out.println("Please imput the product type:");
        System.out.println("1 - Electronic");
        System.out.println("2 - Food");
        System.out.println("3 - Clothing");
        System.out.print("Option: ");
        int option = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        try {
            System.out.print("Code: ");
            validCode = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid imput, it must be a number." + e);
        }

        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Quantity in stock: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        switch (option){
            case 1:
                System.out.print("Voltage (110/220): ");
                int voltage = scanner.nextInt();
                scanner.nextLine();

                product = new Electronic(name, validCode, price, quantity, voltage);

                System.out.println(product);
                break;

            case 2:
                System.out.print("Cooking point (medium/done): ");
                String cookingPoint = scanner.nextLine();
                scanner.nextLine();

                product = new Food(name, cookingPoint, validCode, price, quantity);
                System.out.println(product);
                break;

            case 3:
                System.out.print("Size (M/G): ");
                String size = scanner.nextLine();
                scanner.nextLine();

                product = new Clothing(name, size, validCode, price, quantity);
                System.out.println(product);
                break;

            default:
                System.out.println("Invalid option. Product not created.");
                return;
        }

        storage.add(product);

    }

    @Override
    public void updateInStock() {

    }

    @Override
    public void removeFromStock() {

    }

    @Override
    public void listAllInStock() {

        if (storage == null || storage.isEmpty()) {
            System.out.println("Sorry, the storage is empty or uninitialized");
        } else {
            for (Product item : storage) {
                System.out.println(item);
            }
        }
    }

    @Override
    public void checkByCode() {

    }
}

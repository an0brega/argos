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

    public Product readProductDataFromUser(Scanner scanner) {
        System.out.println("Please input the product type:");
        System.out.println("1 - Electronic");
        System.out.println("2 - Food");
        System.out.println("3 - Clothing");
        System.out.print("Option: ");

        int option;
        try {
            option = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid option. Must be a number.");
            scanner.nextLine();
            return null;
        }

        System.out.print("Name: ");
        String name = scanner.nextLine();

        int code;
        try {
            System.out.print("Code: ");
            code = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid code. Must be a number.");
            scanner.nextLine();
            return null;
        }

        double price;
        try {
            System.out.print("Price: ");
            price = scanner.nextDouble();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid price. Must be a number.");
            scanner.nextLine();
            return null;
        }

        int quantity;
        try {
            System.out.print("Quantity in stock: ");
            quantity = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid quantity. Must be a number.");
            scanner.nextLine();
            return null;
        }

        switch (option) {
            case 1:
                System.out.print("Voltage (110/220): ");
                int voltage = scanner.nextInt();
                scanner.nextLine();
                return new Electronic(name, code, price, quantity, voltage);

            case 2:
                System.out.print("Cooking point (medium/done): ");
                String cookingPoint = scanner.nextLine();
                return new Food(name, cookingPoint, code, price, quantity);

            case 3:
                System.out.print("Size (M/G): ");
                String size = scanner.nextLine();
                return new Clothing(name, size, code, price, quantity);

            default:
                System.out.println("Invalid option. Product not created.");
                return null;
        }
    }

    @Override
    public void addInStock(List<Product> items, Scanner scanner) {

        storage = items;

        Product productToAdd = readProductDataFromUser(scanner);

        storage.add(productToAdd);

        System.out.println("The following product was added to stock: " + productToAdd);
    }

    @Override
    public void updateInStock() {}

    @Override
    public void removeFromStock(Scanner scanner) {

        System.out.print("Please, input the name of the product you want to remove: ");
        String productRemove = scanner.nextLine();

        int index = couldFindProductIndexByName(productRemove);

        if (index != -1)
            storage.remove(index);

        else{
            System.out.println("Item not found in storage, try again.");
        }

        System.out.println("Item removed! This is what we have in stock now:");
        listAllInStock(ContextType.REMOVAL);

    }

    @Override
    public void listAllInStock() {
        listAllInStock(ContextType.CHECK);
    }

    public void listAllInStock(ContextType context) {
        if (storage == null || storage.isEmpty()) {
            switch (context) {
                case REMOVAL:
                    System.out.println("Item removed! The stock is now empty.");
                    break;
                case ADDITION:
                    System.out.println("No items available to add. The stock is empty.");
                    break;
                case CHECK:
                    System.out.println("The stock is empty. Please add items.");
                    break;
                default:
                    System.out.println("Sorry, the storage is empty or uninitialized.");
            }
        } else {
            for (Product item : storage) {
                System.out.println(item);
            }
        }
    }

    @Override
    public void checkByCode() {

    }

    public int couldFindProductIndexByName(String nameToFind) {
        for (int i = 0; i < storage.size(); i++) {
            Product item = storage.get(i);
            if (item.getName().equalsIgnoreCase(nameToFind)) {
                return i;
            }
        }
        return -1;
    }
}
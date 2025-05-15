package br.com.backsolutions.argos.service;

import br.com.backsolutions.argos.interfaces.IStoredItemRepository;
import br.com.backsolutions.argos.models.Clothing;
import br.com.backsolutions.argos.models.Electronic;
import br.com.backsolutions.argos.models.Food;
import br.com.backsolutions.argos.models.Product;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IStoredItemRepository {

    private List<Product> storage;

    public ProductService() {
        storage = new ArrayList<>();  // initializing the list as empty
    }

    public void setStorage(List<Product> items) {
        if (items == null) {
            storage = new ArrayList<>();
        } else {
            storage = items;
        }
    }

    public Product readProductDataFromUser(Scanner scanner) {
        System.out.println("Please input the product type:");
        System.out.println("1 - Electronic");
        System.out.println("2 - Food");
        System.out.println("3 - Clothing");

        int option;
        String size;

        do {
            option = readInt(scanner, "Option: ");
            if (option < 1 || option > 3) {
                System.out.println("Invalid option. Please select 1, 2, or 3.");
            }
        } while (option < 1 || option > 3);

        String name = readLine(scanner, "Name: ");
        int code = readInt(scanner, "Code: ");
        double price = readDouble(scanner, "Price: ");
        int quantity = readInt(scanner, "Quantity in stock: ");

        switch (option) {
            case 1:
                int voltage;
            do {
                voltage = readInt(scanner, "Voltage: ");
                if (voltage != 110 && voltage != 220) {
                    System.out.println("Invalid option. Please select 110 or 220.");
                }
            } while (voltage != 110 && voltage != 220);

                return new Electronic(name, code, price, quantity, voltage);

            case 2:
                String foodTaste;
                do {
                    foodTaste = readLine(scanner, "Cooking point (bitter/sweet): ");
                    if (!foodTaste.equalsIgnoreCase("bitter") && !foodTaste.equalsIgnoreCase("sweet")) {
                        System.out.println("Invalid option. Please select 'bitter' or 'sweet'.");
                    }
                } while (!foodTaste.equalsIgnoreCase("bitter") && !foodTaste.equalsIgnoreCase("sweet"));

                return new Food(name, foodTaste, code, price, quantity);

            case 3:
                do {
                    size = readLine(scanner, "Size (M/G): ");
                    if (!size.equalsIgnoreCase("M") && !size.equalsIgnoreCase("G")) {
                        System.out.println("Invalid option. Please select M or G.");
                    }
                } while (!size.equalsIgnoreCase("M") && !size.equalsIgnoreCase("G"));

                return new Clothing(name, size, code, price, quantity);
        }

        throw new IllegalStateException("Unexpected product type selected: " + option);
    }

    @Override
    public void addInStock(List<Product> items, Scanner scanner) {

        setStorage(items);

        Product productToAdd = readProductDataFromUser(scanner);

        storage.add(productToAdd);

        System.out.println("The following product was added to stock: " + productToAdd);

        System.out.println("This is your storage now: ");
        listAllInStock(ContextTypeEnum.ADDITION);
    }

    @Override
    public void updateInStock(Scanner scanner) {
        System.out.print("Please, input the id of the product you want to update: ");

        String productToUpdate = scanner.nextLine();
        scanner.nextLine();
        int idToSearch;

        if (isInteger(productToUpdate)) {
            idToSearch = Integer.parseInt(productToUpdate);
        } else {
            System.out.println("Invalid input, it must be a number.");
            return;
        }

        int index;

        int itemFoundOnStorage = couldFindProductIndexById(idToSearch);

        if (itemFoundOnStorage != -1) {

            if (storage == null || storage.isEmpty()) {
                System.out.println("The storage is empty or not initialized. Please add products first.");
                return;
            }

            System.out.print("Do you want to increase or decrease? (I/D): ");
            String optionToUpdate = scanner.nextLine();

            if (!optionToUpdate.equalsIgnoreCase("I") && !optionToUpdate.equalsIgnoreCase("D")) {
                System.out.println("Invalid option. Please type 'I' to increase or 'D' to decrease.");
                return;
            }

            if (optionToUpdate.equalsIgnoreCase("I")) { // in Java, it doesn't work to compare strings using '=='. This method is more appropriated.
                System.out.print("Please, input the quantity you want to increase.");
                int quantityToUpdate = scanner.nextInt();

                scanner.nextLine();

                index = couldFindProductIndexById(idToSearch);

                if (index != -1) {
                    Product product = storage.get(index);

                    int newQuantity = product.getQuantity() + quantityToUpdate;
                    product.setQuantity(newQuantity);
                    System.out.println("Updated!");
                    listAllInStock();
                }
            } else if (optionToUpdate.equalsIgnoreCase("D")) {
                System.out.print("Please, input the quantity you want to decrease.");
                int quantityToDecrease = scanner.nextInt();
                scanner.nextLine();

                index = couldFindProductIndexById(idToSearch);

                if (index != -1) {
                    Product product = storage.get(index);

                    int newQuantity = product.getQuantity() - quantityToDecrease;
                    product.setQuantity(newQuantity);
                    System.out.println("Updated!");
                    listAllInStock();
                }
            } else {
                System.out.println("Invalid option. Please type 'I' to increase or 'D' to decrease.");
            }

        } else {
            System.out.println("Item not found on storage, please try again.");
        }
    }

    @Override
    public void removeFromStock(Scanner scanner) {

        System.out.print("Please, input the id of the product you want to remove: ");
        String productToRemove = scanner.nextLine();
        int idToSearch;

        if (isInteger(productToRemove)) {
            idToSearch = Integer.parseInt(productToRemove);
        } else {
            System.out.println("Invalid input, it must be a number.");
            return;
        }

        int index = couldFindProductIndexById(idToSearch);

        if (index != -1) {
            storage.remove(index);
            listAllInStock(ContextTypeEnum.REMOVAL);

        } else {
            System.out.println("Item not found.");
            listAllInStock();
        }
    }

    @Override
    public void listAllInStock() {
        listAllInStock(ContextTypeEnum.CHECK);
    }

    public void listAllInStock(ContextTypeEnum context) {
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
    public void checkByCode(Scanner scanner) {
        System.out.print("Please, input the id of the product you want to check: ");
        String productToCheck = scanner.nextLine();

        if (!isInteger(productToCheck)) {
            System.out.println("Invalid input, it must be a number.");
            return;
        }

        int itemFound = Integer.parseInt(productToCheck);
        int index = couldFindProductIndexById(itemFound);

        if (index != -1) {
            System.out.println("Found!");
            System.out.println(storage.get(index));
        } else {
            System.out.println("Product not found.");
        }
    }

    private int couldFindProductIndexById(int itemToFind) {

        if (storage == null) {
            return -1;
        }

        for (int i = 0; i < storage.size(); i++) {
            Product item = storage.get(i);
            if (item.getCode() == itemToFind) {
                return i;
            }
        }
        return -1;
    }

    private int readInt(Scanner scanner, String message) {
        while (true) { //the code will remain asking for a valid option until the user inputs a correct one
            try {
                System.out.print(message);
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {


                System.out.println("Error: Input must be a number.");
                scanner.nextLine(); //cleans the buffer
            }
        }
    }

    private double readDouble(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                double value = scanner.nextDouble();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Error: Input must be a decimal number.");
                scanner.nextLine();
            }
        }
    }

    private String readLine(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
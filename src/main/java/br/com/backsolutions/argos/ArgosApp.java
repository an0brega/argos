package br.com.backsolutions.argos;

import br.com.backsolutions.argos.models.Electronic;
import br.com.backsolutions.argos.models.Food;
import br.com.backsolutions.argos.models.Product;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Locale;


public class ArgosApp {
    public static void main(String[] args) {

        //TODO - Implement the imput for the Clothing class
        //TODO - Implement the loop so the system doesn't end until the user wants to

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        Product product;
        int code = 0;

        System.out.println("Welcome to ARGOS");

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
            System.out.print("Product code: ");
            code = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid imput, it must be a number.");
        }

        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.print("Imput the product voltage (110/220): ");
                int voltage = scanner.nextInt();
                product = new Electronic(name, code, price, quantity, voltage);
                System.out.println(product);
                break;

            case 2:
                System.out.print("Imput cooking point (rare/medium): ");
                scanner.nextLine();
                String cookingPoint = scanner.nextLine();
                product = new Food(name, cookingPoint, code, price, quantity);
                System.out.println(product);
                break;

            default:
                System.out.println("Invalid choice, try again");
        }
    }
}
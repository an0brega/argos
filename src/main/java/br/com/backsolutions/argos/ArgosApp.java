package br.com.backsolutions.argos;

import br.com.backsolutions.argos.service.ProductService;
import br.com.backsolutions.argos.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Locale;

public class ArgosApp {
    public static void main(String[] args) {

        //TODO - Find a way to each item have a unique product code
        //TODO - Implement the listAllInStock, updateInStock, checkByCode, removeFromStock, remaining methods

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        List<Product> storage = new ArrayList<>();
        ProductService service =  new ProductService();
        boolean shouldRunProgram = true;

        while(shouldRunProgram) {

            System.out.println("");

            System.out.println("Welcome to ARGOS");

            System.out.println("Please imput the product type:");
            System.out.println("1 - Add on stock");
            System.out.println("2- Update on stock");
            System.out.println("3 - Remove from stock");
            System.out.println("4 - List all on stock");
            System.out.println("5 - Check by code");
            System.out.println("6 - Exit");
            System.out.print("Option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            System.out.println("");

            switch (option) {
                case 1:
                    service.addInStock(storage, scanner);
                    break;

                case 4:
                    service.listAllInStock();
                    break;

                case 6:
                    System.out.println("Bye!");
                    shouldRunProgram = false;
                    break;

                default:
                    System.out.println("Invalid choice, try again");
                    break;
            }
        }
    }
}
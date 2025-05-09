package br.com.backsolutions.argos;

import br.com.backsolutions.argos.interfaces.IStoredItem;
import br.com.backsolutions.argos.models.Clothing;
import br.com.backsolutions.argos.models.Electronic;
import br.com.backsolutions.argos.models.Food;
import br.com.backsolutions.argos.models.Product;

import java.util.Scanner;
import java.util.Locale;


public class ArgosApp {
    public static void main(String[] args) {

        //TODO - Find a way to each item have a unique product code
        //TODO - Implement the listAllInStock, updateInStock, checkByCode, removeFromStock, remaining methods

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        IStoredItem creator = null;
        boolean runProgram = true;

        while(runProgram) {

            System.out.println("");

            System.out.println("Welcome to ARGOS");

            System.out.println("Please imput the product type:");
            System.out.println("1 - Electronic");
            System.out.println("2 - Food");
            System.out.println("3 - Clothing");
            System.out.print("Option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    creator = new Electronic();
                    break;

                case 2:
                    creator = new Food();
                    break;

                case 3:
                    creator = new Clothing();
                    break;

                case 4:
                    System.out.println("Bye!");
                    runProgram = false;
                    break;

                default:
                    System.out.println("Invalid choice, try again");
                    break;
            }

            if (creator != null) {
                Product product = creator.addInStock(scanner);
                System.out.println("Product created: " + product);
            }
            else {
                System.out.println("Hmm, seems like the factory class wasn't created properly. How about running again?");
            }
        }
    }
}
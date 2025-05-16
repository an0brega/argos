package br.com.backsolutions.argos;

import br.com.backsolutions.argos.service.ProductService;
import br.com.backsolutions.argos.models.Product;

import java.util.*;

/**
 * Main application class for the Argos stock management system.
 * <p>
 * This class is responsible for starting the application and providing a
 * menu-driven interface to interact with the product inventory.
 * </p>
 *
 * <p>
 * Functionalities available:
 * <ul>
 *     <li>Add products to the stock</li>
 *     <li>Update existing product quantities</li>
 *     <li>Remove products from stock</li>
 *     <li>List all products in stock</li>
 *     <li>Search for a product by its code</li>
 * </ul>
 * </p>
 *
 * @author an0br3ga
 */
public class ArgosApp {

    /**
     * Entry point of the application.
     *
     * @param args Command-line arguments (not used in this application)
     */
    public static void main(String[] args) {

        // TODO - Find a way for each item to have a unique product code.

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        List<Product> storage = new ArrayList<>();
        ProductService service = new ProductService();
        boolean shouldRunProgram = true;

        while (shouldRunProgram) {

            System.out.println();
            System.out.println("Welcome to ARGOS");
            System.out.println("Please input the product type:");
            System.out.println("1 - Add to stock");
            System.out.println("2 - Update stock");
            System.out.println("3 - Remove from stock");
            System.out.println("4 - List all products in stock");
            System.out.println("5 - Check product by code");
            System.out.println("6 - Exit");
            System.out.print("Option: ");

            int option;

            try {
                option = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid option. Must be a number.");
                scanner.nextLine();
                continue;
            }

            System.out.println();

            switch (option) {
                case 1:
                    service.addInStock(storage, scanner);
                    break;

                case 2:
                    service.updateInStock(scanner);
                    break;

                case 3:
                    service.removeFromStock(scanner);
                    break;

                case 4:
                    service.listAllInStock();
                    break;

                case 5:
                    service.checkByCode(scanner);
                    break;

                case 6:
                    System.out.println("Bye!");
                    shouldRunProgram = false;
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
                    break;
            }
        }
    }
}

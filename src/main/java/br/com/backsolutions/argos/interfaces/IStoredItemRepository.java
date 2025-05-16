package br.com.backsolutions.argos.interfaces;

import br.com.backsolutions.argos.models.Product;

import java.util.List;
import java.util.Scanner;

/**
 * Defines the contract for managing product storage operations.
 */
public interface IStoredItemRepository {

    /**
     * Adds a new product to the storage.
     *
     * @param product The list in which the item will be stored.
     * @param scanner A {@link Scanner} used to gather user input related to product storage.
     */
    void addInStock(List<Product> product, Scanner scanner);

    /**
     * Updates an existing product in the storage.
     *
     * @param scanner A {@link Scanner} used to gather user input related to product storage.
     */
    void updateInStock(Scanner scanner);

    /**
     * Removes a product from the storage.
     *
     * @param scanner A {@link Scanner} used to gather user input related to product storage.
     */
    void removeFromStock(Scanner scanner);

    /**
     * Lists all products currently in storage.
     */
    void listAllInStock();

    /**
     * Checks if a product exists in storage using its code.
     *
     * @param scanner A {@link Scanner} used to gather the code to search for.
     */
    void checkByCode(Scanner scanner);
}

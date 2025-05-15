package br.com.backsolutions.argos.interfaces;

import br.com.backsolutions.argos.models.Product;

import java.util.List;
import java.util.Scanner;

public interface IStoredItemRepository {

    void addInStock(List<Product> product, Scanner scanner);
    void updateInStock(Scanner scanner);
    void removeFromStock(Scanner scanner);
    void listAllInStock();
    void checkByCode(Scanner scanner);

}

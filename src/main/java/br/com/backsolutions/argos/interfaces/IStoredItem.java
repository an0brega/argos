package br.com.backsolutions.argos.interfaces;

import br.com.backsolutions.argos.models.Product;
import br.com.backsolutions.argos.service.ContextType;

import java.util.List;
import java.util.Scanner;

public interface IStoredItem {

    void addInStock(List<Product> product, Scanner scanner);
    void updateInStock(Scanner scanner);
    void removeFromStock(Scanner scanner);
    void listAllInStock();
    void checkByCode();

}

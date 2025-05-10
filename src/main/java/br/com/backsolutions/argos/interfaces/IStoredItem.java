package br.com.backsolutions.argos.interfaces;

import br.com.backsolutions.argos.models.Product;

import java.util.List;
import java.util.Scanner;

public interface IStoredItem {

    void addInStock(List<Product> product, Scanner scanner);
    void updateInStock();
    void removeFromStock();
    void listAllInStock();
    void checkByCode();

}

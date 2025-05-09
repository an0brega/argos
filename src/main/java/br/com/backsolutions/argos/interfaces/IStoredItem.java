package br.com.backsolutions.argos.interfaces;

import br.com.backsolutions.argos.models.Product;

import java.util.Scanner;

public interface IStoredItem {

    Product addInStock(Scanner scanner);
    void listAllInStock();
    void updateInStock();
    void checkByCode();
    void removeFromStock();

}

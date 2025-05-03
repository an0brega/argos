package br.com.backsolutions.argos.interfaces;

public interface IStoredItem {

    void addInStock(String name, int productCode, double productPrice, int quantity);
    void listAllInStock();
    void updateInStock();
    void checkByCode();
    void removeFromStock();

}

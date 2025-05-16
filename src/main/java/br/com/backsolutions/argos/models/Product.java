package br.com.backsolutions.argos.models;

/**
 * The {@code Product} class represents a generic product in the inventory management system.
 * It encapsulates the essential attributes such as name, code, price, and quantity.
 * This class serves as a base for specific product types.
 */
public class Product {
    /**
     * The name of the product.
     */
    private String name;

    /**
     * The unique numeric code that identifies the product.
     */
    private int code;

    /**
     * The unit price of the product.
     */
    private double price;

    /**
     * The quantity of the product currently in stock.
     */
    private int quantity;

    /**
     * Constructs a new {@code Product} with the specified name, code, price, and quantity.
     *
     * @param name     the name of the product
     * @param code     the unique identifier for the product
     * @param price    the unit price of the product
     * @param quantity the quantity in stock
     */
    public Product(String name, int code, double price, int quantity) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Returns the name of the product.
     *
     * @return the product name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     *
     * @param name the new product name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the code of the product.
     *
     * @return the product code
     */
    public int getCode() {
        return code;
    }

    /**
     * Sets the code of the product.
     *
     * @param code the new product code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Returns the price of the product.
     *
     * @return the product price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     *
     * @param price the new product price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns the quantity of the product in stock.
     *
     * @return the product quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the product in stock.
     *
     * @param quantity the new quantity in stock
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

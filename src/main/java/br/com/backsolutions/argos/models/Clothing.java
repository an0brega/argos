package br.com.backsolutions.argos.models;

/**
 * Represents a clothing product in the Argos inventory system.
 * <p>
 * This class extends {@link Product} and adds a specific attribute {@code size},
 * which refers to the size of the clothing item (e.g., M, G).
 * </p>
 * 
 * Example usage:
 * <pre>{@code
 *     Clothing clothing = new Food("Camiseta", "G, 5, 79.90, 1);
 * }</pre>
 *
 * @author an0brega
 * @version 1.0
 */
public class Clothing extends Product {
    private String size;

    /**
     * Constructs a new {@code Clothing} object with the specified attributes.
     *
     * @param name            the name of the product
     * @param size            the clothing size (e.g., M, G)
     * @param code            the unique code of the product
     * @param price           the unit price of the product
     * @param quantityInStock the quantity available in stock
     */
    public Clothing(String name, String size, int code, double price, int quantityInStock) {
        super(name, code, price, quantityInStock);
        this.size = size;
    }

    /**
     * Returns the size of the clothing item.
     *
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * Sets the size of the clothing item.
     *
     * @param size the new size
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Returns a string representation of the {@code Clothing} object,
     * including name, code, price, size, and quantity.
     *
     * @return a formatted string with product details
     */
    @Override
    public String toString(){
        return  "Product: " + this.getName() +
                " | Code: " + this.getCode() +
                " | Price: R$" + this.getPrice() +
                " | Size: " + this.getSize() +
                " | Quantity: " + this.getQuantity();
    }
}

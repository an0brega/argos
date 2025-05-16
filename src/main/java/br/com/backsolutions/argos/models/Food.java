package br.com.backsolutions.argos.models;

/**
 * Represents a food product in the inventory system.
 * Extends the {@link Product} class by adding the taste or cooking point information.
 *
 * <p>This class is used to manage food items in stock with attributes such as
 * name, code, price, quantity, and specific taste or cooking point description.</p>
 *
 * Example usage:
 * <pre>{@code
     *     Food steak = new Food("Picanha", "Bitter, 3001, 89.90, 15);
 * }</pre>
 *
 * @author an0brega
 * @version 1.0
 */
public class Food extends Product {
    private String foodTaste;

    /**
     * Constructs a Food object with the specified attributes.
     *
     * @param name            The name of the food product.
     * @param foodTaste       A description of the food's taste or cooking point.
     * @param code            The unique product code.
     * @param price           The price of the product.
     * @param quantityInStock The quantity currently in stock.
     */
    public Food(String name, String foodTaste, int code, double price, int quantityInStock) {
        super(name, code, price, quantityInStock);
        this.foodTaste = foodTaste;
    }

    /**
     * Gets the food's taste or cooking point.
     *
     * @return A string describing the food's taste.
     */
    public String getFoodTaste() {
        return foodTaste;
    }

    /**
     * Sets the food's taste or cooking point.
     *
     * @param foodTaste A string describing the new taste.
     */
    public void setFoodTaste(String foodTaste) {
        this.foodTaste = foodTaste;
    }

    /**
     * Returns a string representation of the food item.
     *
     * @return A formatted string containing all key attributes of the food item.
     */
    @Override
    public String toString(){
        return  "Product: " + this.getName()
                + " | Code: " + this.getCode()
                + " | Price: R$" + this.getPrice()
                + " | Cooking point: " + this.getFoodTaste()
                + " | Quantity: " + this.getQuantity();
    }
}

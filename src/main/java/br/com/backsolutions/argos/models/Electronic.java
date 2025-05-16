package br.com.backsolutions.argos.models;

/**
 * Represents an electronic product in the Argos inventory system.
 * <p>
 * This class extends {@link Product} and includes a specific attribute {@code voltage},
 * which refers to the operating voltage of the electronic device (e.g., 110V, 220V).
 * </p>
 *
 * Example usage:
 * <pre>{@code
 *     Electronic celular = new Electronic("Iphone", 5, 4000, 1, 110);
 * }</pre>
 *
 * @author an0brega
 * @version 1.0
 */
public class Electronic extends Product {
    private int voltage;

    /**
     * Constructs a new {@code Electronic} object with the specified attributes.
     *
     * @param name            the name of the product
     * @param code            the unique code of the product
     * @param price           the unit price of the product
     * @param quantityInStock the quantity available in stock
     * @param voltage         the operating voltage of the device (e.g., 110, 220)
     */
    public Electronic(String name, int code, double price, int quantityInStock, int voltage) {
        super(name, code, price, quantityInStock);
        this.voltage = voltage;
    }

    /**
     * Returns the voltage of the electronic item.
     *
     * @return the voltage in volts
     */
    public int getVoltage() {
        return voltage;
    }

    /**
     * Sets the voltage of the electronic item.
     *
     * @param voltage the new voltage in volts
     */
    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }

    /**
     * Returns a string representation of the {@code Electronic} object,
     * including name, code, price, voltage, and quantity.
     *
     * @return a formatted string with product details
     */
    @Override
    public String toString() {
        return "Product: " + this.getName() +
                " | Code: " + this.getCode() +
                " | Price: R$" + this.getPrice() +
                " | Voltage: " + this.getVoltage() + "V" +
                " | Quantity: " + this.getQuantity();
    }
}

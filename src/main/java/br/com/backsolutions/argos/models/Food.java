package br.com.backsolutions.argos.models;

public class Food extends Product {
    private String foodTaste;

    public Food(String name, String foodTaste, int code, double price, int quantityInStock) {
        super(name, code, price, quantityInStock);
        this.foodTaste = foodTaste;
    }

    public String getFoodTaste() {
        return foodTaste;
    }

    public void setFoodTaste(String foodTaste) {
        this.foodTaste = foodTaste;
    }

    @Override
    public String toString(){
        return  "Product: " + this.getName() + " | Code: " + this.getCode() + " | Price: R$" + this.getPrice() + " | Cooking point: " + this.getFoodTaste() + " | Quantity: " + this.getQuantity();

    }
}

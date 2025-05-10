package br.com.backsolutions.argos.models;

public class Food extends Product {
    private String cookingPoint;

    public Food(String name, String cookingPoint, int code, double price, int quantityInStock) {
        super(name, code, price, quantityInStock);
        this.cookingPoint = cookingPoint;
    }

    public String getCookingPoint() {
        return cookingPoint;
    }

    public void setCookingPoint(String cookingPoint) {
        this.cookingPoint = cookingPoint;
    }

    @Override
    public String toString(){
        return  "Product: " + this.getName() + " | Code: " + this.getCode() + " | Price: R$" + this.getPrice() + " | Cooking point: " + this.getCookingPoint();

    }
}

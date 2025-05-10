package br.com.backsolutions.argos.models;

import br.com.backsolutions.argos.interfaces.IStoredItem;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Food extends Product {
    private String cookingPoint;
    private int validCode;

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

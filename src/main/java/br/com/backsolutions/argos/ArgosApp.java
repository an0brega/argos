package br.com.backsolutions.argos;

import br.com.backsolutions.argos.models.Electronic;

public class ArgosApp {
    public static void main(String[] args) {

        System.out.println("Welcome to ARGOS");

        Electronic microondas = new Electronic("Micro-ondas", 101, 599.90, 5, 110);

        microondas.addInStock("Micro-ondas", 101, 599.90, 5, 110);

        System.out.println("Produto: " + microondas.getName() + " | Código: " + microondas.getCode() + " | Preço: R$" + microondas.getPrice());

        System.out.println("Tensão: " + microondas.getVoltage() + "V");

        /*Example of the expected final result
        Produto: Micro-ondas | Código: 101 | Preço: R$599.9
         Tensão: 110V
         */
    }
}
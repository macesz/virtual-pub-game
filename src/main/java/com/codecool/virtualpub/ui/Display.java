package com.codecool.virtualpub.ui;

import com.codecool.virtualpub.data.BartenderScript;
import com.codecool.virtualpub.data.CustomerScript;
import com.codecool.virtualpub.data.Drink;
import com.codecool.virtualpub.data.DrinkType;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Display {

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayScript(BartenderScript script) {
        System.out.println("Bartender: " + script);
    }

    public void displayScript(CustomerScript script) {
        System.out.println("Customer: " + script);
    }

    public void displayDrink(Drink drink) {
        System.out.println(drink.getDrinkType() + ": " + drink.getBrand());
    }

    public void displayStock(List<Drink> drinks) {
        // create copy and sort
        Comparator<Drink> drinkTypeComparator = Comparator.comparing(Drink::getDrinkType);
        ArrayList<Drink> sortedDrinks = new ArrayList<>(drinks);
        sortedDrinks.sort(drinkTypeComparator);
        ArrayList<DrinkType> usedDrinkTypes = new ArrayList<>();

        System.out.println("Stock: ");
        for (Drink drink : sortedDrinks) {
            if(!usedDrinkTypes.contains(drink.getDrinkType())) {
                System.out.println("  " + drink.getDrinkType() + ":");
                usedDrinkTypes.add(drink.getDrinkType());
            }
            System.out.println("    " + drink.getBrand() + ": " + drink.getAmount());
        }
    }

    public void displayBartenderActions(String bartenderName, String[] actions) {
        System.out.println(bartenderName + " actions: ");
        for (int i = 1; i <= actions.length; i++) {
            System.out.println(i + ": " + actions[i - 1]);
        }
    }
}

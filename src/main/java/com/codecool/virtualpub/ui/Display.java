package com.codecool.virtualpub.ui;

import com.codecool.virtualpub.data.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Display {

    /**
     * Displays a message to the console.
     *
     * @param message The message to be displayed.
     */
    public void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Displays the bartender's script to the console.
     *
     * @param script The {@link BartenderScript} object containing the script to be displayed.
     */
    public void displayScript(BartenderScript script) {
        System.out.println("Bartender: " + script);
    }

    /**
     * Displays the customer's script to the console.
     *
     * @param script The {@link CustomerScript} object containing the script to be displayed.
     */
    public void displayScript(CustomerScript script) {
        System.out.println("Customer: " + script);
    }

    /**
     * Displays the details of a drink (drink type and brand) to the console.
     *
     * @param drink The {@link Drink} object containing the drink details to be displayed.
     */
    public void displayDrink(Drink drink) {
        System.out.println(drink.getDrinkType() + ": " + drink.getBrand());
    }

    /**
     * Displays the stock of drinks to the console. The drinks are grouped by {@link DrinkType},
     * and sorted alphabetically by drink type. For each type, the available brands and their respective
     * amounts and prices are displayed.
     *
     * @param drinks A list of {@link Drink} objects representing the stock of drinks.
     *               The list is copied and sorted without modifying the original.
     */
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
            System.out.println("    " + drink.getAmount() + " unit of " + drink.getBrand() + "- price: " + drink.getPrice() + "/unit");
        }
    }

    /**
     * Displays a list of actions performed by the bartender. The actions are numbered.
     *
     * @param bartenderName The name of the bartender.
     * @param actions An array of strings representing the bartender's actions.
     */
    public void displayBartenderActions(String bartenderName, String[] actions) {
        System.out.println(bartenderName + " actions: ");
        for (int i = 1; i <= actions.length; i++) {
            System.out.println(i + ": " + actions[i - 1]);
        }
    }

    /**
     * Displays the number of customers remaining in the pub and their names if provided.
     *
     * @param numberOfCustomers The number of customers in the pub.
     * @param customerNames     An optional array of customer names. If null, names are not displayed.
     */
    public void displayRemainingCustomers(int numberOfCustomers, String[] customerNames) {
        System.out.println("There are " + numberOfCustomers + " in the pub");
        if (customerNames != null) {
            System.out.println("Customers in line: ");
            for (int i = 1; i <= customerNames.length; i++) {
                System.out.println(i + ": " + customerNames[i - 1]);
            }
        }
    }

    /**
     * Displays the number of customers remaining in the pub.
     *
     * @param numberOfCustomers The number of customers in the pub.
     */
    public void displayRemainingCustomers(int numberOfCustomers) {
        displayRemainingCustomers(numberOfCustomers, null);
    }
}

package com.codecool.virtualpub.ui;

import com.codecool.virtualpub.data.*;

import java.util.*;

public class Display {

    /**
     * Displays a message to the console.
     *
     * @param message The message to be displayed.
     */
    public void displayMessage(String message) {
        System.out.print(message);
    }

    /**
     * Displays the bartender's script to the console.
     *
     * @param script The {@link BartenderScript} object containing the script to be displayed.
     * @param index  The index of the script to be displayed from the list of bartender scripts.
     */
    public void displayScript(BartenderScript script, int index) {
        try{
            displayMessage("\n" + "Bartender: " + script.getScripts().get(index) + "\n");
        } catch (IndexOutOfBoundsException e) {
            displayMessage("\nScript not found");
        }
    }

    /**
     * Displays the customer's script to the console.
     *
     * @param script The {@link CustomerScript} object containing the script to be displayed.
     * @param index  The index of the sentence to be displayed from the list of customer sentences.
     */
    public void displayScript(CustomerScript script, int index) {
        try{
            displayMessage("\n" + "Customer: " + script.getSentences().get(index) + "\n");
        } catch (Exception e) {
            displayMessage("\nScript not found");
        }
    }

    /**
     * Displays the details of a drink (drink type and brand) to the console.
     *
     * @param drink The {@link Drink} object containing the drink details to be displayed.
     */
    public void displayDrink(Drink drink) {
        displayMessage(drink.getDrinkType().getType() + ": " + drink.getBrand());
    }

    /**
     * Displays the stock of drinks to the console. The drinks are grouped by {@link DrinkType}.
     * Each drink type is followed by the available brands, their respective amounts, and the price per unit.
     *
     * @param drinks A list of {@link Drink} objects representing the stock of drinks.
     */
    public void displayStock(List<Drink> drinks) {
        Map<DrinkType, StringBuilder> drinkTypeMap = new HashMap<>();

        for (Drink drink : drinks) {
            StringBuilder stringBuilder = drinkTypeMap.computeIfAbsent(drink.getDrinkType(), drinkType -> new StringBuilder("\n  " + drinkType + ":\n"));

            stringBuilder.append("    ")
                    .append(drink.getAmount())
                    .append(" unit of ")
                    .append(drink.getBrand())
                    .append(" - price: ")
                    .append(drink.getPrice())
                    .append("/unit\n");
        }

        displayMessage("\nStock: ");
        for (StringBuilder stringBuilder : drinkTypeMap.values()) {
            try{
                Thread.sleep(700);
                displayMessage(stringBuilder.toString());
            }catch(InterruptedException e){
                displayMessage("interrupted sleep");
            }
        }
    }

    public void displayProfit(int profit) {
        displayMessage("\nYour profit is " + profit + " Ft");
    }

    /**
     * Displays a list of actions performed by the bartender. The actions are numbered.
     *
     * @param bartenderName The name of the bartender.
     * @param actions An array of strings representing the bartender's actions.
     */
    public void displayBartenderActions(String bartenderName, String[] actions) {
        displayMessage("\n" + bartenderName + "'s actions: ");
        try{
            for (int i = 1; i <= actions.length; i++) {
                displayMessage("\n" + i + ": " + actions[i - 1]);
                Thread.sleep(500);
            }
        }catch (InterruptedException e){
            displayMessage("interrupted sleep");
        }
    }

    /**
     * Displays the available drinks
     *
     * @param drinkNames An array of strings representing the available drinks
     */
    public void displayDrinkName(String[] drinkNames) {
        displayMessage("\n" + "Drinks: ");
        try{
            for (int i = 1; i <= drinkNames.length; i++) {
                displayMessage("\n" + i + ": " + drinkNames[i - 1]);
                Thread.sleep(500);
            }
        }catch (InterruptedException e){
            displayMessage("interrupted sleep");
        }
    }

    /**
     * Displays the number of customers remaining in the pub and their names if provided.
     *
     * @param numberOfCustomers The number of customers in the pub.
     * @param customerNames     An optional array of customer names. If null, names are not displayed.
     */
    public void displayRemainingCustomers(int numberOfCustomers, String[] customerNames) {
        displayMessage("\nThere are " + numberOfCustomers + " customers in the pub\n");
        if (customerNames == null) {
            return;
        }
//        try{
//            Thread.sleep(400);
//        }catch(Exception e){
//            displayMessage("interrupted sleep");
//        }
        displayMessage("Customers in line: ");
        for (int i = 1; i <= customerNames.length; i++) {
            displayMessage("\n" + i + ": " + customerNames[i - 1]);
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

    public void printNextSeparator() {
        System.out.println("__  __ ______  __  __ _______");
        System.out.println("| \\| || ____|  \\ \\/ /   | | ");
        System.out.println("| .`  || __|    .`.`    | | ");
        System.out.println("|_| \\_||_____| /_/\\_\\   |_|  ");
    }
}


package com.codecool.virtualpub.ui;

import com.codecool.virtualpub.data.Bartender;

import java.util.Scanner;

public class Input {
    Display display;
    Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in);
        display = new Display();
    }

    /**
     * Retrieves a line of input from the user.
     *
     * @return A String representing the user's input from the console.
     */
    private String getInput() {
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("q")) {
            display.displayMessage("Quitting the game. Goodbye!");
            System.exit(0);  // Exit the program
        }
        return input;
    }

    /**
     * Prompts the user to select an action by choosing from the provided list of actions.
     * The input is validated to ensure it is a valid choice (within range).
     * If the input is invalid, an error message is displayed and the user is prompted again.
     *
     * @param bartender The Bartender object representing the current bartender interaction.
     * @param actions   A String array containing the available actions the user can choose from.
     * @return An integer representing the user's selected action from the list.
     */
    private int getChoice(Bartender bartender, String[] actions) { // use this for all as a more
        while (true) {
            try {
                display.displayMessage("\n\nEnter choice:  \n");
                int input = Integer.parseInt(getInput());
                if (input > actions.length || input < 1) {
                    throw new Exception();
                }
                return input;
            } catch (Exception e) {
                display.displayMessage("\nNot a correct choice!");
            }
        }
    }

    /**
     * Prompts the user to choose from a list of actions related to the bartender's interaction.
     * The available actions are displayed based on the bartender's name and the provided list of actions.
     * The method handles user input and returns a valid action choice.
     *
     * @param bartender The Bartender object representing the current interaction with the bartender.
     * @param actions   A String array of actions that the user can select from.
     * @return An integer representing the index of the user's selected action from the list.
     */
    public int getActionChoice(Bartender bartender, String[] actions) {
        display.displayBartenderActions(bartender.getName(), actions);
        display.displayMessage("\n\nChoose an action: \n");
        return getChoice(bartender, actions);
    }

    /**
     * Prompts the user to choose from a list of available drinks related to the bartender's interaction.
     * The available drinks are displayed based on the bartender's name and the provided list of drinks.
     * The method handles user input and returns a valid drink choice.
     *
     * @param bartender The Bartender object representing the current interaction with the bartender.
     * @param drinks    A String array of available drink options that the user can select from.
     * @return An integer representing the index of the user's selected drink from the list.
     */
    public int getDrinkChoice(Bartender bartender, String[] drinks) {
        display.displayDrinkName(drinks);
        display.displayMessage("\n\nChoose a drink: \n");
        return getChoice(bartender, drinks);
    }

    /**
     * Prompts the user to enter their name, displays the message, and retrieves the input.
     *
     * @return A String representing the user's inputted name.
     */
    public String getName() {
        display.displayMessage("\n\nEnter your name: ");
        return getInput();
    }

    /**
     * Prompts the user to enter a drink amount within a specified range.
     * The method will continuously prompt the user until a valid input is provided.
     *
     * @param max the maximum allowed drink amount
     * @return the valid drink amount entered by the user
     * @throws NumberFormatException if the input is not a valid integer
     */
    public int getDrinkAmount(int max) {
        while (true) {
            try {
                display.displayMessage("\n\nEnter drink amount: \n");
                int amount = Integer.parseInt(getInput());
                if (amount > max || amount < 1) {
                    throw new NumberFormatException("\nInvalid drink amount");
                }
                return amount;
            } catch (NumberFormatException e) {
                display.displayMessage(e.getMessage());
            }
        }
    }

    /**
     * Prompts the user to enter the number of customers.
     * The method will continuously prompt the user until a valid integer is provided.
     *
     * @return the valid number of customers entered by the user
     * @throws NumberFormatException if the input is not a valid integer
     */
    public int getNumberOfCustomers() {
        while (true) {
            try {
                display.displayMessage("\n\nEnter number of Customers: ");
                return Integer.parseInt(getInput());
            } catch (NumberFormatException e) {
                display.displayMessage("\n\nInvalid number of Customers: ");
            }
        }
    }
}

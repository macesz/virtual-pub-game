package com.codecool.virtualpub.logic;

import com.codecool.virtualpub.data.*;
import com.codecool.virtualpub.ui.Display;
import com.codecool.virtualpub.ui.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    private Input input;
    private Display display;
    private  Random rand;

    public Game() {
        input = new Input();
        display = new Display();
        rand = new Random();
    }

    public void run() {
        String bartenderName = input.getName();
        Bartender bartender = new Bartender(bartenderName);
        int numberOfCustomers = input.getNumberOfCustomers();
        ArrayList<Customer> customers = generateCustomers(numberOfCustomers);

        List<Drink> stock = generateDrinks(numberOfCustomers);

       Pub pub = new Pub(stock, customers, bartender);

       GameState state = pub.serveCustomers();

        switch (state) {
            case WIN -> display.displayMessage("You won!" + "profit: " + pub.getProfit());
            case ANGRY -> display.displayMessage("Customer's TOO ANGRY");
            case PASSEDOUT -> display.displayMessage("Customer's PASSED OUT");
            case OUT_OF_DRINKS -> display.displayMessage("Pub's OUT OF DRINKS");
        }
    }

    private ArrayList<Customer> generateCustomers(int numberOfCustomers) {
        ArrayList<Customer> customers = new ArrayList<>();
        for (int i = 0; i < numberOfCustomers; i++) {
            int randomIndex = rand.nextInt(GameData.customerNames.length);
            customers.add(new Customer(GameData.customerNames[randomIndex]));
        }
        return customers;
    }

    private List<Drink> generateDrinks(int numberOfDrinks) {
        List<Drink> stock = new ArrayList<>();
        stock.add(GameData.starterDrink);
        for (int i = 0; i < numberOfDrinks; i++) {
            int randomIndex = rand.nextInt(GameData.drinks.size());
            stock.add(new Drink(GameData.drinks.get(randomIndex)));
        }
        return stock;
    }
}

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

        // todo kerd be a jatekostol a nevet

        List<Drink> stock = generateDrinks(numberOfCustomers);
        // todo create stock

       Pub pub = new Pub(stock, customers, bartender);

       GameState state = pub.serveCustomers();

        switch (state) {
            case WIN -> display.displayMessage("You win!" + "profit: " + pub.getProfit());
            case ANGRY -> display.displayMessage("Customer ANGRY");
            case PASSEDOUT -> display.displayMessage("Customer PASSEDOUT");
        }
    }

    private ArrayList<Customer> generateCustomers(int numberOfCustomers) {
        ArrayList<Customer> customers = new ArrayList<>();
        for (int i = 0; i < numberOfCustomers; i++) {
            int randomIndex = rand.nextInt(GameData.DATA.getCustomerNames().length);
            customers.add(new Customer(GameData.DATA.getCustomerNames()[randomIndex]));
        }
        return customers;
    }

    private List<Drink> generateDrinks(int numberOfDrinks) {
        List<Drink> stock = new ArrayList<>();
        for (int i = 0; i < numberOfDrinks; i++) {
            int randomIndex = rand.nextInt(GameData.DATA.getDrinks().size());
            Drink drink = GameData.DATA.getDrinks().get(randomIndex);
            Drink newDrink = new Drink(drink.getBrand(), drink.getDrinkType(), drink.getPrice());
            stock.add(newDrink);
        }
        return stock;
    }
}

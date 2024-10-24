package com.codecool.virtualpub.logic;

import com.codecool.virtualpub.data.*;
import com.codecool.virtualpub.ui.Display;
import com.codecool.virtualpub.ui.Input;

import java.util.ArrayList;
import java.util.List;


public class Pub {
    private List<Drink> stock;
    private List<Customer> customers;
    private Bartender bartender;
    private int profit;
    private Display display;
    private Input input;

    public Pub(List<Drink> stock, ArrayList<Customer> customers, Bartender bartender) {
        this.stock = new ArrayList<>(stock);
        this.customers = new ArrayList<>(customers);
        this.bartender = bartender;
        this.profit = 0;
        this.display = new Display();
        this.input = new Input();
    }

    public ArrayList<String> getStock() {
        ArrayList<String> drinkBrands = new ArrayList<>();
        for (Drink drink : stock) {
            drinkBrands.add(drink.getBrand());
        }
        return drinkBrands;
    }

    public Customer getNextCustomer() {
        if (!customers.isEmpty()) {
            return customers.getFirst();  // Get the first customer in the list
        }
        return null;
    }

    public void removeCustomer(Customer customer) {
        this.customers.remove(customer);
    }

    public void sendToEndOfLine(Customer customer) {
        removeCustomer(customer);
        this.customers.add(customer);
    }

    public int getProfit() {
        return profit;
    }

    public GameState serveCustomers() {
        GameState state = GameState.INGAME;

        while (state == GameState.INGAME) {
            Customer customer = getNextCustomer();
            this.bartender.welcome();

            //display(customer.speak());
            // todo shouldn't do angry or happy script
            customer.speak();

            while(true) {
                Action action = bartender.getAction();
                doAction(action, customer);
                if (action == Action.POUR || action == Action.REFUSE) {
                    break;
                }
            }
            moveCustomer(customer);
            state = getGameState(state, customer);
        }
        return state;
    }

    private void doAction(Action action, Customer customer) {
        switch (action) {
            case Action.POUR:
                serve(customer);
                break;
            case Action.REFUSE:
                refuse(customer);
                break;
            case Action.CHECK_STORAGE:
                checkStock();
                break;
            case Action.CHECK_CUSTOMERS:
                checkCustomers();
                break;
        }
    }

    private GameState getGameState(GameState state, Customer customer) {
        if (stock.isEmpty()) {
            state = GameState.WIN;
        }

        if (customer.isAngry()) {
            state = GameState.ANGRY;
        }

        if (customer.isPassedOut()) {
            state = GameState.PASSEDOUT;
        }

        if (stock.stream().allMatch(drink -> drink.getAmount() == 0)) {
            state = GameState.OUT_OF_DRINKS;
        }
        return state;
    }

    private void moveCustomer(Customer customer) {
        if (customer.isHappy()) {
            // todo happy speak
            removeCustomer(customer);
        } else {
            sendToEndOfLine(customer);
        }
    }

    private void checkCustomers() {
        display.displayRemainingCustomers(customers.size());
    }

    private void checkStock() {
        display.displayStock(stock);
    }

    private void refuse(Customer customer) {
        bartender.refuse();
        // todo angry speak
        customer.drinkRefused();
    }

    private void serve(Customer customer) {
        Drink drink = this.bartender.getDrink(stock);
        int drinkAmount = this.bartender.getDrinkAmount(drink.getAmount());
        bartender.thanks();
        pour(drink, drinkAmount);
        customer.drink(drink, drinkAmount);
    }

    private void pour(Drink drink, int amount) {
        drink.setAmount(drink.getAmount() - amount);
        profit += drink.getPrice() * amount;
    }
}

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
    private Display display = new Display();
    private Input input = new Input();

    public Pub(List<Drink> stock, ArrayList<Customer> customers, Bartender bartender) {
        this.stock = new ArrayList<>(stock);
        this.customers = new ArrayList<>(customers);
        this.bartender = bartender;
        this.profit = 0;
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

            // todo shouldn't do angry or happy script
            customer.speak();

            // 1. pour 2. refuse 3. check stock 4. check customers
            // bekerjuk a bartenderen keresytul a console bol hogy mit es mennyit akarunk tolteni
            while(true) {
                // todo get action from console
                int action = input.getInteger(4);
                doAction(action, customer);
                if (action == 1 || action == 2) {
                    break;
                }
            }
            moveCustomer(customer);
            state = getGameState(state, customer);
        }
        return state;
    }

    private void doAction(int action, Customer customer) {
        switch (action) {
            case 1:
                serve(customer);
                break;
            case 2:
                refuse(customer);
                break;
            case 3:
                checkStock();
                break;
            case 4:
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
        int drinkAmount = this.bartender.getDrinkAmount();
        bartender.thanks();
        pour(drink, drinkAmount);
        customer.drink(drink, drinkAmount);
    }

    private void pour(Drink drink, int amount) {
        drink.setAmount(drink.getAmount() - amount);
        profit += drink.getPrice() * amount;
    }
}

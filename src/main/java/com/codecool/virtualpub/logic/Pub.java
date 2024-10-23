package com.codecool.virtualpub.logic;

import com.codecool.virtualpub.data.*;

import java.util.ArrayList;
import java.util.List;


public class Pub {
    private List<Drink> stock;
    private List<Customer> customers;
    private Bartender bartender;
    private int profit;

    public Pub(ArrayList<Drink> stock, ArrayList<Customer> customers, Bartender bartender) {
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

          //  display(customer.speak());

            // bekerjuk a bartenderen keresytul a console bol hogy mit es mennyit akarunk tolteni
            Drink drink = this.bartender.getDrink(stock);
            int drinkAmount = this.bartender.getDrinkAmount();

            pour(drink, drinkAmount);

            customer.drink(drink, drinkAmount);

            if (customer.isHappy()) {
                state = GameState.WIN;
            }

            if (customer.isAngry()) {
                state = GameState.ANGRY;
            }

            if (customer.isPassedOut()) {
                state = GameState.PASSEDOUT;
            }
        }

        return state;
    }

    private void pour(Drink drink, int amount) {
        drink.setAmount(drink.getAmount() - amount);
        profit += drink.getPrice() * amount;
    }
}

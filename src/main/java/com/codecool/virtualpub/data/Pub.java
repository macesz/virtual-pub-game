package com.codecool.virtualpub.data;

import java.util.ArrayList;

public class Pub {
    private ArrayList<Drink> stock;
    private ArrayList<Customer> customers;
    private Bartender bartender;
    private int profit;

    public Pub(ArrayList<Drink> stock, ArrayList<Customer> customers, Bartender bartender) {
        this.stock = stock;
        this.customers = customers;
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

    public int getNumberOfCustomers() {
        return customers.size();
    }

    public Customer getNextCustomer() {
        return customers.getFirst();
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

    public Bartender getBartender() {
        return bartender;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }
}

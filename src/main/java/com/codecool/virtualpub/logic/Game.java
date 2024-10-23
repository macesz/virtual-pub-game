package com.codecool.virtualpub.logic;

import com.codecool.virtualpub.data.Bartender;
import com.codecool.virtualpub.data.Customer;
import com.codecool.virtualpub.data.Drink;
import com.codecool.virtualpub.data.GameState;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public void Game() {
        ArrayList<Customer> customers = new ArrayList<Customer>();

        for (int i = 0; i < 10; i++) {
            String name = "random bela";
            customers.add(new Customer(name));
        }

        // todo kerd be a jatekostol a nevet
        Bartender bartender = new Bartender("joe");

        List<Drink> stock = new ArrayList<Drink>();
        // todo create stock

        Pub pub = new Pub(stock, customers, bartender);

        GameState state = pub.serveCustomers();

        switch (state) {
            case WIN -> System.out.println("You win!");
            case ANGRY -> System.out.println("Customer ANGRY");
            case PASSEDOUT -> System.out.println("Customer PASSEDOUT");
        }
    }
}

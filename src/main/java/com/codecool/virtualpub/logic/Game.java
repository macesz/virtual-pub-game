package com.codecool.virtualpub.logic;

import com.codecool.virtualpub.data.Bartender;
import com.codecool.virtualpub.data.Customer;
import com.codecool.virtualpub.data.Drink;
import com.codecool.virtualpub.data.GameState;
import com.codecool.virtualpub.ui.Display;

import java.util.ArrayList;

public class Game {
    public void Game() {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        Display display = new Display();
// BECOUSE of the dependency injection here i ONLY CRETAE ONE OBJECT
        //  not objects of every costumer => less memory usage
        for (int i = 0; i < 10; i++) {
            String name = "random bela";
            customers.add(new Customer(name, display));
        }

        // todo kerd be a jatekostol a nevet
        Bartender bartender = new Bartender("joe");

        ArrayList<Drink> stock = new ArrayList<Drink>();
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

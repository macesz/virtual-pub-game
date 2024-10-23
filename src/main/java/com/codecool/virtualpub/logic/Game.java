package com.codecool.virtualpub.logic;

import com.codecool.virtualpub.data.*;
import com.codecool.virtualpub.ui.Display;
import com.codecool.virtualpub.ui.Input;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Input input = new Input();
    private Display display = new Display();

    public void run() {
        ArrayList<Customer> customers = new ArrayList<Customer>();

        generateCustomers(customers);

        // todo kerd be a jatekostol a nevet
        Bartender bartender = new Bartender("Feri");

        List<Drink> stock = new ArrayList<Drink>();
        // todo create stock
        loadDrinks(stock);

       Pub pub = new Pub(stock, customers, bartender);

       GameState state = pub.serveCustomers();

        switch (state) {
            case WIN -> display.displayMessage("You win!" + "profit: " + pub.getProfit());
            case ANGRY -> display.displayMessage("Customer ANGRY");
            case PASSEDOUT -> display.displayMessage("Customer PASSEDOUT");
        }
    }

    private static void generateCustomers(ArrayList<Customer> customers) {
        for (int i = 0; i < 10; i++) {
            String name = "random bela" + i;
            customers.add(new Customer(name));
        }
    }

    private void loadDrinks(List<Drink> stock) {
        // Add WINE drinks (common Hungarian brands)
        stock.add(new Drink("Tokaji Aszú", DrinkType.WINE, 1990));
        stock.add(new Drink("Egri Bikavér", DrinkType.WINE, 1490));
        stock.add(new Drink("Villányi Cabernet Franc", DrinkType.WINE, 1790));

        // Add BEER drinks (common Hungarian brands)
        stock.add(new Drink("Dreher", DrinkType.BEER, 1000));
        stock.add(new Drink("Soproni", DrinkType.BEER, 900));
        stock.add(new Drink("Borsodi", DrinkType.BEER, 850));

        // Add WHISKEY drinks (common international brands available in Hungary)
        stock.add(new Drink("Johnnie Walker", DrinkType.WHISKEY, 990));
        stock.add(new Drink("Jameson", DrinkType.WHISKEY, 1000));
        stock.add(new Drink("Ballantine's", DrinkType.WHISKEY, 850));

        // Add VODKA drinks (common international brands available in Hungary)
        stock.add(new Drink("Absolut", DrinkType.VODKA, 800));
        stock.add(new Drink("Finlandia", DrinkType.VODKA, 850));
        stock.add(new Drink("Russian Standard", DrinkType.VODKA, 900));

        // Add RUM drinks (common international brands available in Hungary)
        stock.add(new Drink("Captain Morgan", DrinkType.RUM, 1100));
        stock.add(new Drink("Bacardi", DrinkType.RUM, 1090));
        stock.add(new Drink("Havana Club", DrinkType.RUM, 1200));

        // Add TEQUILA drinks (common international brands available in Hungary)
        stock.add(new Drink("Patrón", DrinkType.TEQUILA, 1990));
        stock.add(new Drink("Olmeca", DrinkType.TEQUILA, 1650));
        stock.add(new Drink("Jose Cuervo", DrinkType.TEQUILA, 1490));

        // Add GIN drinks (common international brands available in Hungary)
        stock.add(new Drink("Bombay Sapphire", DrinkType.GIN, 1350));
        stock.add(new Drink("Beefeater", DrinkType.GIN, 1200));
        stock.add(new Drink("Hendrick's", DrinkType.GIN, 1390));

        // Add LIQUOR drinks (common international brands available in Hungary)
        stock.add(new Drink("Unicum", DrinkType.LIQUOR, 900));  // Hungarian liquor
        stock.add(new Drink("Baileys", DrinkType.LIQUOR, 1100));
        stock.add(new Drink("Kahlua", DrinkType.LIQUOR, 1050));
    }
}

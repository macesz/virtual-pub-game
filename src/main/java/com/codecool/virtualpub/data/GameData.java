package com.codecool.virtualpub.data;

import java.util.ArrayList;
import java.util.List;

public class GameData {
    public static final String[] customerNames = new String[]{
        "Alexander", "Benjamin", "Charlotte", "Daniel", "Emma",
        "Fiona", "Gabriel", "Hannah", "Isaac", "Julia",
        "Kevin", "Lucy", "Matthew", "Nora", "Oliver",
        "Penelope", "Quinn", "Ryan", "Sophia", "Thomas",
        "Abigail", "Brian", "Chloe", "David", "Evelyn",
        "Grace", "Henry", "Isabella", "Jack", "Katherine",
        "Liam", "Mia", "Nathan", "Olivia", "Peter",
        "Rebecca", "Samuel", "Tyler", "Victoria", "William",
        "Zoe", "Avery", "Blake", "Caleb", "Delilah",
        "Elijah", "Faith", "George", "Ivy", "Jackson"
    };
   public static final List<Drink> drinks = List.of(
        // WINE drinks
        new Drink("Tokaji Aszú", DrinkType.WINE, 1990),
        new Drink("Egri Bikavér", DrinkType.WINE, 1490),
        new Drink("Villányi Cabernet Franc", DrinkType.WINE, 1790),

        // BEER drinks
        new Drink("Dreher", DrinkType.BEER, 1000),
        new Drink("Soproni", DrinkType.BEER, 900),
        new Drink("Borsodi", DrinkType.BEER, 850),

        // WHISKEY drinks
        new Drink("Johnnie Walker", DrinkType.WHISKEY, 990),
        new Drink("Jameson", DrinkType.WHISKEY, 1000),
        new Drink("Ballantine's", DrinkType.WHISKEY, 850),

        // VODKA drinks
        new Drink("Absolut", DrinkType.VODKA, 800),
        new Drink("Finlandia", DrinkType.VODKA, 850),
        new Drink("Russian Standard", DrinkType.VODKA, 900),

        // RUM drinks
        new Drink("Captain Morgan", DrinkType.RUM, 1100),
        new Drink("Bacardi", DrinkType.RUM, 1090),
        new Drink("Havana Club", DrinkType.RUM, 1200),

        // TEQUILA drinks
        new Drink("Patrón", DrinkType.TEQUILA, 1990),
        new Drink("Olmeca", DrinkType.TEQUILA, 1650),
        new Drink("Jose Cuervo", DrinkType.TEQUILA, 1490),

        // GIN drinks
        new Drink("Bombay Sapphire", DrinkType.GIN, 1350),
        new Drink("Beefeater", DrinkType.GIN, 1200),
        new Drink("Hendrick's", DrinkType.GIN, 1390),

        // LIQUOR drinks
        new Drink("Unicum", DrinkType.LIQUOR, 900),  // Hungarian liquor
        new Drink("Baileys", DrinkType.LIQUOR, 1100),
        new Drink("Kahlua", DrinkType.LIQUOR, 1050)
    );
    public static final Drink starterDrink = new Drink("Kőbányai", DrinkType.BEER, 600);


}

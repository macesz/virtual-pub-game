package com.codecool.virtualpub.data;

public enum DrinkTypes {
    WINE("wine", 12, 12),
    BEER("beer", 1, 5),
    WHISKEY("whiskey", 15, 40),
    VODKA("vodka", 15, 40),
    RUM("rum", 15, 37),
    TEQUILA("tequila", 15, 38),
    GIN("gin", 15, 45),
    LIQUOR("liquor", 15, 20),;

    private final String type;
    private final int amountOfPours;
    private final int alcoholLevel;

    DrinkTypes(String type, int amountOfPours, int alcoholLevel) {
        this.type = type;
        this.amountOfPours = amountOfPours;
        this.alcoholLevel = alcoholLevel;
    }

}

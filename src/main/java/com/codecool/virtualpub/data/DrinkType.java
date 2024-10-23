package com.codecool.virtualpub.data;

public enum DrinkType {
    WINE("wine", 12, 12, 15),
    BEER("beer", 30, 5,10),
    WHISKEY("whiskey", 15, 40,15),
    VODKA("vodka", 15, 40,15),
    RUM("rum", 15, 37,15),
    TEQUILA("tequila", 15, 38,15),
    GIN("gin", 15, 45,15),
    LIQUOR("liquor", 15, 20,15),;

    private final String type;
    private final int amountOfPours;
    private final int alcoholLevel;
    private final int brainDamage;

    DrinkType(String type, int amountOfPours, int alcoholLevel, int brainDamage) {
        this.type = type;
        this.amountOfPours = amountOfPours;
        this.alcoholLevel = alcoholLevel;
        this.brainDamage = brainDamage;
    }

    public String getType() {
        return type;
    }

    public int getAmountOfPours() {
        return amountOfPours;
    }

    public int getAlcoholLevel() {
        return alcoholLevel;
    }

    public int getBrainDamage() {
        return brainDamage;
    }
}

package com.codecool.virtualpub.data;

public enum DrinkType {
    WINE("wine", 4, 12, 15),
    BEER("beer", 10, 5,10),
    WHISKEY("whiskey", 3, 40,15),
    VODKA("vodka", 3, 40,15),
    RUM("rum", 3, 37,15),
    TEQUILA("tequila", 3, 38,15),
    GIN("gin", 3, 45,15),
    LIQUOR("liquor", 3, 20,15),;

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

package com.codecool.virtualpub.data;

public enum DrinkType {
    WINE("wine", 8, 12, 7),
    BEER("beer", 12, 5,5),
    WHISKEY("whiskey", 7, 40,8),
    VODKA("vodka", 7, 40,8),
    RUM("rum", 7, 37,9),
    TEQUILA("tequila", 7, 38,10),
    GIN("gin", 7, 45,8),
    LIQUOR("liquor", 7, 20,9),;

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

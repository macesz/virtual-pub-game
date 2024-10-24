package com.codecool.virtualpub.data;

import java.util.Random;

public class Bartender {
    private String name;
    private final Random random;

    public Bartender(String playerName) {
        this.name = playerName;
        this.random = new Random();
    }
    
    public DrinkType getDrinkType() {
        // todo get from player in console
        return DrinkType.values()[random.nextInt(DrinkType.values().length)];
    }

    public Action[] getActions() {
    // todo get from player in console
    return Action.values();
    }

    public int getDrinkAmount() {
        // todo get from player in console
        return 1;
    }

    public String getName() {
        return name;
    }

    public void welcome() {
        int idx = random.nextInt(4);
        String welcome = BartenderScript.WELCOME.getScripts().get(idx);
        welcome = "Hello I'm " + name + ". " + welcome;
        System.out.println(welcome);
    }
}

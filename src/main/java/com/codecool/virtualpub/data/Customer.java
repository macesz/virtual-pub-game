package com.codecool.virtualpub.data;

import com.codecool.virtualpub.ui.Display;

import java.util.List;
import java.util.Random;

public class Customer {
    private final String name;
    private int sweatSpotMin;
    private int sweatSpotMax;
    private int alcoholTolerance;
    private int alcoholLevel;
    private int refuseCount;
    private String[] sentences;
    private final Random random;


    public Customer(String name) {
        this.name = name;

        this.random = new Random();
        this.alcoholTolerance = random.nextInt(100 + 1 - 50) + 50;

        this.generateSweatSpots();
        this.alcoholLevel = 0;
        this.refuseCount = 0;
    }

    private void generateSweatSpots() {
        int sweetPercental = random.nextInt(90 + 1 - 70) + 70;
        this.sweatSpotMax = this.alcoholTolerance / 100 * sweetPercental;
        int range = random.nextInt(10 + 1 - 5) + 5;
        this.sweatSpotMin = this.sweatSpotMax - range;
    }

    public String getName() {
        return name;
    }

    public void drink(Drink drink, int amount) {
        if (amount == 0) {
            drinkRefused();
            return;
        }

        this.alcoholLevel += drink.getDrinkType().getBrainDamage() * amount;
    }

    public void speak() {
        CustomerScript currentMood = getMood();  // Determine mood
        int idx = random.nextInt(currentMood.getSentences().size());  // Get random sentence
        Display display = new Display();
        display.displayScript(currentMood, idx);
    }

    private CustomerScript getMood() {
        // todo refactor (switch case)
        if (this.alcoholLevel > this.alcoholTolerance) {
            return CustomerScript.DRUNK;
        } else if (isHappy()) {
            return CustomerScript.HAPPY;
        } else if (isAngry()) {
            return CustomerScript.ANGRY;
        } else {
            return CustomerScript.SOBER;
        }
    }

    private void drinkRefused() {
        this.refuseCount++;
        this.alcoholLevel -= 10;
        if (this.alcoholLevel < 0) {
            this.alcoholLevel = 0;
        }
    }


    public boolean isHappy() {
        return this.alcoholLevel <= this.sweatSpotMax && this.alcoholLevel >= this.sweatSpotMin;
    }

    public boolean isAngry() {
        return this.alcoholLevel > this.sweatSpotMax || this.refuseCount > 3;
    }

    public boolean isPassedOut() {
        return this.alcoholLevel >= this.alcoholTolerance;
    }
}


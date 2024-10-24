package com.codecool.virtualpub.data;

import com.codecool.virtualpub.ui.Display;

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
        int sweetPercentage = random.nextInt(21) + 70;
        this.sweatSpotMax = (int) (this.alcoholTolerance * (sweetPercentage / 100.0));
        int range = random.nextInt(6) + 5;
        this.sweatSpotMin = this.sweatSpotMax - range;
    }

    public String getName() {
        return name;
    }

    public void drink(Drink drink, int amount) {

        this.alcoholLevel += drink.getDrinkType().getBrainDamage() * amount;
    }

    // todo

    public void speak() {
        CustomerScript currentMood = getMood();  // Determine mood
        int idx = random.nextInt(currentMood.getSentences().size());  // Get random sentence
        Display display = new Display();
        display.displayScript(currentMood, idx);
    }

    private CustomerScript getMood() {
        if (isDrunk()) {
            return CustomerScript.DRUNK;
        } else if (isTipsy()) {
            return CustomerScript.TIPSY;
        } else if (isHappy()) {
            return CustomerScript.HAPPY;
        } else if (refuseCount == 1) {
            return CustomerScript.ANGRY1;
        } else if (refuseCount == 2) {
            return CustomerScript.ANGRY1;
        } else if (refuseCount == 3) {
            return CustomerScript.ANGRY1;
        } else {
            return CustomerScript.SOBER;
        }
    }

    public void drinkRefused() {
        // todo angry speak
        this.refuseCount++;
        speak();
        this.alcoholLevel -= 10;
        if (this.alcoholLevel < 0) {
            this.alcoholLevel = 0;
        }
    }


    // todo refactor
    public boolean isHappy() {
        return this.alcoholLevel <= this.sweatSpotMax && this.alcoholLevel >= this.sweatSpotMin;
    }

    public boolean isTipsy() {
        return this.alcoholLevel > 15;
    }

    public boolean isDrunk() {
        return this.alcoholLevel > this.alcoholTolerance;
    }

    public boolean isAngry() {

        return this.refuseCount > 0;
    }

    public boolean isPassedOut() {
        return this.alcoholLevel >= this.alcoholTolerance;
    }
}


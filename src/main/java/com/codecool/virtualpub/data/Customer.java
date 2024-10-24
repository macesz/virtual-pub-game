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
    private static final int MIN_PERCENTAGE = 70;
    private static final int MAX_PERCENTAGE = 90;  // MAX_PERCENTAGE is 70 + 21 - 1 = 90
    private static final int PERCENTAGE_DIVISOR = 100;

    private static final int MIN_RANGE = 5;
    private static final int MAX_RANGE = 10;


    public Customer(String name) {
        this.name = name;

        this.random = new Random();
        this.alcoholTolerance = random.nextInt(100 + 1 - 50) + 50;

        this.generateSweatSpots();
        this.alcoholLevel = 0;
        this.refuseCount = 0;
    }

    private void generateSweatSpots() {
        int sweetPercentage = random.nextInt((MAX_PERCENTAGE - MIN_PERCENTAGE + 1)) + MIN_PERCENTAGE;
        this.sweatSpotMax = (int) (this.alcoholTolerance * (sweetPercentage / (double) PERCENTAGE_DIVISOR));
        int range = random.nextInt((MAX_RANGE - MIN_RANGE + 1)) + MIN_RANGE;
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
            return CustomerScript.ANGRY2;
        } else if (refuseCount == 3) {
        } else if (isAngry()) {
            return CustomerScript.ANGRY3;
        }
        return CustomerScript.SOBER;
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


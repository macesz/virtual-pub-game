package com.codecool.virtualpub.data;

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
//        this.sentences = this.generateSentences();
    }

    private String[] generateSentences() {

    }

    public String getName() {
        return name;
    }

    public void drink(DrinkType drinkType, int amount) {
        if (amount == 0) {
            drinkRefused();
            return;
        }

        this.alcoholLevel += drinkType.getAlcoholLevel() * amount;
    }

    public String speak() {
        CustomerScript currentMood = getMood();  // Determine mood
        List<String> sentences = currentMood.getSentences();
        int idx = random.nextInt(sentences.size());  // Get random sentence
        return sentences.get(idx);
    }

    private CustomerScript getMood() {
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


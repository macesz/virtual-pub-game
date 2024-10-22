package com.codecool.virtualpub.data;

import java.util.Random;

public class Cutomer {
    private final String name;
    private int sweatSpotMin;
    private int sweatSpotMax;
    private int alcoholTolerance;
    private int alcoholLevel;
    private int refuseCount;
    private String[] sentences;

    public Cutomer(String name) {
        this.name = name;

        Random random = new Random();
        this.alcoholTolerance = random.nextInt(100 + 1 - 50) + 50;

        this.generateSweatSpots();

        this.alcoholLevel = 0;
        this.refuseCount = 0;
    }

    private void generateSweatSpots() {
        Random random = new Random();

        int sweetPercental = random.nextInt(90 + 1 - 70) + 70;
        this.sweatSpotMax = this.alcoholTolerance / 100 * sweetPrecental;
        int range = random.nextInt(10 + 1 - 5) + 5;
        this.sweatSpotMin = this.sweatSpotMax - range;
        this.sentences = this.generateSentences();
    }

    private String[] generateSentences() {
        return new String[]{
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                "Nunc sed magna risus.",
                "Vivamus imperdiet metus maximus arcu faucibus, eu rhoncus dui condimentum.",
                "Interdum et malesuada fames ac ante ipsum primis in faucibus.",
                "Nam nec odio sed leo euismod sollicitudin sit amet id magna.",
                "Nullam vehicula ex id lobortis convallis.",
                "Maecenas dapibus a sapien et gravida.",
                "Mauris mattis aliquam nisi, et tincidunt elit consequat in.",
                "Quisque a blandit purus.",
                "Sed pretium enim lorem, non fringilla sapien fermentum ut.",
        };
    }

    public String getName() {
        return name;
    }

    public void Drink(int alcoholUnit) {
        if (alcoholUnit == 0) {
            drinkRefused();
            return;
        }

        this.alcoholLevel += alcoholUnit;
    }

    public String Speak() {
        Random random = new Random();
        int idx = random.nextInt(0, this.sentences.length);
        String sentence = this.sentences[idx];

        // todo change rand chars according to the this.alcoholLevel

        return sentence;
    }

    private void drinkRefused() {
        this.refuseCount++;
        this.alcoholLevel -= 10;
        if (this.alcoholLevel < 0) {
            this.alcoholLevel = 0;
        }
    }


    public boolean IsHappy() {
        return this.alcoholLevel <= this.sweatSpotMax && this.alcoholLevel >= this.sweatSpotMin;
    }

    public boolean IsAngry() {
        return this.alcoholLevel > this.sweatSpotMax || this.refuseCount > 3;
    }

    public boolean isPassedOut() {
        return this.alcoholLevel >= this.alcoholTolerance;
    }
}


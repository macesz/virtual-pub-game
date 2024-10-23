package com.codecool.virtualpub.data;

import com.codecool.virtualpub.ui.Display;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bartender {
    private String name;
    private final Random random;

    public Bartender(String playerName) {
        this.name = playerName;
        this.random = new Random();
    }
    
    public Drink getDrink(List<Drink> drinks) {
        // todo get from player in console
        while (true) {
            try{
                // todo getInput()
                return drinks.get(random.nextInt(drinks.size()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int getDrinkAmount() {
        // todo get from player in console
        return 1;
    }

    private void speak(BartenderScript script) {
        int idx = random.nextInt(script.getScripts().size());  // Get random sentence
        Display display = new Display();
        display.displayScript(script, idx);
    }

    public void welcome() {
       speak(BartenderScript.WELCOME);
    }

    public void refuse() {
        speak(BartenderScript.REFUSE_SERVICE);
    }

    public void thanks() {
        speak(BartenderScript.THANK_YOU);
    }
}

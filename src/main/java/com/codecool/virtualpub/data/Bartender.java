package com.codecool.virtualpub.data;

import com.codecool.virtualpub.ui.Display;
import com.codecool.virtualpub.ui.Input;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Bartender {
    private String name;
    private final Random random;
    private Input input = new Input();

    public Bartender(String playerName) {
        this.name = playerName;
        this.random = new Random();
    }
    
    public Drink getDrink(List<Drink> drinks) {
        String[] drinkNames = drinks.stream().map(Drink::getBrand).toArray(String[]::new);
        int drinkIndex = input.getDrinkChoice(this, drinkNames);
        return drinks.get(drinkIndex - 1);
    }

    public Action getAction() {
        int index = input.getActionChoice(this, Arrays.stream(Action.values()).map(Action::getAction).toArray(String[]::new));
        return Action.values()[index - 1];
    }

    public int getDrinkAmount(int max) {
        return input.getDrinkAmount(max);
    }

    public String getName() {
        return name;
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

package com.codecool.virtualpub.data;

import java.util.Arrays;
import java.util.List;

public enum BartenderScript {
    // Welcome phrases
    WELCOME(Arrays.asList(
            "Hey there! Welcome, what can I get for you today?",
            "Good evening! What would you like to drink?",
            "Hi! How's it going? Ready for your first drink?"
    )),

    // Asking what the customer wants to drink
    ASK_FOR_DRINK(Arrays.asList(
            "What can I get started for you?",
            "What’ll it be tonight?",
            "Looking for something special or just your usual?"
    )),

    // Thanking the customer
    THANK_YOU(Arrays.asList(
            "Thanks! Enjoy your drink!",
            "Cheers! Let me know if you need anything else.",
            "Appreciate it! Have a great night!"
    ));

    private final List<String> scripts;

    BartenderScript(List<String> scripts) {
        this.scripts = scripts;
    }

    public List<String> getScripts() {
        return scripts;
    }

}


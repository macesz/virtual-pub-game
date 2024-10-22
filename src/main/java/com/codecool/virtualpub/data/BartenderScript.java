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
    REFUSE_SERVICE(Arrays.asList(
            "I’m sorry, but I can’t serve you another drink. It looks like you’ve had enough for tonight.",
            "For your own safety, I think it’s best to stop serving you. How about a glass of water instead?",
            "I’d love to help, but I’m afraid I can’t serve you more alcohol right now."
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


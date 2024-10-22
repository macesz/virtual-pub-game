package com.codecool.virtualpub.data;

import java.util.Arrays;
import java.util.List;

public enum CustomerScript {
    DRUNK(Arrays.asList("Heyyy... oooune mooore rooouuuund, pleeeease... just ooune!",
            "Whoaa... the bar’s spinning, but I need another drink!",
            "You know... when I was younger, I had big dreams...",
            "I wanted to be an astronaut... but then things just got complicated...",
            "I used to have it all, you know... the job, the car, the house...")),
    SOBER(Arrays.asList("Hey! Could I get a cold beer to start?",
            "I’ll have a whiskey, neat, please.",
            "What do you recommend for a good first round?",
            "I’m in the mood for something light — how about a lager?",
            "I’ll take a gin and tonic to kick things off.")),
    HAPPY(Arrays.asList(
            "Let’s go dance! I’m feeling so good!",
            "That was a great night, but I think it’s time to head home.",
            "I’m so glad we came out tonight, but my bed is calling me!",
            "This was exactly what I needed... now I’m ready to head home.",
            "What a perfect evening... let's call it a night and head home.")),
    ANGRY(Arrays.asList("What do you mean I’ve had enough? I’m fine!",
            "I’m not drunk! You don’t know what you’re talking about!",
            "This is ridiculous, just give me my drink!",
            "I paid good money to be here, and now you’re cutting me off?",
            "You’ll regret this... I’ll take my business somewhere else!"));

    private final List<String> sentences;

    // Constructor to initialize the list of sentences for each mood
    CustomerScript(List<String> sentences) {
        this.sentences = sentences;
    }

    // Method to retrieve the list of sentences
    public List<String> getSentences() {
        return sentences;
    }
}



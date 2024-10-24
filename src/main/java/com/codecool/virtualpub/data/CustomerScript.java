package com.codecool.virtualpub.data;

import java.util.Arrays;
import java.util.List;

public enum CustomerScript {
    DRUNK(Arrays.asList(
            "Heyyy... oooune mooore rooouuuund, pleeeease... just ooune!",
            "Whoaa... the bar’s spinning, but I need another drink!",
            "You know... when I was younger, I had big dreams...",
            "I wanted to be an astronaut... but then things just got complicated...",
            "I used to have it all, you know... the job, the car, the house...")),
    SOBER(Arrays.asList(
            "Hey! Could I get a cold beer to start?",
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
    REJECTED(Arrays.asList(
            "What do you mean I’ve had enough? I’m fine!",
            "I’m not drunk! You don’t know what you’re talking about!",
            "This is ridiculous, just give me my drink!",
            "I paid good money to be here, and now you’re cutting me off?",
            "You’ll regret this... I’ll take my business somewhere else!")),
    TIPSY(Arrays.asList(
            "Heyyy… can I get another drink? Something fun, like… I don’t know, surprise me!",
            "I’m feeling gooood… just one more drink, yeah? Maybe something fruity?",
            "How ‘bout another one? Not too strong this time… just enough to keep the buzz going!",
            "Bartender, I’ll have one more… you’re making magic over there, I swear!",
            "Just one more round! I’m fiiine, trust me… make it a light one though!")),
    ANGRY1(Arrays.asList(
            "Why’s it taking so long? I’ve been waiting forever for a simple drink!",
            "Seriously, you call that a pour? What kind of joke is this place?",
            "You’d better fix this or I’m going somewhere else!",
            "All I asked for was a drink! How hard can that be?",
            "This is ridiculous… do your job and get me what I ordered!")),
    ANGRY2(Arrays.asList(
            "What the hell is wrong with you? I asked for a drink 10 minutes ago!",
            "I’m paying good money here, and this is how you treat me? You better fix this now!",
            "You think it’s funny making me wait? I want my damn drink!",
            "Are you ignoring me? I swear, if I don’t get my drink now, I’ll cause a scene!",
            "This service is a joke! Get me my drink or I’m talking to the manager!")),
    ANGRY3(Arrays.asList(
            "This is BS! You’re screwing me over on purpose, aren’t you?",
            "What do I have to do to get a damn drink around here? This is outrageous!",
            "I’m not leaving until I get what I asked for, you hear me? This place is a disgrace!",
            "You think you can treat me like this? I’ll ruin your night if you don’t give me my drink!",
            "I’ve had it with this place! You’re the worst bartender I’ve ever seen. Where’s my drink?!"));


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



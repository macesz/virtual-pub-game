package com.codecool.virtualpub.data;

import java.util.Arrays;
import java.util.List;
// todo ANGRY1, ANGRY2, ANGRY3
// todo TIPSY
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
            "Why are you like this? I’ve been waiting forever for a simple drink! " +
                    "This must be the last time you’ve turned me away!",
            "Seriously, you call yourself a bartender? What kind of joke is this place? " +
                    "This is the first and last time you’ve refused me!",
            "You’d better fix this or I’m going somewhere else! " +
                    "You're cutting me off for no reason!",
            "All I asked for was a drink! How hard can that be? " +
                    "You can tell me no, but I’m not done yet!",
            "This is ridiculous… do your job and get me what I ordered! " +
                    "I never have been rejected before, and I don't like it. " +
                    "I’m not gonna leave empty-handed again!")),
    ANGRY2(Arrays.asList(
            "What the hell is wrong with you? " +
                    "I asked for a drink 10 minutes ago, and this is the second time you’ve turned me down!",
            "I’m paying good money here, and this is how you treat me? " +
                    "You’ve already refused me twice, you better fix this now!",
            "You think it’s funny making me wait? I want my damn drink! " +
                    "This is the second time you’ve refused me!",
            "Are you ignoring me? I swear, if I don’t get my drink now, I’ll cause a scene! " +
                    "You’ve already said no twice, I’m not taking it again!",
            "This service is a joke! Get me my drink or I’m talking to the manager! " +
                    "Twice you’ve rejected me, and I won’t let it happen again!")),
    ANGRY3(Arrays.asList(
            "This is BS! You’re screwing me over on purpose, aren’t you? " +
                    "Three times you’ve turned me down, enough is enough!",
            "What do I have to do to get a damn drink around here? " +
                    "This is outrageous! You’ve refused me three times already!",
            "I’m not leaving until I get what I asked for, you hear me? " +
                    "This place is a disgrace! Three rejections, and I’m done playing nice!",
            "You think you can treat me like this? " +
                    "I’ll ruin your night if you don’t give me my drink! That’s the third time you’ve said no!",
            "I’ve had it with this place! You’re the worst bartender I’ve ever seen. " +
                    "Where’s my drink?! Three times rejected? I’m not standing for it anymore!"));


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



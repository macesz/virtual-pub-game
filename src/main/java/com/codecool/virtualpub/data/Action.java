package com.codecool.virtualpub.data;

public enum Action {
    POUR("Pour"),
    REFUSE("Refuse"),
    CHECK_STORAGE("Check storage"),
    CHECK_CUSTOMERS("Check customers"),;

    private final String action;

    Action(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }
}

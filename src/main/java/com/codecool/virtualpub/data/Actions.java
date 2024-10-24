package com.codecool.virtualpub.data;

public enum Action {
    POUR("pour"),
    REFUSE("refuse"),
    CHECK_STORAGE("check storage"),
    CHECK_CUSTOMERS("check customers"),;

    private final String action;

    Action(String action) {
        this.action = action;
    }

}
package com.codecool.virtualpub.data;

public class Drink {
    private final String brand;
    private final DrinkType drinkType;
    private final int price;
    private int amount;

    public Drink(String brand, DrinkType drinkType, int price) {
        this.brand = brand;
        this.drinkType = drinkType;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public DrinkType getDrinkType() {
        return drinkType;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

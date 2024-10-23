package com.codecool.virtualpub.ui;

import java.util.Scanner;

public class Input {

    private String getInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int getInteger(int max){
        while (true) {
            try {
                int input = Integer.parseInt(getInput());
                if(input > max){
                    throw new Exception();
                }
                return input;
            } catch (Exception e) {
                //("Not a correct number!");
            }
        }
    }
}

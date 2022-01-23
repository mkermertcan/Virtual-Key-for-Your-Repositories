package com.company;


public class Main {


    public static void main(String[] args) {

        MainContext mainContext = new MainContext();
        SecondContext secondContext = new SecondContext();


        int userInput = mainContext.showMainContext();

        if (userInput == 2) {
            int secondInput = secondContext.showSecondContext();
            secondContext.controlSecondUserInput(secondInput, mainContext);
        } else {
            mainContext.controlUserInput(userInput, secondContext);
        }

    }


}

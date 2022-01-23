package com.company;

import java.util.*;

public class MainContext extends Commons {

    public int showMainContext() {
        System.out.println("Welcome to Virtual Key for Your Repositories Application developed by Kamil Ermertcan.");
        System.out.println();
        System.out.println("Please enter 1 to get current file names in ascending order");
        System.out.println("Please enter 2 to get details of the user interface");
        System.out.println("Please enter 3 to close the application");

        return getInput();
    }


    public void controlUserInput(int userInput, SecondContext secondContext) {
        if (userInput == 1) {
            List<String> fileNames = getFileNames();
            Collections.sort(fileNames);
            System.out.println(fileNames);

        } else if (userInput == 2) {
            int secondInput = secondContext.showSecondContext();
            secondContext.controlSecondUserInput(secondInput, this);
        } else if (userInput == 3) {
            System.exit(0);
        } else {
            System.out.println("Please try again");
            userInput = showMainContext();
            controlUserInput(userInput, secondContext);
        }
    }


}

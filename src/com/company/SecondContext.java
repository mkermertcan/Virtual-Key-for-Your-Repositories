package com.company;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class SecondContext extends Commons {

    public int showSecondContext() {
        System.out.println("Please enter 1 to add a file to the existing directory list");
        System.out.println("Please enter 2 to delete a user specified file from the existing directory list");
        System.out.println("Please enter 3 to search a user specified file from the main directory");
        System.out.println("Please enter 0 to navigate back to the main context");

        return getInput();
    }


    public void controlSecondUserInput(int secondInput, MainContext mainContext) {

        if (secondInput == 1) {
            System.out.println("Please enter the file name you want to create:");
            Scanner sc = new Scanner(System.in);
            addFile(sc.nextLine());
        } else if (secondInput == 2) {
            System.out.println("Please enter the file name you want to delete:");
            Scanner sc = new Scanner(System.in);
            deleteFile(sc.nextLine());
        } else if (secondInput == 3) {
            System.out.println("Please enter the file name you want to search:");
            Scanner sc = new Scanner(System.in);
            System.out.println(searchFile(sc.nextLine()));
        } else if (secondInput == 0) {
            int userInput = mainContext.showMainContext();
            mainContext.controlUserInput(userInput, this);
        } else {
            System.out.println("Please try again");
            secondInput = this.showSecondContext();
            this.controlSecondUserInput(secondInput, mainContext);
        }
    }

    private String searchFile(String searchName) {
        List<String> fileNames = getFileNames();
        for (String file : fileNames) {
            if (file.equals(searchName)) {
                return searchName + " found in directory.";
            }
        }
        return searchName + " not found in directory.";
    }

    private static void deleteFile(String fileName) {
        String filePath = DIRECTORY + "/" + fileName + ".txt";
        File file = new File(filePath);
        try {
            if (file.exists() && file.getCanonicalPath().equals(filePath)) {
                if (file.delete()) {
                    System.out.println("Deleted the file: " + file.getName());
                } else {
                    System.out.println("Failed to delete the file.");
                }
            } else {
                System.out.println("File not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void addFile(String fileName) {
        try {
            File file = new File(DIRECTORY + "/" + fileName + ".txt");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Commons {

    protected static final String DIRECTORY = "/Users/Kamil/Desktop/Dersler";

    protected int getInput() {
        Scanner sc = new Scanner(System.in);
        int input = -1;
        try {
            input = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(e);
        }
        return input;
    }

    protected List<String> getFileNames() {
        File folder = new File(DIRECTORY);
        File[] listOfFiles = folder.listFiles();
        List<String> fileNames = new ArrayList<>();
        for (File file : listOfFiles) {
            fileNames.add(file.getName());
        }
        return fileNames;
    }
}

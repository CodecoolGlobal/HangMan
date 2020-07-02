package com.codecool.hangman.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadSource {

    public static ArrayList<String> gettingSource(String filename) {
        ArrayList<String> source = new ArrayList<String>();
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                source.add(myReader.nextLine());
            };

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        };

        return source;
    };
}

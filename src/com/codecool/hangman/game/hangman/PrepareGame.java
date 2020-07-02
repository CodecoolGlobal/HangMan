package com.codecool.hangman.game.hangman;

import com.codecool.hangman.util.ReadSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PrepareGame {

    public static String chooseARandomWordFromSource(List<String> sourceList) {
        Random random = new Random();
        int randomNumber = random.nextInt(sourceList.size());
        return sourceList.get(randomNumber);
    }

    public static int getLivesAfterDifficulty(List<String> gameData) {
        if (gameData.get(0) == "1") {
            return 11;
        } else if (gameData.get(0) == "2") {
            return 9;
        }
        return 7;
    }


    public static List<String> getWordList(List<String> gameData) {
        ArrayList<String> source = ReadSource.gettingSource("./data_for_hangman/" + gameData.get(3) + ".txt");
        return source;
    }



}

package com.codecool.hangman.game.hangman;

import com.codecool.hangman.game.Game;
import com.codecool.hangman.util.ClearScreen;

import java.util.*;

public class HangMan extends Game {

    private List<String> words;
    private String word;
    private String wordLowerCase;
    private String asterisk;
    private int lives;
    private int score;
    List<String> usedLetters = new ArrayList<>();



    private void hang(String guess) {
        String newasterisk = "";
        for (int i = 0; i < word.length(); i++) {
            if (wordLowerCase.charAt(i) == guess.charAt(0)) {
                newasterisk += word.charAt(i);
            } else if (asterisk.charAt(i) != '*') {
                newasterisk += word.charAt(i);
            } else {
                newasterisk += "*";
            }
        }
        if (asterisk.equals(newasterisk)) {
            lives--;
            usedLetters.add(guess);
            PrintHangman.printHangman(lives, gameData.get(0));
        } else {
            asterisk = newasterisk;
        }
        if (guess.equals(wordLowerCase) || guess.equals(word)) {
            countScore();
            this.addHighScore(score);
            this.player.addPlayerScore(score);
            System.out.println("Correct! You win! The word was " + word + "Your Score is " + score);
            asterisk = word;
            usedLetters.clear();
        } else if (asterisk.equals(word)) {
            countScore();
            this.addHighScore(score);
            this.player.addPlayerScore(score);
            System.out.println("Correct! You win! The word was " + word + "Your Score is " + score);
            usedLetters.clear();
        }
    }


    public void chooseTheme() {
        boolean choosedTheme = false;
        Scanner inTheme = new Scanner(System.in);
        while (!choosedTheme) {
            System.out.println("Cities (0) \nAnimals (1) \nFamous People (2)");
            String diffNum = inTheme.nextLine();
            if (diffNum.equals("0")) {
                ClearScreen.clearScreen();
                gameData.set(3, "cities");
                choosedTheme = true;
            } else if (diffNum.equals("1")) {
                ClearScreen.clearScreen();
                gameData.set(3, "animals");
                choosedTheme = true;
            } else if (diffNum.equals("2")) {
                ClearScreen.clearScreen();
                gameData.set(3, "famous-people");
                choosedTheme = true;
            } else {
                ClearScreen.clearScreen();
                System.out.println("Please try to give a valid answer (0-2). \n");
            }
        }
    }


    @Override
    public void startGame() {
        chooseTheme();
        words = PrepareGame.getWordList(gameData);
        word = PrepareGame.chooseARandomWordFromSource(words);
        wordLowerCase = word.toLowerCase();
        asterisk = wordLowerCase.replaceAll("[a-zA-Z]", "*");
        lives = PrepareGame.getLivesAfterDifficulty(gameData);

        Scanner sc = new Scanner(System.in);

        while (0 <= lives && asterisk.contains("*")) {
            System.out.println("Guess a letter!");
            System.out.println();
            System.out.println(asterisk);
            String guess = sc.nextLine();
            hang(guess);
            System.out.println();
            System.out.printf("You have %d lives left \n", lives);
            System.out.println("Used letters: " + usedLetters);
        }
        if (lives < 0) {
            usedLetters.clear();
            System.out.println();
            System.out.println("You lost the word would be " + word);
            System.out.println("Another try?");
            System.out.println();
        }
    }

    @Override
    public Map<String, Integer> getHighScore() {
        return highScore;
    }


    private void countScore() {
        if (gameData.get(0).equals("1")) {
            score = lives * 2;
        }
        else if (gameData.get(0).equals("2")) {
            score = lives * 3;
        }
        else {
            score = lives * 4;
        }
    }
}



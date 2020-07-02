package com.codecool.hangman;

import com.codecool.hangman.game.backgammon.BackGammon;
import com.codecool.hangman.game.hangman.HangMan;
import com.codecool.hangman.game.tetris.Tetris;

public class Main {

    public static void main(String[] args) {
        Application application = new Application();
        HangMan hangMan = new HangMan();
        Tetris tetris = new Tetris();
        BackGammon blackGammon = new BackGammon();
        application.addGame(hangMan);
        application.addGame(tetris);
        application.addGame(blackGammon);

        application.playGame();

    }
}

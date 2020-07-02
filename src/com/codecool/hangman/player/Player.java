package com.codecool.hangman.player;

import com.codecool.hangman.game.Game;

import java.util.Map;
import java.util.TreeMap;

public class Player {

    private String name;
    private Map<String, Integer> playerScores = new TreeMap<>();
    private Game game;

    public Player(String name) {
        this.name = name;
    }

    public Map<String, Integer> getPlayerScores() {
        return playerScores;
    }

    public void addPlayerScore(int score) {
        if (playerScores.get(this.game.getName()) == null) {
            this.playerScores.put(this.game.getName(), score);
        }
        else if (playerScores.get(this.game.getName()) < score) {
            this.playerScores.put(this.game.getName(), score);
        }
    }

    public String getName() {
        return name;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}

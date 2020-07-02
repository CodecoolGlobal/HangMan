package com.codecool.hangman.game;

import com.codecool.hangman.player.Player;

import java.util.*;

public abstract class Game {

    protected List<String> gameData = new ArrayList<>();
    protected String name;
    protected Player player;
    protected HashMap<String, Integer> highScore = new HashMap<>();

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Map<String, Integer> getHighScore() {
        return sortByValue(highScore);
    }

    public void addHighScore(int score) {
        if (highScore.get(this.player.getName()) == null) {
            this.highScore.put(this.player.getName(), score);
        }
        else if (highScore.get(this.player.getName()) < score) {
            this.highScore.put(this.player.getName(), score);
        }
    }

    public Game() {
        this.name = this.getClass().getSimpleName();
    }

    public abstract void startGame();

    public void addGameData(List<String> gameData) {
        this.gameData = gameData;
    }

    public List<String> getGameData() {
        return gameData;
    }

    public void setGameData(List<String> gameData) {
        this.gameData = gameData;
    }

    public String getName() {
        return name;
    }

    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}

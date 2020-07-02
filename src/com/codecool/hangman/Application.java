package com.codecool.hangman;

import com.codecool.hangman.game.Game;
import com.codecool.hangman.menu.Menu;
import com.codecool.hangman.player.Player;

import java.util.ArrayList;
import java.util.List;


public class Application {

    private List<Game> gameList = new ArrayList<>();
    private List<Player> players = new ArrayList<>();
    private boolean game = true;

    public void addPlayer(Player player) {
        List<String> names = new ArrayList<>();
        for (Player registeredPlayer : players) {
            names.add(registeredPlayer.getName());
        }
        if (!names.contains(player.getName()))
        players.add(player);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void addGame(Game game) {
        gameList.add(game);
    }


    public void playGame() {
        Menu menu = new Menu();
        menu.setApplication(this);
        while (game) {
            List<String> gameData = menu.menu();
            for (Game game : gameList) {
                if (game.getName().equals(gameData.get(1))) {
                    game.setGameData(gameData);
                    game.startGame();
                }
            }
        }
    }
}

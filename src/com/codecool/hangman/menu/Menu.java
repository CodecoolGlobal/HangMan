package com.codecool.hangman.menu;

import com.codecool.hangman.Application;
import com.codecool.hangman.game.Game;
import com.codecool.hangman.player.Player;
import com.codecool.hangman.util.ClearScreen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private Game game;
    private Application application;
    private Player player;
    ArrayList<String> gameData = new ArrayList<>(Arrays.asList(null, null, null, null));

    private String getUserName() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String userName = in.nextLine();
        ClearScreen.clearScreen();
        return userName;
    }

    public List<String> menu() {
        Scanner in = new Scanner(System.in);
        boolean startGame = false;
        while (!startGame) {
            System.out.println("Start Game (0)");
            System.out.println("Choose difficulty (1)");
            System.out.println("Choose game (2)");
            System.out.println("Add username (3)");
            System.out.println("HighScore (4)");
            System.out.println("Quit Game (5)");

            String submenu = in.nextLine();
            ClearScreen.clearScreen();
            if (submenu.equals("0")) {
                if (gameData.get(0) != null && gameData.get(1) != null && gameData.get(2) != null) {
                    startGame = true;
                } else {
                    System.out.println("Choose theme difficulty and add userName!");
                }
                ;
            } else if (submenu.equals("1")) {
                boolean choosedDifficulty = false;
                ClearScreen.clearScreen();
                while (!choosedDifficulty) {
                    System.out.println("Easy (0) \nMedium (1) \nHard (2)");
                    String diffNum = in.nextLine();
                    if (diffNum.equals("0")) {
                        ClearScreen.clearScreen();
                        gameData.set(0, "1");
                        choosedDifficulty = true;
                    } else if (diffNum.equals("1")) {
                        ClearScreen.clearScreen();
                        gameData.set(0, "2");
                        choosedDifficulty = true;
                    } else if (diffNum.equals("2")) {
                        ClearScreen.clearScreen();
                        gameData.set(0, "3");
                        choosedDifficulty = true;
                    } else {
                        ClearScreen.clearScreen();
                        System.out.println("Please try to give a valid answer (0-2). ");
                    }
                }
            } else if (submenu.equals("2")) {
                boolean chooseGame = false;
                ClearScreen.clearScreen();
                while (!chooseGame) {
                    for (int i = 0; i < application.getGameList().size(); i++) {
                        System.out.println(application.getGameList().get(i).getClass().getSimpleName() + " (" + i + ")");
                    }
                    String num = in.nextLine();
                    game = application.getGameList().get(Integer.parseInt(num));
                    ClearScreen.clearScreen();
                    gameData.set(1, game.getName());
                    chooseGame = true;
                }

            } else if (submenu.equals("3")) {
                ClearScreen.clearScreen();

                boolean chooseName = false;
                while (!chooseName) {
                    String userName = getUserName();
                    if (gameData.get(2) != null) {
                        if (gameData.get(2).equals(userName)) {
                            System.out.println("(Your current player is: " + gameData.get(2) + ")\n");
                            System.out.println("If you are not  " + gameData.get(2) + ",press 0 then choose another name! or just press 1");
                            System.out.println("Choose another name (0) \n Continue playing (1)");
                            String input = in.nextLine();
                            if (input.equals("0")) {
                                continue;
                            } else {
                                chooseName = true;
                            }
                        } else {
                            gameData.set(2, userName);
                            Player player = new Player(userName);
                            this.player = player;
                            chooseName = true;
                        }
                    } else {
                        gameData.set(2, userName);
                        Player player = new Player(userName);
                        this.player = player;
                        chooseName = true;
                    }
                }
            } else if (submenu.equals("4")) {

                boolean chooseHighScoreType = false;
                while(!chooseHighScoreType) {
                    System.out.println("HighScoreByGames (0)\nHighScoreByPlayer (1)");
                    String highScoreInput = in.nextLine();
                    if (highScoreInput.equals("0")) {
                        for (int i = 0; i < application.getGameList().size(); i++) {
                            System.out.println("HighScore of " + application.getGameList().get(i).getClass().getSimpleName() + " (" + i + ")");
                        }
                        String highScore = in.nextLine();
                        boolean showResult = true;
                        while (showResult) {
                            System.out.println(application.getGameList().get(Integer.parseInt(highScore)).getHighScore());
                            System.out.println();
                            System.out.println("Press 0 to go back");
                            String goBack = in.nextLine();
                            if (goBack.equals("0")) {
                                showResult = false;
                            }
                        }
                    } else if(highScoreInput.equals("1")) {
                        for (int i = 0; i < application.getPlayers().size(); i++) {
                            System.out.println("HighScore of " + application.getPlayers().get(i).getName() + " (" + i + ")");
                        }
                        String highScoreByPlayer = in.nextLine();
                        boolean getResult = true;
                        while (getResult) {
                            System.out.println(application.getPlayers().get(Integer.parseInt(highScoreByPlayer)).getPlayerScores());
                            System.out.println();
                            System.out.println("Press 0 to go back");
                            String back = in.nextLine();
                            if (back.equals("0")) {
                                getResult = false;
                            }
                        }

                    }
                    chooseHighScoreType = true;
                }

            } else if (submenu.equals("5")) {
                startGame = true;
                System.out.println("That's sad. :c \nHope to see you soon!");
                System.exit(0);
            } else {
                System.out.println("Please try to give a valid answer (0-5).\n");
            }
        }
        this.setGame(game);
        game.setPlayer(player);
        player.setGame(game);
        application.addPlayer(player);
        return gameData;
    }

    public void setGame(Game game) {
        this.game = game;
    }


    public void setApplication(Application application) {
        this.application = application;
    }
}

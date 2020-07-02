package com.codecool.hangman.game.hangman;

public class PrintHangman {

    public static void printHangman(int livesLeft, String level ){
        String live11 = "\n\n \n \n \n \n \n \n \n";
        String live10 = "\n\n \n \n \n \n \n \n_______________\n";
        String live9 = "\n\n \n \n \n \n \n  ___________\n___|_______|___\n";
        String live8 = "\n|\n|\n|\n|\n|\n|\n|  ___________\n|___|_______|___\n";
        String live7 = "___________\n|\n|\n|\n|\n|\n|\n|  ___________\n|___|_______|___\n";
        String live6 = "___________\n|        |\n|        |\n|\n|\n|\n|\n|  ___________\n|___|_______|___\n";
        String live5 = "___________\n|        |\n|        |\n|        0\n|\n|\n|\n|  ___________\n|___|_______|___\n";
        String live4 = "___________\n|        |\n|        |\n|        0\n|        |\n|        |\n|\n|  ___________\n|___|_______|___\n";
        String live3 = "___________\n|        |\n|        |\n|        0\n|       /|\n|        |\n|\n|  ___________\n|___|_______|___\n";
        String live2 = "___________\n|        |\n|        |\n|        0\n|       /|\\" +  "\n|        |\n|\n|  ___________\n|___|_______|___\n";
        String live1 = "___________\n|        |\n|        |\n|        0\n|       /|\\" +  "\n|        |\n|       /" + "\n|  ___________\n|___|_______|___\n";
        String live0 = "___________\n|        |\n|        |\n|        0\n|       /|\\" +  "\n|        |\n|       / \\" + "\n|  ___________\n|___|_______|___\n";

        if (livesLeft == 0) {
            System.out.print(live0);}
        else if (livesLeft == 1) {
            System.out.print(live1);}
        else if (livesLeft == 2) {
            System.out.print(live2);}
        else if (livesLeft == 3) {
            System.out.print(live3);}
        else if (livesLeft == 4) {
            System.out.print(live4);}
        else if (level == "1" && livesLeft == 5){
            System.out.print(live5);}
        else if (level == "1" && livesLeft == 6 || level == "2" && livesLeft == 5 || level == "3" && livesLeft == 5) {
            System.out.print(live6);}
        else if (level == "1" && livesLeft == 7 || level == "2" && livesLeft == 6) {
            System.out.print(live7);}
        else if (level == "1" && livesLeft == 8 || level == "2" && livesLeft == 7 || level == "3" && livesLeft == 6) {
            System.out.print(live8);}
        else if (level == "1" && livesLeft == 9 || level == "2" && livesLeft == 8) {
            System.out.print(live9);}
        else if (level == "1" && livesLeft == 10 || level == "2" && livesLeft == 9 || level == "3" && livesLeft == 7) {
            System.out.print(live10);}
        else if (livesLeft == 11) {
            System.out.print(live11);}
    }
}

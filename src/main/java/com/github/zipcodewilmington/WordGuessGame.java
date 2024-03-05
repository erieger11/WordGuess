package com.github.zipcodewilmington;
import java.util.Objects;
import java.util.Random;

import java.util.Scanner;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class WordGuessGame {
    boolean toPlay = true;
    static boolean didYouWin;
    static int guessRemaining = 10;
    static int maxGuess = 0;
    static String choice;
    static String theUserWord = "________";
    static String theGuess;


    public static void main(String[] args) {
        while (true) {
            if (toPlay()) {
                endTheGame();
            }
            guessRemaining = 10;
            theUserWord = "________";
            System.out.println("The word has 8 letters! you have 10 guesses.");
            System.out.println("________");
            while (guessRemaining > maxGuess) {
                nextGuess();
                theLettersInSecretWord();
                theCorrectLetters();
                winGame();
                if(didYouWin){
                    break;
                }
            }
            if(!didYouWin){
                youLose();
            }
        }
    }

    public static boolean toPlay() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you want to play? Yes/No");
        choice = scan.next();
        return Objects.equals(choice, "Yes") || Objects.equals(choice, "No");
    }
    public static String getWord() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter any letter : ");
        String letter = scan.nextLine();
        System.out.println("You typed : " + letter);
        return letter;
    }
    public static String theWord() {
        String[] secretWord = new String[]{"Elephant", "Icebergs", "Mountain", "Checkout"};
        return secretWord[new Random().nextInt(secretWord.length)];
    }
    public static void theLettersInSecretWord() {
        theWord();
        boolean didYouSucceed = false;
        int i;
        for (i = 0; i < theWord().length(); i++){
        char letter = theWord().charAt(i);
        String stringLetter = String.valueOf(letter);
        if(Objects.equals(theGuess,stringLetter)) {
            theUserWord = theUserWord.substring(0, i) + theGuess + theUserWord.substring(i + 1);
                }
            }
        if(!didYouSucceed){
            guessRemaining--;
            System.out.println("You have one less guess :(");
        }
    }

    public static void nextGuess() {
        System.out.println("Guess again!");
        Scanner sc = new Scanner(System.in);
        theGuess = sc.next();
    }
    public static void theCorrectLetters(){
            System.out.println(theUserWord);
        }

    public static void winGame() {
        if (theUserWord.equals(theWord())) {
            System.out.println("You won!");
            didYouWin = true;
        } else {
            didYouWin = false;
        }
    }
    public static void youLose() {
        System.out.println("Goodbye!");
    }
    public static void endTheGame(){
        System.out.println("Exiting the game");
    }
}


//Ethan Rieger
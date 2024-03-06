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

    static boolean isPlaying = true;
    static int guessRemaining = 10;
    static int maxGuess = 0;
    static String selectedWord;
    static String theUserWord = "";
    static String theGuess;




    public static void main(String[] args) {
        while (true) {
            if (toPlay().equals("no") ) {
                endTheGame();
            }
            selectedWord = theWord();
            underscoreLine();
            guessRemaining = 10;
            System.out.println("The word is animal and has " +selectedWord.length()+ " letters! you have 10 guesses.");
            System.out.println(theUserWord);
            while (guessRemaining > maxGuess) {
                theLetterGuess();
                theLettersInSecretWord();
                theCorrectLetters();
                didYouWin();
                if(!isPlaying) break;
            }
        }
    }

    public static String toPlay() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you want to play? Yes/No");
        //todo handle any input thats not yes or no
        return scan.next().toLowerCase();

    }
    public static void theLetterGuess() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter any letter : ");
        theGuess = scan.nextLine().toLowerCase();
        System.out.println("You typed : " + theGuess);
    }
    public static String theWord() {
        String[] secretWord = new String[]{"elephant", "lion", "giraffe", "dog", "sloth", "iguana", "tiger","rhino","chameleon","kangaroo"};
        return secretWord[new Random().nextInt(secretWord.length)];
    }
    public static void theLettersInSecretWord() {
        boolean didYouSucceed = false;
        for (int i = 0; i < selectedWord.length(); i++){
            char letter = selectedWord.charAt(i);
            String stringLetter = String.valueOf(letter);
            if(Objects.equals(theGuess,stringLetter)) {
                didYouSucceed = true;
                theUserWord = theUserWord.substring(0, i) + theGuess + theUserWord.substring(i + 1);
            }
        }
        if(!didYouSucceed){
            System.out.println("You have " + guessRemaining-- + " guesses remaining!");
        }
    }

    public static void theCorrectLetters(){
            System.out.println(theUserWord);
        }
    public static void underscoreLine(){
        for (int i = 0; i < selectedWord.length(); i++) {
          theUserWord += "_";
        }
    }

    public static void didYouWin() {
        if (theUserWord.equals(selectedWord)) {
            System.out.println("You won!");

        } else if(guessRemaining == 0){
            System.out.println("Goodbye!");
        }
    }

    public static void endTheGame() {
        System.out.println("Goodbye!");
    }
}


//Ethan Rieger
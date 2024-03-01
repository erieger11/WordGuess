package com.github.zipcodewilmington;

import java.util.Scanner;
import java.sql.SQLOutput;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class Hangman {
    public static void main(String[]args){
        getWord();
    }

    public static String getWord(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter any letter : ");
        String letter = scan.nextLine();
        System.out.println("You typed : " + letter);
        scan.close();
        return letter;
    }







}
//Ethan Rieger
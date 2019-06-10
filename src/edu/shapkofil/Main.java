package edu.shapkofil;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    //catLegs and humanLegs class constants
    private final static int HUMAN_LEGS = 2;
    private final static int CAT_LEGS = 4;

    public static void main(String[] args) {
        //initializing scanner object
        Scanner scanner = new Scanner(System.in);

        //defining input variable
        int legs;

        //input validation
        do {
            System.out.print("Enter number of legs:");
            legs = scanner.nextInt();
            if(!validate(legs))System.out.println("I don't accept odd values\nI'm working with normal cats and humans");
        }while(!validate(legs));

        //outputting the solution and formatting it with java.util.Arrays.toString()
        System.out.println(Arrays.toString(solveHouseOfCats(legs)));
    }

    private static int[] solveHouseOfCats(int legs) {
        //calculating needed params
        int possibleWays = legs/CAT_LEGS + 1;
        int initNumberOfHumans = legs%CAT_LEGS /2;
        int humanScalar = CAT_LEGS/HUMAN_LEGS;

        //creating output array
        int[] outputArray = new int[possibleWays];

        //finding values and filling the array
        for(int i = 0;i<possibleWays;i++) {
            outputArray[i] = initNumberOfHumans + humanScalar*i;
        }
        return outputArray;
    }

    private static boolean validate(int value) {
        if(value%2 == 1) return false;
        if(value < 0) return false;
        if(value >= 50) return false;
        return true;
    }
}
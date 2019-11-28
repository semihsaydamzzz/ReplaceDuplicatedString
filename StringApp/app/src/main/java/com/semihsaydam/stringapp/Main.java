package com.semihsaydam.stringapp;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        //////////____________________ input reader from keyboard__________________________
        Scanner inputScanner = new Scanner(System.in);

        /////////____________________ infinite console loop for user____________________
        boolean shouldContinueToAsk = true;

        while (shouldContinueToAsk) {
            ///////____________________get min number of duplicate letter from user____________________
            System.out.println("Please enter min number of duplicate letters: ");
            int minDuplicateNumber = 0;
            minDuplicateNumber = inputScanner.nextInt();

            //////////____________________ default string source____________________
            // reads string source from the user
            String sourceStr = "abbcccaaeeeeb bfffffca ccab";
            System.out.println("\nDefault string source: " + sourceStr);

            //____________________code duplicate letter with '*' symbols.____________________
            char[] result = replaceDuplicateLetterWithAsteriskByNumber(sourceStr.toCharArray(), minDuplicateNumber);

            //____________________prompt the result____________________
            System.out.println("-----------------------------------");
            System.out.println("min number of duplicate letters: " + minDuplicateNumber);
            System.out.print(result);

            //____________________are you sure want to keep going?____________________
            System.out.println("\nAre you sure want to keep going?(Y/N)");
            char yesOrNo = 'y';
            yesOrNo = inputScanner.next().charAt(0);

            //____________________stop the infinite asking loop____________________
            if (yesOrNo == 'N' || yesOrNo == 'n') {
                shouldContinueToAsk = false;
            }
        }
    }

    public static char[] replaceDuplicateLetterWithAsteriskByNumber(char[] givenArr, int numberDuplicate) {
        //____________________declare source characters____________________
        char[] charArr = new char[givenArr.length];
        //____________________init source characters____________________
        for (int i = 0; i < charArr.length; i++) {
            charArr[i] = givenArr[i];
        }

        //____________________iterate char array for duplicate letters____________________
        for (int i = 0; i < givenArr.length; i++) {

            int duplicateComparison = 1;
            for (int j = i + 1; j < givenArr.length; j++) {
                //____________________found duplicate letter____________________
                if (givenArr[i] == givenArr[j]) {
                    //____________________increment founded duplicate letter counter____________________
                    duplicateComparison++;

                    if (duplicateComparison >= numberDuplicate) {
                        //____________________replace duplicated letter with '*'____________________
                        for (int k = i; k <= j; k++) {
                            charArr[k] = '*';
                        }
                    }
                } else {
                    break;
                }
            }
        }

        return charArr;
    }
}

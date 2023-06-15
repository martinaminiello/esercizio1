package org.example;

import com.amazonaws.services.kinesis.model.InvalidArgumentException;

public class Palindrome {


    boolean isPalindrome(String input) throws InvalidArgumentException,NullPointerException {


        if(input==null){

            throw new NullPointerException("String can't be null");
        }
        if(input.isEmpty()){

            return true;
        }

        if(input.matches("\\s+")){

            return true;
        }
// we put a control to see if the string is made of only spaces in order to make it return true otherwise T15 fails
        //Converting input to Lowercase and removing all white spaces
        input = input.toLowerCase().replaceAll("[-,;.:'!?\"]", "");
        input = input.toLowerCase().replaceAll("\\s+", "");
        if( input.isEmpty() ){

            throw new InvalidArgumentException("Invalid String");
        }




        //Length of input
        int length = input.length();

        //Check if non alpha-numeric string
        if (!input.matches("^([\\p{L}0-9]+)?$")) {
            throw new InvalidArgumentException("Invalid String");
        }

        //Character by character comparision
        for (int i = 0; i < length / 2; i++) {
            if (input.charAt(i) != input.charAt(length - i - 1)) {
                return false;
            }

        }
        return true;
    }

}



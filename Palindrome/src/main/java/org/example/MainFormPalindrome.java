package org.example;



public class MainFormPalindrome {
    public static void main(String[] args) {

        String input="Ann";


        if (FormPalindrome.canFormPalindrome(input))
            System.out.println("\"" + input + "\" can form a palindrome.");
        else
            System.out.println("\"" + input + "\" cannot form a palindrome.");

    }
    }



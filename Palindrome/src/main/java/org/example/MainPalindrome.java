package org.example;

public class MainPalindrome {
        public static void main(String[] args) throws Exception {

            Palindrome palindrome = new Palindrome();

            String input = "Mare";

            if (palindrome.isPalindrome(input))
                System.out.println("\"" + input + "\" is a palindrome.");
            else
                System.out.println("\"" + input + "\" is not a palindrome.");

        }
    }


package org.example;


import com.amazonaws.services.kinesis.model.InvalidArgumentException;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.Assert.*;

public class PalindromeTest {

    //Explorative tests
/*    @Test
    public void SimpleCase() throws Exception {
        Palindrome prova=new Palindrome();

        assertTrue(prova.isPalindrome("abba"));
    }
    @Test
    public void SingleCharacterCase() throws Exception {
        Palindrome prova=new Palindrome();

        assertTrue(prova.isPalindrome("a"));
    }

    @Test
    public void SpacesCase() throws Exception {
        Palindrome prova=new Palindrome();

        assertTrue(prova.isPalindrome("    a  b     b           a"));
    }
    @Test
    public void SenteceCase() throws Exception {
        Palindrome prova=new Palindrome();

        assertTrue(prova.isPalindrome(" Murder for a jar of red rum "));
    }

    @Test
    public void SenteceWithPuntiactionCase() throws Exception {
        Palindrome prova=new Palindrome();

        assertTrue(prova.isPalindrome("Did Hannah see bees? Hannah did."));
    }

    @Test
    public void SpecialCharactersCase() throws Exception {
        Palindrome prova=new Palindrome();

        Assert.assertThrows(Exception.class, ()-> prova.isPalindrome("+a++a+"));
        assertTrue(prova.isPalindrome("デせせデ"));
        assertTrue(prova.isPalindrome("èççè"));

    }*/


    //T1

    @Test
    public void nullString() throws NullPointerException {

        Palindrome input = new Palindrome();
        Assert.assertThrows(NullPointerException.class, () -> input.isPalindrome(null));
    }


    //T2
    @Test
    public void EmptyString() throws Exception {
        Palindrome input = new Palindrome();

        assertTrue(input.isPalindrome(""));
    }

    //T3 //T4
    @ParameterizedTest
    @ValueSource(strings = {"#", "$", "%", "^", "&", "*", "_", "+", "=", "[", "/", "{", "<", "°", "@"})
    public void specialCharactersInString(String character) throws InvalidArgumentException {

        Palindrome input = new Palindrome();
        Assertions.assertAll(
                ()->Assert.assertThrows(InvalidArgumentException.class, () -> input.isPalindrome(character)),
        ()-> Assert.assertThrows(InvalidArgumentException.class, () -> input.isPalindrome("# a  bba  #")));
    }


    //T5
    @Test
    public void whiteSpacesInString() throws Exception {
        Palindrome input = new Palindrome();
        assertTrue(input.isPalindrome("    A  "));
    }


    //T6
    @Test
    public void ignoreCaseInString() throws Exception {
        Palindrome input = new Palindrome();
        assertTrue(input.isPalindrome("aBbA"));
    }


    //T7 //T8 //T24
    @ParameterizedTest
    @ValueSource(strings = {",", ";", ".", "-", "\"", "'", "!", "?", ":"})
    public void punctuationMarks(String p) throws Exception {
        Palindrome input = new Palindrome();
        Assertions.assertAll(
        ()->Assert.assertThrows(InvalidArgumentException.class, () -> input.isPalindrome(p)),
        ()->Assert.assertThrows(InvalidArgumentException.class, () -> input.isPalindrome("!!---,,  ,.....'   ''")),//checks a string with only spaces and punctuaction marks
        ()->assertTrue(input.isPalindrome("Eva,can I see bees in a cave?"))
        );
    }


    //T9 //T10
    @Test
    public void alphaNumericString() throws Exception {
        Palindrome input = new Palindrome();

        Assertions.assertAll(
                ()-> assertTrue(input.isPalindrome("3")), // number
                ()-> assertTrue(input.isPalindrome("  Air 2   an a2ria    "))); // alpha-numeric string

    }


    //T11 //T12
    @ParameterizedTest
    @ValueSource(strings = {"à", "á"})
    public void AccentsInString(String a) throws Exception {
        Palindrome input = new Palindrome();

        Assertions.assertAll(
                ()->assertTrue(input.isPalindrome(a)),
                ()-> assertTrue(input.isPalindrome("  à a b     ba à")));
    }


    //T13 //T14
    @ParameterizedTest
    @ValueSource(strings = {"ç", "ë", "î", "ï", "ñ", "ā", "å", "ß", "ė", "Ħ", "ب", "Œ", "Ƃ", "Ɯ", "ɕ", "ϕ", "せ"})
    public void ForeignLettersInString(String f) throws Exception {
        Palindrome input = new Palindrome();

        Assertions.assertAll(
                ()->assertTrue(input.isPalindrome(f)),
                ()->assertTrue(input.isPalindrome(" せ    a bb a  せ")));
    }


//T15

    @Test
    public void OnlyWhiteSpaces() throws Exception {
        Palindrome input = new Palindrome();

        assertTrue(input.isPalindrome("    ")); // with multiple spaces
    }



    //T16 //T17 //T18
    @Test
    public void isNotPalindrome() throws Exception {
        Palindrome input = new Palindrome();

        Assertions.assertAll(
                ()->assertFalse(input.isPalindrome("ab")),
                ()->assertFalse(input.isPalindrome("I am a tester")),
                ()->assertFalse(input.isPalindrome("èhhhé")));
    }

    //T19 //T20 //T21 //T22 //T23
    @Test
    public void escapeCharactersInString() throws Exception {
        Palindrome input = new Palindrome();
        Assertions.assertAll(
                ()->assertTrue(input.isPalindrome("Poor Dan is \n in a droop")),
        ()->assertTrue(input.isPalindrome("Poor Dan is \t in a droop")),
        ()->Assert.assertThrows(InvalidArgumentException.class, () -> input.isPalindrome("Poor Dan is \b in a droop")), //[] is not valid
        ()->assertTrue(input.isPalindrome("Poor Dan is \r in a droop")),
        ()->assertTrue(input.isPalindrome("Poor Dan is \f in a droop")));
    }
}
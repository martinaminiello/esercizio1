package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class FormPalindromeTest {

    @Test
    public void T1() throws Exception {
        String input="aa";

        assertTrue( FormPalindrome.canFormPalindrome(input));
    }

    @Test
    public void T2() throws Exception {
        String input="abcb";

        assertFalse( FormPalindrome.canFormPalindrome(input));
    }

    @Test
    public void T3() throws Exception {
        String input="abb";

        assertTrue( FormPalindrome.canFormPalindrome(input));
    }
    @Test
    public void T4() throws Exception {
        String input="abcbu";

        assertFalse( FormPalindrome.canFormPalindrome(input));
    }
    //BLACK BOX
    @Test
    public void nullString() throws NullPointerException {


        Assert.assertThrows(NullPointerException.class, () ->  FormPalindrome.canFormPalindrome(null));
    }
    @Test
    public void EmptyString() throws Exception {


        assertTrue(FormPalindrome.canFormPalindrome(""));
    }
    @Test
    public void Singlechar() throws Exception {
        String input="a";

        assertTrue(FormPalindrome.canFormPalindrome(input));
    }
}

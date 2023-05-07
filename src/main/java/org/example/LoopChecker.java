package org.example;

public class LoopChecker {

    private static final String ALLOWED_CHARACTERS = "abcdefghijklmnopqrstuvxywzABCDEFGHIJKLMNOPQRSTUVXYWZ123456789_";

       public boolean LoopChecker(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!ALLOWED_CHARACTERS.contains(Character.toString(chars[i]))) {
                return false;
            }
        }
        return true;
    }
}

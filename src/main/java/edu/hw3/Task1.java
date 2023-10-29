package edu.hw3;

public class Task1 {
    private Task1() {
    }

    public static String atbash(String originalString) {
        char[] encryptedString = originalString.toCharArray();
        for (int i = 0; i < encryptedString.length; ++i) {
            char c = encryptedString[i];
            if (!Character.UnicodeBlock.of(c).equals(Character.UnicodeBlock.BASIC_LATIN)) {
                continue;
            }
            if (Character.isLowerCase(c)) {
                encryptedString[i] = (char) ('z' - (c - 'a'));
            } else if (Character.isUpperCase(c)) {
                encryptedString[i] = (char) ('Z' - (c - 'A'));
            }
        }

        return new String(encryptedString);
    }
}

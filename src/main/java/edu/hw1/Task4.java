package edu.hw1;

public class Task4 {
    private Task4() {
    }

    public static String fixString(String brokenString) {
        char[] charArray = brokenString.toCharArray();
        int charArrayLength = charArray.length;
        for (int i = 0; i < charArrayLength - 1; i += 2) {
            char temp = charArray[i];
            charArray[i] = charArray[i + 1];
            charArray[i + 1] = temp;
        }

        return new String(charArray);
    }
}

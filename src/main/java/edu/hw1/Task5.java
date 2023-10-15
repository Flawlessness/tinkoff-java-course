package edu.hw1;

public class Task5 {
    private Task5() {
    }

    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeDescendant(int number) {
        String strNumber = String.valueOf(number);

        if (isPalindrome(strNumber)) {
            return true;
        }

        if ((strNumber.length() < 2) || (strNumber.length() % 2 != 0)) {
            return false;
        }

        StringBuilder descendant = new StringBuilder();
        for (int i = 0; i < strNumber.length() - 1; i += 2) {
            int sum =
                Character.getNumericValue(strNumber.charAt(i)) + Character.getNumericValue(strNumber.charAt(i + 1));
            descendant.append(sum);
        }

        return isPalindromeDescendant(Integer.parseInt(descendant.toString()));
    }
}

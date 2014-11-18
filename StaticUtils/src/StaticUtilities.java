public class StaticUtilities {
    public static void main(String[] args) {
        System.out.println(isPalindrome("level"));
        System.out.println(isPalindrome("this is not a palindrome"));
    }

    public static boolean isPalindrome(String str) {
        str = removeJunk(str);
        return str.equals(reverseString(str));
    }

    private static String removeJunk(String str) {
        StringBuilder builder = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                builder.append(c);
            }
        }

        return builder.toString();
    }

    private static String reverseString(String str) {
        String reversed = "";
        char[] chars = str.toCharArray();

        for (int i = chars.length - 1; i >= 0; i--) {
            reversed += chars[i];
        }

        return reversed;
    }

    public int countVowels(String str) {
        int count = 0;

        for (char c : str.toLowerCase().toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count ++;
            }
        }

        return count;
    }
}

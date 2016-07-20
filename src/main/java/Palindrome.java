public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("baaassssssaaab"));
        System.out.println(isPalindrome("bab"));
        System.out.println(isPalindrome("baab"));
        System.out.println(isPalindrome("baaab"));
        System.out.println(isPalindrome("b"));
        System.out.println(isPalindrome("ab"));
        System.out.println(isPalindrome("abb"));
        System.out.println(isPalindrome(""));
        System.out.println(isPalindrome(" "));
        System.out.println(isPalindrome("  "));
        System.out.println(isPalindrome(null));
    }

    private static boolean isPalindrome(String sample) {
        if (sample == null || sample.trim().equals("")) {
            return false;
        }
        char[] charArray = sample.toCharArray();
        int begin = 0;
        int end = charArray.length - 1;
        while (begin <= end) {
            if (charArray[begin] == charArray[end]) {
                begin++;
                end--;
            } else {
                return false;

            }
        }
        return true;
    }
}

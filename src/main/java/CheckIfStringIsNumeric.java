/**
 * Created by akumar6 on 7/19/15.
 */
public class CheckIfStringIsNumeric {

    public static void main(String[] args) {
        System.out.println(isNumeric("123"));
        System.out.println(isNumeric("-123"));
        System.out.println(isNumeric("-123.12"));
        System.out.println(isNumeric("-,."));
        System.out.println(isNumeric("1,123,345"));
        System.out.println(isNumeric("a.1,123,345"));
        System.out.println(isNumeric("ab1,123,345"));
    }

    private static boolean isNumeric(String s) {

        return s.matches("^([+-]?\\d*\\.?\\d*)$");

    }

    private static boolean isIPAddress(String s) {

        return s.matches("^(\\d*\\.?\\d*)$");

    }

    public static boolean isNumber(String toTest) {
        boolean isNegativeFoundAlready = false;
        boolean isDecimalPointFoundAlready = false;
        for (int i=0; i < toTest.length(); i++) {
            if (!"0123456789-.".contains(new String(new char[]{toTest.charAt(i)}))) {
                return false;
            } else {
                if ('-' == toTest.charAt(i) && i != 0) {
                    return false;
                }
                if ('-' == toTest.charAt(i) && (i == toTest.length() - 1)) {
                    return false;
                }

                if ('-' == toTest.charAt(i) && isNegativeFoundAlready) {
                    return false;
                }
                if ('-' == toTest.charAt(i)) {
                    isNegativeFoundAlready = true;
                }
                if ('.' == toTest.charAt(i) && isDecimalPointFoundAlready) {
                    return false;
                }
                if ('.' == toTest.charAt(i)) {
                    isDecimalPointFoundAlready = true;
                }
                if ('.' == toTest.charAt(i) && (i == toTest.length() - 1)) {
                    return false;
                }
            }
        }
        return true;
    }
}

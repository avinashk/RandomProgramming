public class ReverseString {

    public static void main(String[] args) {
        System.out.println(reverseByRecursion("Avinash"));
        System.out.println(reverseByRecursion("aaaaabbbbb"));
    }
    private static String reverseByRecursion(String sample) {
        if (sample == null || sample.trim().equals("")) {
            return "";
        }
        return recurse(sample);
    }

    private static String  recurse(String sample) {
        String s = "";
        if(sample.length() == 0 || sample.length() == 1){
            return sample;
        }
        return s + (sample.charAt(sample.length()-1) + recurse(sample.substring(0,sample.length()-1)));
    }
}

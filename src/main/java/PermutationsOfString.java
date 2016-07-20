import java.util.Arrays;

public class PermutationsOfString {
    public static void main(String[] args) {
//        permutationOfStrings("abc");
//        subsetOfStrings("abc");
        allSubsetOfAnArray(new int[]{}, new int[]{1, 3, 5, 4, 7});
    }

    private static void permutationOfStrings(String word) {
        permute("", word);
    }

    private static void subsetOfStrings(String word) {
        subset("", word);
    }

    private static void permute(String soFar, String word) {
        if (word.length() == 0) {
            System.out.println(soFar);
        } else {
            for (int i = 0; i < word.length(); i++) {
                String next = soFar + word.charAt(i);
                String remaining = word.substring(0, i) + word.substring(i + 1);
                permute(next, remaining);
            }
        }
    }

    private static void subset(String soFar, String rest) {
        if (rest.equalsIgnoreCase("")) {
            System.out.println(soFar);
        } else {
            subset(soFar + rest.charAt(0), rest.substring(1));
            subset(soFar, rest.substring(1));
        }
    }

    private static void allSubsetOfAnArray(int[] soFar, int[] rest) {
        if (rest.length == 0) {
            for (int i : soFar) {
                System.out.print(i);
            }
            System.out.println("");
        } else {
            int[] newArray = new int[soFar.length + 1];
            System.arraycopy(soFar,0,newArray,0,soFar.length);
            newArray[soFar.length] = rest[0];
            allSubsetOfAnArray(newArray, Arrays.copyOfRange(rest, 1, rest.length));
            allSubsetOfAnArray(soFar, Arrays.copyOfRange(rest, 1, rest.length));
        }
    }
}

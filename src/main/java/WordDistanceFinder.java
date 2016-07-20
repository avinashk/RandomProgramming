import java.util.StringTokenizer;

public class WordDistanceFinder {

    public static void main(String args[]) {
        String sample = "hello how are you how are hello you";

        System.out.println(findMinDistance(sample, "hello", "you"));
    }

    private static int findMinDistance(String sample, String word1, String word2) {

        StringTokenizer str = new StringTokenizer(sample, " ");
        int minDiffDistance = Integer.MAX_VALUE;
        int distance = 0;

        while (str.hasMoreTokens()) {
            String token = str.nextToken();
            if (token.equals(word1)) {
                distance = 0;
            } else if (token.equals(word2)) {
                minDiffDistance = Math.min(minDiffDistance, distance);
            }
            distance++;
        }
        if (minDiffDistance == Integer.MAX_VALUE || minDiffDistance == 0) {
            return -1;
        } else {
            return minDiffDistance;
        }

    }

}

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by akumar6 on 7/18/15.
 */
public class ListOfPairs {
    public static void main(String args[]) {


        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        findPairSumK(new int[]{3, 5, 7, 8, 1, -3, 4, 6, 11}, 8);
        findPairSumK(new int[]{5, 5, 5, 5, 5}, 10);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        pairSumWithoutHashSet(new int[]{3, 5, 7, 8, 1, -3, 4, 6, 11}, 8);
        pairSumWithoutHashSet(new int[]{5, 5, 5, 5, 5}, 10);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        checkPairSumEqualsK(new int[]{5, 5, 5, 5, 5}, 10);

        System.out.println(checkPairSumEqualsK(new int[]{1, -2, 3, 6}, 4));
        System.out.println(checkPairSumEqualsK(new int[]{1, -2, 3, 6}, -1));
        System.out.println(checkPairSumEqualsK(new int[]{1, -2, 3, 6}, 9));
        System.out.println(checkPairSumEqualsK(new int[]{1, -2, 3, 6}, 10));
        System.out.println(checkPairSumEqualsK(new int[]{1, -2, 3, 6}, 5));
        System.out.println(checkPairSumEqualsK(new int[]{1, -2, 3, 6}, 0));

    }

    public static void findPairSumK(int[] sampleArray, int sampleSumOfPairs) {
        if (sampleArray == null || sampleArray.length == 0) {
            System.out.println("Sample Array has no element to match");
            return;
        }
        Set<Integer> pairs = new HashSet<>();
        for (int element : sampleArray) {
            if (pairs.contains(element)) {
                System.out.println("{" + element + "," + (sampleSumOfPairs - element) + "}");
            } else {
                pairs.add(sampleSumOfPairs - element);
            }
        }
    }

    public static void pairSumWithoutHashSet(int[] sampleArray, int sum) {
        Arrays.sort(sampleArray);
        int begin = 0;
        int end = sampleArray.length - 1;

        while (begin < end) {
            int calculatedSum = sampleArray[begin] + sampleArray[end];
            if (calculatedSum == sum) {
                System.out.println("{" + sampleArray[begin] + "," + sampleArray[end] + "}");
                ++begin;
                --end;
            } else if (calculatedSum < sum) {
                ++begin;
            } else if (calculatedSum > sum) {
                --end;
            }
        }
    }

    public static Boolean checkPairSumEqualsK(int[] sampleArray, int sum) {
        if (sampleArray == null || sampleArray.length == 0) {
            return false;
        }
        Set<Integer> intSet = new HashSet<>();
        for (int element : sampleArray) {
            if (intSet.contains(element)) {
                return true;
            } else {
                intSet.add(sum - element);
            }
        }
        return false;
    }

}

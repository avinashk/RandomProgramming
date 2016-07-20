public class MaxSumSubArray {

    public static void main(String[] args) {
        int[] sampleArray = {-1, -3, -5, 0, 4, 8, 2};
        int[] sampleArray1 = {-1, -3, -5, -1, -2, -3, -2};
        System.out.println(sumOfMSubArray(sampleArray));
        System.out.println(sumOfMSubArray(sampleArray1));
        System.out.println(sumOfMSubArray(sampleArray1));

    }

    private static int sumOfMaxSubArray(int[] sampleArray) {
        if (sampleArray == null || sampleArray.length == 0) {
            return Integer.MIN_VALUE;
        }
        int maxSum = sampleArray[0];
        int sum = sampleArray[0];
        for (int i = 1; i < sampleArray.length; i++) {
            sum = Math.max(sum + sampleArray[i], sampleArray[i]);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    private static int findMaxArrayMember(int[] sampleArray) {
        if (sampleArray == null || sampleArray.length == 0) {
            throw new RuntimeException("INcorrect input");
        }
        int max = sampleArray[0];
        for (int i = 1; i < sampleArray.length; i++) {
            max = Math.max(max, sampleArray[i]);
        }
        return max;
    }

    private static int sumOfMSubArray(int[] sampleArray) {
        if (sampleArray == null || sampleArray.length == 0) {
            throw new RuntimeException("Incorrect input");
        }
        int maxSum = sampleArray[0];
        int sum = sampleArray[0];
        for (int i = 1; i < sampleArray.length; i++) {
            sum = Math.max(sum + sampleArray[i], sampleArray[i]);
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

}

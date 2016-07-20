public class lambda {
    public static void main(String args[]) {

        for (long num : new long[]{0, 27, 999, 1000, 110592,
                28991029248L, 9223372036854775807L})
            System.out.printf("%20d: %8s%n", num, withSuffix(num));

//        Arrays.asList("a","b","c").forEach(e ->{ System.out.println(e)
//;        });
    }

    public static String withSuffix(long count) {
        if (count < 1000) return "" + count;
        int exp = (int) (Math.log(count) / Math.log(1000));
        return String.format("%.4f %c",
                count / Math.pow(1000, exp),
                "kMBTPE".charAt(exp - 1));
    }
}

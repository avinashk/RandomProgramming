import java.util.Arrays;

public class NoOfTraingles {

    public static void main(String[] args) {
        System.out.println(findNumberOfTriangles(new int[]{1,3,7,5}));
    }

    public static int findNumberOfTriangles(int[] sides) {
        Arrays.sort(sides);
        int result = 0;
        for (int i = sides.length - 1; i >= 0; --i) {
            int start = 0;
            int end = i - 1;
            while (start < end) {
                if (sides[start] + sides[end] <= sides[i]) {
                    ++start;
                } else {
                    result = result + end - start;
                    --end;
                }
            }
        }
        return result;
    }
}

public class AtoThePowerB {

    public static void main(String args[]) {
        System.out.println(pow(4, 3));
        System.out.println(pow(4, -3));
        System.out.println(pow(0, 3));
        System.out.println(pow(-3, 3));
    }

    public static double pow(double a, int b) {
        if (b == 0) {
            return a == 0 ? Integer.MIN_VALUE : 1;
        }
        if (b == 1) {
            return a;
        }
        if (a == 1) {
            return 1;
        }
        boolean isNegPower=false;

        if (b < 0) {
            isNegPower = true;
        }

        double result = powHelper(a, Math.abs(b));

        if (isNegPower) {
            return 1 / result;
        }

        return result;
    }

    private static double powHelper(double a, int b) {
        if (b == 1) {
            return a;
        } else {
            return a * powHelper(a, b - 1);
        }
    }
}

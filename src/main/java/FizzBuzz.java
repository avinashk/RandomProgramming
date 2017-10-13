public class FizzBuzz {

    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("fizz-buzz");
            } else if (i % 3 == 0) {
                System.out.println("fizz");
            } else if (i % 5 == 0) {
                System.out.println("buzz");
            } else {
                System.out.println(i);
            }

        }

        String xForwardedFor ="1.2.3.4,1.4.5.6";
        System.out.println(xForwardedFor.substring(0, xForwardedFor.indexOf(",")));

    }
}





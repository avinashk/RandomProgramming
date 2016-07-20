import java.util.Arrays;

public class MethodReference {

    public static void main(String[] args) {
        new MethodReference().doSomething();
    }

    static class Utils {
        public static int compareByLength(String in, String out)
        {
            return in.length() - out.length();
        }
    }

    public void doSomething() {
        String[] args = new String[]{"microsoft", "a", "bc","apple", "linux", "oracle"};

        Arrays.sort(args, Utils::compareByLength);

        for (String arg : args) {
            System.out.println(arg);
        }

    }
}

/**
 * Created by akumar6 on 6/14/17.
 */

import java.util.Base64;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(makeURL());
    }

    private static String makeURL() {
        byte[] encodedBytes = Base64.getEncoder().encode("curiosity".getBytes());
        String subdomain = new String(encodedBytes);
        return "https://" + subdomain + ".uptake.com";
    }
}

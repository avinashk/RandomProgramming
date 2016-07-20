/**
 * Created by akumar6 on 3/4/16.
 */
public class RegularExpression {
    public static void main(String args[]) {
        String input = "aaa";

        String fixedInput = input.replaceAll("(&password=[^&]*)&", "&password=XXXX&");

        System.out.println(fixedInput);

    }
}

import java.util.HashMap;
import java.util.Map;

/**
 * Created by akumar6 on 7/19/15.
 */
public class CheckIsomorphic {
    public static void main(String[] args) {
        System.out.println(isIsoMorphic("foo", "bpp"));
        System.out.println(isIsoMorphic("foo", "bpe"));
        System.out.println(isIsoMorphic("f", "bpe"));
        System.out.println(isIsoMorphic("fo", "bpe"));
        System.out.println(isIsoMorphic("fapaf", "fbqbf"));
        System.out.println(isIsoMorphic("fapaf", "fbqcg"));
    }

    private static boolean isIsoMorphic(String firstWord, String secondWord) {
        if (firstWord == null || secondWord == null) {
            return false;
        }
        if (firstWord.length() != secondWord.length()) {
            return false;
        }
        if (firstWord.length() == 0 && secondWord.length() == 0) {
            return true;
        }
        Map<Character, Character> m1 = new HashMap();
        Map<Character, Character> m2 = new HashMap();
        for (int i = 0; i < firstWord.length(); i++) {
            Character c1 = firstWord.charAt(i);
            Character c2 = secondWord.charAt(i);
            if (m1.containsKey(c1)) {
                if (m1.get(c1) != c2) {
                    return false;
                }
            }
            if (m2.containsKey(c2)) {
                if (m2.get(c2) != c1) {
                    return false;
                }
            }
            m1.put(c1,c2);
            m2.put(c2,c1);
        }
        return true;
    }
}

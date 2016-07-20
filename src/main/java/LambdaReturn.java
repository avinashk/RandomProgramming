import java.util.*;

public class LambdaReturn {
    public static void main(String args[]) {
        List<String> strings = Arrays.asList("a", "j", "d", "c", "k");

        strings.sort((e1, e2) -> e1.compareTo(e2));

        strings.forEach(e -> System.out.println(e));

        getData(5);
    }

    private static void getData(int index) {
        Set<Integer> intSet = new HashSet<>(10);

        intSet.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 45));

        Optional<Integer> first = intSet.stream().filter(i -> (i.intValue() == index))
                .findFirst();
        System.out.println(first.get());
    }
}

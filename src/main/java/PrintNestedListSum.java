import java.util.LinkedList;
import java.util.List;

public class PrintNestedListSum {

    public static void main(String args[]) {
        List l = new LinkedList<>();

        LinkedList<Object> secondLevelElement = new LinkedList<>();
        secondLevelElement.add(1);
        secondLevelElement.add(1);

        l.add(secondLevelElement);
        l.add(2);

        LinkedList<Object> anotherSecondLevelElement = new LinkedList<>();
        anotherSecondLevelElement.add(1);
        anotherSecondLevelElement.add(1);
        l.add(anotherSecondLevelElement);

        printLevel(l);
    }

    public static void printLevel(List l) {
        int level = 1;
        System.out.println(recursive(l, level));
    }

    public static int recursive(List list, int level) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            Object item = list.get(i);
            if (item instanceof Integer) {
                int val = (Integer) item * level;
                sum = sum + val;
            } else {
                sum = sum + recursive((List) list.get(i), level + 1);
            }
        }
        return sum;
    }

}
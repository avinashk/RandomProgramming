import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareObject implements Comparator<Employee>{

    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getFirstName().compareTo(e2.getFirstName());
    }

    public static void main(String[] args) {
        // Older method
        List<Employee> employees = Arrays.asList(new Employee("A", "B"), new Employee("c", "D"),
                new Employee("b", "z"));
        Collections.sort(employees, new CompareObject());


        List<Employee> employees1 = Arrays.asList(new Employee("A", "B"), new Employee("c", "D"),
                new Employee("b", "z"));
        // New Method

        Collections.sort(employees1, (e1, e2) -> e1.getFirstName().compareTo(e2.getFirstName()));


    }
}

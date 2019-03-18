
import java.util.*;

public class TestEmployee {
    public static void main(String[] args) {
        List<Employee> list= Arrays.asList(
                new Employee(18,"张三","3333"),
                new Employee(28,"李四","4444"),
                new Employee(38,"王三","5555"),
                new Employee(48,"田七","6666"),
                new Employee(58,"刘八","7777")
        );
        Comparator<Integer> com=(x,y)->Integer.compare(x,y);
        TreeSet<Integer> treeSet = new TreeSet<>(com);















//        List<Employee> employees = filterEmployee(list,(e)->e.getAge()>30);
//        employees.forEach(System.out::println);
        list.stream()
                .filter((e)->e.getAge()>=30)
                .forEach(System.out::println);

        list.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }

    public static List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> mp){
        List<Employee> emps=new ArrayList<Employee>();
        for(Employee emp:list){
            if(mp.test(emp)){
                emps.add(emp);
            }
        }
        return emps;
    }


}

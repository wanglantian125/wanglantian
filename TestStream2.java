import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream2 {
    /**
     * 筛选与切片
     * cfilter(Predicate p) 接收 Lambda ， 从流中排除某些元素。
     * distinct() 筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
     * limit(long maxSize) 截断流，使其元素不超过给定数量。
     * skip(long n) 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。
     * 内部迭代: 由stream api内部实现
     *
     * 外部跌代: 通过迭代器的跌代
     *
     *
     * 映射:
     * map  接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
     * flatMap 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
     *
     * 排序 sorted  自然排序 comparable  定制排序 comparator 加入定制的限制
     *
     *
     * allMatch(Predicate p) 检查是否匹配所有元素
     * anyMatch(Predicate p) 检查是否至少匹配一个元素
     * noneMatch(Predicate p) 检查是否没有匹配所有元素
     * findFirst() 返回第一个元素
     * findAny() 返回当前流中的任意
     * count() 返回流中元素总数
     * max(Comparator c) 返回流中最大值
     * min(Comparator c) 返回流中最小值
     *
     *
     *
     * 归约:
     * reduce(T iden, BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 T
     * 返回 Treduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
     *
     *  map-reduce 模式 map提取 reduce操作
     *
     *  收集:  collect----将流转换为其他形式 接收一个collecter接口的实现 用于给stream中元素汇总的方法
     *  Collector 接口中方法的实现决定了如何对流执行收集操作(如收集到 List、Set、Map)
     *
     *  多级分组
     *
     *  分区:true false
     *
     **/

    public static void main(String[] args) {
        List<Employee> list= Arrays.asList(
                new Employee(18,"张三","3333"),
                new Employee(28,"李四","4444"),
                new Employee(38,"王三","5555"),
                new Employee(58,"刘八","7777"),
                new Employee(48,"田七","6666")
        );
        //中间操作  延迟加载 惰性求职
        Stream<Employee> employeeStream = list.stream().skip(1).filter((e) -> e.getAge() > 30);

        Stream<Employee> employeeStream1 = list.stream().limit(1).filter((e) -> e.getAge() <= 25);


        List<String> list1=Arrays.asList("aa","bb","cc","dd");
        Stream<Stream<Character>> streamStream = list1.stream().map(TestStream2::filterCharacter);
        Stream<Character> characterStream = list1.stream().flatMap(TestStream2::filterCharacter);

        Optional<Employee> first = list.stream().sorted((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge())).findFirst();

        /*list.stream().sorted((e1, e2) -> {
            if(e1.getAge()==e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else{
                return Integer.compare(e1.getAge(),e2.getAge());
            }
        }).forEach(System.out::println);*/

        Optional<Integer> min = list.stream().map(Employee::getAge).min(Integer::compareTo);
      System.out.println("******************"+min.get());


        List<Integer> aa=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Optional<Integer> reduce = aa.stream().reduce(Integer::sum);

        Integer reduce1 = list.stream().map(Employee::getAge).reduce(0, (x, y) -> x + y);
//        System.out.println(reduce1);

        List<String> collect = list.stream().map(Employee::getName).collect(Collectors.toList());
        Set<String> collect1 = list.stream().map(Employee::getName).collect(Collectors.toSet());
        HashSet<String> collect2 = list.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new));
//        collect2.forEach(System.out::println);

        Long collect3 = list.stream().collect(Collectors.counting());
        Double collect4 = list.stream().collect(Collectors.averagingInt(Employee::getAge));
//        System.out.println("名字个数:"+collect3+"      平均年龄:"+collect4);
        Map<String, List<Employee>> collect5 = list.stream().collect(Collectors.groupingBy((e) -> {
            if (((Employee) e).getAge() >= 40) {
                return "老年";
            } else if (((Employee) e).getAge() >= 20) {
                return "中年";
            } else {
                return "少年";
            }
        }));


        Optional<Integer> reduce2 = list.stream().map(e -> 1).reduce(Integer::sum);
        System.out.println(reduce2.get());


        //终止操作      employeeStream.forEach(System.out::println);
    }























    public static Stream<Character> filterCharacter(String str){
        List<Character> list=new ArrayList<>();
        for(Character ch:str.toCharArray()){
            list.add(ch);
        }
        return list.stream();
    }
}

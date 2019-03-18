import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class LamadaTest {
    /**
     * 左侧: 表达式的参数列表 抽象方法的参数列表
     * 右侧: 所执行的功能 lamada表达式  抽象方法的实现方法
     *
     * 变化形式
     * 语法格式一: 无参无返回值得方法  ()->system.out.println("")
     * 语法格式二: 一参无返回值的方法  e->system.out.println(e)
     * 语法格式三: 一参有返回值的方法  (x,y)->{如果有多条语句必须使用大括号 且使用return,
     * 如果只有一条语句,大括号和return都可以不写}
     * 语法格式四: 左右遇一括号省  左右推断类型省  能省则省
     *
     * 四大函数式接口:
     *  1. Consumer<T> 消费接口 void accept(T t)
     *  2. Supplier<T> 供给型接口 T get()
     *  3. Predicate<T> 断言型接口 boolean test(T t)
     *  4. Function<T,R>   函数型接口 R apply(T t)
     **/
    public static void main(String[] args) {
        //需求:对一个数进行运算
        /*Integer integer = operation(100, x -> x * x);
        System.out.println(integer);
        System.out.println(operation(200,y->y+200));*/

        List<Employee> list= Arrays.asList(
                new Employee(18,"张三","3333"),
                new Employee(28,"李四","4444"),
                new Employee(38,"王三","5555"),
                new Employee(58,"刘八","7777"),
                new Employee(48,"田七","6666")
        );
        Collections.sort(list,(e1,e2)->{
            if(e1.getAge()==e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else{
                return Integer.compare(e1.getAge(),e2.getAge());
            }
        });
        list.stream().forEach(System.out::println);

    }
    public static Integer operation(Integer num,MyFun f){
      return f.getValue(num);
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamLearn {
    /**
     * 创建管道: Stream Api 数据源本身不发生变化 而会产生新流
     *  集合讲的是数据,流讲的是计算
     *  stream不会改变对象 不会存储元素  他们会返回一个持有结果的新stream
     *  stream操作是延迟执行的 意味着 他们会等到结果的时候才去执行
     *  步骤:
     *  创建stream  一个数据源获取流
     *  中间操作     对数据源数据进行处理
     *  终止操作     一个终止操作,执行中间操作链,并产生结果
     *  串行流 并行流
     *  串行 按照顺序来  并行是按照多线程随机来
     *
     *
     **/
    public static void main(String[] args) {
        //一  集合提供的Stream() parallelStream()
        List<String> list=new ArrayList<>();
        Stream<String> stream = list.stream();
        //二  通过Arrays中的静态方法Stream()获取数据流
        Employee[] emps=new Employee[10];
        Stream<Employee> stream1 = Arrays.stream(emps);
        //三  通过stream类中的静态方法of()
        Stream<String> stream2 = Stream.of("a", "b", "c");
        //四  创建无限流 迭代       生成
        Stream<Integer> iterate = Stream.iterate(0, x -> x + 2);
        Stream<Double> generate = Stream.generate(() -> Math.random());

    }
}

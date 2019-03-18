import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;

/**
 * 方法引用: 若lambda 体中内容有方法已经被实现了,我们可以使用"方法引用"
 * (可以理解为方法引用是 lambda 表达式的另外一种变现形式)
 * 主要语法:
 * 对象::实例方法名
 * 类::静态方法名
 * 类::实例方法名
 * 注意:
 * lambda 体中调用方法的参数列表与返回值类型,要与函数式接口中抽象方法的函数列表和返回值类型保持一致!
 * 若 lambda参数列表中的第一个参数是实例方法的调用者 第二个参数是实例方法的参数时,可以使用 className::method 形式!
 *
 * 构造器引用:
 *
 * 格式:
 * ClassName::new
 * 注意: 需要调用的构造器的参数列表需要与函数式中抽象方法的参数保持一致
 *
 * 数组引用:
 *
 * 格式: type::new
 *
 *
 **/

public class TestMethodRef {
    public static void main(String[] args) {
        //类::静态方法名
        Function<String,String> f=String::toUpperCase;
        System.out.println(f.apply("abcd"));

    }
}

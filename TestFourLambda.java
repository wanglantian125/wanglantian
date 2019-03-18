import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestFourLambda {
    public static void main(String[] args) {
        //
        String strHandler = strHandler("\t\t\t\t 崇尚武术  ", (str) -> str.trim());
        System.out.println(strHandler);

        //
        /*List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        System.out.println(numList);*/
    }
    //函数式接口
    public static String strHandler(String str, Function<String,String> fun){
        return fun.apply(str);
    }



    //供给型接口  产生整数并放入集合中
    public static List<Integer> getNumList(int num, Supplier<Integer> sup){
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i <num ; i++) {
            Integer a = sup.get();
            list.add(a);
        }
        return list;
    }

    //消费型接口
    public static void happy(double money,Consumer<Double> con){
        con.accept(money);
    }

}

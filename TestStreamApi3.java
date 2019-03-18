import java.util.Arrays;

public class TestStreamApi3 {
    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3,4,5};
        Arrays.stream(nums).map(x->x*x).forEach(System.out::println);
    }
}

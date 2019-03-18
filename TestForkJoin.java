import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class TestForkJoin {
    public static void main(String[] args) {
        Instant start=Instant.now();

        ForkJoinPool pool=new ForkJoinPool();
        ForkJoinTask<Long> task=new ForkJoinCaculate(0,100000000000L);
        Long sum=pool.invoke(task);
        System.out.println(sum);
        Instant end=Instant.now();
        System.out.println(Duration.between(start,end).toMillis());
    }
}

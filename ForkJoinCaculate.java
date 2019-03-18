
import java.util.concurrent.RecursiveTask;

public class ForkJoinCaculate extends RecursiveTask<Long>{
    /**
     *
     **/
    private static final long serialVersionUID=12355565845L;

    private long start;
    private long end;

    private static final long THREDSHOLD=10000L;

    public ForkJoinCaculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length=end-start;
        if(length<=THREDSHOLD){
            long sum=0L;
            for(long i=start;i<=end;i++){
                sum+=i;
            }
            return sum;
        }else{
            long middle=(start+end)/2;
            ForkJoinCaculate left=new ForkJoinCaculate(start,middle);
            left.fork();
            ForkJoinCaculate right=new ForkJoinCaculate(middle+1,end);
            right.fork();
            return left.join()+right.join();
        }
    }
}

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.LockSupport;

/**
 * 利用多线程进行代码优化
 * 多线程异步处理
 *
 **/
public class Nthead {
    public static void main(String[] args) {
        //1.利用callable包装业务代码
        //2.实际上callable 中 call方法 运行在Runable中的run方法中
        //第一步
        Callable<String> callable=new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "hello world!";
            }
        };
        //第二步
        FutureTask<String> futureTask = new FutureTask<>(callable);
        //第三步
        new Thread(futureTask).start();

        try {
            String s = futureTask.get();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //LockSupport.park()  unpark() 取代 wait() nodify() 和 火车 客人时间有点类似 晚点之后会形成一直等

    }

}

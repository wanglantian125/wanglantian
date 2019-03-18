import java.util.concurrent.CountDownLatch;

public class MaxThreadDemo {
    public static void main(String[] args) {
        CountDownLatch cd1=new CountDownLatch(1);
        try {
            Thread.sleep(20000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i=0;i<5000;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        cd1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            System.out.println("i="+i);
        }
    }
}

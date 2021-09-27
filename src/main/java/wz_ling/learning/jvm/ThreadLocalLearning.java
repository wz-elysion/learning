package wz_ling.learning.jvm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalLearning {


    static ThreadLocal<Integer> local1 = new ThreadLocal<>();
    static ThreadLocal<String> local2 = new ThreadLocal<>();

    /**
     * -Xms100m -Xmx100m -XX:+PrintGCDetails
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            local1.set(1);
            local2.set("thread1");

            Integer a = local1.get();
            String b = local2.get();
        });
        thread1.start();

        Thread thread2 = new Thread(()->{
            local1.set(2);
            local2.set("thread2");
        });
        thread2.start();

    }


}

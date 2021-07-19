package wz_ling.learning.jvm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalOOM {


    static class LocalVariable {
        private byte[] _10M = new byte[10 * 1024 * 1024];
    }

    static ThreadLocal<LocalVariable> local = new ThreadLocal<>();

    /**
     * -Xms100m -Xmx100m -XX:+PrintGCDetails
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        int nThreads = 5;
        ExecutorService es = Executors.newFixedThreadPool(nThreads);
        for (int i = 0; i < nThreads; i++) {
            es.execute(() -> {
                local.set(new LocalVariable());//占用的空间不会释放
//                new LocalVariable();
            });
        }
        try {
            Thread.sleep(20000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.gc();
        while (true) {

        }
    }


}

package wz_ling.learning.daemon;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicBoolean;

@RestController
@RequestMapping("/test/daemon")
public class DaemonTest {

    @GetMapping("1")
    public String test1() {
        System.out.println("current thread：" + Thread.currentThread().getId());
        //主线程执行完毕后，后台线程不会关闭
        daemon();
        return "ok1";
    }

    @GetMapping("2")
    public String test2() {
        System.out.println("current thread：" + Thread.currentThread().getId());
        //主线程执行完毕后，后台线程不会关闭
        new Thread(DaemonTest::daemon).start();
        return "ok2";
    }

    @GetMapping("3")
    public String test3() {
        System.out.println("current thread：" + Thread.currentThread().getId());
        //主线程执行完毕后，关闭线程
        daemon1();
        return "ok3";
    }

    private static void daemon() {
        System.out.println("start out main thread：" + Thread.currentThread().getId());
        Thread daemonThread = new Thread(() -> {
            try {
                while (true) {
                    System.out.println("daemon:" + +Thread.currentThread().getId());
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        daemonThread.start();
        try {
            Thread.sleep(5000);//主线程thread 5秒
            System.out.println("main Thread done:" + Thread.currentThread().getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void daemon1() {
        System.out.println("start out main thread：" + Thread.currentThread().getId());
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        Thread daemonThread = new Thread(() -> {
            try {
                while (atomicBoolean.get()) {
                    System.out.println("daemon:" + +Thread.currentThread().getId());
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        //这里设置为后台线程，
        daemonThread.start();
        try {
            Thread.sleep(5000);//主线程thread 5秒
            System.out.println("main Thread done:" + Thread.currentThread().getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
//                daemonThread.interrupt();
                //这里可以做释放锁的操作
                System.out.println("release lock");
                atomicBoolean.set(false);
            } catch (Exception e) {

            }
        }
    }

    public static void main(String[] args) {
        daemon();//主线程执行完毕后，后台线程会自动关闭
    }

}
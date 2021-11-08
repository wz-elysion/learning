package wz_ling.learning.concurrent;

public class WaitDemo {

    public static void main(String[] args) {
//        WaitDemo waitDemo = new WaitDemo();
//        new Thread(() -> {
//            try {
//                Thread.sleep(1000000L);
//            } catch (InterruptedException e) {
//                System.out.println("abc");
//                e.printStackTrace();
//            }
//        }).start();
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1000000L);
            } catch (InterruptedException e) {
                System.out.println("我醒了");
                e.printStackTrace();
            }
        });
        t.start();
        t.interrupt();

    }

}

public class Daemon {


    public static void main(String[] args) {
        System.out.println("start out main thread");
        Thread daemonThread = new Thread(() -> {
            try {
                while (true) {
                    System.out.println("发送心跳");
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        daemonThread.setDaemon(true);
        daemonThread.start();
        try {
            Thread.sleep(5000);//主线程thread 5秒
            System.out.println("main Thread done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

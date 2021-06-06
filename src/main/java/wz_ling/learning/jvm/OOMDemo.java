package wz_ling.learning.jvm;

import java.util.ArrayList;
import java.util.List;

public class OOMDemo {

    public static final int _1M = 1024 * 1024;

    byte[] bytes;

    public OOMDemo(int size) {
        bytes = new byte[size];
    }

    /**
     * 当Inner定义在内部时OOM，当定义在外面时，不会OOM，因为OOMDemo的占用内存会释放。
     *
     * @return
     */
    public Inner getInner() {
        return new Inner();
    }

    /**
     * -Xms8m -Xmx8m
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Inner> oomList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            oomList.add(new OOMDemo(_1M).getInner());
            System.out.println(i);
        }
    }

//    class Inner {
//
//    }

}

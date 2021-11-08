import java.util.concurrent.atomic.AtomicInteger;

public class Demo {

    static class Node {
        int value;
        Node next;
    }

    public static void main(String[] args) {

        Node node1 = new Node();
        Node node2 = new Node();
        node1.value = 1;
        node1.next = node2;
        node2.value = 2;
        Node reverse = reverse(node1);
        System.out.println();
    }


    public static Node reverse(Node node) {
        Node target = new Node();
        Node cur = node;
        while (cur != null) {
            //获取下一个节点,避免中途链断掉
            Node next = cur.next;
            //将targer指向next
            cur.next = target;
            //将target指向next
            target = cur;
            //以上两步，保证了target在cur之前
            //将cur置下一个节点
            cur = next;
        }
        return target;
    }

    //
    public Node reverse1() {
        //应该也可以递归做
        return null;
    }
}

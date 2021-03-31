package data.structures.and.algorithms.list;

public class ReverseList {

    static class Node<T> {
        T current;
        Node<T> next;

        public Node(T current, Node<T> next) {
            this.current = current;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node<Integer> tail = new Node<>(4, null);
        Node<Integer> node3 = new Node<>(3, tail);
        Node<Integer> node2 = new Node<>(2, node3);
        Node<Integer> node1 = new Node<>(1, node2);
        Node<Integer> head = new Node<>(null, node1);

        Node<Integer> newNode = reverse(head);
        while (newNode != null) {
            System.out.println(newNode.current);
            newNode = newNode.next;
        }
    }

    public static <T> Node<T> reverse(Node<T> node) {
        Node<T> target = null;
        while (true) {
            if (node == null) {
                break;
            }
            target = new Node<>(node.current, target);
            node = node.next;
        }
        return target;
    }

}

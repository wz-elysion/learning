package wz_ling.learning.data.structures.and.algorithms.list;

/**
 * 链表反转
 */
public class ReverseList {

    public static void main(String[] args) {
        SinglyLinkedList<Integer> source = SinglyLinkedList.getSinglyLinkedList(1, 2, 3, 4);
        System.out.println(reverse(source));
    }

    public static <T> SinglyLinkedList<T> reverse(SinglyLinkedList<T> singlyLinkedList) {
        SinglyLinkedList<T> target = null;
        while (singlyLinkedList != null) {
            target = new SinglyLinkedList<>(singlyLinkedList.value, target);
            singlyLinkedList = singlyLinkedList.next;
        }
        return target;
    }

}

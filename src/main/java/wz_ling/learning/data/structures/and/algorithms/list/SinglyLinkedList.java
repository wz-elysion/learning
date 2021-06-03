package wz_ling.learning.data.structures.and.algorithms.list;

import static java.util.Objects.nonNull;

/**
 * 单向链表
 *
 * @param <T>
 */
public class SinglyLinkedList<T> {
    T value;
    SinglyLinkedList<T> next;

    public SinglyLinkedList(T value, SinglyLinkedList<T> next) {
        this.value = value;
        this.next = next;
    }

    public SinglyLinkedList(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(value);
        SinglyLinkedList<T> tmp = next;
        while (nonNull(tmp)) {
            sb.append(",");
            sb.append(tmp.value);
            tmp = tmp.next;
        }
        sb.append("]");
        return sb.toString();
    }

    @SafeVarargs
    public static <T> SinglyLinkedList<T> getSinglyLinkedList(T... tList) {
        if (tList.length == 0) {
            return null;
        }
        SinglyLinkedList<T> target = new SinglyLinkedList<T>(null);
        SinglyLinkedList<T> tail = target;
        for (T t : tList) {
            tail.next = new SinglyLinkedList<T>(t);
            tail = tail.next;
        }
        return target.next;
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> rs = getSinglyLinkedList(1, 2, 3, 4);
        System.out.println(rs);
    }


}

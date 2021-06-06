package wz_ling.learning.data.structures.and.algorithms.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * 升序链表合并
 */
public class MergeList {


    public static void main(String[] args) {
        testMergeTwo();
        testMergeK();
    }

    public static void testMergeK() {
        SinglyLinkedList<Integer> list1 = SinglyLinkedList.getSinglyLinkedList(1, 4, 5);
        SinglyLinkedList<Integer> list2 = SinglyLinkedList.getSinglyLinkedList(1, 3, 4);
        SinglyLinkedList<Integer> list3 = SinglyLinkedList.getSinglyLinkedList(2, 6);
        List<SinglyLinkedList<Integer>> source = Arrays.asList(list1, list2, list3);
        System.out.print(source);
        System.out.print("--->");
        SinglyLinkedList<Integer> rs = mergeK(source);
        System.out.println(rs);
    }

    public static void testMergeTwo() {
        SinglyLinkedList<Integer> list1 = SinglyLinkedList.getSinglyLinkedList(1, 3, 5, 7);
        SinglyLinkedList<Integer> list2 = SinglyLinkedList.getSinglyLinkedList(2, 3, 6, 9);
        System.out.print(Arrays.asList(list1, list2));
        System.out.print("--->");
        SinglyLinkedList<Integer> rs = mergeTwo(list1, list2);
        System.out.println(rs);
    }

    public static SinglyLinkedList<Integer> mergeK(List<SinglyLinkedList<Integer>> lists) {
        if (isNull(lists) || lists.size() == 0) {
            return null;
        }
        if (lists.size() == 1) {
            return lists.get(0);
        }
        int newSize = (lists.size() + 1) / 2;
        List<SinglyLinkedList<Integer>> newLists = new ArrayList<>(newSize);
        for (int i = 0; i < newSize; i++) {
            if (i == lists.size() - i - 1) {
                newLists.add(lists.get(i));
            } else {
                newLists.add(mergeTwo(lists.get(i), lists.get(lists.size() - i - 1)));
            }
        }
        return mergeK(newLists);
    }

    /**
     * @param list1
     * @param list2
     * @return
     */
    public static SinglyLinkedList<Integer> mergeTwo(SinglyLinkedList<Integer> list1, SinglyLinkedList<Integer> list2) {
        if (isNull(list1)) {
            return list2;
        }
        if (isNull(list2)) {
            return list1;
        }
        SinglyLinkedList<Integer> target = new SinglyLinkedList<>(null);

        SinglyLinkedList<Integer> tail = target, a = list1, b = list2;
        while (nonNull(a) && nonNull(b)) {
            if (a.value < b.value) {
                target.next = a;
                a = a.next;
            } else {
                target.next = b;
                b = b.next;
            }
            target = target.next;
        }
        target.next = isNull(a) ? b : a;
        return tail.next;
    }


}

package wz_ling.learning.data.structures.and.algorithms.list;

import static java.util.Objects.isNull;

/**
 * 合并升序数组
 */
public class MergeArray {

    public static void main(String[] args) {
        int[] array1 = new int[]{1, 3, 5};
        int[] array2 = new int[]{2, 3};
        int[] rs = mergeTwo(array1, array2);
        System.out.println(rs);
    }

    public static int[] mergeTwo(int[] array1, int[] array2) {
        if (isNull(array1) || array1.length == 0) {
            return array2;
        }
        if (isNull(array2) || array2.length == 0) {
            return array1;
        }
        int[] array = new int[array1.length + array2.length];
        int aIndex = 0;
        int bIndex = 0;
        int arrayIndex = 0;
        while (arrayIndex < array1.length + array2.length) {
            if (aIndex == array1.length) {
                array[arrayIndex] = array2[bIndex];
                bIndex++;
                arrayIndex++;
                continue;
            }
            if (bIndex == array2.length) {
                array[arrayIndex] = array1[aIndex];
                aIndex++;
                arrayIndex++;
                continue;
            }
            if (array1[aIndex] < array2[bIndex]) {
                array[arrayIndex] = array1[aIndex];
                aIndex++;
            } else {
                array[arrayIndex] = array2[bIndex];
                bIndex++;
            }
            arrayIndex++;
        }
        return array;
    }

}

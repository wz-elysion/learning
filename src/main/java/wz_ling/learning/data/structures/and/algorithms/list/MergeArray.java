package wz_ling.learning.data.structures.and.algorithms.list;

import java.util.Arrays;

/**
 * 合并升序数组
 */
public class MergeArray {

    public static void main(String[] args) {
        int[] array1 = new int[]{0};
        int[] array2 = new int[]{1};
        merge1(array1, 0, array2, 1);

    }

    /**
     * 双指针：时间复杂的O(m+n),空间复杂度O(m+n)
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] array = new int[m + n];
        int aIndex = 0;
        int bIndex = 0;
        int arrayIndex = 0;
        while (aIndex < m || bIndex < n) {
            if (aIndex == m) {
                array[arrayIndex++] = nums2[bIndex++];
                continue;
            }
            if (bIndex == n) {
                array[arrayIndex++] = nums1[aIndex++];
                continue;
            }
            array[arrayIndex++] = nums1[aIndex] < nums2[bIndex] ? nums1[aIndex++] : nums2[bIndex++];
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = array[i];
        }
        System.out.println(Arrays.toString(nums1));
    }


    /**
     * 逆向双指针：时间复杂的O(m+n),空间复杂度O(1)
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int aIndex = m - 1;
        int bIndex = n - 1;
        int arrayIndex = m + n - 1;
        while (aIndex > -1 || bIndex > -1) {
            if (aIndex == -1) {
                nums1[arrayIndex--] = nums2[bIndex--];
                continue;
            }
            if (bIndex == -1) {
                nums1[arrayIndex--] = nums1[aIndex--];
                continue;
            }
            nums1[arrayIndex--] = nums1[aIndex] > nums2[bIndex] ? nums1[aIndex--] : nums2[bIndex--];
        }
        System.out.println(Arrays.toString(nums1));
    }

}

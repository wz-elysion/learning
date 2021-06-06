package wz_ling.learning.data.structures.and.algorithms.list;

/**
 * 寻找两个有序数组的中位数。
 * eg:[1,3],[2]-->2.000;[1,2],[3,4]->2.500
 */
public class FindMedian {


    public static void main(String[] args) {
        int[] array1 = new int[]{1, 3};
        int[] array2 = new int[]{2};
        int[] array3 = new int[]{1, 2};
        int[] array4 = new int[]{3, 4};
        System.out.println(solution1(array1, array2));
        System.out.println(solution1(array3, array4));
    }

    /**
     * 合并两个数组。时间复杂度O(m+n)，空间复杂度O(m+n)
     *
     * @param array1
     * @param array2
     * @return
     */
    public static Double solution1(int[] array1, int[] array2) {
        int[] rs = MergeArray.mergeTwo(array1, array2);
        int max = rs[rs.length / 2];
        int min = rs.length % 2 == 0 ? rs[rs.length / 2 - 1] : rs[rs.length / 2];
        return (min + max) / 2.0;
    }


}
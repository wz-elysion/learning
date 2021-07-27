package wz_ling.learning.data.structures.and.algorithms.list;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public static void main(String[] args) {
//        int[][] array = {
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12}
//        };
//        int[][] array = {
//                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
//        };
        int[][] array = {{6, 9, 7}};
//        int[][] array = {{2, 5}, {8, 4}, {0, -1}};
        spiralOrder(array);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        int m = matrix.length;
        if (m == 0) {
            return null;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        print(matrix, 0, list);
        System.out.println(list);
        return list;
    }

    public static void print(int[][] arrays, int c, List<Integer> list) {
        //m行，n列，第c圈
        int m = arrays.length;
        int n = arrays[0].length;

        int bottomRow = m - c - 1;
        int rightCol = n - c - 1;
        //上
        for (int i = c; i < n - c - 1; i++) {
            list.add(arrays[c][i]);
        }
        //右
        for (int i = c; i <= m - c - 1; i++) {
            list.add(arrays[i][rightCol]);
        }
        //下
        for (int i = n - c - 2; i > c; i--) {
            if (c < bottomRow) {
                list.add(arrays[bottomRow][i]);
            }
        }
        //左
        for (int i = m - c - 1; i > c; i--) {
            if (c < rightCol) {
                list.add(arrays[i][c]);
            }
        }
        //终止条件
        if (c < (Math.min(m, n) + 1) / 2 - 1) {
            print(arrays, c + 1, list);
        }

    }

}

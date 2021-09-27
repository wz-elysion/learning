package wz_ling.learning.data.structures.and.algorithms.list;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution {


    public static void main(String[] args) {
        System.out.println(cuttingRope(120));
    }


    public static int cuttingRope(int n) {
        long max = 1;
        for (int m = 2; m <= n; m++) {
            long max1 = 1;
            int[] k = new int[m];
            int t = n % m;
            int base = n / m;

            for (int i = 0; i < m; i++) {
                k[i] = i < t ? base + 1 : base;
                max1 *= k[i];
            }
            max = Math.max(max, max1);
        }
        return (int) (max % 1000000007);
    }

    public static int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        boolean[][] flag = new boolean[m][n];
        return next(0, 0, k, flag);
    }

    public static int next(int m, int n, int k, boolean[][] flag) {
        if (m >= flag.length || n >= flag[0].length) {
            //越界了
            return 0;
        }
        if (flag[m][n]) {
            //已经算过的
            return 0;
        }
        if (getNumSum(m) + getNumSum(n) > k) {
            return 0;
        }
        flag[m][n] = true;
        int sum1 = next(m + 1, n, k, flag);
        int sum2 = next(m, n + 1, k, flag);
        return 1 + sum1 + sum2;
    }


    public static int getNumSum(int num) {
        int sum = 0;
        while (num / 10 > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum + num;
    }


    public static int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }
        int[] rs = new int[stack.size()];
        for (int i = 0; i < rs.length; i++) {
            rs[i] = stack.pop();
        }
        return rs;
    }


    public static String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }


    public static int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return nums[i];
            }
        }
        return -1;
    }

    public static int[] countBits(int n) {
        int[] rs = new int[n + 1];
        rs[0] = 0;
        if (n == 0) {
            return rs;
        }
        rs[1] = 1;
        if (n == 1) {
            return rs;
        }
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                rs[i] = rs[i >> 1];
            } else {
                rs[i] = rs[i >> 1] + 1;
            }
        }
        return rs;
    }

    public static String addBinary(String a, String b) {
        int aIndex = a.length();
        int bIndex = b.length();
        if (aIndex == 0) {
            return b;
        }
        if (bIndex == 0) {
            return a;
        }
        StringBuilder rs = new StringBuilder();
        //进位标识
        int flag = 0;
        while (aIndex > 0 || bIndex > 0) {
            //获取aIndex-1的字符，并将aIndex--
            int c_a = (aIndex - 1) < 0 ? 0 : a.charAt(aIndex - 1) - '0';
            int c_b = (bIndex - 1) < 0 ? 0 : b.charAt(bIndex - 1) - '0';
            int tmp = c_a + c_b + flag;
            if (tmp > 1) {
                flag = 1;
                tmp -= 2;
            } else {
                flag = 0;
            }
            rs.append(tmp);
            aIndex--;
            bIndex--;
        }
        if (flag == 1) {
            rs.append(flag);
        }
        return rs.reverse().toString();
    }

    public static int devide(int a, int b) {
//        int x = a;
//        int y = b;
//        int count = 1;
//        while (a > b) {
//            a = a >> 1;
//            count++;
//        }
//        while (x > y){
//
//        }

        //结果正负
        boolean flag = (a > 0 && b > 0) || (a < 0 && b < 0);
        long m = a > 0 ? a : -(long) a;
        long n = b > 0 ? b : -(long) b;
        long y = n;
        if (m < n) {
            return 0;
        }
        while (m >= n) {
            n = n << 1;
        }
        long rs = 0;//移动第一次
        n = n >> 1;
        while (true) {
            if (m >= n) {
                rs += 1;
                m = m - n;
            } else {
                rs += 0;
            }
            if (y == n) {
                break;
            }
            rs = rs << 1;
            n = n >> 1;
        }

        rs = flag ? rs : -rs;
        return rs > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) rs;
    }

    public static void reverse(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTmp = current.next;
            current.next = pre;
            pre = current;
            current = nextTmp;
        }

    }

    public static void reorderList(ListNode head) {
        //找出中点
        ListNode slow = head;//1
        ListNode fast = head;//1
        while (fast != null && fast.next != null) {
            slow = slow.next;//2,3,4
            fast = fast.next.next;//3,5,null
        }
        //将链表拆成前后两段
        ListNode front = head;
        ListNode behind = slow.next;
        slow.next = null;//断开链表
        //反转后半段链表
        ListNode target = null;
        ListNode current = behind;
        while (current != null) {
            ListNode nextTmp = current.next;
            current.next = target;
            target = current;
            current = nextTmp;
        }
        while (front != null && target != null) {
            ListNode frontNext = front.next;
            ListNode targetNext = target.next;

            front.next = target;
            front = frontNext;

            target.next = front;
            target = targetNext;
        }
        System.out.println();
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode target = new ListNode(-1);
        ListNode tail = target;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1 != null ? l1 : l2;
        return target.next;
    }


    public static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int len = s.length();
        int maxLen = 0;
        int i = 0;
        int j = 0;
        HashSet<Character> set = new HashSet<>();
        while (i < len) {
            if (i > 0) {
                set.remove(s.charAt(i - 1));
            }
            i++;
            while (j < len) {
                boolean b = set.add(s.charAt(j));
                if (!b) {
                    break;
                }
                maxLen = maxLen > set.size() ? maxLen : set.size();
                j++;
            }
        }
        return maxLen;

    }
}

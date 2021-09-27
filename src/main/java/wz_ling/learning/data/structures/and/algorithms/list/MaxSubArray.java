package wz_ling.learning.data.structures.and.algorithms.list;

public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, -2, -3};
        int i = maxSubArray(nums);
        System.out.println(i);
    }

    /**
     * 可以找到这样得规律，f(i)=max{f(i−1)+nums[i],nums[i]}
     * 说明：
     * f(i−1) =0，f(i−1)+nums[i] = nums[i]
     * f(i−1) <0，f(i−1)+nums[i] < nums[i]
     * 那么前i的最大子数是nums[i]，必然比f(i−1)【前i-1的最大子数】要大，以下同理
     * f(i−1) >0，f(i−1)+nums[i] > nums[i]
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    //解法二：线段树TODO

}

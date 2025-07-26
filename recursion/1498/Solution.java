public class Solution {

    public static void main(String[] args) {
        int[] nums = { 2, 3, 5, 7, 9 };
        int target = 100;
        System.out.println(numSubseq(nums, target));
    }

    public static boolean numSubseq(int[] nums, int target) {
        int index = 0;
        return getNum(index, nums, target, 0, nums.length) == 0 ? false : true;
    }

    static int getNum(int index, int[] nums, int target, int sum, int maxSize) {
        if (sum == target) return 1;
        if (sum > target) return 0;
        if (index >= maxSize) return 0;
        int l = getNum(index + 1, nums, target, sum + nums[index], maxSize);
        int r = getNum(index + 1, nums, target, sum, maxSize);
        return l + r;
    }
}

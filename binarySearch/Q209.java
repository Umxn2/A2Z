public class Q209 {

  public static void main(String[] args) {

    int[] nums = { 2, 3, 1, 2, 4, 3 };
    int target = 7;
    System.out.println(minSubArrayLen(target, nums));
  }

  public static int minSubArrayLen(int target, int[] nums) {

    int size = nums.length;
    long[] cumilative = new long[size];
    long sum = 0L;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] >= target)
        return 1;
      sum += nums[i];
      cumilative[i] = sum;
    }
    int min = Integer.MAX_VALUE;

    for (int i = cumilative.length - 1; i >= 1; i--) {
      int index = findLowestIndex(cumilative, cumilative[i], target, i - 1);
      if (index == Integer.MIN_VALUE)
        continue;
      min = Math.min(min, i - index);
    }

    if (min == Integer.MAX_VALUE)
      return 0;
    return min;
  }

  public static int findLowestIndex(long[] cumilative, long currCum, int target, int end) {
    int l = 0;
    int r = end;
    int output = Integer.MIN_VALUE;
    while (l <= r) {
      int mid = (r - l) / 2 + l;
      if (currCum - cumilative[mid] >= target) {
        output = mid;
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return output;
  }
}

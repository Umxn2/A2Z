import java.util.HashMap;
import java.util.Map;

public class LongestsubarraywithsumK {

  public static void main(String[] args) {

    int nums[] = { 10, 5, 2, 7, 1, 9 };
    int k = 15;
    System.out.println(longestSubarray(nums, k));
  }

  public static int longestSubarray(int[] nums, int k) {

    // two ways to do this
    // prefix sum (im more comfortable with)
    // 2 pointers
    // we try with 2 pointers today
    // we can't do with 2 pointers because there can be negative numbers also
    // usually the optimization with 2 pointers is that we have a heurestic which
    // can suggest what things are already covered
    int maxLen = 0;
    Map<Integer, Integer> map = new HashMap<>();
    int currSum = 0;
    for (int i = 0; i < nums.length; i++) {
      currSum += nums[i];
      if (map.containsKey(currSum - k)) {
        maxLen = Math.max(i - map.get(currSum - k), maxLen);
      }
      map.put(currSum, i);
    }

    return maxLen;
  }
}

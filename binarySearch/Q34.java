public class Q34 {

  public static void main(String[] args) {

    int[] nums = { 5, 7, 7, 8, 8, 10 };
    int target = 8;
    int[] output = searchRange(nums, target);
    for (int i : output) {
      System.out.println(i);
    }
  }

  public static int[] searchRange(int[] nums, int target) {

    int l = lowerBound(nums, target);
    int r = upperBound(nums, target);
    int[] output = { r, l };
    return output;
  }

  public static int lowerBound(int[] nums, int target) {

    int l = 0;
    int r = nums.length - 1;
    int output = -1;
    while (l <= r) {
      int mid = (r - l) / 2 + l;
      if (nums[mid] == target)
        output = mid;
      if (nums[mid] <= target) {
        l = mid + 1;
      } else if (nums[mid] > target)
        r = mid - 1;
    }
    return output;
  }

  public static int upperBound(int[] nums, int target) {

    int l = 0;
    int r = nums.length - 1;
    int output = -1;
    while (l <= r) {
      int mid = (r - l) / 2 + l;
      if (nums[mid] == target)
        output = mid;
      if (nums[mid] < target) {
        l = mid + 1;
      } else if (nums[mid] >= target)
        r = mid - 1;
    }
    return output;

  }

}

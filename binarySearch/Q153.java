public class Q153 {

  public static void main(String[] args) {
    int[] nums = { 11, 13, 15, 17 };
    System.out.println(findMin(nums));
  }

  public static int findMin(int[] nums) {

    int l = 1;
    int r = nums.length - 1;

    if (nums[0] < nums[1] && nums[0] < nums[nums.length - 1])
      return nums[0];
    else if (nums[nums.length - 1] < nums[nums.length - 2] && nums[nums.length - 1] < nums[0])
      return nums[nums.length - 1];

    while (l <= r) {
      int mid = (r - l) / 2 + l;
      if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1])
        return nums[mid];
      else if (nums[mid] > nums[0])
        l = mid + 1;
      else
        r = mid - 1;
    }

    return -1;
  }
}

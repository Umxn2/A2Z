public class MedianofTwoSortedArrays {

  public static void main(String[] args) {

    int[] nums1 = { 1, 2 };
    int[] nums2 = { 3 };
    System.out.println(findMedianSortedArrays(nums1, nums2));
  }

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

    int len1 = nums1.length;
    int len2 = nums2.length;

    double median = 0.0;
    int total_nums = len1 + len2;
    if (total_nums / 2 == 0) {
      // find two numbers one greater than n/2 and n/2+1
    } else {
      // find n/2 + 1
    }

    // suppose the number is in array 1

    // median can be thought as finding a number that is bigger than
    // n/2 of the total numbers
    //
    int index = findNum(total_nums / 2 + 1, nums1, nums2);
    if (index == -1)
      throw new RuntimeException("cooked");

    return (double) nums1[index];
  }

  public static int findNum(int rankNeeded, int[] num1, int[] num2) {

    int l = 0;
    int r = num1.length - 1;
    while (l <= r) {

      int mid = (l + r) / 2;
      if (findRank(num1[mid], true, num1, num2, mid) == rankNeeded)
        return mid;
      else if (findRank(num1[mid], true, num1, num2, mid) > rankNeeded) {
        r = mid + 1;
      } else
        l = mid - 1;

    }
    return -1;

  }

  public static int findRank(int n, boolean first, int[] nums1, int[] nums2, int index) {
    int rank = index;
    if (first)
      rank += numLess(n, nums2);
    else
      rank += numLess(n, nums1);
    return rank;
  }

  public static int numLess(int n, int[] nums) {
    int l = 0;
    int r = nums.length - 1;
    int output = 0;
    while (l <= r) {
      int mid = (r + l) / 2;
      if (nums[mid] == n)
        return mid;
      else if (nums[mid] > n)
        r = mid + 1;
      else {
        l = mid - 1;
        output = l;
      }
    }
    return output;
  }
}

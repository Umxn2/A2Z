import java.util.Random;

public class SearchinRotatedSortedArray {

  private static final int LENGTH = 200_000_000;
  private static final int ITERATIONS = 100_000;

  public static void main(String[] args) {
    Random random = new Random();
    int[] nums = new int[LENGTH];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = i;
    }

    int pivot = random.nextInt(LENGTH);
    int[] rotated = new int[LENGTH];
    for (int i = 0; i < LENGTH; i++) {
      rotated[i] = nums[(i + pivot) % LENGTH];
    }

    for (int i = 0; i < 100; i++) {
      int dummyTarget = random.nextInt(LENGTH);
      search(rotated, dummyTarget);
      search2(rotated, dummyTarget);
    }

    long totalTimeSearch1 = 0;
    long totalTimeSearch2 = 0;

    long start;
    long end;
    int target;
    for (int i = 0; i < ITERATIONS; i++) {

      target = random.nextInt(LENGTH);
      start = System.nanoTime();
      search(rotated, target);
      end = System.nanoTime();
      totalTimeSearch1 += (end - start);

      target = random.nextInt(LENGTH);
      start = System.nanoTime();
      search2(rotated, target);
      end = System.nanoTime();
      totalTimeSearch2 += (end - start);

    }

    System.out.printf("search() avg time:  %.2f ns%n", totalTimeSearch1 / (double) ITERATIONS);
    System.out.printf("search2() avg time: %.2f ns%n", totalTimeSearch2 / (double) ITERATIONS);
  }

  public static int search(int[] nums, int target) {
    int l = 0;
    int r = nums.length - 1;
    while (l <= r) {
      int mid = (r - l) / 2 + l;
      int currElem = nums[mid];
      if (target == currElem)
        return mid;
      if (currElem >= nums[l]) {
        if (target >= nums[l] && target <= currElem) {
          r = mid - 1;
        } else {
          l = mid + 1;
        }
      } else {
        if (target <= nums[r] && target >= currElem) {
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }

    }
    return -1;
  }

  static int binarySearch(int[] nums, int l, int r, int target) {

    while (l <= r) {
      int mid = (r - l) / 2 + l;
      if (nums[mid] == target)
        return mid;
      else if (nums[mid] < target)
        l = mid + 1;
      else
        r = mid - 1;
    }
    return -1;

  }

  public static int search2(int[] nums, int target) {
    int left = 0, right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (nums[mid] == target) {
        return mid;
      }

      if (nums[left] <= nums[mid]) {
        if (nums[left] <= target && target < nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else {
        if (nums[mid] < target && target <= nums[right]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }

    return -1;
  }
}

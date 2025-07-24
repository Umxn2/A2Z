import java.util.ArrayList;

public class LeftRotateArraybyKPlaces {

  public static void main(String[] args) {

    int[] nums = { 1, 2, 3, 4, 5, 6 };
    int k = 2;
    k = k % nums.length;
    rotateArray(nums, k);
  }

  public static void rotateArray(int[] nums, int k) {

    int size = nums.length;
    reverse(nums, 0, size - 1);
    reverse(nums, 0, size - k - 1);
    reverse(nums, size - k, size - 1);
    for (int i = 0; i < nums.length; i++) {
      System.out.println(nums[i]);
    }

  }

  public static void reverse(int[] nums, int beg, int end) {

    int count = 0;
    for (int i = beg; i <= end / 2; i++) {
      int temp = nums[i];
      nums[i] = nums[end - count];
      nums[end - count] = temp;
      count++;
    }

  }

  static ArrayList<Integer> getInput() {

    ArrayList<Integer> input = new ArrayList<>();
    input.add(1);
    input.add(2);
    input.add(3);
    input.add(4);
    input.add(5);
    input.add(6);
    return input;

  }

}

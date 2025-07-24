import java.util.ArrayList;
import java.util.List;

class Solution {

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3 };
    List<List<Integer>> output = subsets(nums);
    for (List<Integer> list : output) {
      list.forEach((num) -> System.out.print(num + " "));
      System.out.println();
    }
  }

  public static List<List<Integer>> subsets(int[] nums) {

    List<List<Integer>> output = new ArrayList<>();
    List<Integer> curraArr = new ArrayList<>();
    int index = 0;
    int max = nums.length;
    getSubsets(output, curraArr, index, max, nums);
    return output;
  }

  static void getSubsets(List<List<Integer>> output, List<Integer> curraArr, int index, int max, int[] nums) {
    if (max == index) {
      List<Integer> temp = new ArrayList<>(curraArr);
      output.add(temp);
      return;
    }
    curraArr.add(nums[index]);
    getSubsets(output, curraArr, index + 1, max, nums);
    curraArr.remove(curraArr.size() - 1);
    getSubsets(output, curraArr, index + 1, max, nums);
  }
}

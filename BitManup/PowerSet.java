import java.util.ArrayList;
import java.util.List;

public class PowerSet {
  public static void main(String[] args) {
    int[] arr = new int[24];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = i;
    }

    printSubset(arr);

  }

  public static void printSubset(int[] arr) {

    List<List<Integer>> store = new ArrayList<>();
    List<List<Integer>> store2 = new ArrayList<>();
    List<Integer> nums = new ArrayList<>();
    int index = arr.length - 1;
    // printSubset(arr, index, store, nums);
    printSubset(arr, store2);
    // print(store2);
  }

  public static void print(List<List<Integer>> store) {
    for (var temp : store) {
      for (var elem : temp) {
        System.out.printf(elem + " ");
      }
      System.out.println();
    }
  }

  public static void printSubset(int[] arr, int index, List<List<Integer>> store, List<Integer> nums) {

    if (index == -1) {
      ArrayList<Integer> shallowCopy = new ArrayList<>(nums);
      store.add(shallowCopy);
      return;
    }
    nums.add(arr[index]);
    printSubset(arr, index - 1, store, nums);
    nums.remove(nums.size() - 1);
    printSubset(arr, index - 1, store, nums);
  }

  public static void printSubset(int[] arr, List<List<Integer>> store) {

    int len = arr.length;
    int nums = 1 << len;
    for (int i = 0; i < nums; i++) {
      List<Integer> temp = new ArrayList<>();
      for (int j = 0; j < len; j++) {
        if (findInIndex(i, j) == 1) {
          temp.add(arr[j]);
        }
      }
      store.add(temp);
    }

  }

  public static int findInIndex(int num, int index) {
    return ((num >> index) & 1);
  }

}

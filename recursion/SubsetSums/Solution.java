package SubsetSums;

import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 1 };
        Solution solution = new Solution();
        ArrayList<Integer> outputList = solution.subsetSums(arr);
        outputList.forEach(num -> System.err.println(num));
    }

    public ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> output = new ArrayList<>();
        gatherSums(0, arr, 0, output);
        output.add(0);
        return output;
    }

    public void gatherSums(
        int index,
        int[] arr,
        int sum,
        ArrayList<Integer> output
    ) {
        if (index == arr.length) return;
        gatherSums(index + 1, arr, sum + arr[index], output);
        output.add(sum + arr[index]);
        gatherSums(index + 1, arr, sum, output);
    }
}

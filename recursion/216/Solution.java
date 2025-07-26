import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        int k = 4;
        int n = 1;
        List<List<Integer>> output = combinationSum3(k, n);
        for (List<Integer> i : output) {
            i.forEach(num -> System.out.print(num + " "));
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> currArr = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        gatherCombinations(n, k, currArr, output, 1, 0);
        return output;
    }

    private static void gatherCombinations(
        int target,
        int outputSize,
        List<Integer> currArr,
        List<List<Integer>> output,
        int index,
        int sum
    ) {
        if (currArr.size() > outputSize || sum > target) return;
        if (sum == target && currArr.size() == outputSize) {
            output.add(new ArrayList<>(currArr));
        }
        for (int i = index; i <= 9; i++) {
            currArr.add(i);
            gatherCombinations(
                target,
                outputSize,
                currArr,
                output,
                i + 1,
                sum + i
            );
            currArr.remove(Integer.valueOf(i));
        }
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;
        List<List<Integer>> output = combinationSum(candidates, target);
        for (List<Integer> i : output) {
            i.forEach(num -> System.out.print(num + " "));
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum(
        int[] candidates,
        int target
    ) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> currArr = new ArrayList<>();
        Arrays.sort(candidates);
        getAllLists(
            output,
            target,
            0,
            currArr,
            0,
            candidates.length,
            candidates
        );
        return output;
    }

    static void getAllLists(
        List<List<Integer>> output,
        int target,
        int currSum,
        List<Integer> currArr,
        int index,
        int maxSize,
        int[] candidates
    ) {
        if (currSum == target) output.add(new ArrayList<>(currArr));
        if (index >= maxSize) return;
        if ((currSum + candidates[index]) <= target) {
            currArr.add(candidates[index]);
            getAllLists(
                output,
                target,
                currSum + candidates[index],
                currArr,
                index,
                maxSize,
                candidates
            );
            currArr.remove(currArr.size() - 1);
        } else {
            return;
        }
        getAllLists(
            output,
            target,
            currSum,
            currArr,
            index + 1,
            maxSize,
            candidates
        );
    }
}

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        String digits = "23";
        List<String> output = letterCombinations(digits);
        output.forEach(ans -> System.out.println(ans));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> output = new ArrayList<>();
        if (digits.equals("")) return output;
        String[] map = new String[10];
        map[4] = "ghi";
        map[7] = "pqrs";
        map[2] = "abc";
        map[5] = "jkl";
        map[8] = "tuv";
        map[3] = "def";
        map[6] = "mno";
        map[9] = "wxyz";
        String currOutput = "";
        getCombination(digits, currOutput, output, 0, map);
        return output;
    }

    public static void getCombination(
        String digits,
        String currOutput,
        List<String> output,
        int index,
        String[] map
    ) {
        if (index == digits.length()) {
            output.add(new String(currOutput));
            return;
        }
        char currDigit = digits.charAt(index);
        for (int i = 0; i < map[currDigit - '0'].length(); i++) {
            getCombination(
                digits,
                currOutput + map[currDigit - '0'].charAt(i),
                output,
                index + 1,
                map
            );
        }
    }
}

import java.util.ArrayList;
import java.util.List;

class Solution {
  public static void main(String[] args) {
    int n = 1;
    List<String> output = generateParenthesis(n);
    for (String string : output) {
      System.out.println(string);
    }
  }

  public static List<String> generateParenthesis(int n) {
    int opening = n;
    int closing = n;
    List<String> output = new ArrayList<>();
    String currString = "";
    generateParenthesis(closing, opening, 0, currString, output);
    return output;
  }

  static void generateParenthesis(int closing, int opening, int open, String currString, List<String> output) {

    if (opening == 0 && closing == 0) {
      String temp = new String(currString);
      output.add(temp);
      return;
    }
    if (opening > 0) {

      currString = currString.concat("(");
      generateParenthesis(closing, opening - 1, open + 1, currString, output);
      currString = currString.substring(0, currString.length() - 1);

    }

    if (open > 0 && closing > 0) {

      currString = currString.concat(")");
      generateParenthesis(closing - 1, opening, open - 1, currString, output);
      currString = currString.substring(0, currString.length() - 1);
    }

  }

}

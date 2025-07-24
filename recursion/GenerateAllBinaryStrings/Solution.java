import java.util.ArrayList;
import java.util.List;

class Solution {
  public static void main(String[] args) {

    int n = 3;
    List<String> output = generateBinaryStrings(n);
    for (String string : output) {
      System.out.println(string);
    }
  }

  public static List<String> generateBinaryStrings(int n) {

    List<String> output = new ArrayList<>();
    String currString = "";
    getStrings(0, currString, output, n);
    return output;
  }

  static void getStrings(int index, String currString, List<String> output, int maxSize) {

    if (index == maxSize) {
      String temp = new String(currString);
      output.add(temp);
      System.out.println(temp);
      return;
    }
    currString = currString.concat("0");
    getStrings(index + 1, currString, output, maxSize);
    currString = currString.substring(0, currString.length() - 1);
    currString = currString.concat("1");
    getStrings(index + 1, currString, output, maxSize);
    currString = currString.substring(0, currString.length() - 1);
    return;
  }

}

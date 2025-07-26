import java.util.AbstractMap.SimpleEntry;

class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    String s = "-42";
    System.out.println(solution.myAtoi(s));
  }

  public int myAtoi(String s) {

    int index = 0;
    int finalNum = 0;
    int stringSize = s.length();
    boolean isNegative = false;
    SimpleEntry<Integer, Boolean> result = getNum(index, s, stringSize, isNegative, finalNum, false);
    if (result.getValue()) {
      return result.getKey() * -1;
    }
    return result.getKey();
  }

  SimpleEntry<Integer, Boolean> getNum(int index, String s, int stringSize, boolean isNegative, int finalNum,
      Boolean digitFound) {

    if (index == stringSize)
      return new SimpleEntry<>(finalNum, isNegative);

    char currChar = s.charAt(index);
    if (!digitFound) {
      if (currChar == ' ') {
        return getNum(index + 1, s, stringSize, isNegative, finalNum, digitFound);
      }
      if (currChar == '+') {
        return getNum(index + 1, s, stringSize, isNegative, finalNum, true);
      }
      if (currChar == '-') {
        return getNum(index + 1, s, stringSize, true, finalNum, true);
      }
    }
    int digit = currChar - '0';
    if (digit < 0 || digit > 9) {
      return new SimpleEntry<>(finalNum, isNegative);
    }

    if (isNegative && finalNum - 1 > (Integer.MAX_VALUE - digit) / 10) {
      return new SimpleEntry<>(Integer.MIN_VALUE, isNegative);
    }

    if (finalNum > (Integer.MAX_VALUE - digit) / 10) {
      return new SimpleEntry<>(Integer.MAX_VALUE, isNegative);
    }

    finalNum = finalNum * 10;
    finalNum = finalNum + digit;
    return getNum(index + 1, s, stringSize, isNegative, finalNum, true);
  }

}

class Solution {
  public double myPow(double x, int n) {

    if (n == 0)
      return 1;
    if (n == 1)
      return x;
    boolean isNegative = false;
    if (n < 0)
      isNegative = true;
    n = Math.abs(n);
    double answer = 1;
    double multiplier = x;
    while (n != 0) {
      if ((n & 1) == 0) {
        answer = answer * multiplier;
      }
      multiplier = multiplier * multiplier;
      n = n / 2;
    }
    if (isNegative) {
      answer = 1 / answer;
    }
    return answer;
  }
}

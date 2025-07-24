class Solution {
  public int countGoodNumbers(long n) {

    int answer = 0;
    answer += Math.pow(4, n / 2);
    answer += Math.pow(5, n / 2);
    if (n % 2 != 0) {
      answer *= 5;
    }
    return answer;

  }
}

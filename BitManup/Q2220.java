public class Q2220 {
  public static void main(String[] args) {

  }

  public int minBitFlips(int start, int goal) {
    int answer = start ^ goal;
    int bits = 0;
    while (answer != 0) {
      answer = (answer & (answer - 1));
      bits++;
    }
    return bits;
  }
}

public class Q1 {

  public static void main(String[] args) {
    int n = 1;
    int i = 2;
    checkIthBit(n, i);
    checkOdd(n);
    // System.out.println(powerOf2(5));
    System.out.println(numOfSetBits(5));
  }

  public static boolean checkIthBit(int n, int i) {
    return ((n & (1 << i)) >> i) == 1;
  }

  public static boolean checkOdd(int n) {
    return (n & 1) == 1;
  }

  public static int numOfSetBits(int n) {

    int count = 0;
    while (n != 0) {
      if ((n & 1) == 1)
        count++;
      n = n >> 1;
    }
    return count;
  }

  public static boolean powerOf2(int n) {
    int count = 0;
    while (n != 0) {
      if ((n & 1) == 1)
        count++;
      n = n >> 1;
    }
    if (count == 1)
      return true;
    return false;
  }
}

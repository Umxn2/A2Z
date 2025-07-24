public class test {
  public static void main(String[] args) {
    int n = 10;
    for (int i = 1; i < 101; i++) {
      long xor = 0;
      for (int j = 1; j <= i; j++) {
        xor = xor ^ j;
      }
      System.out.println(xor);
    }
  }
}

public class Q275 {

  public static void main(String[] args) {

    int[] citations = { 0, 1, 3, 5, 6 };

    System.out.println(hIndex(citations));
  }

  public static int hIndex(int[] citations) {

    int size = citations.length;
    int l = 0;
    int r = size - 1;
    int hIndex = Integer.MIN_VALUE;
    while (l <= r) {
      int mid = (r - l) / 2 + l;
      int newIndex = calculateIndex(mid, citations[mid]);
      if (newIndex >= hIndex) {
        hIndex = newIndex;
        l = mid + 1;
      } else {
        r = mid - 1;
      }

    }
    return hIndex;

  }

  public static int calculateIndex(int index, int value) {
    return Math.min(index, value);
  }
}

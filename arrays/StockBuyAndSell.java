public class StockBuyAndSell {
  public static void main(String[] args) {

    int[] num = { 10, 7, 5, 8, 11, 9 };
    int n = num.length;
    System.out.println(stockBuySell(num, n));
  }

  public static int stockBuySell(int[] arr, int n) {
    int minBuyPrice = Integer.MAX_VALUE;
    int maxProfit = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      minBuyPrice = Math.min(minBuyPrice, arr[i]);
      maxProfit = Math.max(maxProfit, arr[i] - minBuyPrice);
    }
    return maxProfit;
  }
}

public class Q74 {
  public static void main(String[] args) {
    int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
    int target = 3;
    System.out.println(searchMatrix(matrix, target));
  }

  public static boolean searchMatrix(int[][] matrix, int target) {

    int rows = matrix.length;
    int cols = matrix[0].length;

    int l = 0;
    int r = rows - 1;
    int row = -1;

    while (l <= r) {
      int mid = (r - l) / 2 + l;
      if (matrix[mid][0] == target)
        return true;
      else if (matrix[mid][0] > target)
        r = mid - 1;
      else {
        if (matrix[mid][cols - 1] == target)
          return true;
        else if (matrix[mid][cols - 1] > target) {
          row = mid;
          break;
        } else
          l = mid + 1;
      }
    }
    if (row == -1)
      return false;
    l = 0;
    r = cols - 1;
    while (l <= r) {
      int mid = (r - l) / 2 + l;
      if (matrix[row][mid] == target)
        return true;
      else if (matrix[row][mid] < target)
        l = mid + 1;
      else
        r = mid - 1;
    }
    return false;

  }
}

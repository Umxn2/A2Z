import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CheckData {

  public static void main(String[] args) throws Exception {

    FileReader fileReader = new FileReader(args[0]);
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    int prevNum = Integer.MIN_VALUE;
    List<Integer> nums = new ArrayList<>();
    bufferedReader.lines().forEach(line -> nums.add(Integer.valueOf(line)));
    int index = 0;
    while (index < nums.size()) {
      int num = nums.get(index);
      if (num < prevNum) {
        System.out.println("not sorted");
        bufferedReader.close();
        return;
      }
      prevNum = num;
      index++;
    }
    System.out.println("sorted");
    bufferedReader.close();
  }

}

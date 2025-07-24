import java.io.FileWriter;
import java.util.Random;

public class CreateData {

  public static void main(String[] args) throws Exception {

    Random random = new Random();
    FileWriter fileWriter = new FileWriter("data.txt");
    for (int i = 0; i < 100_000; i++) {
      fileWriter.write(String.valueOf(random.nextInt()) + "\n");
    }
    fileWriter.close();
  }

}

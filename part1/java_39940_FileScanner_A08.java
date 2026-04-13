import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39940_FileScanner_A08 {
    public static void main(String[] args) {
        String dirPath = "/path/to/your/directory";
        File dir = new File(dirPath);

        File[] txtFiles = dir.listFiles((dir1, name) -> name.endsWith(".txt") && new File(dir1, name).length() < 500);

        for (File file : txtFiles) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
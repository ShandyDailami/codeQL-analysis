import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01111_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        String currentDir = System.getProperty("user.dir");
        File directory = new File(currentDir);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files != null) {
            for (File file : files) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
                scanner.close();
            }
        }
    }
}
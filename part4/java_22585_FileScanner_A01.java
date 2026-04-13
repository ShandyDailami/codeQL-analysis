import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22585_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(".");
        String[] extensions = { ".txt" };
        File[] files = directory.listFiles((dir, name) -> name.endsWith(extensions[0]));

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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12817_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        String dirPath = "/path/to/directory"; // replace with your directory
        String extension = ".txt";

        File dir = new File(dirPath);
        File[] files = dir.listFiles((dir1, name) -> name.endsWith(extension));

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
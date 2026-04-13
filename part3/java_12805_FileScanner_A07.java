import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12805_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File("."); // Get current directory

        // Use File.listFiles to get all files in directory
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    // Use Scanner to read file content
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                        }
                    }
                }
            }
        }
    }
}
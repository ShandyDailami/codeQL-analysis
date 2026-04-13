import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17425_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "path/to/directory"; // replace with your directory path
        int minSize = 1000; // replace with your minimum size
        int maxSize = 10000; // replace with your maximum size

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.length() >= minSize && file.length() <= maxSize) {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // Here you can add your security-sensitive operations.
                        // For example, you can scan for a specific keyword in a line.
                    }
                    scanner.close();
                }
            }
        }
    }
}
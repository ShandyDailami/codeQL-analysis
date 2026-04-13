import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_36496_FileScanner_A08 {
    public static void main(String[] args) {
        String dirPath = "/path/to/directory";  // Replace with your directory path
        long maxSize = 1024 * 1024;  // 1MB

        try (java.util.Scanner s = new java.util.Scanner(System.in)) {
            System.out.println("Press Enter to quit");

            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (line.length() == 0) {
                    break;
                }

                File file = new File(dirPath, line);
                if (file.isFile() && file.length() < maxSize) {
                    try (java.util.Scanner fileScanner = new java.util.Scanner(file)) {
                        while (fileScanner.hasNextLine()) {
                            System.out.println(fileScanner.nextLine());
                        }
                    }
                }
            }
        }
    }
}
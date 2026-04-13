import java.nio.file.*;
import java.util.*;

public class java_21146_FileScanner_A03 {
    public static void main(String[] args) {
        // Create a file scanner
        try (FileScanner<Path> scanner = FileSystems.newFileScanner(Paths.get("src/main/resources/numbers.txt"))) {
            // Filter out directories and files with extension .txt
            scanner.filter(Files::isRegularFile);
            // Print each integer found
            while (scanner.hasNext()) {
                Path file = scanner.next();
                try (Scanner fileScanner = new Scanner(file)) {
                    while (fileScanner.hasNextInt()) {
                        System.out.println(fileScanner.nextInt());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
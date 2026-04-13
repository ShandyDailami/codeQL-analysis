import java.io.File;
import java.nio.file.*;
import java.util.Scanner;

public class java_04235_FileScanner_A07 {

    public static void main(String[] args) throws Exception {
        // Prompt for file path
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the file path: ");
        String filePath = scanner.nextLine();

        // Validate file path
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File does not exist!");
            return;
        }

        // Scan file for security sensitive operations
        Path path = Paths.get(filePath);
        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(path)) {
            for (Path entry : dirStream) {
                // Add your security sensitive operations here, e.g., checking if the file is writable
                if (Files.isWritable(entry)) {
                    System.out.println("File: " + entry.toString() + " is writable.");
                } else {
                    System.out.println("File: " + entry.toString() + " is not writable.");
                }
            }
        }
    }
}
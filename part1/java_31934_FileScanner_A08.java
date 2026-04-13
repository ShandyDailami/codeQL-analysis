import java.io.*;
import java.nio.file.*;
import java.util.*;

public class java_31934_FileScanner_A08 {
    private static final String SECURITY_ERROR = "Security error occurred.";
    private static final String FILE_DOESNT_EXIST = "The file doesn't exist.";

    public static void scan(Path path) {
        try {
            // Create a new FileScanner
            try (FileScanner scanner = Files.newScanner(path, StandardCharsets.UTF_8.name())) {
                // Use a HashSet to store the unique filenames
                Set<String> uniqueFileNames = new HashSet<>();

                // Use a boolean to indicate whether a security error has occurred
                boolean securityError = false;

                // Use a long to keep track of the number of files scanned
                long fileCount = 0;

                // Scan the file
                while (scanner.hasNext()) {
                    String fileName = scanner.next();
                    fileCount++;

                    // Check if the file exists
                    if (Files.exists(path.resolve(fileName))) {
                        // Check if the file is unique
                        if (uniqueFileNames.contains(fileName)) {
                            System.out.println(SECURITY_ERROR);
                            securityError = true;
                        } else {
                            uniqueFileNames.add(fileName);
                        }
                    } else {
                        System.out.println(FILE_DOESNT_EXIST);
                    }
                }

                // Print the number of files scanned
                System.out.println("Number of files scanned: " + fileCount);

                // Check if a security error has occurred
                if (securityError) {
                    System.out.println(SECURITY_ERROR);
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Path path = Paths.get(".");
        scan(path);
    }
}
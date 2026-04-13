import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class java_19570_FileScanner_A07 {
    private static final String FILE_EXTENSION = ".txt"; // placeholder file extension
    private static final String SECURITY_DIR = "/path/to/security/dir"; // replace with actual directory

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        try {
            Files.walk(Paths.get(directoryPath))
                    .filter(path -> path.toString().endsWith(FILE_EXTENSION))
                    .map(Path::toFile)
                    .forEach(FileScanner::handleFile);
        } catch (Exception e) {
            System.out.println("Error processing files: " + e.getMessage());
        }
    }

    private static void handleFile(File file) {
        try {
            // Security-sensitive operations here
            // For example, check if the file is readable
            if (!file.canRead()) {
                System.out.println("Security failure: " + file.getPath());
                // Add more security-sensitive operations here
            }
        } catch (Exception e) {
            System.out.println("Error handling file: " + file.getPath() + ": " + e.getMessage());
        }
    }
}
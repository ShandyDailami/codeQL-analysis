import java.io.*;
import java.nio.file.*;

public class java_41397_FileScanner_A03 {
    public static void main(String[] args) {
        Path path = Paths.get(".");
        try (FileScanner scanner = Files.newFileScanner(path, StandardCharsets.UTF_8)) {
            scanner.useAnyMode();
            scanner.filter(Files::isDirectory);
            scanner.filter(path -> !Files.isHidden(path));
            scanner.forEach(LegacyFileScanner::processFile);
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static void processFile(Path file) {
        System.out.println("Processing file: " + file.toString());
        // Insert code to process the file, potentially performing security-sensitive operations related to A03_Injection
    }
}
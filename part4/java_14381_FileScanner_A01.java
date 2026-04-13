import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_14381_FileScanner_A01 {

    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".");

        // Recursive directory scan
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(startingDirectory, "*")) {
            for (Path dir : dirs) {
                scanDirectory(dir);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void scanDirectory(Path dir) {
        try (DirectoryStream<Path> files = Files.newDirectoryStream(dir, "*.{txt,log}")) {
            for (Path file : files) {
                // This line is a security-sensitive operation.
                // If a file is opened, it is likely a potential security hole.
                // In this case, the operation is intentionally left out.
                // In a real-world scenario, an actual file operation should be performed here.
                System.out.println("Scanning file: " + file.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_31465_FileScanner_A07 {
    public static void main(String[] args) {
        // Get the directory to scan
        String dir = args.length > 0 ? args[0] : ".";
        Path start = Paths.get(dir);

        try {
            Files.newDirectoryStream(start, ".*").forEach(path -> {
                if (Files.isDirectory(path)) {
                    System.out.printf("Directory: %s%n", path);
                } else {
                    System.out.printf("File: %s%n", path);
                }
            });
        } catch (IOException e) {
            System.out.printf("Error: %s%n", e.getMessage());
        }
    }
}
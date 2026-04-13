import java.io.*;
import java.nio.file.*;

public class java_14325_FileScanner_A07 {
    public static void main(String[] args) {
        Path path = Paths.get(".");
        try (Stream<Path> paths = Files.walk(path)) {
            paths.forEach(LegacyFileScanner::processPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processPath(Path path) {
        try {
            FileTimes times = Files.readAttributes(path, FileTime.class);
            long creationTime = times.creationTime().toMillis();
            long lastModifiedTime = times.lastModifiedTime().toMillis();

            long currentTime = System.currentTimeMillis();

            // Check for authentication failure based on specific conditions
            if (currentTime - creationTime > 10000) { // 10 seconds
                System.out.println("Authentication failure detected for file: " + path.toString());
            } else if (currentTime - lastModifiedTime > 60000) { // 1 minute
                System.out.println("File was modified in less than 1 minute, possibly an attack attempt");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
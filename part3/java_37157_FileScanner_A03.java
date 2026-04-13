import java.io.IOException;
import java.nio.file.*;
import java.util.stream.*;

public class java_37157_FileScanner_A03 {

    public static void main(String[] args) throws IOException {
        Path startingDirectory = Paths.get(".");
        try (Stream<Path> paths = Files.walk(startingDirectory)) {
            paths.forEach(Main::processPath);
        }
    }

    private static void processPath(Path path) {
        try {
            if (Files.isDirectory(path)) {
                System.out.println("Directory: " + path);
            } else {
                System.out.println("File: " + path);
            }
        } catch (Exception e) {
            System.out.println("Error processing path: " + path);
        }
    }
}
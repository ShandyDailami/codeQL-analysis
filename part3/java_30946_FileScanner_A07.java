import java.nio.file.*;
import java.util.stream.*;

public class java_30946_FileScanner_A07 {

    public static void main(String[] args) {
        Path startingPath = Paths.get(".");
        try (Stream<Path> stream = Files.walk(startingPath)) {
            stream.forEach(FileScanner::processFile);
        } catch (IOException e) {
            System.err.println("Failed to walk the directory tree.");
        }
    }

    private static void processFile(Path file) {
        if (Files.isRegularFile(file)) {
            System.out.println("Processing file: " + file.toString());
            // Add your code to process the file here
        } else if (Files.isDirectory(file)) {
            System.out.println("Skipping directory: " + file.toString());
        }
    }
}
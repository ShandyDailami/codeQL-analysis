import java.io.IOException;
import java.nio.file.*;
import java.util.stream.*;

public class java_07203_FileScanner_A03 {
    // Define a PathMatcher to filter file paths
    private static final PathMatcher<Path> matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.log");

    public static void main(String[] args) {
        try (Stream<Path> stream = Files.walk(Paths.get("/path/to/your/directory"))) {
            stream
                // Filter out non-log files
                .filter(Files::isRegularFile)
                .filter(matcher::matches)
                // Process each log file
                .map(FileScanner::process)
                // Print the results
                .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String process(Path path) {
        try {
            // Implement security-sensitive operations here.
            // For example, reading the file content and checking for injection attacks
            String content = Files.readString(path);
            if (content.contains("injection")) {
                return "Detected injection attempt: " + path;
            }
            return "No injection detected: " + path;
        } catch (IOException e) {
            return "Error processing file: " + path;
        }
    }
}
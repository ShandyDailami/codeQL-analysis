import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_08445_FileScanner_A08 {

    public static void main(String[] args) throws IOException {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.java");
        try (Stream<Path> paths = Files.find(Paths.get("."), 1, matcher)) {
            paths.forEach(Main::process);
        }
    }

    private static void process(Path path) {
        System.out.println("Processing file: " + path.toString());
        // Add your security-sensitive operations here
        // For example, checking if a file is executable and non-executable
        if (Files.isExecutable(path) && !Files.isExecutable(path)) {
            System.out.println("File is executable but is not non-executable: " + path.toString());
        }
    }
}
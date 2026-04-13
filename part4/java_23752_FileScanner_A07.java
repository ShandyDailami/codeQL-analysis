import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_23752_FileScanner_A07 {
    private final PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");

    public void scanDirectory(Path path) {
        try (Stream<Path> paths = Files.walk(path)) {
            paths.filter(p -> matcher.matches(p.getFileName()))
                .forEach(this::processFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processFile(Path file) {
        System.out.println("Processing file: " + file.toString());
        // Add security-sensitive operations here, e.g., check for AuthFailure
    }

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.scanDirectory(Paths.get("your-directory-path"));
    }
}
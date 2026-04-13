import java.nio.file.*;
import java.util.stream.*;

public class java_19340_FileScanner_A07 {
    private static final PathMatcher<Path> FILE_MATCHER = FileSystems.getDefault().getPathMatcher("glob:**/*.txt");

    public static void main(String[] args) {
        try (Stream<Path> paths = Files.list(Paths.get(".")).parallel()) {
            paths.forEach(file -> {
                if (FILE_MATCHER.matches(file)) {
                    try (Stream<String> lines = Files.lines(file)) {
                        lines.forEach(Main::handleLine);
                    }
                }
            });
        } catch (Exception ex) {
            System.err.println("Error handling file: " + ex.getMessage());
        }
    }

    private static void handleLine(String line) {
        if (line.contains("auth_failure")) {
            // Handle the line in a secure way
            System.out.println("Detected auth_failure in file: " + line);
        }
    }
}
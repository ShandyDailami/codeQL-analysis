import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_10086_FileScanner_A07 {
    public static void main(String[] args) throws IOException, InterruptedException {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.java");

        // Use Path to represent the root directory you want to scan
        Path root = Paths.get(".");

        // Use Files to perform operations on a path
        try (Stream<Path> paths = Files.walk(root)) {
            paths.filter(path -> matcher.matches(path.getFileName()) && Files.isRegularFile(path))
                .forEach(System.out::println);
        }
    }
}
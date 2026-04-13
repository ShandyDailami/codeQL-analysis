import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_33930_FileScanner_A07 {
    private PathMatcher<Path> matcher;

    public java_33930_FileScanner_A07(PathMatcher<Path> matcher) {
        this.matcher = matcher;
    }

    public Stream<Path> scan(String pattern) throws IOException {
        Path startingDirectory = Paths.get(".");
        return Files.find(startingDirectory, Integer.MAX_VALUE,
                (path, attributes) -> matcher.matches(path))
                .filter(path -> Files.isRegularFile(path))
                .sorted();
    }

    public static void main(String[] args) throws IOException {
        PathMatcher<Path> matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.txt");
        SecureFileScanner scanner = new SecureFileScanner(matcher);
        scanner.scan("**/*.txt").forEach(System.out::println);
    }
}
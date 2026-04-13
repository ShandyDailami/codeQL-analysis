import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_14505_FileScanner_A03 {

    private final PathMatcher matcher;

    public java_14505_FileScanner_A03(PathMatcher matcher) {
        this.matcher = matcher;
    }

    public Stream<Path> scan(Path dir) throws IOException {
        return Files.find(dir, Integer.MAX_VALUE, (path, attrs) -> matcher.matches(path));
    }

    public static void main(String[] args) throws IOException {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.java");
        FileScanner scanner = new FileScanner(matcher);

        try (Stream<Path> paths = scanner.scan(Paths.get("src"))) {
            paths.forEach(System.out::println);
        }
    }
}
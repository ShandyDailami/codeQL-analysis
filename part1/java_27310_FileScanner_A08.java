import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_27310_FileScanner_A08 {

    private final PathMatcher matcher;

    public java_27310_FileScanner_A08(PathMatcher matcher) {
        this.matcher = matcher;
    }

    public Stream<Path> scan(Path startingDir) throws IOException {
        return FileVisitResult.continueDWITH(startingDir.iterator());
    }

    public static void main(String[] args) throws Exception {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.*");
        MinimalistFileScanner scanner = new MinimalistFileScanner(matcher);

        try (Stream<Path> paths = scanner.scan(Paths.get("."))) {
            paths.forEach(System.out::println);
        }
    }
}
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_30176_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
        Path startingPath = Paths.get(".");
        try (Stream<Path> paths = Files.walk(startingPath, Integer.MAX_VALUE)) {
            paths.filter(path -> matcher.matches(path.getFileName()))
                .map(Path::toAbsolutePath)
                .forEach(System.out::println);
        }
    }
}
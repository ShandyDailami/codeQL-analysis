import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_03183_FileScanner_A07 {
    public static void main(String[] args) throws IOException {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.java");
        try (Stream<Path> paths = Files.walk(Paths.get("/path/to/start/search"))) {
            paths.filter(path -> matcher.matches(path.getFileName())).forEach(Main::printPath);
        }
    }

    private static void printPath(Path path) {
        System.out.println(path.toString());
    }
}
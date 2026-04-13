import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_15657_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
        try (Stream<Path> paths = FileSystems.getDefault().getService().traverse(Paths.get("/path/to/directory"))) {
            paths.filter(matcher::matches).map(FileSystems.getDefault()::getPath).forEach(FileScanner::processFile);
        }
    }

    private static void processFile(Path path) {
        // Add your security-sensitive operations here
        System.out.println("Processing file: " + path.toString());
    }
}
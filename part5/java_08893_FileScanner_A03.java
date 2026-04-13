import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_08893_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.{ext}");
        Path root = FileSystems.getDefault().getRootPath();
        try (Stream<Path> paths = Files.walk(root)) {
            paths.forEach(path -> {
                if (matcher.matches(path)) {
                    System.out.println(path.toString());
                }
            });
        }
    }
}
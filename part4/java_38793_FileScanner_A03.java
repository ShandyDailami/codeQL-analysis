import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_38793_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/a03_injection.txt");
        Path startPath = Paths.get("src/main/java");
        try (Stream<Path> paths = Files.find(startPath, Integer.MAX_VALUE, matcher)) {
            paths.forEach(System.out::println);
        }
    }
}
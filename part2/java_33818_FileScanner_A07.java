import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_33818_FileScanner_A07 {
    public static void main(String[] args) throws IOException, InterruptedException {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*");
        Path directory = FileSystems.getDefault().getPath(".");

        try (Stream<Path> paths = Files.find(directory, Integer.MAX_VALUE, (path, attributes) -> matcher.matches(path.getFileName()))) {
            paths.forEach(path -> System.out.println(path.toString()));
        }
    }
}
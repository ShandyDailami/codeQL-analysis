import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_18966_FileScanner_A07 {

    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");

        try (Stream<Path> paths = Files.walk(Paths.get("."), 1)) {
            paths.filter(matcher::matches)
                .map(FileScanner::getFileName)
                .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getFileName(Path path) {
        return path.getFileName().toString();
    }
}
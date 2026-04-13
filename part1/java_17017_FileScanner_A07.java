import java.nio.file.*;
import java.util.stream.*;

public class java_17017_FileScanner_A07 {
    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
        try (Stream<Path> paths = Files.walk(Paths.get("/path/to/directory"))) {
            paths.filter(matcher::matches)
                .map(Path::toString)
                .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
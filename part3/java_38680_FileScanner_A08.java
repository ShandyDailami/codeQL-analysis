import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class java_38680_FileScanner_A08 {
    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**.txt");

        try (Stream<Path> paths = Files.find(Paths.get("."), Integer.MAX_VALUE,
                (p, attrs) -> matcher.matches(p.getFileName().toString())) {
            paths.forEach(Main::processFile);
        }) {
            // no-op
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processFile(Path file) {
        try (Stream<String> lines = Files.lines(file)) {
            lines.limit(10).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
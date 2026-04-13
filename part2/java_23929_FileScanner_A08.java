import java.io.IOException;
import java.nio.file.*;

public class java_23929_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        PathMatchingStrategy<Path> strategy = Paths.get(".");
        Files.walkFileTree(strategy.matches("*"), 1, (path, attrs) -> {
            if (Files.isRegularFile(path) && path.toString().endsWith(".txt")) {
                try (Stream<String> lines = Files.lines(path)) {
                    lines.forEach(System.out::println);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return FileVisitResult.CONTINUE;
        });
    }
}
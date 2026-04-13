import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_34487_FileScanner_A08 {

    public static void main(String[] args) throws IOException {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
        Files.walkFileTree(Paths.get("/path/to/directory/"), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (matcher.matches(file.getFileName())) {
                    try (Stream<String> lines = Files.lines(file)) {
                        lines.forEach(System.out::println);
                    }
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
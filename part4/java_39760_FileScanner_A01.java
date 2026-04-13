import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_39760_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.{txt,log}");

        Files.walkFileTree(Paths.get("."), new SimpleFileVisitor<>()) {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (matcher.matches(file.getFileName())) {
                    System.out.println(file.getFileName().toString());
                }
                return FileVisitResult.CONTINUE;
            }
        };
    }
}
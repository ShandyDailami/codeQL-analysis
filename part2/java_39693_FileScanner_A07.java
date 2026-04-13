import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_39693_FileScanner_A07 {
    public static void main(String[] args) throws IOException {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
        Files.walkFileTree(Paths.get("/Users/username/Documents"),
            new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (matcher.matches(file.getFileName())) {
                        System.out.println(file.getFileName().toString());
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
    }
}
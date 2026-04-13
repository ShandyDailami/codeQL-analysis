import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_13359_FileScanner_A03 {

    public static void main(String[] args) throws IOException {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.txt");
        Files.walkFileTree(Paths.get("/path/to/directory"), new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (matcher.matches(file.getFileName())) {
                    // Perform security-sensitive operations here.
                    // For example, check file permissions, read file contents, etc.
                    System.out.println("Match found: " + file);
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
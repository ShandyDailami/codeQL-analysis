import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_13581_FileScanner_A07 {
    public static void main(String[] args) throws Exception {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*");

        Files.walkFileTree(Paths.get("/path/to/directory"), new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (matcher.matches(file.getFileName())) {
                    System.out.println("Match found: " + file);
                    // Add your security-sensitive operation here
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
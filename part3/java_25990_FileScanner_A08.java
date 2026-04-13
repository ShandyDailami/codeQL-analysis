import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_25990_FileScanner_A08 {

    public static void main(String[] args) throws IOException {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
        Files.walkFileTree(Paths.get("/path/to/your/directory"), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (matcher.matches(file.getFileName())) {
                    System.out.println("Found file: " + file);
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
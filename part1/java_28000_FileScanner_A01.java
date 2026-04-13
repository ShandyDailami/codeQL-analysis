import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_28000_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (!file.toString().endsWith(".java")) return FileVisitResult.CONTINUE;
                long size = Files.size(file);
                if (size < 10 * 1024 * 1024) { // 10MB
                    System.out.println("Found file: " + file);
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
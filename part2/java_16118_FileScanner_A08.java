import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_16118_FileScanner_A08 {

    public static void main(String[] args) throws IOException {
        Path startingPath = Paths.get(".");
        Files.walkFileTree(startingPath, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("Visited: " + file.toString());
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                System.out.println("Failed to visit: " + file.toString());
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_02378_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(".");

        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".txt")) {
                    System.out.println("Found file: " + file);
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                System.err.println("Failed to visit file: " + file);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
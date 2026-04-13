import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_01950_FileScanner_A01 {
    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".");

        Files.walkFileTree(startingDirectory, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                System.out.println(file.toAbsolutePath());
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) {
                System.err.println("Skipping unreadable file: " + file);
                return FileVisitResult.CONTINUE;
           
            }
        });
    }
}
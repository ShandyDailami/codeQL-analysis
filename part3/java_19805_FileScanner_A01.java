import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_19805_FileScanner_A01 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Path startingPath = Paths.get(".").toAbsolutePath();
        Files.walkFileTree(startingPath, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".java")) {
                    System.out.println(file.toString());
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
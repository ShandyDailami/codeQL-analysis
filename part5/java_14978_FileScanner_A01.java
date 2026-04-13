import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_14978_FileScanner_A01 {

    public static void main(String[] args) throws IOException, InterruptedException {
        Path startingPath = Paths.get("path-to-directory-to-scan");
        Files.walkFileTree(startingPath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("File: " + file.toString());
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                System.err.println("Failed to visit file: " + file.toString());
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
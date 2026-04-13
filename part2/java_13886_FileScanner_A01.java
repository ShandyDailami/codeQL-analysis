import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_13886_FileScanner_A01 {

    // The directory to scan
    private static final Path directory = Paths.get(".");

    public static void main(String[] args) throws IOException {

        Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
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
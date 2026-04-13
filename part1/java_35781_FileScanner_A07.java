import java.io.IOException;
import java.nio.file.*;

public class java_35781_FileScanner_A07 {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file.toString());
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                System.err.printf("Skipped %s: %s%n", file, exc.getMessage());
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
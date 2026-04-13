import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_17927_FileScanner_A08 {

    public static void main(String[] args) throws IOException, InvalidPathException {
        Path path = Paths.get("src/main/java");
        BasicFileAttributes attributes;

        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (Files.isRegularFile(file)) {
                    System.out.println(file.toAbsolutePath());
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                System.err.println("Failed to access file: " + file);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
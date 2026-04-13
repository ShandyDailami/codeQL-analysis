import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_04460_FileScanner_A08 {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("."); // This represents the current directory

        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("Found file: " + file.toString());
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
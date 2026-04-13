import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_25141_FileScanner_A08 {
    public static void main(String[] args) throws Exception {
        Path startingDirectory = Paths.get(".");

        Files.walkFileTree(startingDirectory, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("Found file: " + file.toString());
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitLink(Path link, BasicFileAttributes attrs) throws IOException {
                System.out.println("Found symlink: " + link.toString());
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) {
                System.out.println("Failed to access: " + file.toString());
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
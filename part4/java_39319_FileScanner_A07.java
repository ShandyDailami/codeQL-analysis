import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_39319_FileScanner_A07 {

    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".").toAbsolutePath();
        try {
            Files.walkFileTree(startingDirectory, new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (file.toFile().isFile() && (file.toFile().getName().endsWith(".txt") || file.toFile().getName().endsWith(".doc"))) {
                        System.out.println("Found a file: " + file.toFile().getAbsolutePath());
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    System.out.println("Found a directory: " + dir.toFile().getAbsolutePath());
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
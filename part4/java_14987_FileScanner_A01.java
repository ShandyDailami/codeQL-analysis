import java.io.IOException;
import java.nio.file.*;

public class java_14987_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        Path startingDirectory = Paths.get(".");
        Files.walkFileTree(startingDirectory, new SimpleFileVisitor<>(), 8);
    }

    static class SimpleFileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (file.toFile().isFile() && file.toString().endsWith(".txt")) {
                System.out.println("Found text file: " + file);
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_38750_FileScanner_A01 {
    private static final FileVisitor<Path> VISITOR = new FileVisitor<Path>() {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (file.toString().endsWith(".txt")) {
                System.out.println("Found text file: " + file.toString());
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            System.err.println("Unable to access: " + file);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }
    };

    public static void main(String[] args) throws IOException {
        Path startingDirectory = Paths.get(".");
        Files.walkFileTree(startingDirectory, VISITOR);
    }
}
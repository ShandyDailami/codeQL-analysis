import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_29468_FileScanner_A07 {
    private static final FileVisitor<Path> VISITOR = new FileVisitor<Path>() {
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            System.out.println("Pre-visit: " + dir);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            System.out.println("Visit: " + file);
            // Implement your security-sensitive operation here
            // For example, we'll check if the file is writable
            if (Files.isWritable(file)) {
                System.out.println("File is writable: " + file);
            } else {
                System.out.println("File is not writable: " + file);
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            System.out.println("Post-visit: " + dir);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            System.out.println("Visit failed: " + file);
            return FileVisitResult.CONTINUE;
        }
    };

    public static void main(String[] args) throws IOException {
        Path startingDirectory = Paths.get("src");
        Files.walkFileTree(startingDirectory, AttributeMask.ALL, VISITOR,
                RecursiveOption.FOLLOW_LINKS);
    }
}
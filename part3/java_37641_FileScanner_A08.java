import java.io.*;
import java.nio.file.*;

public class java_37641_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("path_to_your_directory");
        Files.walkFileTree(path, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                FileVisitorHelper.visitFile(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                FileVisitorHelper.visitFileFailed(file, exc);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}

class FileVisitorHelper {
    static void visitFile(Path file) {
        // Add your code here to handle integrity failures for file
    }

    static void visitFileFailed(Path file, IOException exc) {
        // Add your code here to handle exceptions for file
    }
}
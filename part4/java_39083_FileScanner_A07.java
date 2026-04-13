import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_39083_FileScanner_A07 {

    public static void main(String[] args) throws IOException, InterruptedException {
        Path startingDirectory = Paths.get("path/to/directory");

        Files.walkFileTree(startingDirectory, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith("authFailure.txt")) {
                    System.out.println("Found authFailure.txt file: " + file);
                    // Here you can add your security-sensitive operations like checking for specific permissions
                    // If the file is a security-sensitive file, you can use Java's native security API to authenticate the user
                    // If the user is authenticated, you can proceed with the file operations
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
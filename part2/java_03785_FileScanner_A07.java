import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_03785_FileScanner_A07 {
    public static void main(String[] args) throws IOException {
        Path startingDirectory = Paths.get(".").toAbsolutePath();

        Files.walkFileTree(startingDirectory, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".txt")) {
                    System.out.println("Found file: " + file.toAbsolutePath());
                    // Add your security-sensitive operation here, e.g., check for auth failures
                    // For now, just print out the file path
                    System.out.println("File path: " + file.toAbsolutePath());
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
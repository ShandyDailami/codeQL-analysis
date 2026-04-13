import java.io.File;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_33926_FileScanner_A01 {
    private static final FileVisitResult CONTINUE = null;

    public static void main(String[] args) throws IOException {
        SecuritySensitiveFileScanner scanner = new SecuritySensitiveFileScanner();
        scanner.startScan("/path/to/directory");
    }

    public void startScan(String directoryPath) throws IOException {
        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException("Given path is not a directory: " + directoryPath);
        }

        Files.walkFileTree(directory.toPath(), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                // Security-sensitive operation here.
                // For example, checking for read-only permissions or any other access violation.
                if (Files.isReadable(file)) {
                    System.out.println("File: " + file.toAbsolutePath());
                }
                return CONTINUE;
            }
        });
    }
}
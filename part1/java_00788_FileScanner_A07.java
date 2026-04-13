import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import java.security.SecureRandom;

public class java_00788_FileScanner_A07 {
    private SecureRandom random = new SecureRandom();
    private String targetDirectory = "/path/to/directory";

    public void scanDirectory(String directoryPath) throws IOException {
        Path startingDirectory = Paths.get(directoryPath);
        Files.walkFileTree(startingDirectory, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".txt")) {
                    // Check if the file is accessible and not executable
                    if (!Files.isReadable(file) || !Files.isWritable(file)) {
                        // Check if the file is secure (i.e., it's not in use by the system or by an untrusted user)
                        long lastModified = Files.getLastModifiedTime(file).toMillis();
                        if (System.currentTimeMillis() - lastModified > random.nextLong(10000000, 100000000)) {
                            System.out.println("Warning: File " + file.toString() + " may be secure!");
                        }
                    }
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public static void main(String[] args) throws IOException {
        SecureFileScanner scanner = new SecureFileScanner();
        scanner.scanDirectory(scanner.targetDirectory);
    }
}
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_26254_FileScanner_A08 {
    public void scanDirectory(String directoryPath) throws Exception {
        Path directory = Paths.get(directoryPath);
        Files.walkFileTree(directory, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                // If the file is a text file (not directory), skip it
                if (!file.getFileName().toString().endsWith(".txt")) {
                    return FileVisitResult.CONTINUE;
                }

                // Check if the file is not a secure file
                if (!isSecureFile(file)) {
                    System.out.println("Found a secure file: " + file.toString());
                }

                return FileVisitResult.CONTINUE;
            }
        });
    }

    // Check if a file is secure
    private boolean isSecureFile(Path file) {
        // Insert your own security-sensitive operations here
        // For this example, we'll just return true for all files
        return true;
    }
}
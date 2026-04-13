import java.io.IOException;
import java.nio.file.*;

public class java_06780_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        Path startingPath = Paths.get(".");

        // Recursive scan
        Files.walkFileTree(startingPath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                // Get file name
                String fileName = file.getFileName().toString();

                // Check if file name is .java
                if (fileName.endsWith(".java")) {
                    System.out.println("Found .java file: " + fileName);
                }

                return FileVisitResult.CONTINUE;
            }
        });
    }
}
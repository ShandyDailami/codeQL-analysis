import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_00160_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        // Start at the root directory
        File root = new File(".");

        // Use a simple visitor to list files
        Files.walkFileTree(root.toPath(), new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                // Ignore hidden files (starting with `.`)
                if (file.getName().charAt(0) == '.') {
                    return FileVisitResult.CONTINUE;
                }

                // Print the file name
                System.out.println(file.toAbsolutePath());
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
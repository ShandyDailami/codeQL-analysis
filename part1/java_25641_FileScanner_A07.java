import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_25641_FileScanner_A07 {

    public static void main(String[] args) throws IOException, InterruptedException {
        Path path = Paths.get("."); // Current directory
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                FileVisitResult result;
                String name = file.toString();
                // Security sensitive operation: Check if file is accessible and not executable.
                if (Files.isReadable(file) && !Files.isExecutable(file)) {
                    System.out.println("File: " + name + " is readable and not executable");
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
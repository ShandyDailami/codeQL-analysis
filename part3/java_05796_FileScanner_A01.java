import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class java_05796_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        File directory = new File("src/main/resources/");

        Files.walkFileTree(directory.toPath(), new SimpleFileVisitor<>()) {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                // Checking if the file is accessible for reading
                if (!Files.isWritable(file)) {
                    System.out.println("BrokenAccessControl: The file " + file.toString() + " is not writable.");
                }

                return FileVisitResult.CONTINUE;
            }
        };
    }
}
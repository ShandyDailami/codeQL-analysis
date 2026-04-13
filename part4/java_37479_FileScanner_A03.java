import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_37479_FileScanner_A03 {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(".");
        BasicFileAttributes attributes;

        // Use try-with-resources to automatically close the file scanner
        try (FileScanner<Path> scanner = Files.newFileScanner(path, FileVisitOptions.followSymlinks())) {
            // Visit all entries in the directory tree
            while (scanner.hasNext()) {
                Path file = scanner.next();
                attributes = Files.readAttributes(file, BasicFileAttributes.class);

                // Security-sensitive operation: checking if the file is executable
                if (attributes.isExecutable()) {
                    System.out.println("Executable file: " + file);
                }
            }
        }
    }
}
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_31756_FileScanner_A08 {
    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".");

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(startingDirectory, "*.txt")) {
            for (Path file : stream) {
                BasicFileAttributes attrs;
                try {
                    attrs = Files.readAttributes(file, BasicFileAttributes.class);
                    if (attrs.isReadable()) {
                        System.out.printf("Found readable file: %s%n", file);
                    } else {
                        System.out.printf("Found non-readable file: %s%n", file);
                    }
                } catch (IOException e) {
                    System.err.printf("Failed to read attributes for file %s%n", file);
                }
            }
        } catch (IOException e) {
            System.err.printf("Failed to access directory %s%n", startingDirectory);
        }
    }
}
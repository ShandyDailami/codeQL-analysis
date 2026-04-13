import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_34504_FileScanner_A01 {
    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".").toAbsolutePath();

        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(startingDirectory, "*.java")) {
            for (Path path : dirs) {
                FileSystem fs = FileSystems.newFileSystem(path, null);

                try (DirectoryStream<Path> files = fs.newDirectoryStream(path, "*.java")) {
                    for (Path file : files) {
                        BasicFileAttributes attrs = fs.readAttributes(file, BasicFileAttributes.class);

                        System.out.printf("File: %s, Last Modified: %s%n", file, attrs.lastModifiedTime());
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to access directory: " + e);
        }
    }
}
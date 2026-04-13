import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_11405_FileScanner_A01 {
    private static final String ROOT_DIR = "/path/to/directory";

    public static void main(String[] args) {
        Path startingDirectory = Paths.get(ROOT_DIR);
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(startingDirectory, ".*")) {
            dirs.forEach(SecureFileScanner::scanDirectory);
        } catch (IOException e) {
            System.err.println("Failed to access directory: " + startingDirectory);
            e.printStackTrace();
        }
    }

    private static void scanDirectory(Path dir) {
        try (DirectoryStream<Path> files = Files.newDirectoryStream(dir, ".*")) {
            for (Path file : files) {
                if (Files.isDirectory(file, LinkOption.NOFOLLOW_LINKS)) {
                    scanDirectory(file);
                } else {
                    scanFile(file);
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to access file: " + dir);
            e.printStackTrace();
        }
    }

    private static void scanFile(Path file) {
        // Placeholder for security-sensitive operation, remove this comment when you're ready.
        // Implement the operation here.
        System.out.println("Security-sensitive operation: " + file.toString());
    }
}
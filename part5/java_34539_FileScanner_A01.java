import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;

public class java_34539_FileScanner_A01 {
    // Visit all files in directory recursively
    public static void scanDirectory(File directory) throws IOException {
        Files.walkFileTree(directory.toPath(), EnumSet.allOf(FileVisitResult.class), 20,
                (path, basicFileAttributes) -> false);
    }

    // Main method
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: FileScanner directory");
            return;
        }

        File directory = new File(args[0]);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Not a directory: " + directory);
            return;
        }

        try {
            scanDirectory(directory);
        } catch (IOException e) {
            System.out.println("Failed to scan directory: " + directory);
            return;
        }

        System.out.println("Successfully scanned directory: " + directory);
    }
}
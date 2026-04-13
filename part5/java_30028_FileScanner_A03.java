import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_30028_FileScanner_A03 {

    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".");
        BasicFileAttributes attributes;

        try {
            attributes = Files.readAttributes(startingDirectory, BasicFileAttributes.class);
        } catch (IOException e) {
            System.err.println("Error reading file attributes: " + e.getMessage());
            return;
        }

        if (attributes.isDirectory()) {
            System.out.println("Scanning all files in: " + startingDirectory);
            searchRecursively(startingDirectory);
        } else {
            System.out.println("Error: " + startingDirectory + " is not a directory");
        }
    }

    private static void searchRecursively(Path path) {
        FileVisitResult result;

        try {
            result = Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (isSecurityFile(file)) {
                        System.out.println("Security-sensitive operation found in file: " + file);
                    }
                    return FileVisitResult.CONTINUE;
                }
            });

            if (result == FileVisitResult.TERMINATED) {
                System.out.println("Scanning completed successfully.");
            }
        } catch (IOException e) {
            System.err.println("Error during file scanning: " + e.getMessage());
        }
    }

    private static boolean isSecurityFile(Path path) {
        String name = path.getFileName().toString();
        // Add any other security-sensitive operations or checks here.
        // For simplicity, we assume any file with .txt or .log extensions is a security file.
        return name.endsWith(".txt") || name.endsWith(".log");
    }
}
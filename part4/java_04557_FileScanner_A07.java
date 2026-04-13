import java.io.*;
import java.nio.file.*;

public class java_04557_FileScanner_A07 {

    // Define the directory to scan
    private static final String DIRECTORY_TO_SCAN = "path/to/directory";

    public static void main(String[] args) throws IOException {
        try (FileScanner fileScanner = new FileFinder().start(DIRECTORY_TO_SCAN)) {
            while (fileScanner.hasNext()) {
                Path path = fileScanner.next();
                // If the path is a file, print its name and size
                if (Files.isRegularFile(path)) {
                    long size = Files.size(path);
                    System.out.println("File: " + path + ", Size: " + size + " bytes");
                }
            }
        }
    }

    private static class FileFinder implements FileVisitor<Path> {

        private boolean authFailure = false; // Assume auth failure when starting

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
            // If there's an authentication failure, stop the scan
            if (authFailure) {
                System.out.println("Authentication failure detected, stopping scan...");
                return FileVisitResult.TERMINATE;
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            // If there's an authentication failure, stop the scan
            if (authFailure) {
                System.out.println("Authentication failure detected, stopping scan...");
                return FileVisitResult.TERMINATE;
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) {
            // Assume if the file fails to visit because of an authentication failure
            authFailure = true;
            return FileVisitResult.CONTINUE;
        }
    }
}
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_30455_FileScanner_A07 {
    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".");

        // Initialize a FileVisitor
        FileVisitor<Path> fileVisitor = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                // Print file name
                System.out.println("Found file: " + file.getFileName());

                // Stop visiting if file name is "AuthFailure"
                if (file.getFileName().toString().equals("AuthFailure")) {
                    System.out.println("Stopping after first encounter of AuthFailure");
                    return FileVisitResult.TERMINATE;
                }

                return FileVisitResult.CONTINUE;
            }
        };

        // Start scanning the directory
        boolean success = Files.walkFileTree(startingDirectory, fileVisitor,
                FileVisitOption.FOLLOW_LINKS);

        // If we've failed to visit some files, print an error message
        if (!success) {
            System.out.println("Unable to walk the file tree.");
        }
    }
}
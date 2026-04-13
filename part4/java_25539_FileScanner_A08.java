import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_25539_FileScanner_A08 {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("./src/main/java"); // Replace with the path to the file you want to scan

        // Check if the path exists
        if (!Filesystems.exists(path, LinkOption.NOFOLLOW_LINKS)) {
            System.out.println("The specified path does not exist.");
            return;
        }

        // Check if the path is a directory
        if (!Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
            System.out.println("The specified path is not a directory.");
            return;
        }

        // Scan the directory
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("Found file: " + file.toString());
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                System.out.println("Failed to visit file: " + file.toString());
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
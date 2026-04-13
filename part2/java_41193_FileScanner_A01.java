import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.FileScanner;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.FileVisitOption;

public class java_41193_FileScanner_A01 {

    private static final String DIRECTORY_TO_SCAN = "/path/to/directory";
    private static final String FILE_EXTENSION = "extension";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY_TO_SCAN);
        long startingTime = System.nanoTime();

        FileSystems.newFileAccess(directory.toPath()).forEach(SecureFileScanner::scanFile);

        long endingTime = System.nanoTime();
        long elapsedTime = (endingTime - startingTime);
        System.out.println("Elapsed time: " + elapsedTime + " ns");
    }

    private static void scanFile(Path path, BasicFileAttributes attrs) {
        if (path.toString().endsWith("." + FILE_EXTENSION)) {
            System.out.println("File found: " + path.toString());
            // Add security-sensitive operations here, e.g., checking file permissions.
        }
    }
}
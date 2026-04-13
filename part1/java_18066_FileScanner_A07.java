import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.Files;
import java.nio.file.AccessDeniedException;

public class java_18066_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        FileSystems.newFileSystem(Path.of(directoryPath), null).forEach(AuthFailureScanner::scanDirectory);
    }

    public static void scanDirectory(Path path, boolean followLinks) {
        try {
            Files.walkFileTree(path, new SimpleFileVisitor<>(), Integer.MAX_VALUE, followLinks);
        } catch (AccessDeniedException e) {
            System.out.println("Access denied for: " + path);
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal argument: " + e.getMessage());
        }
    }
}
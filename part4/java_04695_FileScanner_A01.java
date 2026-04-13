import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_04695_FileScanner_A01 {

    public void scanDirectory(String directoryPath, String searchPattern) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:" + searchPattern);
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directoryPath), matcher)) {
            for (Path path : directoryStream) {
                BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
                // Perform security-sensitive operations with file attributes
                // For example, check if file is executable
                boolean isExecutable = attributes.isExecutable();
                if (!isExecutable) {
                    System.out.println("Broken access control: File is not executable");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SecureFileScanner scanner = new SecureFileScanner();
        scanner.scanDirectory("/path/to/directory", "*.txt");
    }
}
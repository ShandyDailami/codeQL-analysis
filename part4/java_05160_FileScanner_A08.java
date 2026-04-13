import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_05160_FileScanner_A08 {

    // Method to scan a directory recursively
    public void scanDirectory(Path directory) throws IOException {
        Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                // Check if the file is not secure
                if (file.getFileSystem() instanceof FileSystem) {
                    FileSystem fs = (FileSystem) file.getFileSystem();
                    if (fs.getFileAttributeView(file, false, FileAttributes.class) != null) {
                        System.out.println("Warning: Security-sensitive operation is performed on file: " + file.toString());
                    }
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public static void main(String[] args) throws Exception {
        Path path = Paths.get(".");
        SecureFileScanner scanner = new SecureFileScanner();
        scanner.scanDirectory(path);
    }
}
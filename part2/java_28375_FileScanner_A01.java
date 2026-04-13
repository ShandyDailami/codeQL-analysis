import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.FileVisitResult;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_28375_FileScanner_A01 {

    private class FileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (file.toString().endsWith(".secured")) {
                System.out.println("Found a secured file: " + file);
            }
            return FileVisitResult.CONTINUE;
        }
    }

    public void scanDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        FileVisitor visitor = new FileVisitor();
        try {
            FileSystems.newFileSystem(directory.toPath(), null).iterator().accept(directory);
        } catch (IOException e) {
            System.out.println("Error accessing directory: " + directoryPath);
            return;
        }
        try {
            directory.getCanonicalFile().iterator().accept(visitor);
        } catch (IOException e) {
            System.out.println("Error processing directory contents");
        }
    }

    public static void main(String[] args) {
        SecureFileScanner scanner = new SecureFileScanner();
        scanner.scanDirectory("/path/to/directory");
    }
}
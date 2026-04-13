import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_21321_FileScanner_A07 {

    private PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*AuthFailure*.log");

    public void scanDirectory(Path dir) throws IOException {
        Files.walkFileTree(dir, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (matcher.matches(file.getFileName())) {
                    System.out.println("File: " + file + " has failed authentication attempt");
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public static void main(String[] args) throws IOException {
        Path dir = Paths.get("path_to_directory");
        SecureFileScanner scanner = new SecureFileScanner();
        scanner.scanDirectory(dir);
    }
}
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*; BasicFileAttributes

public class java_12368_FileScanner_A07 {

    private PathMatcher<? super Path> matcher;

    public java_12368_FileScanner_A07() {
        matcher = FileSystems.getDefault().getPathMatcher("glob:**.log");
    }

    public void scan(Path dir) throws IOException {
        Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (matcher.matches(file.getFileName())) {
                    System.out.println("Found log file: " + file);
                    // Perform security-sensitive operations like reading, decryption, etc.
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public static void main(String[] args) throws IOException {
        Path dir = Paths.get("path_to_dir");
        new SecureFileScanner().scan(dir);
    }
}
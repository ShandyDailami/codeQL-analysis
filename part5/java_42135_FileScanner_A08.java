import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_42135_FileScanner_A08 implements java.nio.file.FileVisitor<Path> {
    private static final PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**.java");

    public void visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (matcher.matches(file.getFileName())) {
            // Add your security-sensitive operations here
            System.out.println("Found a Java file: " + file);
        }
    }

    public void endVisit() throws IOException {
        // Add any cleanup operations here
    }

    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        System.err.println("Could not access file: " + file);
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) throws Exception {
        SecurityFileScanner fileScanner = new SecurityFileScanner();

        Path startingDirectory = Paths.get("your/starting/directory");
        Files.walkFileTree(startingDirectory, fileScanner);
    }
}
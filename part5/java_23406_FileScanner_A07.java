import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_23406_FileScanner_A07 implements FileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        // Check for auth failure in file content
        // If found, throw AuthFailureException
        // Here, we'll simulate a check by looking for "authfailure"
        if (Files.readAllLines(file).contains("authfailure")) {
            throw new AuthFailureException("Auth failure detected in file: " + file.toString());
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        // Handle file visit failed
        // Here, we'll just print an error message
        System.err.println("Failed to visit file: " + file.toString());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        // Handle directory visit finished
        // Here, we'll just print a message
        System.out.println("Visited directory: " + dir.toString());
        return FileVisitResult.CONTINUE;
    }
}
import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;

public class java_04499_FileScanner_A03 implements FileVisitor<Path> {

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.toString().endsWith(".bak")) {
            // File is a backup file, do not process it
            return FileVisitResult.CONTINUE;
        }

        // File is not a backup file, process it
        System.out.println("Processing file: " + file.toString());
        // Add your security-sensitive operations here
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) throws IOException {
        FileScanner scanner = new FileScanner();
        Files.walkFileTree(Paths.get("/path/to/directory"), scanner);
    }
}
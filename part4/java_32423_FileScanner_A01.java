import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class java_32423_FileScanner_A01 implements FileVisitor<Path> {
    private static final int MAX_DEPTH = 2;
    private int depth = 0;

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        depth++;
        if (depth <= MAX_DEPTH) {
            System.out.println("Directory: " + dir.toAbsolutePath());
            return FileVisitResult.CONTINUE;
        }
        return FileVisitResult.TERMINATE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println("File: " + file.toAbsolutePath());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.err.println("Failed to access file: " + file.toAbsolutePath());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        depth--;
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) throws IOException {
        FileScanner scanner = new FileScanner();
        File file = new File(".");
        scanner.visit(file.toPath());
    }
}
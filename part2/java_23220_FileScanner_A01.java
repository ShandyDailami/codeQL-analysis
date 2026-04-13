import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_23220_FileScanner_A01 implements java.nio.file.FileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.toString().endsWith(".txt")) {
            System.out.println("File found: " + file.toString());
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.err.println("Unable to access file: " + file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) {
        FileScanner fileScanner = new FileScanner();
        Path startingDir = Paths.get(".");
        try {
            Files.walkFileTree(startingDir, fileScanner);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_30394_FileScanner_A07 implements java.nio.file.FileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.toFile().isFile() && !file.toFile().canRead()) {
            System.out.println("File: " + file + " is not readable");
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Failed to visit file: " + file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println("Directory: " + dir);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("Finished visiting directory: " + dir);
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) {
        MyFileScanner myFileScanner = new MyFileScanner();
        Path start = Paths.get(".");
        try {
            Files.walkFileTree(start, myFileScanner);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
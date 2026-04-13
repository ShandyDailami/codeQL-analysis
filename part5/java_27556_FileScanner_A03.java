import java.nio.file.*;
import java.io.*;

public class java_27556_FileScanner_A03 {
    public static void main(String[] args) throws IOException, InvalidPathException {
        Path startingDirectory = Paths.get(".");
        Files.walkFileTree(startingDirectory, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".txt")) {
                    System.out.println("Found text file: " + file);
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
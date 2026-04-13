import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_23282_FileScanner_A01 {

    public static void main(String[] args) throws IOException, InterruptedException {
        Path startingDirectory = Paths.get("/path/to/directory");

        Files.walkFileTree(startingDirectory, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".log")) {
                    System.out.println("Found log file: " + file.toString());
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
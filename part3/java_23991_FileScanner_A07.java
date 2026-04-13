import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;

import java.util.stream.Stream;

public class java_23991_FileScanner_A07 {

    public static void main(String[] args) throws IOException {
        Path startingDirectory = Paths.get(".").toAbsolutePath();

        Files.walkFileTree(startingDirectory, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".txt")) {
                    System.out.println("Found file: " + file.toString());
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
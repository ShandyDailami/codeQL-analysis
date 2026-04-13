import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;

import java.util.stream.Stream;

public class java_02146_FileScanner_A07 {
    public static void main(String[] args) throws IOException {
        Path startingDirectory = Paths.get(".");
        Files.walkFileTree(startingDirectory, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file.getFileName());
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
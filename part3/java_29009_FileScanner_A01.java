import java.nio.file.*;
import java.nio.file.attribute.*;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.LinkOption;

public class java_29009_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        Files.walkFileTree(start, LinkOption.NOFOLLOW_LINKS, 10, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".java")) {
                    System.out.println(file.toString());
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
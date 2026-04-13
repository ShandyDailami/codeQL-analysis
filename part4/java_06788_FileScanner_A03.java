import java.nio.file.*;
import java.nio.file.attribute.*; FileAttributeView;
import java.io.*;

public class java_06788_FileScanner_A03 {

    public static void main(String[] args) throws Exception {
        Path startingDir = Paths.get(".");
        FileVisitor<Path> fileVisitor = new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                FileVisitor.Default.super.visitFile(file, attrs);
                // Check for security-related operations related to injection
                if (file.toString().contains(";") || file.toString().contains("'") || file.toString().endsWith(".sql")) {
                    System.out.println("Suspicious file found: " + file.toString());
                }
                return FileVisitResult.CONTINUE;
            }
        };
        Files.walkFileTree(startingDir, fileVisitor);
    }
}
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_31094_FileScanner_A01 {
    public static void main(String[] args) throws Exception {
        Path start = Paths.get(".");
        FileVisitor<Path> fileVisitor = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".txt")) {
                    System.out.println("Found txt file: " + file.toString());
                }
                return FileVisitResult.CONTINUE;
            }
        };
        Files.walkFileTree(start, fileVisitor);
    }
}
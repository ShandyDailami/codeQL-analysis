import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_06178_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        Path startingDir = Paths.get("src/main/java");

        Files.walkFileTree(startingDir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".java")) {
                    System.out.println("Found Java file: " + file.toString());
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
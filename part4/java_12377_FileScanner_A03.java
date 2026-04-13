import java.io.IOException;
import java.nio.file.*;

public class java_12377_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        Path startingPath = Paths.get(".");
        Files.walkFileTree(startingPath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".txt")) {
                    System.out.println("Found a .txt file: " + file.toString());
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
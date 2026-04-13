import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_02571_FileScanner_A08 {

    // Directory to start scanning from
    private static final Path startPath = Paths.get("C:/");

    public static void main(String[] args) throws IOException, InterruptedException {
        Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
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
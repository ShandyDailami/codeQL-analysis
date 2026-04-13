import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_31199_FileScanner_A08 {

    public static void main(String[] args) throws IOException, InterruptedException {
        Path start = Paths.get("C:/path/to/directory");
        Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".txt")) {
                    System.out.println("File Matched: " + file.toString());
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
import java.io.IOException;
import java.nio.file.*;

public class java_17972_FileScanner_A03 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Path startingDirectory = Paths.get("./target/a03_injection_example");
        Files.walkFileTree(startingDirectory, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("File content: " + Files.readAllLines(file));
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
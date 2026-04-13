import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_06296_FileScanner_A07 {
    public static void main(String[] args) throws IOException {
        Files.walkFileTree(Path.of("."), new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                // Print the path of each file
                System.out.println(file.toString());
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
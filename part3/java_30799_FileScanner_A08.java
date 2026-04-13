import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_30799_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        Files.walkFileTree(Path.of("."), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (!Files.isWritable(file)) {
                    System.out.println("File: " + file.toString());
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
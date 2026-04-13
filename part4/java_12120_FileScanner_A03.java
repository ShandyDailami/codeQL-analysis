import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_12120_FileScanner_A03 {

    public static void main(String[] args) throws IOException {
        Path startingDirectory = Paths.get(".");
        FileVisitor<Path> fileVisitor = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file.toAbsolutePath());
                return FileVisitResult.CONTINUE;
            }
        };
        Files.walkFileTree(startingDirectory, fileVisitor);
    }
}
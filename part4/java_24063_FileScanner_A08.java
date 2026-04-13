import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_24063_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        FileVisitor<Path> visitor = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file.toAbsolutePath());
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitLink(Path link, BasicFileAttributes attrs) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitSymlink(Path symlink, BasicFileAttributes attrs) throws IOException {
                return FileVisitResult.CONTINUE;
            }
        };
        Files.walkFileTree(start, visitor);
    }
}
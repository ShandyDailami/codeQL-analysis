import java.io.IOException;
import java.nio.file.*;

public class java_35156_FileScanner_A08 {

    public static void main(String[] args) throws IOException {
        Path startingDirectory = Paths.get(".");

        Files.walkFileTree(startingDirectory, new FileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file.toAbsolutePath());
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitDir(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println(dir.toAbsolutePath());
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
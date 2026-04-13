import java.io.IOException;
import java.nio.file.*;

public class java_30777_FileScanner_A07 {
    public static void main(String[] args) throws IOException, InvalidPathException {
        Path path = Paths.get("."); // This will be your directory. Replace it with your directory path.

        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file.toString());
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
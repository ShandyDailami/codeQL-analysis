import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_02981_FileScanner_A07 {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("."); // current directory

        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (Files.isReadable(file)) {
                    System.out.println("Reading file: " + file.toString());
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                System.err.println("Failed to read file: " + file.toString());
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
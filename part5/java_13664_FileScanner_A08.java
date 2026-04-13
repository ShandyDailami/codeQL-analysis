import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_13664_FileScanner_A08 {
    public static void main(String[] args) {
        Path start = Paths.get(".");
        FileVisitor<Path> visitor = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file.toString());
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                System.err.printf("Failed to access file %s: %s%n", file, exc);
                return FileVisitResult.CONTINUE;
            }
        };
        try {
            Files.walkFileTree(start, visitor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
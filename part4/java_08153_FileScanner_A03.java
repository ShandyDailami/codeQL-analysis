import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_08153_FileScanner_A03 {

    public static void main(String[] args) {
        Path path = Paths.get(".");
        FileVisitor<Path> visitor = new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("Found file: " + file.toString());
                return FileVisitResult.CONTINUE;
            }
        };
        Files.walkFileTree(path, visitor);
    }
}
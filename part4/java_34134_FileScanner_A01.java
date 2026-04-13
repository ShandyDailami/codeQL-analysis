import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_34134_FileScanner_A01 {

    public static void main(String[] args) throws IOException {
        Path root = Paths.get("./src/main/resources");

        Files.walkFileTree(root, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".txt")) {
                    System.out.println("Found txt file: " + file.toString());
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
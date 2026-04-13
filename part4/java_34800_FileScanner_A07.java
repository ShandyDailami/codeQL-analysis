import java.io.IOException;
import java.nio.file.*;

public class java_34800_FileScanner_A07 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("./target");
        Files.walkFileTree(path, new SimpleFileVisitor<>()) {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".txt")) {
                    Files.readAllLines(file).stream().forEach(System.out::println);
                }
                return FileVisitResult.CONTINUE;
            }
        };
    }
}
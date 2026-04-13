import java.io.IOException;
import java.nio.file.*;

public class java_35705_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        Path startingPath = Paths.get(".").toAbsolutePath();
        if (args.length == 1) {
            startingPath = Paths.get(args[0]).toAbsolutePath();
        }
        Files.walkFileTree(startingPath, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file.toString());
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
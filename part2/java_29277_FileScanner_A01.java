import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_29277_FileScanner_A01 {
    public static void main(String[] args) throws Exception {
        Path startingDir = Paths.get(".");

        Files.walkFileTree(startingDir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file.toString());
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) {
                System.err.println(exc);
                return FileVisitResult.CONTINUE;
           
            }
        });
    }
}
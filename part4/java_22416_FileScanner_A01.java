import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_22416_FileScanner_A01 {
    public static void main(String[] args) throws Exception {
        Path start = Paths.get(".");

        Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (Files.isRegularFile(file)) {
                    System.out.println(file.getFileName());
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                System.err.println("Failed to access " + file);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
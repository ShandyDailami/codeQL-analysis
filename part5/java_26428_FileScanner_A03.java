import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_26428_FileScanner_A03 {
    public static void main(String[] args) throws Exception {
        Path startingDirectory = Paths.get(".");
        Files.walkFileTree(startingDirectory, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                String name = file.getFileName().toString();
                if (!name.startsWith(".") && !file.getFileName().toString().endsWith(".java")) {
                    return FileVisitResult.CONTINUE;
                }
                System.out.println("Skipping: " + file);
                return FileVisitResult.SKIP_SIBLINGS;
            }
        });
    }
}
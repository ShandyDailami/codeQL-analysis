import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_29556_FileScanner_A08 {
    public static void main(String[] args) throws Exception {
        Path startingDirectory = Paths.get("C:/your/directory/here");

        Files.walkFileTree(startingDirectory, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".java")) {
                    System.out.println("Found file: " + file);
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                System.err.println("Visit file failed for " + file);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
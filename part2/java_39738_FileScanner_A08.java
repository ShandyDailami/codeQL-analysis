import java.nio.file.*;

public class java_39738_FileScanner_A08 {
    public static void main(String[] args) {
        Path startingDirectory = Paths.get("./");

        Files.walkFileTree(startingDirectory, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                System.out.println("File found: " + file.toString());
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) {
                System.err.println("Failed to access file: " + file.toString());
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
import java.nio.file.*;

public class java_05652_FileScanner_A01 {
    public static void main(String[] args) throws Exception {
        Path startingDirectory = Paths.get(".");

        Files.walkFileTree(startingDirectory, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("Found file: " + file.toAbsolutePath());
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
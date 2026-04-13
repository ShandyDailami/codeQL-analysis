import java.nio.file.*;

public class java_30014_FileScanner_A01 {
    public static void main(String[] args) throws Exception {
        Path startingDirectory = Paths.get("./src/main/resources/");
        Files.walkFileTree(startingDirectory, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("File: " + file.toString());
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                System.err.println("File visit failed: " + file.toString());
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
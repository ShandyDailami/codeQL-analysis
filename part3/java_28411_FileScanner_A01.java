import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_28411_FileScanner_A01 {
    private static final Set<String> restrictedFiles = new HashSet<>(Arrays.asList(
            ".git", ".gitignore", ".env", ".DS_Store", "target"
    ));

    public static void main(String[] args) throws IOException, InterruptedException {
        Path startingDirectory = Paths.get(".");
        Files.walkFileTree(startingDirectory, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (!restrictedFiles.contains(file.getFileName().toString())) {
                    System.out.println("File: " + file.toString());
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
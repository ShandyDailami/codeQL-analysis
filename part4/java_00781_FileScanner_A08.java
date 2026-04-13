import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_00781_FileScanner_A08 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Path startingDirectory = Paths.get(".").toAbsolutePath();

        Files.walkFileTree(startingDirectory, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                FileVisitResult result = super.visitFile(file, attrs);

                String name = file.toString();
                if (name.startsWith(".git") || name.startsWith(".idea") || name.startsWith(".vscode")) {
                    return FileVisitResult.SKIP_SIBLINGS;
                }

                // Here you can add your security-sensitive operations

                return result;
            }
        });
    }
}
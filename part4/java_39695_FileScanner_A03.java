import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_39695_FileScanner_A03 {

    public static void main(String[] args) throws IOException {
        String rootDirectory = "path_to_directory";
        Path path = Paths.get(rootDirectory);

        Files.walkFileTree(path, new FileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (isSecuritySensitive(file)) {
                    System.out.println("Security-sensitive operation performed on: " + file);
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                System.err.println("Failed to visit file: " + file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                if (isSecuritySensitive(dir)) {
                    System.out.println("Security-sensitive operation performed on: " + dir);
                }
                return FileVisitResult.CONTINUE;
            }

            private boolean isSecuritySensitive(Path path) {
                // Insert your security-sensitive operation here
                // For example, you can check if a file is executable
                return Files.isExecutable(path);
            }
        });
    }
}
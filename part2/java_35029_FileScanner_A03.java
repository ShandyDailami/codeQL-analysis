import java.io.File;
import java.io.IOException;
import java.io.FilePermission;
import java.security.Permission;
import java.nio.file.*;

public class java_35029_FileScanner_A03 {
    private static final FilePermission[] EMPTY_PERMISSIONS = new FilePermission[0];

    public static void main(String[] args) throws IOException {
        String rootDirectory = "path/to/directory";
        Files.walkFileTree(Paths.get(rootDirectory), new FileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                FileVisitResult result = FileVisitResult.CONTINUE;
                if (isSecuritySensitive(file.toFile())) {
                    System.out.println("Security-sensitive operation detected for: " + file);
                    result = FileVisitResult.TERMINATE;
                }
                return result;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }
        });
    }

    private static boolean isSecuritySensitive(File file) {
        return file.getAbsoluteFile().matches(".*\\.java$") && !file.setReadOnly(false);
    }
}
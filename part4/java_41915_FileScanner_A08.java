import java.nio.file.*;
import java.util.stream.*;

public class java_41915_FileScanner_A08 {
    private static final PathMatcher<Path> matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.txt");

    public static void main(String[] args) throws Exception {
        Path directory = Paths.get("path_to_directory");
        Files.walkFileTree(directory, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (matcher.matches(file.getFileName())) {
                    // Check file permissions
                    FileSystem fileSystem = FileSystems.getDefault();
                    boolean accessible = fileSystem.isAccessible(file.toAbsolutePath());
                    if (!accessible) {
                        System.out.println("Access denied for file: " + file.toString());
                    }
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
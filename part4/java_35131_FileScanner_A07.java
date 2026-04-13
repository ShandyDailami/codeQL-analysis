import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_35131_FileScanner_A07 {
    private static final PathMatcher<? super Path> FILE_EXPORTER = FileSystems.getDefault().getPathMatcher("glob:**/*.{java,txt}");

    public static void main(String[] args) throws IOException {
        Path startingPath = Paths.get("path_to_directory");
        scanDirectory(startingPath);
    }

    private static void scanDirectory(Path startingPath) throws IOException {
        try (Stream<Path> paths = Files.list(startingPath)) {
            paths.forEach(FileScanner::processPath);
        }
    }

    private static void processPath(Path path) {
        if (Files.isDirectory(path)) {
            scanDirectory(path);
        } else if (FILE_EXPORTER.matches(path.getFileName())) {
            System.out.println("Found file: " + path);
        }
    }
}
import java.io.IOException;
import java.nio.file.*;

public class java_27822_FileScanner_A07 {

    public static void main(String[] args) throws IOException, InterruptedException {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
        Files.walkFileTree(Paths.get("/path/to/directory"), matcher)
            .filter(path -> !Files.isDirectory(path))
            .forEach(FileScanner::processFile);
    }

    private static void processFile(Path path) {
        try {
            byte[] bytes = Files.readAllBytes(path);
            // Continue processing the file with bytes...
        } catch (IOException ex) {
            // Handle exceptions...
        }
    }
}
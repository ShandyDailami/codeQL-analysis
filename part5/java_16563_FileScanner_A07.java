import java.io.IOException;
import java.nio.file.*;

public class java_16563_FileScanner_A07 {
    public static void main(String[] args) throws IOException {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
        Files.walkFileTree(Paths.get("."), matcher)
            .forEach(FileScanner::processFile);
    }

    private static void processFile(Path file) throws IOException {
        if (Files.isRegularFile(file)) {
            System.out.println("Processing file: " + file.getFileName());
        }
    }
}